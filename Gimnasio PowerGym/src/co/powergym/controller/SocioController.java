package co.powergym.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import co.powergym.dao.SocioDao;
import co.powergym.model.Socio;
import co.powergym.view.BusquedaSocio;
import co.powergym.view.RegistroSocio;

public class SocioController implements ActionListener {

	SocioDao socioDao;
	
	RegistroSocio viewRegistroSocio;
	BusquedaSocio viewBusquedaSocio;

	public SocioController(SocioDao socioDao, RegistroSocio viewRegistroSocio, BusquedaSocio viewBusquedaSocio) {
		this.socioDao = socioDao;
		this.viewRegistroSocio = viewRegistroSocio;
		this.viewRegistroSocio.btnRegistrar.addActionListener(this);
		this.viewRegistroSocio.setVisible(true);
		this.viewBusquedaSocio = viewBusquedaSocio;
		this.viewBusquedaSocio.btnBuscar.addActionListener(this);
		this.viewBusquedaSocio.setVisible(true);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == viewRegistroSocio.btnRegistrar) {
			String numeroId = viewRegistroSocio.getTextField_identidad().getText();
			Socio socio = socioDao.buscarSocio(numeroId);
			if (socio == null) {
				String primerNombre = viewRegistroSocio.getTextField_primerNombre().getText();
				String segundoNombre = viewRegistroSocio.getTextField_segundoNombre().getText();
				String primerApellido = viewRegistroSocio.getTextField_primerApellido().getText();
				String segundoApellido = viewRegistroSocio.getTextField_segundoApellido().getText();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				// Date fechaNacimiento =
				// dateFormat.format(viewRegistroSocio.getDateChooser_fechaNacimiento().getDate());
				Date fechaNacimiento = new Date(viewRegistroSocio.getDateChooser_fechaNacimiento().getDate().getTime());
				String telefono = viewRegistroSocio.getTextField_telefono().getText();
				String correo = viewRegistroSocio.getTextField_correoElectronico().getText();
				int genero = viewRegistroSocio.getComboBox_genero().getSelectedIndex();

				boolean respuesta = socioDao.registrarSocio(numeroId, fechaNacimiento, primerNombre, segundoNombre,
						primerApellido, segundoApellido, correo, telefono, genero);
				if (respuesta) {
					JOptionPane.showMessageDialog(null, "Registro exitoso");
				} else {
					JOptionPane.showMessageDialog(null, "Ocurrio un error registrando un nuevo socio.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "El socio ya se encuentra registrado");
			}

		}
		else if (e.getSource()== viewBusquedaSocio.btnBuscar) {
			String numeroId = viewBusquedaSocio.getTextField_identidad().getText();
			Socio socio = socioDao.buscarSocio(numeroId);
			if (socio != null) {
				
				String primerNombre = socio.getPrimerNombre();
				viewBusquedaSocio.getTextField_primerNombre().setText(primerNombre);
				String segundoNombre = socio.getSegundoNombre();
				viewBusquedaSocio.getTextField_segundoNombre().setText(segundoNombre);
				String primerApellido = socio.getPrimerApellido();
				viewBusquedaSocio.getTextField_primerApellido().setText(primerApellido);
				String segundoApellido = socio.getSegundoApellido();
				viewBusquedaSocio.getTextField_segundoApellido().setText(segundoApellido);
				String fechaNacimiento = String.valueOf(socio.getFechaNacimiento());
				viewBusquedaSocio.getTextField_fechaNacimiento().setText(fechaNacimiento);
				String telefono = socio.getTelefono();
				viewBusquedaSocio.getTextField_telefono().setText(telefono);
				String correo = socio.getCorreo();
				viewBusquedaSocio.getTextField_correoElectronico().setText(correo);
				int genero = socio.getGenero();
				viewBusquedaSocio.getTextField_genero().setText(String.valueOf(genero));
			
			} else {
				JOptionPane.showMessageDialog(null, "No se encontró un socio con ese número de identificación, "
						+ "por favor verique e intente de nuevo");
			}

			
		}
	}

}

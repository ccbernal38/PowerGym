package co.powergym.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import co.powergym.dao.SocioDao;
import co.powergym.model.Socio;
import co.powergym.view.RegistroSocio;

public class SocioController implements ActionListener {

	SocioDao socioDao;
	RegistroSocio viewRegistroSocio;

	public SocioController(SocioDao socioDao, RegistroSocio viewRegistroSocio) {
		this.socioDao = socioDao;
		this.viewRegistroSocio = viewRegistroSocio;
		this.viewRegistroSocio.btnRegistrar.addActionListener(this);
		this.viewRegistroSocio.setVisible(true);		
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
	}

}

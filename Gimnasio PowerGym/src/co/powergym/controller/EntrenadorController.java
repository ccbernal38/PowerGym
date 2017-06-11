package co.powergym.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JOptionPane;

import com.github.sarxos.webcam.Webcam;

import co.powergym.dao.EntrenadorDao;
import co.powergym.dao.SocioDao;
import co.powergym.model.Entrenador;
import co.powergym.model.Socio;
import co.powergym.view.BusquedaEntrenador;
import co.powergym.view.BusquedaSocio;
import co.powergym.view.RegistroEntrenador;
import co.powergym.view.RegistroView;

public class EntrenadorController implements ActionListener{
	
	EntrenadorDao entrenadorDao;	
	RegistroEntrenador viewRegistroEntrenador;
	BusquedaEntrenador viewBusquedantrenador;
	
	public EntrenadorController(EntrenadorDao entrenadorDao, RegistroEntrenador viewRegistroEntrenador, BusquedaEntrenador viewBusquedaentrenador) {
		this.entrenadorDao = entrenadorDao;
		this.viewRegistroEntrenador = viewRegistroEntrenador;
		this.viewRegistroEntrenador.getBtnRegistrar().addActionListener(this);
		this.viewRegistroEntrenador.getBtnCancelar().addActionListener(this);
		this.viewRegistroEntrenador.setVisible(true);
		this.viewBusquedantrenador = viewBusquedaentrenador;
		this.viewBusquedantrenador.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == viewRegistroEntrenador.getBtnRegistrar()) {
			String numeroId = viewRegistroEntrenador.getTxtNumeroid().getText();
			Entrenador entrenador = entrenadorDao.buscarEntrenador(numeroId);
			if (entrenador == null) {
				String primerNombre = viewRegistroEntrenador.getTxtNombre().getText();
				String segundoNombre = viewRegistroEntrenador.getTxtSegundonombre().getText();
				String primerApellido = viewRegistroEntrenador.getTxtPrimerapellido().getText();
				String segundoApellido = viewRegistroEntrenador.getTxtSegundoapellido().getText();
				Date fechaNacimiento = new Date(viewRegistroEntrenador.getDateChooser_fechaNacimiento().getDate().getTime());
				String telefono = viewRegistroEntrenador.getTxtTelefono().getText();
				String correo = viewRegistroEntrenador.getTxtCorreoelectronico().getText();
				int genero = viewRegistroEntrenador.getComboBox_genero().getSelectedIndex();

				boolean respuesta = entrenadorDao.registrarEntrenador(numeroId, fechaNacimiento, primerNombre, segundoNombre, 
						primerApellido, segundoApellido, correo, telefono, genero);
				if (respuesta) {
					JOptionPane.showMessageDialog(null, "Registro exitoso");
				} else {
					JOptionPane.showMessageDialog(null, "Ocurrio un error registrando un nuevo entrenador.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "El entrenador ya se encuentra registrado");
			}

		}
		
	}

	
}

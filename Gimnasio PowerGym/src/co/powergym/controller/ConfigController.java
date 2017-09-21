package co.powergym.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import co.powergym.utils.Constantes;
import co.powergym.utils.Preferencias;
import co.powergym.view.config.ConfigPuertoView;

public class ConfigController implements ActionListener {

	private ConfigPuertoView configPuertoView;

	/**
	 * @param configPuertoView
	 */
	public ConfigController(ConfigPuertoView configPuertoView) {
		this.configPuertoView = configPuertoView;
		this.configPuertoView.getTextFieldPuerto().setText(Preferencias.obtenerPreferencia(Constantes.PUERTO));
		this.configPuertoView.getBtnCambiar().addActionListener(this);
		this.configPuertoView.getBtnCancelar().addActionListener(this);
		this.configPuertoView.setLocationRelativeTo(null);
		this.configPuertoView.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (configPuertoView != null) {
			if (configPuertoView.getBtnCambiar() == e.getSource()) {
				String newPort = configPuertoView.getTextFieldPuerto().getText();
				if (!newPort.equals("")) {
					Preferencias.guardarPreferencia(Constantes.PUERTO, newPort);
					this.configPuertoView.setVisible(false);
					this.configPuertoView.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "No debe dejar el campo vacio.");
				}
			}

		}
	}

}

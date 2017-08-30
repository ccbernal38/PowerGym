package co.powergym.controller;

import co.powergym.utils.Constantes;
import co.powergym.utils.Preferencias;
import co.powergym.view.config.ConfigPuertoView;

public class ConfigController {
	
	private ConfigPuertoView configPuertoView;

	/**
	 * @param configPuertoView
	 */
	public ConfigController(ConfigPuertoView configPuertoView) {
		this.configPuertoView = configPuertoView;
		this.configPuertoView.getTextFieldPuerto().setText(Preferencias.obtenerPreferencia(Constantes.PUERTO));
		this.configPuertoView.setLocationRelativeTo(null);
		this.configPuertoView.setVisible(true);
	}
	
	
	
	
}

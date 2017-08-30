/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.powergym.mvc;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import co.powergym.controller.InicioController;
import co.powergym.controller.LoginController;
import co.powergym.utils.Preferencias;
import co.powergym.view.Principal;

/**
 *
 * @author
 */
public class CrudMvc {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		CrudMvc crudMvc = new CrudMvc();
		crudMvc.cargarLogin();
		
	}

	public void cargarLogin() {
		Preferencias.initPreferencia();
		LoginController controller = new LoginController();

	}

}

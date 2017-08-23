/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.powergym.mvc;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import co.powergym.controller.InicioController;
import co.powergym.view.Principal;

/**
 *
 * @author
 */
public class CrudMvc {
	private static Preferences prefs;

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		CrudMvc crudMvc = new CrudMvc();
		crudMvc.cargarPreferencias();

	}

	public void cargarPreferencias() {
		prefs = Preferences.userRoot().node(this.getClass().getName());

		System.out.println(prefs.getInt("Clave", -1));

		prefs.putInt("Clave",3);
		Principal viewPrincipal = new Principal();
		InicioController controller = new InicioController(viewPrincipal);
		
	}

}

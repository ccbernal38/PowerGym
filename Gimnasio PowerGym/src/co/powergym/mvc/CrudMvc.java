/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.powergym.mvc;

import co.powergym.controller.InicioController;
import co.powergym.controller.SocioController;
import co.powergym.dao.SocioDao;
import co.powergym.view.Principal;
import co.powergym.view.RegistroSocio;

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
		Principal viewPrincipal = new Principal();
		InicioController controller = new InicioController(viewPrincipal);
		
	}

}

/**
 * 
 */
package co.powergym.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.powergym.view.Login;

/**
 * @author nia
 *
 */
public class LoginController implements ActionListener{
	
	Login viewLogin = new Login();
	
	public LoginController(Login viewLogin)
	{
		this.viewLogin = viewLogin;
		this.viewLogin.jButtonInicioSesion.addActionListener(this);
		this.viewLogin.setVisible(true);
		this.viewLogin.setLocationRelativeTo(null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

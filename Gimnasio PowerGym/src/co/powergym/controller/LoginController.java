/**
 * 
 */
package co.powergym.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.sun.nio.file.SensitivityWatchEventModifier;

import co.powergym.dao.LoginDao;
import co.powergym.model.Usuario;
import co.powergym.utils.Preferencias;
import co.powergym.view.Login;
import co.powergym.view.Principal;

/**
 * @author nia
 *
 */
public class LoginController implements ActionListener {
	Login viewLogin;
	LoginDao loginDao;

	public LoginController() {
		loginDao = new LoginDao();
		viewLogin = new Login();
		this.viewLogin.getBtnIniciar().addActionListener(this);
		this.viewLogin.getBtnSalir().addActionListener(this);
		this.viewLogin.setVisible(true);
		this.viewLogin.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (viewLogin != null) {
			if (viewLogin.getBtnIniciar() == e.getSource()) {
				String username = viewLogin.getTextFieldUsername().getText();
				String password = viewLogin.getPasswordField().getText();
				Usuario usuario = loginDao.inicioSesion(username, password);
				if (usuario != null) {
					viewLogin.setVisible(false);
					Preferencias.InicioSesionPrefs(usuario);
					InicioController controller = new InicioController(new Principal());
					System.out.println(Preferencias.obtenerPreferencia("user_username"));

				} else {
					viewLogin.getTextFieldUsername().setText("");
					viewLogin.getPasswordField().setText("");
					JOptionPane.showMessageDialog(viewLogin, "El nombre de usuario y/o contraseña son incorrectos.");
				}
			}  else if (viewLogin.getBtnSalir() == e.getSource()) {
				Preferencias.resetPreferencias();
				JOptionPane pane = new JOptionPane("Espere, Saliendo......", JOptionPane.INFORMATION_MESSAGE,
						JOptionPane.DEFAULT_OPTION, null, new Object[] {}, null);
				JDialog dialog = pane.createDialog(null, "Entrada");
				new Thread(new Runnable() {
					public void run() {
						try {
							Thread.sleep(1000);
							dialog.dispose();
							System.exit(0);
						} catch (Throwable th) {
							System.out.println("setValidComboIndex(): error :\n" + th.getMessage());
						}
					}
				}).start();

				dialog.setVisible(true);

			}

		}
	}

}

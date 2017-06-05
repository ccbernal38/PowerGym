package co.powergym.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.powergym.dao.SocioDao;
import co.powergym.view.Principal;
import co.powergym.view.RegistroSocio;

public class InicioController implements ActionListener {

	Principal viewPrincipal = new Principal();

	public InicioController(Principal viewPrincipal) {

		this.viewPrincipal = viewPrincipal;
		this.viewPrincipal.btnRegistrarSocio.addActionListener(this);
		this.viewPrincipal.setVisible(true);
		this.viewPrincipal.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (viewPrincipal.btnRegistrarSocio == e.getSource()) {
			SocioDao dao = new SocioDao();
			RegistroSocio viewRegistroSocio = new RegistroSocio();
			viewPrincipal.jDesktopPane1.add(viewRegistroSocio);
			SocioController socioController = new SocioController(dao, viewRegistroSocio);

		}
		
		if(viewPrincipal.crea)
	}

}

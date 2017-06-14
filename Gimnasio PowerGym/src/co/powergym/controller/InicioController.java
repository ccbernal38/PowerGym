package co.powergym.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sun.java_cup.internal.runtime.virtual_parse_stack;

import co.powergym.dao.EntrenadorDao;
import co.powergym.dao.SocioDao;
import co.powergym.view.BusquedaEntrenador;
import co.powergym.view.CrearMembresia;
import co.powergym.view.Principal;
import co.powergym.view.RegistroEntrenador;
import co.powergym.view.socio.SocioBusquedaView;
import co.powergym.view.socio.SocioCumpleaniosListadoView;
import co.powergym.view.socio.SocioListadoView;
import co.powergym.view.socio.SocioRegistroView;

public class InicioController implements ActionListener {

	Principal viewPrincipal = new Principal();

	public InicioController(Principal viewPrincipal) {

		this.viewPrincipal = viewPrincipal;
		this.viewPrincipal.btnRegistrarSocio.addActionListener(this);
		this.viewPrincipal.jMenuItem3buscarSocio.addActionListener(this);
		this.viewPrincipal.btnMenuMembresia.addActionListener(this);
		this.viewPrincipal.getMntmListadoDeSocios().addActionListener(this);
		this.viewPrincipal.getJMenuItemCumpleanios().addActionListener(this);
		this.viewPrincipal.getJMenuItemRegistrarEntrenador().addActionListener(this);
		this.viewPrincipal.getJMenuItemBuscarEntrenador().addActionListener(this);
		this.viewPrincipal.setVisible(true);
		this.viewPrincipal.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (viewPrincipal.btnRegistrarSocio == e.getSource()) {
			SocioDao dao = new SocioDao();
			SocioRegistroView viewRegistroSocio = new SocioRegistroView();
			SocioController socioController = new SocioController(dao, viewRegistroSocio, null, null, null);
		} else if (viewPrincipal.jMenuItem3buscarSocio == e.getSource()) {
			SocioDao dao = new SocioDao();
			SocioBusquedaView viewBusquedaSocio = new SocioBusquedaView();
			SocioController socioController = new SocioController(dao, null, viewBusquedaSocio, null, null);
		} else if (viewPrincipal.btnMenuMembresia == e.getSource()) {
			CrearMembresia crearMembresia = new CrearMembresia();
			MembresiaController Mcontroller = new MembresiaController(crearMembresia);
		} else if (viewPrincipal.getMntmListadoDeSocios() == e.getSource()) {
			SocioListadoView socioListadoView = new SocioListadoView();
			SocioController socioController = new SocioController(new SocioDao(), null, null, socioListadoView, null);
		} else if (viewPrincipal.getJMenuItemCumpleanios() == e.getSource()) {
			SocioController socioController = new SocioController(new SocioDao(), null, null, null,
					new SocioCumpleaniosListadoView());
		}
		else if (viewPrincipal.getJMenuItemRegistrarEntrenador() == e.getSource()){
			EntrenadorDao dao = new EntrenadorDao();
			RegistroEntrenador viewRegistroEntrenador = new RegistroEntrenador();
			EntrenadorController entrenadorController = new EntrenadorController(dao, viewRegistroEntrenador, null);
		}
		else if (viewPrincipal.getJMenuItemBuscarEntrenador() == e.getSource()){
			EntrenadorDao dao = new EntrenadorDao();
			BusquedaEntrenador viewBusquedaEntrenador = new BusquedaEntrenador();
			EntrenadorController entrenadorController = new EntrenadorController(dao, null, viewBusquedaEntrenador);
			
		}
	}
}

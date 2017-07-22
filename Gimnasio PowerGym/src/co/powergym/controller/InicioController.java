package co.powergym.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.powergym.dao.EntrenadorDao;
import co.powergym.dao.MembresiaDao;
import co.powergym.dao.SocioDao;
import co.powergym.view.Principal;
import co.powergym.view.entrenador.BusquedaEntrenador;
import co.powergym.view.entrenador.ListaEntrenador;
import co.powergym.view.entrenador.RegistroEntrenador;
import co.powergym.view.membresia.CrearMembresia;
import co.powergym.view.membresia.MembresiaListadoView;
import co.powergym.view.socio.SocioBusquedaView;
import co.powergym.view.socio.SocioCumpleaniosListadoView;
import co.powergym.view.socio.SocioListadoView;
import co.powergym.view.socio.SocioRegistrarEntradaView;
import co.powergym.view.socio.SocioRegistroView;

public class InicioController implements ActionListener {

	Principal viewPrincipal = new Principal();

	public InicioController(Principal viewPrincipal) {

		this.viewPrincipal = viewPrincipal;
		this.viewPrincipal.getJMenuItemRegistrarSocio().addActionListener(this);
		this.viewPrincipal.btnRegistrarSocio.addActionListener(this);
		this.viewPrincipal.jMenuItem3buscarSocio.addActionListener(this);
		this.viewPrincipal.btnMenuMembresia.addActionListener(this);
		this.viewPrincipal.getMntmListadoDeSocios().addActionListener(this);
		this.viewPrincipal.getJMenuItemCumpleanios().addActionListener(this);
		this.viewPrincipal.getJMenuItemRegistrarEntrenador().addActionListener(this);
		this.viewPrincipal.getJMenuItemBuscarEntrenador().addActionListener(this);
		this.viewPrincipal.getJMenuItemListaEntrenador().addActionListener(this);
		this.viewPrincipal.getJMenuItemListaMembresias().addActionListener(this);
		this.viewPrincipal.getJButtonRegistrarEntrada().addActionListener(this);
		this.viewPrincipal.setVisible(true);
		this.viewPrincipal.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (viewPrincipal.getJButtonRegistrarEntrada() == e.getSource()) {
			SocioController socioController = new SocioController(new SocioDao(), null, null, null, null, new SocioRegistrarEntradaView(), null);
		} else if (viewPrincipal.btnRegistrarSocio == e.getSource()
				|| viewPrincipal.getJMenuItemRegistrarSocio() == e.getSource()) {
			SocioDao dao = new SocioDao();
			SocioRegistroView viewRegistroSocio = new SocioRegistroView();
			SocioController socioController = new SocioController(dao, viewRegistroSocio, null, null, null, null, null);
		} else if (viewPrincipal.jMenuItem3buscarSocio == e.getSource()) {
			SocioDao dao = new SocioDao();
			SocioBusquedaView viewBusquedaSocio = new SocioBusquedaView();
			SocioController socioController = new SocioController(dao, null, viewBusquedaSocio, null, null, null, null);
		} else if (viewPrincipal.btnMenuMembresia == e.getSource()) {
			MembresiaDao membresiaDao = new MembresiaDao();
			CrearMembresia crearMembresia = new CrearMembresia();
			MembresiaController Mcontroller = new MembresiaController(membresiaDao, crearMembresia, null);
		} else if (viewPrincipal.getMntmListadoDeSocios() == e.getSource()) {
			SocioListadoView socioListadoView = new SocioListadoView();
			SocioController socioController = new SocioController(new SocioDao(), null, null, socioListadoView, null,
					null, null);
		} else if (viewPrincipal.getJMenuItemCumpleanios() == e.getSource()) {
			SocioController socioController = new SocioController(new SocioDao(), null, null, null,
					new SocioCumpleaniosListadoView(), null, null);
		} else if (viewPrincipal.getJMenuItemListaMembresias() == e.getSource()) {
			MembresiaController membresiaController = new MembresiaController(new MembresiaDao(), null,
					new MembresiaListadoView());
		} else if (viewPrincipal.getJMenuItemRegistrarEntrenador() == e.getSource()) {
			EntrenadorController entrenadorController = new EntrenadorController(new EntrenadorDao(),
					new RegistroEntrenador(), null, null,null);
		} else if (viewPrincipal.getJMenuItemBuscarEntrenador() == e.getSource()) {
			EntrenadorController entrenadorController = new EntrenadorController(new EntrenadorDao(), null,
					new BusquedaEntrenador(), null, null);
		} else if (viewPrincipal.getJMenuItemListaEntrenador() == e.getSource()) {
			EntrenadorController entrenadorController = new EntrenadorController(new EntrenadorDao(), null, null,
					new ListaEntrenador(), null);
		}

	}
}

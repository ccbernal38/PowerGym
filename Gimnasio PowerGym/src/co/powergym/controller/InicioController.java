package co.powergym.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;

import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.verification.DPFPVerification;

import co.powergym.dao.EntrenadorDao;
import co.powergym.dao.MembresiaDao;
import co.powergym.dao.SocioDao;
import co.powergym.model.Socio;
import co.powergym.utils.HuellaInit;
import co.powergym.utils.Preferencias;
import co.powergym.utils.SocioPanelCumpleanios;
import co.powergym.view.InitView;
import co.powergym.view.config.ConfigPuertoView;
import co.powergym.view.membresia.CrearMembresia;
import co.powergym.view.membresia.MembresiaListadoView;
import co.powergym.view.socio.SocioBusquedaView;
import co.powergym.view.socio.SocioCumpleaniosListadoView;
import co.powergym.view.socio.SocioListadoView;
import co.powergym.view.socio.SocioRegistrarEntradaView;
import co.powergym.view.socio.SocioRegistroView;
import co.powergym.view.usuario.entrenador.BusquedaEntrenador;
import co.powergym.view.usuario.entrenador.ListaEntrenador;
import co.powergym.view.usuario.entrenador.RegistroEntrenador;

public class InicioController implements ActionListener {

	InitView viewPrincipal = new InitView();
	SocioDao socioDao;

	private DPFPCapture Lector;
	private DPFPEnrollment Reclutador;
	private DPFPVerification Verificador;
	private DPFPTemplate template;
	public static String TEMPLATE_PROPERTY = "template";
	public DPFPFeatureSet featuresinscripcion;
	public DPFPFeatureSet featuresverificacion;
	private HuellaInit huellaInit;

	public InicioController(InitView viewPrincipal) {
		socioDao = new SocioDao();
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
		this.viewPrincipal.getMntmPuertoTorniquete().addActionListener(this);
		this.viewPrincipal.getBtnSalir().addActionListener(this);
		listadoCumpleaniosDia();
		this.viewPrincipal.setVisible(true);
		this.viewPrincipal.setLocationRelativeTo(null);
		this.viewPrincipal.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Closed");
				Preferencias.resetPreferencias();
				JOptionPane pane = new JOptionPane("Espere, Saliendo......", JOptionPane.INFORMATION_MESSAGE,
						JOptionPane.DEFAULT_OPTION, null, new Object[] {}, null);
				JDialog dialog = pane.createDialog(null, "Entrada");
				new Thread(new Runnable() {
					public void run() {
						try {
							Thread.sleep(500);
							dialog.dispose();
							e.getWindow().dispose();
						} catch (Throwable th) {
							System.out.println("setValidComboIndex(): error :\n" + th.getMessage());
						}
					}
				}).start();

				dialog.setVisible(true);

			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		});
		huellaInit = new HuellaInit(viewPrincipal);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (viewPrincipal.getJButtonRegistrarEntrada() == e.getSource()) {
			HuellaController huellaController = new HuellaController(null, new SocioRegistrarEntradaView(), null);
		} else if (viewPrincipal.btnRegistrarSocio == e.getSource()
				|| viewPrincipal.getJMenuItemRegistrarSocio() == e.getSource()) {
			SocioRegistroView viewRegistroSocio = new SocioRegistroView();
			SocioController socioController = new SocioController(viewRegistroSocio, null, null, null, null);
			
		} else if (viewPrincipal.jMenuItem3buscarSocio == e.getSource()) {
			SocioBusquedaView viewBusquedaSocio = new SocioBusquedaView();
			SocioController socioController = new SocioController(null, viewBusquedaSocio, null, null, null);
		} else if (viewPrincipal.btnMenuMembresia == e.getSource()) {
			MembresiaDao membresiaDao = new MembresiaDao();
			CrearMembresia crearMembresia = new CrearMembresia();
			MembresiaController Mcontroller = new MembresiaController(crearMembresia, null);
		} else if (viewPrincipal.getMntmListadoDeSocios() == e.getSource()) {
			SocioListadoView socioListadoView = new SocioListadoView();
			SocioController socioController = new SocioController(null, null, socioListadoView, null, null);
		} else if (viewPrincipal.getJMenuItemCumpleanios() == e.getSource()) {
			SocioController socioController = new SocioController(null, null, null, new SocioCumpleaniosListadoView(),
					null);
		} else if (viewPrincipal.getJMenuItemListaMembresias() == e.getSource()) {
			MembresiaController membresiaController = new MembresiaController(null, new MembresiaListadoView());
		} else if (viewPrincipal.getJMenuItemRegistrarEntrenador() == e.getSource()) {
			EntrenadorController entrenadorController = new EntrenadorController(new EntrenadorDao(),
					new RegistroEntrenador(), null, null, null);
		} else if (viewPrincipal.getJMenuItemBuscarEntrenador() == e.getSource()) {
			EntrenadorController entrenadorController = new EntrenadorController(new EntrenadorDao(), null,
					new BusquedaEntrenador(), null, null);
		} else if (viewPrincipal.getJMenuItemListaEntrenador() == e.getSource()) {
			EntrenadorController entrenadorController = new EntrenadorController(new EntrenadorDao(), null, null,
					new ListaEntrenador(), null);
		} else if (viewPrincipal.getBtnSalir() == e.getSource()) {
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
		} else if (viewPrincipal.getMntmPuertoTorniquete() == e.getSource()) {
			new ConfigController(new ConfigPuertoView());
		}
	}

	public void listadoCumpleaniosDia() {
		JList<Socio> jList = viewPrincipal.getListCumpleanios();
		List<Socio> socios = socioDao.sociosCumpleaniosDia();

		DefaultListModel<Socio> model = new DefaultListModel<>();
		for (Socio socio : socios) {
			model.addElement(socio);
		}
		jList.setModel(model);
		jList.setCellRenderer(new SocioPanelCumpleanios());
	}
}

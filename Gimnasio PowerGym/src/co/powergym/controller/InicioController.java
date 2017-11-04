package co.powergym.controller;

import java.awt.Dialog;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.verification.DPFPVerification;

import co.powergym.dao.UsuarioDao;
import co.powergym.dao.AsistenciaDao;
import co.powergym.dao.CajaDao;
import co.powergym.dao.MembresiaDao;
import co.powergym.dao.PermisoDao;
import co.powergym.dao.PermisoUsuarioDao;

import co.powergym.dao.MembresiaSocioDao;
import co.powergym.dao.SocioDao;
import co.powergym.model.Asistencia;
import co.powergym.model.MembresiaSocio;
import co.powergym.model.PermisoUsuario;
import co.powergym.model.Socio;
import co.powergym.utils.Constantes;
import co.powergym.utils.HuellaInit;
import co.powergym.utils.Preferencias;
import co.powergym.utils.SocioPanelCumpleanios;
import co.powergym.view.BackupView;
import co.powergym.view.InitView;
import co.powergym.view.ReciboView;
import co.powergym.view.caja.CajaAperturaView;
import co.powergym.view.caja.CajaCierreView;
import co.powergym.view.caja.CajaHistoricoView;
import co.powergym.view.caja.CajaListaEgresosHoyView;
import co.powergym.view.caja.CajaListaHistoricoEgresosView;
import co.powergym.view.caja.CajaListaHistoricosIngresosView;
import co.powergym.view.caja.CajaListaIngresosHoyView;
import co.powergym.view.caja.CajaMembresiaVentaDiaView;
import co.powergym.view.caja.CajaRegistroEgresoView;
import co.powergym.view.caja.CajaRegistroIngresoView;
import co.powergym.view.config.ConfigPuertoView;
import co.powergym.view.membresia.MembresiaRegistroView;
import co.powergym.view.membresia.MembresiaRegistroVisitaRangoView;
import co.powergym.view.membresia.MembresiaListaDiaVisitasView;
import co.powergym.view.membresia.MembresiaListaVisitasView;
import co.powergym.view.membresia.MembresiaListadoView;
import co.powergym.view.membresia.MembresiaRegistroVisitaView;
import co.powergym.view.reporte.GenerarReporte;
import co.powergym.view.socio.SocioBusquedaView;
import co.powergym.view.socio.SocioConsultaBusquedaView;
import co.powergym.view.socio.SocioCumpleaniosListadoView;
import co.powergym.view.socio.SocioListConsultaBusquedaView;
import co.powergym.view.socio.SocioListadoView;
import co.powergym.view.socio.SocioRegistrarEntradaView;
import co.powergym.view.socio.SocioRegistroView;
import co.powergym.view.usuario.entrenador.BusquedaUsuario;
import co.powergym.view.usuario.entrenador.ListaUsuario;
import co.powergym.view.usuario.entrenador.RegistroUsuario;

public class InicioController implements ActionListener {

	InitView viewPrincipal = new InitView();
	SocioDao socioDao;
	CajaDao cajaDao;
	PermisoUsuarioDao permisoUsuarioDao;

	public static String TEMPLATE_PROPERTY = "template";
	public DPFPFeatureSet featuresinscripcion;
	public DPFPFeatureSet featuresverificacion;
	private HuellaInit huellaInit;
	private CajaAperturaView aperturaCajaView;

	public InicioController(InitView viewPrincipal) {
		socioDao = new SocioDao();
		cajaDao = new CajaDao();
		permisoUsuarioDao = new PermisoUsuarioDao();
		this.viewPrincipal = viewPrincipal;
		this.viewPrincipal.getJMenuItemRegistrarSocio().addActionListener(this);
		this.viewPrincipal.getJMenuItemRegistrarSocio().setEnabled(false);
		this.viewPrincipal.getMntmRegistroDeVisitaRango().addActionListener(this);
		this.viewPrincipal.getBtnRegistrarSocio().addActionListener(this);
		this.viewPrincipal.getBtnRegistrarSocio().setEnabled(false);
		this.viewPrincipal.getjMenuItem3buscarSocio().addActionListener(this);
		this.viewPrincipal.getjMenuItem3buscarSocio().setEnabled(false);
		this.viewPrincipal.getBtnMenuMembresia().addActionListener(this);
		this.viewPrincipal.getBtnMenuMembresia().setEnabled(false);
		this.viewPrincipal.getJButtonCierreCaja().setEnabled(false);
		this.viewPrincipal.getJCrearMembresia().setEnabled(false);
		this.viewPrincipal.getMntmListadoDeSocios().addActionListener(this);
		this.viewPrincipal.getMntmListadoDeSocios().setEnabled(false);
		this.viewPrincipal.getJMenuItemCumpleanios().addActionListener(this);
		this.viewPrincipal.getJMenuItemCumpleanios().setEnabled(false);
		this.viewPrincipal.getJMenuItemRegistrarUsuario().addActionListener(this);
		this.viewPrincipal.getJMenuItemRegistrarUsuario().setEnabled(false);
		this.viewPrincipal.getJMenuItemListaUsuario().addActionListener(this);
		this.viewPrincipal.getJMenuItemListaUsuario().setEnabled(false);
		this.viewPrincipal.getJMenuItemListaMembresias().addActionListener(this);
		this.viewPrincipal.getJMenuItemListaMembresias().setEnabled(false);
		this.viewPrincipal.getBtnRegistrodeVisita().addActionListener(this);
		this.viewPrincipal.getBtnRegistrodeVisita().setEnabled(false);
		this.viewPrincipal.getMntmPuertoTorniquete().addActionListener(this);
		this.viewPrincipal.getBtnSalir().addActionListener(this);
		this.viewPrincipal.getjMenuItemAsistencia().addActionListener(this);
		this.viewPrincipal.getjMenuItemSocioActivo().addActionListener(this);
		this.viewPrincipal.getBtnPuerta().addActionListener(this);
		this.viewPrincipal.getBtnBuscar().addActionListener(this);
		this.viewPrincipal.getMntmRegistrarEgreso().addActionListener(this);
		this.viewPrincipal.getMntmRegistrarEgreso().setEnabled(false);
		this.viewPrincipal.getBtnVerificar().addActionListener(this);
		this.viewPrincipal.getMntmHistoricoDeEgresos().addActionListener(this);
		this.viewPrincipal.getMntmHistoricoDeEgresos().setEnabled(false);
		this.viewPrincipal.getMntmEgresosDelDia().addActionListener(this);
		this.viewPrincipal.getMntmEgresosDelDia().setEnabled(false);
		this.viewPrincipal.getMntmHistoricoDeVisitas().addActionListener(this);
		this.viewPrincipal.getMntmHistoricoDeVisitas().setEnabled(false);
		this.viewPrincipal.getMntmVisitasDeHoy().addActionListener(this);
		this.viewPrincipal.getMntmVisitasDeHoy().setEnabled(false);
		this.viewPrincipal.getMntmRegistroDeVisitas().addActionListener(this);
		this.viewPrincipal.getMntmRegistroDeVisitas().setEnabled(false);
		this.viewPrincipal.getJMenuItemVentasDia().addActionListener(this);
		this.viewPrincipal.getJMenuItemVentasDia().setEnabled(false);
		this.viewPrincipal.getJMenuItemCierreCaja().addActionListener(this);
		this.viewPrincipal.getJMenuItemCierreCaja().setEnabled(false);
		this.viewPrincipal.getMntmCopiaDeSeguridad().addActionListener(this);
		this.viewPrincipal.getMntmCopiaDeSeguridad().setEnabled(false);
		this.viewPrincipal.getMntmHistoricoDeCaja().addActionListener(this);
		this.viewPrincipal.getMntmHistoricoDeCaja().setEnabled(false);
		listadoCumpleaniosDia();
		this.viewPrincipal.setExtendedState(JFrame.MAXIMIZED_HORIZ);
		this.viewPrincipal.setVisible(true);
		this.viewPrincipal.setLocationRelativeTo(null);
		asignarPermisos();

		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(new KeyEventDispatcher() {

			@Override
			public boolean dispatchKeyEvent(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getID() == KeyEvent.KEY_PRESSED) {
					if (e.getKeyCode() == KeyEvent.VK_F2) {
						new VisitaController(new MembresiaRegistroVisitaView(), null, null, null);
					}
					if (e.getKeyCode() == KeyEvent.VK_F3) {
						SocioController socioController = new SocioController(new SocioRegistroView(), null, null, null,
								null, null, null);
						socioController.setHuellaInit(huellaInit);
					}
					if (e.getKeyCode() == KeyEvent.VK_F4) {

					}
					if (e.getKeyCode() == KeyEvent.VK_F5) {
						new MembresiaController(new MembresiaRegistroView(), null, null);
					}
					if (e.getKeyCode() == KeyEvent.VK_F6) {
						new CajaController(null, new CajaCierreView(), null, null);
					}
				}
				return false;
			}
		});
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
		if (cajaDao.verificarCajaAbierta() == -1) {
			aperturaCajaView = new CajaAperturaView();
			aperturaCajaView.getLblNombreResponsable()
					.setText(Preferencias.obtenerPreferencia(Constantes.NOMBRE_RESPONSABLE));
			aperturaCajaView.getBtnAbrir().addActionListener(this);
			aperturaCajaView.setLocationRelativeTo(null);
			viewPrincipal.setEnabled(false);
			aperturaCajaView.setVisible(true);
		}
	}

	public void asignarPermisos() {

		int idUsuario = Integer.parseInt(Preferencias.obtenerPreferencia(Constantes.ID_RESPONSABLE));
		List<PermisoUsuario> permisos = permisoUsuarioDao.permisosPorUsuario(idUsuario);

		for (int i = 0; i < permisos.size(); i++) {
			if (permisos.get(i).getPermiso_id() == 1) {
				viewPrincipal.getMntmCopiaDeSeguridad().setEnabled(true);
			}
			if (permisos.get(i).getPermiso_id() == 2) {
				viewPrincipal.getBtnRegistrarSocio().setEnabled(true);
				viewPrincipal.getJMenuItemRegistrarSocio().setEnabled(true);
			}
			if (permisos.get(i).getPermiso_id() == 3) {
				viewPrincipal.getjMenuItem3buscarSocio().setEnabled(true);
			}
			if (permisos.get(i).getPermiso_id() == 4) {
				viewPrincipal.getMntmListadoDeSocios().setEnabled(true);
			}
			if (permisos.get(i).getPermiso_id() == 5) {
				viewPrincipal.getJMenuItemCumpleanios().setEnabled(true);
			}
			if (permisos.get(i).getPermiso_id() == 6) {
				viewPrincipal.getJCrearMembresia().setEnabled(true);
				viewPrincipal.getBtnMenuMembresia().setEnabled(true);
			}
			if (permisos.get(i).getPermiso_id() == 7) {
				viewPrincipal.getJMenuItemListaMembresias().setEnabled(true);
			}
			if (permisos.get(i).getPermiso_id() == 8) {
				viewPrincipal.getJMenuItemCierreCaja().setEnabled(true);
				viewPrincipal.getJButtonCierreCaja().setEnabled(true);
			}
			if (permisos.get(i).getPermiso_id() == 9) {
				viewPrincipal.getJMenuItemVentasDia().setEnabled(true);
			}
			if (permisos.get(i).getPermiso_id() == 10) {
				viewPrincipal.getMntmHistoricoDeCaja().setEnabled(true);
			}
			if (permisos.get(i).getPermiso_id() == 11) {
				viewPrincipal.getMntmHistoricoDeEgresos().setEnabled(true);
			}
			if (permisos.get(i).getPermiso_id() == 12) {
				viewPrincipal.getMntmEgresosDelDia().setEnabled(true);
			}
			if (permisos.get(i).getPermiso_id() == 13) {
				viewPrincipal.getMntmRegistrarEgreso().setEnabled(true);
			}
			if (permisos.get(i).getPermiso_id() == 14) {
				viewPrincipal.getMntmHistoricoDeVisitas().setEnabled(true);
			}
			if (permisos.get(i).getPermiso_id() == 15) {
				viewPrincipal.getBtnRegistrodeVisita().setEnabled(true);
				viewPrincipal.getMntmRegistroDeVisitas().setEnabled(true);
			}
			if (permisos.get(i).getPermiso_id() == 16) {
				viewPrincipal.getMntmVisitasDeHoy().setEnabled(true);
			}
			if (permisos.get(i).getPermiso_id() == 17) {
				viewPrincipal.getJMenuItemRegistrarUsuario().setEnabled(true);
			}
			if (permisos.get(i).getPermiso_id() == 18) {
				viewPrincipal.getJMenuItemListaUsuario().setEnabled(true);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (aperturaCajaView != null) {
			if (aperturaCajaView.getBtnAbrir() == e.getSource()) {
				Date fechaApertura = null;
				try {
					fechaApertura = new SimpleDateFormat("dd/MM/yyyy").parse(aperturaCajaView.getFecha().getText());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int saldoInicial = 0;
				boolean res = cajaDao.aperturaCaja(
						Integer.parseInt(Preferencias.obtenerPreferencia(Constantes.ID_RESPONSABLE)), fechaApertura,
						saldoInicial);
				if (res == true) {
					JOptionPane.showMessageDialog(null, "La apertura de caja se ha realizado correctamente.");
				}
				int id = cajaDao.verificarCajaAbierta();
				Preferencias.datosCajaActiva(id);
				viewPrincipal.setEnabled(true);
				aperturaCajaView.setVisible(false);
				aperturaCajaView.dispose();
			}
		}
		if (viewPrincipal.getjMenuItemSocioActivo() == e.getSource()) {
			new ReporteController(new GenerarReporte());
		}
		if (viewPrincipal.getMntmRegistrarEgreso() == e.getSource()) {
			new MovimientoController(null, new CajaRegistroEgresoView(), null, null, null, null);
			// new ReciboController(new ReciboView());
		}
		if (viewPrincipal.getBtnRegistrodeVisita() == e.getSource()
				|| viewPrincipal.getMntmRegistroDeVisitas() == e.getSource()) {
			new VisitaController(new MembresiaRegistroVisitaView(), null, null, null);
		} else if (viewPrincipal.getMntmHistoricoDeVisitas() == e.getSource()) {
			new VisitaController(null, new MembresiaListaVisitasView(), null, null);
		} else if (viewPrincipal.getMntmVisitasDeHoy() == e.getSource()) {
			new VisitaController(null, null, new MembresiaListaDiaVisitasView(), null);
		} else if (viewPrincipal.getBtnBuscar() == e.getSource()) {
			String key = viewPrincipal.getTextFieldKey().getText();
			List<Socio> socios = socioDao.buscarSocioKey(key);
			if (socios.size() == 1) {
				mostrarViewBusqueda(socios.get(0));
			} else if (socios.size() == 0) {
				JOptionPane.showMessageDialog(null, "No se encontr� coincidencia.");
			} else {
				mostrarViewListSocios(socios);
			}

		} else if (viewPrincipal.getBtnPuerta() == e.getSource()) {
			huellaInit.abrirTorniquete();
		} else if (viewPrincipal.btnRegistrarSocio == e.getSource()
				|| viewPrincipal.getJMenuItemRegistrarSocio() == e.getSource()) {
			SocioRegistroView viewRegistroSocio = new SocioRegistroView();
			SocioController socioController = new SocioController(viewRegistroSocio, null, null, null, null, null,
					null);
			socioController.setHuellaInit(huellaInit);
		} else if (viewPrincipal.jMenuItem3buscarSocio == e.getSource()) {
			SocioBusquedaView viewBusquedaSocio = new SocioBusquedaView();
			new SocioController(null, null, viewBusquedaSocio, null, null, null, null);
		} else if (viewPrincipal.btnMenuMembresia == e.getSource()) {
			new MembresiaDao();
			MembresiaRegistroView crearMembresia = new MembresiaRegistroView();
			new MembresiaController(crearMembresia, null, null);
		} else if (viewPrincipal.getMntmListadoDeSocios() == e.getSource()) {
			SocioListadoView socioListadoView = new SocioListadoView();
			new SocioController(null, null, null, socioListadoView, null, null, null);
		} else if (viewPrincipal.getJMenuItemCumpleanios() == e.getSource()) {
			new SocioController(null, null, null, null, new SocioCumpleaniosListadoView(), null, null);
		} else if (viewPrincipal.getJMenuItemListaMembresias() == e.getSource()) {
			new MembresiaController(null, new MembresiaListadoView(), null);
		} else if (viewPrincipal.getJMenuItemRegistrarUsuario() == e.getSource()) {
			UsuarioController usuarioController = new UsuarioController(new UsuarioDao(), new PermisoDao(),
					new PermisoUsuarioDao(), new RegistroUsuario(), null, null, null);
		} else if (viewPrincipal.getJMenuItemListaUsuario() == e.getSource()) {
			new UsuarioController(new UsuarioDao(), new PermisoDao(), new PermisoUsuarioDao(), null, null,
					new ListaUsuario(), null);
		} else if (viewPrincipal.getjMenuItemAsistencia() == e.getSource()) {

		} else if (viewPrincipal.getMntmEgresosDelDia() == e.getSource()) {
			new MovimientoController(null, null, new CajaListaEgresosHoyView(), null, null, null);
		} else if (viewPrincipal.getMntmHistoricoDeEgresos() == e.getSource()) {
			new MovimientoController(null, null, null, null, new CajaListaHistoricoEgresosView(), null);
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
		} else if (viewPrincipal.getBtnVerificar() == e.getSource()) {
			String id = viewPrincipal.getTextFieldCodigo().getText();
			if (!id.equals("")) {
				Socio socio = socioDao.buscarSocioIdOrCodigo(id);
				huellaInit.initConsultaEntrada(socio);
			}
		} else if (viewPrincipal.getMntmHistoricoDeVisitas() == e.getSource()) {
			new VisitaController(null, new MembresiaListaVisitasView(), null, null);
		} else if (viewPrincipal.getMntmVisitasDeHoy() == e.getSource()) {
			new VisitaController(null, null, new MembresiaListaDiaVisitasView(), null);
		} else if (viewPrincipal.getJMenuItemVentasDia() == e.getSource()) {
			new CajaController(new CajaMembresiaVentaDiaView(), null, null, null);
		} else if (viewPrincipal.getJMenuItemCierreCaja() == e.getSource()) {
			new CajaController(null, new CajaCierreView(), null, null);
		} else if (viewPrincipal.getMntmCopiaDeSeguridad() == e.getSource()) {
			new CajaController(null, null, new BackupView(), null);
		} else if (this.viewPrincipal.getMntmHistoricoDeCaja() == e.getSource()) {
			new CajaController(null, null, null, new CajaHistoricoView());
		} else if (viewPrincipal.getMntmRegistroDeVisitaRango() == e.getSource()) {
			new VisitaController(null, null, null, new MembresiaRegistroVisitaRangoView());
		}
	}

	private void mostrarViewListSocios(List<Socio> socios) {
		SocioListConsultaBusquedaView view = new SocioListConsultaBusquedaView();
		DefaultListModel<Socio> defaultListModel = new DefaultListModel<>();
		for (Socio socio : socios) {
			defaultListModel.addElement(socio);
		}
		view.getListSocios().setModel(defaultListModel);
		view.getListSocios().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					Socio item = (Socio) view.getListSocios().getSelectedValue();
					mostrarViewBusqueda(item);
				}
			}
		});
		view.setLocationRelativeTo(null);
		view.setVisible(true);
	}

	private void mostrarViewBusqueda(Socio socio) {
		SocioController controller = new SocioController(null, null, null, null, null, null,
				new SocioConsultaBusquedaView());
		controller.cargarConsultaBusquedaSocio(socio);
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

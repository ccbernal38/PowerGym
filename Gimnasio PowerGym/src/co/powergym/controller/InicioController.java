package co.powergym.controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
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
import co.powergym.dao.MembresiaDao;
import co.powergym.dao.MembresiaSocioDao;
import co.powergym.dao.SocioDao;
import co.powergym.model.Asistencia;
import co.powergym.model.MembresiaSocio;
import co.powergym.model.Socio;
import co.powergym.reportes.Reporte;
import co.powergym.utils.HuellaInit;
import co.powergym.utils.Preferencias;
import co.powergym.utils.SocioPanelCumpleanios;
import co.powergym.view.InitView;
import co.powergym.view.config.ConfigPuertoView;
import co.powergym.view.membresia.CrearMembresia;
import co.powergym.view.membresia.MembresiaListadoView;
import co.powergym.view.socio.SocioBusquedaView;
import co.powergym.view.socio.SocioConsultaBusquedaView;
import co.powergym.view.socio.SocioCumpleaniosListadoView;
import co.powergym.view.socio.SocioListConsultaBusquedaView;
import co.powergym.view.socio.SocioListadoView;
import co.powergym.view.socio.SocioRegistrarEntradaView;
import co.powergym.view.socio.SocioRegistroView;
import co.powergym.view.usuario.entrenador.BusquedaEntrenador;
import co.powergym.view.usuario.entrenador.ListaEntrenador;
import co.powergym.view.usuario.entrenador.RegistroEntrenador;

public class InicioController implements ActionListener {

	InitView viewPrincipal = new InitView();
	SocioDao socioDao;
	Reporte reporte;

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
		this.viewPrincipal.getjMenuItemAsistencia().addActionListener(this);
		this.viewPrincipal.getjMenuItemSocioActivo().addActionListener(this);
		this.viewPrincipal.getBtnPuerta().addActionListener(this);
		this.viewPrincipal.getBtnBuscar().addActionListener(this);
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
		} else if (viewPrincipal.getBtnBuscar() == e.getSource()) {
			String key = viewPrincipal.getTextFieldKey().getText();
			List<Socio> socios = socioDao.buscarSocioKey(key);
			if (socios.size() == 1) {
				mostrarViewBusqueda(socios.get(0));
			} else if (socios.size() == 0) {
				JOptionPane.showMessageDialog(null, "No se encontró coincidencia.");
			} else {
				mostrarViewListSocios(socios);
			}

		} else if (viewPrincipal.getBtnPuerta() == e.getSource()) {
			huellaInit.abrirTorniquete();
		} else if (viewPrincipal.btnRegistrarSocio == e.getSource()
				|| viewPrincipal.getJMenuItemRegistrarSocio() == e.getSource()) {
			SocioRegistroView viewRegistroSocio = new SocioRegistroView();
			SocioController socioController = new SocioController(viewRegistroSocio, null, null, null, null);
			socioController.setHuellaInit(huellaInit);
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
			UsuarioController entrenadorController = new UsuarioController(new UsuarioDao(), new RegistroEntrenador(),
					null, null, null);
		} else if (viewPrincipal.getJMenuItemBuscarEntrenador() == e.getSource()) {
			UsuarioController entrenadorController = new UsuarioController(new UsuarioDao(), null,
					new BusquedaEntrenador(), null, null);
		} else if (viewPrincipal.getJMenuItemListaEntrenador() == e.getSource()) {
			UsuarioController entrenadorController = new UsuarioController(new UsuarioDao(), null, null,
					new ListaEntrenador(), null);
		} else if (viewPrincipal.getjMenuItemAsistencia() == e.getSource()) {

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
		SocioConsultaBusquedaView viewBusquedaSocio = new SocioConsultaBusquedaView();
		if (socio != null) {
			viewBusquedaSocio.getBtnAgregarMembresia().setEnabled(true);
			viewBusquedaSocio.getBtnAgregarPago().setEnabled(true);
			String primerNombre = socio.getNombreCompleto();
			viewBusquedaSocio.getTextField_primerNombre().setText(primerNombre);
			String fechaNacimiento = String.valueOf(socio.getFechaNacimiento());
			viewBusquedaSocio.getTextField_fechaNacimiento().setText(fechaNacimiento);
			String telefono = socio.getTelefono();
			viewBusquedaSocio.getTextField_telefono().setText(telefono);
			if (socio.getFoto() != null) {
				Image dimg = socio.getFoto().getScaledInstance(viewBusquedaSocio.getLblFoto().getWidth(),
						viewBusquedaSocio.getLblFoto().getHeight(), Image.SCALE_REPLICATE);
				viewBusquedaSocio.getLblFoto().setIcon(new ImageIcon(dimg));
			}
			llenarTablaHistorico(socio.getId(), viewBusquedaSocio);
			llenarTablaAsistencia(socio.getId(), viewBusquedaSocio);
			viewBusquedaSocio.setLocationRelativeTo(null);
			viewBusquedaSocio.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "No se encontrï¿½ un socio con ese nï¿½mero de identificaciï¿½n, "
					+ "por favor verifique e intente de nuevo");
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

	private void llenarTablaAsistencia(int id, SocioConsultaBusquedaView viewBusquedaSocio) {
		AsistenciaDao asistenciaDao = new AsistenciaDao();
		List<Asistencia> list = asistenciaDao.historicoAsistencias(id);

		DefaultTableModel defaultTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Dia", "Fecha", "Hora" });

		Object[] columna = new Object[3];
		int numeroRegistros = list.size();

		for (int i = 0; i < numeroRegistros; i++) {
			columna[0] = list.get(i).getDia();
			columna[1] = list.get(i).getFecha();
			columna[2] = list.get(i).getHora();

			defaultTableModel.addRow(columna);
		}
		viewBusquedaSocio.getTableAsistencias().setModel(defaultTableModel);
		viewBusquedaSocio.getTableAsistencias().repaint();
	}

	private void llenarTablaHistorico(int id, SocioConsultaBusquedaView viewBusquedaSocio) {
		MembresiaSocioDao membresiaSocioDao = new MembresiaSocioDao();
		List<MembresiaSocio> list = membresiaSocioDao.historialMembresias(id);

		DefaultTableModel defaultTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Nombre", "Fecha Inicio", "Fecha Fin", "Estado" });

		Object[] columna = new Object[4];
		int numeroRegistros = list.size();

		for (int i = 0; i < numeroRegistros; i++) {
			columna[0] = list.get(i).getMembresia().getNombre();
			Date inicial = list.get(i).getFechaInicial();
			columna[1] = new SimpleDateFormat("MM-dd-yyyy").format(inicial);

			columna[2] = new SimpleDateFormat("MM-dd-yyyy").format(list.get(i).getFechaFinal());
			if (list.get(i).isActiva()) {
				columna[3] = "Activa";
			} else {
				columna[3] = "Inactiva";
			}
			defaultTableModel.addRow(columna);
		}
		viewBusquedaSocio.getTableHistorico().setModel(defaultTableModel);
		viewBusquedaSocio.getTableHistorico().repaint();
	}
}

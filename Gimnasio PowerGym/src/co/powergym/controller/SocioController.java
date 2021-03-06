package co.powergym.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.FieldPosition;
import java.text.Format;
import java.text.Normalizer.Form;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.github.sarxos.webcam.Webcam;
import com.sun.java_cup.internal.runtime.virtual_parse_stack;
import com.sun.xml.internal.ws.api.Cancelable;

import co.powergym.dao.AsistenciaDao;
import co.powergym.dao.CajaDao;
import co.powergym.dao.MembresiaDao;
import co.powergym.dao.MembresiaSocioDao;
import co.powergym.dao.SocioDao;
import co.powergym.model.Asistencia;
import co.powergym.model.Membresia;
import co.powergym.model.MembresiaSocio;
import co.powergym.model.Socio;
import co.powergym.utils.HuellaInit;
import co.powergym.view.membresia.PagoMembresiaView;
import co.powergym.view.socio.SocioAsignarMembresiaView;
import co.powergym.view.socio.SocioBusquedaView;
import co.powergym.view.socio.SocioConsultaBusquedaView;
import co.powergym.view.socio.SocioCumpleaniosListadoView;
import co.powergym.view.socio.SocioListadoView;
import co.powergym.view.socio.SocioRegistroView;
import javafx.scene.control.ComboBox;
import jdk.nashorn.internal.runtime.arrays.NumericElements;
import co.powergym.view.socio.SocioRegistrarEntradaView;
import co.powergym.view.socio.SocioRegistroHuella;

public class SocioController implements ActionListener, ItemListener {

	private Webcam webcam;
	private SocioDao socioDao;
	private MembresiaDao membresiaDao;
	private MembresiaSocioDao membresiaSocioDao;
	private SocioRegistroView viewRegistroSocio;
	private SocioBusquedaView viewBusquedaSocio;
	private SocioListadoView viewListadoSocio;
	private SocioCumpleaniosListadoView viewCumpleaniosListadoView;
	private BufferedImage fotoTemp;
	private SocioAsignarMembresiaView viewAsignarMembresia;
	private SocioConsultaBusquedaView viewConsultaBusquedaSocio;
	private byte[] tempHuella;
	private HuellaInit huellaInit;
	private Membresia membresiaTemp;

	public SocioController(SocioRegistroView viewRegistroSocio, SocioBusquedaView viewBusquedaSocio,
			SocioListadoView socioListadoView, SocioCumpleaniosListadoView cumpleaniosListadoView,
			SocioAsignarMembresiaView asignarMembresiaView, SocioConsultaBusquedaView consultaBusquedaView) {
		this.socioDao = new SocioDao();
		this.membresiaDao = new MembresiaDao();
		this.membresiaSocioDao = new MembresiaSocioDao();
		this.viewConsultaBusquedaSocio = consultaBusquedaView;

		if (viewRegistroSocio != null) {
			initRegistroSocio(viewRegistroSocio);
		}
		if (viewBusquedaSocio != null) {
			initBusquedaSocio(viewBusquedaSocio);
		}
		if (socioListadoView != null) {
			initSocioListado(socioListadoView);
		}
		if (cumpleaniosListadoView != null) {
			initCumpleaniosListado(cumpleaniosListadoView);
		}
		if (viewConsultaBusquedaSocio != null) {
			viewConsultaBusquedaSocio.setLocationRelativeTo(null);
			viewConsultaBusquedaSocio.setVisible(true);
		}
	}

	public void cargarConsultaBusquedaSocio(Socio socio) {
		if (socio != null) {
			viewConsultaBusquedaSocio.getBtnAgregarMembresia().setEnabled(true);
			viewConsultaBusquedaSocio.getBtnAgregarPago().setEnabled(true);
			viewConsultaBusquedaSocio.getBtnRegistrarVisita().setEnabled(true);
			viewConsultaBusquedaSocio.getBtnAgregarMembresia().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String identificacion = socio.getIdentificacion();
					initAsignarMembresia(new SocioAsignarMembresiaView(), identificacion);
				}
			});
			viewConsultaBusquedaSocio.getBtnAgregarPago().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					new PagoController(new PagoMembresiaView());
				}
			});
			String primerNombre = socio.getNombreCompleto();
			viewConsultaBusquedaSocio.getTextField_primerNombre().setText(primerNombre);
			String fechaNacimiento = String.valueOf(socio.getFechaNacimiento());
			viewConsultaBusquedaSocio.getTextField_fechaNacimiento().setText(fechaNacimiento);
			String telefono = socio.getTelefono();
			viewConsultaBusquedaSocio.getTextField_telefono().setText(telefono);
			if (socio.getFoto() != null) {
				Image dimg = socio.getFoto().getScaledInstance(viewConsultaBusquedaSocio.getLblFoto().getWidth(),
						viewConsultaBusquedaSocio.getLblFoto().getHeight(), Image.SCALE_REPLICATE);
				viewConsultaBusquedaSocio.getLblFoto().setIcon(new ImageIcon(dimg));
			}
			llenarTablaHistorico(socio.getId(), viewConsultaBusquedaSocio);
			llenarTablaAsistencia(socio.getId(), viewConsultaBusquedaSocio);

		} else {
			JOptionPane.showMessageDialog(null, "No se encontr� un socio con ese n�mero de identificaci�n, "
					+ "por favor verifique e intente de nuevo");
		}
	}

	public void initAsignarMembresia(SocioAsignarMembresiaView asignarMembresiaView, String identificacion) {
		this.viewAsignarMembresia = asignarMembresiaView;
		cargarDatosAsignarMembresia(identificacion);
		this.viewAsignarMembresia.setLocationRelativeTo(viewBusquedaSocio);
		this.viewAsignarMembresia.setVisible(true);
		this.viewAsignarMembresia.getDateChooserFin().getDateEditor()
				.addPropertyChangeListener(new PropertyChangeListener() {
					@Override
					public void propertyChange(PropertyChangeEvent e) {
						if ("date".equals(e.getPropertyName())) {
							System.out.println(e.getPropertyName() + ": " + (Date) e.getNewValue());
							membresiaTemp.setFechaFinal((Date) e.getNewValue());
							viewAsignarMembresia.getLabelResumenDuracion().setText(membresiaTemp.getTiempoDuracion());
						}
					}
				});
		this.viewAsignarMembresia.getTextFieldDescuento().getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				actualizarTotal();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				actualizarTotal();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				actualizarTotal();
			}
		});
	}

	public void actualizarTotal() {
		int descuento = Integer.parseInt(viewAsignarMembresia.getTextFieldDescuento().getText());
		int valor = membresiaTemp.getValor();
		int total = valor - descuento;
		NumberFormat format = NumberFormat.getInstance();
		viewAsignarMembresia.getLabelResumenCostoInscripcion().setText("$" + format.format(descuento));
		viewAsignarMembresia.getLabelResumenTotal().setText("$" + format.format(total));
	}

	private void cargarDatosAsignarMembresia(String identificacion) {
		List<Membresia> membresias = membresiaDao.listaMembresia();
		JComboBox comboboxMembresias = viewAsignarMembresia.getComboBoxMembresia();
		comboboxMembresias.addItem("----");
		for (Membresia membresia : membresias) {
			comboboxMembresias.addItem(membresia);
		}
		comboboxMembresias.addItemListener(this);

		viewAsignarMembresia.getBtnCancelar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewAsignarMembresia.setVisible(false);
				viewAsignarMembresia.dispose();
			}
		});
		viewAsignarMembresia.getBtnFinalizar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (viewAsignarMembresia.getComboBoxMembresia().getSelectedItem() instanceof Membresia) {
					Membresia membresia = (Membresia) viewAsignarMembresia.getComboBoxMembresia().getSelectedItem();
					Socio socio = socioDao.buscarSocio(identificacion);

					Date fechaInicio = viewAsignarMembresia.getDateChooserInicio().getDate();
					Date fechaFin = viewAsignarMembresia.getDateChooserFin().getDate();
					int renovar = 0;
					if (viewAsignarMembresia.getRdbtnSi().isSelected()) {
						renovar = 1;
					}
					int caja_id = new CajaDao().verificarCajaAbierta();
					int descuento = Integer.parseInt(viewAsignarMembresia.getTextFieldDescuento().getText());
					boolean respuesta = membresiaSocioDao.registrarMembresiaSocio(membresia.getId(), socio.getId(),
							fechaInicio, fechaFin, descuento, renovar, caja_id);
					if (respuesta == true) {
						JOptionPane.showMessageDialog(viewAsignarMembresia,
								"Se ha asignado una nueva membresia al socio.");
						viewAsignarMembresia.setVisible(false);
						viewAsignarMembresia.dispose();
						llenarTablaHistorico(socio.getId(), viewConsultaBusquedaSocio);
					} else {
						JOptionPane.showMessageDialog(viewAsignarMembresia,
								"Ha ocurrido un error asignando una nueva membresia al socio.");
						viewAsignarMembresia.setVisible(false);
						viewAsignarMembresia.dispose();
					}
				}
			}
		});
	}

	public void initRegistroSocio(SocioRegistroView socioRegistroView) {
		webcam = Webcam.getWebcams().get(0);
		this.viewRegistroSocio = socioRegistroView;
		this.viewRegistroSocio.getBtnTomarFoto().addActionListener(this);
		this.viewRegistroSocio.getBtnCapturar().addActionListener(this);
		this.viewRegistroSocio.getBtnRegistrar().addActionListener(this);
		this.viewRegistroSocio.getBtnCancelar().addActionListener(this);
		this.viewRegistroSocio.getBtnTomarHuellas().addActionListener(this);
		this.viewRegistroSocio.setVisible(true);
		this.viewRegistroSocio.setWebcam(webcam);
		generarCodigo();
	}

	public void initBusquedaSocio(SocioBusquedaView socioBusquedaView) {
		this.viewBusquedaSocio = socioBusquedaView;
		this.viewBusquedaSocio.getBtnBuscar().addActionListener(this);
		this.viewBusquedaSocio.getBtnAgregarMembresia().addActionListener(this);
		this.viewBusquedaSocio.getBtnAgregarPago().addActionListener(this);
		this.viewBusquedaSocio.setLocationRelativeTo(null);
		this.viewBusquedaSocio.setVisible(true);
	}

	public void initSocioListado(SocioListadoView socioListadoView) {
		this.viewListadoSocio = socioListadoView;
		listadoSociosLlenarTabla(viewListadoSocio.getTableSocios());
		this.viewListadoSocio.setVisible(true);
	}

	public void initCumpleaniosListado(SocioCumpleaniosListadoView cumpleaniosListadoView) {
		this.viewCumpleaniosListadoView = cumpleaniosListadoView;
		listadoCumpleaniosLlenarTabla(viewCumpleaniosListadoView.getTableSocios());
		this.viewCumpleaniosListadoView.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (viewRegistroSocio != null) {

			if (e.getSource() == viewRegistroSocio.getBtnRegistrar()) {
				registroSocio();
			}

			if (e.getSource() == viewRegistroSocio.getBtnCapturar()) {
				viewRegistroSocio.getBtnTomarFoto().setEnabled(true);
				viewRegistroSocio.getWebcamPanel().start();
			}

			if (e.getSource() == viewRegistroSocio.btnCancelar) {
				activarHuellaBackground();
				viewRegistroSocio.dispose();
			}

			if (e.getSource() == viewRegistroSocio.getBtnTomarHuellas()) {
				new HuellaController(new SocioRegistroHuella(), null, this);
			}

			if (e.getSource() == viewRegistroSocio.getBtnTomarFoto()) {
				fotoTemp = viewRegistroSocio.getWebcam().getImage();
				viewRegistroSocio.getWebcamPanel().stop();
				viewRegistroSocio.getWebcamPanel().setVisible(false);
				JLabel jLabel = new JLabel(new ImageIcon(fotoTemp));
				jLabel.setBounds(viewRegistroSocio.getWebcamPanel().getBounds());
				viewRegistroSocio.getPanel().add(jLabel);
				viewRegistroSocio.btnTomarFoto.setEnabled(false);
				viewRegistroSocio.btnCapturar.setEnabled(false);
			}
		}

		if (viewBusquedaSocio != null) {
			if (e.getSource() == viewBusquedaSocio.btnBuscar) {
				String numeroId = viewBusquedaSocio.getTextField_identidad().getText();
				Socio socio = socioDao.buscarSocio(numeroId);
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
					llenarTablaHistorico(socio.getId(), null);
					llenarTablaAsistencia(socio.getId(), null);
				} else {
					JOptionPane.showMessageDialog(null,
							"No se encontr� un socio con ese n�mero de identificaci�n, "
									+ "por favor verifique e intente de nuevo");
				}
			}
			if (e.getSource() == viewBusquedaSocio.getBtnAgregarMembresia()) {
				String identificacion = viewBusquedaSocio.getTextField_identidad().getText();
				initAsignarMembresia(new SocioAsignarMembresiaView(), identificacion);
			}
			if (e.getSource() == viewBusquedaSocio.getBtnAgregarPago()) {
				new PagoController(new PagoMembresiaView());
			}
		}

	}

	private void llenarTablaAsistencia(int id, SocioConsultaBusquedaView busquedaView) {
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
		if (busquedaView != null) {
			viewConsultaBusquedaSocio.getTableAsistencias().setModel(defaultTableModel);
			viewConsultaBusquedaSocio.getTableAsistencias().repaint();

		} else {
			viewBusquedaSocio.getTableAsistencias().setModel(defaultTableModel);
			viewBusquedaSocio.getTableAsistencias().repaint();
		}

	}

	private void llenarTablaHistorico(int id, SocioConsultaBusquedaView busquedaView) {
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
		if (busquedaView != null) {
			viewConsultaBusquedaSocio.getTableHistorico().setModel(defaultTableModel);
			viewConsultaBusquedaSocio.getTableHistorico().repaint();
			;
		} else {
			viewBusquedaSocio.getTableHistorico().setModel(defaultTableModel);
			viewBusquedaSocio.getTableHistorico().repaint();
		}

	}

	private void registroSocio() {
		try {
			String numeroId = viewRegistroSocio.getTextField_identificacion().getText();
			Socio socio = socioDao.buscarSocio(numeroId);
			if (socio == null) {
				String nombre = viewRegistroSocio.getTextField_primerNombre().getText();

				if (nombre == null || nombre.equals("")) {
					JOptionPane.showMessageDialog(null, "El campo primer nombre no puede estar vacio.");
				} else {

					String apellido = viewRegistroSocio.getTextField_primerApellido().getText();
					if (apellido == null || apellido.equals("")) {
						JOptionPane.showMessageDialog(null, "El campo primer apellido no puede estar vacio.");
					} else {

						Date fechaNacimiento = null;
						if (viewRegistroSocio.getDateChooser_fechaNacimiento().getDate() == null) {
							JOptionPane.showMessageDialog(null, "El campo fecha de nacimiento no puede estar vacio.");
						} else {
							fechaNacimiento = new Date(
									viewRegistroSocio.getDateChooser_fechaNacimiento().getDate().getTime());

							String telefono = viewRegistroSocio.getTextField_telefono().getText();
							String correo = viewRegistroSocio.getTextField_correo().getText();
							int genero = viewRegistroSocio.getComboBox_genero().getSelectedIndex();

							if (fotoTemp == null) {
								int random = (int) (Math.random() * 3);
								if (genero == 0) {
									if (random == 0) {
										fotoTemp = ImageIO.read(new File("image/avatar_girl.png"));
									} else if (random == 1) {
										fotoTemp = ImageIO.read(new File("image/avatar_girl_2.png"));
									} else {
										fotoTemp = ImageIO.read(new File("image/avatar_girl_3.png"));
									}
								} else {
									if (random == 0) {
										fotoTemp = ImageIO.read(new File("image/avatar_boy.png"));
									} else if (random == 1) {
										fotoTemp = ImageIO.read(new File("image/avatar_boy_2.png"));
									} else {
										fotoTemp = ImageIO.read(new File("image/avatar_boy_3.png"));
									}
								}
							}
							if (tempHuella != null) {

								boolean respuesta = socioDao.registrarSocio(numeroId, fechaNacimiento, nombre, apellido,
										correo, telefono, genero, fotoTemp, tempHuella, generarCodigo());
								if (respuesta) {
									JOptionPane.showMessageDialog(null, "Registro exitoso");
									viewRegistroSocio.setVisible(false);
									activarHuellaBackground();
									viewRegistroSocio.dispose();

								} else {
									JOptionPane.showMessageDialog(null, "Ocurrio un error registrando un nuevo socio.");
								}
							} else {
								JOptionPane.showMessageDialog(viewRegistroSocio,
										"Aun no ha registrado la huella del nuevo socio.");
							}

						}
					}
				}

			} else {
				JOptionPane.showMessageDialog(null, "El socio ya se encuentra registrado");
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void listadoSociosLlenarTabla(JTable tabla) {
		DefaultTableModel defaultTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Nro. identificacion", "Nombre", "Direcci�n", "Correo electr�nico", "Tel�fono" });

		Object[] columna = new Object[5];
		List<Socio> listSocios = socioDao.listaSocios();
		int numeroRegistros = listSocios.size();

		for (int i = 0; i < numeroRegistros; i++) {
			columna[0] = listSocios.get(i).getIdentificacion();
			columna[1] = listSocios.get(i).getNombreCompleto();
			columna[2] = listSocios.get(i).getDireccion();
			columna[3] = listSocios.get(i).getCorreo();
			columna[4] = listSocios.get(i).getTelefono();
			defaultTableModel.addRow(columna);
		}
		tabla.setModel(defaultTableModel);
		tabla.repaint();

	}

	public void listadoCumpleaniosLlenarTabla(JTable tableSocios) {

		DefaultTableModel defaultTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Nro. identificacion", "Nombre", "Fecha de cumplea�os" });

		Object[] columna = new Object[3];
		List<Socio> listSocios = socioDao.sociosCumpleaniosMes();
		int numeroRegistros = listSocios.size();

		for (int i = 0; i < numeroRegistros; i++) {
			columna[0] = listSocios.get(i).getIdentificacion();
			columna[1] = listSocios.get(i).getNombreCompleto();

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(listSocios.get(i).getFechaNacimiento());
			int mesTemp = calendar.get(Calendar.MONTH) + 1;
			String mes = "";
			if (mesTemp == 1) {
				mes = "Enero";
			} else if (mesTemp == 2) {
				mes = "Febrero";
			} else if (mesTemp == 3) {
				mes = "Marzo";
			} else if (mesTemp == 4) {
				mes = "Abril";
			} else if (mesTemp == 5) {
				mes = "Mayo";
			} else if (mesTemp == 6) {
				mes = "Junio";
			} else if (mesTemp == 7) {
				mes = "Julio";
			} else if (mesTemp == 8) {
				mes = "Agosto";
			} else if (mesTemp == 9) {
				mes = "Septiembre";
			} else if (mesTemp == 10) {
				mes = "Octubre";
			} else if (mesTemp == 11) {
				mes = "Noviembre";
			} else if (mesTemp == 12) {
				mes = "Diciembre";
			}

			columna[2] = calendar.get(Calendar.DAY_OF_MONTH) + " de " + mes;
			defaultTableModel.addRow(columna);
		}
		tableSocios.setModel(defaultTableModel);
		tableSocios.repaint();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		if (viewAsignarMembresia != null) {
			if (e.getSource() == viewAsignarMembresia.getComboBoxMembresia()) {

				try {
					membresiaTemp = (Membresia) viewAsignarMembresia.getComboBoxMembresia().getSelectedItem();
					viewAsignarMembresia.getLabelPrecioMembresia()
							.setText("$" + NumberFormat.getNumberInstance().format(membresiaTemp.getValor()));
					viewAsignarMembresia.getLabelResumenNombreMembresia().setText(membresiaTemp.getNombre());

					viewAsignarMembresia.getLabelDuracionMembresia()
							.setText(membresiaTemp.getDuracion() + " " + membresiaTemp.getDuracionValor().getNombre());
					viewAsignarMembresia.getDateChooserFin().setDate(membresiaTemp.getFechaFinal());
					viewAsignarMembresia.getLabelDiasPermitidos().setText(membresiaTemp.getDias());
					viewAsignarMembresia.getLabelHorarioPermitido().setText(membresiaTemp.getHorarioPermitido());
					if (membresiaTemp.getCantidad_visitas_dia() == -1) {
						viewAsignarMembresia.getLabelVisitasPorDia().setText("Sin limite");
					} else {
						viewAsignarMembresia.getLabelVisitasPorDia()
								.setText(membresiaTemp.getCantidad_visitas_dia() + "");
					}
					viewAsignarMembresia.getLblResumenPrecioMembresia()
							.setText("$" + NumberFormat.getNumberInstance().format(membresiaTemp.getValor()));
					viewAsignarMembresia.getLabelResumenSubtotal()
							.setText("$" + NumberFormat.getNumberInstance().format(membresiaTemp.getValor()));
					viewAsignarMembresia.getLabelResumenDuracion().setText(membresiaTemp.getTiempoDuracion());
					int descuento = Integer.parseInt(viewAsignarMembresia.getTextFieldDescuento().getText());
					int valor = membresiaTemp.getValor();
					int total = valor - descuento;
					NumberFormat format = NumberFormat.getInstance();
					viewAsignarMembresia.getLabelResumenCostoInscripcion().setText("$" + format.format(descuento));
					viewAsignarMembresia.getLabelResumenTotal().setText("$" + format.format(total));
				} catch (Exception error) {

				}
			}
		}
	}

	public String generarCodigo() {

		int cantSocios = socioDao.contarSocios() + 1;
		String codigo = cantSocios + "";
		if (codigo.length() == 1) {
			codigo = "000" + codigo;
		} else if (codigo.length() == 2) {
			codigo = "00" + codigo;
		} else if (codigo.length() == 3) {
			codigo = "0" + codigo;
		}
		viewRegistroSocio.getTextFieldCodigo().setText(codigo);
		return codigo;
	}

	public byte[] getTempHuella() {
		return tempHuella;
	}

	public void setTempHuella(byte[] tempHuella) {
		this.tempHuella = tempHuella;
	}

	public HuellaInit getHuellaInit() {
		return huellaInit;
	}

	public void setHuellaInit(HuellaInit huellaInit) {
		this.huellaInit = huellaInit;
		desactivarHuellaBackground();
	}

	public void activarHuellaBackground() {
		huellaInit.start();
	}

	public void desactivarHuellaBackground() {
		huellaInit.stop();
	}

}

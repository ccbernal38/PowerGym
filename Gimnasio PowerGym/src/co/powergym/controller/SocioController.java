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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
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

import co.powergym.dao.AsistenciaDao;
import co.powergym.dao.MembresiaDao;
import co.powergym.dao.MembresiaSocioDao;
import co.powergym.dao.SocioDao;
import co.powergym.model.Asistencia;
import co.powergym.model.Membresia;
import co.powergym.model.MembresiaSocio;
import co.powergym.model.Socio;
import co.powergym.view.socio.SocioAsignarMembresiaView;
import co.powergym.view.socio.SocioBusquedaView;
import co.powergym.view.socio.SocioConsultaEntradaView;
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
	private SocioConsultaEntradaView viewConsultarEntrada;
	private BufferedImage fotoTemp;
	private SocioAsignarMembresiaView viewAsignarMembresia;
	private byte[] tempHuella;

	public SocioController(SocioRegistroView viewRegistroSocio, SocioBusquedaView viewBusquedaSocio,
			SocioListadoView socioListadoView, SocioCumpleaniosListadoView cumpleaniosListadoView,
			SocioConsultaEntradaView consultaEntradaView, SocioAsignarMembresiaView asignarMembresiaView) {
		this.socioDao = new SocioDao();
		this.membresiaDao = new MembresiaDao();
		this.membresiaSocioDao = new MembresiaSocioDao();

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
		if (consultaEntradaView != null) {
			initConsultarEntrada(consultaEntradaView);
		}
	}

	public void initAsignarMembresia(SocioAsignarMembresiaView asignarMembresiaView, String identificacion) {
		this.viewAsignarMembresia = asignarMembresiaView;
		cargarDatosAsignarMembresia(identificacion);
		this.viewAsignarMembresia.setLocationRelativeTo(viewBusquedaSocio);
		this.viewAsignarMembresia.setVisible(true);
	}

	private void cargarDatosAsignarMembresia(String identificacion) {
		List<Membresia> membresias = membresiaDao.listaMembresia();
		JComboBox comboboxMembresias = viewAsignarMembresia.getComboBoxMembresia();
		comboboxMembresias.addItem("----");
		for (Membresia membresia : membresias) {
			comboboxMembresias.addItem(membresia);
		}
		comboboxMembresias.addItemListener(this);
		viewAsignarMembresia.getCheckboxInscripcion().addItemListener(this);
		viewAsignarMembresia.getTextFieldValorInscripcion().getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				actualizarTotal();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				actualizarTotal();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				actualizarTotal();
			}
		});
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
					int dia = (int) viewAsignarMembresia.getComboBoxDia().getSelectedItem();
					int mes = viewAsignarMembresia.getComboBoxMes().getSelectedIndex();
					Calendar calendar = Calendar.getInstance();
					calendar.set(calendar.get(Calendar.YEAR), mes, dia);
					Date date = new Date(calendar.get(Calendar.YEAR) - 1900, mes, dia);
					boolean renovar = viewAsignarMembresia.getRdbtnSi().isSelected();
					boolean respuesta = membresiaSocioDao.registrarMembresiaSocio(membresia.getId(), socio.getId(),
							date, renovar);
					if (respuesta == true) {
						JOptionPane.showMessageDialog(viewAsignarMembresia,
								"Se ha asignado una nueva membresia al socio.");
						viewAsignarMembresia.setVisible(false);
						viewAsignarMembresia.dispose();
					} else {
						JOptionPane.showMessageDialog(viewAsignarMembresia,
								"Ha ocurrido un error asignando una nueva membresia al socio.");
						viewAsignarMembresia.setVisible(false);
						viewAsignarMembresia.dispose();
					}
				}
			}
		});
		JComboBox<String> comboBoxMeses = viewAsignarMembresia.getComboBoxMes();
		comboBoxMeses.addItem("Enero");
		comboBoxMeses.addItem("Febrero");
		comboBoxMeses.addItem("Marzo");
		comboBoxMeses.addItem("Abril");
		comboBoxMeses.addItem("Mayo");
		comboBoxMeses.addItem("Junio");
		comboBoxMeses.addItem("Julio");
		comboBoxMeses.addItem("Agosto");
		comboBoxMeses.addItem("Septiembre");
		comboBoxMeses.addItem("Octubre");
		comboBoxMeses.addItem("Noviembre");
		comboBoxMeses.addItem("Diciembre");
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
	}

	public void initBusquedaSocio(SocioBusquedaView socioBusquedaView) {
		this.viewBusquedaSocio = socioBusquedaView;
		this.viewBusquedaSocio.btnBuscar.addActionListener(this);
		this.viewBusquedaSocio.getBtnAgregarMembresia().addActionListener(this);
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

	public void initConsultarEntrada(SocioConsultaEntradaView consultaEntradaView) {
		this.viewConsultarEntrada = consultaEntradaView;
		this.viewConsultarEntrada.setVisible(true);
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
					llenarTablaHistorico(socio.getId());
					llenarTablaAsistencia(socio.getId());
				} else {
					JOptionPane.showMessageDialog(null, "No se encontró un socio con ese número de identificación, "
							+ "por favor verifique e intente de nuevo");
				}
			}
			if (e.getSource() == viewBusquedaSocio.getBtnAgregarMembresia()) {
				String identificacion = viewBusquedaSocio.getTextField_identidad().getText();
				initAsignarMembresia(new SocioAsignarMembresiaView(), identificacion);
			}
		}
	}

	private void llenarTablaAsistencia(int id) {
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

	private void llenarTablaHistorico(int id) {
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

	private void registroSocio() {
		try {
			String numeroId = viewRegistroSocio.getTextField_identificacion().getText();
			Socio socio = socioDao.buscarSocio(numeroId);
			if (socio == null) {
				String primerNombre = viewRegistroSocio.getTextField_primerNombre().getText();

				if (primerNombre == null || primerNombre.equals("")) {
					JOptionPane.showMessageDialog(null, "El campo primer nombre no puede estar vacio.");
				} else {
					String segundoNombre = viewRegistroSocio.getTextField_segundoNombre().getText();
					String primerApellido = viewRegistroSocio.getTextField_primerApellido().getText();
					if (primerApellido == null || primerApellido.equals("")) {
						JOptionPane.showMessageDialog(null, "El campo primer apellido no puede estar vacio.");
					} else {
						String segundoApellido = viewRegistroSocio.getTextField_segundoApellido().getText();
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
								int random =(int) (Math.random() * 3);
								if(genero == 0) {
									if(random == 0) {
										fotoTemp = ImageIO.read(new File("image/avatar_girl.png"));		
									}else if(random == 1) {
										fotoTemp = ImageIO.read(new File("image/avatar_girl_2.png"));		
									}else {
										fotoTemp = ImageIO.read(new File("image/avatar_girl_3.png"));
									}
								}else {
									if(random == 0) {
										fotoTemp = ImageIO.read(new File("image/avatar_boy.png"));		
									}else if(random == 1) {
										fotoTemp = ImageIO.read(new File("image/avatar_boy_2.png"));		
									}else {
										fotoTemp = ImageIO.read(new File("image/avatar_boy_3.png"));
									}
								}
								
							}
							if (tempHuella != null) {
								boolean respuesta = socioDao.registrarSocio(numeroId, fechaNacimiento, primerNombre,
										segundoNombre, primerApellido, segundoApellido, correo, telefono, genero,
										fotoTemp, tempHuella);
								if (respuesta) {
									JOptionPane.showMessageDialog(null, "Registro exitoso");
									viewRegistroSocio.setVisible(false);
									viewRegistroSocio = null;
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
				new String[] { "Nro. identificacion", "Nombre", "Dirección", "Correo electrónico", "Teléfono" });

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
				new String[] { "Nro. identificacion", "Nombre", "Fecha de cumpleaños" });

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
					Membresia membresia = (Membresia) viewAsignarMembresia.getComboBoxMembresia().getSelectedItem();
					viewAsignarMembresia.getLabelPrecioMembresia()
							.setText("$" + NumberFormat.getNumberInstance().format(membresia.getValor()));
					viewAsignarMembresia.getLabelResumenNombreMembresia().setText(membresia.getNombre());

					viewAsignarMembresia.getLabelDuracionMembresia()
							.setText(membresia.getDuracion() + " " + membresia.getDuracionValor().getNombre());

					viewAsignarMembresia.getLabelDiasPermitidos().setText(membresia.getDias());
					viewAsignarMembresia.getLabelHorarioPermitido().setText(membresia.getHorarioPermitido());
					if (membresia.getCantidad_visitas_dia() == -1) {
						viewAsignarMembresia.getLabelVisitasPorDia().setText("Sin limite");
					} else {
						viewAsignarMembresia.getLabelVisitasPorDia().setText(membresia.getCantidad_visitas_dia() + "");
					}
					viewAsignarMembresia.getLblResumenPrecioMembresia()
							.setText("$" + NumberFormat.getNumberInstance().format(membresia.getValor()));
					viewAsignarMembresia.getLabelResumenSubtotal()
							.setText("$" + NumberFormat.getNumberInstance().format(membresia.getValor()));
					if (viewAsignarMembresia.getCheckboxInscripcion().getState() == true) {
						viewAsignarMembresia.getTextFieldValorInscripcion().setEnabled(true);
						String costo = viewAsignarMembresia.getTextFieldValorInscripcion().getText();
						if (!costo.equals("") || !costo.matches("[a-zA-Z]+")) {
							int costoIncripcion = Integer.parseInt(costo);
							viewAsignarMembresia.getLabelResumenCostoInscripcion()
									.setText("$" + NumberFormat.getNumberInstance().format(costoIncripcion));
							viewAsignarMembresia.getLabelResumenTotal().setText("$"
									+ NumberFormat.getNumberInstance().format(membresia.getValor() + costoIncripcion));
						}
					} else {
						viewAsignarMembresia.getTextFieldValorInscripcion().setEnabled(false);
						viewAsignarMembresia.getLabelResumenCostoInscripcion().setText("$0");
						viewAsignarMembresia.getLabelResumenTotal().setText("$" + membresia.getValor());
					}

					viewAsignarMembresia.getLabelResumenDuracion().setText(membresia.getTiempoDuracion());

				} catch (Exception error) {

				}
			}
			if (viewAsignarMembresia.getCheckboxInscripcion() == e.getSource()) {
				try {
					actualizarTotal();
				} catch (Exception error) {

				}
			}
		}

	}

	private void actualizarTotal() {
		if (viewAsignarMembresia.getComboBoxMembresia().getSelectedItem() instanceof Membresia) {
			Membresia membresia = (Membresia) viewAsignarMembresia.getComboBoxMembresia().getSelectedItem();

			if (viewAsignarMembresia.getCheckboxInscripcion().getState() == true) {
				viewAsignarMembresia.getTextFieldValorInscripcion().setEnabled(true);
				String costo = viewAsignarMembresia.getTextFieldValorInscripcion().getText();
				if (!costo.equals("") || !costo.matches("[a-zA-Z]+")) {
					try {
						int costoIncripcion = Integer.parseInt(costo);
						viewAsignarMembresia.getLabelResumenCostoInscripcion()
								.setText("$" + NumberFormat.getNumberInstance().format(costoIncripcion));
						viewAsignarMembresia.getLabelResumenTotal().setText(
								"$" + NumberFormat.getNumberInstance().format(membresia.getValor() + costoIncripcion));
					} catch (Exception error) {

					}
				}
			} else {
				viewAsignarMembresia.getTextFieldValorInscripcion().setEnabled(false);
				viewAsignarMembresia.getLabelResumenCostoInscripcion().setText("$0");
				viewAsignarMembresia.getLabelResumenTotal()
						.setText("$" + NumberFormat.getNumberInstance().format(membresia.getValor()));
			}
		}

	}

	public byte[] getTempHuella() {
		return tempHuella;
	}

	public void setTempHuella(byte[] tempHuella) {
		this.tempHuella = tempHuella;
	}

}

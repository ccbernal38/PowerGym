package co.powergym.controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.event.DPFPDataAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPDataEvent;
import com.digitalpersona.onetouch.capture.event.DPFPErrorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPErrorEvent;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import com.digitalpersona.onetouch.capture.event.DPFPSensorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPSensorEvent;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.processing.DPFPFeatureExtraction;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;
import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;

import co.powergym.dao.AsistenciaDao;
import co.powergym.dao.MembresiaDao;
import co.powergym.dao.SocioDao;
import co.powergym.model.Conexion;
import co.powergym.model.DiaSemana;
import co.powergym.model.Horario;
import co.powergym.model.Membresia;
import co.powergym.model.Socio;
import co.powergym.utils.Constantes;
import co.powergym.utils.Preferencias;
import co.powergym.view.socio.SocioRegistrarEntradaView;
import co.powergym.view.socio.SocioRegistroHuella;
import jssc.SerialPortException;

public class HuellaController implements ActionListener {

	private DPFPCapture Lector;
	private DPFPEnrollment Reclutador;
	private DPFPVerification Verificador;
	private DPFPTemplate template;
	public static String TEMPLATE_PROPERTY = "template";
	public DPFPFeatureSet featuresinscripcion;
	public DPFPFeatureSet featuresverificacion;
	private SocioRegistroHuella socioRegistroHuella;
	private Conexion con;

	private SocioController socioController;
	private SocioRegistrarEntradaView viewRegistrarEntrada;
	private SocioDao socioDao;
	private AsistenciaDao asistenciaDao;

	public HuellaController(SocioRegistroHuella socioRegistroHuella, SocioRegistrarEntradaView registrarEntradaView,
			SocioController socioController) {
		con = new Conexion();
		socioDao = new SocioDao();
		asistenciaDao = new AsistenciaDao();

		this.socioController = socioController;

		if (socioRegistroHuella != null) {

			this.socioRegistroHuella = socioRegistroHuella;
			this.socioRegistroHuella.getBtnGuardar().addActionListener(this);
			this.socioRegistroHuella.getBtnSalir().addActionListener(this);
			this.socioRegistroHuella.setVisible(true);
			this.socioRegistroHuella.setLocationRelativeTo(null);
		}
		if (registrarEntradaView != null) {
			initRegistrarEntrada(registrarEntradaView);
		}
		if (Lector == null) {
			Lector = DPFPGlobal.getCaptureFactory().createCapture();
		}
		if (Verificador == null) {
			Verificador = DPFPGlobal.getVerificationFactory().createVerification();
		}
		if (Reclutador == null) {
			Reclutador = DPFPGlobal.getEnrollmentFactory().createEnrollment();
		}
		initLector();

	}

	private void initRegistrarEntrada(SocioRegistrarEntradaView registrarEntradaView) {
		this.viewRegistrarEntrada = registrarEntradaView;
		this.viewRegistrarEntrada.setVisible(true);
		this.viewRegistrarEntrada.setLocationRelativeTo(null);
		this.viewRegistrarEntrada.getBtnIdentificar().addActionListener(this);
		this.viewRegistrarEntrada.getBtnCancelar().addActionListener(this);
		this.viewRegistrarEntrada.getBtnVerificar().addActionListener(this);
	}

	protected void Iniciar() {
		Lector.addDataListener(new DPFPDataAdapter() {
			@Override
			public void dataAcquired(final DPFPDataEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						enviarTexto("La Huella Digital ha sido Capturada");
						ProcesarCaptura(e.getSample());
						if (viewRegistrarEntrada != null) {
							try {
								identificarHuella();
								Reclutador.clear();
							} catch (IOException ex) {
								System.out.println(ex.getMessage());
							}
						}
					}
				});
			}
		});

		Lector.addReaderStatusListener(new DPFPReaderStatusAdapter() {
			@Override
			public void readerConnected(final DPFPReaderStatusEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						enviarTexto("El Sensor de Huella Digital esta Activado o Conectado");
					}
				});
			}

			@Override
			public void readerDisconnected(final DPFPReaderStatusEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						enviarTexto("El Sensor de Huella Digital esta Desactivado o no Conecatado");
					}
				});
			}
		});

		Lector.addSensorListener(new DPFPSensorAdapter() {
			@Override
			public void fingerTouched(final DPFPSensorEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						enviarTexto("El dedo ha sido colocado sobre el Lector de Huella");
					}
				});
			}

			@Override
			public void fingerGone(final DPFPSensorEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						enviarTexto("El dedo ha sido quitado del Lector de Huella");
					}
				});
			}
		});

		Lector.addErrorListener(new DPFPErrorAdapter() {
			public void errorReader(final DPFPErrorEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						enviarTexto("Error: " + e.getError());
					}
				});
			}
		});

		Lector.addErrorListener(new DPFPErrorAdapter() {

			public void errorReader(final DPFPErrorEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						enviarTexto("Error: " + e.getError());
					}
				});
			}
		});
	}

	public DPFPFeatureSet extraerCaracteristicas(DPFPSample sample, DPFPDataPurpose purpose) {
		DPFPFeatureExtraction extractor = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
		try {
			return extractor.createFeatureSet(sample, purpose);
		} catch (DPFPImageQualityException e) {
			return null;
		}
	}

	public Image CrearImagenHuella(DPFPSample sample) {
		return DPFPGlobal.getSampleConversionFactory().createImage(sample);
	}

	public void DibujarHuella(Image image, int huella) {

		if (socioRegistroHuella != null) {
			if (huella == 1) {
				socioRegistroHuella.getLblImagenHuella1().setIcon(
						new ImageIcon(image.getScaledInstance(socioRegistroHuella.getLblImagenHuella1().getWidth(),
								socioRegistroHuella.getLblImagenHuella1().getHeight(), Image.SCALE_DEFAULT)));
				socioRegistroHuella.repaint();
			} else if (huella == 2) {
				socioRegistroHuella.getLblImagenHuella2().setIcon(
						new ImageIcon(image.getScaledInstance(socioRegistroHuella.getLblImagenHuella2().getWidth(),
								socioRegistroHuella.getLblImagenHuella2().getHeight(), Image.SCALE_DEFAULT)));
				socioRegistroHuella.repaint();
			} else if (huella == 3) {
				socioRegistroHuella.getLblImagenHuella3().setIcon(
						new ImageIcon(image.getScaledInstance(socioRegistroHuella.getLblImagenHuella3().getWidth(),
								socioRegistroHuella.getLblImagenHuella3().getHeight(), Image.SCALE_DEFAULT)));
				socioRegistroHuella.repaint();
			} else {
				socioRegistroHuella.getLblImagenHuella4().setIcon(
						new ImageIcon(image.getScaledInstance(socioRegistroHuella.getLblImagenHuella4().getWidth(),
								socioRegistroHuella.getLblImagenHuella4().getHeight(), Image.SCALE_DEFAULT)));
				socioRegistroHuella.repaint();
			}
		}
		if (viewRegistrarEntrada != null) {
			viewRegistrarEntrada.getLblHuella()
					.setIcon(new ImageIcon(image.getScaledInstance(viewRegistrarEntrada.getLblHuella().getWidth(),
							viewRegistrarEntrada.getLblHuella().getHeight(), Image.SCALE_DEFAULT)));
		}

	}

	public void EstadoHuellas() {
		enviarTexto("Muestra de Huellas Necesarias para Guardar Template " + Reclutador.getFeaturesNeeded());
	}

	public void enviarTexto(String string) {
		if (socioRegistroHuella != null) {
			socioRegistroHuella.getTextArea().append(string + "\n");
		}
		if (viewRegistrarEntrada != null) {
			viewRegistrarEntrada.getTextArea().append(string + "\n");
		}

	}

	public void start() {
		try {
			if (!Lector.isStarted()) {
				Lector.stopCapture();
				Lector.startCapture();
				enviarTexto("Utilizando el Lector de Huella Dactilar ");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void stop() {
		Lector.stopCapture();
		enviarTexto("No se est� usando el Lector de Huella Dactilar ");
	}

	public DPFPTemplate getTemplate() {
		return this.template;
	}

	public void setTemplate(DPFPTemplate template) {
		DPFPTemplate old = this.template;
		this.template = template;
		if (socioRegistroHuella != null) {
			socioRegistroHuella.callFirePropertyChange(TEMPLATE_PROPERTY, old, template);
		} else if (viewRegistrarEntrada != null) {
			viewRegistrarEntrada.callFirePropertyChange(TEMPLATE_PROPERTY, old, template);
		}

	}

	public void ProcesarCaptura(DPFPSample sample) {
		featuresinscripcion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);

		featuresverificacion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);

		if (featuresinscripcion != null)
			try {
				System.out.println("Las Caracteristicas de la Huella han sido creada");
				Reclutador.addFeatures(featuresinscripcion);
				Image image = CrearImagenHuella(sample);
				if (Reclutador.getFeaturesNeeded() == 3) {
					DibujarHuella(image, 1);
				} else if (Reclutador.getFeaturesNeeded() == 2) {
					DibujarHuella(image, 2);
				} else if (Reclutador.getFeaturesNeeded() == 1) {
					DibujarHuella(image, 3);
				} else {
					DibujarHuella(image, 4);
				}

			} catch (DPFPImageQualityException ex) {
				System.err.println("Error: " + ex.getMessage());
			}

			finally {
				EstadoHuellas();

				switch (Reclutador.getTemplateStatus()) {
				case TEMPLATE_STATUS_READY:
					stop();
					setTemplate(Reclutador.getTemplate());
					enviarTexto("La Plantilla de la Huella ha Sido Creada, ya puede Verificarla o Identificarla");
					socioRegistroHuella.getBtnGuardar().setEnabled(true);
					socioRegistroHuella.getBtnGuardar().grabFocus();

					break;

				case TEMPLATE_STATUS_FAILED: // informe de fallas y reiniciar la captura de huellas
					Reclutador.clear();
					stop();
					EstadoHuellas();
					setTemplate(null);
					JOptionPane.showMessageDialog(socioRegistroHuella,
							"La Plantilla de la Huella no pudo ser creada, Repita el Proceso",
							"Inscripcion de Huellas Dactilares", JOptionPane.ERROR_MESSAGE);
					start();
					break;
				}
			}
	}

	public void guardarHuella() {
		ByteArrayInputStream datosHuella = new ByteArrayInputStream(template.serialize());
		Integer tamanoHuella = template.serialize().length;

		try {
			socioController.setTempHuella(read(datosHuella));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		socioRegistroHuella.setVisible(false);
	}

	public byte[] read(ByteArrayInputStream bais) throws IOException {
		byte[] array = new byte[bais.available()];
		bais.read(array);

		return array;
	}

	public void guardarHuellaDB() {
		// Obtiene los datos del template de la huella actual
		ByteArrayInputStream datosHuella = new ByteArrayInputStream(template.serialize());
		Integer tamanoHuella = template.serialize().length;

		// Pregunta el nombre de la persona a la cual corresponde dicha huella
		String nombre = JOptionPane.showInputDialog("Nombre:");
		try {
			// Establece los valores para la sentencia SQL
			Connection c = con.getConexion();
			PreparedStatement guardarStmt = c.prepareStatement("INSERT INTO huella(huenombre, huehuella) values(?,?)");
			guardarStmt.setString(1, nombre);
			guardarStmt.setBinaryStream(2, datosHuella, tamanoHuella);
			// Ejecuta la sentencia
			guardarStmt.execute();
			guardarStmt.close();
			JOptionPane.showMessageDialog(null, "Huella Guardada Correctamente");
			con.desconectar();
			socioRegistroHuella.getBtnGuardar().setEnabled(false);
		} catch (SQLException ex) {
			// Si ocurre un error lo indica en la consola
			System.err.println("Error al guardar los datos de la huella.");
		} finally {
			con.desconectar();
		}
	}

	public void identificarHuella() throws IOException {
		List<Socio> socios = socioDao.listaSocios();
		for (Socio socio : socios) {
			DPFPTemplate referenceTemplate = DPFPGlobal.getTemplateFactory().createTemplate(socio.getHuella());
			setTemplate(referenceTemplate);
			DPFPVerificationResult result = Verificador.verify(featuresverificacion, getTemplate());

			if (result.isVerified()) {
				JOptionPane.showMessageDialog(null, "Las huella capturada es de " + socio.getNombreCompleto(),
						"Verificacion de Huella", JOptionPane.INFORMATION_MESSAGE);
				initConsultaEntrada(socio);
				return;
			}
		}
		JOptionPane.showMessageDialog(null, "No existe ning�n registro que coincida con la huella",
				"Verificacion de Huella", JOptionPane.ERROR_MESSAGE);
		setTemplate(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (socioRegistroHuella != null && e.getSource() == socioRegistroHuella.getBtnGuardar()) {
			guardarHuella();
			Reclutador.clear();
			stop();
			initLector();

		}

		if (viewRegistrarEntrada != null && e.getSource() == viewRegistrarEntrada.getBtnIdentificar()) {

		}

		if (socioRegistroHuella != null && e.getSource() == socioRegistroHuella.getBtnSalir()) {

		}
		if (viewRegistrarEntrada != null && e.getSource() == viewRegistrarEntrada.getBtnCancelar()) {
			viewRegistrarEntrada.setVisible(false);
		}
		if (viewRegistrarEntrada != null && e.getSource() == viewRegistrarEntrada.getBtnVerificar()) {
			String id = viewRegistrarEntrada.getTextFieldIdentificacion().getText();

			Socio socio = socioDao.buscarSocio(id);
			if (socio != null) {
				initConsultaEntrada(socio);
			} else {
				JOptionPane.showMessageDialog(viewRegistrarEntrada,
						"No se encontr� un socio con este numero de identificaci�n.");
			}

		}

	}

	private void initConsultaEntrada(Socio socio) {
		MembresiaDao membresiaDao = new MembresiaDao();
		Membresia membresia = membresiaDao.verificarEntradaMembresia(socio.getId());

		if (verificarDia(membresia.getDiasPermitidos())) {
			if (verificarHora(membresia.getHorario())) {
				asistenciaDao.registrarAsistencia(socio.getId());
				abrirTorniquete();
				viewRegistrarEntrada.setVisible(false);
				viewRegistrarEntrada.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "El socio no tiene permitido el ingreso en este horario");
			}
		} else {
			JOptionPane.showMessageDialog(null, "El socio no tiene permitido hoy el ingreso.");
		}

	}

	private boolean verificarHora(List<Horario> horarios) {
		Calendar horaActual = Calendar.getInstance();
		int hora = horaActual.get(Calendar.HOUR_OF_DAY);
		int minutos = horaActual.get(Calendar.MINUTE);
		for (Horario horario : horarios) {
			Calendar horarioInicio = Calendar.getInstance();
			horarioInicio.setTime(horario.getHoraInicio());
			Calendar horarioFin = Calendar.getInstance();
			horarioFin.setTime(horario.getHoraFin());

			int horaInicio = horarioInicio.get(Calendar.HOUR_OF_DAY);
			int minutoInicio = horarioInicio.get(Calendar.MINUTE);

			int horaFin = horarioFin.get(Calendar.HOUR_OF_DAY);
			int minutoFin = horarioFin.get(Calendar.MINUTE);

			if (horaInicio <= hora && hora <= horaFin) {
				if (minutoInicio <= minutos) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean verificarDia(List<DiaSemana> diasPermitidos) {
		Calendar date = Calendar.getInstance();
		for (DiaSemana diaSemana : diasPermitidos) {
			int dia = date.get(Calendar.DAY_OF_WEEK);
			if (diaSemana.getId() == dia) {
				return true;
			}
		}
		return false;
	}

	public void initLector() {
		Iniciar();
		start();
		EstadoHuellas();
		if (socioRegistroHuella != null) {
			socioRegistroHuella.getLblImagenHuella1().setIcon(null);
			socioRegistroHuella.getLblImagenHuella2().setIcon(null);
			socioRegistroHuella.getLblImagenHuella3().setIcon(null);
			socioRegistroHuella.getLblImagenHuella4().setIcon(null);
		}
		if (viewRegistrarEntrada != null) {
			viewRegistrarEntrada.getLblHuella().setIcon(null);
		}

	}

	public void abrirTorniquete() {
		PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
		System.out.println("Mensaje Inicio");
		JOptionPane pane = new JOptionPane("Espere, abriendo puerta......", JOptionPane.INFORMATION_MESSAGE,
				JOptionPane.DEFAULT_OPTION, null, new Object[] {}, null);
		JDialog dialog = pane.createDialog(null, "Entrada");

		new Thread(new Runnable() {
			public void run() {
				try {
					String puerto = Preferencias.obtenerPreferencia(Constantes.PUERTO);
					if (puerto.equals("-1")) {
						puerto = "COM5";
					}
					// Se inicia la comunicaci�n con el Puerto Serie
					System.out.println("Arduino inicio");
					ino.arduinoTX(puerto, 9600);
					TimeUnit.SECONDS.sleep(2);
					ino.sendData("1");
					System.out.println("Arduino Fin");
					ino.killArduinoConnection();
				} catch (ArduinoException ex) {
					Logger.getLogger(HuellaController.class.getName()).log(Level.SEVERE, null, ex);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SerialPortException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(2000);
					dialog.dispose();

				} catch (Throwable th) {
					System.out.println("setValidComboIndex(): error :\n" + th.getMessage());
				}
			}
		}).start();

		dialog.setVisible(true);
		System.out.println("Mensaje Fin");

	}

	public void mensajeTorniquete() {

	}
}

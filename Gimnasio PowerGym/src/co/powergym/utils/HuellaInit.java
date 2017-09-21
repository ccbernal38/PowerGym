package co.powergym.utils;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
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

import co.powergym.controller.HuellaController;
import co.powergym.dao.AsistenciaDao;
import co.powergym.dao.MembresiaDao;
import co.powergym.dao.SocioDao;
import co.powergym.model.DiaSemana;
import co.powergym.model.Horario;
import co.powergym.model.Membresia;
import co.powergym.model.Socio;
import co.powergym.view.InitView;
import jssc.SerialPortException;

public class HuellaInit {

	private DPFPCapture Lector;
	private DPFPEnrollment Reclutador;
	private DPFPVerification Verificador;
	private DPFPTemplate template;
	public static String TEMPLATE_PROPERTY = "template";
	public DPFPFeatureSet featuresinscripcion;
	public DPFPFeatureSet featuresverificacion;

	private InitView initView;
	private SocioDao socioDao;
	private AsistenciaDao asistenciaDao;

	public HuellaInit(InitView initView) {
		socioDao = new SocioDao();
		asistenciaDao = new AsistenciaDao();
		this.initView = initView;

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

	public void initLector() {
		Iniciar();
		start();
		EstadoHuellas();
		if (initView != null) {
			initView.getLblHuella().setIcon(null);
		}

	}

	protected void Iniciar() {
		Lector.addDataListener(new DPFPDataAdapter() {
			@Override
			public void dataAcquired(final DPFPDataEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						enviarTexto("La Huella Digital ha sido Capturada");
						ProcesarCaptura(e.getSample());
						if (initView != null) {
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
						enviarTexto("El Sensor de Huella Digital esta Desactivado o no Conectado");
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

		if (initView != null) {
			initView.getLblHuella().setIcon(new ImageIcon(image.getScaledInstance(initView.getLblHuella().getWidth(),
					initView.getLblHuella().getHeight(), Image.SCALE_DEFAULT)));
		}

	}

	public void EstadoHuellas() {
		//enviarTexto("Muestra de Huellas Necesarias para Guardar Template " + Reclutador.getFeaturesNeeded());
	}

	public void enviarTexto(String string) {

		if (initView != null) {
			initView.getTextArea().append(string + "\n");
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
		enviarTexto("No se está usando el Lector de Huella Dactilar ");
	}

	public DPFPTemplate getTemplate() {
		return this.template;
	}

	public void setTemplate(DPFPTemplate template) {
		DPFPTemplate old = this.template;
		this.template = template;
		if (initView != null) {
			initView.callFirePropertyChange(TEMPLATE_PROPERTY, old, template);
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
					break;

				case TEMPLATE_STATUS_FAILED: // informe de fallas y reiniciar la captura de huellas
					Reclutador.clear();
					stop();
					EstadoHuellas();
					setTemplate(null);

					start();
					break;
				}
			}
	}

	public byte[] read(ByteArrayInputStream bais) throws IOException {
		byte[] array = new byte[bais.available()];
		bais.read(array);

		return array;
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
		JOptionPane.showMessageDialog(null, "No existe ningún registro que coincida con la huella",
				"Verificacion de Huella", JOptionPane.ERROR_MESSAGE);
		setTemplate(null);
	}

	public void initConsultaEntrada(Socio socio) {
		MembresiaDao membresiaDao = new MembresiaDao();
		Membresia membresia = membresiaDao.verificarEntradaMembresia(socio.getId());

		if (membresia != null) {
			if(verificarDia(membresia.getDiasPermitidos())) {
				if (verificarHora(membresia.getHorario())) {
					asistenciaDao.registrarAsistencia(socio.getId());
					abrirTorniquete();
					initView.setVisible(false);
					initView.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "El socio no tiene permitido el ingreso en este horario");
				}
			} else {
				JOptionPane.showMessageDialog(null, "El socio no tiene permitido hoy el ingreso.");
			}
		}else {
			JOptionPane.showMessageDialog(null, "El socio no tiene membresias activas.");
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
					// Se inicia la comunicación con el Puerto Serie
					System.out.println("Arduino inicio");
					ino.arduinoTX(puerto, 9600);
					TimeUnit.SECONDS.sleep(2);
					ino.sendData("1");
					System.out.println("Arduino Fin");
					ino.killArduinoConnection();
				} catch (ArduinoException ex) {
					Logger.getLogger(HuellaController.class.getName()).log(Level.SEVERE, null, ex);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (SerialPortException e) {
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

}

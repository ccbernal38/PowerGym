package co.powergym.controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.swing.ImageIcon;
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
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.processing.DPFPFeatureExtraction;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import com.digitalpersona.onetouch.verification.DPFPVerification;

import co.powergym.dao.AsistenciaDao;
import co.powergym.dao.SocioDao;
import co.powergym.model.DiaSemana;
import co.powergym.model.Horario;
import co.powergym.utils.HuellaInit;
import co.powergym.view.socio.SocioRegistroHuella;

public class HuellaController implements ActionListener {

	private DPFPCapture lector;
	private DPFPEnrollment reclutador;
	private DPFPVerification verificador;
	private DPFPTemplate template;
	public static String TEMPLATE_PROPERTY = "template";
	public DPFPFeatureSet featuresinscripcion;
	public DPFPFeatureSet featuresverificacion;
	private SocioRegistroHuella socioRegistroHuella;

	private SocioController socioController;
	private SocioDao socioDao;
	private AsistenciaDao asistenciaDao;
	private HuellaInit huella;

	public HuellaController(SocioRegistroHuella socioRegistroHuella, SocioController socioController,
			HuellaInit huellaInit) {
		socioDao = new SocioDao();
		asistenciaDao = new AsistenciaDao();

		huella = huellaInit;
		huellaInit.start();
		lector = huellaInit.getLector();
		if (verificador == null) {
			verificador = DPFPGlobal.getVerificationFactory().createVerification();
		}
		if (reclutador == null) {
			reclutador = DPFPGlobal.getEnrollmentFactory().createEnrollment();
		}
		initLector();
		
		this.socioController = socioController;

		if (socioRegistroHuella != null) {
			this.socioRegistroHuella = socioRegistroHuella;
			this.socioRegistroHuella.getBtnGuardar().addActionListener(this);
			this.socioRegistroHuella.getBtnSalir().addActionListener(this);
			this.socioRegistroHuella.setVisible(true);
			this.socioRegistroHuella.setLocationRelativeTo(null);
			this.socioRegistroHuella.addWindowListener(new WindowListener() {

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

				}

				@Override
				public void windowClosed(WindowEvent e) {

				}

				@Override
				public void windowActivated(WindowEvent e) {
					// TODO Auto-generated method stub

				}
			});
		}

	}

	protected void Iniciar() {
		lector.addDataListener(new DPFPDataAdapter() {
			@Override
			public void dataAcquired(final DPFPDataEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						enviarTexto("La Huella Digital ha sido Capturada");
						ProcesarCaptura(e.getSample());
					}
				});
			}
		});

		lector.addReaderStatusListener(new DPFPReaderStatusAdapter() {
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

		lector.addSensorListener(null);

		lector.addErrorListener(new DPFPErrorAdapter() {
			public void errorReader(final DPFPErrorEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						enviarTexto("Error: " + e.getError());
					}
				});
			}
		});

		lector.addErrorListener(new DPFPErrorAdapter() {

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

	}

	public void EstadoHuellas() {
		enviarTexto("Muestra de Huellas Necesarias para Guardar Template " + reclutador.getFeaturesNeeded());
	}

	public void enviarTexto(String string) {
		if (socioRegistroHuella != null) {
			socioRegistroHuella.getTextArea().append(string + "\n");
		}

	}

	public void start() {
		try {
			if (!lector.isStarted()) {
				lector.stopCapture();
				lector.startCapture();
				enviarTexto("Utilizando el Lector de Huella Dactilar ");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void stop() {
		lector.stopCapture();
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
		}

	}

	public void ProcesarCaptura(DPFPSample sample) {
		featuresinscripcion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);

		featuresverificacion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);

		if (featuresinscripcion != null)
			try {
				System.out.println("Las Caracteristicas de la Huella han sido creada");
				reclutador.addFeatures(featuresinscripcion);
				Image image = CrearImagenHuella(sample);
				if (reclutador.getFeaturesNeeded() == 3) {
					DibujarHuella(image, 1);
				} else if (reclutador.getFeaturesNeeded() == 2) {
					DibujarHuella(image, 2);
				} else if (reclutador.getFeaturesNeeded() == 1) {
					DibujarHuella(image, 3);
				} else {
					DibujarHuella(image, 4);
				}

			} catch (DPFPImageQualityException ex) {
				System.err.println("Error: " + ex.getMessage());
			}

			finally {
				EstadoHuellas();

				switch (reclutador.getTemplateStatus()) {
				case TEMPLATE_STATUS_READY:
					stop();
					setTemplate(reclutador.getTemplate());
					enviarTexto("La Plantilla de la Huella ha Sido Creada, ya puede Verificarla o Identificarla");
					socioRegistroHuella.getBtnGuardar().setEnabled(true);
					socioRegistroHuella.getBtnGuardar().grabFocus();

					break;

				case TEMPLATE_STATUS_FAILED: // informe de fallas y reiniciar la captura de huellas
					reclutador.clear();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (socioRegistroHuella != null && e.getSource() == socioRegistroHuella.getBtnGuardar()) {
			guardarHuella();
			reclutador.clear();
			stop();
			initLector();
		}
		if (socioRegistroHuella != null && e.getSource() == socioRegistroHuella.getBtnSalir()) {

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
	}

	public HuellaInit getHuella() {
		return huella;
	}

	public void setHuella(HuellaInit huella) {
		this.huella = huella;
	}

}

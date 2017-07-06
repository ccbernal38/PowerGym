package co.powergym.mvc;
/**
* @package: Formularios
* @class: CapturaHuella
* @author: Napster2011
* @version: 1.0
*/

/**
* @librerias importadas
* @author: Napster2011
*/
import com.digitalpersona.onetouch.*;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.event.*;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.processing.DPFPFeatureExtraction;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;

import co.powergym.model.Conexion;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class CapturaHuella extends javax.swing.JDialog {
	/**
	 * @function: CapturaHuella
	 * @author: Napster2011
	 * @description: funcion constructora de la clase
	 * @access: public
	 * @return
	 */
	public CapturaHuella() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Imposible modificar el tema visual", "Lookandfeel inv�lido.",
					JOptionPane.ERROR_MESSAGE);
		}
		initComponents();
		txtArea.setEditable(false);
	}

	/**
	 * @function:
	 * @author: Napster2011
	 * @description: Funciones privadas de la clase, generadas automaticamente
	 *               por el sistema
	 * @access: public
	 * @return
	 */

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		panHuellas = new javax.swing.JPanel();
		jPanel1 = new javax.swing.JPanel();
		lblImagenHuella = new javax.swing.JLabel();
		panBtns = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		btnSalir = new javax.swing.JButton();
		btnIdentificar = new javax.swing.JButton();
		btnGuardar = new javax.swing.JButton();
		jPanel4 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		txtArea = new javax.swing.JTextArea();
		jPanel3 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Huellas Dactilares ");
		setResizable(false);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				formWindowClosing(evt);
			}

			public void windowOpened(java.awt.event.WindowEvent evt) {
				formWindowOpened(evt);
			}
		});

		panHuellas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Huella Digital Capturada",
				javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
		panHuellas.setPreferredSize(new java.awt.Dimension(400, 270));
		panHuellas.setLayout(new java.awt.BorderLayout());

		jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
		jPanel1.setLayout(new java.awt.BorderLayout());
		jPanel1.add(lblImagenHuella, java.awt.BorderLayout.CENTER);

		panHuellas.add(jPanel1, java.awt.BorderLayout.CENTER);

		getContentPane().add(panHuellas, java.awt.BorderLayout.NORTH);

		panBtns.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones",
				javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
		panBtns.setPreferredSize(new java.awt.Dimension(400, 190));
		panBtns.setLayout(new java.awt.BorderLayout());

		jPanel2.setPreferredSize(new java.awt.Dimension(366, 90));

		btnSalir.setText("Salir");
		btnSalir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSalirActionPerformed(evt);
			}
		});

		btnIdentificar.setText("Identificar");
		btnIdentificar.setPreferredSize(new java.awt.Dimension(71, 23));
		btnIdentificar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnIdentificarActionPerformed(evt);
			}
		});

		btnGuardar.setText("Guardar");
		btnGuardar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnGuardarActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel2Layout.createSequentialGroup().addGap(61, 61, 61)
										.addComponent(btnIdentificar, javax.swing.GroupLayout.PREFERRED_SIZE, 139,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(26, 26, 26)
										.addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 128,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel2Layout.createSequentialGroup().addGap(149, 149, 149).addComponent(
										btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 128,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(77, Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel2Layout.createSequentialGroup().addGap(11, 11, 11)
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(btnIdentificar, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		panBtns.add(jPanel2, java.awt.BorderLayout.NORTH);

		jPanel4.setLayout(new java.awt.BorderLayout());

		txtArea.setColumns(20);
		txtArea.setFont(new java.awt.Font("Lucida Sans", 1, 10)); // NOI18N
		txtArea.setRows(5);
		jScrollPane1.setViewportView(txtArea);

		jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

		panBtns.add(jPanel4, java.awt.BorderLayout.CENTER);

		jPanel3.setPreferredSize(new java.awt.Dimension(366, 20));

		jLabel1.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("Ingeniero Napster2011");

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel3Layout.createSequentialGroup().addContainerGap(299, Short.MAX_VALUE).addComponent(
								jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
								javax.swing.GroupLayout.PREFERRED_SIZE)));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addComponent(jLabel1)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		panBtns.add(jPanel3, java.awt.BorderLayout.SOUTH);

		getContentPane().add(panBtns, java.awt.BorderLayout.SOUTH);

		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 459) / 2, (screenSize.height - 499) / 2, 459, 499);
	}// </editor-fold>

	private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
	}

	private void btnIdentificarActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			identificarHuella();
			Reclutador.clear();
		} catch (IOException ex) {
			Logger.getLogger(CapturaHuella.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
		guardarHuella();
		Reclutador.clear();
		lblImagenHuella.setIcon(null);
		start();
	}

	private void formWindowOpened(java.awt.event.WindowEvent evt) {
		Iniciar();
		start();
		EstadoHuellas();
		btnGuardar.setEnabled(true);
		btnIdentificar.setEnabled(true);
		btnSalir.grabFocus();
	}

	private void formWindowClosing(java.awt.event.WindowEvent evt) {
		stop();
	}

	/**
	 * @atributos
	 * @author: Napster2011
	 * @access: public y private
	 */
	// Varible que permite iniciar el dispositivo de lector de huella conectado
	// con sus distintos metodos.
	private DPFPCapture Lector = DPFPGlobal.getCaptureFactory().createCapture();

	// Varible que permite establecer las capturas de la huellas, para determina
	// sus caracteristicas
	// y poder estimar la creacion de un template de la huella para luego poder
	// guardarla
	private DPFPEnrollment Reclutador = DPFPGlobal.getEnrollmentFactory().createEnrollment();

	// Esta variable tambien captura una huella del lector y crea sus
	// caracteristcas para auntetificarla
	// o verificarla con alguna guardada en la BD
	private DPFPVerification Verificador = DPFPGlobal.getVerificationFactory().createVerification();

	// Variable que para crear el template de la huella luego de que se hallan
	// creado las caracteriticas
	// necesarias de la huella si no ha ocurrido ningun problema
	private DPFPTemplate template;
	public static String TEMPLATE_PROPERTY = "template";

	/**
	 * @function: Iniciar
	 * @author: Napster2011
	 * @description: funcion encargada de inicializar el formulario
	 * @access: public
	 * @return
	 */
	protected void Iniciar() {
		Lector.addDataListener(new DPFPDataAdapter() {
			@Override
			public void dataAcquired(final DPFPDataEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						EnviarTexto("La Huella Digital ha sido Capturada");
						ProcesarCaptura(e.getSample());
					}
				});
			}
		});

		Lector.addReaderStatusListener(new DPFPReaderStatusAdapter() {
			@Override
			public void readerConnected(final DPFPReaderStatusEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						EnviarTexto("El Sensor de Huella Digital esta Activado o Conectado");
					}
				});
			}

			@Override
			public void readerDisconnected(final DPFPReaderStatusEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						EnviarTexto("El Sensor de Huella Digital esta Desactivado o no Conectado");
					}
				});
			}
		});

		Lector.addSensorListener(new DPFPSensorAdapter() {
			@Override
			public void fingerTouched(final DPFPSensorEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						EnviarTexto("El dedo ha sido colocado sobre el Lector de Huella");
					}
				});
			}

			@Override
			public void fingerGone(final DPFPSensorEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						EnviarTexto("El dedo ha sido quitado del Lector de Huella");
					}
				});
			}
		});

		Lector.addErrorListener(new DPFPErrorAdapter() {
			public void errorReader(final DPFPErrorEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						EnviarTexto("Error: " + e.getError());
					}
				});
			}
		});
	}

	/**
	 * @atributos
	 * @author: Napster2011
	 * @access: public
	 */
	public DPFPFeatureSet featuresinscripcion;
	public DPFPFeatureSet featuresverificacion;

	/**
	 * @function: ProcesarCaptura
	 * @author: Napster2011
	 * @description:
	 * @access: public
	 * @return
	 */
	public void ProcesarCaptura(DPFPSample sample) {
		// Procesar la muestra de la huella y crear un conjunto de
		// caracter�sticas con el prop�sito de inscripci�n.
		featuresinscripcion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);

		// Procesar la muestra de la huella y crear un conjunto de
		// caracter�sticas con el prop�sito de verificacion.
		featuresverificacion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);

		// Comprobar la calidad de la muestra de la huella y lo a�ade a su
		// reclutador si es bueno
		if (featuresinscripcion != null) {
			try {
				System.out.println("Las Caracteristicas de la Huella han sido creada");
				Reclutador.addFeatures(featuresinscripcion);// Agregar las
															// caracteristicas
															// de la huella a la
															// plantilla a crear

				// Dibuja la huella dactilar capturada.
				Image image = CrearImagenHuella(sample);
				DibujarHuella(image);

				btnIdentificar.setEnabled(true);
			} catch (DPFPImageQualityException ex) {
				System.err.println("Error: " + ex.getMessage());
			}

			finally {
				// EstadoHuellas();

				// Comprueba si la plantilla se ha creado.
				switch (Reclutador.getTemplateStatus()) {
				case TEMPLATE_STATUS_READY: // informe de �xito y detiene la
											// captura de huellas
					stop();
					setTemplate(Reclutador.getTemplate());
					EnviarTexto("La Plantilla de la Huella ha Sido Creada, ya puede Verificarla");
					btnIdentificar.setEnabled(true);
					btnGuardar.setEnabled(true);
					btnGuardar.grabFocus();
					break;

				case TEMPLATE_STATUS_FAILED: // informe de fallas y reiniciar la
												// captura de huellas
					Reclutador.clear();
					stop();
					// EstadoHuellas();
					setTemplate(null);
					JOptionPane.showMessageDialog(CapturaHuella.this,
							"La Plantilla de la Huella no pudo ser creada, Repita el Proceso",
							"Inscripcion de Huellas Dactilares", JOptionPane.ERROR_MESSAGE);
					start();
					break;
				}
			}
		}
	}

	/**
	 * @function: extraerCaracteristicas
	 * @author: Napster2011
	 * @description:
	 * @access: public
	 * @return
	 */
	public DPFPFeatureSet extraerCaracteristicas(DPFPSample sample, DPFPDataPurpose purpose) {
		DPFPFeatureExtraction extractor = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
		try {
			return extractor.createFeatureSet(sample, purpose);
		} catch (DPFPImageQualityException e) {
			return null;
		}
	}

	/**
	 * @function: CrearImagenHuella
	 * @author: Napster2011
	 * @description:
	 * @access: public
	 * @return
	 */
	public Image CrearImagenHuella(DPFPSample sample) {
		return DPFPGlobal.getSampleConversionFactory().createImage(sample);
	}

	/**
	 * @function: DibujarHuella
	 * @author: Napster2011
	 * @description:
	 * @access: public
	 * @return
	 */
	public void DibujarHuella(Image image) {
		lblImagenHuella.setIcon(new ImageIcon(
				image.getScaledInstance(lblImagenHuella.getWidth(), lblImagenHuella.getHeight(), Image.SCALE_DEFAULT)));
		repaint();
	}

	/**
	 * @function: EstadoHuellas
	 * @author: Napster2011
	 * @description:
	 * @access: public
	 * @return
	 */
	public void EstadoHuellas() {
		EnviarTexto("Muestra de Huellas Necesarias para Guardar Template " + Reclutador.getFeaturesNeeded());
	}

	/**
	 * @function: EnviarTexto
	 * @author: Napster2011
	 * @description:
	 * @access: public
	 * @return
	 */
	public void EnviarTexto(String string) {
		txtArea.append(string + "\n");
	}

	/**
	 * @function: start
	 * @author: Napster2011
	 * @description:
	 * @access: public
	 * @return
	 */
	public void start() {
		Lector.startCapture();
		EnviarTexto("Utilizando el Lector de Huella Dactilar ");
	}

	/**
	 * @function: stop
	 * @author: Napster2011
	 * @description:
	 * @access: public
	 * @return
	 */
	public void stop() {
		Lector.stopCapture();
		EnviarTexto("No se est� usando el Lector de Huella Dactilar ");
	}

	/**
	 * @function: getTemplate
	 * @author: Napster2011
	 * @description:
	 * @access: public
	 * @return
	 */
	public DPFPTemplate getTemplate() {
		return template;
	}

	/**
	 * @function: setTemplate
	 * @author: Napster2011
	 * @description:
	 * @access: public
	 * @return
	 */
	public void setTemplate(DPFPTemplate template) {
		DPFPTemplate old = this.template;
		this.template = template;
		firePropertyChange(TEMPLATE_PROPERTY, old, template);
	}

	/**
	 * @global
	 * @author: Napster2011
	 */
	Conexion con = new Conexion();

	/**
	 * @function: guardarHuella
	 * @author: Napster2011
	 * @description:
	 * @access: public
	 * @return
	 */
	public void guardarHuella() {

		// Obtiene los datos del template de la huella actual
		ByteArrayInputStream datosHuella = new ByteArrayInputStream(template.serialize());
		Integer tama�oHuella = template.serialize().length;

		// Capturamos los datos del usuario
		String cedula = JOptionPane.showInputDialog("No. Identificacion:");
		try {
			// Establece los valores para la sentencia SQL
			Connection c = con.getConexion(); // establece la conexion con la BD
			PreparedStatement verificaCedulaUsuario = c.prepareStatement(
					"select identificacion_usuario, huella1_usuario from huella where (identificacion_usuario=?)");
			verificaCedulaUsuario.setInt(1, Integer.parseInt(cedula));
			ResultSet rs = verificaCedulaUsuario.executeQuery();

			if (rs.next()) {
				// Lee la plantilla de la base de datos
				byte templateBuffer[] = rs.getBytes(2);
				// Crea una nueva plantilla a partir de la guardada en la base
				// de datos
				DPFPTemplate referenceTemplate = DPFPGlobal.getTemplateFactory().createTemplate(templateBuffer);
				// Envia la plantilla creada al objeto contendor de Template del
				// componente de huella digital
				setTemplate(referenceTemplate);

				// Compara las caracteriticas de la huella recientemente
				// capturda con la
				// plantilla guardada al usuario especifico en la base de datos
				DPFPVerificationResult result = Verificador.verify(featuresverificacion, getTemplate());

				// compara las plantilas (actual vs bd)
				if (result.isVerified()) {
					JOptionPane.showMessageDialog(null, "La huella ya existe, coloque un dedo diferente");
				} else {
					PreparedStatement guardarStmt2 = c
							.prepareStatement("update huella set huella2_usuario=? where (identificacion_usuario=?)");
					guardarStmt2.setBinaryStream(1, datosHuella, tama�oHuella);
					guardarStmt2.setInt(2, Integer.parseInt(cedula));

					// Ejecuta la sentencia
					guardarStmt2.execute();
					guardarStmt2.close();
					JOptionPane.showMessageDialog(null, "Huella Guardada Correctamente");
				}
			} else if (!rs.next()) {
				String nombre = JOptionPane.showInputDialog("Nombre y Apellidos:");
				PreparedStatement guardarStmt = c.prepareStatement(
						"INSERT INTO huella(identificacion_usuario, nombres_usuario, huella1_usuario, huella2_usuario) values(?,?,?,?)");
				guardarStmt.setInt(1, Integer.parseInt(cedula));
				guardarStmt.setString(2, nombre);
				guardarStmt.setBinaryStream(3, datosHuella, tama�oHuella);
				// Ejecuta la sentencia
				guardarStmt.execute();
				guardarStmt.close();
				JOptionPane.showMessageDialog(null, "Huella Guardada Correctamente");
			}

			// con.desconectar();
			// btnGuardar.setEnabled(false);

		} catch (SQLException ex) {
			// Si ocurre un error lo indica en la consola
			System.err.println("Error al guardar los datos de la huella.");
		}
		/*
		 * finally{ con.desconectar(); }
		 */
	}

	/**
	 * @function: identificarHuella
	 * @author: Napster2011
	 * @description:
	 * @access: public
	 * @return
	 */
	public void identificarHuella() throws IOException {
		try {
			// Establece los valores para la sentencia SQL
			Connection c = con.getConexion();

			// Obtiene todas las huellas de la bd
			PreparedStatement identificarStmt = c.prepareStatement(
					"SELECT nombres_usuario, huella1_usuario FROM huella UNION ALL SELECT nombres_usuario, huella2_usuario FROM huella");
			// Obtiene todas las huellas de la bd
			ResultSet rsIdentificar = identificarStmt.executeQuery();

			// Si se encuentra el nombre en la base de datos
			// byte templateBuffer[] = null;
			int i = 0;
			while (rsIdentificar.next()) {
				i++;
				System.out.println("SQL:" + rsIdentificar.getString(1) + "\n");
				System.out.println("Contador:" + i + "\n");

				byte templateBuffer[] = rsIdentificar.getBytes("huella1_usuario");
				// Crea una nueva plantilla a partir de la guardada en la base
				// de datos
				DPFPTemplate referenceTemplate = DPFPGlobal.getTemplateFactory().createTemplate(templateBuffer);
				// Envia la plantilla creada al objeto contendor de Template del
				// componente de huella digital
				setTemplate(referenceTemplate);

				// Compara las caracteriticas de la huella recientemente
				// capturda con la
				// alguna plantilla guardada en la base de datos que coincide
				// con ese tipo
				DPFPVerificationResult result = Verificador.verify(featuresverificacion, getTemplate());

				// compara las plantilas (actual vs bd)
				// Si encuentra correspondencia dibuja el mapa
				// e indica el nombre de la persona que coincidi�.
				if (result.isVerified()) {
					// crea la imagen de los datos guardado de las huellas
					// guardadas en la base de datos
					JOptionPane.showMessageDialog(null, "Bienvenido " + rsIdentificar.getString("nombres_usuario"));
					return;
				}
			}
			// Si no encuentra alguna huella que coincida lo indica con un
			// mensaje
			JOptionPane.showMessageDialog(null, "No existe ning�n registro que coincida con la huella.");
		} catch (SQLException e) {
			System.out.println("Se produjo el siguiente error: " + e.getMessage());
			e.printStackTrace();
		}
		/*
		 * finally{ con.desconectar(); }
		 */
	}

	/**
	 * @function: main
	 * @author: Napster2011
	 * @description:
	 * @access: public
	 * @return
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CapturaHuella().setVisible(true);
			}
		});
	}

	/**
	 * @atributos
	 * @author: Napster2011
	 * @access: public y private
	 */
	// Variables declaration � do not modify
	private javax.swing.JButton btnGuardar;
	private javax.swing.JButton btnIdentificar;
	private javax.swing.JButton btnSalir;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel lblImagenHuella;
	private javax.swing.JPanel panBtns;
	private javax.swing.JPanel panHuellas;
	private javax.swing.JTextArea txtArea;
	// End of variables declaration
}
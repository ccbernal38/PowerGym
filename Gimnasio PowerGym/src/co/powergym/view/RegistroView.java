package co.powergym.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.Webcam;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;

public class RegistroView extends JFrame {

	private JPanel contentPane;
	private JTextField textField_identificacion;
	private JTextField textField_primerNombre;
	private JTextField textField_segundoNombre;
	private JTextField textField_primerApellido;
	private JTextField textField_segundoApellido;
	private JTextField textField_correo;
	private JTextField textField_telefono;
	private JComboBox comboBox_genero;
	private JDateChooser dateChooser_fechaNacimiento;
	public JButton btnRegistrar;
	public JButton btnCancelar;
	private WebcamPanel webcamPanel;
	private JButton btnTomarFoto;
	private JButton btnCapturar;
	public Webcam webcam;
	

	
	public Webcam getWebcam() {
		return webcam;
	}
	public void setWebcam(Webcam webcam) {
		this.webcam = webcam;
	}
	/**
	 * Create the frame.
	 */
	public RegistroView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(32, 29, 246, 331);
		contentPane.add(panel);
		panel.setLayout(null);

		if(webcam != null){
			webcamPanel = new WebcamPanel(webcam, false);	
		}else{
			webcamPanel = new WebcamPanel(Webcam.getWebcams().get(0), false);
		}
		
		webcamPanel.setBounds(10, 11, 226, 239);
		panel.add(webcamPanel);

		btnTomarFoto = new JButton("Tomar Foto");
		btnTomarFoto.setBounds(10, 261, 226, 23);
		panel.add(btnTomarFoto);

		btnCapturar = new JButton("Capturar");
		btnCapturar.setBounds(10, 295, 226, 23);
		panel.add(btnCapturar);
		
		textField_identificacion = new JTextField();
		textField_identificacion.setBounds(471, 29, 202, 20);
		contentPane.add(textField_identificacion);
		textField_identificacion.setColumns(10);
		
		textField_primerNombre = new JTextField();
		textField_primerNombre.setBounds(471, 60, 202, 20);
		contentPane.add(textField_primerNombre);
		textField_primerNombre.setColumns(10);
		
		textField_segundoNombre = new JTextField();
		textField_segundoNombre.setBounds(471, 91, 202, 20);
		contentPane.add(textField_segundoNombre);
		textField_segundoNombre.setColumns(10);
		
		textField_primerApellido = new JTextField();
		textField_primerApellido.setBounds(471, 122, 202, 20);
		contentPane.add(textField_primerApellido);
		textField_primerApellido.setColumns(10);
		
		textField_segundoApellido = new JTextField();
		textField_segundoApellido.setBounds(471, 153, 202, 20);
		contentPane.add(textField_segundoApellido);
		textField_segundoApellido.setColumns(10);
		
		textField_correo = new JTextField();
		textField_correo.setBounds(471, 184, 202, 20);
		contentPane.add(textField_correo);
		textField_correo.setColumns(10);
		
		textField_telefono = new JTextField();
		textField_telefono.setBounds(471, 215, 202, 20);
		contentPane.add(textField_telefono);
		textField_telefono.setColumns(10);
		
		comboBox_genero = new JComboBox();
		comboBox_genero.setBounds(471, 246, 202, 20);
		contentPane.add(comboBox_genero);
		
		dateChooser_fechaNacimiento = new JDateChooser();
		dateChooser_fechaNacimiento.setBounds(471, 277, 202, 20);
		contentPane.add(dateChooser_fechaNacimiento);
		
		JLabel lblPrimerNombre = new JLabel("Primer nombre:");
		lblPrimerNombre.setBounds(304, 66, 157, 14);
		contentPane.add(lblPrimerNombre);
		
		JLabel lblSegundoNombre = new JLabel("Segundo nombre:");
		lblSegundoNombre.setBounds(304, 97, 157, 14);
		contentPane.add(lblSegundoNombre);
		
		JLabel lblPrimerApellido = new JLabel("Primer apellido:");
		lblPrimerApellido.setBounds(304, 128, 157, 14);
		contentPane.add(lblPrimerApellido);
		
		JLabel lblSegundoApellido = new JLabel("Segundo apellido:");
		lblSegundoApellido.setBounds(304, 159, 157, 14);
		contentPane.add(lblSegundoApellido);
		
		JLabel lblNmeroDeIdentificacin = new JLabel("N\u00FAmero de identificaci\u00F3n:");
		lblNmeroDeIdentificacin.setBounds(304, 35, 157, 14);
		contentPane.add(lblNmeroDeIdentificacin);
		
		JLabel lblCorreoElectronico = new JLabel("Correo electr\u00F3nico:");
		lblCorreoElectronico.setBounds(304, 190, 157, 14);
		contentPane.add(lblCorreoElectronico);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(304, 218, 157, 14);
		contentPane.add(lblTelfono);
		
		JLabel lblGnero = new JLabel("G\u00E9nero:");
		lblGnero.setBounds(304, 252, 157, 14);
		contentPane.add(lblGnero);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setBounds(304, 283, 157, 14);
		contentPane.add(lblFechaDeNacimiento);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(315, 390, 89, 23);
		contentPane.add(btnRegistrar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(216, 390, 89, 23);
		contentPane.add(btnCancelar);
	}
	public JTextField getTextField_identificacion() {
		return textField_identificacion;
	}
	public JTextField getTextField_primerNombre() {
		return textField_primerNombre;
	}
	public JTextField getTextField_segundoNombre() {
		return textField_segundoNombre;
	}
	public JTextField getTextField_primerApellido() {
		return textField_primerApellido;
	}
	public JTextField getTextField_segundoApellido() {
		return textField_segundoApellido;
	}
	public JTextField getTextField_correo() {
		return textField_correo;
	}
	public JTextField getTextField_telefono() {
		return textField_telefono;
	}
	public JComboBox getComboBox_genero() {
		return comboBox_genero;
	}
	public JDateChooser getDateChooser_fechaNacimiento() {
		return dateChooser_fechaNacimiento;
	}
	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	public WebcamPanel getWebcamPanel() {
		return webcamPanel;
	}
	public JButton getBtnTomarFoto() {
		return btnTomarFoto;
	}
	public JButton getBtnCapturar() {
		return btnCapturar;
	}
}

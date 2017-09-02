package co.powergym.view.socio;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.toedter.calendar.JDateChooser;

public class SocioRegistroView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_identificacion;
	private JTextField textField_nombre;
	private JTextField textField_apellido;
	private JTextField textField_correo;
	private JTextField textField_telefono;
	public JComboBox<String> comboBox_genero;
	public JDateChooser dateChooser_fechaNacimiento;
	public JButton btnRegistrar;
	public JButton btnCancelar;
	public WebcamPanel webcamPanel;
	public JButton btnTomarFoto;
	public JButton btnCapturar;
	public Webcam webcam;
	private JPanel panel;
	private JButton btnTomarHuellas;
	

	
	public Webcam getWebcam() {
		return webcam;
	}
	public void setWebcam(Webcam webcam) {
		this.webcam = webcam;
	}
	/**
	 * Create the frame.
	 */
	public SocioRegistroView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 765, 463);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 39, 49));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(32, 29, 246, 331);
		contentPane.add(panel);
		panel.setLayout(null);

		if(webcam == null){
			webcam = Webcam.getWebcams().get(0);
		}
		
		webcamPanel = new WebcamPanel(webcam, false);	
		webcamPanel.setBackground(Color.GRAY);

		webcamPanel.setBounds(10, 11, 226, 239);
		panel.add(webcamPanel);

		btnTomarFoto = new JButton("Tomar Foto");
		btnTomarFoto.setEnabled(false);
		btnTomarFoto.setBounds(10, 261, 226, 23);
		panel.add(btnTomarFoto);

		btnCapturar = new JButton("Capturar");
		btnCapturar.setBounds(10, 295, 226, 23);
		panel.add(btnCapturar);
		
		textField_identificacion = new JTextField();
		textField_identificacion.setBounds(495, 29, 202, 20);
		contentPane.add(textField_identificacion);
		textField_identificacion.setColumns(10);
		
		textField_nombre = new JTextField();
		textField_nombre.setBounds(495, 60, 202, 20);
		contentPane.add(textField_nombre);
		textField_nombre.setColumns(10);
		
		
		textField_apellido = new JTextField();
		textField_apellido.setBounds(495, 92, 202, 20);
		contentPane.add(textField_apellido);
		textField_apellido.setColumns(10);
		
		
		textField_correo = new JTextField();
		textField_correo.setBounds(495, 124, 202, 20);
		contentPane.add(textField_correo);
		textField_correo.setColumns(10);
		
		textField_telefono = new JTextField();
		textField_telefono.setBounds(495, 155, 202, 20);
		contentPane.add(textField_telefono);
		textField_telefono.setColumns(10);
		
		comboBox_genero = new JComboBox<String>();
		comboBox_genero.setBounds(495, 186, 202, 20);
		comboBox_genero.addItem("Femenino");
		comboBox_genero.addItem("Masculino");		
		contentPane.add(comboBox_genero);
		
		dateChooser_fechaNacimiento = new JDateChooser();
		dateChooser_fechaNacimiento.setBounds(495, 217, 202, 20);
		contentPane.add(dateChooser_fechaNacimiento);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(304, 66, 157, 14);
		contentPane.add(lblNombre);
		
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setBounds(304, 98, 157, 14);
		contentPane.add(lblApellido);
		
		
		JLabel lblNmeroDeIdentificacin = new JLabel("N\u00FAmero de identificaci\u00F3n:");
		lblNmeroDeIdentificacin.setForeground(Color.WHITE);
		lblNmeroDeIdentificacin.setBounds(304, 35, 179, 14);
		contentPane.add(lblNmeroDeIdentificacin);
		
		JLabel lblCorreoElectronico = new JLabel("Correo electr\u00F3nico:");
		lblCorreoElectronico.setForeground(Color.WHITE);
		lblCorreoElectronico.setBounds(304, 130, 157, 14);
		contentPane.add(lblCorreoElectronico);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setForeground(Color.WHITE);
		lblTelfono.setBounds(304, 158, 157, 14);
		contentPane.add(lblTelfono);
		
		JLabel lblGnero = new JLabel("G\u00E9nero:");
		lblGnero.setForeground(Color.WHITE);
		lblGnero.setBounds(304, 192, 157, 14);
		contentPane.add(lblGnero);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setForeground(Color.WHITE);
		lblFechaDeNacimiento.setBounds(304, 223, 157, 14);
		contentPane.add(lblFechaDeNacimiento);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(315, 381, 119, 32);
		
		
		contentPane.add(btnRegistrar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(216, 390, 89, 23);
		contentPane.add(btnCancelar);
		
		btnTomarHuellas = new JButton("Tomar Huellas ");
		btnTomarHuellas.setBounds(304, 336, 393, 23);
		contentPane.add(btnTomarHuellas);
		
	}
	public JTextField getTextField_identificacion() {
		return textField_identificacion;
	}
	public JTextField getTextField_primerNombre() {
		return textField_nombre;
	}
	public JTextField getTextField_primerApellido() {
		return textField_apellido;
	}
	public JTextField getTextField_correo() {
		return textField_correo;
	}
	public JTextField getTextField_telefono() {
		return textField_telefono;
	}
	public JComboBox<String> getComboBox_genero() {
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
	public JPanel getPanel() {
		return panel;
	}
	public JButton getBtnTomarHuellas() {
		return btnTomarHuellas;
	}
}

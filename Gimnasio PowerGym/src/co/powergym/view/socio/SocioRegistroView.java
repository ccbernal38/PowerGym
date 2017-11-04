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

import co.powergym.utils.ButtonSecundario;
import co.powergym.utils.Constantes;

import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

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
	private JLabel labelCodigoSocio;
	private JTextField textFieldCodigo;
	private JPanel panel_1;
	private JLabel lblRegistroDeSocio;
	private JPanel panel_2;
	private JLabel label;
	

	
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
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 765, 517);
		contentPane = new JPanel();
		contentPane.setBackground(Constantes.black());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(Constantes.black());
		panel.setBorder(new LineBorder(Color.WHITE));
		panel.setBounds(29, 83, 246, 331);
		contentPane.add(panel);
		panel.setLayout(null);

		if(webcam == null){
			webcam = Webcam.getWebcams().get(0);
		}
		
		webcamPanel = new WebcamPanel(webcam, false);	
		webcamPanel.setBackground(Color.GRAY);

		webcamPanel.setBounds(10, 11, 226, 239);
		panel.add(webcamPanel);

		btnTomarFoto = new ButtonSecundario("Tomar Foto");
		btnTomarFoto.setEnabled(false);
		btnTomarFoto.setBounds(10, 261, 226, 23);
		panel.add(btnTomarFoto);

		btnCapturar = new ButtonSecundario("Capturar");
		btnCapturar.setBounds(10, 295, 226, 23);
		panel.add(btnCapturar);
		
		textField_identificacion = new JTextField();
		textField_identificacion.setBounds(492, 83, 202, 20);
		contentPane.add(textField_identificacion);
		textField_identificacion.setColumns(10);
		
		textField_nombre = new JTextField();
		textField_nombre.setBounds(492, 114, 202, 20);
		contentPane.add(textField_nombre);
		textField_nombre.setColumns(10);
		
		
		textField_apellido = new JTextField();
		textField_apellido.setBounds(492, 146, 202, 20);
		contentPane.add(textField_apellido);
		textField_apellido.setColumns(10);
		
		
		textField_correo = new JTextField();
		textField_correo.setBounds(492, 178, 202, 20);
		contentPane.add(textField_correo);
		textField_correo.setColumns(10);
		
		textField_telefono = new JTextField();
		textField_telefono.setBounds(492, 209, 202, 20);
		contentPane.add(textField_telefono);
		textField_telefono.setColumns(10);
		
		comboBox_genero = new JComboBox<String>();
		comboBox_genero.setBounds(492, 240, 202, 20);
		comboBox_genero.addItem("Femenino");
		comboBox_genero.addItem("Masculino");		
		contentPane.add(comboBox_genero);
		
		dateChooser_fechaNacimiento = new JDateChooser();
		dateChooser_fechaNacimiento.setBounds(492, 271, 202, 20);
		contentPane.add(dateChooser_fechaNacimiento);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(285, 114, 216, 20);
		contentPane.add(lblNombre);
		
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Verdana", Font.BOLD, 14));
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setBounds(285, 145, 216, 21);
		contentPane.add(lblApellido);
		
		
		JLabel lblNmeroDeIdentificacin = new JLabel("N\u00FAmero de identificaci\u00F3n:");
		lblNmeroDeIdentificacin.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNmeroDeIdentificacin.setForeground(Color.WHITE);
		lblNmeroDeIdentificacin.setBounds(285, 83, 216, 20);
		contentPane.add(lblNmeroDeIdentificacin);
		
		JLabel lblCorreoElectronico = new JLabel("Correo electr\u00F3nico:");
		lblCorreoElectronico.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCorreoElectronico.setForeground(Color.WHITE);
		lblCorreoElectronico.setBounds(285, 177, 216, 21);
		contentPane.add(lblCorreoElectronico);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setFont(new Font("Verdana", Font.BOLD, 14));
		lblTelfono.setForeground(Color.WHITE);
		lblTelfono.setBounds(285, 209, 216, 20);
		contentPane.add(lblTelfono);
		
		JLabel lblGnero = new JLabel("G\u00E9nero:");
		lblGnero.setFont(new Font("Verdana", Font.BOLD, 14));
		lblGnero.setForeground(Color.WHITE);
		lblGnero.setBounds(285, 240, 216, 20);
		contentPane.add(lblGnero);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setFont(new Font("Verdana", Font.BOLD, 14));
		lblFechaDeNacimiento.setForeground(Color.WHITE);
		lblFechaDeNacimiento.setBounds(285, 271, 216, 20);
		contentPane.add(lblFechaDeNacimiento);
		
		btnRegistrar = new ButtonSecundario("Registrar");
		btnRegistrar.setBounds(301, 440, 80, 27);
		
		
		contentPane.add(btnRegistrar);
		
		btnCancelar = new ButtonSecundario("Cancelar");
		btnCancelar.setBounds(389, 440, 80, 27);
		contentPane.add(btnCancelar);
		
		labelCodigoSocio = new JLabel("C\u00F3digo de acceso:");
		labelCodigoSocio.setFont(new Font("Verdana", Font.BOLD, 14));
		labelCodigoSocio.setForeground(Color.WHITE);
		labelCodigoSocio.setBounds(285, 302, 216, 20);
		contentPane.add(labelCodigoSocio);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setEditable(false);
		textFieldCodigo.setBounds(492, 302, 202, 20);
		contentPane.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 759, 56);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		lblRegistroDeSocio = new JLabel("Registro de socio");
		lblRegistroDeSocio.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeSocio.setFont(new Font("Verdana", Font.BOLD, 18));
		panel_1.add(lblRegistroDeSocio);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Constantes.black());
		panel_2.setBounds(285, 327, 96, 87);
		contentPane.add(panel_2);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(((new ImageIcon("image/huella.png")).getImage()).getScaledInstance(
				50, 50, java.awt.Image.SCALE_AREA_AVERAGING)));
		panel_2.add(label);
		
		btnTomarHuellas = new ButtonSecundario("Tomar Huellas ");
		panel_2.add(btnTomarHuellas);
		
		
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
	public JTextField getTextFieldCodigo() {
		return textFieldCodigo;
	}
}

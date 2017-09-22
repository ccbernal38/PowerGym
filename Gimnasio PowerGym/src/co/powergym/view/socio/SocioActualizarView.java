package co.powergym.view.socio;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SocioActualizarView extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Webcam webcam;
	private WebcamPanel webcamPanel;
	private JTextField textIdentificacion;
	private JTextField textNombres;
	private JTextField textApellidos;
	private JTextField textCorreo;
	private JTextField textTelefono;
	private JTextField textGenero;
	private JDateChooser textFechaNacimiento;
	private JButton btnTomarFoto;
	private JButton btnCapturar;
	private JButton btnActualizar;
	private JPanel panelFoto;

	public SocioActualizarView() {
		setTitle("Actualizar datos del socio");
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		setBounds(100, 100, 807, 519);

		panelFoto = new JPanel();
		panelFoto.setBounds(30, 34, 239, 313);
		getContentPane().add(panelFoto);
		
		if(webcam == null){
			webcam = Webcam.getWebcams().get(0);
		}
		panelFoto.setLayout(null);
		
		webcamPanel = new WebcamPanel(webcam, false);	
		webcamPanel.setBackground(Color.GRAY);

		webcamPanel.setBounds(6, 6, 224, 231);
		panelFoto.add(webcamPanel);
		
		btnTomarFoto = new JButton("Tomar foto");
		btnTomarFoto.setEnabled(false);
		btnTomarFoto.setBounds(6, 241, 224, 29);
		panelFoto.add(btnTomarFoto);
		
		btnCapturar = new JButton("Capturar");
		btnCapturar.setBounds(6, 270, 224, 29);
		panelFoto.add(btnCapturar);
		
		JLabel lblIdentificacin = new JLabel("Número de identificación:");
		lblIdentificacin.setForeground(Color.WHITE);
		lblIdentificacin.setBounds(351, 36, 183, 16);
		getContentPane().add(lblIdentificacin);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setForeground(Color.WHITE);
		lblNombres.setBounds(351, 66, 61, 16);
		getContentPane().add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setBounds(351, 96, 84, 16);
		getContentPane().add(lblApellidos);
		
		JLabel lblCorreoElectrnico = new JLabel("Correo electrónico:");
		lblCorreoElectrnico.setForeground(Color.WHITE);
		lblCorreoElectrnico.setBounds(351, 126, 148, 16);
		getContentPane().add(lblCorreoElectrnico);
		
		JLabel lblTelefno = new JLabel("Telefóno:");
		lblTelefno.setForeground(Color.WHITE);
		lblTelefno.setBounds(351, 156, 84, 16);
		getContentPane().add(lblTelefno);
		
		JLabel lblGnero = new JLabel("Género:");
		lblGnero.setForeground(Color.WHITE);
		lblGnero.setBounds(351, 186, 61, 16);
		getContentPane().add(lblGnero);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setForeground(Color.WHITE);
		lblFechaDeNacimiento.setBounds(351, 216, 148, 16);
		getContentPane().add(lblFechaDeNacimiento);
		
		textIdentificacion = new JTextField();
		textIdentificacion.setBounds(521, 31, 245, 26);
		getContentPane().add(textIdentificacion);
		textIdentificacion.setColumns(10);
		
		textNombres = new JTextField();
		textNombres.setBounds(521, 61, 245, 26);
		getContentPane().add(textNombres);
		textNombres.setColumns(10);
		
		textApellidos = new JTextField();
		textApellidos.setBounds(521, 91, 245, 26);
		getContentPane().add(textApellidos);
		textApellidos.setColumns(10);
		
		textCorreo = new JTextField();
		textCorreo.setBounds(521, 121, 245, 26);
		getContentPane().add(textCorreo);
		textCorreo.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(521, 151, 245, 26);
		getContentPane().add(textTelefono);
		textTelefono.setColumns(10);
		
		textGenero = new JTextField();
		textGenero.setBounds(521, 181, 245, 26);
		getContentPane().add(textGenero);
		textGenero.setColumns(10);
		
		textFechaNacimiento = new JDateChooser();
		textFechaNacimiento.setBounds(521, 211, 245, 26);
		getContentPane().add(textFechaNacimiento);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(351, 367, 117, 29);
		getContentPane().add(btnActualizar);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the webcam
	 */
	public Webcam getWebcam() {
		return webcam;
	}

	/**
	 * @param webcam the webcam to set
	 */
	public void setWebcam(Webcam webcam) {
		this.webcam = webcam;
	}

	/**
	 * @return the webcamPanel
	 */
	public WebcamPanel getWebcamPanel() {
		return webcamPanel;
	}

	/**
	 * @param webcamPanel the webcamPanel to set
	 */
	public void setWebcamPanel(WebcamPanel webcamPanel) {
		this.webcamPanel = webcamPanel;
	}

	/**
	 * @return the textIdentificacion
	 */
	public JTextField getTextIdentificacion() {
		return textIdentificacion;
	}

	/**
	 * @param textIdentificacion the textIdentificacion to set
	 */
	public void setTextIdentificacion(JTextField textIdentificacion) {
		this.textIdentificacion = textIdentificacion;
	}

	/**
	 * @return the textNombres
	 */
	public JTextField getTextNombres() {
		return textNombres;
	}

	/**
	 * @param textNombres the textNombres to set
	 */
	public void setTextNombres(JTextField textNombres) {
		this.textNombres = textNombres;
	}

	/**
	 * @return the textApellidos
	 */
	public JTextField getTextApellidos() {
		return textApellidos;
	}

	/**
	 * @param textApellidos the textApellidos to set
	 */
	public void setTextApellidos(JTextField textApellidos) {
		this.textApellidos = textApellidos;
	}

	/**
	 * @return the textCorreo
	 */
	public JTextField getTextCorreo() {
		return textCorreo;
	}

	/**
	 * @param textCorreo the textCorreo to set
	 */
	public void setTextCorreo(JTextField textCorreo) {
		this.textCorreo = textCorreo;
	}

	/**
	 * @return the textTelefono
	 */
	public JTextField getTextTelefono() {
		return textTelefono;
	}

	/**
	 * @param textTelefono the textTelefono to set
	 */
	public void setTextTelefono(JTextField textTelefono) {
		this.textTelefono = textTelefono;
	}

	/**
	 * @return the textGenero
	 */
	public JTextField getTextGenero() {
		return textGenero;
	}

	/**
	 * @param textGenero the textGenero to set
	 */
	public void setTextGenero(JTextField textGenero) {
		this.textGenero = textGenero;
	}

	/**
	 * @return the textFechaNacimiento
	 */
	public JDateChooser getTextFechaNacimiento() {
		return textFechaNacimiento;
	}

	/**
	 * @param textFechaNacimiento the textFechaNacimiento to set
	 */
	public void setTextFechaNacimiento(JDateChooser textFechaNacimiento) {
		this.textFechaNacimiento = textFechaNacimiento;
	}

	/**
	 * @return the btnTomarFoto
	 */
	public JButton getBtnTomarFoto() {
		return btnTomarFoto;
	}

	/**
	 * @param btnTomarFoto the btnTomarFoto to set
	 */
	public void setBtnTomarFoto(JButton btnTomarFoto) {
		this.btnTomarFoto = btnTomarFoto;
	}

	/**
	 * @return the btnCapturar
	 */
	public JButton getBtnCapturar() {
		return btnCapturar;
	}

	/**
	 * @param btnCapturar the btnCapturar to set
	 */
	public void setBtnCapturar(JButton btnCapturar) {
		this.btnCapturar = btnCapturar;
	}

	/**
	 * @return the btnActualizar
	 */
	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	/**
	 * @param btnActualizar the btnActualizar to set
	 */
	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

	/**
	 * @return the panelFoto
	 */
	public JPanel getPanelFoto() {
		return panelFoto;
	}

	/**
	 * @param panelFoto the panelFoto to set
	 */
	public void setPanelFoto(JPanel panelFoto) {
		this.panelFoto = panelFoto;
	}
}

package co.powergym.view.usuario.entrenador;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class RegistroUsuario extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField txtNumeroid;
	public JTextField txtNombre;
	public JTextField txtApellido;
	public JTextField txtTelefono;
	public JTextField txtSegundonombre;
	public JTextField txtCorreoelectronico;
	public JButton btnRegistrar;
	public JButton btnCancelar;
	public JDateChooser dateChooserFechaNa;
	public JComboBox<String> comboBox_genero;
	private JTable tablePermisos;
	private JRadioButton rdbtnEntrenador;
	private JRadioButton rdbtnAdministrador;
	private JScrollPane scrollPane;
	private JTextField textUsername;
	private JTextField textContrasena;
	private JTextField textConfirmaC;
	private JPanel panel;
	private JPanel panel_1;
	
	
	public RegistroUsuario() {
		setTitle("Registro de usuario");
		getContentPane().setLayout(null);
		
		txtNumeroid = new JTextField();
		txtNumeroid.setBounds(207, 34, 202, 26);
		getContentPane().add(txtNumeroid);
		txtNumeroid.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(207, 63, 202, 26);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(207, 91, 202, 26);
		getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(598, 63, 202, 26);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblDocumentoDeIdentidad = new JLabel("Número de identificación:");
		lblDocumentoDeIdentidad.setBounds(33, 39, 168, 16);
		getContentPane().add(lblDocumentoDeIdentidad);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(33, 68, 130, 16);
		getContentPane().add(lblNombre);
		
		JLabel lblPrimerApellido = new JLabel("Apellidos:");
		lblPrimerApellido.setBounds(33, 96, 104, 16);
		getContentPane().add(lblPrimerApellido);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(469, 68, 61, 16);
		getContentPane().add(lblTelefono);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setBounds(33, 123, 144, 16);
		getContentPane().add(lblFechaDeNacimiento);
		
		dateChooserFechaNa = new JDateChooser();
		dateChooserFechaNa.setBounds(207, 123, 202, 20);
		getContentPane().add(dateChooserFechaNa);
		
		JLabel lblCorreoElectrnico = new JLabel("Correo electrónico:");
		lblCorreoElectrnico.setBounds(469, 39, 135, 16);
		getContentPane().add(lblCorreoElectrnico);
		
		txtCorreoelectronico = new JTextField();
		txtCorreoelectronico.setBounds(598, 34, 202, 26);
		getContentPane().add(txtCorreoelectronico);
		txtCorreoelectronico.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(430, 489, 100, 29);
		getContentPane().add(btnRegistrar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(315, 489, 100, 29);
		getContentPane().add(btnCancelar);
		
		JLabel lblGnero = new JLabel("G\u00E9nero:");
		lblGnero.setBounds(469, 97, 157, 14);
		getContentPane().add(lblGnero);
		
		comboBox_genero = new JComboBox<String>();
		comboBox_genero.setBounds(598, 95, 202, 20);
		comboBox_genero.addItem("Masculino");
		comboBox_genero.addItem("Femenino");
		getContentPane().add(comboBox_genero);
		
		rdbtnEntrenador = new JRadioButton("Entrenador");
		rdbtnEntrenador.setBounds(598, 120, 100, 23);
		getContentPane().add(rdbtnEntrenador);
		
		rdbtnAdministrador = new JRadioButton("Administrador");
		rdbtnAdministrador.setBounds(700, 119, 126, 23);
		getContentPane().add(rdbtnAdministrador);
		
		JLabel lblTipoDeUsuario = new JLabel("Tipo de usuario:");
		lblTipoDeUsuario.setBounds(469, 123, 130, 16);
		getContentPane().add(lblTipoDeUsuario);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Credenciales de acceso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(33, 173, 779, 96);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		textUsername = new JTextField();
		textUsername.setBounds(18, 47, 199, 26);
		panel.add(textUsername);
		textUsername.setColumns(10);
		
		textContrasena = new JPasswordField();
		textContrasena.setBounds(229, 47, 254, 26);
		panel.add(textContrasena);
		textContrasena.setColumns(10);
		
		textConfirmaC = new JPasswordField();
		textConfirmaC.setBounds(495, 47, 262, 26);
		panel.add(textConfirmaC);
		textConfirmaC.setColumns(10);
		
		JLabel lblConfirmeLaContrsea = new JLabel("Confirme la contraseña:");
		lblConfirmeLaContrsea.setBounds(495, 30, 162, 16);
		panel.add(lblConfirmeLaContrsea);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(229, 30, 86, 16);
		panel.add(lblContrasea);
		
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(18, 30, 72, 16);
		panel.add(lblUsername);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Permisos de acceso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(33, 278, 779, 199);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 43, 738, 135);
		panel_1.add(scrollPane);
		scrollPane.setToolTipText("");
		
		tablePermisos = new JTable();
		tablePermisos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePermisos.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setViewportView(tablePermisos);
		setSize(861, 558);
	}

		
	public JDateChooser getDateChooser_fechaNacimiento() {
		return dateChooserFechaNa;
	}
	public void setDateChooser_fechaNacimiento(JDateChooser dateChooser_fechaNacimiento) {
		this.dateChooserFechaNa = dateChooser_fechaNacimiento;
	}
	public JTextField getTxtNumeroid() {
		return txtNumeroid;
	}
	public void setTxtNumeroid(JTextField txtNumeroid) {
		this.txtNumeroid = txtNumeroid;
	}
	public JTextField getTxtNombre() {
		return txtNombre;
	}
	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}
	public JTextField getTxtPrimerapellido() {
		return txtApellido;
	}
	public void setTxtPrimerapellido(JTextField txtPrimerapellido) {
		this.txtApellido = txtPrimerapellido;
	}
	public JTextField getTxtTelefono() {
		return txtTelefono;
	}
	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}
	public JTextField getTxtCorreoelectronico() {
		return txtCorreoelectronico;
	}
	public void setTxtCorreoelectronico(JTextField txtCorreoelectronico) {
		this.txtCorreoelectronico = txtCorreoelectronico;
	}
	/**
	 * @return the textUsername
	 */
	public JTextField getTextUsername() {
		return textUsername;
	}


	/**
	 * @param textUsername the textUsername to set
	 */
	public void setTextUsername(JTextField textUsername) {
		this.textUsername = textUsername;
	}


	/**
	 * @return the textContrasena
	 */
	public JTextField getTextContrasena() {
		return textContrasena;
	}


	/**
	 * @param textContrasena the textContrasena to set
	 */
	public void setTextContrasena(JTextField textContrasena) {
		this.textContrasena = textContrasena;
	}


	/**
	 * @return the textConfirmaC
	 */
	public JTextField getTextConfirmaC() {
		return textConfirmaC;
	}


	/**
	 * @param textConfirmaC the textConfirmaC to set
	 */
	public void setTextConfirmaC(JTextField textConfirmaC) {
		this.textConfirmaC = textConfirmaC;
	}


	public JComboBox<String> getComboBox_genero() {
		return comboBox_genero;
	}
	public void setComboBox_genero(JComboBox<String> comboBox_genero) {
		this.comboBox_genero = comboBox_genero;
	}
	/**
	 * @return the tablePermisos
	 */
	public JTable getTablePermisos() {
		return tablePermisos;
	}



	/**
	 * @param tablePermisos the tablePermisos to set
	 */
	public void setTablePermisos(JTable tablePermisos) {
		this.tablePermisos = tablePermisos;
	}



	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}
	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}


	/**
	 * @return the rdbtnEntrenador
	 */
	public JRadioButton getRdbtnEntrenador() {
		return rdbtnEntrenador;
	}


	/**
	 * @param rdbtnEntrenador the rdbtnEntrenador to set
	 */
	public void setRdbtnEntrenador(JRadioButton rdbtnEntrenador) {
		this.rdbtnEntrenador = rdbtnEntrenador;
	}


	/**
	 * @return the rdbtnAdministrador
	 */
	public JRadioButton getRdbtnAdministrador() {
		return rdbtnAdministrador;
	}


	/**
	 * @param rdbtnAdministrador the rdbtnAdministrador to set
	 */
	public void setRdbtnAdministrador(JRadioButton rdbtnAdministrador) {
		this.rdbtnAdministrador = rdbtnAdministrador;
	}


	/**
	 * @return the scrollPane
	 */
	public JScrollPane getScrollPane() {
		return scrollPane;
	}


	/**
	 * @param scrollPane the scrollPane to set
	 */
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
}

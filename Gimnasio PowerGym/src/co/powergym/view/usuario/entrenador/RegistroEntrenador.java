package co.powergym.view.usuario.entrenador;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class RegistroEntrenador extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField txtNumeroid;
	public JTextField txtNombre;
	public JTextField txtPrimerapellido;
	public JTextField txtSegundoapellido;
	public JTextField txtTelefono;
	public JTextField txtSegundonombre;
	public JTextField txtCorreoelectronico;
	public JButton btnRegistrar;
	public JButton btnCancelar;
	public JDateChooser dateChooserFechaNa;
	public JComboBox comboBox_genero;
	
	public RegistroEntrenador() {
		setTitle("Registro de entrenador");
		getContentPane().setLayout(null);
		
		txtNumeroid = new JTextField();
		txtNumeroid.setBounds(226, 24, 202, 26);
		getContentPane().add(txtNumeroid);
		txtNumeroid.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(226, 60, 202, 26);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPrimerapellido = new JTextField();
		txtPrimerapellido.setBounds(226, 120, 202, 26);
		getContentPane().add(txtPrimerapellido);
		txtPrimerapellido.setColumns(10);
		
		txtSegundoapellido = new JTextField();
		txtSegundoapellido.setBounds(226, 150, 202, 26);
		getContentPane().add(txtSegundoapellido);
		txtSegundoapellido.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(226, 240, 202, 26);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblDocumentoDeIdentidad = new JLabel("Número de identificación");
		lblDocumentoDeIdentidad.setBounds(53, 30, 162, 16);
		getContentPane().add(lblDocumentoDeIdentidad);
		
		JLabel lblNombre = new JLabel("Primer nombre");
		lblNombre.setBounds(53, 60, 130, 16);
		getContentPane().add(lblNombre);
		
		JLabel lblPrimerApellido = new JLabel("Primer apellido");
		lblPrimerApellido.setBounds(53, 120, 104, 16);
		getContentPane().add(lblPrimerApellido);
		
		JLabel lblSegundoApellido = new JLabel("Segundo apellido");
		lblSegundoApellido.setBounds(53, 150, 130, 16);
		getContentPane().add(lblSegundoApellido);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(53, 240, 61, 16);
		getContentPane().add(lblTelefono);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setBounds(53, 180, 130, 16);
		getContentPane().add(lblFechaDeNacimiento);
		
		dateChooserFechaNa = new JDateChooser();
		dateChooserFechaNa.setBounds(226, 180, 202, 20);
		getContentPane().add(dateChooserFechaNa);
		
		JLabel lblSegundoNombre = new JLabel("Segundo nombre");
		lblSegundoNombre.setBounds(53, 90, 130, 16);
		getContentPane().add(lblSegundoNombre);
		
		txtSegundonombre = new JTextField();
		txtSegundonombre.setBounds(226, 90, 202, 26);
		getContentPane().add(txtSegundonombre);
		txtSegundonombre.setColumns(10);
		
		JLabel lblCorreoElectrnico = new JLabel("Correo electrónico");
		lblCorreoElectrnico.setBounds(53, 210, 135, 16);
		getContentPane().add(lblCorreoElectrnico);
		
		txtCorreoelectronico = new JTextField();
		txtCorreoelectronico.setBounds(226, 210, 202, 26);
		getContentPane().add(txtCorreoelectronico);
		txtCorreoelectronico.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(236, 300, 100, 29);
		getContentPane().add(btnRegistrar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(121, 300, 100, 29);
		getContentPane().add(btnCancelar);
		
		JLabel lblGnero = new JLabel("G\u00E9nero:");
		lblGnero.setBounds(53, 270, 157, 14);
		getContentPane().add(lblGnero);
		
		comboBox_genero = new JComboBox();
		comboBox_genero.setBounds(226, 270, 202, 20);
		getContentPane().add(comboBox_genero);
		setSize(470, 380);
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
		return txtPrimerapellido;
	}
	public void setTxtPrimerapellido(JTextField txtPrimerapellido) {
		this.txtPrimerapellido = txtPrimerapellido;
	}
	public JTextField getTxtSegundoapellido() {
		return txtSegundoapellido;
	}
	public void setTxtSegundoapellido(JTextField txtSegundoapellido) {
		this.txtSegundoapellido = txtSegundoapellido;
	}
	public JTextField getTxtTelefono() {
		return txtTelefono;
	}
	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}
	public JTextField getTxtSegundonombre() {
		return txtSegundonombre;
	}
	public void setTxtSegundonombre(JTextField txtSegundonombre) {
		this.txtSegundonombre = txtSegundonombre;
	}
	public JTextField getTxtCorreoelectronico() {
		return txtCorreoelectronico;
	}
	public void setTxtCorreoelectronico(JTextField txtCorreoelectronico) {
		this.txtCorreoelectronico = txtCorreoelectronico;
	}
	public JComboBox getComboBox_genero() {
		return comboBox_genero;
	}
	public void setComboBox_genero(JComboBox comboBox_genero) {
		this.comboBox_genero = comboBox_genero;
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
}

package co.powergym.view.usuario.entrenador;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

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
	public JComboBox comboBox_genero;
	private JTable tablePermisos;
	
	public RegistroUsuario() {
		setTitle("Registro de usuario");
		getContentPane().setLayout(null);
		
		txtNumeroid = new JTextField();
		txtNumeroid.setBounds(307, 37, 202, 26);
		getContentPane().add(txtNumeroid);
		txtNumeroid.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(309, 66, 202, 26);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(309, 94, 202, 26);
		getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(309, 182, 202, 26);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblDocumentoDeIdentidad = new JLabel("N\u00FAmero de identificaci\u00F3n");
		lblDocumentoDeIdentidad.setBounds(100, 42, 162, 16);
		getContentPane().add(lblDocumentoDeIdentidad);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(100, 71, 130, 16);
		getContentPane().add(lblNombre);
		
		JLabel lblPrimerApellido = new JLabel("Apellido");
		lblPrimerApellido.setBounds(100, 99, 104, 16);
		getContentPane().add(lblPrimerApellido);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(100, 187, 61, 16);
		getContentPane().add(lblTelefono);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setBounds(100, 126, 130, 16);
		getContentPane().add(lblFechaDeNacimiento);
		
		dateChooserFechaNa = new JDateChooser();
		dateChooserFechaNa.setBounds(309, 122, 202, 20);
		getContentPane().add(dateChooserFechaNa);
		
		JLabel lblCorreoElectrnico = new JLabel("Correo electrónico");
		lblCorreoElectrnico.setBounds(100, 157, 135, 16);
		getContentPane().add(lblCorreoElectrnico);
		
		txtCorreoelectronico = new JTextField();
		txtCorreoelectronico.setBounds(309, 152, 202, 26);
		getContentPane().add(txtCorreoelectronico);
		txtCorreoelectronico.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(344, 432, 100, 29);
		getContentPane().add(btnRegistrar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(229, 432, 100, 29);
		getContentPane().add(btnCancelar);
		
		JLabel lblGnero = new JLabel("G\u00E9nero:");
		lblGnero.setBounds(100, 214, 157, 14);
		getContentPane().add(lblGnero);
		
		comboBox_genero = new JComboBox();
		comboBox_genero.setBounds(309, 212, 202, 20);
		getContentPane().add(comboBox_genero);
		
		JRadioButton rdbtnEntrenador = new JRadioButton("Entrenador");
		rdbtnEntrenador.setBounds(309, 236, 100, 23);
		getContentPane().add(rdbtnEntrenador);
		
		JRadioButton rdbtnAdministrador = new JRadioButton("Administrador");
		rdbtnAdministrador.setBounds(408, 236, 126, 23);
		getContentPane().add(rdbtnAdministrador);
		
		JLabel lblTipoDeUsuario = new JLabel("Tipo de usuario");
		lblTipoDeUsuario.setBounds(100, 240, 130, 16);
		getContentPane().add(lblTipoDeUsuario);
		
		JLabel lblListaDePermisos = new JLabel("Lista de permisos");
		lblListaDePermisos.setBounds(71, 281, 130, 16);
		getContentPane().add(lblListaDePermisos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 297, 463, 112);
		getContentPane().add(scrollPane);
		
		tablePermisos = new JTable();
		scrollPane.setViewportView(tablePermisos);
		setSize(644, 500);
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
	public JComboBox getComboBox_genero() {
		return comboBox_genero;
	}
	public void setComboBox_genero(JComboBox comboBox_genero) {
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
}

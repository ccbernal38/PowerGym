package co.powergym.view.usuario.entrenador;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BusquedaEntrenador extends JFrame{
	/**
	 * 
	 */public JButton btnBuscar1;
	
	public BusquedaEntrenador() {
		setTitle("Buscar entrenador");
		getContentPane().setLayout(null);
		
		txtNumeroid = new JTextField();
		txtNumeroid.setBounds(226, 24, 202, 26);
		getContentPane().add(txtNumeroid);
		txtNumeroid.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(226, 60, 202, 26);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPrimerapellido = new JTextField();
		txtPrimerapellido.setEditable(false);
		txtPrimerapellido.setBounds(226, 120, 202, 26);
		getContentPane().add(txtPrimerapellido);
		txtPrimerapellido.setColumns(10);
		
		txtSegundoapellido = new JTextField();
		txtSegundoapellido.setEditable(false);
		txtSegundoapellido.setBounds(226, 150, 202, 26);
		getContentPane().add(txtSegundoapellido);
		txtSegundoapellido.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
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
		
		/**JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setBounds(53, 180, 130, 16);
		getContentPane().add(lblFechaDeNacimiento);*/
		
		JLabel lblSegundoNombre = new JLabel("Segundo nombre");
		lblSegundoNombre.setBounds(53, 90, 130, 16);
		getContentPane().add(lblSegundoNombre);
		
		txtSegundonombre = new JTextField();
		txtSegundonombre.setEditable(false);
		txtSegundonombre.setBounds(226, 90, 202, 26);
		getContentPane().add(txtSegundonombre);
		txtSegundonombre.setColumns(10);
		
		JLabel lblCorreoElectrnico = new JLabel("Correo electrónico");
		lblCorreoElectrnico.setBounds(53, 210, 135, 16);
		getContentPane().add(lblCorreoElectrnico);
		
		txtCorreoelectronico = new JTextField();
		txtCorreoelectronico.setEditable(false);
		txtCorreoelectronico.setBounds(226, 210, 202, 26);
		getContentPane().add(txtCorreoelectronico);
		txtCorreoelectronico.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(453, 24, 100, 29);
		btnBuscar1 = btnBuscar;
		getContentPane().add(btnBuscar1);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(245, 326, 100, 29);
		btnCancelar1 = btnCancelar;
		getContentPane().add(btnCancelar1);
		
		JLabel label = new JLabel("Género:");
		label.setBounds(53, 270, 157, 14);
		getContentPane().add(label);
		
	/**	txtTxtfechanacimiento = new JTextField();
		txtTxtfechanacimiento.setEditable(false);
		txtTxtfechanacimiento.setBounds(226, 180, 202, 26);
		getContentPane().add(txtTxtfechanacimiento);
		txtTxtfechanacimiento.setColumns(10);*/
		
		txtTxtgenero = new JTextField();
		txtTxtgenero.setEditable(false);
		txtTxtgenero.setBounds(226, 270, 202, 26);
		getContentPane().add(txtTxtgenero);
		txtTxtgenero.setColumns(10);
		setSize(570, 480);
	
	}

	
	private static final long serialVersionUID = 1L;
	public JTextField txtNumeroid;
	public JTextField txtNombre;
	public JTextField txtPrimerapellido;
	public JTextField txtSegundoapellido;
	public JTextField txtTelefono;
	public JTextField txtSegundonombre;
	public JTextField txtCorreoelectronico;
	
	public JButton btnCancelar1;
	//public JTextField txtfechaNacimiento;
	public JTextField txtgenero;
	public JTextField txtTxtfechanacimiento;
	public JTextField txtTxtgenero;
	
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
	public JButton getBtnBuscar() {
		return btnBuscar1;
	}
	public void setBtnRegistrar(JButton btnBuscar) {
		this.btnBuscar1 = btnBuscar;
	}
	public JButton getBtnCancelar() {
		return btnCancelar1;
	}
	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar1 = btnCancelar;
	}
	/**public JTextField getTxtfechaNacimiento() {
		return txtfechaNacimiento;
	}
	public void setTxtfechaNacimiento(JTextField txtfechaNacimiento) {
		this.txtfechaNacimiento = txtfechaNacimiento;
	}*/
	public JTextField getTxtgenero() {
		return txtgenero;
	}
	public void setTxtgenero(JTextField txtgenero) {
		this.txtgenero = txtgenero;
	}
}

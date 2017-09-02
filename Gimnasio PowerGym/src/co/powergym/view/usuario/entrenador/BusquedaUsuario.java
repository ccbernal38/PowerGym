package co.powergym.view.usuario.entrenador;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BusquedaUsuario extends JFrame{
	/**
	 * 
	 */public JButton btnBuscar1;
	
	public BusquedaUsuario() {
		setTitle("Buscar usuario");
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
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setBounds(226, 240, 202, 26);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblDocumentoDeIdentidad = new JLabel("Número de identificación");
		lblDocumentoDeIdentidad.setBounds(53, 30, 162, 16);
		getContentPane().add(lblDocumentoDeIdentidad);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(53, 60, 130, 16);
		getContentPane().add(lblNombre);
		
		JLabel lblPrimerApellido = new JLabel("Apellido");
		lblPrimerApellido.setBounds(53, 120, 104, 16);
		getContentPane().add(lblPrimerApellido);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(53, 240, 61, 16);
		getContentPane().add(lblTelefono);
		
		/**JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setBounds(53, 180, 130, 16);
		getContentPane().add(lblFechaDeNacimiento);*/
		
		
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
	public JTextField txtTelefono;
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

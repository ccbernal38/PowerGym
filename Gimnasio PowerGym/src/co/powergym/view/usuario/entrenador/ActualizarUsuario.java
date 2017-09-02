package co.powergym.view.usuario.entrenador;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import java.awt.Font;

public class ActualizarUsuario extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNumeroid;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtFechanacimiento;
	private JTextField txtCorreoelectronico;
	private JTextField txtTelefono;
	private JLabel lblNombre;
	private JLabel lblFechaDeNacimiento;
	private JLabel lblCorreoElectrnico;
	private JLabel lblNmeroDeContacto;
	public JButton btnActualizar1;	
	private JLabel lblApellido;
	
	
	public ActualizarUsuario() {
		getContentPane().setLayout(null);
		
		txtNumeroid = new JTextField();
		txtNumeroid.setBounds(271, 76, 230, 26);
		getContentPane().add(txtNumeroid);
		txtNumeroid.setColumns(10);
		
		
		txtFechanacimiento = new JTextField();
		txtFechanacimiento.setBounds(271, 163, 230, 26);
		getContentPane().add(txtFechanacimiento);
		txtFechanacimiento.setColumns(10);
		
		txtCorreoelectronico = new JTextField();
		txtCorreoelectronico.setBounds(271, 196, 230, 26);
		getContentPane().add(txtCorreoelectronico);
		txtCorreoelectronico.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(271, 229, 230, 26);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblNmeroDeIdentificacion = new JLabel("Número de identificación");
		lblNmeroDeIdentificacion.setBounds(109, 81, 166, 16);
		getContentPane().add(lblNmeroDeIdentificacion);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(109, 111, 101, 16);
		getContentPane().add(lblNombre);
		
		lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setBounds(109, 168, 130, 16);
		getContentPane().add(lblFechaDeNacimiento);
		
		lblCorreoElectrnico = new JLabel("Correo electrónico");
		lblCorreoElectrnico.setBounds(109, 201, 130, 16);
		getContentPane().add(lblCorreoElectrnico);
		
		lblNmeroDeContacto = new JLabel("Número de contacto");
		lblNmeroDeContacto.setBounds(109, 234, 130, 16);
		getContentPane().add(lblNmeroDeContacto);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(256, 280, 117, 29);
		btnActualizar1 = btnActualizar;
		getContentPane().add(btnActualizar1);
		
		JLabel lblActualizarDatos = new JLabel("Actualizar datos del usuario");
		lblActualizarDatos.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblActualizarDatos.setBounds(199, 21, 230, 16);
		getContentPane().add(lblActualizarDatos);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(271, 106, 230, 26);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		
		txtApellido = new JTextField();
		txtApellido.setBounds(271, 133, 230, 26);
		getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(109, 139, 110, 16);
		getContentPane().add(lblApellido);
		
		setSize(656, 385);
	}

	public JButton getBtnActualizar1() {
		return btnActualizar1;
	}

	public void setBtnActualizar1(JButton btnActualizar1) {
		this.btnActualizar1 = btnActualizar1;
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
	
	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}
	
	public JTextField getTxtFechanacimiento() {
		return txtFechanacimiento;
	}

	public void setTxtFechanacimiento(JTextField txtFechanacimiento) {
		this.txtFechanacimiento = txtFechanacimiento;
	}

	public JTextField getTxtCorreoelectronico() {
		return txtCorreoelectronico;
	}

	public void setTxtCorreoelectronico(JTextField txtCorreoelectronico) {
		this.txtCorreoelectronico = txtCorreoelectronico;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}
}

package co.powergym.view.entrenador;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;

public class ActualizarEntrenador extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNumeroid;
	private JTextField txtSegundoNombre;
	private JTextField txtFechanacimiento;
	private JTextField txtCorreoelectronico;
	private JTextField txtTelefono;
	private JLabel lblNombre;
	private JLabel lblFechaDeNacimiento;
	private JLabel lblCorreoElectrnico;
	private JLabel lblNmeroDeContacto;
	public JButton btnActualizar1;
	private JTextField txtPrimernombre;
	private JLabel lblSegundoNombre;
	private JTextField txtPrimerapellido;
	private JLabel lblPrimerApellido;
	
	public ActualizarEntrenador() {
		getContentPane().setLayout(null);
		
		txtNumeroid = new JTextField();
		txtNumeroid.setBounds(226, 54, 230, 26);
		getContentPane().add(txtNumeroid);
		txtNumeroid.setColumns(10);
		
		txtSegundoNombre = new JTextField();
		txtSegundoNombre.setBounds(226, 114, 230, 26);
		getContentPane().add(txtSegundoNombre);
		txtSegundoNombre.setColumns(10);
		
		txtFechanacimiento = new JTextField();
		txtFechanacimiento.setBounds(226, 183, 230, 26);
		getContentPane().add(txtFechanacimiento);
		txtFechanacimiento.setColumns(10);
		
		txtCorreoelectronico = new JTextField();
		txtCorreoelectronico.setBounds(226, 216, 230, 26);
		getContentPane().add(txtCorreoelectronico);
		txtCorreoelectronico.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(226, 249, 230, 26);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblNmeroDeIdentificacion = new JLabel("Número de identificacion");
		lblNmeroDeIdentificacion.setBounds(64, 59, 166, 16);
		getContentPane().add(lblNmeroDeIdentificacion);
		
		lblNombre = new JLabel("Primer nombre");
		lblNombre.setBounds(63, 89, 101, 16);
		getContentPane().add(lblNombre);
		
		lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setBounds(64, 188, 130, 16);
		getContentPane().add(lblFechaDeNacimiento);
		
		lblCorreoElectrnico = new JLabel("Correo electrónico");
		lblCorreoElectrnico.setBounds(64, 221, 130, 16);
		getContentPane().add(lblCorreoElectrnico);
		
		lblNmeroDeContacto = new JLabel("Número de contacto");
		lblNmeroDeContacto.setBounds(64, 254, 130, 16);
		getContentPane().add(lblNmeroDeContacto);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(211, 305, 117, 29);
		btnActualizar1 = btnActualizar;
		getContentPane().add(btnActualizar1);
		
		JLabel lblActualizarDatos = new JLabel("Actualizar datos");
		lblActualizarDatos.setBounds(163, 6, 110, 16);
		getContentPane().add(lblActualizarDatos);
		
		txtPrimernombre = new JTextField();
		txtPrimernombre.setBounds(226, 84, 230, 26);
		getContentPane().add(txtPrimernombre);
		txtPrimernombre.setColumns(10);
		
		lblSegundoNombre = new JLabel("Segundo nombre");
		lblSegundoNombre.setBounds(64, 119, 117, 16);
		getContentPane().add(lblSegundoNombre);
		
		txtPrimerapellido = new JTextField();
		txtPrimerapellido.setBounds(226, 145, 230, 26);
		getContentPane().add(txtPrimerapellido);
		txtPrimerapellido.setColumns(10);
		
		lblPrimerApellido = new JLabel("Primer apellido");
		lblPrimerApellido.setBounds(64, 147, 110, 16);
		getContentPane().add(lblPrimerApellido);
	}

	public JButton getBtnActualizar1() {
		return btnActualizar1;
	}

	public void setBtnActualizar1(JButton btnActualizar1) {
		this.btnActualizar1 = btnActualizar1;
	}
}
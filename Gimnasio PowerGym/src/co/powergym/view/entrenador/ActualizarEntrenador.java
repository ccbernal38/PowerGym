package co.powergym.view.entrenador;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import java.awt.Font;

public class ActualizarEntrenador extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNumeroid;
	private JTextField txtPrimernombre;
	private JTextField txtSegundoNombre;
	private JTextField txtPrimerapellido;
	private JTextField txtSegundoapellido;
	private JTextField txtFechanacimiento;
	private JTextField txtCorreoelectronico;
	private JTextField txtTelefono;
	private JLabel lblNombre;
	private JLabel lblFechaDeNacimiento;
	private JLabel lblCorreoElectrnico;
	private JLabel lblNmeroDeContacto;
	public JButton btnActualizar1;
	
	private JLabel lblSegundoNombre;
	
	private JLabel lblPrimerApellido;
	
	
	public ActualizarEntrenador() {
		getContentPane().setLayout(null);
		
		txtNumeroid = new JTextField();
		txtNumeroid.setBounds(271, 76, 230, 26);
		getContentPane().add(txtNumeroid);
		txtNumeroid.setColumns(10);
		
		txtSegundoNombre = new JTextField();
		txtSegundoNombre.setBounds(271, 136, 230, 26);
		getContentPane().add(txtSegundoNombre);
		txtSegundoNombre.setColumns(10);
		
		txtFechanacimiento = new JTextField();
		txtFechanacimiento.setBounds(271, 223, 230, 26);
		getContentPane().add(txtFechanacimiento);
		txtFechanacimiento.setColumns(10);
		
		txtCorreoelectronico = new JTextField();
		txtCorreoelectronico.setBounds(271, 256, 230, 26);
		getContentPane().add(txtCorreoelectronico);
		txtCorreoelectronico.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(271, 289, 230, 26);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblNmeroDeIdentificacion = new JLabel("Número de identificacion");
		lblNmeroDeIdentificacion.setBounds(109, 81, 166, 16);
		getContentPane().add(lblNmeroDeIdentificacion);
		
		lblNombre = new JLabel("Primer nombre");
		lblNombre.setBounds(108, 111, 101, 16);
		getContentPane().add(lblNombre);
		
		lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setBounds(109, 228, 130, 16);
		getContentPane().add(lblFechaDeNacimiento);
		
		lblCorreoElectrnico = new JLabel("Correo electrónico");
		lblCorreoElectrnico.setBounds(109, 261, 130, 16);
		getContentPane().add(lblCorreoElectrnico);
		
		lblNmeroDeContacto = new JLabel("Número de contacto");
		lblNmeroDeContacto.setBounds(109, 294, 130, 16);
		getContentPane().add(lblNmeroDeContacto);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(256, 327, 117, 29);
		btnActualizar1 = btnActualizar;
		getContentPane().add(btnActualizar1);
		
		JLabel lblActualizarDatos = new JLabel("Actualizar datos del entrenador");
		lblActualizarDatos.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblActualizarDatos.setBounds(199, 21, 261, 16);
		getContentPane().add(lblActualizarDatos);
		
		txtPrimernombre = new JTextField();
		txtPrimernombre.setBounds(271, 106, 230, 26);
		getContentPane().add(txtPrimernombre);
		txtPrimernombre.setColumns(10);
		
		lblSegundoNombre = new JLabel("Segundo nombre");
		lblSegundoNombre.setBounds(109, 141, 117, 16);
		getContentPane().add(lblSegundoNombre);
		
		txtPrimerapellido = new JTextField();
		txtPrimerapellido.setBounds(271, 167, 230, 26);
		getContentPane().add(txtPrimerapellido);
		txtPrimerapellido.setColumns(10);
		
		lblPrimerApellido = new JLabel("Primer apellido");
		lblPrimerApellido.setBounds(109, 169, 110, 16);
		getContentPane().add(lblPrimerApellido);
		
		txtSegundoapellido = new JTextField();
		txtSegundoapellido.setBounds(271, 195, 230, 26);
		getContentPane().add(txtSegundoapellido);
		txtSegundoapellido.setColumns(10);
		
		JLabel lblSegundoApellido = new JLabel("Segundo apellido");
		lblSegundoApellido.setBounds(109, 197, 123, 16);
		getContentPane().add(lblSegundoApellido);
		
		setSize(656, 480);
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

	public JTextField getTxtPrimernombre() {
		return txtPrimernombre;
	}

	public void setTxtPrimernombre(JTextField txtPrimernombre) {
		this.txtPrimernombre = txtPrimernombre;
	}

	public JTextField getTxtSegundoNombre() {
		return txtSegundoNombre;
	}

	public void setTxtSegundoNombre(JTextField txtSegundoNombre) {
		this.txtSegundoNombre = txtSegundoNombre;
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

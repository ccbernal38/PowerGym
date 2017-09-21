package co.powergym.view.usuario.entrenador;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class ActualizarUsuario extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNumeroid;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCorreoelectronico;
	private JTextField txtTelefono;
	private JLabel lblNombre;
	private JLabel lblFechaDeNacimiento;
	private JLabel lblCorreoElectrnico;
	private JLabel lblNmeroDeContacto;
	public JButton btnActualizar1;	
	private JLabel lblApellido;
	private JTextField textUsuario;
	private JTextField textContrasena;
	private JTextField textconfirmaC;
	private JTable tablePermisos;
	private JDateChooser fechaNacimiento;
	
	
	public ActualizarUsuario() {
		getContentPane().setLayout(null);
		
		txtNumeroid = new JTextField();
		txtNumeroid.setBounds(201, 73, 177, 26);
		getContentPane().add(txtNumeroid);
		txtNumeroid.setColumns(10);
		
		txtCorreoelectronico = new JTextField();
		txtCorreoelectronico.setBounds(158, 148, 220, 26);
		getContentPane().add(txtCorreoelectronico);
		txtCorreoelectronico.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(558, 148, 216, 26);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblNmeroDeIdentificacion = new JLabel("Número de identificación:");
		lblNmeroDeIdentificacion.setBounds(35, 78, 166, 16);
		getContentPane().add(lblNmeroDeIdentificacion);
		
		lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setBounds(416, 114, 140, 16);
		getContentPane().add(lblFechaDeNacimiento);
		
		lblCorreoElectrnico = new JLabel("Correo electrónico:");
		lblCorreoElectrnico.setBounds(35, 153, 130, 16);
		getContentPane().add(lblCorreoElectrnico);
		
		lblNmeroDeContacto = new JLabel("Número de contacto:");
		lblNmeroDeContacto.setBounds(416, 153, 140, 16);
		getContentPane().add(lblNmeroDeContacto);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(360, 498, 117, 29);
		btnActualizar1 = btnActualizar;
		getContentPane().add(btnActualizar1);
		
		JLabel lblActualizarDatos = new JLabel("Actualizar datos del usuario");
		lblActualizarDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblActualizarDatos.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblActualizarDatos.setBounds(289, 19, 230, 16);
		getContentPane().add(lblActualizarDatos);
		
		lblNombre = new JLabel("Nombres:");
		lblNombre.setBounds(416, 78, 61, 16);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(477, 73, 297, 26);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		
		txtApellido = new JTextField();
		txtApellido.setBounds(99, 109, 279, 26);
		getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		lblApellido = new JLabel("Apellidos:");
		lblApellido.setBounds(35, 114, 69, 16);
		getContentPane().add(lblApellido);
		
		JPanel panelCredenciales = new JPanel();
		panelCredenciales.setBorder(new TitledBorder(null, "Credenciales de acceso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCredenciales.setToolTipText("");
		panelCredenciales.setBounds(35, 213, 739, 90);
		getContentPane().add(panelCredenciales);
		panelCredenciales.setLayout(null);
		
		textContrasena = new JTextField();
		textContrasena.setBounds(221, 44, 240, 26);
		panelCredenciales.add(textContrasena);
		textContrasena.setColumns(10);
		
		JLabel lblContrsea = new JLabel("Contraseña:");
		lblContrsea.setBounds(221, 29, 82, 16);
		panelCredenciales.add(lblContrsea);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(23, 44, 176, 26);
		panelCredenciales.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(23, 29, 61, 16);
		panelCredenciales.add(lblUsuario);
		
		JLabel lblConfirmacinDeLa = new JLabel("Confirmación de la contraseña:");
		lblConfirmacinDeLa.setBounds(483, 29, 206, 16);
		panelCredenciales.add(lblConfirmacinDeLa);
		
		textconfirmaC = new JTextField();
		textconfirmaC.setBounds(483, 44, 240, 26);
		panelCredenciales.add(textconfirmaC);
		textconfirmaC.setColumns(10);
		
		JPanel panelPermisos = new JPanel();
		panelPermisos.setBorder(new TitledBorder(null, "Permisos de acceso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPermisos.setBounds(35, 319, 739, 156);
		getContentPane().add(panelPermisos);
		panelPermisos.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 34, 699, 101);
		panelPermisos.add(scrollPane);
		
		tablePermisos = new JTable();
		scrollPane.setColumnHeaderView(tablePermisos);
		
		fechaNacimiento = new JDateChooser();
		fechaNacimiento.setBounds(558, 110, 102, 26);
		getContentPane().add(fechaNacimiento);
		
		setSize(818, 569);
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

	/**
	 * @return the textconfirmaC
	 */
	public JTextField getTextconfirmaC() {
		return textconfirmaC;
	}

	/**
	 * @param textconfirmaC the textconfirmaC to set
	 */
	public void setTextconfirmaC(JTextField textconfirmaC) {
		this.textconfirmaC = textconfirmaC;
	}

	/**
	 * @return the textUsuario
	 */
	public JTextField getTextUsuario() {
		return textUsuario;
	}

	/**
	 * @param textUsuario the textUsuario to set
	 */
	public void setTextUsuario(JTextField textUsuario) {
		this.textUsuario = textUsuario;
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
	public JDateChooser getFechaNacimiento() {
		return fechaNacimiento;
	}
}

package co.powergym.view;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class RegistroEntrenador extends JFrame{
	
	public RegistroEntrenador() {
		setTitle("Registro de entrenador");
		getContentPane().setLayout(null);
		
		txtNumeroid = new JTextField();
		txtNumeroid.setBounds(50, 80, 130, 26);
		getContentPane().add(txtNumeroid);
		txtNumeroid.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(50, 118, 130, 26);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPrimerapellido = new JTextField();
		txtPrimerapellido.setBounds(50, 156, 130, 26);
		getContentPane().add(txtPrimerapellido);
		txtPrimerapellido.setColumns(10);
		
		txtSegundoapellido = new JTextField();
		txtSegundoapellido.setBounds(50, 194, 130, 26);
		getContentPane().add(txtSegundoapellido);
		txtSegundoapellido.setColumns(10);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(50, 237, 130, 26);
		getContentPane().add(txtEdad);
		txtEdad.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(50, 276, 130, 26);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNumeroid;
	private JTextField txtNombre;
	private JTextField txtPrimerapellido;
	private JTextField txtSegundoapellido;
	private JTextField txtEdad;
	private JTextField txtTelefono;
}

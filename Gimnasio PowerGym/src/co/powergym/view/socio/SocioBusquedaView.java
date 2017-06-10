package co.powergym.view.socio;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;

public class SocioBusquedaView extends JFrame{
	
	private JPanel contentPane;
	public JTextField textField_identidad;
	public JTextField textField_primerNombre;
	public JTextField textField_segundoNombre;
	public JTextField textField_primerApellido;
	public JTextField textField_segundoApellido;
	public JTextField textField_telefono;
	public JTextField textField_correoElectronico;
	public JTextField textField_fechaNacimiento;
	public JTextField textField_genero;
	public JButton btnBuscar;  
	private JTextField textField_direccion;
	private JLabel lblFoto;
	
	/**
     * Creates new form RegistroSocio
     */
    public SocioBusquedaView() {

    	setTitle("Buscar un socio");    
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 740, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
        JLabel lblNumeroDeIdentidad = new JLabel("Ingrese el n\u00FAmero de identidad:");
        lblNumeroDeIdentidad.setBounds(39, 69, 159, 20);
        
        textField_identidad = new JTextField();
        textField_identidad.setBounds(211, 69, 86, 20);
        textField_identidad.setColumns(10);
        
        JLabel lblBuscarSocio = new JLabel("Buscar Socio");
        lblBuscarSocio.setBounds(172, 21, 364, 25);
        lblBuscarSocio.setHorizontalAlignment(SwingConstants.CENTER);
        lblBuscarSocio.setFont(new Font("Tahoma", Font.PLAIN, 20));
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(307, 68, 117, 23);
        getContentPane().setLayout(null);
        getContentPane().add(lblNumeroDeIdentidad);
        getContentPane().add(textField_identidad);
        getContentPane().add(lblBuscarSocio);
        getContentPane().add(btnBuscar);
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Socio", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(39, 100, 668, 197);
        getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel lblPrimerApellido = new JLabel("Primer apellido:");
        lblPrimerApellido.setBounds(187, 65, 113, 20);
        panel.add(lblPrimerApellido);
        
        JLabel lblCorreoElectronico = new JLabel("Correo electr\u00F3nico:");
        lblCorreoElectronico.setBounds(187, 92, 113, 20);
        panel.add(lblCorreoElectronico);
        
        JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
        lblFechaDeNacimiento.setBounds(187, 119, 113, 20);
        panel.add(lblFechaDeNacimiento);
        
        JLabel lblNombre = new JLabel("Primer nombre:");
        lblNombre.setBounds(187, 38, 113, 20);
        panel.add(lblNombre);
        
        textField_primerNombre = new JTextField();
        textField_primerNombre.setBounds(308, 38, 122, 20);
        panel.add(textField_primerNombre);
        textField_primerNombre.setEditable(false);
        textField_primerNombre.setColumns(10);
        
        JLabel lblSegundoNombre = new JLabel("Segundo nombre:");
        lblSegundoNombre.setBounds(442, 38, 97, 20);
        panel.add(lblSegundoNombre);
        
        textField_fechaNacimiento = new JTextField();
        textField_fechaNacimiento.setBounds(308, 119, 122, 20);
        panel.add(textField_fechaNacimiento);
        textField_fechaNacimiento.setEditable(false);
        
        textField_primerApellido = new JTextField();
        textField_primerApellido.setBounds(308, 65, 122, 20);
        panel.add(textField_primerApellido);
        textField_primerApellido.setEditable(false);
        textField_primerApellido.setColumns(10);
        
        textField_correoElectronico = new JTextField();
        textField_correoElectronico.setBounds(308, 92, 122, 20);
        panel.add(textField_correoElectronico);
        textField_correoElectronico.setEditable(false);
        textField_correoElectronico.setColumns(10);
        
        JLabel lblGenero = new JLabel("Genero:");
        lblGenero.setBounds(442, 92, 97, 20);
        panel.add(lblGenero);
        
        JLabel lblNewLabel = new JLabel("Tel\u00E9fono:");
        lblNewLabel.setBounds(442, 119, 97, 20);
        panel.add(lblNewLabel);
        
        JLabel lblSegundoNombre_1 = new JLabel("Segundo apellido:");
        lblSegundoNombre_1.setBounds(442, 65, 97, 20);
        panel.add(lblSegundoNombre_1);
        
        textField_segundoNombre = new JTextField();
        textField_segundoNombre.setBounds(538, 38, 120, 20);
        panel.add(textField_segundoNombre);
        textField_segundoNombre.setEditable(false);
        textField_segundoNombre.setColumns(10);
        
        textField_segundoApellido = new JTextField();
        textField_segundoApellido.setBounds(538, 65, 120, 20);
        panel.add(textField_segundoApellido);
        textField_segundoApellido.setEditable(false);
        textField_segundoApellido.setColumns(10);
        
        textField_telefono = new JTextField();
        textField_telefono.setBounds(538, 119, 120, 20);
        panel.add(textField_telefono);
        textField_telefono.setEditable(false);
        textField_telefono.setColumns(10);
        
        textField_genero = new JTextField();
        textField_genero.setBounds(538, 92, 120, 20);
        panel.add(textField_genero);
        textField_genero.setEditable(false);
        textField_genero.setColumns(10);
        
        JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
        lblDireccin.setBounds(187, 146, 113, 20);
        panel.add(lblDireccin);
        
        textField_direccion = new JTextField();
        textField_direccion.setEditable(false);
        textField_direccion.setBounds(308, 146, 350, 20);
        panel.add(textField_direccion);
        textField_direccion.setColumns(10);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Foto", TitledBorder.LEADING, TitledBorder.BOTTOM, null, new Color(0, 0, 0)));
        panel_1.setBounds(10, 22, 167, 164);
        panel.add(panel_1);
        panel_1.setLayout(null);
        
        lblFoto = new JLabel("");
        lblFoto.setBounds(0, 0, 167, 164);
        panel_1.add(lblFoto);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
   
    
	public JTextField getTextField_primerApellido() {
		return textField_primerApellido;
	}
	public JTextField getTextField_identidad() {
		return textField_identidad;
	}
	public JTextField getTextField_correoElectronico() {
		return textField_correoElectronico;
	}
	public JTextField getTextField_primerNombre() {
		return textField_primerNombre;
	}
	public JTextField getTextField_fechaNacimiento() {
		return textField_fechaNacimiento;
	}
	public JTextField getTextField_genero() {
		return textField_genero;
	}
	public JTextField getTextField_telefono() {
		return textField_telefono;
	}
	public JTextField getTextField_segundoNombre() {
		return textField_segundoNombre;
	}
	public JTextField getTextField_segundoApellido() {
		return textField_segundoApellido;
	}
	public JButton getBtnBuscar() {
		return btnBuscar;
	}
	public JLabel getLblFoto() {
		return lblFoto;
	}
}

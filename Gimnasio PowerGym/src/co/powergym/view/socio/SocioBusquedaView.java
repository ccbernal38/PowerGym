package co.powergym.view.socio;

import java.awt.Font;
import java.awt.Image;

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
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.FlowLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class SocioBusquedaView extends JFrame {

	private JPanel contentPane;
	public JTextField textField_identidad;
	public JLabel textField_primerNombre;
	public JLabel textField_telefono;
	public JLabel textField_fechaNacimiento;
	public JButton btnBuscar;
	private JLabel lblFoto;
	private JButton btnAgregarMembresia;
	private JTable table;

	/**
	 * Creates new form RegistroSocio
	 */
	public SocioBusquedaView() {

		setTitle("Buscar un socio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 610, 705);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNumeroDeIdentidad = new JLabel("Ingrese el n\u00FAmero de identidad:");
		lblNumeroDeIdentidad.setBounds(25, 69, 210, 20);

		textField_identidad = new JTextField();
		textField_identidad.setBounds(245, 69, 165, 20);
		textField_identidad.setColumns(10);

		JLabel lblBuscarSocio = new JLabel("Buscar Socio");
		lblBuscarSocio.setBounds(25, 21, 550, 25);
		lblBuscarSocio.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarSocio.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(420, 68, 155, 23);
		getContentPane().setLayout(null);
		getContentPane().add(lblNumeroDeIdentidad);
		getContentPane().add(textField_identidad);
		getContentPane().add(lblBuscarSocio);
		getContentPane().add(btnBuscar);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Socio", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(25, 100, 210, 245);
		getContentPane().add(panel);
		panel.setLayout(null);

		textField_primerNombre = new JLabel();
		textField_primerNombre.setFont(new Font("Avenir Black", Font.BOLD, 11));
		textField_primerNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textField_primerNombre.setText("Primer nombre");
		textField_primerNombre.setBounds(5, 191, 200, 15);
		panel.add(textField_primerNombre);

		textField_fechaNacimiento = new JLabel();
		textField_fechaNacimiento.setFont(new Font("Avenir Black", Font.BOLD, 11));
		textField_fechaNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		textField_fechaNacimiento.setText("Fecha de nacimiento");
		textField_fechaNacimiento.setBounds(5, 206, 200, 15);
		panel.add(textField_fechaNacimiento);

		textField_telefono = new JLabel();
		textField_telefono.setFont(new Font("Avenir Black", Font.BOLD, 11));
		textField_telefono.setHorizontalAlignment(SwingConstants.CENTER);
		textField_telefono.setText("Telefono");
		textField_telefono.setBounds(5, 221, 200, 15);
		panel.add(textField_telefono);

		lblFoto = new JLabel("");
		lblFoto.setBounds(30, 30, 150, 150);
		panel.add(lblFoto);
		lblFoto.setIcon(new ImageIcon(((new ImageIcon("image/avatar.png")).getImage())
				.getScaledInstance(lblFoto.getHeight(), lblFoto.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "Historial de membresias", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(25, 356, 550, 140);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 530, 106);
		panel_1.add(scrollPane);

		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);

		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Fecha de inicio", "Estado" }));
		scrollPane.setViewportView(table);

		JTableHeader header = new JTableHeader();
		header.setName("asdas");
		table.setBounds(10, 23, 530, 106);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Historial de asistencias",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(25, 507, 550, 140);
		contentPane.add(panel_2);

		btnAgregarMembresia = new JButton("<html><center>Agregar<br/> Membresia</center></html>");
		btnAgregarMembresia.setBounds(255, 100, 91, 91);
		contentPane.add(btnAgregarMembresia);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */

	public JTextField getTextField_identidad() {
		return textField_identidad;
	}

	public JLabel getTextField_primerNombre() {
		return textField_primerNombre;
	}

	public JLabel getTextField_fechaNacimiento() {
		return textField_fechaNacimiento;
	}

	public JLabel getTextField_telefono() {
		return textField_telefono;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JLabel getLblFoto() {
		return lblFoto;
	}

	public JButton getBtnAgregarMembresia() {
		return btnAgregarMembresia;
	}
}

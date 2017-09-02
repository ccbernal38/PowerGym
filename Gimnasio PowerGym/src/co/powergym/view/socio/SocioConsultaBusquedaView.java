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
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class SocioConsultaBusquedaView extends JFrame {

	private JPanel contentPane;
	public JLabel textField_nombre;
	public JLabel textField_telefono;
	public JLabel textField_fechaNacimiento;
	private JLabel lblFoto;
	private JButton btnAgregarMembresia;
	private JTable table;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private JButton btnAgregarPago;
	private JButton btnRegistrarVisita;

	/**
	 * Creates new form RegistroSocio
	 */
	public SocioConsultaBusquedaView() {

		setTitle("Buscar un socio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 610, 705);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(42, 45, 52));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBuscarSocio = new JLabel("Consulta de socio");
		lblBuscarSocio.setForeground(Color.WHITE);
		lblBuscarSocio.setBounds(25, 21, 550, 25);
		lblBuscarSocio.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarSocio.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().setLayout(null);
		getContentPane().add(lblBuscarSocio);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(42, 45, 52));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Historial de membresias",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
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
		panel_2.setBackground(new Color(42, 45, 52));
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Historial de asistencias",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		panel_2.setBounds(25, 507, 550, 140);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 23, 530, 106);
		panel_2.add(scrollPane_1);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "D�a", "Fecha", "Hora" }));
		scrollPane_1.setViewportView(table_1);

		btnAgregarMembresia = new JButton("<html><center>Agregar<br/> Membresia</center></html>");
		btnAgregarMembresia.setEnabled(false);
		btnAgregarMembresia.setBounds(185, 207, 91, 91);
		contentPane.add(btnAgregarMembresia);

		btnAgregarPago = new JButton("<html><center>Agregar<br/> Pago</center></html>");
		btnAgregarPago.setEnabled(false);
		btnAgregarPago.setBounds(286, 207, 89, 91);
		contentPane.add(btnAgregarPago);

		lblFoto = new JLabel("");
		lblFoto.setBorder(null);
		lblFoto.setBounds(25, 84, 150, 150);
		contentPane.add(lblFoto);
		lblFoto.setIcon(new ImageIcon(((new ImageIcon("image/avatar.png")).getImage())
				.getScaledInstance(lblFoto.getHeight(), lblFoto.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));

		textField_nombre = new JLabel();
		textField_nombre.setBounds(185, 84, 390, 44);
		contentPane.add(textField_nombre);
		textField_nombre.setForeground(Color.ORANGE);
		textField_nombre.setFont(new Font("Verdana", Font.BOLD, 18));
		textField_nombre.setHorizontalAlignment(SwingConstants.LEFT);
		textField_nombre.setText("Christian Camilo Bernal Rojas");

		textField_fechaNacimiento = new JLabel();
		textField_fechaNacimiento.setBounds(375, 125, 200, 30);
		contentPane.add(textField_fechaNacimiento);
		textField_fechaNacimiento.setForeground(Color.WHITE);
		textField_fechaNacimiento.setFont(new Font("Verdana", Font.BOLD, 14));
		textField_fechaNacimiento.setHorizontalAlignment(SwingConstants.LEFT);
		textField_fechaNacimiento.setText("19/08/2999");

		textField_telefono = new JLabel();
		textField_telefono.setBounds(297, 166, 200, 30);
		contentPane.add(textField_telefono);
		textField_telefono.setForeground(Color.WHITE);
		textField_telefono.setFont(new Font("Verdana", Font.BOLD, 14));
		textField_telefono.setHorizontalAlignment(SwingConstants.LEFT);
		textField_telefono.setText("Telefono");

		JLabel lblFechaDeNacimiento = new JLabel();
		lblFechaDeNacimiento.setText("Fecha de nacimiento:");
		lblFechaDeNacimiento.setHorizontalAlignment(SwingConstants.LEFT);
		lblFechaDeNacimiento.setForeground(Color.WHITE);
		lblFechaDeNacimiento.setFont(new Font("Verdana", Font.BOLD, 14));
		lblFechaDeNacimiento.setBounds(185, 125, 180, 30);
		contentPane.add(lblFechaDeNacimiento);

		JLabel lblTelfono = new JLabel();
		lblTelfono.setText("Tel\u00E9fono:");
		lblTelfono.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelfono.setForeground(Color.WHITE);
		lblTelfono.setFont(new Font("Verdana", Font.BOLD, 14));
		lblTelfono.setBounds(185, 166, 102, 30);
		contentPane.add(lblTelfono);
		
		btnRegistrarVisita = new JButton("<html><center>Registrar<br/> Visita</center></html>");
		btnRegistrarVisita.setEnabled(false);
		btnRegistrarVisita.setBounds(385, 207, 89, 91);
		contentPane.add(btnRegistrarVisita);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */

	public JLabel getTextField_primerNombre() {
		return textField_nombre;
	}

	public JLabel getTextField_fechaNacimiento() {
		return textField_fechaNacimiento;
	}

	public JLabel getTextField_telefono() {
		return textField_telefono;
	}

	public JLabel getLblFoto() {
		return lblFoto;
	}

	public JButton getBtnAgregarMembresia() {
		return btnAgregarMembresia;
	}

	public JTable getTableHistorico() {
		return table;
	}

	public JTable getTableAsistencias() {
		return table_1;
	}

	public JButton getBtnAgregarPago() {
		return btnAgregarPago;
	}
	public JButton getBtnRegistrarVisita() {
		return btnRegistrarVisita;
	}
}

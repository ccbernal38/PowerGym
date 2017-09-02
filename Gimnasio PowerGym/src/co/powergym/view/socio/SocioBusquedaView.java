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

public class SocioBusquedaView extends JFrame {

	private JPanel contentPane;
	public JTextField textField_identidad;
	public JLabel textField_nombre;
	public JLabel textField_telefono;
	public JLabel textField_fechaNacimiento;
	public JButton btnBuscar;
	private JLabel lblFoto;
	private JButton btnAgregarMembresia;
	private JTable table;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private JButton btnAgregarPago;

	/**
	 * Creates new form RegistroSocio
	 */
	public SocioBusquedaView() {

		setTitle("Buscar un socio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 610, 705);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 39, 49));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNumeroDeIdentidad = new JLabel("Ingrese el n�mero de identidad:");
		lblNumeroDeIdentidad.setForeground(Color.WHITE);
		lblNumeroDeIdentidad.setBounds(25, 69, 210, 20);

		textField_identidad = new JTextField();
		textField_identidad.setBounds(245, 69, 165, 20);
		textField_identidad.setColumns(10);

		JLabel lblBuscarSocio = new JLabel("Buscar Socio");
		lblBuscarSocio.setForeground(Color.WHITE);
		lblBuscarSocio.setBounds(25, 21, 550, 25);
		lblBuscarSocio.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarSocio.setFont(new Font("Tahoma", Font.BOLD, 20));

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(420, 68, 155, 23);
		getContentPane().setLayout(null);
		getContentPane().add(lblNumeroDeIdentidad);
		getContentPane().add(textField_identidad);
		getContentPane().add(lblBuscarSocio);
		getContentPane().add(btnBuscar);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 39, 49));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Socio", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		panel.setBounds(25, 100, 210, 245);
		getContentPane().add(panel);
		panel.setLayout(null);

		textField_nombre = new JLabel();
		textField_nombre.setForeground(Color.WHITE);
		textField_nombre.setFont(new Font("Avenir Black", Font.BOLD, 11));
		textField_nombre.setHorizontalAlignment(SwingConstants.CENTER);
		textField_nombre.setText("Primer nombre");
		textField_nombre.setBounds(5, 191, 200, 15);
		panel.add(textField_nombre);

		textField_fechaNacimiento = new JLabel();
		textField_fechaNacimiento.setForeground(Color.WHITE);
		textField_fechaNacimiento.setFont(new Font("Avenir Black", Font.BOLD, 11));
		textField_fechaNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		textField_fechaNacimiento.setText("Fecha de nacimiento");
		textField_fechaNacimiento.setBounds(5, 206, 200, 15);
		panel.add(textField_fechaNacimiento);

		textField_telefono = new JLabel();
		textField_telefono.setForeground(Color.WHITE);
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
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(32, 39, 49));
		panel_1.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Historial de membresias", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
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
		panel_2.setBackground(new Color(32, 39, 49));
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Historial de asistencias", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		panel_2.setBounds(25, 507, 550, 140);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 23, 530, 106);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"D�a", "Fecha", "Hora"
			}
		));
		scrollPane_1.setViewportView(table_1);

		btnAgregarMembresia = new JButton("<html><center>Agregar<br/> Membresia</center></html>");
		btnAgregarMembresia.setEnabled(false);
		btnAgregarMembresia.setBounds(255, 100, 91, 91);
		contentPane.add(btnAgregarMembresia);
		
		btnAgregarPago = new JButton("<html><center>Agregar<br/> Pago</center></html>");
		btnAgregarPago.setEnabled(false);
		btnAgregarPago.setBounds(356, 100, 89, 91);
		contentPane.add(btnAgregarPago);
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
		return textField_nombre;
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
	public JTable getTableHistorico() {
		return table;
	}
	public JTable getTableAsistencias() {
		return table_1;
	}
	public JButton getBtnAgregarPago() {
		return btnAgregarPago;
	}
}

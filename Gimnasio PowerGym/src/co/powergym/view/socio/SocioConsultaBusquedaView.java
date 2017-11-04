package co.powergym.view.socio;

import java.awt.Font;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
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

import co.powergym.utils.ButtonSecundario;
import co.powergym.utils.Constantes;

import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;

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
	private JLabel lblSaldoAFavor;
	private JLabel labelSaldoFavor;
	private JLabel lblDeudas;
	private JLabel labelDeuda;
	private JPanel panel;
	private JScrollPane scrollPane_2;
	private JPanel panel_3;
	private JScrollPane scrollPane_3;
	private JTable tableHistorialPagos;
	private JTable tableHistorialVisitas;
	private JButton btnEliminar;
	private JCheckBox chckbxInactivo;
	private JPanel panel_4;

	/**
	 * Creates new form RegistroSocio
	 */
	public SocioConsultaBusquedaView() {

		setTitle("Buscar un socio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 812, 648);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Constantes.black());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(Constantes.black());
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Historial de membresias",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		panel_1.setBounds(25, 272, 376, 175);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 350, 119);
		panel_1.add(scrollPane);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setForeground(Color.BLACK);
		table.setGridColor(Constantes.white());
		table.setBorder(null);
		table.setFillsViewportHeight(true);
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Fecha de inicio", "Estado" }));
		scrollPane.setViewportView(table);

		JTableHeader header = new JTableHeader();
		header.setName("asdas");
		table.setBounds(10, 23, 530, 106);

		btnEliminar = new ButtonSecundario("Eliminar membresia activa");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminar.setBounds(160, 15, 200, 23);
		panel_1.add(btnEliminar);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Constantes.black());
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Historial de asistencias",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		panel_2.setBounds(25, 458, 376, 140);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 23, 350, 106);
		panel_2.add(scrollPane_1);

		table_1 = new JTable();
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setForeground(Color.BLACK);
		table_1.setGridColor(Constantes.white());
		table_1.setBorder(null);
		table_1.setFillsViewportHeight(true);
		table_1.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "D�a", "Fecha", "Hora" }));
		scrollPane_1.setViewportView(table_1);

		btnAgregarMembresia = new ButtonSecundario("<html><center>Agregar<br/> Membresia</center></html>");
		btnAgregarMembresia.setBackground(Color.LIGHT_GRAY);
		btnAgregarMembresia.setEnabled(false);
		btnAgregarMembresia.setBounds(185, 207, 91, 54);
		contentPane.add(btnAgregarMembresia);

		btnAgregarPago = new ButtonSecundario("<html><center>Agregar<br/> Pago</center></html>");
		btnAgregarPago.setBackground(Color.LIGHT_GRAY);
		btnAgregarPago.setEnabled(false);
		btnAgregarPago.setBounds(286, 207, 89, 54);
		contentPane.add(btnAgregarPago);

		lblFoto = new JLabel("");
		lblFoto.setBorder(null);
		lblFoto.setBounds(25, 57, 150, 150);
		contentPane.add(lblFoto);
		lblFoto.setIcon(new ImageIcon(((new ImageIcon("image/avatar.png")).getImage())
				.getScaledInstance(lblFoto.getHeight(), lblFoto.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));

		textField_nombre = new JLabel();
		textField_nombre.setBounds(185, 57, 390, 44);
		contentPane.add(textField_nombre);
		textField_nombre.setForeground(Color.WHITE);
		textField_nombre.setFont(new Font("Verdana", Font.BOLD, 18));
		textField_nombre.setHorizontalAlignment(SwingConstants.LEFT);
		textField_nombre.setText("Christian Camilo Bernal Rojas");

		textField_fechaNacimiento = new JLabel();
		textField_fechaNacimiento.setBounds(375, 98, 200, 30);
		contentPane.add(textField_fechaNacimiento);
		textField_fechaNacimiento.setForeground(Color.WHITE);
		textField_fechaNacimiento.setFont(new Font("Verdana", Font.BOLD, 14));
		textField_fechaNacimiento.setHorizontalAlignment(SwingConstants.LEFT);
		textField_fechaNacimiento.setText("19/08/2999");

		textField_telefono = new JLabel();
		textField_telefono.setBounds(297, 127, 200, 30);
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
		lblFechaDeNacimiento.setBounds(185, 98, 180, 30);
		contentPane.add(lblFechaDeNacimiento);

		JLabel lblTelfono = new JLabel();
		lblTelfono.setText("Tel\u00E9fono:");
		lblTelfono.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelfono.setForeground(Color.WHITE);
		lblTelfono.setFont(new Font("Verdana", Font.BOLD, 14));
		lblTelfono.setBounds(185, 127, 102, 30);
		contentPane.add(lblTelfono);

		btnRegistrarVisita = new ButtonSecundario("<html><center>Registrar<br/> Visita</center></html>");
		btnRegistrarVisita.setBackground(Color.LIGHT_GRAY);
		btnRegistrarVisita.setEnabled(false);
		btnRegistrarVisita.setBounds(385, 207, 89, 54);
		contentPane.add(btnRegistrarVisita);

		lblSaldoAFavor = new JLabel();
		lblSaldoAFavor.setText("Saldo a favor:");
		lblSaldoAFavor.setHorizontalAlignment(SwingConstants.LEFT);
		lblSaldoAFavor.setForeground(Color.WHITE);
		lblSaldoAFavor.setFont(new Font("Verdana", Font.BOLD, 14));
		lblSaldoAFavor.setBounds(185, 152, 126, 30);
		contentPane.add(lblSaldoAFavor);

		labelSaldoFavor = new JLabel();
		labelSaldoFavor.setText("$ 0");
		labelSaldoFavor.setHorizontalAlignment(SwingConstants.LEFT);
		labelSaldoFavor.setForeground(new Color(34, 139, 34));
		labelSaldoFavor.setFont(new Font("Verdana", Font.BOLD, 14));
		labelSaldoFavor.setBounds(297, 152, 200, 30);
		contentPane.add(labelSaldoFavor);

		lblDeudas = new JLabel();
		lblDeudas.setText("Deudas:");
		lblDeudas.setHorizontalAlignment(SwingConstants.LEFT);
		lblDeudas.setForeground(Color.WHITE);
		lblDeudas.setFont(new Font("Verdana", Font.BOLD, 14));
		lblDeudas.setBounds(185, 177, 126, 30);
		contentPane.add(lblDeudas);

		labelDeuda = new JLabel();
		labelDeuda.setText("$ 0");
		labelDeuda.setHorizontalAlignment(SwingConstants.LEFT);
		labelDeuda.setForeground(new Color(128, 0, 0));
		labelDeuda.setFont(new Font("Verdana", Font.BOLD, 14));
		labelDeuda.setBounds(297, 177, 200, 30);
		contentPane.add(labelDeuda);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Historial de pagos",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel.setBackground(Constantes.black());
		panel.setBounds(411, 272, 376, 175);
		contentPane.add(panel);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 23, 350, 141);
		panel.add(scrollPane_2);

		tableHistorialPagos = new JTable();
		tableHistorialPagos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableHistorialPagos.setForeground(Color.BLACK);
		tableHistorialPagos.setGridColor(Constantes.white());
		tableHistorialPagos.setBorder(null);
		tableHistorialPagos.setFillsViewportHeight(true);
		tableHistorialPagos
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Id", "Valor", "Fecha de pago" }));
		tableHistorialPagos.getColumnModel().getColumn(0).setMaxWidth(30);
		scrollPane_2.setViewportView(tableHistorialPagos);

		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Historial de visitas",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_3.setBackground(Constantes.black());
		panel_3.setBounds(411, 458, 376, 140);
		contentPane.add(panel_3);

		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 23, 350, 106);
		panel_3.add(scrollPane_3);

		tableHistorialVisitas = new JTable();
		tableHistorialVisitas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableHistorialVisitas.setForeground(Color.BLACK);
		tableHistorialVisitas.setGridColor(Constantes.white());
		tableHistorialVisitas.setBorder(null);
		tableHistorialVisitas.setFillsViewportHeight(true);
		tableHistorialVisitas
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "id", "Valor", "Fecha" }));
		tableHistorialVisitas.getColumnModel().getColumn(0).setMaxWidth(30);
		scrollPane_3.setViewportView(tableHistorialVisitas);

		chckbxInactivo = new JCheckBox("Inactivo");
		chckbxInactivo.setForeground(Color.WHITE);
		chckbxInactivo.setBackground(Constantes.black());
		chckbxInactivo.setBounds(498, 238, 97, 23);
		contentPane.add(chckbxInactivo);
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(0, 0, 796, 56);
		contentPane.add(panel_4);
				panel_4.setLayout(new BorderLayout(0, 0));
		
				JLabel lblBuscarSocio = new JLabel("Consulta de socio");
				panel_4.add(lblBuscarSocio);
				lblBuscarSocio.setForeground(new Color(74, 74, 72));
				lblBuscarSocio.setHorizontalAlignment(SwingConstants.CENTER);
				lblBuscarSocio.setFont(new Font("Tahoma", Font.BOLD, 20));
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

	public JLabel getLabelSaldoFavor() {
		return labelSaldoFavor;
	}

	public JLabel getLabelDeuda() {
		return labelDeuda;
	}

	public JTable getTableHistorialVisitas() {
		return tableHistorialVisitas;
	}

	public JTable getTableHistorialPagos() {
		return tableHistorialPagos;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JCheckBox getChckbxInactivo() {
		return chckbxInactivo;
	}
}

package co.powergym.view.socio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import java.awt.ScrollPane;
import com.toedter.calendar.JYearChooser;

import co.powergym.utils.ButtonSecundario;
import co.powergym.utils.Constantes;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class SocioListadoView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnEditar;
	private JPanel panel;
	private JLabel lblListadoDeSocios;

	/**
	 * Create the frame.
	 */
	public SocioListadoView() {
		setResizable(false);
		setTitle("Listado de socios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 720, 464);
		contentPane = new JPanel();
		contentPane.setBackground(Constantes.black());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setBackground(new Color(32, 39, 49));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 94, 667, 290);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setForeground(Color.BLACK);
		table.setGridColor(Constantes.white());
		table.setBorder(null);
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nro. identificación", "Nombre", "Correo electrónico", "Teléfono" }));

		scrollPane.setViewportView(table);
		
		btnEditar = new ButtonSecundario("Editar");
		btnEditar.setBounds(574, 395, 117, 29);
		contentPane.add(btnEditar);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 714, 56);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		lblListadoDeSocios = new JLabel("Listado de Socios");
		lblListadoDeSocios.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoDeSocios.setFont(new Font("Verdana", Font.BOLD, 18));
		panel.add(lblListadoDeSocios, BorderLayout.CENTER);

		JTableHeader header = new JTableHeader();
		header.setName("asdas");
	}

	public JTable getTableSocios() {
		return table;
	}

	/**
	 * @return the btnEditar
	 */
	public JButton getBtnEditar() {
		return btnEditar;
	}

	/**
	 * @param btnEditar the btnEditar to set
	 */
	public void setBtnEditar(JButton btnEditar) {
		this.btnEditar = btnEditar;
	}

	/**
	 * @param tableSocios the tableSocios to set
	 */
	public void setTableSocios(JTable tableSocios) {
		this.table = tableSocios;
	}
}

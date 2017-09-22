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
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class SocioListadoView extends JFrame {

	private JPanel contentPane;
	private JTable tableSocios;
	private JButton btnEditar;

	/**
	 * Create the frame.
	 */
	public SocioListadoView() {
		setTitle("Listado de socios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 707, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setBackground(new Color(32, 39, 49));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 29, 667, 290);
		contentPane.add(scrollPane);

		tableSocios = new JTable();
		tableSocios.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nro. identificacion", "Nombre", "Correo electr�nico", "Tel�fono" }));

		scrollPane.setViewportView(tableSocios);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(297, 348, 117, 29);
		contentPane.add(btnEditar);

		JTableHeader header = new JTableHeader();
		header.setName("asdas");
	}

	public JTable getTableSocios() {
		return tableSocios;
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
		this.tableSocios = tableSocios;
	}
}

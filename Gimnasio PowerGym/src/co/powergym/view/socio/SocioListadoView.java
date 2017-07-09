package co.powergym.view.socio;

import java.awt.BorderLayout;
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

public class SocioListadoView extends JFrame {

	private JPanel contentPane;
	private JTable tableSocios;

	/**
	 * Create the frame.
	 */
	public SocioListadoView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LISTADO DE SOCIOS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(213, 11, 206, 42);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 79, 614, 290);
		contentPane.add(scrollPane);
		
		tableSocios = new JTable();
		tableSocios.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nro. identificacion", "Nombre", "Dirección", "Correo electrónico", "Teléfono" }));
		
		scrollPane.setViewportView(tableSocios);
		
		JTableHeader header = new JTableHeader();
		header.setName("asdas");
	}

	public JTable getTableSocios() {
		return tableSocios;
	}
}

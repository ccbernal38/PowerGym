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
		
		
		
		tableSocios = new JTable();
		tableSocios.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Identificaci\u00F3n", "Nombre"
			}
		));
		tableSocios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableSocios.setBounds(-32, 68, 579, 301);
		JTableHeader header = new JTableHeader();
		header.setName("asdas");
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(22, 71, 584, 251);
		scrollPane.add(tableSocios);
		contentPane.add(scrollPane);
	}
	public JTable getTableSocios() {
		return tableSocios;
	}
}

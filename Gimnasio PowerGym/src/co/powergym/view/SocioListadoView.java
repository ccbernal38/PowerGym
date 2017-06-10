package co.powergym.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SocioListadoView extends JFrame {

	private JPanel contentPane;
	private JTable tableSocios;

	/**
	 * Create the frame.
	 */
	public SocioListadoView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 646, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tableSocios = new JTable();
		tableSocios.setBounds(10, 11, 610, 381);
		contentPane.add(tableSocios);
	}
	public JTable getTableSocios() {
		return tableSocios;
	}
}

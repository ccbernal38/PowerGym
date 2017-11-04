package co.powergym.view.caja;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import co.powergym.utils.ButtonSecundario;
import co.powergym.utils.Constantes;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CajaListaIngresosHoyView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnSalir;
	private JPanel panel;

	
	/**
	 * Create the frame.
	 */
	public CajaListaIngresosHoyView() {
		setResizable(false);
		setTitle("Ingresos del dia");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 658, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Constantes.black());
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 622, 307);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Fecha", "Concepto", "Saldo" }));
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(1).setMinWidth(10);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setForeground(Color.BLACK);
		table.setGridColor(Constantes.white());
		table.setBorder(null);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);

		btnSalir = new ButtonSecundario("Cancelar");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalir.setBounds(543, 397, 89, 23);
		contentPane.add(btnSalir);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 652, 56);
		contentPane.add(panel);
				panel.setLayout(new BorderLayout(0, 0));
		
				JLabel lblNewLabel = new JLabel("INGRESOS DE HOY");
				panel.add(lblNewLabel);
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
	}
	public JButton getBtnSalir() {
		return btnSalir;
	}
	public JTable getTable() {
		return table;
	}
}

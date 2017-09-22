package co.powergym.view.caja;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class CajaHistoricoView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnCancelar;

	/**
	 * Create the frame.
	 */
	public CajaHistoricoView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1020, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 974, 256);
		panel.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Fecha de apertura", "Fecha de cierre", "Total de visitas", "Total de membresias",
						"Total de saldo a favor", "Total de adeudos", "Total de egresos", "Saldo final",
						"Responsable Apertura", "Responsable de cierre" }));
		table.getColumnModel().getColumn(0).setMaxWidth(40);

		table.setFont(new Font("Verdana", Font.PLAIN, 11));
		scrollPane.setViewportView(table);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(895, 278, 89, 23);
		panel.add(btnCancelar);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Historico de caja");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		panel_1.add(lblNewLabel);
	}

	public JTable getTable() {
		return table;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}

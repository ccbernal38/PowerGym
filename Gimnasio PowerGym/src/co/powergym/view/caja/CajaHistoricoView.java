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

import co.powergym.utils.ButtonSecundario;
import co.powergym.utils.Constantes;

import javax.swing.JButton;
import java.awt.Color;

public class CajaHistoricoView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnCancelar;

	/**
	 * Create the frame.
	 */
	public CajaHistoricoView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1020, 398);
		contentPane = new JPanel();
		contentPane.setBackground(Constantes.black());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 1004, 56);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Historico de caja");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		panel_1.add(lblNewLabel);

		btnCancelar = new ButtonSecundario("Cancelar");
		btnCancelar.setBounds(905, 323, 89, 23);
		contentPane.add(btnCancelar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Constantes.black());
		scrollPane.setBounds(0, 56, 1004, 256);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Id", "Fecha de apertura", "Fecha de cierre",
						"Total de ingresos", "Total de egresos", "Responsable Apertura", "Responsable de cierre" }));
		table.getColumnModel().getColumn(0).setMaxWidth(40);

		table.setFont(new Font("Verdana", Font.PLAIN, 11));
		scrollPane.setViewportView(table);
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}

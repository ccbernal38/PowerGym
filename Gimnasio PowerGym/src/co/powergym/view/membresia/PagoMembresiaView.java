package co.powergym.view.membresia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

public class PagoMembresiaView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JLabel lblPago;
	private JLabel lblNuevoBalance;
	private JLabel lblBalance;
	private JButton btnCancelar;
	private JButton btnPagar;

	/**
	 * Create the frame.
	 */
	public PagoMembresiaView() {
		setTitle("Pago de membresias");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 693, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 657, 135);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Verdana", Font.PLAIN, 11));
		scrollPane.setViewportView(table);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);

		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Fecha Asignacion", "Producto Adquirido", "Costo Membresia" }));

		JLabel lblBalanceAPagar = new JLabel("Balance a pagar:");
		lblBalanceAPagar.setFont(new Font("Verdana", Font.BOLD, 12));
		lblBalanceAPagar.setBounds(388, 230, 172, 14);
		contentPane.add(lblBalanceAPagar);

		JLabel lblNuevoPago = new JLabel("Nuevo pago:");
		lblNuevoPago.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNuevoPago.setBounds(388, 255, 172, 14);
		contentPane.add(lblNuevoPago);

		JLabel lblElNuevoBalance = new JLabel("El nuevo balance ser\u00E1:");
		lblElNuevoBalance.setFont(new Font("Verdana", Font.BOLD, 12));
		lblElNuevoBalance.setBounds(388, 280, 172, 14);
		contentPane.add(lblElNuevoBalance);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(388, 305, 279, 120);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNuevoPago_1 = new JLabel("NUEVO PAGO");
		lblNuevoPago_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoPago_1.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNuevoPago_1.setBounds(10, 11, 259, 23);
		panel.add(lblNuevoPago_1);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setForeground(new Color(34, 139, 34));
		textField.setFont(new Font("Verdana", Font.BOLD, 48));
		textField.setBounds(10, 36, 259, 73);
		panel.add(textField);
		textField.setColumns(10);

		lblBalance = new JLabel("$0");
		lblBalance.setForeground(Color.RED);
		lblBalance.setFont(new Font("Verdana", Font.BOLD, 11));
		lblBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBalance.setBounds(529, 230, 138, 14);
		contentPane.add(lblBalance);

		lblPago = new JLabel("$0");
		lblPago.setForeground(new Color(34, 139, 34));
		lblPago.setFont(new Font("Verdana", Font.BOLD, 11));
		lblPago.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPago.setBounds(529, 255, 138, 14);
		contentPane.add(lblPago);

		lblNuevoBalance = new JLabel("$0");
		lblNuevoBalance.setFont(new Font("Verdana", Font.BOLD, 11));
		lblNuevoBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNuevoBalance.setBounds(529, 280, 138, 14);
		contentPane.add(lblNuevoBalance);

		JLabel lblPagoDe = new JLabel("Pago de balances pendientes");
		lblPagoDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblPagoDe.setFont(new Font("Verdana", Font.BOLD, 18));
		lblPagoDe.setBounds(10, 21, 657, 38);
		contentPane.add(lblPagoDe);

		btnPagar = new JButton("Pagar");
		btnPagar.setBounds(537, 438, 130, 23);
		contentPane.add(btnPagar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(388, 438, 130, 23);
		contentPane.add(btnCancelar);
	}

	public JTextField getTextFieldPago() {
		return textField;
	}

	public JTable getTablePendientes() {
		return table;
	}

	public JLabel getLblPago() {
		return lblPago;
	}

	public JLabel getLblNuevoBalance() {
		return lblNuevoBalance;
	}

	public JLabel getLblBalance() {
		return lblBalance;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JButton getBtnPagar() {
		return btnPagar;
	}
}

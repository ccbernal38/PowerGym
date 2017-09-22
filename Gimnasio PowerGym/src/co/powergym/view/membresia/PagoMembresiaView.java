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
import javax.swing.JCheckBox;

public class PagoMembresiaView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JLabel lblSaldoFavor;
	private JLabel lblNuevoBalance;
	private JLabel lblBalance;
	private JButton btnCancelar;
	private JButton btnPagar;
	private JLabel lblSaldoFavorActual;
	private JTextField textFieldSaldoUsar;
	private JCheckBox chckbxSi;

	/**
	 * Create the frame.
	 */
	public PagoMembresiaView() {
		setTitle("Pago de membresias");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 693, 511);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(74, 74, 72));
		contentPane.setBackground((new Color(127, 190, 235)));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 657, 135);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setForeground(new Color(74, 74, 72));
		table.setFont(new Font("Verdana", Font.PLAIN, 11));
		scrollPane.setViewportView(table);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);

		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Fecha Asignacion", "Producto Adquirido", "Costo Membresia" }));

		JLabel lblBalanceAPagar = new JLabel("Balance a pagar:");
		lblBalanceAPagar.setForeground(new Color(74, 74, 72));
		lblBalanceAPagar.setFont(new Font("Verdana", Font.BOLD, 12));
		lblBalanceAPagar.setBounds(388, 230, 172, 14);
		contentPane.add(lblBalanceAPagar);

		JLabel lblNuevoPago = new JLabel("Saldo a favor:");
		lblNuevoPago.setForeground(new Color(74, 74, 72));
		lblNuevoPago.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNuevoPago.setBounds(388, 255, 172, 14);
		contentPane.add(lblNuevoPago);

		JLabel lblElNuevoBalance = new JLabel("El nuevo balance ser\u00E1:");
		lblElNuevoBalance.setForeground(new Color(74, 74, 72));
		lblElNuevoBalance.setFont(new Font("Verdana", Font.BOLD, 12));
		lblElNuevoBalance.setBounds(388, 280, 172, 14);
		contentPane.add(lblElNuevoBalance);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(388, 305, 279, 120);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNuevoPago_1 = new JLabel("NUEVO PAGO");
		lblNuevoPago_1.setForeground(new Color(74, 74, 72));
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

		lblSaldoFavor = new JLabel("$0");
		lblSaldoFavor.setForeground(new Color(34, 139, 34));
		lblSaldoFavor.setFont(new Font("Verdana", Font.BOLD, 11));
		lblSaldoFavor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSaldoFavor.setBounds(529, 255, 138, 14);
		contentPane.add(lblSaldoFavor);

		lblNuevoBalance = new JLabel("$0");
		lblNuevoBalance.setForeground(new Color(74, 74, 72));
		lblNuevoBalance.setFont(new Font("Verdana", Font.BOLD, 11));
		lblNuevoBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNuevoBalance.setBounds(529, 280, 138, 14);
		contentPane.add(lblNuevoBalance);

		JLabel lblPagoDe = new JLabel("Pago de balances pendientes");
		lblPagoDe.setForeground(new Color(74, 74, 72));
		lblPagoDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblPagoDe.setFont(new Font("Verdana", Font.BOLD, 18));
		lblPagoDe.setBounds(10, 21, 657, 38);
		contentPane.add(lblPagoDe);

		btnPagar = new JButton("Pagar");
		btnPagar.setForeground(new Color(74, 74, 72));
		btnPagar.setBackground(Color.LIGHT_GRAY);
		btnPagar.setBounds(537, 438, 130, 23);
		contentPane.add(btnPagar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(74, 74, 72));
		btnCancelar.setBackground(Color.LIGHT_GRAY);
		btnCancelar.setBounds(388, 438, 130, 23);
		contentPane.add(btnCancelar);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBounds(10, 230, 368, 110);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u00BFDesea utilizar el saldo a favor?");
		lblNewLabel.setForeground(new Color(74, 74, 72));
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 39, 187, 14);
		panel_1.add(lblNewLabel);

		chckbxSi = new JCheckBox("Si");
		chckbxSi.setForeground(new Color(74, 74, 72));
		chckbxSi.setFont(new Font("Verdana", Font.PLAIN, 11));
		chckbxSi.setBounds(203, 35, 97, 23);
		panel_1.add(chckbxSi);

		JLabel lblSaldoAFavor = new JLabel("SALDO A FAVOR");
		lblSaldoAFavor.setForeground(new Color(74, 74, 72));
		lblSaldoAFavor.setHorizontalAlignment(SwingConstants.LEFT);
		lblSaldoAFavor.setFont(new Font("Verdana", Font.BOLD, 18));
		lblSaldoAFavor.setBounds(10, 11, 187, 23);
		panel_1.add(lblSaldoAFavor);

		lblSaldoFavorActual = new JLabel("$ 0");
		lblSaldoFavorActual.setFont(new Font("Verdana", Font.BOLD, 18));
		lblSaldoFavorActual.setForeground(new Color(34, 139, 34));
		lblSaldoFavorActual.setBounds(203, 11, 155, 23);
		panel_1.add(lblSaldoFavorActual);
		
		textFieldSaldoUsar = new JTextField();
		textFieldSaldoUsar.setForeground(new Color(74, 74, 72));
		textFieldSaldoUsar.setText("0");
		textFieldSaldoUsar.setEnabled(false);
		textFieldSaldoUsar.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldSaldoUsar.setBounds(203, 64, 155, 23);
		panel_1.add(textFieldSaldoUsar);
		textFieldSaldoUsar.setColumns(10);
		
		JLabel lblValorAUtilizar = new JLabel("Valor a utilizar:");
		lblValorAUtilizar.setForeground(new Color(74, 74, 72));
		lblValorAUtilizar.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblValorAUtilizar.setBounds(10, 68, 187, 14);
		panel_1.add(lblValorAUtilizar);
	}

	public JTextField getTextFieldPago() {
		return textField;
	}

	public JTable getTablePendientes() {
		return table;
	}

	public JLabel getLblPago() {
		return lblSaldoFavor;
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
	public JLabel getLblSaldoFavorActual() {
		return lblSaldoFavorActual;
	}
	public JCheckBox getChckbxSi() {
		return chckbxSi;
	}
	public JTextField getTextFieldSaldoUsar() {
		return textFieldSaldoUsar;
	}
}

package co.powergym.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JButton;

public class ReciboView extends JFrame implements Printable {

	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel9;
	private JPanel contentPane;
	private JLabel jLabel1;
	private JTextField textFieldPaga;
	private JTextField textFieldUsadoSaldoFavor;
	private JTextField textFieldDebe;
	private JTextField textFieldSaldoFavor;
	private JLabel labelOperador;
	private JLabel labelFecha;
	private JLabel labelCliente;
	private JButton btnImprimir;
	private JTextPane textPaneDescripcion;
	private JPanel panel;
	private JLabel labelNumero;

	
	/**
	 * Create the frame.
	 */
	public ReciboView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 381, 464);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 365, 384);
		contentPane.add(panel);
		jLabel2 = new javax.swing.JLabel();
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2.setBounds(0, 37, 368, 14);
		jLabel3 = new javax.swing.JLabel();
		jLabel3.setBounds(0, 63, 368, 14);
		jLabel9 = new javax.swing.JLabel();
		jLabel9.setLocation(0, 170);
		jLabel9.setSize(368, 14);
		panel.setLayout(null);
		jLabel1 = new JLabel();
		jLabel1.setFont(new java.awt.Font("Monospaced", 1, 11)); // NOI18N
		jLabel1.setText("Power GYM");
		panel.add(jLabel1);
		
		jLabel2.setFont(new java.awt.Font("Monospaced", 1, 11)); // NOI18N
		jLabel2.setText("Nit: 10270746-1");
		panel.add(jLabel2);

		jLabel3.setFont(new java.awt.Font("Monospaced", 1, 11)); // NOI18N
		jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel3.setText("Calle 51 No. 51 - 52 ");
		panel.add(jLabel3);
		jLabel9.setText("--------------------------------------------------------------------------------------------");
		panel.add(jLabel9);

		JLabel lblPowergym = new JLabel();
		lblPowergym.setHorizontalAlignment(SwingConstants.CENTER);
		lblPowergym.setText("PowerGym");
		lblPowergym.setFont(new Font("Monospaced", Font.BOLD, 11));
		lblPowergym.setBounds(0, 11, 368, 14);
		panel.add(lblPowergym);

		JLabel lblReciboDePago = new JLabel();
		lblReciboDePago.setText("Recibo de Pago No.");
		lblReciboDePago.setHorizontalAlignment(SwingConstants.CENTER);
		lblReciboDePago.setFont(new Font("Monospaced", Font.BOLD, 11));
		lblReciboDePago.setBounds(0, 88, 368, 14);
		panel.add(lblReciboDePago);

		JLabel lblFecha = new JLabel();
		lblFecha.setText("Fecha:");
		lblFecha.setHorizontalAlignment(SwingConstants.LEFT);
		lblFecha.setFont(new Font("Monospaced", Font.BOLD, 11));
		lblFecha.setBounds(10, 113, 66, 14);
		panel.add(lblFecha);

		JLabel lblCliente = new JLabel();
		lblCliente.setText("Cliente:");
		lblCliente.setHorizontalAlignment(SwingConstants.LEFT);
		lblCliente.setFont(new Font("Monospaced", Font.BOLD, 11));
		lblCliente.setBounds(10, 132, 66, 14);
		panel.add(lblCliente);

		JLabel lblOperador = new JLabel();
		lblOperador.setText("Operador:");
		lblOperador.setHorizontalAlignment(SwingConstants.LEFT);
		lblOperador.setFont(new Font("Monospaced", Font.BOLD, 11));
		lblOperador.setBounds(10, 150, 66, 14);
		panel.add(lblOperador);

		textPaneDescripcion = new JTextPane();
		textPaneDescripcion.setFont(new Font("Monospaced", Font.BOLD, 11));
		textPaneDescripcion.setBackground(Color.WHITE);
		textPaneDescripcion.setBounds(0, 186, 368, 49);
		panel.add(textPaneDescripcion);

		JLabel label = new JLabel();
		label.setText("--------------------------------------------------------------------------------------------");
		label.setBounds(0, 232, 368, 14);
		panel.add(label);

		JLabel lblNewLabel = new JLabel("Paga $");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 11));
		lblNewLabel.setBounds(101, 253, 162, 14);
		panel.add(lblNewLabel);

		JLabel lblUsadoDeSaldo = new JLabel("Usado de saldo a favor $");
		lblUsadoDeSaldo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsadoDeSaldo.setBounds(66, 278, 197, 14);
		lblUsadoDeSaldo.setFont(new Font("Monospaced", Font.BOLD, 11));
		panel.add(lblUsadoDeSaldo);

		JLabel lblDebe = new JLabel("Debe $");
		lblDebe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDebe.setBounds(101, 303, 162, 14);
		lblDebe.setFont(new Font("Monospaced", Font.BOLD, 11));
		panel.add(lblDebe);

		JLabel lblNewLabel_1 = new JLabel("Saldo a Favor $");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(101, 328, 162, 14);
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 11));
		panel.add(lblNewLabel_1);

		JLabel lblnoSeHacen = new JLabel();
		lblnoSeHacen.setText("***NO SE HACEN DEVOLUCIONES DE DINERO***");
		lblnoSeHacen.setHorizontalAlignment(SwingConstants.CENTER);
		lblnoSeHacen.setFont(new Font("Monospaced", Font.BOLD, 11));
		lblnoSeHacen.setBounds(0, 353, 368, 14);
		panel.add(lblnoSeHacen);

		btnImprimir = new JButton("Imprimir");
		btnImprimir.setFont(new Font("Monospaced", Font.BOLD, 11));
		btnImprimir.setBounds(250, 391, 105, 23);
		contentPane.add(btnImprimir);

		textFieldPaga = new JTextField();
		textFieldPaga.setFont(new Font("Monospaced", Font.BOLD, 11));
		textFieldPaga.setBounds(273, 250, 82, 20);
		panel.add(textFieldPaga);
		textFieldPaga.setColumns(10);

		textFieldUsadoSaldoFavor = new JTextField();
		textFieldUsadoSaldoFavor.setFont(new Font("Monospaced", Font.BOLD, 11));
		textFieldUsadoSaldoFavor.setColumns(10);
		textFieldUsadoSaldoFavor.setBounds(273, 275, 82, 20);
		panel.add(textFieldUsadoSaldoFavor);

		textFieldDebe = new JTextField();
		textFieldDebe.setFont(new Font("Monospaced", Font.BOLD, 11));
		textFieldDebe.setColumns(10);
		textFieldDebe.setBounds(273, 300, 82, 20);
		panel.add(textFieldDebe);

		textFieldSaldoFavor = new JTextField();
		textFieldSaldoFavor.setFont(new Font("Monospaced", Font.BOLD, 11));
		textFieldSaldoFavor.setColumns(10);
		textFieldSaldoFavor.setBounds(273, 325, 82, 20);
		panel.add(textFieldSaldoFavor);

		labelFecha = new JLabel("");
		labelFecha.setFont(new Font("Monospaced", Font.BOLD, 11));
		labelFecha.setBounds(86, 113, 269, 14);
		panel.add(labelFecha);

		labelCliente = new JLabel("");
		labelCliente.setFont(new Font("Monospaced", Font.BOLD, 11));
		labelCliente.setBounds(86, 132, 269, 14);
		panel.add(labelCliente);

		labelOperador = new JLabel("");
		labelOperador.setFont(new Font("Monospaced", Font.BOLD, 11));
		labelOperador.setBounds(86, 150, 269, 14);
		panel.add(labelOperador);

		labelNumero = new JLabel("");
		labelNumero.setBounds(248, 88, 46, 14);
		panel.add(labelNumero);

	}

	public JLabel getLabelOperador() {
		return labelOperador;
	}

	public JLabel getLabelFecha() {
		return labelFecha;
	}

	public JLabel getLabelCliente() {
		return labelCliente;
	}

	public JTextField getTextFieldPaga() {
		return textFieldPaga;
	}

	public JTextField getTextFieldSaldoFavor() {
		return textFieldSaldoFavor;
	}

	public JTextField getTextFieldUsadoSaldoFavor() {
		return textFieldUsadoSaldoFavor;
	}

	public JTextField getTextFieldDebe() {
		return textFieldDebe;
	}

	
	public JButton getBtnImprimir() {
		return btnImprimir;
	}

	public JTextPane getTextPaneDescripcion() {
		return textPaneDescripcion;
	}

	public JLabel getLabelNumero() {
		return labelNumero;
	}

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		if (pageIndex > 0)
			return NO_SUCH_PAGE;
		Graphics2D g2d = (Graphics2D) graphics;
		// Punto donde empezará a imprimir dentro la pagina (100, 50)
		g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
		g2d.scale(0.5, 0.5); // Reducción de la impresión al 50%
		panel.printAll(graphics);
		return PAGE_EXISTS;
	}
}

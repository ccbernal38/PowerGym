package co.powergym.view.caja;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.powergym.utils.ButtonSecundario;
import co.powergym.utils.Constantes;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class CajaRegistroIngresoView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldValor;
	private JButton btnRegistrar;
	private JButton btnCancelar;
	private JTextArea textAreaConcepto;

	/**
	 * Create the frame.
	 */
	public CajaRegistroIngresoView() {
		setResizable(false);
		setTitle("Ingreso");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 431, 252);
		contentPane = new JPanel();
		contentPane.setBackground(Constantes.black());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 425, 56);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Registrar Ingreso");
		panel_1.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.BLACK);

		JLabel lblConcepto = new JLabel("Concepto:");
		lblConcepto.setBounds(10, 61, 96, 27);
		contentPane.add(lblConcepto);
		lblConcepto.setFont(new Font("Verdana", Font.BOLD, 14));
		lblConcepto.setForeground(Constantes.white());

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(10, 144, 96, 27);
		contentPane.add(lblValor);
		lblValor.setFont(new Font("Verdana", Font.BOLD, 14));
		lblValor.setForeground(Constantes.white());

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(136, 63, 279, 71);
		contentPane.add(scrollPane);

		textAreaConcepto = new JTextArea();
		scrollPane.setViewportView(textAreaConcepto);
		textAreaConcepto.setFont(new Font("Verdana", Font.PLAIN, 12));

		textFieldValor = new JTextField();
		textFieldValor.setBounds(136, 145, 279, 27);
		contentPane.add(textFieldValor);
		textFieldValor.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldValor.setColumns(10);

		btnRegistrar = new ButtonSecundario("Registrar");
		btnRegistrar.setBounds(227, 183, 89, 23);
		contentPane.add(btnRegistrar);

		btnCancelar = new ButtonSecundario("Cancelar");
		btnCancelar.setBounds(326, 183, 89, 23);
		contentPane.add(btnCancelar);
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JTextArea getTextAreaConcepto() {
		return textAreaConcepto;
	}

	public JTextField getTextFieldValor() {
		return textFieldValor;
	}
}

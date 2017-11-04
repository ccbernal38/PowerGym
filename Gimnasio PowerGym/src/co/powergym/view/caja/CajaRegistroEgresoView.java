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

public class CajaRegistroEgresoView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldValor;
	private JButton btnCancelar;
	private JTextArea textAreaConcepto;
	private JButton btnRegistrar;

	/**
	 * Create the frame.
	 */
	public CajaRegistroEgresoView() {
		setResizable(false);
		setTitle("Egreso");
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
		
		JLabel lblNewLabel = new JLabel("Registrar Egreso");
		lblNewLabel.setBackground(Color.BLACK);
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
		
		textFieldValor = new JTextField();
		textFieldValor.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldValor.setBounds(136, 145, 279, 27);
		contentPane.add(textFieldValor);
		textFieldValor.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(136, 63, 279, 71);
		contentPane.add(scrollPane);
		
		textAreaConcepto = new JTextArea();
		textAreaConcepto.setFont(new Font("Verdana", Font.PLAIN, 12));
		scrollPane.setViewportView(textAreaConcepto);
		
		btnRegistrar = new ButtonSecundario("Registrar");
		btnRegistrar.setBounds(227, 183, 89, 23);
		contentPane.add(btnRegistrar);
		
		btnCancelar = new ButtonSecundario("Cancelar");
		btnCancelar.setBounds(326, 183, 89, 23);
		contentPane.add(btnCancelar);
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
	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}
}

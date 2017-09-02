package co.powergym.view.caja;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
		setTitle("Egreso");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 375, 254);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(42, 45, 52));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Registrar Egreso");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(42, 45, 52));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblConcepto = new JLabel("Concepto:");
		lblConcepto.setFont(new Font("Verdana", Font.BOLD, 11));
		lblConcepto.setForeground(Color.WHITE);
		lblConcepto.setBounds(10, 31, 96, 14);
		panel.add(lblConcepto);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Verdana", Font.BOLD, 11));
		lblValor.setForeground(Color.WHITE);
		lblValor.setBounds(10, 115, 96, 14);
		panel.add(lblValor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(116, 31, 186, 71);
		panel.add(scrollPane);
		
		textAreaConcepto = new JTextArea();
		scrollPane.setViewportView(textAreaConcepto);
		
		textFieldValor = new JTextField();
		textFieldValor.setBounds(116, 113, 186, 20);
		panel.add(textFieldValor);
		textFieldValor.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(175, 144, 89, 23);
		panel.add(btnRegistrar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(76, 144, 89, 23);
		panel.add(btnCancelar);
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

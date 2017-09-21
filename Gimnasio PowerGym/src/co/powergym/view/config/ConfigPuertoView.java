package co.powergym.view.config;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ConfigPuertoView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPuerto;
	private JButton btnCambiar;
	private JButton btnCancelar;

	/**
	 * Create the frame.
	 */
	public ConfigPuertoView() {
		setTitle("Puerto de comunicaci\u00F3n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 182);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Puerto de comunicaci\u00F3n de torniquete");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblPuerto = new JLabel("Puerto:");
		lblPuerto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPuerto.setBounds(106, 58, 60, 14);
		contentPane.add(lblPuerto);
		
		textFieldPuerto = new JTextField();
		textFieldPuerto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldPuerto.setBounds(177, 55, 148, 20);
		contentPane.add(textFieldPuerto);
		textFieldPuerto.setColumns(10);
		
		btnCambiar = new JButton("Cambiar");
		btnCambiar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCambiar.setBounds(129, 99, 89, 23);
		contentPane.add(btnCambiar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(228, 99, 89, 23);
		contentPane.add(btnCancelar);
	}
	public JTextField getTextFieldPuerto() {
		return textFieldPuerto;
	}
	public JButton getBtnCambiar() {
		return btnCambiar;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}

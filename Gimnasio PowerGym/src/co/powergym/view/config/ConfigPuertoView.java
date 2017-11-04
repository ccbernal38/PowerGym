package co.powergym.view.config;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.powergym.utils.ButtonSecundario;
import co.powergym.utils.Constantes;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class ConfigPuertoView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPuerto;
	private JButton btnCambiar;
	private JButton btnCancelar;
	private JPanel panel;

	/**
	 * Create the frame.
	 */
	public ConfigPuertoView() {
		setResizable(false);
		setTitle("Puerto de comunicaci\u00F3n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 434, 182);
		contentPane = new JPanel();
		contentPane.setBackground(Constantes.black());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPuerto = new JLabel("Puerto:");
		lblPuerto.setForeground(Constantes.white());
		lblPuerto.setFont(new Font("Verdana", Font.BOLD, 14));
		lblPuerto.setBounds(10, 71, 60, 14);
		contentPane.add(lblPuerto);

		textFieldPuerto = new JTextField();
		textFieldPuerto.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldPuerto.setBounds(80, 66, 337, 27);
		contentPane.add(textFieldPuerto);
		textFieldPuerto.setColumns(10);

		btnCambiar = new ButtonSecundario("Cambiar");
		btnCambiar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCambiar.setBounds(222, 109, 89, 23);
		contentPane.add(btnCambiar);

		btnCancelar = new ButtonSecundario("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(329, 109, 89, 23);
		contentPane.add(btnCancelar);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 428, 56);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Puerto de comunicaci\u00F3n de torniquete");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
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

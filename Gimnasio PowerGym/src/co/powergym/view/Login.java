package co.powergym.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JPasswordField passwordField;
	private JButton btnIniciar;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 69, 438, 231);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario: ");
		lblNombreDeUsuario.setBounds(56, 48, 122, 14);
		panel.add(lblNombreDeUsuario);
		
		JLabel lblNewLabel = new JLabel("Contrase\u00F1a:");
		lblNewLabel.setBounds(56, 73, 122, 14);
		panel.add(lblNewLabel);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(188, 45, 198, 20);
		panel.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(188, 70, 198, 20);
		panel.add(passwordField);
		
		btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds(297, 111, 89, 23);
		panel.add(btnIniciar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(440, 320, 89, 23);
		contentPane.add(btnSalir);
	}
	public JTextField getTextFieldUsername() {
		return textFieldUsername;
	}
	public JPasswordField getPasswordField() {
		return passwordField;
	}
	public JButton getBtnIniciar() {
		return btnIniciar;
	}
	public JButton getBtnSalir() {
		return btnSalir;
	}
}

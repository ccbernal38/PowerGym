package co.powergym.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdesktop.xswingx.PromptSupport;

import javafx.scene.web.PromptData;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JButton btnIniciar;
	private JButton btnSalir;
	private JPanel panel_2;
	private JTextField textFieldUsername;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblNewLabel;

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
		setTitle("PowerGym");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(new Color(42, 45, 52));

		lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(167, 11, 150, 130);
		lblNewLabel.setIcon(new ImageIcon(((new ImageIcon("image/avatar_boy.png")).getImage()).getScaledInstance(
				lblNewLabel.getHeight(), lblNewLabel.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));		
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 149, 438, 208);
		panel.setBackground(new Color(0, 0, 0, 0));
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_1.setBounds(58, 22, 319, 50);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(0, 0, 50, 50);
		
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		label = new JLabel("");
		label.setBounds(12, 12, 26, 26);
		label.setIcon(new ImageIcon(((new ImageIcon("image/user.png")).getImage()).getScaledInstance(
				label.getHeight(), label.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		panel_2.add(label);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBorder(new EmptyBorder(0, 0, 0, 0));
		textFieldUsername.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldUsername.setBounds(60, 11, 249, 28);textFieldUsername.setText("ccbernal38");
		PromptSupport.setPrompt("Nombre de usuario", textFieldUsername);
		PromptSupport.setForeground(Color.LIGHT_GRAY, textFieldUsername);
		PromptSupport.setFontStyle(Font.PLAIN, textFieldUsername);
		textFieldUsername.transferFocus();;
		panel_1.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_3.setBounds(58, 83, 319, 50);
		panel.add(panel_3);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(0, 0, 50, 50);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		label_1 = new JLabel("");
		label_1.setBounds(12, 12, 26, 26);
		label_1.setIcon(new ImageIcon(((new ImageIcon("image/password.png")).getImage()).getScaledInstance(
				label_1.getHeight(), label_1.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));		
		panel_4.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new EmptyBorder(0, 0, 0, 0));
		passwordField.setFont(new Font("Verdana", Font.PLAIN, 12));
		passwordField.setBounds(60, 11, 249, 28);
		passwordField.setText("123456");
		panel_3.add(passwordField);
		PromptSupport.setPrompt("Contraseña", passwordField);
		PromptSupport.setForeground(Color.LIGHT_GRAY, passwordField);
		PromptSupport.setFontStyle(Font.PLAIN, passwordField);
		btnSalir = new JButton("Salir");
		btnSalir.setBorder(new LineBorder(Color.LIGHT_GRAY, 3, true));
		btnSalir.setBackground(Color.GRAY);
		btnSalir.setFont(new Font("Verdana", Font.BOLD, 14));
		btnSalir.setBounds(321, 399, 139, 51);
		contentPane.add(btnSalir);
		
		btnIniciar = new JButton("Iniciar");
		btnIniciar.setFont(new Font("Verdana", Font.BOLD, 14));
		btnIniciar.setBackground(Color.ORANGE);
		btnIniciar.setBorder(new LineBorder(new Color(255, 255, 153), 3, true));
		btnIniciar.setBounds(58, 144, 319, 51);
		btnIniciar.setFocusable(true);
		btnIniciar.requestDefaultFocus();
		btnIniciar.setRequestFocusEnabled(true);
		btnIniciar.setFocusPainted(false);
		panel.add(btnIniciar);
		this.addWindowListener(new WindowAdapter() {
		    public void windowGainedFocus(WindowEvent e) {
		        btnIniciar.requestFocusInWindow();
		        btnIniciar.requestFocus();
		    }
		});
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

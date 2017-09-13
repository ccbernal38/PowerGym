package co.powergym.view.usuario.administrador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class UsuarioCambiarContraseniaView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JTextField textFieldPassword;
	private JTextField textFieldPassworNew;
	private JTextField textFieldPasswordNewRepeat;
	private JButton btnCancelar;
	private JButton btnCambiar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsuarioCambiarContraseniaView frame = new UsuarioCambiarContraseniaView();
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
	public UsuarioCambiarContraseniaView() {
		setTitle("Cambiar contrase\u00F1a");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 376, 256);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(42, 45, 52));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblCambiarContrasea = new JLabel("CAMBIAR CONTRASE\u00D1A");
		lblCambiarContrasea.setForeground(Color.WHITE);
		lblCambiarContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblCambiarContrasea.setFont(new Font("Verdana", Font.BOLD, 18));
		contentPane.add(lblCambiarContrasea, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0, 0));
		contentPane.add(panel, BorderLayout.CENTER);

		panel.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Verdana", Font.BOLD, 11));
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBounds(10, 22, 200, 14);
		panel.add(lblUsuario);

		JLabel lblContraseaActual = new JLabel("Contrase\u00F1a actual:");
		lblContraseaActual.setFont(new Font("Verdana", Font.BOLD, 11));
		lblContraseaActual.setForeground(Color.WHITE);
		lblContraseaActual.setBounds(10, 47, 200, 14);
		panel.add(lblContraseaActual);

		JLabel lblContraseaNueva = new JLabel("Contrase\u00F1a nueva:");
		lblContraseaNueva.setFont(new Font("Verdana", Font.BOLD, 11));
		lblContraseaNueva.setForeground(Color.WHITE);
		lblContraseaNueva.setBounds(10, 72, 200, 14);
		panel.add(lblContraseaNueva);

		JLabel lblRepitaLaContraseanueva = new JLabel("Repita la contrase\u00F1a nueva:");
		lblRepitaLaContraseanueva.setFont(new Font("Verdana", Font.BOLD, 11));
		lblRepitaLaContraseanueva.setForeground(Color.WHITE);
		lblRepitaLaContraseanueva.setBounds(10, 97, 200, 14);
		panel.add(lblRepitaLaContraseanueva);

		textFieldUsuario = new JTextField();
		textFieldUsuario.setFont(new Font("Verdana", Font.BOLD, 11));
		textFieldUsuario.setBounds(196, 20, 144, 20);
		panel.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);

		textFieldPassword = new JTextField();
		textFieldPassword.setFont(new Font("Verdana", Font.BOLD, 11));
		textFieldPassword.setBounds(196, 45, 144, 20);
		panel.add(textFieldPassword);
		textFieldPassword.setColumns(10);

		textFieldPassworNew = new JTextField();
		textFieldPassworNew.setFont(new Font("Verdana", Font.BOLD, 11));
		textFieldPassworNew.setBounds(196, 70, 144, 20);
		panel.add(textFieldPassworNew);
		textFieldPassworNew.setColumns(10);

		textFieldPasswordNewRepeat = new JTextField();
		textFieldPasswordNewRepeat.setFont(new Font("Verdana", Font.BOLD, 11));
		textFieldPasswordNewRepeat.setBounds(196, 95, 144, 20);
		panel.add(textFieldPasswordNewRepeat);
		textFieldPasswordNewRepeat.setColumns(10);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(72, 138, 89, 23);
		panel.add(btnCancelar);

		btnCambiar = new JButton("Cambiar");
		btnCambiar.setBounds(185, 138, 89, 23);
		panel.add(btnCambiar);
	}
	public JTextField getTextFieldPasswordNewRepeat() {
		return textFieldPasswordNewRepeat;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	public JTextField getTextFieldPassworNew() {
		return textFieldPassworNew;
	}
	public JButton getBtnCambiar() {
		return btnCambiar;
	}
	public JTextField getTextFieldPassword() {
		return textFieldPassword;
	}
	public JTextField getTextFieldUsuario() {
		return textFieldUsuario;
	}
}

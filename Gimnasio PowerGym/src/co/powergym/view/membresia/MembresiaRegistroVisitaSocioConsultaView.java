package co.powergym.view.membresia;

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
import javax.swing.JButton;

public class MembresiaRegistroVisitaSocioConsultaView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSocio;
	private JTextField textFieldNombres;
	private JTextField textFieldApellidos;
	private JTextField textFieldValor;
	private JButton btnCancelar;
	private JButton btnRegistrar;

	/**
	 * Create the frame.
	 */
	public MembresiaRegistroVisitaSocioConsultaView() {
		setTitle("Registrar visita");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 535, 232);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(42, 45, 52));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0, 0));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JLabel lblSocio = new JLabel("Socio:");
		lblSocio.setForeground(Color.WHITE);
		lblSocio.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblSocio.setBounds(10, 30, 93, 14);
		panel_1.add(lblSocio);

		textFieldSocio = new JTextField();
		textFieldSocio.setEditable(false);
		textFieldSocio.setEnabled(false);
		textFieldSocio.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldSocio.setBounds(113, 28, 135, 20);
		panel_1.add(textFieldSocio);
		textFieldSocio.setColumns(10);

		JLabel lblNombre = new JLabel("Nombres:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Verdana", Font.BOLD, 11));
		lblNombre.setBounds(10, 62, 93, 14);
		panel_1.add(lblNombre);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Verdana", Font.BOLD, 11));
		lblApellidos.setBounds(258, 62, 93, 14);
		panel_1.add(lblApellidos);

		textFieldNombres = new JTextField();
		textFieldNombres.setEnabled(false);
		textFieldNombres.setEditable(false);
		textFieldNombres.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldNombres.setColumns(10);
		textFieldNombres.setBounds(113, 59, 135, 20);
		panel_1.add(textFieldNombres);

		textFieldApellidos = new JTextField();
		textFieldApellidos.setEnabled(false);
		textFieldApellidos.setEditable(false);
		textFieldApellidos.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldApellidos.setColumns(10);
		textFieldApellidos.setBounds(361, 59, 135, 20);
		panel_1.add(textFieldApellidos);

		textFieldValor = new JTextField();
		textFieldValor.setBounds(113, 90, 135, 20);
		panel_1.add(textFieldValor);
		textFieldValor.setColumns(10);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setForeground(Color.WHITE);
		lblValor.setFont(new Font("Verdana", Font.BOLD, 11));
		lblValor.setBounds(10, 92, 93, 14);
		panel_1.add(lblValor);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(258, 121, 89, 23);
		panel_1.add(btnRegistrar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(159, 121, 89, 23);
		panel_1.add(btnCancelar);

		JLabel lblNewLabel = new JLabel("Registrar Visita");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
	}

	public JTextField getTextFieldApellidos() {
		return textFieldApellidos;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JTextField getTextFieldSocio() {
		return textFieldSocio;
	}

	public JTextField getTextFieldNombres() {
		return textFieldNombres;
	}

	public JTextField getTextFieldValor() {
		return textFieldValor;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

}

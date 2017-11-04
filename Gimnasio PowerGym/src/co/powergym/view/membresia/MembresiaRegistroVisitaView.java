package co.powergym.view.membresia;

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
import javax.swing.JButton;

public class MembresiaRegistroVisitaView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSocio;
	private JTextField textFieldNombres;
	private JTextField textFieldApellidos;
	private JTextField textFieldValor;
	private JButton btnCancelar;
	private JButton btnRegistrar;
	private JButton btnBuscar;

	/**
	 * Create the frame.
	 */
	public MembresiaRegistroVisitaView() {
		setTitle("Registrar visita");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 535, 240);
		contentPane = new JPanel();
		contentPane.setBackground(Constantes.black());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSocio = new JLabel("Socio:");
		lblSocio.setBounds(10, 70, 93, 14);
		contentPane.add(lblSocio);
		lblSocio.setForeground(Color.WHITE);
		lblSocio.setFont(new Font("Verdana", Font.BOLD, 12));

		textFieldSocio = new JTextField();
		textFieldSocio.setBounds(113, 68, 135, 20);
		contentPane.add(textFieldSocio);
		textFieldSocio.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldSocio.setColumns(10);

		btnBuscar = new ButtonSecundario("Buscar");
		btnBuscar.setBounds(258, 67, 89, 23);
		contentPane.add(btnBuscar);

		JLabel lblNombre = new JLabel("Nombres:");
		lblNombre.setBounds(10, 102, 93, 14);
		contentPane.add(lblNombre);
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Verdana", Font.BOLD, 12));

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(258, 102, 93, 14);
		contentPane.add(lblApellidos);
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Verdana", Font.BOLD, 12));

		textFieldNombres = new JTextField();
		textFieldNombres.setBounds(113, 99, 135, 20);
		contentPane.add(textFieldNombres);
		textFieldNombres.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldNombres.setColumns(10);

		textFieldApellidos = new JTextField();
		textFieldApellidos.setBounds(361, 99, 135, 20);
		contentPane.add(textFieldApellidos);
		textFieldApellidos.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldApellidos.setColumns(10);

		textFieldValor = new JTextField();
		textFieldValor.setBounds(113, 130, 135, 20);
		contentPane.add(textFieldValor);
		textFieldValor.setColumns(10);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(10, 132, 93, 14);
		contentPane.add(lblValor);
		lblValor.setForeground(Color.WHITE);
		lblValor.setFont(new Font("Verdana", Font.BOLD, 12));

		btnRegistrar = new ButtonSecundario("Registrar");
		btnRegistrar.setBounds(321, 161, 89, 23);
		contentPane.add(btnRegistrar);

		btnCancelar = new ButtonSecundario("Cancelar");
		btnCancelar.setBounds(420, 161, 89, 23);
		contentPane.add(btnCancelar);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 519, 56);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Registrar Visita");
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
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

	public JButton getBtnBuscar() {
		return btnBuscar;
	}
}

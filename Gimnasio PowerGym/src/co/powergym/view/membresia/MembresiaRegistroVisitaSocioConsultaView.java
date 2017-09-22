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
	private JLabel textFieldSocio;
	private JLabel textFieldNombres;
	private JLabel textFieldApellidos;
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
		contentPane.setBackground(new Color(127, 190, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0, 0));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JLabel lblSocio = new JLabel("Socio:");
		lblSocio.setForeground(new Color(74, 74, 72));;
		lblSocio.setFont(new Font("Verdana", Font.BOLD, 12));
		lblSocio.setBounds(10, 30, 93, 14);
		panel_1.add(lblSocio);

		textFieldSocio = new JLabel();
		textFieldSocio.setForeground(new Color(74, 74, 72));
		textFieldSocio.setFont(new Font("Verdana", Font.BOLD, 12));
		textFieldSocio.setBounds(113, 28, 135, 20);
		panel_1.add(textFieldSocio);

		JLabel lblNombre = new JLabel("Nombres:");
		lblNombre.setForeground(new Color(74, 74, 72));;
		lblNombre.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNombre.setBounds(10, 62, 93, 14);
		panel_1.add(lblNombre);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setForeground(new Color(74, 74, 72));;
		lblApellidos.setFont(new Font("Verdana", Font.BOLD, 12));
		lblApellidos.setBounds(258, 62, 93, 14);
		panel_1.add(lblApellidos);

		textFieldNombres = new JLabel();
		textFieldNombres.setForeground(new Color(74, 74, 72));
		textFieldNombres.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldNombres.setBounds(113, 59, 135, 20);
		panel_1.add(textFieldNombres);

		textFieldApellidos = new JLabel();
		textFieldApellidos.setForeground(new Color(74, 74, 72));
		textFieldApellidos.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldApellidos.setBounds(390, 59, 135, 20);
		panel_1.add(textFieldApellidos);

		textFieldValor = new JTextField();
		textFieldValor.setBounds(113, 90, 135, 20);
		panel_1.add(textFieldValor);
		textFieldValor.setColumns(10);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setForeground(new Color(74, 74, 72));;
		lblValor.setFont(new Font("Verdana", Font.BOLD, 12));
		lblValor.setBounds(10, 92, 93, 14);
		panel_1.add(lblValor);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(Color.LIGHT_GRAY);
		btnRegistrar.setBounds(258, 121, 89, 23);
		panel_1.add(btnRegistrar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.LIGHT_GRAY);
		btnCancelar.setBounds(159, 121, 89, 23);
		panel_1.add(btnCancelar);

		JLabel lblNewLabel = new JLabel("Registrar Visita");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(74, 74, 72));;
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
	}

	public JLabel getTextFieldApellidos() {
		return textFieldApellidos;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JLabel getTextFieldSocio() {
		return textFieldSocio;
	}

	public JLabel getTextFieldNombres() {
		return textFieldNombres;
	}

	public JTextField getTextFieldValor() {
		return textFieldValor;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

}

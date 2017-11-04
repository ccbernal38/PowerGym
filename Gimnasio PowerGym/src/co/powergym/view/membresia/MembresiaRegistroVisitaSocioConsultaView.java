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

public class MembresiaRegistroVisitaSocioConsultaView extends JFrame {

	private JPanel contentPane;
	private JLabel textFieldSocio;
	private JLabel textFieldNombres;
	private JLabel textFieldApellidos;
	private JTextField textFieldValor;
	private JButton btnCancelar;
	private JButton btnRegistrar;
	private JPanel panel;

	/**
	 * Create the frame.
	 */
	public MembresiaRegistroVisitaSocioConsultaView() {
		setResizable(false);
		setTitle("Registrar visita");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 535, 309);
		contentPane = new JPanel();
		contentPane.setBackground(Constantes.black());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 84, 509, 181);
		panel_1.setBackground(new Color(0, 0, 0, 0));
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblSocio = new JLabel("Socio:");
		lblSocio.setForeground(Color.WHITE);;
		lblSocio.setFont(new Font("Verdana", Font.BOLD, 12));
		lblSocio.setBounds(10, 30, 93, 14);
		panel_1.add(lblSocio);

		textFieldSocio = new JLabel();
		textFieldSocio.setBackground(Color.WHITE);
		textFieldSocio.setForeground(Color.WHITE);
		textFieldSocio.setFont(new Font("Verdana", Font.BOLD, 12));
		textFieldSocio.setBounds(113, 28, 135, 20);
		panel_1.add(textFieldSocio);

		JLabel lblNombre = new JLabel("Nombres:");
		lblNombre.setForeground(Color.WHITE);;
		lblNombre.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNombre.setBounds(10, 62, 93, 14);
		panel_1.add(lblNombre);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setForeground(Color.WHITE);;
		lblApellidos.setFont(new Font("Verdana", Font.BOLD, 12));
		lblApellidos.setBounds(258, 62, 93, 14);
		panel_1.add(lblApellidos);

		textFieldNombres = new JLabel();
		textFieldNombres.setBackground(Color.WHITE);
		textFieldNombres.setForeground(Color.WHITE);
		textFieldNombres.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldNombres.setBounds(113, 59, 135, 20);
		panel_1.add(textFieldNombres);

		textFieldApellidos = new JLabel();
		textFieldApellidos.setBackground(Color.WHITE);
		textFieldApellidos.setForeground(Color.WHITE);
		textFieldApellidos.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldApellidos.setBounds(390, 59, 135, 20);
		panel_1.add(textFieldApellidos);

		textFieldValor = new JTextField();
		textFieldValor.setBounds(113, 90, 135, 20);
		panel_1.add(textFieldValor);
		textFieldValor.setColumns(10);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setForeground(Color.WHITE);;
		lblValor.setFont(new Font("Verdana", Font.BOLD, 12));
		lblValor.setBounds(10, 92, 93, 14);
		panel_1.add(lblValor);

		btnRegistrar = new ButtonSecundario("Registrar");
		btnRegistrar.setBackground(Color.LIGHT_GRAY);
		btnRegistrar.setBounds(291, 136, 89, 23);
		panel_1.add(btnRegistrar);

		btnCancelar = new ButtonSecundario("Cancelar");
		btnCancelar.setBackground(Color.LIGHT_GRAY);
		btnCancelar.setBounds(390, 136, 89, 23);
		panel_1.add(btnCancelar);;
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 529, 56);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
				
						JLabel lblNewLabel = new JLabel("Registrar Visita");
						lblNewLabel.setBackground(Color.WHITE);
						panel.add(lblNewLabel, BorderLayout.CENTER);
						lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
						lblNewLabel.setForeground(Color.BLACK);
						lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
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

package co.powergym.view.caja;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.LineBorder;
import javax.swing.text.NumberFormatter;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

import co.powergym.utils.ButtonPrincipal;
import co.powergym.utils.ButtonSecundario;
import co.powergym.utils.Constantes;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.BorderLayout;

public class CajaAperturaView extends JFrame {

	private JPanel contentPane;
	private JLabel lblResponsable;
	private JButton btnNewButton;
	private JLabel formattedTextField;
	private JLabel dateChooser;

	/**
	 * Create the frame.
	 */
	public CajaAperturaView() {
		setResizable(false);
		setBackground(Color.DARK_GRAY);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 473, 265);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Constantes.black());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Calendar calendar = Calendar.getInstance();

		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
		format.setMaximumFractionDigits(0);

		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setMinimum(0.0);
		formatter.setMaximum(10000000.0);
		formatter.setAllowsInvalid(true);
		formatter.setOverwriteMode(true);

		JPanel panel_1 = new JPanel();

		panel_1.setBounds(0, 0, 469, 56);
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JLabel lblCaja = new JLabel("Apertura de Caja");
		panel_1.add(lblCaja);

		lblCaja.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaja.setForeground(Color.BLACK);
		lblCaja.setFont(new Font("Verdana", Font.BOLD, 18));

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(5, 72, 454, 109);
		contentPane.add(panel_3);
		panel_3.setBackground(new Color(0, 0, 0, 0));
		panel_3.setBorder(null);
		panel_3.setLayout(null);

		lblResponsable = new JLabel("Christian Camilo Bernal Rojas");
		lblResponsable.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblResponsable.setVerticalAlignment(SwingConstants.TOP);
		lblResponsable.setForeground(Constantes.white());
		lblResponsable.setBounds(126, 11, 318, 16);
		panel_3.add(lblResponsable);

		JLabel lblRes = new JLabel("Responsable:");
		lblRes.setVerticalAlignment(SwingConstants.BOTTOM);
		lblRes.setFont(new Font("Verdana", Font.BOLD, 14));
		lblRes.setForeground(Constantes.white());
		lblRes.setBounds(10, 5, 209, 24);
		panel_3.add(lblRes);

		JLabel lblFechaYHora = new JLabel("Fecha y Hora de apertura:");
		lblFechaYHora.setBounds(10, 38, 219, 28);
		panel_3.add(lblFechaYHora);
		lblFechaYHora.setForeground(Constantes.white());
		lblFechaYHora.setFont(new Font("Verdana", Font.BOLD, 14));

		JLabel lblSaldoInicial = new JLabel("Saldo Inicial:");
		lblSaldoInicial.setBounds(10, 69, 219, 28);
		panel_3.add(lblSaldoInicial);
		lblSaldoInicial.setForeground(Constantes.white());
		lblSaldoInicial.setFont(new Font("Verdana", Font.BOLD, 14));

		dateChooser = new JLabel();
		dateChooser.setBounds(230, 38, 214, 28);
		panel_3.add(dateChooser);
		dateChooser.setForeground(Constantes.white());
		dateChooser.setHorizontalAlignment(SwingConstants.RIGHT);
		dateChooser.setFont(new Font("Verdana", Font.PLAIN, 14));
		dateChooser.setOpaque(false);
		dateChooser.setText(new SimpleDateFormat("dd/MM/yyyy hh:MM:ss a").format(calendar.getTime()));

		formattedTextField = new JLabel("New label");
		formattedTextField.setBounds(230, 69, 214, 28);
		panel_3.add(formattedTextField);
		formattedTextField.setForeground(Constantes.white());
		formattedTextField.setOpaque(false);
		formattedTextField.setText("$ 0");
		formattedTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		formattedTextField.setFont(new Font("Verdana", Font.PLAIN, 14));

		btnNewButton = new ButtonSecundario("Abrir Caja");
		btnNewButton.setBounds(369, 192, 90, 28);
		btnNewButton.setBackground(Color.WHITE);
		contentPane.add(btnNewButton);
		btnNewButton.setFocusable(false);

	}

	public JLabel getLblNombreResponsable() {
		return lblResponsable;
	}

	public JButton getBtnAbrir() {
		return btnNewButton;
	}

	public JLabel getSaldoInicio() {
		return formattedTextField;
	}

	public JLabel getFecha() {
		return dateChooser;
	}
}

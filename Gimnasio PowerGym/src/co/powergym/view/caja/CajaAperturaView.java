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
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class CajaAperturaView extends JFrame {

	private JPanel contentPane;
	private JLabel lblEstado;
	private JLabel lblResponsable;
	private JButton btnNewButton;
	private JLabel formattedTextField;
	private JLabel dateChooser;

	/**
	 * Create the frame.
	 */
	public CajaAperturaView() {
		setBackground(Color.DARK_GRAY);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 529, 246);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(218, 227, 229));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBackground(new Color(0,0,0,0));
		panel.setBounds(5, 63, 501, 138);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblFechaYHora = new JLabel("Fecha y Hora de apertura:");
		lblFechaYHora.setForeground(new Color(74, 74, 72));
		lblFechaYHora.setFont(new Font("Verdana", Font.BOLD, 14));
		lblFechaYHora.setBounds(10, 18, 219, 28);
		panel.add(lblFechaYHora);

		dateChooser = new JLabel();
		dateChooser.setForeground(new Color(74, 74, 72));
		dateChooser.setHorizontalAlignment(SwingConstants.RIGHT);
		dateChooser.setFont(new Font("Verdana", Font.PLAIN, 14));
		dateChooser.setOpaque(false);
		
		dateChooser.setBounds(241, 18, 214, 28);
		Calendar calendar = Calendar.getInstance();
		dateChooser.setText(new SimpleDateFormat("dd/MM/yyyy hh:MM:ss a").format(calendar.getTime()));
		panel.add(dateChooser);

		JLabel lblSaldoInicial = new JLabel("Saldo Inicial:");
		lblSaldoInicial.setForeground(new Color(74, 74, 72));
		lblSaldoInicial.setFont(new Font("Verdana", Font.BOLD, 14));
		lblSaldoInicial.setBounds(10, 57, 219, 28);
		panel.add(lblSaldoInicial);

		btnNewButton = new JButton("Abrir Caja");
		btnNewButton.setFocusable(false);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(401, 97, 90, 28);
		panel.add(btnNewButton);

		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
		format.setMaximumFractionDigits(0);

		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setMinimum(0.0);
		formatter.setMaximum(10000000.0);
		formatter.setAllowsInvalid(true);
		formatter.setOverwriteMode(true);

		formattedTextField = new JLabel("New label");
		formattedTextField.setForeground(new Color(74, 74, 72));
		formattedTextField.setOpaque(false);
		formattedTextField.setText("$ 0");
		formattedTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		formattedTextField.setFont(new Font("Verdana", Font.PLAIN, 14));
		formattedTextField.setBounds(241, 58, 214, 28);
		panel.add(formattedTextField);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBounds(5, 5, 501, 56);
		panel_1.setBackground(new Color(0f, 0f, 0f, 0f));
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 154, 53);
		panel_2.setBackground(new Color(0f, 0f, 0f, 0f));
		panel_2.setBorder(null);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		lblEstado = new JLabel("Cerrada");
		lblEstado.setBounds(63, 6, 85, 41);
		lblEstado.setHorizontalAlignment(SwingConstants.LEFT);
		lblEstado.setFont(new Font("Verdana", Font.BOLD, 18));
		lblEstado.setForeground(Color.RED);
		panel_2.add(lblEstado);

		JLabel lblCaja = new JLabel("Caja:");
		lblCaja.setBounds(6, 6, 62, 41);
		panel_2.add(lblCaja);
		lblCaja.setHorizontalAlignment(SwingConstants.LEFT);
		lblCaja.setForeground(new Color(74, 74, 72));
		lblCaja.setFont(new Font("Verdana", Font.BOLD, 18));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 0, 0));
		panel_3.setBorder(null);
		panel_3.setBounds(166, 0, 335, 53);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		lblResponsable = new JLabel("Christian Camilo Bernal Rojas");
		lblResponsable.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblResponsable.setVerticalAlignment(SwingConstants.TOP);
		lblResponsable.setForeground(new Color(74, 74, 72));
		lblResponsable.setBounds(6, 31, 209, 16);
		panel_3.add(lblResponsable);

		JLabel lblRes = new JLabel("Responsable:");
		lblRes.setVerticalAlignment(SwingConstants.BOTTOM);
		lblRes.setFont(new Font("Verdana", Font.BOLD, 12));
		lblRes.setForeground(new Color(74, 74, 72));
		lblRes.setBounds(6, 3, 209, 24);
		panel_3.add(lblRes);

	}

	public JLabel getLblEstado() {
		return lblEstado;
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

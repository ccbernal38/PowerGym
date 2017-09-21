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
	private JFormattedTextField formattedTextField;
	private JTextField dateChooser;

	/**
	 * Create the frame.
	 */
	public CajaAperturaView() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 529, 246);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(42, 45, 52));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBackground(new Color(87, 139, 181));
		panel.setBounds(5, 63, 501, 138);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblFechaYHora = new JLabel("Fecha y Hora de apertura:");
		lblFechaYHora.setForeground(Color.WHITE);
		lblFechaYHora.setFont(new Font("Dialog", Font.BOLD, 14));
		lblFechaYHora.setBounds(31, 18, 198, 28);
		panel.add(lblFechaYHora);

		dateChooser = new JTextField();
		dateChooser.setHorizontalAlignment(SwingConstants.RIGHT);
		dateChooser.setEditable(false);
		dateChooser.setFont(new Font("Verdana", Font.BOLD, 14));
		dateChooser.setOpaque(false);
		
		dateChooser.setBounds(241, 18, 214, 28);
		Calendar calendar = Calendar.getInstance();
		dateChooser.setText(new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));
		panel.add(dateChooser);

		JLabel lblSaldoInicial = new JLabel("Saldo Inicial:");
		lblSaldoInicial.setForeground(Color.WHITE);
		lblSaldoInicial.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSaldoInicial.setBounds(31, 57, 181, 28);
		panel.add(lblSaldoInicial);

		btnNewButton = new JButton("Abrir Caja");
		btnNewButton.setBounds(401, 97, 90, 28);
		panel.add(btnNewButton);

		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
		format.setMaximumFractionDigits(0);

		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setMinimum(0.0);
		formatter.setMaximum(10000000.0);
		formatter.setAllowsInvalid(true);
		formatter.setOverwriteMode(true);

		formattedTextField = new JFormattedTextField(formatter);
		formattedTextField.setEditable(false);
		formattedTextField.setOpaque(false);
		formattedTextField.setText("0");
		formattedTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		formattedTextField.setFont(new Font("Verdana", Font.BOLD, 14));
		formattedTextField.setBounds(241, 58, 214, 28);
		formattedTextField.setValue(0.0);
		panel.add(formattedTextField);

		JPanel panel_1 = new JPanel();
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
		lblEstado.setFont(new Font("Dialog", Font.BOLD, 18));
		lblEstado.setForeground(Color.RED);
		panel_2.add(lblEstado);

		JLabel lblCaja = new JLabel("Caja:");
		lblCaja.setBounds(6, 6, 45, 41);
		panel_2.add(lblCaja);
		lblCaja.setHorizontalAlignment(SwingConstants.LEFT);
		lblCaja.setForeground(Color.WHITE);
		lblCaja.setFont(new Font("Dialog", Font.BOLD, 18));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 0, 0));
		panel_3.setBorder(null);
		panel_3.setBounds(166, 0, 335, 53);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		lblResponsable = new JLabel("Christian Camilo Bernal Rojas");
		lblResponsable.setVerticalAlignment(SwingConstants.TOP);
		lblResponsable.setForeground(Color.WHITE);
		lblResponsable.setBounds(6, 31, 209, 16);
		panel_3.add(lblResponsable);

		JLabel lblRes = new JLabel("Responsable:");
		lblRes.setVerticalAlignment(SwingConstants.BOTTOM);
		lblRes.setFont(new Font("Dialog", Font.BOLD, 12));
		lblRes.setForeground(Color.WHITE);
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

	public JFormattedTextField getSaldoInicio() {
		return formattedTextField;
	}

	public JTextField getFecha() {
		return dateChooser;
	}
}

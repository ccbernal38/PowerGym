package co.powergym.view.caja;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.text.NumberFormat;
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

public class AperturaCaja extends JFrame {

	private JPanel contentPane;
	private JLabel lblEstado;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AperturaCaja frame = new AperturaCaja();
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
	public AperturaCaja() {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 296);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(27, 43, 56));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBackground(new Color(87, 139, 181));
		panel.setBounds(5, 63, 501, 186);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblFechaYHora = new JLabel("Fecha y Hora de apertura:");
		lblFechaYHora.setForeground(Color.WHITE);
		lblFechaYHora.setFont(new Font("Dialog", Font.BOLD, 14));
		lblFechaYHora.setBounds(31, 18, 198, 28);
		panel.add(lblFechaYHora);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("d/MM/yyyy HH:mm:ss a");
		dateChooser.setBounds(241, 18, 214, 28);
		panel.add(dateChooser);
		
		JLabel lblSaldoAnterior = new JLabel("Saldo Anterior:");
		lblSaldoAnterior.setForeground(Color.WHITE);
		lblSaldoAnterior.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSaldoAnterior.setBounds(31, 60, 181, 28);
		panel.add(lblSaldoAnterior);
		
		JLabel lblSaldoInicial = new JLabel("Saldo Inicial:");
		lblSaldoInicial.setForeground(Color.WHITE);
		lblSaldoInicial.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSaldoInicial.setBounds(31, 100, 181, 28);
		panel.add(lblSaldoInicial);
		
		JLabel lblNewLabel_1 = new JLabel("$0");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(241, 60, 214, 28);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Abrir Caja");
		btnNewButton.setBounds(405, 145, 90, 28);
		panel.add(btnNewButton);
		
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
		format.setMaximumFractionDigits(0);

		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setMinimum(0.0);
		formatter.setMaximum(10000000.0);
		formatter.setAllowsInvalid(true);
		formatter.setOverwriteMode(true);
		
		JFormattedTextField formattedTextField = new JFormattedTextField(formatter);
		formattedTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		formattedTextField.setFont(new Font("Dialog", Font.BOLD, 14));
		formattedTextField.setBounds(241, 101, 214, 28);
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
		
		lblNewLabel = new JLabel("Christian Camilo Bernal Rojas");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(6, 31, 209, 16);
		panel_3.add(lblNewLabel);
		
		JLabel lblResponsable = new JLabel("Responsable:");
		lblResponsable.setVerticalAlignment(SwingConstants.BOTTOM);
		lblResponsable.setFont(new Font("Dialog", Font.BOLD, 12));
		lblResponsable.setForeground(Color.WHITE);
		lblResponsable.setBounds(6, 3, 209, 24);
		panel_3.add(lblResponsable);

	}

	public JLabel getLblEstado() {
		return lblEstado;
	}
	public JLabel getLblNombreResponsable() {
		return lblNewLabel;
	}
}

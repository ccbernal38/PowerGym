package co.powergym.view.caja;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Toolkit;

public class CajaCierreView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEgresos;
	private JTextField textFieldVisitas;
	private JTextField textFieldVentasM;
	private JLabel labelResponsableApertura;
	private JLabel labelFechaApertura;
	private JLabel labelResponsableCierre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CajaCierreView frame = new CajaCierreView();
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
	public CajaCierreView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\PowerGym\\PowerGym\\Gimnasio PowerGym\\image\\icon.ico"));
		setTitle("Cierre de caja");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCierreDeCaja = new JLabel("CIERRE DE CAJA");
		lblCierreDeCaja.setHorizontalAlignment(SwingConstants.CENTER);
		lblCierreDeCaja.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblCierreDeCaja.setBounds(10, 11, 542, 56);
		contentPane.add(lblCierreDeCaja);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(10, 78, 542, 240);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Responsable de apertura:");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 232, 24);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha de apertura:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 46, 232, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblResponsableDeCierre = new JLabel("Responsable de cierre:");
		lblResponsableDeCierre.setFont(new Font("Verdana", Font.BOLD, 14));
		lblResponsableDeCierre.setBounds(10, 81, 232, 24);
		panel.add(lblResponsableDeCierre);
		
		JLabel lblVentaDeMembresias = new JLabel("Venta de membres\u00EDas:");
		lblVentaDeMembresias.setFont(new Font("Verdana", Font.BOLD, 14));
		lblVentaDeMembresias.setBounds(10, 115, 232, 27);
		panel.add(lblVentaDeMembresias);
		
		JLabel lblVisitasDelDia = new JLabel("Visitas del d\u00EDa:");
		lblVisitasDelDia.setFont(new Font("Verdana", Font.BOLD, 14));
		lblVisitasDelDia.setBounds(10, 153, 232, 24);
		panel.add(lblVisitasDelDia);
		
		JLabel lblEgresosDelDia = new JLabel("Egresos del d\u00EDa:");
		lblEgresosDelDia.setFont(new Font("Verdana", Font.BOLD, 14));
		lblEgresosDelDia.setBounds(10, 190, 232, 24);
		panel.add(lblEgresosDelDia);
		
		textFieldEgresos = new JTextField();
		textFieldEgresos.setForeground(new Color(128, 0, 0));
		textFieldEgresos.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldEgresos.setFont(new Font("Verdana", Font.BOLD, 14));
		textFieldEgresos.setEditable(false);
		textFieldEgresos.setBounds(232, 190, 200, 27);
		panel.add(textFieldEgresos);
		textFieldEgresos.setColumns(10);
		
		textFieldVisitas = new JTextField();
		textFieldVisitas.setForeground(new Color(34, 139, 34));
		textFieldVisitas.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldVisitas.setFont(new Font("Verdana", Font.BOLD, 14));
		textFieldVisitas.setEditable(false);
		textFieldVisitas.setColumns(10);
		textFieldVisitas.setBounds(232, 153, 200, 27);
		panel.add(textFieldVisitas);
		
		textFieldVentasM = new JTextField();
		textFieldVentasM.setForeground(new Color(34, 139, 34));
		textFieldVentasM.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldVentasM.setFont(new Font("Verdana", Font.BOLD, 14));
		textFieldVentasM.setEditable(false);
		textFieldVentasM.setColumns(10);
		textFieldVentasM.setBounds(232, 116, 200, 27);
		panel.add(textFieldVentasM);
		
		labelResponsableCierre = new JLabel("");
		labelResponsableCierre.setHorizontalAlignment(SwingConstants.RIGHT);
		labelResponsableCierre.setFont(new Font("Verdana", Font.BOLD, 14));
		labelResponsableCierre.setBounds(232, 81, 200, 24);
		panel.add(labelResponsableCierre);
		
		labelFechaApertura = new JLabel("");
		labelFechaApertura.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFechaApertura.setFont(new Font("Verdana", Font.BOLD, 14));
		labelFechaApertura.setBounds(232, 46, 200, 24);
		panel.add(labelFechaApertura);
		
		labelResponsableApertura = new JLabel("");
		labelResponsableApertura.setHorizontalAlignment(SwingConstants.RIGHT);
		labelResponsableApertura.setFont(new Font("Verdana", Font.BOLD, 14));
		labelResponsableApertura.setBounds(232, 11, 200, 24);
		panel.add(labelResponsableApertura);
		
		JButton buttonDetallesMembresia = new JButton("Detalles");
		buttonDetallesMembresia.setBounds(442, 119, 89, 23);
		panel.add(buttonDetallesMembresia);
		
		JButton buttonDetallesVisitasDia = new JButton("Detalles");
		buttonDetallesVisitasDia.setBounds(442, 156, 89, 23);
		panel.add(buttonDetallesVisitasDia);
		
		JButton buttonDetalleEgresosDia = new JButton("Detalles");
		buttonDetalleEgresosDia.setBounds(442, 193, 89, 23);
		panel.add(buttonDetalleEgresosDia);
	}
	public JLabel getLabelResponsableApertura() {
		return labelResponsableApertura;
	}
	public JLabel getLabelFechaApertura() {
		return labelFechaApertura;
	}
	public JLabel getLabelResponsableCierre() {
		return labelResponsableCierre;
	}
	public JTextField getTextFieldVentasM() {
		return textFieldVentasM;
	}
	public JTextField getTextFieldVisitas() {
		return textFieldVisitas;
	}
	public JTextField getTextFieldEgresos() {
		return textFieldEgresos;
	}
}

package co.powergym.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class BackupView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUbicacion;
	private JButton btnGenerarCopiaDe;
	private JButton btnCancelar;
	private JButton btnSeleccionar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BackupView frame = new BackupView();
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
	public BackupView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblCopiaDeSeguridad = new JLabel("COPIA DE SEGURIDAD");
		lblCopiaDeSeguridad.setFont(new Font("Verdana", Font.BOLD, 18));
		panel.add(lblCopiaDeSeguridad);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblUbicacin = new JLabel("Ubicaci\u00F3n:");
		lblUbicacin.setFont(new Font("Verdana", Font.BOLD, 11));
		lblUbicacin.setBounds(10, 26, 124, 14);
		panel_1.add(lblUbicacin);
		
		textFieldUbicacion = new JTextField();
		textFieldUbicacion.setBounds(87, 24, 346, 20);
		panel_1.add(textFieldUbicacion);
		textFieldUbicacion.setColumns(10);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setBounds(436, 23, 89, 23);
		panel_1.add(btnSeleccionar);
		
		btnGenerarCopiaDe = new JButton("Generar copia de seguridad");
		btnGenerarCopiaDe.setBounds(134, 64, 167, 23);
		panel_1.add(btnGenerarCopiaDe);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(309, 64, 100, 23);
		panel_1.add(btnCancelar);
	}
	public JButton getBtnGenerarCopiaDe() {
		return btnGenerarCopiaDe;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	public JButton getBtnSeleccionar() {
		return btnSeleccionar;
	}
	public JTextField getTextFieldUbicacion() {
		return textFieldUbicacion;
	}
}

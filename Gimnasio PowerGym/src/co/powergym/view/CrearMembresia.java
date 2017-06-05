package co.powergym.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CrearMembresia extends JFrame {

	private JPanel contentPane;
	private JTextField tfNombreMembresia;
	private JButton btnSiguiente;
	private JButton btnCancelar;
	private JLabel lblNombreMembresia;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearMembresia frame = new CrearMembresia();
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
	public CrearMembresia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCrearMembresia = new JLabel("Crear un tipo de membresia");
		lblCrearMembresia.setBounds(5, 5, 440, 19);
		lblCrearMembresia.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrearMembresia.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		contentPane.add(lblCrearMembresia);
		
		lblNombreMembresia = new JLabel("¿Qué nombre le dara a la nueva membresia?");
		lblNombreMembresia.setBounds(20, 67, 285, 16);
		contentPane.add(lblNombreMembresia);
		
		tfNombreMembresia = new JTextField();
		tfNombreMembresia.setBounds(20, 88, 410, 26);
		contentPane.add(tfNombreMembresia);
		tfNombreMembresia.setColumns(10);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(92, 235, 117, 37);
		contentPane.add(btnCancelar);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(221, 235, 117, 37);
		contentPane.add(btnSiguiente);
	}
	public JButton getBtnSiguiente() {
		return btnSiguiente;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	public JTextField getTextField() {
		return tfNombreMembresia;
	}
	
	
	public JLabel getLblNombreMembresia() {
		return lblNombreMembresia;
	}
}

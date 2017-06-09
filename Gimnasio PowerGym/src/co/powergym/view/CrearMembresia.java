package co.powergym.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;

public class CrearMembresia extends JFrame {

	private JPanel contentPane;
	private JTextField tfNombreMembresia;
	private JButton btnSiguiente;
	private JButton btnCancelar;
	private JLabel lblNombreMembresia;
	private JLabel label;
	private JLabel lblPasoDe;
	
	
	/**
	 * Create the frame.
	 */
	public CrearMembresia() {
		setBounds(100, 100, 474, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(87, 402, 117, 37);
		contentPane.add(btnCancelar);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(216, 402, 117, 37);
		contentPane.add(btnSiguiente);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 203, 397, 187);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNombreMembresia = new JLabel("¿Qué nombre le dara a la nueva membresia?");
		lblNombreMembresia.setBounds(16, 6, 285, 16);
		panel.add(lblNombreMembresia);
		
		tfNombreMembresia = new JTextField();
		tfNombreMembresia.setBounds(16, 27, 374, 26);
		panel.add(tfNombreMembresia);
		tfNombreMembresia.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(513, 36, 211, 187);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setForeground(Color.WHITE);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 0, 474, 95);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("/Users/iosdeveloper/Google Drive/Membresias/Membresia.png"));
		label.setBounds(29, 25, 35, 50);
		panel_2.add(label);
		
		JLabel lblCrearMembresia = new JLabel("Crear un tipo de membresia");
		lblCrearMembresia.setBounds(76, 33, 286, 19);
		panel_2.add(lblCrearMembresia);
		lblCrearMembresia.setHorizontalAlignment(SwingConstants.LEFT);
		lblCrearMembresia.setFont(new Font("Lucida Grande", Font.BOLD, 12));
		
		lblPasoDe = new JLabel("Paso 1 de 4");
		lblPasoDe.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblPasoDe.setBounds(76, 50, 61, 16);
		panel_2.add(lblPasoDe);
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
	@Override
	public JPanel getContentPane() {
		return contentPane;
	}
}

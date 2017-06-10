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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearMembresia extends JFrame {

	private JPanel contentPane;
	private JTextField tfNombreMembresia;
	private JButton btnSiguiente;
	private JButton btn_anterior;
	private JLabel lbl_pregunta_1;
	private JLabel label;
	private JLabel lblPasoDe;
	private JLabel lbl_pregunta;
	private JLabel lbl_pregunta_2;
	private JLabel lb_pregunta;
	
	/**
	 * Create the frame.
	 */
	public CrearMembresia() {
		setBounds(100, 100, 807, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btn_anterior = new JButton("Atras");
		btn_anterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_anterior.setBounds(501, 127, 117, 37);
		contentPane.add(btn_anterior);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(336, 280, 117, 37);
		contentPane.add(btnSiguiente);
		
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
		
		tfNombreMembresia = new JTextField();
		tfNombreMembresia.setBounds(16, 138, 374, 26);
		contentPane.add(tfNombreMembresia);
		tfNombreMembresia.setColumns(10);
		
		lbl_pregunta_1 = new JLabel("¿Qué nombre le dara a la nueva membresia?");
		lbl_pregunta_1.setBounds(20, 118, 285, 16);
		contentPane.add(lbl_pregunta_1);
		
		lbl_pregunta = new JLabel("Seleccione la duración de esta membresía");
		lbl_pregunta.setBounds(503, 21, 285, 16);
		contentPane.add(lbl_pregunta);
		
		lb_pregunta = new JLabel("¿Qué nombre le dara a la nueva membresia?");
		lb_pregunta.setBounds(503, 46, 285, 16);
		contentPane.add(lb_pregunta);
		
		lbl_pregunta_2 = new JLabel("¿Qué nombre le dara a la nueva membresia?");
		lbl_pregunta_2.setBounds(503, 74, 285, 16);
		contentPane.add(lbl_pregunta_2);
		
		JButton button = new JButton("Siguiente");
		button.setBounds(22, 280, 117, 37);
		contentPane.add(button);
	}
	public JButton getBtnSiguiente() {
		return btnSiguiente;
	}
	public JButton getBtnAtras() {
		return btn_anterior;
	}
	public JTextField getTextField() {
		return tfNombreMembresia;
	}
	public JLabel getLbl_pregunta_1() {
		return lbl_pregunta_1;
	}
	public JLabel getLbl_pregunta_2() {
		return lbl_pregunta;
	}
	public JLabel getLbl_pregunta_4() {
		return lbl_pregunta_2;
	}
	public JLabel getLb_pregunta_3() {
		return lb_pregunta;
	}
}

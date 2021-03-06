package co.powergym.view.socio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;

public class SocioRegistroHuella extends JFrame {

	private JPanel contentPane;
	private JPanel panelHuella;
	private JPanel panelBotones;
	private JScrollPane textArea;
	private JButton btnSalir;
	private JLabel lblImagenHuella1;
	private JButton btnGuardar;
	private JLabel lblImagenHuella2;
	private JLabel lblImagenHuella3;
	private JLabel lblImagenHuella4;
	private JTextArea textArea_1;

	

	/**
	 * Create the frame.
	 */
	public SocioRegistroHuella() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 643, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setBackground(new Color(32, 39, 49));
		panelHuella = new JPanel();
		panelHuella.setBorder(new TitledBorder(null, "Huella digital", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelHuella.setBounds(10, 11, 612, 199);
		contentPane.add(panelHuella);
		panelHuella.setLayout(null);
		
		lblImagenHuella1 = new JLabel("");
		lblImagenHuella1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblImagenHuella1.setBounds(10, 28, 140, 150);
		panelHuella.add(lblImagenHuella1);
		
		lblImagenHuella2 = new JLabel("");
		lblImagenHuella2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblImagenHuella2.setBounds(160, 28, 140, 150);
		panelHuella.add(lblImagenHuella2);
		
		lblImagenHuella3 = new JLabel("");
		lblImagenHuella3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblImagenHuella3.setBounds(310, 28, 140, 150);
		panelHuella.add(lblImagenHuella3);
		
		lblImagenHuella4 = new JLabel("");
		lblImagenHuella4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblImagenHuella4.setBounds(460, 28, 140, 150);
		panelHuella.add(lblImagenHuella4);
		
		panelBotones = new JPanel();
		panelBotones.setBorder(new TitledBorder(null, "Acciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBotones.setBounds(10, 211, 612, 75);
		contentPane.add(panelBotones);
		
		btnGuardar = new JButton("Guardar");
		panelBotones.add(btnGuardar);
		
		btnSalir = new JButton("Salir");
		panelBotones.add(btnSalir);
		
		textArea = new JScrollPane();
		textArea.setBounds(10, 297, 612, 129);
		contentPane.add(textArea);
		
		textArea_1 = new JTextArea();
		textArea.setViewportView(textArea_1);
	}
	public JPanel getPanelHuella() {
		return panelHuella;
	}
	public JPanel getPanelBotones() {
		return panelBotones;
	}
	public JTextArea getTextArea() {
		return textArea_1;
	}
	public JButton getBtnSalir() {
		return btnSalir;
	}
	public JLabel getLblImagenHuella1() {
		return lblImagenHuella1;
	}
	public JButton getBtnGuardar() {
		return btnGuardar;
	}
	
	public void callFirePropertyChange(String template, Object old, Object nuevo) {
		firePropertyChange(template, old, nuevo);
	}
	public JLabel getLblImagenHuella4() {
		return lblImagenHuella4;
	}
	public JLabel getLblImagenHuella2() {
		return lblImagenHuella2;
	}
	public JLabel getLblImagenHuella3() {
		return lblImagenHuella3;
	}
}

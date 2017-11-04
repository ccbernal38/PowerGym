package co.powergym.view.socio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import co.powergym.utils.ButtonSecundario;
import co.powergym.utils.Constantes;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 643, 527);
		contentPane = new JPanel();
		contentPane.setBackground(Constantes.black());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setBackground(new Color(32, 39, 49));
		panelHuella = new JPanel();
		panelHuella.setBackground(Constantes.black());
		panelHuella.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Huella digital",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		panelHuella.setBounds(10, 72, 612, 199);
		contentPane.add(panelHuella);
		panelHuella.setLayout(null);

		lblImagenHuella1 = new JLabel("");
		lblImagenHuella1.setOpaque(true);
		lblImagenHuella1.setBackground(Color.WHITE);
		lblImagenHuella1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblImagenHuella1.setBounds(10, 28, 140, 150);
		panelHuella.add(lblImagenHuella1);

		lblImagenHuella2 = new JLabel("");
		lblImagenHuella2.setOpaque(true);
		lblImagenHuella2.setBackground(Color.WHITE);
		lblImagenHuella2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblImagenHuella2.setBounds(160, 28, 140, 150);
		panelHuella.add(lblImagenHuella2);

		lblImagenHuella3 = new JLabel("");
		lblImagenHuella3.setOpaque(true);
		lblImagenHuella3.setBackground(Color.WHITE);
		lblImagenHuella3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblImagenHuella3.setBounds(310, 28, 140, 150);
		panelHuella.add(lblImagenHuella3);

		lblImagenHuella4 = new JLabel("");
		lblImagenHuella4.setBackground(Color.WHITE);
		lblImagenHuella4.setOpaque(true);
		lblImagenHuella4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblImagenHuella4.setBounds(460, 28, 140, 150);
		panelHuella.add(lblImagenHuella4);

		panelBotones = new JPanel();
		panelBotones.setBackground(Constantes.black());
		panelBotones.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Acciones",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		panelBotones.setBounds(10, 272, 612, 61);
		contentPane.add(panelBotones);
		panelBotones.setLayout(null);

		btnGuardar = new ButtonSecundario("Guardar");
		btnGuardar.setBounds(232, 21, 80, 27);
		panelBotones.add(btnGuardar);

		btnSalir = new ButtonSecundario("Salir");
		btnSalir.setBounds(317, 21, 80, 27);
		panelBotones.add(btnSalir);

		textArea = new JScrollPane();
		textArea.setBounds(10, 344, 612, 143);
		contentPane.add(textArea);

		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setFont(new Font("Verdana", Font.BOLD, 14));
		textArea.setViewportView(textArea_1);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 637, 56);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Registro de huella");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		panel.add(lblNewLabel);
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

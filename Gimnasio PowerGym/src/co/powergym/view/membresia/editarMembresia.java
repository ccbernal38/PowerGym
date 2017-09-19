package co.powergym.view.membresia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class editarMembresia extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNuevoNombreM;
	private JTextField textFieldNuevoValor;
	private JTextField textFieldNuevaCantidad;
	private JButton btnGuardar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editarMembresia frame = new editarMembresia();
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
	public editarMembresia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelNombreMem = new JLabel("Asigne un nuevo nombre a la membres\u00EDa:");
		labelNombreMem.setBounds(33, 69, 285, 16);
		contentPane.add(labelNombreMem);
		
		textFieldNuevoNombreM = new JTextField();
		textFieldNuevoNombreM.setColumns(10);
		textFieldNuevoNombreM.setBounds(33, 96, 374, 26);
		contentPane.add(textFieldNuevoNombreM);
		
		JLabel lblEditarMembresia = new JLabel("Editar Membresia");
		lblEditarMembresia.setFont(new Font("Verdana", Font.BOLD, 18));
		lblEditarMembresia.setBounds(10, 22, 217, 26);
		contentPane.add(lblEditarMembresia);
		
		JLabel labelNuevoValor = new JLabel("Asigne un nuevo nombre a la membres\u00EDa:");
		labelNuevoValor.setBounds(33, 136, 285, 16);
		contentPane.add(labelNuevoValor);
		
		JLabel label = new JLabel("$");
		label.setFont(new Font("Tahoma", Font.BOLD, 26));
		label.setBounds(33, 159, 25, 34);
		contentPane.add(label);
		
		textFieldNuevoValor = new JTextField();
		textFieldNuevoValor.setColumns(10);
		textFieldNuevoValor.setBounds(57, 164, 86, 26);
		contentPane.add(textFieldNuevoValor);
		
		JLabel label_1 = new JLabel("\u2022");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_1.setBounds(10, 65, 20, 20);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u2022");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_2.setBounds(10, 133, 20, 20);
		contentPane.add(label_2);
		
		JLabel labelNuevoLimite = new JLabel("Asigne el nuevo limite de visitas por dia:");
		labelNuevoLimite.setBounds(33, 205, 285, 16);
		contentPane.add(labelNuevoLimite);
		
		JLabel label_4 = new JLabel("\u2022");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_4.setBounds(10, 202, 20, 20);
		contentPane.add(label_4);
		
		textFieldNuevaCantidad = new JTextField();
		textFieldNuevaCantidad.setColumns(10);
		textFieldNuevaCantidad.setBounds(33, 232, 47, 26);
		contentPane.add(textFieldNuevaCantidad);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(318, 282, 89, 23);
		contentPane.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(219, 282, 89, 23);
		contentPane.add(btnCancelar);
	}
	public JTextField getTextFieldNuevaCantidad() {
		return textFieldNuevaCantidad;
	}
	public JButton getBtnGuardar() {
		return btnGuardar;
	}
	public JTextField getTextFieldNuevoValor() {
		return textFieldNuevoValor;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	public JTextField getTextFieldNuevoNombreM() {
		return textFieldNuevoNombreM;
	}
}

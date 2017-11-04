package co.powergym.view.membresia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.powergym.utils.ButtonSecundario;
import co.powergym.utils.Constantes;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Color;

public class MembresiaEditarView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNuevoNombreM;
	private JTextField textFieldNuevoValor;
	private JTextField textFieldNuevaCantidad;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private int id;
	private JCheckBox chckbxDesactivar;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	/**
	 * Create the frame.
	 */
	public MembresiaEditarView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 446, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Constantes.black());
		contentPane.setLayout(null);
		
		JLabel labelNombreMem = new JLabel("Nombre:");
		labelNombreMem.setFont(new Font("Verdana", Font.BOLD, 14));
		labelNombreMem.setForeground(Constantes.white());
		labelNombreMem.setBounds(21, 85, 86, 18);
		labelNombreMem.setBackground(Constantes.white());
		contentPane.add(labelNombreMem);
		
		textFieldNuevoNombreM = new JTextField();
		textFieldNuevoNombreM.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldNuevoNombreM.setColumns(10);
		textFieldNuevoNombreM.setBounds(184, 82, 235, 27);
		contentPane.add(textFieldNuevoNombreM);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 440, 56);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblEditarMembresia = new JLabel("Editar Membresia");
		lblEditarMembresia.setForeground(Color.BLACK);
		lblEditarMembresia.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblEditarMembresia);
		lblEditarMembresia.setFont(new Font("Verdana", Font.BOLD, 18));
		
		JLabel labelNuevoValor = new JLabel("Precio:");
		labelNuevoValor.setFont(new Font("Verdana", Font.BOLD, 14));
		labelNuevoValor.setForeground(Constantes.white());
		labelNuevoValor.setBounds(21, 123, 99, 18);
		contentPane.add(labelNuevoValor);
		
		JLabel label = new JLabel("$");
		label.setForeground(new Color(34, 139, 34));
		label.setFont(new Font("Tahoma", Font.BOLD, 26));
		label.setBounds(183, 115, 25, 34);
		contentPane.add(label);
		
		textFieldNuevoValor = new JTextField();
		textFieldNuevoValor.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldNuevoValor.setColumns(10);
		textFieldNuevoValor.setBounds(205, 120, 214, 27);
		contentPane.add(textFieldNuevoValor);
		
		JLabel labelNuevoLimite = new JLabel("Visitas por d\u00EDa:");
		labelNuevoLimite.setFont(new Font("Verdana", Font.BOLD, 14));
		labelNuevoLimite.setForeground(Constantes.white());
		labelNuevoLimite.setBounds(21, 163, 139, 18);
		contentPane.add(labelNuevoLimite);
		
		textFieldNuevaCantidad = new JTextField();
		textFieldNuevaCantidad.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldNuevaCantidad.setColumns(10);
		textFieldNuevaCantidad.setBounds(184, 160, 235, 27);
		contentPane.add(textFieldNuevaCantidad);
		
		btnGuardar = new ButtonSecundario("Guardar");
		btnGuardar.setBounds(316, 277, 89, 23);
		contentPane.add(btnGuardar);
		
		btnCancelar = new ButtonSecundario("Cancelar");
		btnCancelar.setBounds(217, 277, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblDesactivarEstaMembresa = new JLabel("Desactivar esta membres\u00EDa:");
		lblDesactivarEstaMembresa.setFont(new Font("Verdana", Font.BOLD, 14));
		lblDesactivarEstaMembresa.setForeground(Constantes.white());
		lblDesactivarEstaMembresa.setBounds(21, 211, 285, 18);
		contentPane.add(lblDesactivarEstaMembresa);
		
		chckbxDesactivar = new JCheckBox("Desactivar");
		chckbxDesactivar.setForeground(Color.WHITE);
		chckbxDesactivar.setFont(new Font("Verdana", Font.PLAIN, 12));
		chckbxDesactivar.setBackground(Constantes.black());
		chckbxDesactivar.setBounds(280, 210, 110, 23);
		contentPane.add(chckbxDesactivar);
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
	public JCheckBox getChckbxDesactivar() {
		return chckbxDesactivar;
	}
}

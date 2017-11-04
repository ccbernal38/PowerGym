package co.powergym.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import co.powergym.utils.ButtonSecundario;
import co.powergym.utils.Constantes;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;

public class BackupView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUbicacion;
	private JButton btnGenerarCopiaDe;
	private JButton btnCancelar;
	private JButton btnSeleccionar;

	/**
	 * Create the frame.
	 */
	public BackupView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 561, 193);
		contentPane = new JPanel();
		contentPane.setBackground(Constantes.black());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 545, 56);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblCopiaDeSeguridad = new JLabel("COPIA DE SEGURIDAD");
		lblCopiaDeSeguridad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCopiaDeSeguridad.setFont(new Font("Verdana", Font.BOLD, 18));
		panel.add(lblCopiaDeSeguridad);

		JLabel lblUbicacin = new JLabel("Ubicaci\u00F3n:");
		lblUbicacin.setForeground(Constantes.white());
		lblUbicacin.setBackground(Color.WHITE);
		lblUbicacin.setBounds(10, 77, 124, 27);
		contentPane.add(lblUbicacin);
		lblUbicacin.setFont(new Font("Verdana", Font.BOLD, 12));

		textFieldUbicacion = new JTextField();
		textFieldUbicacion.setBounds(96, 78, 346, 27);
		contentPane.add(textFieldUbicacion);
		textFieldUbicacion.setColumns(10);

		btnGenerarCopiaDe = new ButtonSecundario("Generar copia de seguridad");
		btnGenerarCopiaDe.setBounds(260, 116, 167, 23);
		contentPane.add(btnGenerarCopiaDe);

		btnCancelar = new ButtonSecundario("Cancelar");
		btnCancelar.setBounds(435, 116, 100, 23);
		contentPane.add(btnCancelar);

		btnSeleccionar = new ButtonSecundario("Seleccionar");
		btnSeleccionar.setBounds(446, 78, 89, 27);
		contentPane.add(btnSeleccionar);
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

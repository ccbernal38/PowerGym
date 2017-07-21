package co.powergym.view.socio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class SocioRegistrarEntradaView extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnCancelar;
	private JTextField textField;
	private JLabel lblRegistroDeEntrada;

	/**
	 * Create the frame.
	 */
	public SocioRegistrarEntradaView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 425, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Escaneando huella....", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(15, 63, 384, 205);
		
		btnNewButton = new JButton("Identificar");
		btnNewButton.setBounds(75, 279, 122, 23);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(226, 279, 122, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(panel);
		contentPane.add(btnNewButton);
		contentPane.add(btnCancelar);
		
		JLabel lblIngreseElNmero = new JLabel("Ingrese el n\u00FAmero de identificaci\u00F3n del socio:");
		lblIngreseElNmero.setBounds(15, 38, 312, 14);
		contentPane.add(lblIngreseElNmero);
		
		textField = new JTextField();
		textField.setBounds(284, 35, 115, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblRegistroDeEntrada = new JLabel("REGISTRO DE ENTRADA");
		lblRegistroDeEntrada.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeEntrada.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegistroDeEntrada.setBounds(13, 13, 386, 14);
		contentPane.add(lblRegistroDeEntrada);
	}
	public JButton getBtnIdentificar() {
		return btnNewButton;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	public JTextField getTextFieldIdentificacion() {
		return textField;
	}
}

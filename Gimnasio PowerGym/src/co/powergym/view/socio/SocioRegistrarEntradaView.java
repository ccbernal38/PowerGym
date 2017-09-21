package co.powergym.view.socio;

import java.awt.BorderLayout;
import java.awt.Color;
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

import com.digitalpersona.onetouch.DPFPTemplate;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSeparator;

public class SocioRegistrarEntradaView extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnCancelar;
	private JTextField textField;
	private JLabel lblRegistroDeEntrada;
	private JLabel lblHuella;
	private JTextArea textArea;
	private JButton btnVerificar;

	/**
	 * Create the frame.
	 */
	public SocioRegistrarEntradaView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 425, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setBackground(new Color(32, 39, 49));
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Escaneando huella....", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(15, 109, 384, 205);
		
		btnNewButton = new JButton("Identificar");
		btnNewButton.setBounds(73, 418, 122, 23);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(205, 418, 122, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		lblHuella = new JLabel("");
		panel.add(lblHuella, BorderLayout.CENTER);
		contentPane.add(btnNewButton);
		contentPane.add(btnCancelar);
		
		JLabel lblIngreseElNmero = new JLabel("Ingrese el n\u00FAmero de identificaci\u00F3n del socio:");
		lblIngreseElNmero.setBounds(15, 38, 312, 14);
		contentPane.add(lblIngreseElNmero);
		
		textField = new JTextField();
		textField.setBounds(274, 35, 125, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblRegistroDeEntrada = new JLabel("REGISTRO DE ENTRADA");
		lblRegistroDeEntrada.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeEntrada.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegistroDeEntrada.setBounds(13, 13, 386, 14);
		contentPane.add(lblRegistroDeEntrada);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 325, 384, 82);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		btnVerificar = new JButton("Verificar");
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVerificar.setBounds(274, 63, 125, 23);
		contentPane.add(btnVerificar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(15, 97, 384, 2);
		contentPane.add(separator);
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
	public JLabel getLblHuella() {
		return lblHuella;
	}
	public JTextArea getTextArea() {
		return textArea;
	}
	public void callFirePropertyChange(String tEMPLATE_PROPERTY, DPFPTemplate old, DPFPTemplate template) {
		firePropertyChange(tEMPLATE_PROPERTY, old, template);		
	}
	public JButton getBtnVerificar() {
		return btnVerificar;
	}
}

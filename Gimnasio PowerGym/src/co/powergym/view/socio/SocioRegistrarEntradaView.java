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

public class SocioRegistrarEntradaView extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SocioRegistrarEntradaView frame = new SocioRegistrarEntradaView();
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
	public SocioRegistrarEntradaView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Escaneando huella....", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(15, 16, 404, 252);
		
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
	}
	public JButton getBtnIdentificar() {
		return btnNewButton;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}

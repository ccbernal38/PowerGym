package co.powergym.view.socio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import co.powergym.utils.Constantes;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class SocioListConsultaBusquedaView extends JFrame {

	private JPanel contentPane;
	private JList listSocios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SocioListConsultaBusquedaView frame = new SocioListConsultaBusquedaView();
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
	public SocioListConsultaBusquedaView() {
		setTitle("Resultados");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 453, 417);
		contentPane = new JPanel();
		contentPane.setBackground(Constantes.black());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 437, 56);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblResultadosDeLa = new JLabel("Resultados de la busqueda");
		lblResultadosDeLa.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultadosDeLa.setFont(new Font("Verdana", Font.BOLD, 18));
		panel.add(lblResultadosDeLa);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 60, 427, 313);
		contentPane.add(scrollPane);

		listSocios = new JList();
		listSocios.setModel(new AbstractListModel() {
			String[] values = new String[] {};

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listSocios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listSocios);
	}

	public JList getListSocios() {
		return listSocios;
	}
}

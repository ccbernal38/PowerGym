package co.powergym.view.membresia;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.powergym.utils.ButtonSecundario;
import co.powergym.utils.Constantes;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.BorderLayout;

public class MembresiaListadoView extends JFrame {

	private JPanel contentPane;
	private JTable tableMembresias;
	private JButton btnNuevo;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JPanel panel;

	/**
	 * Create the frame.
	 */
	public MembresiaListadoView() {
		setResizable(false);
		setTitle("Listado de membresias");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Constantes.black());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 127, 624, 265);

		btnNuevo = new ButtonSecundario("Nuevo");
		btnNuevo.setForeground(Color.BLACK);
		btnNuevo.setBackground(Color.GRAY);
		btnNuevo.setBounds(334, 66, 90, 50);

		
		btnEditar = new ButtonSecundario("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEditar.setForeground(Color.BLACK);
		btnEditar.setBackground(Color.GRAY);
		btnEditar.setBounds(434, 66, 90, 50);

		btnEliminar = new ButtonSecundario("Eliminar");
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setBackground(Color.GRAY);
		
		
		btnEliminar.setBounds(534, 66, 90, 50);

		tableMembresias = new JTable();
		tableMembresias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableMembresias.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Id", "Nombre de la membres\u00EDa", "Precio", "Duración" 
			}
		));
		tableMembresias.getColumnModel().getColumn(0).setPreferredWidth(10);
		tableMembresias.getColumnModel().getColumn(1).setPreferredWidth(200);
		tableMembresias.getColumnModel().getColumn(2).setPreferredWidth(90);
		scrollPane.setViewportView(tableMembresias);
		tableMembresias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableMembresias.setForeground(Color.BLACK);
		tableMembresias.setGridColor(Constantes.white());
		tableMembresias.setBorder(null);
		tableMembresias.setFillsViewportHeight(true);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 644, 56);
		contentPane.add(panel);
				panel.setLayout(new BorderLayout(0, 0));
		
				JLabel lblListadoDeMembresas = new JLabel("LISTADO DE MEMBRESIAS");
				lblListadoDeMembresas.setBackground(Color.WHITE);
				panel.add(lblListadoDeMembresas);
				lblListadoDeMembresas.setHorizontalAlignment(SwingConstants.CENTER);
				lblListadoDeMembresas.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(scrollPane);
		contentPane.add(btnNuevo);
		contentPane.add(btnEditar);
		contentPane.add(btnEliminar);
	}

	public JTable getTableListMembresias() {
		return tableMembresias;
	}
	public JButton getBtnNuevo() {
		return btnNuevo;
	}
	public JButton getBtnEditar() {
		return btnEditar;
	}
	public JButton getBtnEliminar() {
		return btnEliminar;
	}
}

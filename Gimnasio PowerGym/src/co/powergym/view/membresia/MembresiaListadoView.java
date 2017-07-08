package co.powergym.view.membresia;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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

public class MembresiaListadoView extends JFrame {

	private JPanel contentPane;
	private JTable tableMembresias;
	private JButton btnNuevo;
	private JButton btnEditar;
	private JButton btnEliminar;

	/**
	 * Create the frame.
	 */
	public MembresiaListadoView() {
		setTitle("Listado de membresias");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 127, 614, 265);

		JLabel lblListadoDeMembresas = new JLabel("LISTADO DE MEMBRESIAS");
		lblListadoDeMembresas.setBounds(10, 16, 614, 42);
		lblListadoDeMembresas.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoDeMembresas.setFont(new Font("Tahoma", Font.BOLD, 18));

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setForeground(SystemColor.text);
		btnNuevo.setBackground(Color.GRAY);
		btnNuevo.setBounds(334, 66, 90, 50);

		
		btnEditar = new JButton("Editar");
		btnEditar.setForeground(SystemColor.text);
		btnEditar.setBackground(Color.GRAY);
		btnEditar.setBounds(434, 66, 90, 50);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(SystemColor.text);
		btnEliminar.setBackground(Color.GRAY);
		
		
		btnEliminar.setBounds(534, 66, 90, 50);

		tableMembresias = new JTable();
		tableMembresias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableMembresias.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Id", "Nombre de la membres\u00EDa", "Precio", "Duracion" 
			}
		));
		tableMembresias.getColumnModel().getColumn(0).setPreferredWidth(10);
		tableMembresias.getColumnModel().getColumn(1).setPreferredWidth(200);
		tableMembresias.getColumnModel().getColumn(2).setPreferredWidth(90);
		scrollPane.setViewportView(tableMembresias);
		contentPane.setLayout(null);
		contentPane.add(lblListadoDeMembresas);
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

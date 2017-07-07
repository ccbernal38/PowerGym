package co.powergym.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.ScrollPane;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ListaEntrenador extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable JTableListaEntrenador;
	private JTextField txtListaDeEntrenadores;
	private JPanel contentPane;
	
	public ListaEntrenador(){
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().setLayout(null);
		setContentPane(contentPane);
		
		JTableListaEntrenador = new JTable();
		JTableListaEntrenador.setBounds(33, 57, 389, 197);
		getContentPane().add(JTableListaEntrenador);
		
		txtListaDeEntrenadores = new JTextField();
		txtListaDeEntrenadores.setText("LISTA DE ENTRENADORES");
		txtListaDeEntrenadores.setBounds(141, 6, 174, 26);
		getContentPane().add(txtListaDeEntrenadores);
		txtListaDeEntrenadores.setColumns(10);
		
		JTableListaEntrenador.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Identificaci\u00F3n", "Nombre"
			}
		));
		JTableListaEntrenador.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JTableListaEntrenador.setBounds(-32, 68, 579, 301);
		JTableHeader header = new JTableHeader();
		header.setName("Lista de entrenadores");
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(22, 71, 584, 251);
		scrollPane.add(JTableListaEntrenador);
		contentPane.add(scrollPane);
		
	}

	public JTable getJTableListaEntrenador() {
		return JTableListaEntrenador;
	}

	public void setJTableListaEntrenador(JTable jTableListaEntrenador) {
		JTableListaEntrenador = jTableListaEntrenador;
	}
}

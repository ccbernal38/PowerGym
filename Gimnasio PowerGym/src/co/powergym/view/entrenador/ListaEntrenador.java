package co.powergym.view.entrenador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.ScrollPane;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class ListaEntrenador extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable JTableListaEntrenador;
	
	public ListaEntrenador(){
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().setLayout(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setSize(670, 380);
		JTableHeader header = new JTableHeader();
		header.setName("Lista de entrenadores");
		
		JLabel lblistaEntrenadores = new JLabel("LISTA DE ENTRENADORES");
		lblistaEntrenadores.setHorizontalAlignment(SwingConstants.CENTER);
		lblistaEntrenadores.setBounds(206, 20, 215, 16);
		contentPane.add(lblistaEntrenadores);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 634, 273);
		contentPane.add(scrollPane);
		
		JTableListaEntrenador = new JTable();
		JTableListaEntrenador.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nro. identificación", "Nombre", "Apellido", "Dirección", "Correo electronico", "Teléfono"
			}
		));
		scrollPane.setViewportView(JTableListaEntrenador);
		
		
	}

	public JTable getJTableListaEntrenador() {
		return JTableListaEntrenador;
	}

	public void setJTableListaEntrenador(JTable jTableListaEntrenador) {
		JTableListaEntrenador = jTableListaEntrenador;
	}
}
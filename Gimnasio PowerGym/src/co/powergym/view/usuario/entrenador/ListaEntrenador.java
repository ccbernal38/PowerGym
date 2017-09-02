package co.powergym.view.usuario.entrenador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.ScrollPane;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Button;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class ListaEntrenador extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	public JTable JTableListaEntrenador;
	public JButton btnEliminar1;
	public JButton btnEditar1;
	
	public ListaEntrenador() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().setLayout(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setSize(730, 480);
		JTableHeader header = new JTableHeader();
		header.setName("Lista de entrenadores");
		
		JLabel lblistaEntrenadores = new JLabel("LISTA DE ENTRENADORES");
		lblistaEntrenadores.setHorizontalAlignment(SwingConstants.CENTER);
		lblistaEntrenadores.setBounds(206, 20, 215, 16);
		contentPane.add(lblistaEntrenadores);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 694, 273);
		contentPane.add(scrollPane);
		
		JTableListaEntrenador = new JTable();
		JTableListaEntrenador.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nro. identificaci�n", "Nombre", "Apellido", "Direcci�n", "Correo electronico", "Tel�fono", "Editar", "Eliminar"
			}
		));
		scrollPane.setViewportView(JTableListaEntrenador);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(212, 379, 117, 29);
		btnEditar1 = btnEditar;
		contentPane.add(btnEditar1);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(354, 379, 117, 29);
		btnEliminar1 = btnEliminar;
		contentPane.add(btnEliminar1);
		
		
	}

	

	public JButton getBtnEliminar1() {
		return btnEliminar1;
	}



	public void setBtnEliminar1(JButton btnEliminar1) {
		this.btnEliminar1 = btnEliminar1;
	}



	public JButton getBtnEditar1() {
		return btnEditar1;
	}



	public void setBtnEditar1(JButton btnEditar1) {
		this.btnEditar1 = btnEditar1;
	}



	public JTable getJTableListaEntrenador() {
		return JTableListaEntrenador;
	}

	public void setJTableListaEntrenador(JTable jTableListaEntrenador) {
		JTableListaEntrenador = jTableListaEntrenador;
	}
}
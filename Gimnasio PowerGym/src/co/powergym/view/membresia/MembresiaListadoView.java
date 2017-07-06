package co.powergym.view.membresia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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

public class MembresiaListadoView extends JFrame {

	private JPanel contentPane;
	private JTable tableMembresias;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MembresiaListadoView frame = new MembresiaListadoView();
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
	public MembresiaListadoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblListadoDeMembresas = new JLabel("LISTADO DE MEMBRESIAS");
		lblListadoDeMembresas.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoDeMembresas.setFont(new Font("Tahoma", Font.BOLD, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblListadoDeMembresas, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblListadoDeMembresas, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(32, Short.MAX_VALUE))
		);
		
		tableMembresias = new JTable();
		tableMembresias.setCellSelectionEnabled(true);
		tableMembresias.setColumnSelectionAllowed(true);
		tableMembresias.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre de la membres\u00EDa", "Precio", "Duracion"
			}
		));
		tableMembresias.getColumnModel().getColumn(0).setPreferredWidth(200);
		tableMembresias.getColumnModel().getColumn(2).setPreferredWidth(90);
		scrollPane.setViewportView(tableMembresias);
		contentPane.setLayout(gl_contentPane);
	}
	public JTable getTableListMembresias() {
		return tableMembresias;
	}
}

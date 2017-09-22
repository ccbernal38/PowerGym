package co.powergym.view.socio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import java.awt.ScrollPane;
import java.util.Calendar;

import com.toedter.calendar.JYearChooser;
import javax.swing.SwingConstants;

public class SocioCumpleaniosListadoView extends JFrame {

	private JPanel contentPane;
	private JTable tableSocios;

	/**
	 * Create the frame.
	 */
	public SocioCumpleaniosListadoView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 646, 459);
		setBackground(new Color(32, 39, 49));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Calendar calendar = Calendar.getInstance();
		int mesTemp = calendar.get(Calendar.MONTH) + 1;
		String mes = "";
		if (mesTemp == 1) {
			mes = "Enero";
		} else if (mesTemp == 2) {
			mes = "Febrero";
		} else if (mesTemp == 3) {
			mes = "Marzo";
		} else if (mesTemp == 4) {
			mes = "Abril";
		} else if (mesTemp == 5) {
			mes = "Mayo";
		} else if (mesTemp == 6) {
			mes = "Junio";
		} else if (mesTemp == 7) {
			mes = "Julio";
		} else if (mesTemp == 8) {
			mes = "Agosto";
		} else if (mesTemp == 9) {
			mes = "Septiembre";
		} else if (mesTemp == 10) {
			mes = "Octubre";
		} else if (mesTemp == 11) {
			mes = "Noviembre";
		} else if (mesTemp == 12) {
			mes = "Diciembre";
		}
		JLabel lblNewLabel = new JLabel("CUMPLEAÑOS DEL MES DE " + mes.toUpperCase());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 610, 42);
		contentPane.add(lblNewLabel);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 127, 614, 265);

		tableSocios = new JTable();
		tableSocios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableSocios.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Identificación", "Nombre", "Cumpleaños" }));

		tableSocios.setBounds(32, 68, 579, 301);

		scrollPane.setViewportView(tableSocios);
		contentPane.setLayout(null);
		contentPane.add(scrollPane);
	}

	public JTable getTableSocios() {
		return tableSocios;
	}

}

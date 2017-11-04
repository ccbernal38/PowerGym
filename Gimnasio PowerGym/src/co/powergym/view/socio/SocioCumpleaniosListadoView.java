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

import co.powergym.utils.Constantes;

import javax.swing.SwingConstants;

public class SocioCumpleaniosListadoView extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public SocioCumpleaniosListadoView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 634, 389);
		setBackground(new Color(32, 39, 49));
		contentPane = new JPanel();
		contentPane.setBackground(Constantes.black());
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
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 614, 265);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setForeground(Color.BLACK);
		table.setGridColor(Constantes.white());
		table.setBorder(null);
		table.setFillsViewportHeight(true);
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Identificación", "Nombre", "Cumpleaños" }));

		table.setBounds(32, 68, 579, 301);

		scrollPane.setViewportView(table);
		contentPane.setLayout(null);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 630, 56);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		JLabel lblNewLabel = new JLabel("CUMPLEAÑOS DEL MES DE " + mes.toUpperCase());
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
	}

	public JTable getTableSocios() {
		return table;
	}

}

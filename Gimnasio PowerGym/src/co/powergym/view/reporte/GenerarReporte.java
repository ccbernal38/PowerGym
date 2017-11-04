/**
 * 
 */
package co.powergym.view.reporte;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import co.powergym.utils.ButtonSecundario;
import co.powergym.utils.Constantes;

import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import java.awt.BorderLayout;

/**
 * @author nia
 *
 */
public class GenerarReporte extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JCheckBox chckbxVentasDia = new JCheckBox();
	private JCheckBox chckbxListaSocios;
	private JCheckBox chckbxVentasMes = new JCheckBox();
	private JCheckBox chckbxSociosCumppleanosMes;
	private JCheckBox chckbxVentasE = new JCheckBox();
	private JCheckBox chckbxSociosActivos;
	private JDateChooser dateChooser_fechaInicio = new JDateChooser();
	private JDateChooser dateChooser_fechaFin = new JDateChooser();
	private JButton btnGenerarFechaEspecifica = new JButton();
	private JPanel panel_especifica = new JPanel();
	private JTable table;
	private JButton btnExportar;
	private JCheckBox checkBoxSociosInactivos;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * 
	 */
	public GenerarReporte() {
		getContentPane().setBackground(Constantes.black());
		setResizable(false);
		getContentPane().setLayout(null);
		setBounds(100, 100, 813, 591);

		JLabel lbl_lista_informes = new JLabel("Seleccione el tipo de informe:");
		lbl_lista_informes.setForeground(Constantes.white());
		lbl_lista_informes.setFont(new Font("Verdana", Font.BOLD, 14));
		lbl_lista_informes.setBounds(37, 95, 312, 16);
		getContentPane().add(lbl_lista_informes);

		chckbxListaSocios = new JCheckBox("Lista de socios");
		chckbxListaSocios.setFont(new Font("Verdana", Font.PLAIN, 12));
		chckbxListaSocios.setBackground(Constantes.black());
		chckbxListaSocios.setForeground(Constantes.white());
		buttonGroup.add(chckbxListaSocios);
		chckbxListaSocios.setBounds(53, 123, 127, 23);
		getContentPane().add(chckbxListaSocios);

		chckbxSociosCumppleanosMes = new JCheckBox("Socios cumplea\u00F1os del mes");
		chckbxSociosCumppleanosMes.setFont(new Font("Verdana", Font.PLAIN, 12));
		chckbxSociosCumppleanosMes.setBackground(Constantes.black());
		chckbxSociosCumppleanosMes.setForeground(Constantes.white());
		buttonGroup.add(chckbxSociosCumppleanosMes);
		chckbxSociosCumppleanosMes.setBounds(182, 123, 201, 23);
		getContentPane().add(chckbxSociosCumppleanosMes);

		chckbxSociosActivos = new JCheckBox("Socios activos");
		chckbxSociosActivos.setFont(new Font("Verdana", Font.PLAIN, 12));
		chckbxSociosActivos.setBackground(Constantes.black());
		chckbxSociosActivos.setForeground(Constantes.white());
		buttonGroup.add(chckbxSociosActivos);
		chckbxSociosActivos.setBounds(385, 123, 117, 23);
		getContentPane().add(chckbxSociosActivos);

		panel_especifica = new JPanel();
		panel_especifica.setBackground(Constantes.black());
		panel_especifica.setBounds(37, 153, 728, 71);
		getContentPane().add(panel_especifica);
		panel_especifica.setLayout(null);

		JLabel lblSeleccioneLasFechas = new JLabel("Seleccione las fechas del informe");
		lblSeleccioneLasFechas.setFont(new Font("Verdana", Font.BOLD, 12));
		lblSeleccioneLasFechas.setForeground(Constantes.white());
		lblSeleccioneLasFechas.setBounds(18, 6, 282, 16);
		panel_especifica.add(lblSeleccioneLasFechas);

		JLabel lblDe = new JLabel("De:");
		lblDe.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblDe.setForeground(Constantes.white());
		lblDe.setBounds(28, 34, 29, 16);
		panel_especifica.add(lblDe);

		dateChooser_fechaInicio = new JDateChooser();
		dateChooser_fechaInicio.setBounds(57, 29, 193, 27);
		panel_especifica.add(dateChooser_fechaInicio);

		JLabel lblA = new JLabel("A:");
		lblA.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblA.setForeground(Constantes.white());
		lblA.setBounds(281, 34, 19, 16);
		panel_especifica.add(lblA);

		dateChooser_fechaFin = new JDateChooser();
		dateChooser_fechaFin.setBounds(300, 29, 193, 27);
		panel_especifica.add(dateChooser_fechaFin);

		btnGenerarFechaEspecifica = new ButtonSecundario("Aceptar");
		btnGenerarFechaEspecifica.setBounds(522, 29, 117, 29);
		panel_especifica.add(btnGenerarFechaEspecifica);

		JLabel lblVistaPreviaDel = new JLabel("Vista previa del informe");
		lblVistaPreviaDel.setForeground(Constantes.white());
		lblVistaPreviaDel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblVistaPreviaDel.setBounds(37, 235, 312, 16);
		getContentPane().add(lblVistaPreviaDel);

		btnExportar = new ButtonSecundario("Exportar");
		btnExportar.setBounds(648, 513, 117, 29);
		getContentPane().add(btnExportar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 262, 728, 240);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setForeground(Color.BLACK);
		table.setGridColor(Constantes.white());
		table.setBorder(null);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);

		checkBoxSociosInactivos = new JCheckBox("Socios inactivos");
		checkBoxSociosInactivos.setFont(new Font("Verdana", Font.PLAIN, 12));
		checkBoxSociosInactivos.setBackground(Constantes.black());
		checkBoxSociosInactivos.setForeground(Constantes.white());
		buttonGroup.add(checkBoxSociosInactivos);
		checkBoxSociosInactivos.setBounds(514, 123, 133, 23);
		getContentPane().add(checkBoxSociosInactivos);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 807, 56);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		JLabel lblNewLabel = new JLabel("Informe de ventas");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		// table_vista_informe.addColumn(aColumn);

		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the chckbxVentasDia
	 */
	public JCheckBox getChckbxVentasDia() {
		return chckbxVentasDia;
	}

	/**
	 * @param chckbxVentasDia
	 *            the chckbxVentasDia to set
	 */
	public void setChckbxVentasDia(JCheckBox chckbxVentasDia) {
		this.chckbxVentasDia = chckbxVentasDia;
	}

	/**
	 * @return the chckbxSociosCumppleanosMes
	 */
	public JCheckBox getChckbxSociosCumppleanosMes() {
		return chckbxSociosCumppleanosMes;
	}

	/**
	 * @param chckbxSociosCumppleanosMes
	 *            the chckbxSociosCumppleanosMes to set
	 */
	public void setChckbxSociosCumppleanosMes(JCheckBox chckbxSociosCumppleanosMes) {
		this.chckbxSociosCumppleanosMes = chckbxSociosCumppleanosMes;
	}

	/**
	 * @return the tableReportes
	 */
	public JTable getTableReportes() {
		return table;
	}

	/**
	 * @param tableReportes
	 *            the tableReportes to set
	 */
	public void setTableReportes(JTable tableReportes) {
		this.table = tableReportes;
	}

	/**
	 * @param chckbxListaSocios
	 *            the chckbxListaSocios to set
	 */
	public void setChckbxListaSocios(JCheckBox chckbxListaSocios) {
		this.chckbxListaSocios = chckbxListaSocios;
	}

	/**
	 * @return
	 */
	public JCheckBox getChckbxListaSocios() {
		return chckbxListaSocios;
	}

	/**
	 * @return the chckbxVentasDelMes
	 */
	public JCheckBox getChckbxVentasMes() {
		return chckbxSociosCumppleanosMes;
	}

	/**
	 * @param chckbxVentasDelMes
	 *            the chckbxVentasDelMes to set
	 */
	public void setChckbxVentasMes(JCheckBox chckbxVentasDelMes) {
		this.chckbxSociosCumppleanosMes = chckbxVentasDelMes;
	}

	/**
	 * @return the chckbxVentasEnUna
	 */
	public JCheckBox getChckbxSociosActivos() {
		return chckbxSociosActivos;
	}

	/**
	 * @param chckbxVentasEnUna
	 *            the chckbxVentasEnUna to set
	 */
	public void setChckbxSociosActivos(JCheckBox chckbxVentasEnUna) {
		this.chckbxSociosActivos = chckbxVentasEnUna;
	}

	/**
	 * @return the dateChooser_fechaInicio
	 */
	public JDateChooser getDateChooser_fechaInicio() {
		return dateChooser_fechaInicio;
	}

	/**
	 * @param dateChooser_fechaInicio
	 *            the dateChooser_fechaInicio to set
	 */
	public void setDateChooser_fechaInicio(JDateChooser dateChooser_fechaInicio) {
		this.dateChooser_fechaInicio = dateChooser_fechaInicio;
	}

	/**
	 * @return the dateChooser_fechaFin
	 */
	public JDateChooser getDateChooser_fechaFin() {
		return dateChooser_fechaFin;
	}

	/**
	 * @param dateChooser_fechaFin
	 *            the dateChooser_fechaFin to set
	 */
	public void setDateChooser_fechaFin(JDateChooser dateChooser_fechaFin) {
		this.dateChooser_fechaFin = dateChooser_fechaFin;
	}

	/**
	 * @return the btnGenerarFechaEspecifica
	 */
	public JButton getBtnGenerarFechaEspecifica() {
		return btnGenerarFechaEspecifica;
	}

	/**
	 * @param btnGenerarFechaEspecifica
	 *            the btnGenerarFechaEspecifica to set
	 */
	public void setBtnGenerarFechaEspecifica(JButton btnGenerarFechaEspecifica) {
		this.btnGenerarFechaEspecifica = btnGenerarFechaEspecifica;
	}

	/**
	 * @return the panel_especifica
	 */
	public JPanel getPanel_especifica() {
		return panel_especifica;
	}

	/**
	 * @param panel_especifica
	 *            the panel_especifica to set
	 */
	public void setPanel_especifica(JPanel panel_especifica) {
		this.panel_especifica = panel_especifica;
	}

	public JButton getBtnExportar() {
		return btnExportar;
	}

	public JCheckBox getCheckBoxSociosInactivos() {
		return checkBoxSociosInactivos;
	}
}

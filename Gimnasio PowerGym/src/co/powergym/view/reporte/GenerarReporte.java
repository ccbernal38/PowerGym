/**
 * 
 */
package co.powergym.view.reporte;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 * @author nia
 *
 */
public class GenerarReporte extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table_vista_informe;
	private JCheckBox chckbxVentasDia= new JCheckBox();
	private JCheckBox chckbxVentasMes= new JCheckBox();
	private JCheckBox chckbxVentasE= new JCheckBox();
	private JDateChooser dateChooser_fechaInicio = new JDateChooser();
	private JDateChooser dateChooser_fechaFin = new JDateChooser();
	private JButton btnGenerarFechaEspecifica = new JButton();
	private JPanel panel_especifica = new JPanel();

	/**
	 * 
	 */
	public GenerarReporte() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Informe de ventas");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(281, 33, 146, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lbl_lista_informes = new JLabel("Seleccione el tipo de informe:");
		lbl_lista_informes.setBounds(37, 95, 202, 16);
		getContentPane().add(lbl_lista_informes);
		
		chckbxVentasDia = new JCheckBox("Ventas del día");
		chckbxVentasDia.setBounds(47, 123, 128, 23);
		getContentPane().add(chckbxVentasDia);
		
		chckbxVentasMes = new JCheckBox("Ventas del mes actual");
		chckbxVentasMes.setBounds(182, 123, 169, 23);
		getContentPane().add(chckbxVentasMes);
		
		chckbxVentasE = new JCheckBox("Ventas en una fecha específica");
		chckbxVentasE.setBounds(363, 123, 230, 23);
		getContentPane().add(chckbxVentasE);
		
		panel_especifica = new JPanel();
		panel_especifica.setBackground(Color.WHITE);
		panel_especifica.setBounds(57, 158, 536, 119);
		getContentPane().add(panel_especifica);
		panel_especifica.setLayout(null);
		
		JLabel lblSeleccioneLasFechas = new JLabel("Seleccione las fechas del informe");
		lblSeleccioneLasFechas.setBounds(18, 6, 220, 16);
		panel_especifica.add(lblSeleccioneLasFechas);
		
		JLabel lblDe = new JLabel("De:");
		lblDe.setBounds(28, 34, 29, 16);
		panel_especifica.add(lblDe);
		
		dateChooser_fechaInicio = new JDateChooser();
		dateChooser_fechaInicio.setBounds(58, 34, 193, 16);
		panel_especifica.add(dateChooser_fechaInicio);
		
		JLabel lblA = new JLabel("A:");
		lblA.setBounds(281, 34, 19, 16);
		panel_especifica.add(lblA);
		
		dateChooser_fechaFin = new JDateChooser();
		dateChooser_fechaFin.setBounds(306, 34, 193, 16);
		panel_especifica.add(dateChooser_fechaFin);
		
		btnGenerarFechaEspecifica = new JButton("Aceptar");
		btnGenerarFechaEspecifica.setBackground(Color.LIGHT_GRAY);
		btnGenerarFechaEspecifica.setBounds(219, 81, 117, 29);
		panel_especifica.add(btnGenerarFechaEspecifica);
		
		JLabel lblVistaPreviaDel = new JLabel("Vista previa del informe");
		lblVistaPreviaDel.setBounds(65, 289, 174, 16);
		getContentPane().add(lblVistaPreviaDel);
		
		table_vista_informe = new JTable();
		table_vista_informe.setBounds(90, 453, 491, -120);
		getContentPane().add(table_vista_informe);
		
		
		//table_vista_informe.addColumn(aColumn);
		
		
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @return the chckbxVentasDelDa
	 */
	public JCheckBox getChckbxVentasDia() {
		return chckbxVentasDia;
	}

	/**
	 * @param chckbxVentasDelDa the chckbxVentasDelDa to set
	 */
	public void setChckbxVentasDia(JCheckBox chckbxVentasDelDa) {
		this.chckbxVentasDia = chckbxVentasDelDa;
	}

	/**
	 * @return the chckbxVentasDelMes
	 */
	public JCheckBox getChckbxVentasMes() {
		return chckbxVentasMes;
	}

	/**
	 * @param chckbxVentasDelMes the chckbxVentasDelMes to set
	 */
	public void setChckbxVentasMes(JCheckBox chckbxVentasDelMes) {
		this.chckbxVentasMes = chckbxVentasDelMes;
	}

	/**
	 * @return the chckbxVentasEnUna
	 */
	public JCheckBox getChckbxVentasE() {
		return chckbxVentasE;
	}

	/**
	 * @param chckbxVentasEnUna the chckbxVentasEnUna to set
	 */
	public void setChckbxVentasE(JCheckBox chckbxVentasEnUna) {
		this.chckbxVentasE = chckbxVentasEnUna;
	}

	/**
	 * @return the dateChooser_fechaInicio
	 */
	public JDateChooser getDateChooser_fechaInicio() {
		return dateChooser_fechaInicio;
	}

	/**
	 * @param dateChooser_fechaInicio the dateChooser_fechaInicio to set
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
	 * @param dateChooser_fechaFin the dateChooser_fechaFin to set
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
	 * @param btnGenerarFechaEspecifica the btnGenerarFechaEspecifica to set
	 */
	public void setBtnGenerarFechaEspecifica(JButton btnGenerarFechaEspecifica) {
		this.btnGenerarFechaEspecifica = btnGenerarFechaEspecifica;
	}

	/**
	 * @return the table_vista_informe
	 */
	public JTable getTable_vista_informe() {
		return table_vista_informe;
	}

	/**
	 * @param table_vista_informe the table_vista_informe to set
	 */
	public void setTable_vista_informe(JTable table_vista_informe) {
		this.table_vista_informe = table_vista_informe;
	}

	/**
	 * @return the panel_especifica
	 */
	public JPanel getPanel_especifica() {
		return panel_especifica;
	}

	/**
	 * @param panel_especifica the panel_especifica to set
	 */
	public void setPanel_especifica(JPanel panel_especifica) {
		this.panel_especifica = panel_especifica;
	}
}

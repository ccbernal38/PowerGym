package co.powergym.view.socio;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.Checkbox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.text.Format;
import java.text.NumberFormat;

import javax.swing.JButton;

public class SocioAsignarMembresiaView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldValorInscripcion;
	private JLabel labelResumenTotal;
	private JLabel labelResumenSubtotal;
	private JLabel labelResumenCostoInscripcion;
	private JLabel lblResumenPrecioMembresia;
	private JComboBox comboBoxMembresia;
	private Checkbox checkbox;
	private JComboBox comboBoxDia;
	private JComboBox comboBoxMes;
	private JRadioButton rdbtnSi;
	private JRadioButton rdbtnNo;
	private JButton btnFinalizar;
	private JButton btnCancelar;
	private JLabel labelPrecioMembresia;
	private JLabel labelVisitasPorDia;
	private JLabel labelHorarioPermitido;
	private JLabel labelDuracionMembresia;
	private JLabel labelDiasPermitidos;
	private JLabel labelResumenNombreMembresia;
	private JLabel labelResumenDuracion;

	/**
	 * Create the frame.
	 */
	public SocioAsignarMembresiaView() {
		setBackground(new Color(32, 39, 49));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 591, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccioneUnaMembresia = new JLabel("Seleccione una membresia:");
		lblSeleccioneUnaMembresia.setBounds(37, 53, 198, 14);
		contentPane.add(lblSeleccioneUnaMembresia);
		
		comboBoxMembresia = new JComboBox();
		comboBoxMembresia.setBounds(260, 50, 275, 20);
		contentPane.add(comboBoxMembresia);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(37, 78, 498, 149);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPrecioDeLa = new JLabel("Precio de la membresia: ");
		lblPrecioDeLa.setBounds(10, 11, 157, 14);
		panel.add(lblPrecioDeLa);
		
		JLabel lblNewLabel = new JLabel("Duraci\u00F3n de la membresia:");
		lblNewLabel.setBounds(10, 36, 157, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Visitas por d\u00EDa permitidas:");
		lblNewLabel_1.setBounds(10, 61, 157, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("D\u00EDas permitidos:");
		lblNewLabel_2.setBounds(10, 86, 157, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblHorarioPermitido = new JLabel("Horario permitido:");
		lblHorarioPermitido.setBounds(10, 111, 157, 14);
		panel.add(lblHorarioPermitido);
		
		labelPrecioMembresia = new JLabel("");
		labelPrecioMembresia.setBounds(213, 11, 275, 14);
		panel.add(labelPrecioMembresia);
		
		labelDuracionMembresia = new JLabel("");
		labelDuracionMembresia.setBounds(213, 36, 275, 14);
		panel.add(labelDuracionMembresia);
		
		labelVisitasPorDia = new JLabel("");
		labelVisitasPorDia.setBounds(213, 61, 275, 14);
		panel.add(labelVisitasPorDia);
		
		labelDiasPermitidos = new JLabel("");
		labelDiasPermitidos.setBounds(213, 86, 275, 14);
		panel.add(labelDiasPermitidos);
		
		labelHorarioPermitido = new JLabel("");
		labelHorarioPermitido.setVerticalAlignment(SwingConstants.TOP);
		labelHorarioPermitido.setBounds(213, 111, 275, 38);
		panel.add(labelHorarioPermitido);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de inicio de la membresia");
		lblFechaDeInicio.setBounds(37, 238, 198, 14);
		contentPane.add(lblFechaDeInicio);
		
		comboBoxDia = new JComboBox();
		comboBoxDia.setBounds(320, 235, 50, 20);
		for (int i = 1; i <= 31 ; i++) {
			comboBoxDia.addItem(i);
		}
		contentPane.add(comboBoxDia);
		
		comboBoxMes = new JComboBox();
		comboBoxMes.setBounds(380, 235, 155, 20);
		contentPane.add(comboBoxMes);
		
		JLabel lblRenovarAutomaticamente = new JLabel("Renovar automaticamente:");
		lblRenovarAutomaticamente.setBounds(37, 263, 198, 14);
		contentPane.add(lblRenovarAutomaticamente);
		
		rdbtnSi = new JRadioButton("Si");
		rdbtnSi.setSelected(true);
		rdbtnSi.setBounds(320, 259, 50, 23);
		
		contentPane.add(rdbtnSi);
		
		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(411, 259, 69, 23);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnSi);
		buttonGroup.add(rdbtnNo);
		contentPane.add(rdbtnNo);
		
		JLabel lblSeCobra = new JLabel("Se cobrar\u00E1 inscripcion:");
		lblSeCobra.setBounds(37, 288, 198, 14);
		contentPane.add(lblSeCobra);
		
		checkbox = new Checkbox("Si");
		checkbox.setBounds(320, 285, 50, 17);
		contentPane.add(checkbox);
		Format format = NumberFormat.getNumberInstance();
		textFieldValorInscripcion = new JFormattedTextField(format);
		textFieldValorInscripcion.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldValorInscripcion.setText("0");
		textFieldValorInscripcion.setBounds(380, 285, 155, 20);
		contentPane.add(textFieldValorInscripcion);
		textFieldValorInscripcion.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Asignaci\u00F3n de membresia");
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(37, 11, 498, 28);
		contentPane.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(37, 314, 498, 189);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPrecioDeLa_1 = new JLabel("Precio de la membresia");
		lblPrecioDeLa_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblPrecioDeLa_1.setBounds(20, 82, 230, 14);
		panel_1.add(lblPrecioDeLa_1);
		
		JLabel lblNewLabel_6 = new JLabel("Costo de Inscripci\u00F3n:");
		lblNewLabel_6.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(20, 132, 230, 14);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblSubtotal = new JLabel("Subtotal");
		lblSubtotal.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblSubtotal.setBounds(20, 107, 230, 14);
		panel_1.add(lblSubtotal);
		
		JLabel lblNewLabel_7 = new JLabel("TOTAL A PAGAR:");
		lblNewLabel_7.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(20, 157, 230, 14);
		panel_1.add(lblNewLabel_7);
		
		lblResumenPrecioMembresia = new JLabel("");
		lblResumenPrecioMembresia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblResumenPrecioMembresia.setFont(new Font("Verdana", Font.BOLD, 12));
		lblResumenPrecioMembresia.setBounds(260, 83, 228, 14);
		panel_1.add(lblResumenPrecioMembresia);
		
		labelResumenSubtotal = new JLabel("");
		labelResumenSubtotal.setHorizontalAlignment(SwingConstants.RIGHT);
		labelResumenSubtotal.setFont(new Font("Verdana", Font.BOLD, 12));
		labelResumenSubtotal.setBounds(260, 108, 228, 14);
		panel_1.add(labelResumenSubtotal);
		
		labelResumenCostoInscripcion = new JLabel("");
		labelResumenCostoInscripcion.setHorizontalAlignment(SwingConstants.RIGHT);
		labelResumenCostoInscripcion.setFont(new Font("Verdana", Font.BOLD, 12));
		labelResumenCostoInscripcion.setBounds(260, 133, 228, 14);
		panel_1.add(labelResumenCostoInscripcion);
		
		labelResumenTotal = new JLabel("");
		labelResumenTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		labelResumenTotal.setFont(new Font("Verdana", Font.BOLD, 12));
		labelResumenTotal.setBounds(260, 158, 228, 14);
		panel_1.add(labelResumenTotal);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(1, 1, 496, 71);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		labelResumenDuracion = new JLabel("Comienza el z hasta el x");
		labelResumenDuracion.setBounds(10, 46, 478, 14);
		panel_2.add(labelResumenDuracion);
		labelResumenDuracion.setFont(new Font("Verdana", Font.BOLD, 12));
		labelResumenDuracion.setHorizontalAlignment(SwingConstants.CENTER);
		
		labelResumenNombreMembresia = new JLabel("New label");
		labelResumenNombreMembresia.setBounds(10, 11, 478, 27);
		panel_2.add(labelResumenNombreMembresia);
		labelResumenNombreMembresia.setHorizontalAlignment(SwingConstants.CENTER);
		labelResumenNombreMembresia.setFont(new Font("Verdana", Font.BOLD, 14));
		
		btnFinalizar = new JButton("FINALIZAR");
		btnFinalizar.setBounds(165, 534, 107, 23);
		contentPane.add(btnFinalizar);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(282, 534, 107, 23);
		contentPane.add(btnCancelar);
	}
	public JLabel getLabelResumenTotal() {
		return labelResumenTotal;
	}
	public JLabel getLabelResumenSubtotal() {
		return labelResumenSubtotal;
	}
	public JLabel getLabelResumenCostoInscripcion() {
		return labelResumenCostoInscripcion;
	}
	public JLabel getLblResumenPrecioMembresia() {
		return lblResumenPrecioMembresia;
	}
	public JComboBox getComboBoxMembresia() {
		return comboBoxMembresia;
	}
	public Checkbox getCheckboxInscripcion() {
		return checkbox;
	}
	public JTextField getTextFieldValorInscripcion() {
		return textFieldValorInscripcion;
	}
	public JComboBox getComboBoxDia() {
		return comboBoxDia;
	}
	public JComboBox getComboBoxMes() {
		return comboBoxMes;
	}

	public JRadioButton getRdbtnSi() {
		return rdbtnSi;
	}
	public JRadioButton getRdbtnNo() {
		return rdbtnNo;
	}
	public JButton getBtnFinalizar() {
		return btnFinalizar;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	public JLabel getLabelPrecioMembresia() {
		return labelPrecioMembresia;
	}
	public JLabel getLabelVisitasPorDia() {
		return labelVisitasPorDia;
	}
	public JLabel getLabelHorarioPermitido() {
		return labelHorarioPermitido;
	}
	public JLabel getLabelDuracionMembresia() {
		return labelDuracionMembresia;
	}
	public JLabel getLabelDiasPermitidos() {
		return labelDiasPermitidos;
	}
	public JLabel getLabelResumenNombreMembresia() {
		return labelResumenNombreMembresia;
	}
	public JLabel getLabelResumenDuracion() {
		return labelResumenDuracion;
	}
}

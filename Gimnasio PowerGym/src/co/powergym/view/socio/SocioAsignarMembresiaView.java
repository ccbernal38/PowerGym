package co.powergym.view.socio;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import java.awt.Checkbox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Calendar;

import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import co.powergym.model.Membresia;

import javax.swing.JScrollPane;
import javax.swing.JCheckBox;

public class SocioAsignarMembresiaView extends JFrame {

	private JPanel contentPane;
	private JLabel labelResumenTotal;
	private JLabel labelResumenSubtotal;
	private JLabel labelResumenDescuento;
	private JLabel lblResumenPrecioMembresia;
	private JComboBox<Membresia> comboBoxMembresia;
	private JButton btnFinalizar;
	private JButton btnCancelar;
	private JLabel labelPrecioMembresia;
	private JLabel labelVisitasPorDia;
	private JLabel labelDuracionMembresia;
	private JLabel labelDiasPermitidos;
	private JLabel labelResumenNombreMembresia;
	private JLabel labelResumenDuracion;
	private JDateChooser dateChooserInicio;
	private JDateChooser dateChooserFin;
	private JTextArea labelHorarioPermitido;
	private JTextField textFieldDescuento;
	private JCheckBox rdbtnSi;

	/**
	 * Create the frame.
	 */
	public SocioAsignarMembresiaView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 591, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(42, 45, 52));
		contentPane.setLayout(null);

		JLabel lblSeleccioneUnaMembresia = new JLabel("Seleccione una membresia:");
		lblSeleccioneUnaMembresia.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblSeleccioneUnaMembresia.setForeground(Color.WHITE);
		lblSeleccioneUnaMembresia.setBounds(37, 53, 198, 14);
		contentPane.add(lblSeleccioneUnaMembresia);

		comboBoxMembresia = new JComboBox();
		comboBoxMembresia.setFont(new Font("Verdana", Font.PLAIN, 11));
		comboBoxMembresia.setBounds(260, 50, 275, 20);
		contentPane.add(comboBoxMembresia);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(42, 45, 52));
		panel.setBorder(new LineBorder(Color.WHITE, 1, true));
		panel.setBounds(37, 78, 498, 149);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblPrecioDeLa = new JLabel("Precio de la membresia: ");
		lblPrecioDeLa.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblPrecioDeLa.setForeground(Color.WHITE);
		lblPrecioDeLa.setBounds(10, 11, 193, 14);
		panel.add(lblPrecioDeLa);

		JLabel lblNewLabel = new JLabel("Duraci\u00F3n de la membresia:");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 36, 193, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Visitas por d\u00EDa permitidas:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(10, 61, 193, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("D\u00EDas permitidos:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(10, 86, 193, 14);
		panel.add(lblNewLabel_2);

		JLabel lblHorarioPermitido = new JLabel("Horario permitido:");
		lblHorarioPermitido.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblHorarioPermitido.setForeground(Color.WHITE);
		lblHorarioPermitido.setBounds(10, 111, 193, 14);
		panel.add(lblHorarioPermitido);

		labelPrecioMembresia = new JLabel("");
		labelPrecioMembresia.setFont(new Font("Verdana", Font.PLAIN, 12));
		labelPrecioMembresia.setForeground(Color.WHITE);
		labelPrecioMembresia.setBounds(213, 11, 275, 14);
		panel.add(labelPrecioMembresia);

		labelDuracionMembresia = new JLabel("");
		labelDuracionMembresia.setFont(new Font("Verdana", Font.PLAIN, 12));
		labelDuracionMembresia.setForeground(Color.WHITE);
		labelDuracionMembresia.setBounds(213, 36, 275, 14);
		panel.add(labelDuracionMembresia);

		labelVisitasPorDia = new JLabel("");
		labelVisitasPorDia.setFont(new Font("Verdana", Font.PLAIN, 12));
		labelVisitasPorDia.setForeground(Color.WHITE);
		labelVisitasPorDia.setBounds(213, 61, 275, 14);
		panel.add(labelVisitasPorDia);

		labelDiasPermitidos = new JLabel("");
		labelDiasPermitidos.setFont(new Font("Verdana", Font.PLAIN, 12));
		labelDiasPermitidos.setForeground(Color.WHITE);
		labelDiasPermitidos.setBounds(213, 86, 275, 14);
		panel.add(labelDiasPermitidos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(213, 105, 275, 39);
		panel.add(scrollPane);

		labelHorarioPermitido = new JTextArea();
		labelHorarioPermitido.setForeground(Color.WHITE);
		labelHorarioPermitido.setBackground(new Color(42, 45, 52));
		labelHorarioPermitido.setEditable(false);
		scrollPane.setViewportView(labelHorarioPermitido);

		JLabel lblFechaDeInicio = new JLabel("Fecha de inicio de la membres\u00EDa");
		lblFechaDeInicio.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblFechaDeInicio.setForeground(Color.WHITE);
		lblFechaDeInicio.setBounds(37, 238, 275, 14);
		contentPane.add(lblFechaDeInicio);

		JLabel lblRenovarAutomaticamente = new JLabel("Renovar automaticamente:");
		lblRenovarAutomaticamente.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblRenovarAutomaticamente.setForeground(Color.WHITE);
		lblRenovarAutomaticamente.setBounds(37, 289, 198, 14);
		contentPane.add(lblRenovarAutomaticamente);
		ButtonGroup buttonGroup = new ButtonGroup();
		Format format = NumberFormat.getNumberInstance();

		JLabel lblNewLabel_3 = new JLabel("Asignaci\u00F3n de membresia");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(37, 11, 498, 28);
		contentPane.add(lblNewLabel_3);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(37, 359, 498, 189);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblPrecioDeLa_1 = new JLabel("Precio de la membresia");
		lblPrecioDeLa_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblPrecioDeLa_1.setBounds(20, 82, 230, 14);
		panel_1.add(lblPrecioDeLa_1);

		JLabel lblNewLabel_6 = new JLabel("Descuento:");
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

		labelResumenDescuento = new JLabel("");
		labelResumenDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
		labelResumenDescuento.setFont(new Font("Verdana", Font.BOLD, 12));
		labelResumenDescuento.setBounds(260, 133, 228, 14);
		panel_1.add(labelResumenDescuento);

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
		btnFinalizar.setBounds(166, 559, 107, 23);
		contentPane.add(btnFinalizar);

		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(283, 559, 107, 23);
		contentPane.add(btnCancelar);

		dateChooserInicio = new JDateChooser();
		dateChooserInicio.setDateFormatString("dd/MM/yyyy");
		dateChooserInicio.setFont(new Font("Verdana", Font.PLAIN, 11));
		dateChooserInicio.setBounds(319, 232, 215, 20);
		dateChooserInicio.setDate(Calendar.getInstance().getTime());
		contentPane.add(dateChooserInicio);

		JLabel lblFechaDeFinalizacin = new JLabel("Fecha de finalizaci\u00F3n de la membres\u00EDa");
		lblFechaDeFinalizacin.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblFechaDeFinalizacin.setForeground(Color.WHITE);
		lblFechaDeFinalizacin.setBounds(37, 263, 272, 14);
		contentPane.add(lblFechaDeFinalizacin);

		dateChooserFin = new JDateChooser();
		dateChooserFin.setDateFormatString("dd/MM/yyyy");
		dateChooserFin.setFont(new Font("Verdana", Font.PLAIN, 11));
		dateChooserFin.setBounds(319, 258, 215, 20);
		contentPane.add(dateChooserFin);

		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblDescuento.setForeground(Color.WHITE);
		lblDescuento.setBounds(37, 314, 275, 14);
		contentPane.add(lblDescuento);

		try {
			MaskFormatter mascara = new MaskFormatter("######");

			textFieldDescuento = new JTextField();
			textFieldDescuento.setFont(new Font("Verdana", Font.PLAIN, 11));
			textFieldDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
			textFieldDescuento.setText("0");
			textFieldDescuento.setBounds(319, 311, 215, 20);
			contentPane.add(textFieldDescuento);

			rdbtnSi = new JCheckBox("Si");
			rdbtnSi.setFont(new Font("Verdana", Font.PLAIN, 11));
			rdbtnSi.setForeground(Color.WHITE);
			rdbtnSi.setBackground(new Color(42, 45, 52));
			rdbtnSi.setBounds(319, 285, 97, 23);
			contentPane.add(rdbtnSi);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public JLabel getLabelResumenTotal() {
		return labelResumenTotal;
	}

	public JLabel getLabelResumenSubtotal() {
		return labelResumenSubtotal;
	}

	public JLabel getLabelResumenCostoInscripcion() {
		return labelResumenDescuento;
	}

	public JLabel getLblResumenPrecioMembresia() {
		return lblResumenPrecioMembresia;
	}

	public JComboBox getComboBoxMembresia() {
		return comboBoxMembresia;
	}

	public JCheckBox getRdbtnSi() {
		return rdbtnSi;
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

	public JDateChooser getDateChooserInicio() {
		return dateChooserInicio;
	}

	public JDateChooser getDateChooserFin() {
		return dateChooserFin;
	}

	public JTextArea getLabelHorarioPermitido() {
		return labelHorarioPermitido;
	}

	public JTextField getTextFieldDescuento() {
		return textFieldDescuento;
	}
}

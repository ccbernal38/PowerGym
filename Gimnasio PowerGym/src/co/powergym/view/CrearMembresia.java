package co.powergym.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JList;

public class CrearMembresia extends JFrame {

	private JPanel contentPane;
	private JTextField tfNombreMembresia;
	private JButton btnSiguiente;
	private JButton btn_anterior;
	private JLabel lbl_pregunta_1;
	private JLabel lbl_imagen_m;
	private JLabel lblPasoDe;
	private JLabel lbl_pregunta_2;
	private JLabel lbl_pregunta_4;
	private JLabel lb_pregunta_3;
	private JComboBox CBXCantidad;
	private JComboBox CBXTipoTiempo;
	private JLabel lblCantidad;
	private JCheckBox chckbxNo;
	private JCheckBox chckbxSi;
	private JComboBox comboBoxVisitas;
	private JCheckBox checkBoxTodosDias;
	private JCheckBox checkBox_viernes;
	private JCheckBox checkBox_sabado;
	private JCheckBox checkBox_domingo;
	private JCheckBox checkBox_jueves;
	private JCheckBox checkBox_miercoles;
	private JCheckBox checkBox_martes;
	private JCheckBox checkBox_lunes;
	private JLabel label_signoP;
	private JTextField textFieldPrecio;
	private JLabel lbl_pregunta5;
	private JCheckBox chckbxNo_horario;
	private JCheckBox chckbxSi_horario;
	private JComboBox comboBox_de;
	private JLabel lblDe;
	private JLabel lblA;
	private JComboBox comboBox_a;
	private JButton buttonEliminarH;
	private JButton btnAadirHorario;
	private JList list_listaHorarios;
	private JLabel lbl_costoMembresia;
	
	/**
	 * Create the frame.
	 */
	public CrearMembresia() {
		setBounds(100, 100, 883, 762);
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btn_anterior = new JButton("Atras");
		btn_anterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_anterior.setBounds(726, 105, 110, 30);
		contentPane.add(btn_anterior);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(338, 317, 110, 30);
		contentPane.add(btnSiguiente);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setForeground(Color.WHITE);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 0, 474, 95);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		lbl_imagen_m = new JLabel("");
		lbl_imagen_m.setIcon(new ImageIcon("/Users/iosdeveloper/Google Drive/Membresias/Membresia.png"));
		lbl_imagen_m.setBounds(29, 25, 35, 50);
		panel_2.add(lbl_imagen_m);
		
		JLabel lblCrearMembresia = new JLabel("Crear un tipo de membresia");
		lblCrearMembresia.setBounds(76, 33, 286, 19);
		panel_2.add(lblCrearMembresia);
		lblCrearMembresia.setHorizontalAlignment(SwingConstants.LEFT);
		lblCrearMembresia.setFont(new Font("Lucida Grande", Font.BOLD, 12));
		
		lblPasoDe = new JLabel("Paso 1 de 5");
		lblPasoDe.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblPasoDe.setBounds(76, 50, 61, 16);
		panel_2.add(lblPasoDe);
		
		lbl_pregunta_1 = new JLabel("Asigne un nombre a la nuea membres\u00EDa:");
		lbl_pregunta_1.setBounds(47, 360, 285, 16);
		contentPane.add(lbl_pregunta_1);
		
		lbl_pregunta_2 = new JLabel("Seleccione la duraci\u00F3n de esta membres\u00EDa");
		lbl_pregunta_2.setBounds(503, 21, 285, 16);
		contentPane.add(lbl_pregunta_2);
		
		lb_pregunta_3 = new JLabel("\u00BFSe limitaran las visitas por dia para esta membres\u00EDa?");
		lb_pregunta_3.setBounds(503, 84, 344, 16);
		contentPane.add(lb_pregunta_3);
		
		lbl_pregunta_4 = new JLabel("Seleccione los d\u00EDas de ingreso para esta membres\u00EDa:");
		lbl_pregunta_4.setBounds(503, 171, 285, 16);
		contentPane.add(lbl_pregunta_4);
		
		CBXCantidad = new JComboBox();
		CBXCantidad.setBounds(564, 45, 61, 27);
		contentPane.add(CBXCantidad);
		
		CBXTipoTiempo = new JComboBox();
		CBXTipoTiempo.setBounds(623, 45, 165, 27);
		contentPane.add(CBXTipoTiempo);
		
		lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(503, 49, 61, 16);
		contentPane.add(lblCantidad);
		
		chckbxSi = new JCheckBox("SI. Inidicar el n\u00FAmero de visitas permitidas por d\u00EDa.");
		chckbxSi.setBounds(503, 147, 267, 23);
		contentPane.add(chckbxSi);
		
		chckbxNo = new JCheckBox("NO");
		chckbxNo.setBounds(503, 112, 128, 23);
		contentPane.add(chckbxNo);
		
		comboBoxVisitas = new JComboBox();
		comboBoxVisitas.setBounds(777, 145, 61, 27);
		contentPane.add(comboBoxVisitas);
		
		checkBoxTodosDias = new JCheckBox("Todos los d\u00EDas");
		checkBoxTodosDias.setBounds(720, 230, 93, 23);
		contentPane.add(checkBoxTodosDias);
		
		checkBox_viernes = new JCheckBox("Viernes");
		checkBox_viernes.setBounds(510, 230, 61, 23);
		contentPane.add(checkBox_viernes);
		
		checkBox_sabado = new JCheckBox("Sabado");
		checkBox_sabado.setBounds(580, 230, 61, 23);
		contentPane.add(checkBox_sabado);
		
		checkBox_domingo = new JCheckBox("Domingo");
		checkBox_domingo.setBounds(650, 230, 69, 23);
		contentPane.add(checkBox_domingo);
		
		checkBox_jueves = new JCheckBox("Jueves");
		checkBox_jueves.setBounds(720, 202, 69, 23);
		contentPane.add(checkBox_jueves);
		
		checkBox_miercoles = new JCheckBox("Miercoles");
		checkBox_miercoles.setBounds(650, 202, 69, 23);
		contentPane.add(checkBox_miercoles);
		
		checkBox_martes = new JCheckBox("Martes");
		checkBox_martes.setBounds(580, 202, 61, 23);
		contentPane.add(checkBox_martes);
		
		checkBox_lunes = new JCheckBox("Lunes");
		checkBox_lunes.setBounds(510, 202, 61, 23);
		contentPane.add(checkBox_lunes);
		
		tfNombreMembresia = new JTextField();
		tfNombreMembresia.setBounds(52, 387, 374, 26);
		contentPane.add(tfNombreMembresia);
		tfNombreMembresia.setColumns(10);
		
		lbl_costoMembresia = new JLabel("Asigne un costo a la membres\u00EDa:");
		lbl_costoMembresia.setBounds(47, 434, 285, 16);
		contentPane.add(lbl_costoMembresia);
		
		label_signoP = new JLabel("$");
		label_signoP.setFont(new Font("Tahoma", Font.BOLD, 26));
		label_signoP.setBounds(57, 457, 25, 34);
		contentPane.add(label_signoP);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setColumns(10);
		textFieldPrecio.setBounds(81, 462, 86, 26);
		contentPane.add(textFieldPrecio);
		
		lbl_pregunta5 = new JLabel("Indique los horarios de ingreso permitidos para esta membres\u00EDa");
		lbl_pregunta5.setBounds(20, 118, 342, 16);
		contentPane.add(lbl_pregunta5);
		
		chckbxNo_horario = new JCheckBox("NO");
		chckbxNo_horario.setBounds(30, 147, 128, 23);
		contentPane.add(chckbxNo_horario);
		
		chckbxSi_horario = new JCheckBox("SI. Los horarios pemitidos son:");
		chckbxSi_horario.setBounds(30, 173, 267, 23);
		contentPane.add(chckbxSi_horario);
		
		lblDe = new JLabel("De:");
		lblDe.setBounds(47, 205, 25, 14);
		contentPane.add(lblDe);
		
		lblA = new JLabel("A:");
		lblA.setBounds(47, 230, 25, 14);
		contentPane.add(lblA);
		
		comboBox_de = new JComboBox();
		comboBox_de.setBounds(75, 202, 72, 20);
		contentPane.add(comboBox_de);
		
		comboBox_a = new JComboBox();
		comboBox_a.setBounds(75, 225, 72, 20);
		contentPane.add(comboBox_a);
		
		btnAadirHorario = new JButton("A\u00F1adir");
		btnAadirHorario.setBounds(167, 225, 69, 23);
		contentPane.add(btnAadirHorario);
		
		buttonEliminarH = new JButton("Eliminar");
		buttonEliminarH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonEliminarH.setBounds(247, 225, 69, 23);
		contentPane.add(buttonEliminarH);
		
		list_listaHorarios = new JList();
		list_listaHorarios.setForeground(Color.WHITE);
		list_listaHorarios.setBounds(81, 252, 235, 58);
		contentPane.add(list_listaHorarios);
	}
	public JButton getBtnSiguiente() {
		return btnSiguiente;
	}
	public JButton getBtnAtras() {
		return btn_anterior;
	}
	public JTextField getTfNombreMembresia() {
		return tfNombreMembresia;
	}
	public JLabel getLbl_pregunta_1() {
		return lbl_pregunta_1;
	}
	public JLabel getLbl_pregunta_2() {
		return lbl_pregunta_2;
	}
	public JLabel getLbl_pregunta_4() {
		return lbl_pregunta_4;
	}
	public JLabel getLb_pregunta_3() {
		return lb_pregunta_3;
	}
	public JLabel getLblPasoDe() {
		return lblPasoDe;
	}
	public JComboBox getCBXCantidad() {
		return CBXCantidad;
	}
	public JComboBox getCBXTipoTiempo() {
		return CBXTipoTiempo;
	}
	public JLabel getLblCantidad() {
		return lblCantidad;
	}
	public JCheckBox getChckbxNo() {
		return chckbxNo;
	}
	public JCheckBox getChckbxSi() {
		return chckbxSi;
	}
	public JComboBox getComboBoxVisitas() {
		return comboBoxVisitas;
	}
	public JLabel getLbl_pregunta5() {
		return lbl_pregunta5;
	}
	public JCheckBox getCheckBox_todosDias() {
		return checkBoxTodosDias;
	}
	public JCheckBox getCheckBox_martes() {
		return checkBox_martes;
	}
	public JCheckBox getCheckBox_domingo() {
		return checkBox_domingo;
	}
	public JCheckBox getChckbxSiLosHorarios() {
		return chckbxSi_horario;
	}
	public JCheckBox getCheckBox_sabado() {
		return checkBox_sabado;
	}
	public JCheckBox getCheckBox_lunes() {
		return checkBox_lunes;
	}
	public JCheckBox getChckbxNo_horario() {
		return chckbxNo_horario;
	}
	public JCheckBox getCheckBox_miercoles() {
		return checkBox_miercoles;
	}
	public JCheckBox getCheckBox_viernes() {
		return checkBox_viernes;
	}
	public JCheckBox getCheckBox_4() {
		return checkBox_jueves;
	}
	public JComboBox getComboBoxDe() {
		return comboBox_de;
	}
	public JLabel getLblDe() {
		return lblDe;
	}
	public JLabel getLblA() {
		return lblA;
	}
	public JComboBox getComboBoxA() {
		return comboBox_a;
	}
	public JButton getButtonEliminarH() {
		return buttonEliminarH;
	}
	public JButton getBtnAadirHorario() {
		return btnAadirHorario;
	}
	public JTextField getTFPrecio() {
		return textFieldPrecio;
	}
	public JLabel getLblPeso() {
		return label_signoP;
	}
	public JLabel getLbl_costoMembresia() {
		return lbl_costoMembresia;
	}
}

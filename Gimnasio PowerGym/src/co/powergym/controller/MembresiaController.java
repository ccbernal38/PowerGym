package co.powergym.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import com.sun.glass.events.WindowEvent;
import com.sun.java.swing.plaf.windows.resources.windows;

import co.powergym.dao.DiaMembresiaDao;
import co.powergym.dao.DiaSemanaDao;
import co.powergym.dao.DuracionDao;
import co.powergym.dao.HorarioDao;
import co.powergym.dao.MembresiaDao;
import co.powergym.dao.MembresiaSocioDao;
import co.powergym.model.DiaSemana;
import co.powergym.model.Duracion;
import co.powergym.model.Horario;
import co.powergym.model.Membresia;
import co.powergym.view.membresia.CrearMembresia;
import co.powergym.view.membresia.MembresiaListadoView;
import jssc.SerialPortException;

public class MembresiaController implements ActionListener {

	private CrearMembresia membresia;
	private MembresiaListadoView membresiaListadoView;
	private MembresiaDao membresiaDao;
	private HorarioDao horarioDao;
	private DuracionDao duracionDao;
	private DiaSemanaDao diaSemanaDao;
	private DiaMembresiaDao diaMembresiaDao;
	private Date fechaFinalizacion;
	private int promocional = 0;
	int contPasos = 1;
	int contPasosAtras = 5;

	private List<Membresia> listMembresias;
	private String nombreMembresia;
	private double precioMembresia;
	private int duracionMembresia;
	private Duracion tipoDuracion;
	private boolean limiteMembresiaDiaSi;
	private boolean limiteMembresiaDiaNO;
	private String limite;
	private int visitasDia;
	private List<DiaSemana> diasAux = new ArrayList<>();
	private boolean restriccionHorarioSi;
	private boolean restriccionHorarioNo;
	private String restriccionHorario = "";
	private String horaDeAux;
	private String horaAAux;
	private List<Horario> horarios = new ArrayList<>();
	private String dias = "";
	int IdTipoDuracion;
	
	/**
	 * Método constructor
	 * @param membresia: objeto jframe de crear membresia
	 * @param membresiaListadoView: objeto jframe de listado de membresias
	 */
	public MembresiaController(CrearMembresia membresia, MembresiaListadoView membresiaListadoView) {
		membresiaDao = new MembresiaDao();
		this.duracionDao = new DuracionDao();
		this.horarioDao = new HorarioDao();
		this.diaSemanaDao = new DiaSemanaDao();
		this.diaMembresiaDao = new DiaMembresiaDao();
		if (membresia != null) {
			this.membresia = membresia;
			this.membresia.setVisible(true);
			this.membresia.getBtnSiguiente().addActionListener(this);
			this.membresia.getBtnAtras().addActionListener(this);
			this.membresia.getChckbxSi().addActionListener(this);
			this.membresia.getChckbxNo().addActionListener(this);
			this.membresia.getComboBoxVisitas().setEnabled(false);
			this.membresia.getCheckBox_todosDias().addActionListener(this);
			this.membresia.getCheckBox_lunes().addActionListener(this);
			this.membresia.getCheckBox_martes().addActionListener(this);
			this.membresia.getCheckBox_miercoles().addActionListener(this);
			this.membresia.getCheckBox_jueves().addActionListener(this);
			this.membresia.getCheckBox_viernes().addActionListener(this);
			this.membresia.getCheckBox_sabado().addActionListener(this);
			this.membresia.getCheckBox_domingo().addActionListener(this);
			this.membresia.getChckbxNo_horario().addActionListener(this);
			this.membresia.getChckbxSiLosHorarios().addActionListener(this);
			this.membresia.getBtnAadirHorario().addActionListener(this);
			this.membresia.getBtnFinalizar().addActionListener(this);
			this.membresia.getButtonEliminarH().addActionListener(this);
			this.membresia.getChckbNoProm().addActionListener(this);
			this.membresia.getChckbxSiProm().addActionListener(this);
			this.membresia.getFechaPromo().setEnabled(false);
			llenarRegistroMembresia();
			llenarComboboxNumeroVisitas();
			llenarComboboxHorarios();
			inhabilitarRestriccionHorario();
		}
		if (membresiaListadoView != null) {
			this.membresiaListadoView = membresiaListadoView;
			this.membresiaListadoView.getBtnNuevo().addActionListener(this);
			this.membresiaListadoView.getBtnEditar().addActionListener(this);
			this.membresiaListadoView.getBtnEliminar().addActionListener(this);
			listadoMembresiasLlenarTabla(this.membresiaListadoView.getTableListMembresias());
			this.membresiaListadoView.setVisible(true);
		}

	}
	
	public void registrarMembresia() {
		
		boolean respuesta = membresiaDao.registrarMembresia(nombreMembresia, precioMembresia, duracionMembresia, 
				visitasDia, IdTipoDuracion, promocional, fechaFinalizacion);
		
		if(respuesta == true) {
			
			int id_membresia = membresiaDao.buscarId(nombreMembresia).getId();
			for (int i = 0; i < horarios.size(); i++) {
				horarioDao.registrarHorarioMembresia(horarios.get(i).getHoraInicio(), horarios.get(i).getHoraFin(), id_membresia);				
			}	
			
			int idDiaSemana;
			if(diasAux.size() != 0) {
				for (int i = 0; i < diasAux.size(); i++) {
					idDiaSemana = diaSemanaDao.buscarDiaSemana(diasAux.get(i).getNombre()).getId();
					diaMembresiaDao.regitrarDiaMembresia(idDiaSemana, id_membresia);
				}
			}
			
		}
	}
	
	/**
	 * Método que deshabilita los campos y botones de la vista crear membresía en 
	 * el modulo de restrición de horario.
	 */
	private void inhabilitarRestriccionHorario() {
		membresia.getComboBoxA().setEnabled(false);
		membresia.getComboBoxDe().setEnabled(false);
		membresia.getBtnAadirHorario().setEnabled(false);
		membresia.getList_listaHorarios().setEnabled(false);
		membresia.getButtonEliminarH().setEnabled(false);
		membresia.getLblA().setEnabled(false);
		membresia.getLblDe().setEnabled(false);
	}

	private void llenarRegistroMembresia() {

		List<Duracion> list = duracionDao.listarDuracion();
		for (int i = 0; i < list.size(); i++) {
			this.membresia.getCBXTipoTiempo().addItem(list.get(i));
		}
	}

	private void llenarComboboxNumeroVisitas() {

		for (int i = 1; i <= 20; i++) {
			this.membresia.getComboBoxVisitas().addItem(i);
		}
	}

	private void llenarComboboxHorarios() {

		for (int i = 1; 1 <= 24; i++) {
			if (i <= 12) {
				this.membresia.getComboBoxDe().addItem(i + ":00 AM");
				this.membresia.getComboBoxA().addItem(i + ":00 AM");
			} else if (i > 12 && i <= 24) {
				this.membresia.getComboBoxDe().addItem(i + ":00 PM");
				this.membresia.getComboBoxA().addItem(i + ":00 PM");
			} else
				break;
		}
	}

	private void listadoMembresiasLlenarTabla(JTable tableListMembresias) {

		DefaultTableModel defaultTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Nombre de la membres\u00EDa", "Precio", "Duracion" });

		Object[] columna = new Object[4];
		listMembresias = membresiaDao.listaMembresia();
		int numeroRegistros = listMembresias.size();

		for (int i = 0; i < numeroRegistros; i++) {
			columna[0] = listMembresias.get(i).getId();
			columna[1] = listMembresias.get(i).getNombre();
			columna[2] = listMembresias.get(i).getValor();
			columna[3] = listMembresias.get(i).getDuracion();
			defaultTableModel.addRow(columna);
		}
		tableListMembresias.setModel(defaultTableModel);

		tableListMembresias.repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (membresia != null && e.getSource() == membresia.getBtnSiguiente()) {
			if (contPasos == 1) {
				contPasos++;
				membresia.getLblPasoDe().setText("Paso " + contPasos + " de 6");
				membresia.getLbl_pregunta_1().setVisible(false);
				membresia.getTfNombreMembresia().setVisible(false);
				membresia.getLbl_costoMembresia().setVisible(false);
				membresia.getLblPeso().setVisible(false);
				membresia.getTFPrecio().setVisible(false);

				membresia.getLbl_pregunta_2().setBounds(30, 118, 285, 16);
				membresia.getBtnAtras().setBounds(28, 350, 110, 30);
				membresia.getLblCantidad().setBounds(30, 153, 61, 16);
				membresia.getTextFieldCantidad().setBounds(97, 149, 61, 27);
				membresia.getCBXTipoTiempo().setBounds(161, 149, 156, 27);
				membresia.getLabelMPromocional().setBounds(30, 192, 285, 16);
				membresia.getChckbNoProm().setBounds(30, 223, 97, 23);
				membresia.getChckbxSiProm().setBounds(30, 255, 224, 23);
				membresia.getFechaPromo().setBounds(260, 255, 100, 20);
				
				membresia.getLbl_pregunta_2().setVisible(true);
				membresia.getTextFieldCantidad().setVisible(true);
				membresia.getCBXTipoTiempo().setVisible(true);
				membresia.getLblCantidad().setVisible(true);
				membresia.getLabelMPromocional().setVisible(true);
				membresia.getChckbNoProm().setVisible(true);
				membresia.getChckbxSiProm().setVisible(true);
				membresia.getFechaPromo().setVisible(true);
				
				contPasosAtras++;

			} else if (contPasos == 2) {

				contPasos++;
				membresia.getLblPasoDe().setText("Paso " + contPasos + " de 6");

				membresia.getLbl_pregunta_2().setVisible(false);
				membresia.getTextFieldCantidad().setVisible(false);
				membresia.getCBXTipoTiempo().setVisible(false);
				membresia.getLblCantidad().setVisible(false);
				membresia.getLabel_vineta_2().setVisible(false);
				membresia.getLabelMPromocional().setVisible(false);
				membresia.getChckbNoProm().setVisible(false);
				membresia.getChckbxSiProm().setVisible(false);
				membresia.getFechaPromo().setVisible(false);
				membresia.getLb_pregunta_3().setBounds(30, 118, 342, 16);
				membresia.getChckbxNo().setBounds(30, 152, 128, 23);
				membresia.getChckbxSi().setBounds(30, 187, 320, 23);
				membresia.getComboBoxVisitas().setBounds(350, 187, 61, 27);

				membresia.getLb_pregunta_3().setVisible(true);
				membresia.getComboBoxVisitas().setVisible(true);
				membresia.getChckbxNo().setVisible(true);
				membresia.getChckbxSi().setVisible(true);
				contPasosAtras++;

			} else if (contPasos == 3) {

				contPasos++;
				membresia.getLblPasoDe().setText("Paso " + contPasos + " de 6");

				membresia.getLb_pregunta_3().setVisible(false);
				membresia.getLbl_pregunta_4().setBounds(30, 118, 342, 16);
				membresia.getComboBoxVisitas().setVisible(false);
				membresia.getChckbxNo().setVisible(false);
				membresia.getChckbxSi().setVisible(false);

				membresia.getCheckBox_lunes().setBounds(30, 147, 66, 23);
				membresia.getCheckBox_martes().setBounds(98, 147, 70, 23);
				membresia.getCheckBox_miercoles().setBounds(166, 147, 82, 23);
				membresia.getCheckBox_jueves().setBounds(245, 147, 73, 23);
				membresia.getCheckBox_viernes().setBounds(30, 175, 70, 23);
				membresia.getCheckBox_sabado().setBounds(98, 175, 70, 23);
				membresia.getCheckBox_domingo().setBounds(166, 175, 78, 23);
				membresia.getCheckBox_todosDias().setBounds(245, 175, 110, 23);

				membresia.getLbl_pregunta_4().setVisible(true);
				membresia.getCheckBox_lunes().setVisible(true);
				membresia.getCheckBox_martes().setVisible(true);
				membresia.getCheckBox_miercoles().setVisible(true);
				membresia.getCheckBox_jueves().setVisible(true);
				membresia.getCheckBox_viernes().setVisible(true);
				membresia.getCheckBox_sabado().setVisible(true);
				membresia.getCheckBox_domingo().setVisible(true);
				membresia.getCheckBox_todosDias().setVisible(true);
				contPasosAtras++;

			} else if (contPasos == 4) {

				contPasos++;
				membresia.getLblPasoDe().setText("Paso " + contPasos + " de 6");
				membresia.getLbl_pregunta_4().setVisible(false);
				membresia.getLbl_pregunta5().setBounds(30, 118, 370, 16);
				membresia.getCheckBox_lunes().setVisible(false);
				membresia.getCheckBox_martes().setVisible(false);
				membresia.getCheckBox_miercoles().setVisible(false);
				membresia.getCheckBox_jueves().setVisible(false);
				membresia.getCheckBox_viernes().setVisible(false);
				membresia.getCheckBox_sabado().setVisible(false);
				membresia.getCheckBox_domingo().setVisible(false);
				membresia.getCheckBox_todosDias().setVisible(false);

				membresia.getChckbxNo_horario().setBounds(30, 147, 128, 23);
				membresia.getChckbxSiLosHorarios().setBounds(30, 173, 267, 23);
				membresia.getLblDe().setBounds(40, 215, 25, 14);
				membresia.getComboBoxDe().setBounds(65, 212, 77, 20);
				membresia.getLblA().setBounds(153, 215, 25, 14);
				membresia.getComboBoxA().setBounds(170, 212, 84, 20);
				membresia.getBtnAadirHorario().setBounds(260, 212, 72, 20);
				membresia.getButtonEliminarH().setBounds(253, 310, 80, 20);
				membresia.getList_listaHorarios().setBounds(65, 238, 267, 68);

				membresia.getChckbxNo_horario().setVisible(true);
				membresia.getChckbxSiLosHorarios().setVisible(true);
				membresia.getLblDe().setVisible(true);
				membresia.getComboBoxDe().setVisible(true);
				membresia.getLblA().setVisible(true);
				membresia.getComboBoxA().setVisible(true);
				membresia.getBtnAadirHorario().setVisible(true);
				membresia.getButtonEliminarH().setVisible(true);
				membresia.getList_listaHorarios().setVisible(true);
				membresia.getLbl_pregunta5().setVisible(true);
				contPasosAtras++;

			} else if (contPasos == 5) {

				contPasos++;
				membresia.getLblPasoDe().setText("Paso " + contPasos + " de 6");
				membresia.getLbl_pregunta5().setVisible(false);
				membresia.getChckbxNo_horario().setVisible(false);
				membresia.getChckbxSiLosHorarios().setVisible(false);
				membresia.getLblDe().setVisible(false);
				membresia.getComboBoxDe().setVisible(false);
				membresia.getLblA().setVisible(false);
				membresia.getComboBoxA().setVisible(false);
				membresia.getBtnAadirHorario().setVisible(false);
				membresia.getButtonEliminarH().setVisible(false);
				membresia.getList_listaHorarios().setVisible(false);
				membresia.getLbl_pregunta5().setVisible(false);

				membresia.getLblResumenMembresia().setBounds(30, 118, 285, 16);
				membresia.getScrollPaneResumen().setBounds(28, 160, 418, 126);

				membresia.getLblResumenMembresia().setVisible(true);
				membresia.getScrollPaneResumen().setVisible(true);
				membresia.getTableResumenMembresia().setVisible(true);

				membresia.getBtnSiguiente().setVisible(false);
				membresia.getBtnFinalizar().setVisible(true);

				membresia.getBtnFinalizar().setBounds(338, 350, 110, 30);
				llenarTabla();
			}
		}
		if (membresia != null && e.getSource() == membresia.getBtnAtras()) {

			if (contPasos == 6) {

				contPasos--;
				membresia.getLblPasoDe().setText("Paso " + contPasos + " de 6");
				membresia.getLblResumenMembresia().setVisible(false);
				membresia.getScrollPaneResumen().setVisible(false);

				membresia.getBtnSiguiente().setVisible(true);
				membresia.getBtnFinalizar().setVisible(false);

				membresia.getChckbxNo_horario().setVisible(true);
				membresia.getChckbxSiLosHorarios().setVisible(true);
				membresia.getLblDe().setVisible(true);
				membresia.getComboBoxDe().setVisible(true);
				membresia.getLblA().setVisible(true);
				membresia.getComboBoxA().setVisible(true);
				membresia.getBtnAadirHorario().setVisible(true);
				membresia.getButtonEliminarH().setVisible(true);
				membresia.getList_listaHorarios().setVisible(true);
				membresia.getLbl_pregunta5().setVisible(true);

			} else if (contPasos == 5) {

				contPasos--;
				membresia.getLblPasoDe().setText("Paso " + contPasos + " de 6");
				membresia.getChckbxNo_horario().setVisible(false);
				membresia.getChckbxSiLosHorarios().setVisible(false);
				membresia.getLblDe().setVisible(false);
				membresia.getComboBoxDe().setVisible(false);
				membresia.getLblA().setVisible(false);
				membresia.getComboBoxA().setVisible(false);
				membresia.getBtnAadirHorario().setVisible(false);
				membresia.getButtonEliminarH().setVisible(false);
				membresia.getList_listaHorarios().setVisible(false);
				membresia.getLbl_pregunta5().setVisible(false);

				membresia.getLbl_pregunta_4().setVisible(true);
				membresia.getCheckBox_lunes().setVisible(true);
				membresia.getCheckBox_martes().setVisible(true);
				membresia.getCheckBox_miercoles().setVisible(true);
				membresia.getCheckBox_jueves().setVisible(true);
				membresia.getCheckBox_viernes().setVisible(true);
				membresia.getCheckBox_sabado().setVisible(true);
				membresia.getCheckBox_domingo().setVisible(true);
				membresia.getCheckBox_todosDias().setVisible(true);

			} else if (contPasos == 4) {

				contPasos--;
				membresia.getLblPasoDe().setText("Paso " + contPasos + " de 6");
				membresia.getLbl_pregunta_4().setVisible(false);
				membresia.getCheckBox_lunes().setVisible(false);
				;
				membresia.getCheckBox_martes().setVisible(false);
				membresia.getCheckBox_miercoles().setVisible(false);
				membresia.getCheckBox_jueves().setVisible(false);
				membresia.getCheckBox_viernes().setVisible(false);
				membresia.getCheckBox_sabado().setVisible(false);
				membresia.getCheckBox_domingo().setVisible(false);
				membresia.getCheckBox_todosDias().setVisible(false);

				membresia.getLb_pregunta_3().setVisible(true);
				membresia.getComboBoxVisitas().setVisible(true);
				membresia.getChckbxNo().setVisible(true);
				membresia.getChckbxSi().setVisible(true);

			} else if (contPasos == 3) {

				contPasos--;
				membresia.getLblPasoDe().setText("Paso " + contPasos + " de 6");
				membresia.getLb_pregunta_3().setVisible(false);
				membresia.getComboBoxVisitas().setVisible(false);
				membresia.getChckbxNo().setVisible(false);
				membresia.getChckbxSi().setVisible(false);

				membresia.getLbl_pregunta_2().setVisible(true);
				membresia.getTextFieldCantidad().setVisible(true);
				membresia.getCBXTipoTiempo().setVisible(true);
				membresia.getLblCantidad().setVisible(true);
				membresia.getLabel_vineta_2().setVisible(true);
				membresia.getLabelMPromocional().setVisible(true);
				membresia.getChckbNoProm().setVisible(true);
				membresia.getChckbxSiProm().setVisible(true);
				membresia.getFechaPromo().setVisible(true);
			} else if (contPasos == 2) {

				contPasos--;
				membresia.getLblPasoDe().setText("Paso " + contPasos + " de 6");
				membresia.getLbl_pregunta_2().setVisible(false);
				membresia.getTextFieldCantidad().setVisible(false);
				membresia.getCBXTipoTiempo().setVisible(false);
				membresia.getLblCantidad().setVisible(false);
				membresia.getLabelMPromocional().setVisible(false);
				membresia.getChckbNoProm().setVisible(false);
				membresia.getChckbxSiProm().setVisible(false);
				membresia.getFechaPromo().setVisible(false);

				membresia.getLbl_pregunta_1().setVisible(true);
				membresia.getTfNombreMembresia().setVisible(true);
				membresia.getLbl_costoMembresia().setVisible(true);
				membresia.getLblPeso().setVisible(true);
				membresia.getTFPrecio().setVisible(true);
				membresia.getLabel_vineta_2().setVisible(true);
			}

		}
		if (e.getSource() == membresia.getBtnFinalizar()) {
			int joption = JOptionPane.showConfirmDialog(null, "¿Desea finalizar la creación de esta membresía?");
			fechaFinalizacion = membresia.getFechaPromo().getDate();
			if (joption == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null, "La membresía ha sido creada con éxito");
				registrarMembresia();
				membresia.setVisible(false);
				membresia.dispose();
			}
		}
		if (e.getSource() == membresia.getChckbxNo()) {
			membresia.getComboBoxVisitas().setEnabled(false);
		}
		if (e.getSource() == membresia.getChckbxSi()) {
			membresia.getComboBoxVisitas().setEnabled(true);
		}
		if(e.getSource() == membresia.getChckbNoProm()) {
			membresia.getFechaPromo().setEnabled(false);
			promocional = 0;
		}
		if(e.getSource() == membresia.getChckbxSiProm()) {
			membresia.getFechaPromo().setEnabled(true);
			promocional = 1;
		}
		if (e.getSource() == membresia.getCheckBox_todosDias()) {

			if (membresia.getCheckBox_todosDias().isSelected() == true) {
				membresia.getCheckBox_lunes().setSelected(true);
				DiaSemana lunes = new DiaSemana(1, "lunes");
				membresia.getCheckBox_martes().setSelected(true);
				DiaSemana martes = new DiaSemana(2, "Martes");
				membresia.getCheckBox_miercoles().setSelected(true);
				DiaSemana miercoles = new DiaSemana(3, "Miercoles");
				membresia.getCheckBox_jueves().setSelected(true);
				DiaSemana jueves = new DiaSemana(4, "Jueves");
				membresia.getCheckBox_viernes().setSelected(true);
				DiaSemana viernes = new DiaSemana(5, "Viernes");
				membresia.getCheckBox_sabado().setSelected(true);
				DiaSemana Sabado = new DiaSemana(6, "Sabado");
				membresia.getCheckBox_domingo().setSelected(true);
				DiaSemana domingo = new DiaSemana(7, "Domingo");

				diasAux.add(lunes);
				diasAux.add(martes);
				diasAux.add(miercoles);
				diasAux.add(jueves);
				diasAux.add(viernes);
				diasAux.add(Sabado);
				diasAux.add(domingo);

			} else if (membresia.getCheckBox_todosDias().isSelected() == false) {

				membresia.getCheckBox_lunes().setSelected(false);
				membresia.getCheckBox_martes().setSelected(false);
				membresia.getCheckBox_miercoles().setSelected(false);
				membresia.getCheckBox_jueves().setSelected(false);
				membresia.getCheckBox_viernes().setSelected(false);
				membresia.getCheckBox_sabado().setSelected(false);
				membresia.getCheckBox_domingo().setSelected(false);
				diasAux.clear();
			}
		}
		if (membresia.getCheckBox_lunes() == e.getSource()) {

			if (membresia.getCheckBox_lunes().isSelected() == true) {
				DiaSemana lunes = new DiaSemana(1, "Lunes");
				diasAux.add(lunes);
			} else if (membresia.getCheckBox_lunes().isSelected() == false) {
				eliminarDiasAux(1);
			}
		}
		if (membresia.getCheckBox_martes() == e.getSource()) {
			if (membresia.getCheckBox_martes().isSelected() == true) {
				DiaSemana martes = new DiaSemana(2, "Martes");
				diasAux.add(martes);
			} else if (membresia.getCheckBox_martes().isSelected() == false) {
				eliminarDiasAux(2);
			}
		}
		if (membresia.getCheckBox_miercoles() == e.getSource()) {
			if (membresia.getCheckBox_miercoles().isSelected() == true) {
				DiaSemana miercoles = new DiaSemana(3, "Miercoles");
				diasAux.add(miercoles);
			} else if (membresia.getCheckBox_miercoles().isSelected() == false) {
				eliminarDiasAux(3);
			}
		}
		if (membresia.getCheckBox_jueves() == e.getSource()) {
			if (membresia.getCheckBox_jueves().isSelected() == true) {
				DiaSemana jueves = new DiaSemana(4, "Jueves");
				diasAux.add(jueves);
			} else if (membresia.getCheckBox_jueves().isSelected() == false) {
				eliminarDiasAux(4);
			}
		}
		if (membresia.getCheckBox_viernes() == e.getSource()) {
			if (membresia.getCheckBox_viernes().isSelected() == true) {
				DiaSemana viernes = new DiaSemana(5, "Viernes");
				diasAux.add(viernes);
			} else if (membresia.getCheckBox_viernes().isSelected() == false) {
				eliminarDiasAux(5);
			}
		}
		if (membresia.getCheckBox_sabado() == e.getSource()) {
			if (membresia.getCheckBox_sabado().isSelected() == true) {
				DiaSemana sabado = new DiaSemana(6, "Sabado");
				diasAux.add(sabado);
			} else if (membresia.getCheckBox_sabado().isSelected() == false) {
				eliminarDiasAux(6);
			}
		}
		if (membresia.getCheckBox_domingo() == e.getSource()) {
			if (membresia.getCheckBox_domingo().isSelected() == true) {
				DiaSemana domingo = new DiaSemana(7, "Domingo");
				diasAux.add(domingo);
			} else if (membresia.getCheckBox_domingo().isSelected() == false) {
				eliminarDiasAux(7);
			}
		}
		if (membresia.getChckbxNo_horario() == e.getSource()) {

			membresia.getComboBoxA().setEnabled(false);
			membresia.getComboBoxDe().setEnabled(false);
			membresia.getBtnAadirHorario().setEnabled(false);
			membresia.getList_listaHorarios().setEnabled(false);
			membresia.getButtonEliminarH().setEnabled(false);
			membresia.getLblA().setEnabled(false);
			membresia.getLblDe().setEnabled(false);
		}
		if (membresia.getChckbxSiLosHorarios() == e.getSource()) {

			membresia.getComboBoxA().setEnabled(true);
			membresia.getComboBoxDe().setEnabled(true);
			membresia.getBtnAadirHorario().setEnabled(true);
			membresia.getList_listaHorarios().setEnabled(true);
			membresia.getButtonEliminarH().setEnabled(true);
			membresia.getLblA().setEnabled(true);
			membresia.getLblDe().setEnabled(true);
		}
		if (membresiaListadoView != null && e.getSource() == membresiaListadoView.getBtnNuevo()) {
			CrearMembresia crearMembresia = new CrearMembresia();
			crearMembresia.setVisible(true);
			crearMembresia.getBtnSiguiente().addActionListener(this);
			crearMembresia.getBtnAtras().addActionListener(this);
		}
		if (membresia.getBtnAadirHorario() == e.getSource()) {

			JList lista = membresia.getList_listaHorarios();
			DefaultListModel listModel = new DefaultListModel();

			for (int i = 0; i < lista.getModel().getSize(); i++) {
				listModel.addElement(lista.getModel().getElementAt(i));
			}
			horaDeAux = (String) membresia.getComboBoxDe().getSelectedItem();
			horaAAux = (String) membresia.getComboBoxA().getSelectedItem();
			
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
				Date dateDe = dateFormat.parse(horaDeAux);
				Date dateA = dateFormat.parse(horaAAux); 
				horarios.add(new Horario(dateDe, dateA));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			listModel.addElement("De " + horaDeAux + " a " + horaAAux);
			lista.setModel(listModel);
			lista.updateUI();

		}
		if (membresia.getButtonEliminarH() == e.getSource()) {

			JList lista = membresia.getList_listaHorarios();
			int index = lista.getSelectedIndex();
			DefaultListModel modelo = (DefaultListModel) lista.getModel();
			modelo.remove(index);
		}
		if (membresiaListadoView != null && e.getSource() == membresiaListadoView.getBtnEditar()) {

		}
		if (membresiaListadoView != null && e.getSource() == membresiaListadoView.getBtnEliminar()) {
			int select = membresiaListadoView.getTableListMembresias().getSelectedRow();
			if (select != -1) {
				if (listMembresias != null) {
					int id = listMembresias.get(select).getId();
					if (JOptionPane.showConfirmDialog(membresiaListadoView, "¿Desea eliminar esta membresia?",
							"Eliminar membresia", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						boolean remove = membresiaDao.eliminarMembresia(id);
						if (remove == true) {

							JOptionPane.showMessageDialog(membresiaListadoView,
									"La membresia se ha eliminado correctamente.");
							listadoMembresiasLlenarTabla(membresiaListadoView.getTableListMembresias());
						}
					}
				}
			} else {
				JOptionPane.showMessageDialog(membresiaListadoView,
						"Primero debe Seleccionar una membresia de la tabla.", "Atención", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void eliminarDiasAux(int dia) {
		if (diasAux != null) {
			for (int i = 0; i < diasAux.size(); i++) {
				if (diasAux.get(i).getId() == dia) {
					diasAux.remove(i);
				}
			}
		}

	}

	public void llenarTabla() {

		nombreMembresia = membresia.getTfNombreMembresia().getText();
		if(!membresia.getTFPrecio().getText().equals("")) {
			precioMembresia = Double.parseDouble(membresia.getTFPrecio().getText());			
		}
		if (!membresia.getTextFieldCantidad().getText().equals("")) {
			duracionMembresia = Integer.parseInt(membresia.getTextFieldCantidad().getText());
		}
		if (membresia.getCBXTipoTiempo().getSelectedItem() instanceof Duracion) {

			tipoDuracion = (Duracion) membresia.getCBXTipoTiempo().getSelectedItem();
		}
		String tipoDu = "";
		if(tipoDuracion.getNombre() != null) {
			tipoDu = tipoDuracion.getNombre();
			IdTipoDuracion = tipoDuracion.getId();
		}
		limiteMembresiaDiaNO = membresia.getChckbxNo().isSelected();
		limiteMembresiaDiaSi = membresia.getChckbxSi().isSelected();

		if (limiteMembresiaDiaNO == true) {
			limite = "No hay límite";
		} else if (limiteMembresiaDiaSi == true) {

			visitasDia = (int) membresia.getComboBoxVisitas().getSelectedItem();
			limite = visitasDia + " veces por día";
		}
		for (int i = 0; i < diasAux.size(); i++) {

			if (i == diasAux.size() - 1) {
				dias += diasAux.get(i).getNombre() + ". ";
			} else {
				dias += diasAux.get(i).getNombre() + ", ";
			}
		}
		restriccionHorarioSi = membresia.getChckbxSiLosHorarios().isSelected();
		restriccionHorarioNo = membresia.getChckbxNo_horario().isSelected();

		if (restriccionHorarioNo == true) {
			restriccionHorario = "No hay restricción.";
		} else if (restriccionHorarioSi == true) {
			restriccionHorario = "";
			for (int i = 0; i < horarios.size(); i++) {
				if (i == horarios.size() - 1) {
					restriccionHorario += horarios.get(i).toString()+".";
				} else {
					restriccionHorario += horarios.get(i).toString()+", ";
				}
			}
		}

		DefaultTableModel defaultTableModel = new DefaultTableModel(
				new Object[][] { { " Nombre de la membres\u00EDa:", nombreMembresia },
						{ " Costo de la membres\u00EDa:", precioMembresia },
						{ " Duraci\u00F3n de la membres\u00EDa:", duracionMembresia + " " + tipoDu },
						{ " N\u00FAmero de visitas por d\u00EDa:", limite }, { " D\u00EDas limite de ingreso:", dias },
						{ " Horarios de ingreso por d\u00EDa:", restriccionHorario }, },
				new String[] { "Información", "Detalle" });
		membresia.getTableResumenMembresia().setModel(defaultTableModel);
		membresia.getTableResumenMembresia().repaint();
	}

}

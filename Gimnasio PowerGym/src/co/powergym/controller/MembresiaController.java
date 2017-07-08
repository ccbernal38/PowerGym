package co.powergym.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.powergym.controller.SocioController.HeaderRenderer;
import co.powergym.dao.MembresiaDao;
import co.powergym.model.Membresia;
import co.powergym.model.Socio;
import co.powergym.view.CrearMembresia;
import co.powergym.view.membresia.MembresiaListadoView;

public class MembresiaController implements ActionListener {

	private CrearMembresia membresia;
	private MembresiaListadoView membresiaListadoView;
	private MembresiaDao membresiaDao;
	int contPasos = 1;
	private List<Membresia> listMembresias;

	public MembresiaController(MembresiaDao membresiaDao, CrearMembresia membresia,
			MembresiaListadoView membresiaListadoView) {
		this.membresiaDao = membresiaDao;

		if (membresia != null) {
			this.membresia = membresia;
			this.membresia.setVisible(true);
			this.membresia.getBtnSiguiente().addActionListener(this);
			this.membresia.getBtnAtras().addActionListener(this);
			
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
				membresia.getLblPasoDe().setText("Paso " + contPasos + " de 5");

				membresia.getLbl_pregunta_1().setVisible(false);
				membresia.getTfNombreMembresia().setVisible(false);
				membresia.getLbl_costoMembresia().setVisible(false);
				membresia.getLblPeso().setVisible(false);
				membresia.getTFPrecio().setVisible(false);
				membresia.getLabel_vineta_2().setVisible(false);
				
				membresia.getLbl_pregunta_2().setBounds(30, 118, 285, 16);
				membresia.getBtnAtras().setBounds(118, 317, 110, 30);
				membresia.getLblCantidad().setBounds(21, 148, 61, 16);
				membresia.getCBXCantidad().setBounds(92, 144, 61, 27);
				membresia.getCBXTipoTiempo().setBounds(156, 144, 156, 27);
			} else if (contPasos == 2) {

				contPasos++;
				membresia.getLblPasoDe().setText("Paso " + contPasos + " de 5");

				membresia.getLbl_pregunta_2().setVisible(false);
				membresia.getCBXCantidad().setVisible(false);
				membresia.getCBXTipoTiempo().setVisible(false);
				membresia.getLblCantidad().setVisible(false);
				membresia.getLb_pregunta_3().setBounds(30, 118, 342, 16);
				membresia.getChckbxNo().setBounds(30, 152, 128, 23);
				membresia.getChckbxSi().setBounds(30, 187, 320, 23);
				membresia.getComboBoxVisitas().setBounds(350, 187, 61, 27);

			} else if (contPasos == 3) {

				contPasos++;
				membresia.getLblPasoDe().setText("Paso " + contPasos + " de 5");

				membresia.getLb_pregunta_3().setVisible(false);
				membresia.getLbl_pregunta_4().setBounds(30, 118, 342, 16);
				membresia.getComboBoxVisitas().setVisible(false);
				membresia.getChckbxNo().setVisible(false);
				membresia.getChckbxSi().setVisible(false);
				
				membresia.getCheckBox_lunes().setBounds(30,147,66,23);
				membresia.getCheckBox_martes().setBounds(105,147,66,23);
				membresia.getCheckBox_miercoles().setBounds(175,147,74,23);
				membresia.getCheckBox_jueves().setBounds(245,147,73,23);
				membresia.getCheckBox_viernes().setBounds(30,175,66,23);
				membresia.getCheckBox_sabado().setBounds(105, 175,70,23);
				membresia.getCheckBox_domingo().setBounds(175,175,74,23);
				membresia.getCheckBox_todosDias().setBounds(245,175,98,23);
			}else
			if(contPasos == 4){
				
				contPasos++;
				membresia.getLblPasoDe().setText("Paso " + contPasos + " de 5");
				membresia.getLbl_pregunta_4().setVisible(false);
				membresia.getLbl_pregunta5().setBounds(30, 118, 360, 16);
				membresia.getCheckBox_lunes().setVisible(false);;
				membresia.getCheckBox_martes().setVisible(false);;
				membresia.getCheckBox_miercoles().setVisible(false);;
				membresia.getCheckBox_jueves().setVisible(false);
				membresia.getCheckBox_viernes().setVisible(false);
				membresia.getCheckBox_sabado().setVisible(false);
				membresia.getCheckBox_domingo().setVisible(false);
				membresia.getCheckBox_todosDias().setVisible(false);
				
				membresia.getChckbxNo_horario().setBounds(30,147,128,23);
				membresia.getChckbxSiLosHorarios().setBounds(30,173,267,23);
				membresia.getLblDe().setBounds(47,205,25,14);
				membresia.getComboBoxDe().setBounds(75,202,72,20);
				membresia.getLblA().setBounds(47,230,25,14);
				membresia.getComboBoxA().setBounds(75,225,72,20);
				membresia.getBtnAadirHorario().setBounds(167,225,69,23);
				membresia.getButtonEliminarH().setBounds(247,225,69,23);
				membresia.getList_listaHorarios().setBounds(81,252,235,58);
			}
		}
		if (membresia != null && e.getSource() == membresia.getBtnAtras()) {

		}
		if (membresiaListadoView != null && e.getSource() == membresiaListadoView.getBtnNuevo()) {
			CrearMembresia crearMembresia = new CrearMembresia();
			crearMembresia.setVisible(true);
			crearMembresia.getBtnSiguiente().addActionListener(this);
			crearMembresia.getBtnAtras().addActionListener(this);
		}
		if (membresiaListadoView != null && e.getSource() == membresiaListadoView.getBtnEditar()) {

		}
		if (membresiaListadoView != null && e.getSource() == membresiaListadoView.getBtnEliminar()) {
			int select = membresiaListadoView.getTableListMembresias().getSelectedRow();
			if (select != -1) {
				if (listMembresias != null) {
					int id = listMembresias.get(select).getId();
					boolean remove = membresiaDao.eliminarMembresia(id);
					if (remove == true) {

						JOptionPane.showMessageDialog(membresiaListadoView,
								"La membresia se ha eliminado correctamente.");
						listadoMembresiasLlenarTabla(membresiaListadoView.getTableListMembresias());
					}
				}
			} else {
				JOptionPane.showMessageDialog(membresiaListadoView,
						"Primero debe Seleccionar una membresia de la tabla.", "Atención", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}

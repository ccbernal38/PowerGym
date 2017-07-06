package co.powergym.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
			listadoMembresiasLlenarTabla(this.membresiaListadoView.getTableListMembresias());
			this.membresiaListadoView.setVisible(true);
		}

	}

	private void listadoMembresiasLlenarTabla(JTable tableListMembresias) {
		// TODO Auto-generated method stub
		DefaultTableModel defaultTableModel = (DefaultTableModel) tableListMembresias.getModel();

		Object[] columna = new Object[3];
		List<Membresia> listMembresias = membresiaDao.listaMembresia();
		int numeroRegistros = listMembresias.size();

		for (int i = 0; i < numeroRegistros; i++) {
			columna[0] = listMembresias.get(i).getNombre();
			columna[1] = listMembresias.get(i).getValor();
			columna[2] = listMembresias.get(i).getDuracion();
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
				membresia.getLblPasoDe().setText("Paso " + contPasos + " de 4");

				membresia.getLbl_pregunta_1().setVisible(false);
				membresia.getTfNombreMembresia().setVisible(false);

				membresia.getLbl_pregunta_2().setBounds(20, 118, 285, 16);
				membresia.getBtnAtras().setBounds(22, 280, 117, 37);
				membresia.getLblCantidad().setBounds(21, 146, 61, 16);
				membresia.getCBXCantidad().setBounds(92, 142, 61, 27);
				membresia.getCBXTipoTiempo().setBounds(156, 142, 156, 27);
			} else if (contPasos == 2) {

				contPasos++;
				membresia.getLblPasoDe().setText("Paso " + contPasos + " de 4");
				membresia.getLbl_pregunta_2().setVisible(false);
				membresia.getCBXCantidad().setVisible(false);
				membresia.getCBXTipoTiempo().setVisible(false);
				membresia.getLblCantidad().setVisible(false);
				membresia.getLb_pregunta_3().setBounds(20, 118, 342, 16);
				membresia.getChckbxNo().setBounds(30, 152, 128, 23);
				membresia.getChckbxSi().setBounds(30, 187, 352, 23);
				membresia.getComboBoxVisitas().setBounds(381, 187, 61, 27);

			} else if (contPasos == 3) {

				contPasos++;
				membresia.getLblPasoDe().setText("Paso " + contPasos + " de 4");
				membresia.getLb_pregunta_3().setVisible(false);
				membresia.getLbl_pregunta_4().setBounds(20, 118, 342, 16);
			}
		}
		if (membresia != null && e.getSource() == membresia.getBtnAtras()) {

		}
		if(membresiaListadoView != null){
			
		}
	}

}

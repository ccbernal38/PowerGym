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

				membresia.getLbl_pregunta_2().setBounds(20, 120, 285, 16);
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
				membresia.getLb_pregunta_3().setBounds(20, 118, 342, 16);
				membresia.getChckbxNo().setBounds(30, 152, 128, 23);
				membresia.getChckbxSi().setBounds(30, 187, 352, 23);
				membresia.getComboBoxVisitas().setBounds(381, 187, 61, 27);

			} else if (contPasos == 3) {

				contPasos++;
				membresia.getLblPasoDe().setText("Paso " + contPasos + " de 5");

				membresia.getLb_pregunta_3().setVisible(false);
				membresia.getLbl_pregunta_4().setBounds(20, 118, 342, 16);
				membresia.getComboBoxVisitas().setVisible(false);
			} else if (contPasos == 4) {

				contPasos++;
				membresia.getLblPasoDe().setText("Paso " + contPasos + " de 5");
				membresia.getLbl_pregunta_4().setVisible(false);
				membresia.getLbl_pregunta5().setBounds(20, 118, 342, 16);
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

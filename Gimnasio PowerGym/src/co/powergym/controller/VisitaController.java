package co.powergym.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import co.powergym.dao.AsistenciaDao;
import co.powergym.dao.CajaDao;
import co.powergym.dao.SocioDao;
import co.powergym.dao.VisitaDao;
import co.powergym.model.Asistencia;
import co.powergym.model.Socio;
import co.powergym.model.Visita;
import co.powergym.utils.Constantes;
import co.powergym.utils.Preferencias;
import co.powergym.view.membresia.MembresiaListaDiaVisitasView;
import co.powergym.view.membresia.MembresiaListaVisitasView;
import co.powergym.view.membresia.MembresiaRegistroVisitaView;

public class VisitaController implements ActionListener {

	private VisitaDao visitaDao;
	private SocioDao socioDao;
	private MembresiaRegistroVisitaView membresiaRegistroVisitaView;
	private MembresiaListaVisitasView membresiaListaVisitasView;
	private MembresiaListaDiaVisitasView membresiaDiaVisitaView;
	private Socio socioTemp;
	private CajaDao cajaDao;

	/**
	 * @param membresiaRegistroVisitaView
	 */
	public VisitaController(MembresiaRegistroVisitaView membresiaRegistroVisitaView,
			MembresiaListaVisitasView membresiaListaVisita, MembresiaListaDiaVisitasView membresiaDiaVisitaView) {
		visitaDao = new VisitaDao();
		socioDao = new SocioDao();
		cajaDao = new CajaDao();
		this.membresiaRegistroVisitaView = membresiaRegistroVisitaView;
		this.membresiaListaVisitasView = membresiaListaVisita;
		this.membresiaDiaVisitaView = membresiaDiaVisitaView;
		if (this.membresiaRegistroVisitaView != null) {
			this.membresiaRegistroVisitaView.setLocationRelativeTo(null);
			this.membresiaRegistroVisitaView.getBtnBuscar().addActionListener(this);
			this.membresiaRegistroVisitaView.getBtnCancelar().addActionListener(this);
			this.membresiaRegistroVisitaView.getBtnRegistrar().addActionListener(this);
			this.membresiaRegistroVisitaView.setVisible(true);
		}
		if (this.membresiaListaVisitasView != null) {
			cargarHistoricoVisitas();
			this.membresiaListaVisitasView.setLocationRelativeTo(null);
			this.membresiaListaVisitasView.getBtnSalir().addActionListener(this);
			this.membresiaListaVisitasView.setVisible(true);
		}
		if (this.membresiaDiaVisitaView != null) {
			cargarDiaVisitas();
			this.membresiaDiaVisitaView.setLocationRelativeTo(null);
			this.membresiaDiaVisitaView.getBtnSalir().addActionListener(this);
			this.membresiaDiaVisitaView.setVisible(true);
		}
	}

	private void cargarDiaVisitas() {
		List<Visita> list = visitaDao.visitasDelDia();

		DefaultTableModel defaultTableModel = (DefaultTableModel) this.membresiaDiaVisitaView.getTable().getModel();

		Object[] columna = new Object[4];
		int numeroRegistros = list.size();

		for (int i = 0; i < numeroRegistros; i++) {
			columna[0] = list.get(i).getNombre();
			columna[1] = list.get(i).getApellido();
			NumberFormat format = NumberFormat.getInstance();
			columna[2] = "$ " + format.format(Integer.parseInt(list.get(i).getValor()));
			columna[3] = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a").format(list.get(i).getFecha());

			defaultTableModel.addRow(columna);
		}
		this.membresiaDiaVisitaView.getTable().setModel(defaultTableModel);
		this.membresiaDiaVisitaView.getTable().repaint();

	}

	private void cargarHistoricoVisitas() {
		List<Visita> list = visitaDao.historicoVisitas();

		DefaultTableModel defaultTableModel = (DefaultTableModel) this.membresiaListaVisitasView.getTable().getModel();

		Object[] columna = new Object[4];
		int numeroRegistros = list.size();

		for (int i = 0; i < numeroRegistros; i++) {
			columna[0] = list.get(i).getNombre();
			columna[1] = list.get(i).getApellido();
			NumberFormat format = NumberFormat.getInstance();
			columna[2] = "$ " + format.format(Integer.parseInt(list.get(i).getValor()));
			columna[3] = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a").format(list.get(i).getFecha());

			defaultTableModel.addRow(columna);
		}
		this.membresiaListaVisitasView.getTable().setModel(defaultTableModel);
		this.membresiaListaVisitasView.getTable().repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (membresiaRegistroVisitaView != null) {
			if (membresiaRegistroVisitaView.getBtnBuscar() == e.getSource()) {
				String key = membresiaRegistroVisitaView.getTextFieldSocio().getText();
				if (!key.equals("")) {
					socioTemp = socioDao.buscarSocioIdOrCodigo(key);
					if (socioTemp != null) {
						membresiaRegistroVisitaView.getTextFieldNombres().setText(socioTemp.getNombre());
						membresiaRegistroVisitaView.getTextFieldApellidos().setText(socioTemp.getApellido());
					} else {
						JOptionPane.showMessageDialog(null, "No se encontró un socio asociado.");
					}

				} else {
					JOptionPane.showMessageDialog(null, "El campo codigo no puede estar vacio.");
				}

			} else if (membresiaRegistroVisitaView.getBtnCancelar() == e.getSource()) {
				membresiaRegistroVisitaView.setVisible(false);
				membresiaRegistroVisitaView.dispose();
			} else if (membresiaRegistroVisitaView.getBtnRegistrar() == e.getSource()) {
				if (membresiaRegistroVisitaView.getTextFieldNombres().getText().equals("")
						|| membresiaRegistroVisitaView.getTextFieldApellidos().getText().equals("")
						|| membresiaRegistroVisitaView.getTextFieldValor().getText().equals("")) {
					JOptionPane.showMessageDialog(null, "No puede dejar vacio el campo nombre, apellido o valor.");
				} else {
					boolean res = false;
					int id_caja = cajaDao.verificarCajaAbierta();
					if (socioTemp == null) {
						String nombre = membresiaRegistroVisitaView.getTextFieldNombres().getText();
						String apellido = membresiaRegistroVisitaView.getTextFieldApellidos().getText();
						int valor = Integer.parseInt(membresiaRegistroVisitaView.getTextFieldValor().getText());
						res = visitaDao.registrarVisita(nombre, apellido, valor, -1, id_caja);
						membresiaRegistroVisitaView.setVisible(false);
						membresiaRegistroVisitaView.dispose();
					} else {
						String nombre = membresiaRegistroVisitaView.getTextFieldNombres().getText();
						String apellido = membresiaRegistroVisitaView.getTextFieldApellidos().getText();
						int valor = Integer.parseInt(membresiaRegistroVisitaView.getTextFieldValor().getText());

						res = visitaDao.registrarVisita(nombre, apellido, valor, socioTemp.getId(), id_caja);

						membresiaRegistroVisitaView.setVisible(false);
						membresiaRegistroVisitaView.dispose();
					}
					if (res == true) {
						JOptionPane.showMessageDialog(null, "La visita se registro correctamente");
					} else {
						JOptionPane.showMessageDialog(null, "Ocurrio un error al tratar de registrar la visita.");
					}
				}

			}

		}
		if (membresiaDiaVisitaView != null) {
			if (membresiaDiaVisitaView.getBtnSalir() == e.getSource()) {
				membresiaDiaVisitaView.setVisible(false);
				membresiaDiaVisitaView.dispose();
			}
		}
		if (membresiaListaVisitasView != null) {
			if (membresiaListaVisitasView.getBtnSalir() == e.getSource()) {
				membresiaListaVisitasView.setVisible(false);
				membresiaListaVisitasView.dispose();
			}
		}
	}

}

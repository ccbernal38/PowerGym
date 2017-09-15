package co.powergym.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import co.powergym.dao.CajaDao;
import co.powergym.dao.MovimientoDao;
import co.powergym.model.Movimiento;
import co.powergym.utils.Constantes;
import co.powergym.utils.Preferencias;
import co.powergym.view.caja.CajaListaEgresosHoyView;
import co.powergym.view.caja.CajaListaHistoricoEgresosView;
import co.powergym.view.caja.CajaListaHistoricosIngresosView;
import co.powergym.view.caja.CajaListaIngresosHoyView;
import co.powergym.view.caja.CajaRegistroEgresoView;
import co.powergym.view.caja.CajaRegistroIngresoView;

public class MovimientoController implements ActionListener {

	private CajaRegistroIngresoView cajaRegistroIngresoView;
	private CajaRegistroEgresoView cajaRegistroEgresoView;
	private CajaListaEgresosHoyView cajaListaEgresosHoyView;
	private CajaListaIngresosHoyView cajaListaIngresosHoyView;
	private CajaListaHistoricoEgresosView cajaListaHistoricoEgresosView;
	private CajaListaHistoricosIngresosView cajaListaHistoricoIngresosView;
	MovimientoDao movimientoDao;
	CajaDao cajaDao;

	/**
	 * @param cajaRegistroIngresoView
	 * @param cajaRegistroEgresoView
	 */
	public MovimientoController(CajaRegistroIngresoView IngresoView, CajaRegistroEgresoView EgresoView,
			CajaListaEgresosHoyView listaEgresosHoyView, CajaListaIngresosHoyView listaIngresosHoyView,
			CajaListaHistoricoEgresosView cajaListaEgresos, CajaListaHistoricosIngresosView cajaListaIngresos) {
		movimientoDao = new MovimientoDao();
		cajaDao = new CajaDao();
		this.cajaRegistroIngresoView = IngresoView;
		this.cajaRegistroEgresoView = EgresoView;
		this.cajaListaIngresosHoyView = listaIngresosHoyView;
		this.cajaListaEgresosHoyView = listaEgresosHoyView;
		this.cajaListaHistoricoEgresosView = cajaListaEgresos;
		this.cajaListaHistoricoIngresosView = cajaListaIngresos;
		if (cajaRegistroIngresoView != null) {
			cajaRegistroIngresoView.getBtnCancelar().addActionListener(this);
			cajaRegistroIngresoView.getBtnRegistrar().addActionListener(this);
			cajaRegistroIngresoView.setLocationRelativeTo(null);
			cajaRegistroIngresoView.setVisible(true);
		}

		if (cajaRegistroEgresoView != null) {
			cajaRegistroEgresoView.getBtnCancelar().addActionListener(this);
			cajaRegistroEgresoView.getBtnRegistrar().addActionListener(this);
			cajaRegistroEgresoView.setLocationRelativeTo(null);
			cajaRegistroEgresoView.setVisible(true);
		}

		if (cajaListaIngresosHoyView != null) {
			cargarListaIngresosHoy();
			cajaListaIngresosHoyView.getBtnSalir().addActionListener(this);
			cajaListaIngresosHoyView.setLocationRelativeTo(null);
			cajaListaIngresosHoyView.setVisible(true);

		}
		if (cajaListaEgresosHoyView != null) {
			cargarListaEgresosHoy();
			cajaListaEgresosHoyView.getBtnSalir().addActionListener(this);
			cajaListaEgresosHoyView.setLocationRelativeTo(null);
			cajaListaEgresosHoyView.setVisible(true);
		}
		if (cajaListaHistoricoEgresosView != null) {
			cargarListaHistoricoEgresos();
			cajaListaHistoricoEgresosView.getBtnSalir().addActionListener(this);
			cajaListaHistoricoEgresosView.setLocationRelativeTo(null);
			cajaListaHistoricoEgresosView.setVisible(true);
		}

		if (cajaListaHistoricoIngresosView != null) {
			cargarListaHistoricoIngresos();
			cajaListaHistoricoIngresosView.getBtnSalir().addActionListener(this);
			cajaListaHistoricoIngresosView.setLocationRelativeTo(null);
			cajaListaHistoricoIngresosView.setVisible(true);
		}
	}

	public void cargarListaEgresosHoy() {
		List<Movimiento> list = movimientoDao.listadoEgresosHoy();
		DefaultTableModel defaultTableModel = (DefaultTableModel) cajaListaEgresosHoyView.getTable().getModel();

		Object[] columna = new Object[3];
		int numeroRegistros = list.size();
		for (int i = 0; i < numeroRegistros; i++) {
			Date fecha = list.get(i).getFecha();
			columna[0] = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a").format(fecha);
			columna[1] = list.get(i).getConcepto();
			NumberFormat formatter = NumberFormat.getCurrencyInstance();
			columna[2] = formatter.format(list.get(i).getValor());
			defaultTableModel.addRow(columna);
		}
		this.cajaListaEgresosHoyView.getTable().setModel(defaultTableModel);
		this.cajaListaEgresosHoyView.getTable().repaint();
	}

	public void cargarListaIngresosHoy() {
		List<Movimiento> list = movimientoDao.listadoIngresosHoy();
		DefaultTableModel defaultTableModel = (DefaultTableModel) cajaListaIngresosHoyView.getTable().getModel();

		Object[] columna = new Object[3];
		int numeroRegistros = list.size();
		for (int i = 0; i < numeroRegistros; i++) {
			Date fecha = list.get(i).getFecha();
			columna[0] = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a").format(fecha);
			columna[1] = list.get(i).getConcepto();
			NumberFormat formatter = NumberFormat.getCurrencyInstance();
			columna[2] = formatter.format(list.get(i).getValor());
			defaultTableModel.addRow(columna);
		}
		this.cajaListaIngresosHoyView.getTable().setModel(defaultTableModel);
		this.cajaListaIngresosHoyView.getTable().repaint();
	}

	public void cargarListaHistoricoEgresos() {
		List<Movimiento> list = movimientoDao.listadoEgresos();
		DefaultTableModel defaultTableModel = (DefaultTableModel) cajaListaHistoricoEgresosView.getTable().getModel();

		Object[] columna = new Object[3];
		int numeroRegistros = list.size();
		for (int i = 0; i < numeroRegistros; i++) {
			Date fecha = list.get(i).getFecha();
			columna[0] = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a").format(fecha);
			columna[1] = list.get(i).getConcepto();
			NumberFormat formatter = NumberFormat.getCurrencyInstance();
			columna[2] = formatter.format(list.get(i).getValor());
			defaultTableModel.addRow(columna);
		}
		this.cajaListaHistoricoEgresosView.getTable().setModel(defaultTableModel);
		this.cajaListaHistoricoEgresosView.getTable().repaint();
	}

	public void cargarListaHistoricoIngresos() {
		List<Movimiento> list = movimientoDao.listadoIngresos();
		DefaultTableModel defaultTableModel = (DefaultTableModel) cajaListaHistoricoIngresosView.getTable().getModel();

		Object[] columna = new Object[3];
		int numeroRegistros = list.size();
		for (int i = 0; i < numeroRegistros; i++) {
			Date fecha = list.get(i).getFecha();
			columna[0] = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a").format(fecha);
			columna[1] = list.get(i).getConcepto();
			NumberFormat formatter = NumberFormat.getCurrencyInstance();
			columna[2] = formatter.format(list.get(i).getValor());
			defaultTableModel.addRow(columna);
		}
		this.cajaListaHistoricoIngresosView.getTable().setModel(defaultTableModel);
		this.cajaListaHistoricoIngresosView.getTable().repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (cajaRegistroIngresoView != null) {
			if (cajaRegistroIngresoView.getBtnCancelar() == e.getSource()) {
				cajaRegistroIngresoView.setVisible(false);
				cajaRegistroIngresoView.dispose();
			}
			if (cajaRegistroIngresoView.getBtnRegistrar() == e.getSource()) {
				try {
					String concepto = cajaRegistroIngresoView.getTextAreaConcepto().getText();
					int valor = Integer.parseInt(cajaRegistroIngresoView.getTextFieldValor().getText());
					int caja = cajaDao.verificarCajaAbierta();
					movimientoDao.registrarIngreso(concepto, valor, caja);
					JOptionPane.showMessageDialog(null, "Se ha registrado el ingreso correctamente.");
					cajaRegistroIngresoView.setVisible(false);
					cajaRegistroIngresoView.dispose();
				} catch (NumberFormatException err) {
					JOptionPane.showMessageDialog(null, "Solo debe ingresar numeros en el campo valor.");
				}
			}
		}
		if (cajaRegistroEgresoView != null) {
			if (cajaRegistroEgresoView.getBtnCancelar() == e.getSource()) {
				cajaRegistroEgresoView.setVisible(false);
				cajaRegistroEgresoView.dispose();
			}
			if (cajaRegistroEgresoView.getBtnRegistrar() == e.getSource()) {
				try {
					String concepto = cajaRegistroEgresoView.getTextAreaConcepto().getText();
					int valor = Integer.parseInt(cajaRegistroEgresoView.getTextFieldValor().getText());
					int caja = cajaDao.verificarCajaAbierta();
					movimientoDao.registrarEgreso(concepto, valor, caja);
					JOptionPane.showMessageDialog(null, "Se ha registrado el egreso correctamente.");
					cajaRegistroEgresoView.setVisible(false);
					cajaRegistroEgresoView.dispose();
				} catch (NumberFormatException err) {
					JOptionPane.showMessageDialog(null, "Solo debe ingresar numeros en el campo valor.");
				}
			}
		}
	}
}

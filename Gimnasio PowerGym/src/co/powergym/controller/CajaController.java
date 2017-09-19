package co.powergym.controller;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import co.powergym.dao.CajaDao;
import co.powergym.dao.UsuarioDao;
import co.powergym.model.Caja;
import co.powergym.model.MembresiaSocio;
import co.powergym.model.Usuario;
import co.powergym.utils.Constantes;
import co.powergym.utils.Preferencias;
import co.powergym.view.caja.CajaListaEgresosHoyView;
import co.powergym.view.caja.CajaListaIngresosHoyView;
import co.powergym.view.caja.CajaMembresiaVentaDiaView;
import co.powergym.view.caja.CajaCierreView;

public class CajaController {

	private CajaDao cajaDao;
	private UsuarioDao usuarioDao;
	private CajaMembresiaVentaDiaView membresiaVentaDiaView;
	private CajaCierreView cierreCajaView;

	public CajaController(CajaMembresiaVentaDiaView diaView, CajaCierreView cierreCajaView) {
		cajaDao = new CajaDao();
		usuarioDao = new UsuarioDao();
		this.membresiaVentaDiaView = diaView;
		this.cierreCajaView = cierreCajaView;

		if (membresiaVentaDiaView != null) {
			cargarVentasMembresiaDia();
			membresiaVentaDiaView.setLocationRelativeTo(null);
			membresiaVentaDiaView.setVisible(true);
		}
		if (cierreCajaView != null) {
			cargarSaldosCierre();
			cierreCajaView.setLocationRelativeTo(null);
			cierreCajaView.setVisible(true);
		}

	}

	private void cargarSaldosCierre() {
		Caja caja = cajaDao.ultimoRegistro();
		Usuario userApertura = usuarioDao.buscarUsuarioId(caja.getResponsableApertura());
		cierreCajaView.getLabelFechaApertura()
				.setText(new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a").format(caja.getFechaApertura()));
		cierreCajaView.getLabelResponsableApertura().setText(userApertura.getNombre()+" "+userApertura.getApellido());
		cierreCajaView.getLabelResponsableCierre().setText(Preferencias.obtenerPreferencia(Constantes.NOMBRE_RESPONSABLE));
		int totalVentasMembresiaDia = cajaDao.totalVentasMembresiasDia();
		NumberFormat format = NumberFormat.getInstance();
		cierreCajaView.getTextFieldVentasM().setText("$ "+format.format(totalVentasMembresiaDia));
	}

	private void cargarVentasMembresiaDia() {
		List<MembresiaSocio> list = cajaDao.ventasDelDia();
		DefaultTableModel defaultTableModel = (DefaultTableModel) membresiaVentaDiaView.getTable().getModel();

		Object[] columna = new Object[5];
		int numeroRegistros = list.size();

		for (int i = 0; i < numeroRegistros; i++) {
			columna[0] = list.get(i).getSocio().getNombre();
			columna[1] = list.get(i).getMembresia().getNombre();
			NumberFormat format = NumberFormat.getInstance();
			columna[2] = "$ " + format.format(list.get(i).getValor());
			columna[3] = "$ " + format.format(list.get(i).getDescuento());
			columna[4] = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a").format(list.get(i).getFechaInicial());
			defaultTableModel.addRow(columna);
		}
		this.membresiaVentaDiaView.getTable().setModel(defaultTableModel);
		this.membresiaVentaDiaView.getTable().repaint();
	}

}

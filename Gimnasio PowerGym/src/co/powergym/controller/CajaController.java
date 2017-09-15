package co.powergym.controller;

import co.powergym.dao.CajaDao;
import co.powergym.view.caja.CajaListaEgresosHoyView;
import co.powergym.view.caja.CajaListaIngresosHoyView;

public class CajaController {

	private CajaDao cajaDao;

	/**
	 * @param cajaListaEgresosHoyView
	 * @param cajaListaIngresosHoyView
	 */
	public CajaController() {
		cajaDao = new CajaDao();

	}

	private void cargarListaEgresosHoy() {

	}

	public void cargarListaIngresosHoy() {

	}
}

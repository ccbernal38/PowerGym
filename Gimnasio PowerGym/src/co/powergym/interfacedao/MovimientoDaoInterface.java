package co.powergym.interfacedao;

import java.util.List;

import co.powergym.model.Movimiento;

public interface MovimientoDaoInterface {

	/**
	 * Permite registrar un valor de ingreso del dia
	 * 
	 * @param concepto
	 * @param valor
	 * @param caja_id
	 * @return
	 */
	public boolean registrarIngreso(String concepto, int valor, int caja_id);

	/**
	 * Permite registrar un valor de egreso del dia
	 * 
	 * @param concepto
	 * @param valor
	 * @param caja_id
	 * @return
	 */
	public boolean registrarEgreso(String concepto, int valor, int caja_id);

	/**
	 * Permite listar los ingresos de todos los tiempos
	 * 
	 * @return
	 */
	public List<Movimiento> listadoIngresos();

	/**
	 * Permite listar los ingresos del dia
	 * 
	 * @return
	 */
	public List<Movimiento> listadoIngresosHoy();

	/**
	 * Permite listar los egresos de todos los tiempos
	 * 
	 * @return
	 */
	public List<Movimiento> listadoEgresos();

	/**
	 * Permite listar los egresos de hoy
	 * 
	 * @return
	 */
	public List<Movimiento> listadoEgresosHoy();
}

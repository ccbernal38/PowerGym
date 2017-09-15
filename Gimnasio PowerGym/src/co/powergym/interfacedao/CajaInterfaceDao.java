package co.powergym.interfacedao;

import java.util.Date;
import java.util.List;

import co.powergym.model.Movimiento;

public interface CajaInterfaceDao {

	public boolean aperturaCaja(int responsableApertura, Date fechaApertura, int saldoInicial);

	public int verificarCajaAbierta();
	// public boolean cierreCaja(int responsableCierre, Date fechaCierre);

	public List<Movimiento> listaIngresosHoy();

	public List<Movimiento> listaEgresosHoy();

	public List<Movimiento> historicoIngresos();

	public List<Movimiento> historicoEgresos();
	
}

package co.powergym.interfacedao;

import java.util.Date;
import java.util.List;

import co.powergym.model.Caja;
import co.powergym.model.MembresiaSocio;
import co.powergym.model.Movimiento;

public interface CajaInterfaceDao {

	public boolean aperturaCaja(int responsableApertura, Date fechaApertura, int saldoInicial);

	public int verificarCajaAbierta();
	// public boolean cierreCaja(int responsableCierre, Date fechaCierre);

	public List<MembresiaSocio> ventasDelDia();

	public Caja ultimoRegistro();

	public int totalVentasMembresiasDia();
}

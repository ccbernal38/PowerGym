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

	public int totalVentasMembresiasDia(int caja_id);

	public int totalVentasVisitasDia(int caja_id);

	public int totalEgresosDia(int caja_id);

	public int totalDeudasDia(int caja_id);

	public int totalSaldoFavorDia(int caja_id);

	public boolean cerrarCaja(int caja_id, int usuario_cierre, int totalEgresos, int totalMembresia, int totalVisita,
			int totalAdeudosDia, int totalSaldoFavorDia, int dineroCaja);

	public List<Caja> historicoCaja();
	
	public Caja buscarCaja(int id);
}

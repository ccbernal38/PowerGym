package co.powergym.interfacedao;

import java.util.Date;

public interface ReciboInterfaceDao {
	
	public int numeroFactura();
	public boolean registrarFactura(Date fecha, int socio, int usuario, String descripcion, int pago, int usadoSaldoFavor, int debe, int saldoFavor);
	
}

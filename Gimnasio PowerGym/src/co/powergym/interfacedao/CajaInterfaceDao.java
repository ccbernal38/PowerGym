package co.powergym.interfacedao;

import java.util.Date;

public interface CajaInterfaceDao {

	public boolean aperturaCaja(int responsableApertura, Date fechaApertura, int saldoInicial);

	public int verificarCajaAbierta();
	//public boolean cierreCaja(int responsableCierre, Date fechaCierre);
}

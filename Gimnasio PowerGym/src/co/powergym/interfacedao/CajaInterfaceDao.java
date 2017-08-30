package co.powergym.interfacedao;

import java.util.Date;

public interface CajaInterfaceDao {

	public boolean aperturaCaja(int responsableApertura, Date fechaApertura, int saldoInicial);
	
	//public boolean cierreCaja(int responsableCierre, Date fechaCierre);
}

package co.powergym.interfacedao;

public interface SaldoFavorInterfaceDao {

	public boolean registrarSaldoFavor(int valor, int socio_id, int caja_id);

	public int saldoFavorSocio(int socio_id);
}

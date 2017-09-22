package co.powergym.interfacedao;

public interface DeudaDaoInterface {

	public boolean registrarDeuda(int valor, int socio_id, int caja_id);

	public int totalDeudasSocio(int socio_id);

}

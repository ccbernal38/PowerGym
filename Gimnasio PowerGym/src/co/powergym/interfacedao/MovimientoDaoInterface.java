package co.powergym.interfacedao;

public interface MovimientoDaoInterface {

	public boolean registrarIngreso(String concepto, int valor, int caja_id);

	public boolean registrarEgreso(String concepto, int valor, int caja_id);
	
}

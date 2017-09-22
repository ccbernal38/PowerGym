package co.powergym.interfacedao;

import java.util.List;

import co.powergym.model.Deuda;

public interface DeudaDaoInterface {

	public boolean registrarDeuda(int valor, String concepto, int socio_id, int caja_id);

	public boolean registrarPago(int valor, String concepto, int socio_id, int caja_id);

	public int totalDeudasSocio(int socio_id);

	public List<Deuda> listaDeudasSocio(int socio_id);
	
	public List<Deuda> historicoPago(int socio_id);

}

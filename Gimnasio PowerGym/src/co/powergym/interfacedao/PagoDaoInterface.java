package co.powergym.interfacedao;

import java.sql.Date;
import java.util.ArrayList;

import co.powergym.model.Pago;

public interface PagoDaoInterface {

	public boolean registrarPago(String id_socio, String codigo_membresia, double valor, Date fecha);
	
	public ArrayList<Pago> listaPagos();
	
	public boolean modificarPago(String id_socio, String codigo_membresia, double valor, Date fecha);
	
}

package co.powergym.interfacedao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import co.powergym.model.Factura;

public interface PagoDaoInterface {

	public boolean registrarPago(int id_socio, int codigo_membresia, double valor, Date fecha);
	
	public List<Factura> listaPagos();
	
	public boolean modificarPago(int id_socio, int codigo_membresia, double valor, Date fecha);
	
}

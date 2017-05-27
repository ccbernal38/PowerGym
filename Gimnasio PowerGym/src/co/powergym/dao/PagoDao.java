package co.powergym.dao;

import java.sql.Date;
import java.util.ArrayList;

import co.powergym.interfacedao.PagoDaoInterface;
import co.powergym.model.Conexion;
import co.powergym.model.Pago;

public class PagoDao implements PagoDaoInterface{

	Conexion conexion;
	
	public PagoDao() {
		// TODO Auto-generated constructor stub
		conexion = new Conexion();
	}
	
	@Override
	public boolean registrarPago(String id_socio, String codigo_membresia, double valor, Date fecha) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Pago> listaPagos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificarPago(String id_socio, String codigo_membresia, double valor, Date fecha) {
		// TODO Auto-generated method stub
		return false;
	}

}

package co.powergym.dao;

import java.io.ByteArrayOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.imageio.ImageIO;

import co.powergym.interfacedao.PagoDaoInterface;
import co.powergym.model.Conexion;
import co.powergym.model.Factura;

public class PagoDao implements PagoDaoInterface{

	Conexion conexion;
	
	public PagoDao() {
		// TODO Auto-generated constructor stub
		conexion = new Conexion();
	}
	
	@Override
	public boolean registrarPago(int id_socio, int codigo_membresia, double valor, Date fecha) {
		return false;
	}

	@Override
	public List<Factura> listaPagos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificarPago(int id_socio, int codigo_membresia, double valor, Date fecha) {
		// TODO Auto-generated method stub
		return false;
	}

}

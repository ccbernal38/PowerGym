package co.powergym.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import co.powergym.interfacedao.MembresiaDaoInterface;
import co.powergym.model.Conexion;
import co.powergym.model.Membresia;
import co.powergym.model.Socio;

public class MembresiaDao implements MembresiaDaoInterface {

	Conexion conexion;

	public MembresiaDao() {
		// TODO Auto-generated constructor stub
		conexion = new Conexion();
	}

	@Override
	public boolean registrarMembresia(String codigo, String nombre, double valor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Membresia> listaMembresia() {
		List<Membresia> list = new ArrayList<Membresia>();
		Membresia membresia;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from Membresia");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				membresia = new Membresia();
				membresia.setId(resultSet.getInt(1));
				membresia.setNombre(resultSet.getString(2));
				membresia.setDuracion(resultSet.getInt(3));
				list.add(membresia);
			}
		} catch (Exception e) {
		}
		return list;
	}

	@Override
	public boolean eliminarMembresia(String codigo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificarMembresia(String codigo, String nombre, double valor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Membresia buscarMembresia(String codigo) {
		
		
		return null;
	}

}

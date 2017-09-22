package co.powergym.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import co.powergym.interfacedao.DuracionDaoInterface;
import co.powergym.model.Conexion;
import co.powergym.model.Duracion;

public class DuracionDao implements DuracionDaoInterface{

	private Conexion conexion;
	
	public DuracionDao() {
		conexion = new Conexion();
	}

	@Override
	public List<Duracion> listarDuracion() {
		
		List<Duracion> list = new ArrayList<Duracion>();
		Duracion duracion;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, nombre FROM duracion");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				duracion = new Duracion();
				duracion.setId(resultSet.getInt(1));
				duracion.setNombre(resultSet.getString(2));
				list.add(duracion);
			}
			conexion.desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}

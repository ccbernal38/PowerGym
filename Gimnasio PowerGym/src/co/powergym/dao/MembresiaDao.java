package co.powergym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import co.powergym.interfacedao.MembresiaDaoInterface;
import co.powergym.model.Conexion;
import co.powergym.model.Dia;
import co.powergym.model.Horario;
import co.powergym.model.Membresia;

public class MembresiaDao implements MembresiaDaoInterface {

	Conexion conexion;

	public MembresiaDao() {
		// TODO Auto-generated constructor stub
		conexion = new Conexion();
	}
	
	@Override
	public boolean registrarMembresia(String codigo, String nombre, double valor, int cantidadDuracion,
			String tipoDuracion, boolean limiteDias, int numeroVisitas, List<Dia> dias, boolean horarioIngreso,
			List<Horario> horarios) {
		
		return false;
	}
	
	@Override
	public List<Membresia> listaMembresia() {
		List<Membresia> list = new ArrayList<Membresia>();
		Membresia membresia;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select id, nombre, duracion, precio from Membresia");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				membresia = new Membresia();
				membresia.setId(resultSet.getInt(1));
				membresia.setNombre(resultSet.getString(2));
				membresia.setDuracion(resultSet.getInt(3));
				membresia.setValor(resultSet.getInt(4));
				list.add(membresia);
			}
		} catch (Exception e) {
		}
		return list;
	}

	@Override
	public boolean eliminarMembresia(int id) {

		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM Membresia" + " WHERE id = ?");
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean modificarMembresia(int id, String nombre, double valor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Membresia buscarMembresia(int id) {

		return null;
	}

}

package co.powergym.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import co.powergym.interfacedao.MembresiaDaoInterface;
import co.powergym.model.Conexion;
import co.powergym.model.DiaSemana;
import co.powergym.model.Duracion;
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
			String tipoDuracion, boolean limiteDias, int numeroVisitas, List<DiaSemana> dias, boolean horarioIngreso,
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
					.prepareStatement("SELECT m.id, m.nombre, m.duracion, d.id, d.nombre, m.precio, m.visitasxdia "
							+ "FROM Membresia AS m " + "JOIN Duracion AS d ON d.id = m.duracion_id");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				membresia = new Membresia();
				membresia.setId(resultSet.getInt(1));
				membresia.setNombre(resultSet.getString(2));
				membresia.setDuracion(resultSet.getInt(3));
				membresia.setDuracionValor(new Duracion(resultSet.getInt(4), resultSet.getString(5)));
				membresia.setValor(resultSet.getInt(6));
				membresia.setCantidad_visitas_dia(resultSet.getInt(7));
				membresia.setDiasPermitidos(getDiasPermitidos(membresia.getId()));
				membresia.setHorario(getHorarios(membresia.getId()));
				list.add(membresia);
			}
			conexion.cerrarConexion();
		} catch (Exception e) {
			System.out.println("error");
		}
		return list;
	}

	@Override
	public boolean eliminarMembresia(int id) {

		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Membresia WHERE id = ?");
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			conexion.cerrarConexion();
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

	@Override
	public List<Horario> getHorarios(int id) {
		List<Horario> list = new ArrayList<Horario>();
		Horario horario;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"SELECT id, horaInicio, horaFin " + "FROM Horario AS h " + "WHERE h.membresia_id = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				horario = new Horario();
				horario.setId(resultSet.getInt(1));
				Timestamp timeInicial = resultSet.getTimestamp(2);
				Timestamp timeFin = resultSet.getTimestamp(3);
				horario.setHoraInicio(new Date(timeInicial.getTime()));
				horario.setHoraFin(new Date(timeFin.getTime()));
				list.add(horario);
			}
			conexion.cerrarConexion();
		} catch (Exception e) {
			System.out.println("error");
		}
		return list;
	}

	@Override
	public List<DiaSemana> getDiasPermitidos(int id) {
		List<DiaSemana> list = new ArrayList<DiaSemana>();
		DiaSemana diasemana;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT ds.id, ds.nombre "
					+ "FROM Membresia AS m " + "JOIN Membresia_diasemana AS md ON md.membresia_id = m.id "
					+ "JOIN Diasemana AS ds ON ds.id = md.diassemana_id " + "WHERE m.id = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				diasemana = new DiaSemana();
				diasemana.setId(resultSet.getInt(1));
				diasemana.setNombre(resultSet.getString(2));
				list.add(diasemana);
			}
			conexion.cerrarConexion();
		} catch (Exception e) {
			System.out.println("error");
		}
		return list;
	}

}

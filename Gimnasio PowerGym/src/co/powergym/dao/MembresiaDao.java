package co.powergym.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
	public boolean registrarMembresia(String nombre, double valor, int cantidadDuracion, int visitasxdia,
			int IdTipoDuracion, int promocional, Date fechaFinalizacion) {

		boolean respuesta = false;
		try {
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD.prepareStatement("INSERT INTO Membresia(nombre, duracion, precio,"
					+ "visitasxdia, duracion_id, promocional, fechaFinalizacion) VALUES(?,?,?,?,?,?,?)");
			statement.setString(1, nombre);
			statement.setInt(2, cantidadDuracion);
			statement.setDouble(3, valor);
			statement.setInt(4, visitasxdia);
			statement.setInt(5, IdTipoDuracion);
			statement.setInt(6, promocional);
			if (fechaFinalizacion != null) {
				statement.setDate(7, new java.sql.Date(fechaFinalizacion.getTime()));
			}else {
				statement.setDate(7, null);
			}

			statement.execute();
			respuesta = true;
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return respuesta;
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
			conexion.desconectar();
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
			conexion.desconectar();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean modificarMembresia(String nombre, int valor, int visitasDia, int id, int estado) {
		boolean resultado = false;
		try {
			Connection connection = conexion.getConexion();

			PreparedStatement statement = connection.prepareStatement("UPDATE Membresia Set nombre = ?, "
						+ "precio = ?, visitasxdia = ? WHERE id = ? ");				
				statement.setString(1, nombre);
				statement.setInt(2, valor);
				statement.setInt(3, visitasDia);
				statement.setInt(4, id);
				statement.setInt(5, estado);
				statement.execute();
				resultado = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public Membresia buscarMembresia(int id) {
		Membresia membresia = null;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT m.id, m.nombre, m.duracion, "
					+ "d.id as idDuracion, d.nombre as nombreDuracion, m.precio, m.visitasxdia, m.renovar "
					+ "FROM membresia m " + "JOIN Duracion d ON d.id = m.duracion_id " + "WHERE m.id = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				membresia = new Membresia();
				membresia.setId(id);
				membresia.setNombre(resultSet.getString("nombre"));
				membresia.setDuracion(resultSet.getInt("duracion"));
				membresia.setDuracionValor(
						new Duracion(resultSet.getInt("idDuracion"), resultSet.getString("nombreDuracion")));
				membresia.setValor(resultSet.getInt("precio"));
				membresia.setCantidad_visitas_dia(resultSet.getInt("visitasxdia"));
				if (resultSet.getInt("renovar") == 1)
					membresia.setRenovar(true);
				else
					membresia.setRenovar(false);

			}
			conexion.desconectar();
		} catch (Exception e) {
			System.out.println("error");
		}
		return membresia;
	}

	@Override
	public List<Horario> getHorarios(int id) {
		List<Horario> list = new ArrayList<Horario>();
		Horario horario;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT id, horaInicio, horaFin FROM Horario AS h WHERE h.membresia_id = ?");
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
			conexion.desconectar();
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
			conexion.desconectar();
		} catch (Exception e) {
			System.out.println("error");
		}
		return list;
	}

	@Override
	public Membresia verificarEntradaMembresia(int idSocio) {
		Membresia membresia = null;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"SELECT m.id as idMembresia, ds.id as idDia, ds.nombre as nombre, h.id as idHora, "
							+ " 	h.horaInicio as horaInicio, h.horaFin as horaFin FROM membresia_socio ms "
							+ "		JOIN Membresia m ON m.id = ms.id "
							+ "		JOIN Membresia_diasemana md ON md.membresia_id = m.id "
							+ "		JOIN DiaSemana ds ON ds.id = md.diassemana_id "
							+ "		JOIN Horario h ON h.membresia_id = m.id "
							+ "		WHERE activa = 1 AND socio_id = ?");

			preparedStatement.setInt(1, idSocio);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (membresia == null) {
					membresia = new Membresia();
					membresia.setHorario(new ArrayList<>());
					membresia.setDiasPermitidos(new ArrayList<>());
				}

				DiaSemana diaSemana = new DiaSemana();
				diaSemana.setId(resultSet.getInt("idDia"));
				diaSemana.setNombre(resultSet.getString("nombre"));
				if (!membresia.getDiasPermitidos().contains(diaSemana))
					membresia.getDiasPermitidos().add(diaSemana);

				Horario horario = new Horario();
				horario.setId(resultSet.getInt("idHora"));
				horario.setHoraInicio(new Date(resultSet.getTimestamp("horaInicio").getTime()));
				horario.setHoraFin(new Date(resultSet.getTimestamp("horaFin").getTime()));
				if (!membresia.getHorario().contains(horario))
					membresia.getHorario().add(horario);
			}
			conexion.desconectar();
		} catch (Exception e) {
			System.out.println("error");
		}
		return membresia;
	}

	@Override
	public Membresia buscarId(String nombre) {

		Membresia membresia = null;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT m.id as id FROM membresia m WHERE m.nombre = ?");
			preparedStatement.setString(1, nombre);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				membresia = new Membresia();
				membresia.setId(resultSet.getInt("id"));
			}
			conexion.desconectar();
		} catch (Exception e) {
			System.out.println("error");
		}
		return membresia;
	}

}

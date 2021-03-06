package co.powergym.dao;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.imageio.ImageIO;

import co.powergym.interfacedao.VisitaDaoInterface;
import co.powergym.model.Conexion;
import co.powergym.model.Socio;
import co.powergym.model.Visita;

public class VisitaDao implements VisitaDaoInterface {

	Conexion conexion;

	public VisitaDao() {
		conexion = new Conexion();

	}

	@Override
	public boolean registrarVisita(String nombre, String apellido, int valor, int id_usuario, int id_caja) {
		boolean respuesta = false;
		try {
			Connection accesoBD = conexion.getConexion();

			PreparedStatement statement = null;
			if (id_usuario != -1) {
				statement = accesoBD.prepareStatement(
						"INSERT INTO Visita(nombre, apellido, valor, caja_id, socio_id) VALUES(?,?,?,?,?)");
			} else {
				statement = accesoBD
						.prepareStatement("INSERT INTO Visita(nombre, apellido, valor, caja_id) VALUES(?,?,?,?)");
			}
			statement.setString(1, nombre);
			statement.setString(2, apellido);
			statement.setInt(3, valor);
			statement.setInt(4, id_caja);
			if (id_usuario != -1) {
				statement.setInt(5, id_usuario);
			}
			statement.execute();
			respuesta = true;
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return respuesta;
	}

	@Override
	public List<Visita> historicoVisitas() {
		List<Visita> list = new ArrayList<Visita>();
		Visita visitas;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT id, nombre, apellido, valor, fechaCreacion FROM Visita");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				visitas = new Visita();
				visitas.setId(resultSet.getInt(1));
				visitas.setNombre(resultSet.getString(2));
				visitas.setApellido(resultSet.getString(3));
				visitas.setValor(resultSet.getInt(4) + "");
				visitas.setFecha(resultSet.getTimestamp(5));
				list.add(visitas);

			}
			conexion.desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Visita> visitasDelDia() {
		List<Visita> list = new ArrayList<Visita>();
		Visita visitas;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT id, nombre, apellido, valor, fechaCreacion FROM Visita WHERE "
							+ "MONTH(fechaCreacion) = ? AND YEAR(fechaCreacion) = ? AND DAY(fechaCreacion) = ?");
			Calendar calendar = Calendar.getInstance();
			preparedStatement.setInt(1, calendar.get(Calendar.MONTH) + 1);
			preparedStatement.setInt(2, calendar.get(Calendar.YEAR));
			preparedStatement.setInt(3, calendar.get(Calendar.DAY_OF_MONTH));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				visitas = new Visita();
				visitas.setId(resultSet.getInt(1));
				visitas.setNombre(resultSet.getString(2));
				visitas.setApellido(resultSet.getString(3));
				visitas.setValor(resultSet.getInt(4) + "");
				visitas.setFecha(resultSet.getTimestamp(5));
				list.add(visitas);
			}
			conexion.desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}

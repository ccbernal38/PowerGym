package co.powergym.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import co.powergym.interfacedao.MovimientoDaoInterface;
import co.powergym.model.Conexion;
import co.powergym.model.Movimiento;

public class MovimientoDao implements MovimientoDaoInterface {

	Conexion conexion;

	public MovimientoDao() {
		conexion = new Conexion();
	}

	@Override
	public boolean registrarIngreso(String concepto, int valor, int caja_id) {
		boolean respuesta = false;
		try {
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD
					.prepareStatement("INSERT INTO Movimiento(concepto, valor, caja_id, tipo) VALUES(?,?,?,?)");
			statement.setString(1, concepto);
			statement.setInt(2, valor);
			statement.setInt(3, caja_id);
			statement.setInt(4, Movimiento.INGRESO);

			statement.execute();
			respuesta = true;
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return respuesta;
	}

	@Override
	public boolean registrarEgreso(String concepto, int valor, int caja_id) {
		boolean respuesta = false;
		try {
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD
					.prepareStatement("INSERT INTO Movimiento(concepto, valor, caja_id, tipo) VALUES(?,?,?,?)");
			statement.setString(1, concepto);
			statement.setInt(2, valor);
			statement.setInt(3, caja_id);
			statement.setInt(4, Movimiento.EGRESO);
			statement.execute();
			respuesta = true;
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return respuesta;
	}

	@Override
	public List<Movimiento> listadoIngresos() {
		List<Movimiento> list = new ArrayList<>();
		Movimiento movimiento;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"SELECT id, concepto, valor, tipo, fechaCreacion FROM Movimiento WHERE tipo = ? ORDER BY fechaCreacion DESC");
			preparedStatement.setInt(1, Movimiento.INGRESO);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				movimiento = new Movimiento();
				movimiento.setId(resultSet.getInt(1));
				movimiento.setConcepto(resultSet.getString(2));
				movimiento.setValor(resultSet.getInt(3));
				movimiento.setTipo(resultSet.getInt(4));
				movimiento.setFecha(resultSet.getTimestamp(5));

				list.add(movimiento);

			}
			conexion.desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Movimiento> listadoIngresosHoy() {
		List<Movimiento> list = new ArrayList<>();
		Movimiento movimiento;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT id, concepto, valor, tipo, fechaCreacion FROM Movimiento "
							+ "WHERE tipo = ? AND MONTH(fechaCreacion) = ? AND DAY(fechaCreacion) = ? AND YEAR(fechaCreacion) = ?");
			preparedStatement.setInt(1, Movimiento.INGRESO);
			Calendar calendar = Calendar.getInstance();
			preparedStatement.setInt(2, calendar.get(Calendar.MONTH) + 1);
			preparedStatement.setInt(3, calendar.get(Calendar.DAY_OF_MONTH));
			preparedStatement.setInt(4, calendar.get(Calendar.YEAR));
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				movimiento = new Movimiento();
				movimiento.setId(resultSet.getInt(1));
				movimiento.setConcepto(resultSet.getString(2));
				movimiento.setValor(resultSet.getInt(3));
				movimiento.setTipo(resultSet.getInt(4));
				movimiento.setFecha(resultSet.getTimestamp(5));

				list.add(movimiento);

			}
			conexion.desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Movimiento> listadoEgresos() {
		List<Movimiento> list = new ArrayList<>();
		Movimiento movimiento;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"SELECT id, concepto, valor, tipo, fechaCreacion FROM Movimiento WHERE tipo = ? ORDER BY fechaCreacion DESC");
			preparedStatement.setInt(1, Movimiento.EGRESO);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				movimiento = new Movimiento();
				movimiento.setId(resultSet.getInt(1));
				movimiento.setConcepto(resultSet.getString(2));
				movimiento.setValor(resultSet.getInt(3));
				movimiento.setTipo(resultSet.getInt(4));
				movimiento.setFecha(resultSet.getTimestamp(5));

				list.add(movimiento);

			}
			conexion.desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Movimiento> listadoEgresosHoy() {
		List<Movimiento> list = new ArrayList<>();
		Movimiento movimiento;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT id, concepto, valor, tipo, fechaCreacion FROM Movimiento "
							+ "WHERE tipo = ? AND MONTH(fechaCreacion) = ? AND DAY(fechaCreacion) = ? AND YEAR(fechaCreacion) = ?");
			preparedStatement.setInt(1, Movimiento.EGRESO);
			Calendar calendar = Calendar.getInstance();
			preparedStatement.setInt(2, calendar.get(Calendar.MONTH) + 1);
			preparedStatement.setInt(3, calendar.get(Calendar.DAY_OF_MONTH));
			preparedStatement.setInt(4, calendar.get(Calendar.YEAR));
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				movimiento = new Movimiento();
				movimiento.setId(resultSet.getInt(1));
				movimiento.setConcepto(resultSet.getString(2));
				movimiento.setValor(resultSet.getInt(3));
				movimiento.setTipo(resultSet.getInt(4));
				movimiento.setFecha(resultSet.getTimestamp(5));

				list.add(movimiento);

			}
			conexion.desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}

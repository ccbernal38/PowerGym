package co.powergym.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.imageio.ImageIO;


import co.powergym.interfacedao.DeudaDaoInterface;
import co.powergym.model.Conexion;
import co.powergym.model.Deuda;

public class DeudaDao implements DeudaDaoInterface {

	private Conexion conexion;

	public DeudaDao() {
		conexion = new Conexion();
	}

	@Override
	public boolean registrarDeuda(int valor, String concepto, int socio_id, int caja_id) {
		boolean respuesta = false;
		try {
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD
					.prepareStatement("INSERT INTO Deuda(valor, socio_id, caja_id, concepto) VALUES(?,?,?,?)");
			statement.setInt(1, valor);
			statement.setInt(2, socio_id);
			statement.setInt(3, caja_id);
			statement.setString(4, concepto);

			statement.execute();
			respuesta = true;
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return respuesta;
	}

	@Override
	public boolean registrarPago(int valor, String concepto, int socio_id, int caja_id) {
		boolean respuesta = false;
		try {
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD
					.prepareStatement("INSERT INTO Deuda(valor, socio_id, caja_id, concepto, tipo) VALUES(?,?,?,?,1)");
			statement.setInt(1, valor);
			statement.setInt(2, socio_id);
			statement.setInt(3, caja_id);
			statement.setString(4, concepto);

			statement.execute();
			respuesta = true;
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return respuesta;
	}

	@Override
	public int totalDeudasSocio(int socio_id) {
		int valor = 0;
		try {
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD
					.prepareStatement("SELECT COALESCE(SUM(valor),0) FROM Deuda WHERE socio_id = ?;");
			statement.setInt(1, socio_id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				valor = resultSet.getInt(1);
			}
			return valor;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return valor;
	}

	@Override
	public List<Deuda> listaDeudasSocio(int socio_id) {
		List<Deuda> list = new ArrayList<>();
		try {
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD
					.prepareStatement("SELECT id, concepto, valor, fechaCreacion FROM Deuda WHERE socio_id = ?;");
			statement.setInt(1, socio_id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Deuda deuda = new Deuda();
				deuda.setId(resultSet.getInt(1));
				deuda.setConcepto(resultSet.getString(2));
				deuda.setValor(resultSet.getInt(3));
				deuda.setFecha(resultSet.getTimestamp(4));
				list.add(deuda);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return list;
	}

	@Override
	public List<Deuda> historicoPago(int socio_id) {
		List<Deuda> list = new ArrayList<>();
		try {
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD.prepareStatement(
					"SELECT id, concepto, valor, fechaCreacion FROM Deuda WHERE socio_id = ? AND tipo = 1;");
			statement.setInt(1, socio_id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Deuda deuda = new Deuda();
				deuda.setId(resultSet.getInt(1));
				deuda.setConcepto(resultSet.getString(2));
				deuda.setValor(resultSet.getInt(3));
				deuda.setFecha(resultSet.getTimestamp(4));
				list.add(deuda);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return list;
	}

}

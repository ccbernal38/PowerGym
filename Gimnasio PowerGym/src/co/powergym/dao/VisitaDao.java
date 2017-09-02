package co.powergym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import co.powergym.interfacedao.VisitaDaoInterface;
import co.powergym.model.Conexion;

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

}

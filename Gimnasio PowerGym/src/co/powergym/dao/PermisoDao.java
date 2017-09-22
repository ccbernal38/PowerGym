/**
 * 
 */
package co.powergym.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import co.powergym.interfacedao.PermisoDaoInterface;
import co.powergym.model.Conexion;
import co.powergym.model.Permiso;

/**
 * @author nia
 *
 */
public class PermisoDao implements PermisoDaoInterface{
	
	//Atributos
	Conexion conexion;

	/**
	 * Método constructor de la clase
	 */
	public PermisoDao() {
		conexion = new Conexion();
	}

	@Override
	public boolean registrarPermiso(String nombre, Date fechaCreacion, Date fechaModificacion) {
		boolean respuesta = false;
		try {
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD
					.prepareStatement("INSERT INTO Permiso(nombre, "
							+ "fechaCreacion, fechaModificacion) VALUES(?,?,?)");
			statement.setString(1, nombre);
			statement.setDate(2, fechaCreacion);
			statement.setDate(3, fechaModificacion);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(fechaCreacion);
			calendar.setTime(fechaModificacion);

			// statement.setInt(11, calendar.get(Calendar.DAY_OF_MONTH));
			// statement.setInt(12, calendar.get(Calendar.MONTH) + 1);
			// statement.setInt(13, calendar.get(Calendar.YEAR));
			statement.execute();
			respuesta = true;
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return respuesta;
	}

	@Override
	public ArrayList<Permiso> listaPermisos() {
		ArrayList<Permiso> list = new ArrayList<Permiso>();
		Permiso permiso;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,"
					+ "nombre, fechaCreacion, fechaModificacion "
					+ " FROM Permiso ORDER BY nombre ASC");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				permiso = new Permiso();
				permiso.setId(resultSet.getInt(1));
				permiso.setNombre(resultSet.getString(2));
				permiso.setFechaCreacion(resultSet.getDate(3));
				permiso.setFechaModificacion(resultSet.getDate(4));
				
				list.add(permiso);
			}
			conexion.desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean eliminarPermiso(int id) {
		boolean resultado = false;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement statement = connection.prepareStatement("DELETE FROM Permiso WHERE id = ?");
			statement.setInt(1, id);
			resultado = statement.execute();
			resultado = true;
			conexion.desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public boolean modificarPermiso(int id, String nombre, Date fechaCreacion, Date fechaModificacion) {
		boolean resultado = false;
		try {
			Connection connection = conexion.getConexion();

			PreparedStatement statement = connection.prepareStatement("UPDATE Permiso Set nombre = ?, "
						+ "fechaCreacion = ?, fechaModificacion = ? "
						+ "WHERE id = ?");				
				statement.setString(1, nombre);
				statement.setDate(2, fechaCreacion);
				statement.setDate(3, fechaModificacion);
				statement.execute();
				resultado = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public Permiso buscarPermiso(int id) {
		Permiso permiso = null;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT id, nombre, fechaCreacion, fechaModificacion"
							+ " FROM Permiso WHERE id = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				permiso = new Permiso();
				permiso.setId(resultSet.getInt(1));
				permiso.setNombre(resultSet.getString(2));
				permiso.setFechaCreacion(resultSet.getDate(3));
				permiso.setFechaModificacion(resultSet.getDate(4));
			}
			conexion.desconectar();
		} catch (Exception e) {
			System.out.println("error");
		}
		return permiso;
	}

}

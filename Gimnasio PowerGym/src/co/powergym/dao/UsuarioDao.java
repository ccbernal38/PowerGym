package co.powergym.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import co.powergym.interfacedao.UsuarioDaoInterface;
import co.powergym.model.Conexion;
import co.powergym.model.Usuario;

public class UsuarioDao implements UsuarioDaoInterface {

	Conexion conexion;

	public UsuarioDao() {
		conexion = new Conexion();
	}

	@Override
	public boolean registrarUsuario(String identificacion, String nombre, String apellido, Date fechaNacimiento,
			String telefono, String correo, int genero, String username, String password) {
		boolean respuesta = false;
		try {
			Connection accesoBD = conexion.getConexion();

			PreparedStatement statement = accesoBD.prepareStatement("INSERT INTO Usuario(identificacion, nombre, "
					+ "apellido, fechaNacimiento, correoElectronico, telefono, genero, username, password) VALUES(?,?,?,?,?,?,?,?,?)");
			statement.setString(1, identificacion);
			statement.setString(2, nombre);
			statement.setString(3, apellido);
			statement.setDate(4, new java.sql.Date(fechaNacimiento.getTime()));
			statement.setString(5, correo);
			statement.setString(6, telefono);
			statement.setInt(7, genero);
			statement.setString(8, username);
			statement.setString(9, password);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(fechaNacimiento);

			statement.execute();
			respuesta = true;
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return respuesta;
	}

	@Override
	public ArrayList<Usuario> listaUsuario() {
		ArrayList<Usuario> list = new ArrayList<Usuario>();
		Usuario usuario;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,"
					+ "identificacion, nombre, apellido, fechaNacimiento, correoElectronico, telefono, genero, username, password, direccion "
					+ " FROM Usuario");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				usuario = new Usuario();
				usuario.setId(resultSet.getInt(1));
				usuario.setIdentificacion(resultSet.getString(2));
				usuario.setNombre(resultSet.getString(3));
				usuario.setApellido(resultSet.getString(4));
				usuario.setFechaNacimiento(resultSet.getDate(5));
				usuario.setCorreo(resultSet.getString(6));
				usuario.setTelefono(resultSet.getString(7));
				usuario.setGenero(resultSet.getInt(8));
				usuario.setUsuario(resultSet.getString(9));
				usuario.setContrasena(resultSet.getString(10));
				usuario.setDireccion(resultSet.getString(11));
				list.add(usuario);
			}
			conexion.desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean eliminarUsuario(String identificacion) {
		boolean resultado = false;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement statement = connection.prepareStatement("DELETE FROM Usuario WHERE identificacion = ?");
			statement.setString(1, identificacion);
			resultado = statement.execute();
			resultado = true;
			conexion.desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public boolean modificarUsuario(String identificacion, String nombre, String apellido, Date fechaNacimiento,
			String telefono, String correo, int genero, String username, String password) {
		boolean resultado = false;
		try {
			Connection connection = conexion.getConexion();


			PreparedStatement statement = connection.prepareStatement("UPDATE Usuario Set nombre = ?, "
					+ "apellido = ?, fechaNacimiento = ?, correoElectronico = ?, telefono = ?, genero = ? "
					+ "WHERE identificacion = ?");
			statement.setString(1, nombre);
			statement.setString(2, apellido);
			statement.setDate(3, new java.sql.Date(fechaNacimiento.getTime()));
			statement.setString(4, correo);
			statement.setString(5, telefono);
			statement.setInt(6, genero);
			statement.setString(7, identificacion);
			statement.execute();
			resultado = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public Usuario buscarUsuario(String identificacion) {
		Usuario usuario = null;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, identificacion, nombre, "
					+ "apellido, correoElectronico, telefono, genero, username, password" + " FROM Usuario WHERE identificacion = ?");
			preparedStatement.setString(1, identificacion);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				usuario = new Usuario();
				usuario.setId(resultSet.getInt(1));
				usuario.setIdentificacion(resultSet.getString(2));
				usuario.setNombre(resultSet.getString(3));
				usuario.setApellido(resultSet.getString(4));
				usuario.setCorreo(resultSet.getString(5));
				usuario.setTelefono(resultSet.getString(6));
				usuario.setGenero(resultSet.getInt(7));
				usuario.setUsuario(resultSet.getString(8));
				usuario.setContrasena(resultSet.getString(9));
			}
			conexion.desconectar();
		} catch (Exception e) {
			System.out.println("error");
		}
		return usuario;
	}

	@Override
	public Usuario buscarUsuarioId(int id) {
		Usuario usuario = null;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, identificacion, nombre, "
					+ "apellido, correoElectronico, telefono, genero FROM Usuario WHERE id = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				usuario = new Usuario();
				usuario.setId(resultSet.getInt(1));
				usuario.setIdentificacion(resultSet.getString(2));
				usuario.setNombre(resultSet.getString(3));
				usuario.setApellido(resultSet.getString(4));
				usuario.setCorreo(resultSet.getString(5));
				usuario.setTelefono(resultSet.getString(6));
				usuario.setGenero(resultSet.getInt(7));
			}
			conexion.desconectar();
		} catch (Exception e) {
			System.out.println("error");
		}
		return usuario;
	}

}

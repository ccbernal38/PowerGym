package co.powergym.dao;
import java.sql.Connection;
import java.sql.Date;
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
	public boolean registrarUsuario(String identificacion, String nombre, 
			String apellido, Date fechaNacimiento, String telefono,String correo,
			int genero, String username, String password) {
		boolean respuesta = false;
		try {
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD
					.prepareStatement("INSERT INTO Usuario(username, password, "
							+ "identificacion, nombre, apellido, correoElectronico, telefono, genero, fechaNacimiento) VALUES(?,?,?,?,?,?,?,?,?)");
			
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setString(3, identificacion);
			statement.setString(4, nombre);
			statement.setString(5, apellido);
			statement.setString(6, correo);
			statement.setString(7, telefono);
			statement.setInt(8, genero);
			statement.setDate(9, fechaNacimiento);
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
					+ "identificacion, nombre, apellido, fechaNacimiento, correoElectronico, telefono, genero "
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
			PreparedStatement statement = connection
					.prepareStatement("DELETE FROM Usuario WHERE identificacion = ?");
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
	public boolean modificarUsuario(String identificacion, String nombre, 
			String apellido, Date fechaNacimiento, String telefono,String correo, 
			int genero, String username, String password) {
		boolean resultado = false;
		try {
			Connection connection = conexion.getConexion();

			PreparedStatement statement = connection.prepareStatement("UPDATE Usuario Set username = ?, "
						+ "password = ?, identificacion = ?, nombre = ?, apellido = ?, correoElectronico = ?, telefono = ?, genero = ?, fechaNacimiento = ? "
						+ "WHERE identificacion = ?");	
			
				statement.setString(1, username);
				statement.setString(2, password);
				statement.setString(3, identificacion);
				statement.setString(4, nombre);
				statement.setString(5,apellido );
				statement.setString(6, correo);
				statement.setString(7, telefono);
				statement.setInt(8, genero);
				statement.setDate(9, fechaNacimiento);
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
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT id, identificacion, nombre, "
							+ "apellido, correoElectronico, telefono, genero"
							+ " FROM Usuario WHERE identificacion = ?");
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
			}
			conexion.desconectar();
		} catch (Exception e) {
			System.out.println("error");
		}
		return usuario;
	}

}

package co.powergym.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import co.powergym.interfacedao.EntrenadorDaoInterface;
import co.powergym.model.Conexion;
import co.powergym.model.Entrenador;

public class EntrenadorDao implements EntrenadorDaoInterface {

	Conexion conexion;

	public EntrenadorDao() {
		conexion = new Conexion();
	}

	@Override
	public boolean registrarEntrenador(String identificacion, String primerNombre, String segundoNombre,
			String primerApellido, String segundoApellido, Date fechaNacimiento, String correo, String telefono,
			int genero, String username, String password) {
		boolean respuesta = false;
		try {
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD
					.prepareStatement("INSERT INTO Usuario(identificacion, primerNombre, segundoNombre,"
							+ "primerApellido, segundoApellido, fechaNacimiento, telefono, correoElectronico, genero, username, password) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			statement.setString(1, identificacion);
			statement.setString(2, primerNombre);
			statement.setString(3, segundoNombre);
			statement.setString(4, primerApellido);
			statement.setString(5, segundoApellido);
			statement.setDate(6, fechaNacimiento);
			statement.setString(7, telefono);
			statement.setString(8, correo);
			statement.setInt(9, genero);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(fechaNacimiento);

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
	public ArrayList<Entrenador> listaEntrenador() {
		ArrayList<Entrenador> list = new ArrayList<Entrenador>();
		Entrenador entrenador;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,"
					+ "identificacion, primerNombre, segundoNombre, primerApellido, segundoApellido, fechaNacimiento, telefono, correoElectronico, genero "
					+ " FROM Usuario");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				entrenador = new Entrenador();
				entrenador.setId(resultSet.getInt(1));
				entrenador.setIdentificacion(resultSet.getString(2));
				entrenador.setPrimerNombre(resultSet.getString(3));
				entrenador.setSegundoNombre(resultSet.getString(4));
				entrenador.setPrimerApellido(resultSet.getString(5));
				entrenador.setSegundoApellido(resultSet.getString(6));
				entrenador.setFechaNacimiento(resultSet.getDate(7));
				entrenador.setTelefono(resultSet.getString(8));
				entrenador.setCorreo(resultSet.getString(9));
				entrenador.setGenero(resultSet.getInt(10));
				list.add(entrenador);
			}
			conexion.desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean eliminarEntrenador(String identificacion) {
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
	public boolean modificarEntrenador(String identificacion, String primerNombre, String segundoNombre,
			String primerApellido, String segundoApellido, Date fechaNacimiento, String correo, String telefono,
			int genero, String username, String password) {
		boolean resultado = false;
		try {
			Connection connection = conexion.getConexion();

			PreparedStatement statement = connection.prepareStatement("UPDATE Usuario Set primerNombre = ?, segundoNombre = ?, "
						+ "primerApellido = ?, segundoApellido = ?, fechaNacimiento = ?, telefono = ?, correoElectronico = ?, genero = ? "
						+ "WHERE identificacion = ?");				
				statement.setString(1, primerNombre);
				statement.setString(2, segundoNombre);
				statement.setString(3, primerApellido);
				statement.setString(4, segundoApellido);
				statement.setDate(5, fechaNacimiento);
				statement.setString(6, telefono);
				statement.setString(7, correo);
				statement.setInt(8, genero);
				statement.setString(9, identificacion);
				statement.execute();
				resultado = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public Entrenador buscarEntrenador(String identificacion) {
		Entrenador entrenador = null;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT id, identificacion, primerNombre, segundoNombre,"
							+ "primerApellido, segundoApellido, telefono, correoElectronico, genero"
							+ " FROM Usuario WHERE identificacion = ?");
			preparedStatement.setString(1, identificacion);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				entrenador = new Entrenador();
				entrenador.setId(resultSet.getInt(1));
				entrenador.setIdentificacion(resultSet.getString(2));
				entrenador.setPrimerNombre(resultSet.getString(3));
				entrenador.setSegundoNombre(resultSet.getString(4));
				entrenador.setPrimerApellido(resultSet.getString(5));
				entrenador.setSegundoApellido(resultSet.getString(6));
				entrenador.setTelefono(resultSet.getString(7));
				entrenador.setCorreo(resultSet.getString(8));
				entrenador.setGenero(resultSet.getInt(9));
			}
			conexion.desconectar();
		} catch (Exception e) {
			System.out.println("error");
		}
		return entrenador;
	}

}

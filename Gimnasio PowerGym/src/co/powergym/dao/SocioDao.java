package co.powergym.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.powergym.interfacedao.SocioDaoInterface;
import co.powergym.model.Conexion;
import co.powergym.model.Socio;

public class SocioDao implements SocioDaoInterface{
	
	Conexion conexion;
	
	public SocioDao(){
		conexion = new Conexion();
	}

	@Override
	public boolean registrarSocio(String identificacion, Date fechaNacimiento, String primerNombre,
			String segundoNombre, String primerApellido, String segundoApellido, String correo, String telefono,
			int genero) {
		
		boolean respuesta = false;
		try {
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD.prepareStatement("INSERT INTO Socio(identificacion, primerNombre, segundoNombre,"
					+ "primerApellido, segundoApellido, fechaNacimiento, telefono, correoElectronico, genero) VALUES(?,?,?,?,?,?,?,?,?)");
			statement.setString(1, identificacion);
			statement.setString(2, primerNombre);
			statement.setString(3, segundoNombre);
			statement.setString(4, primerApellido);
			statement.setString(5, segundoApellido);
			statement.setDate(6, fechaNacimiento);
			statement.setString(7, telefono);
			statement.setString(8, correo);
			statement.setInt(9, genero);
			respuesta = true;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return respuesta;
	}

	@Override
	public List<Socio> listaSocios() {
		List<Socio> list = new ArrayList<Socio>();
		Socio socio;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from Socio");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				socio = new Socio();
				socio.setId(resultSet.getInt(1));
				socio.setIdentificacion(resultSet.getString(2));
				socio.setPrimerNombre(resultSet.getString(3));
				socio.setSegundoNombre(resultSet.getString(4));
				socio.setPrimerApellido(resultSet.getString(5));
				socio.setSegundoApellido(resultSet.getString(6));
				socio.setFechaNacimiento(resultSet.getDate(7));
				socio.setTelefono(resultSet.getString(8));
				socio.setCorreo(resultSet.getString(9));
				socio.setGenero(resultSet.getInt(10));
				list.add(socio);				
			}
		} catch (Exception e) {
		}
		return list;
	}

	@Override
	public boolean eliminarSocio(String identificacion) {
		boolean resultado = false;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement statement = connection.prepareStatement("DELETE FROM Socio WHERE identificacion = ?");
			statement.setString(1, identificacion);
			resultado = statement.execute();
		} catch (Exception e) {

		}
		return resultado;
		
		
	}

	@Override
	public boolean modificarSocio(String identificacion, Date fechaNacimiento, String primerNombre,
			String segundoNombre, String primerApellido, String segundoApellido, String correo, String telefono,
			int genero) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Socio buscarSocio(String identificacion) {
		Socio socio = null;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Socio WHERE identificacion = ?");
			preparedStatement.setString(1, identificacion);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			while (resultSet.next()) {
				socio = new Socio();
				socio.setId(resultSet.getInt(1));
				socio.setIdentificacion(resultSet.getString(2));
				socio.setPrimerNombre(resultSet.getString(3));
				socio.setSegundoNombre(resultSet.getString(4));
				socio.setPrimerApellido(resultSet.getString(5));
				socio.setSegundoApellido(resultSet.getString(6));
				socio.setFechaNacimiento(resultSet.getDate(7));
				socio.setTelefono(resultSet.getString(8));
				socio.setCorreo(resultSet.getString(9));
				socio.setGenero(resultSet.getInt(10));
			}
		} catch (Exception e) {
			System.out.println("error");
		}
		return socio;
	}
	
	

}

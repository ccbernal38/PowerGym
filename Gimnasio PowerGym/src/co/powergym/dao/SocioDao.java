package co.powergym.dao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.imageio.ImageIO;

import co.powergym.interfacedao.SocioDaoInterface;
import co.powergym.model.Conexion;
import co.powergym.model.Socio;

public class SocioDao implements SocioDaoInterface {

	Conexion conexion;

	public SocioDao() {
		conexion = new Conexion();
	}

	@Override
	public boolean registrarSocio(String identificacion, Date fechaNacimiento, String nombre, String apellido,
			String correo, String telefono, int genero, BufferedImage foto, byte[] tempHuella, String codigo)
			throws IOException {

		boolean respuesta = false;
		try {
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD.prepareStatement("INSERT INTO Socio(identificacion, nombre, "
					+ "apellido, fechaNacimiento, telefono, correoElectronico, genero, foto, diaNacimiento,"
					+ "mesNacimiento, anioNacimiento, huella, codigo) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			statement.setString(1, identificacion);
			statement.setString(2, nombre);
			statement.setString(3, apellido);
			statement.setDate(4, new java.sql.Date(fechaNacimiento.getTime()));
			statement.setString(5, telefono);
			statement.setString(6, correo);
			statement.setInt(7, genero);
			if (foto != null) {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(foto, "jpg", baos);
				byte[] imageInByte = baos.toByteArray();
				Blob blob = accesoBD.createBlob();
				blob.setBytes(1, imageInByte);
				statement.setBlob(8, blob);
			}

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(fechaNacimiento);

			statement.setInt(9, calendar.get(Calendar.DAY_OF_MONTH));
			statement.setInt(10, calendar.get(Calendar.MONTH) + 1);
			statement.setInt(11, calendar.get(Calendar.YEAR));
			statement.setBytes(12, tempHuella);
			statement.setString(13, codigo);
			statement.execute();
			respuesta = true;
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return respuesta;
	}

	@Override
	public List<Socio> listaSocios() {
		List<Socio> list = new ArrayList<Socio>();
		Socio socio;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, identificacion, nombre"
					+ ", apellido, fechaNacimiento, telefono, correoElectronico, genero, foto, huella, codigo" + " FROM Socio");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				socio = new Socio();
				socio.setId(resultSet.getInt(1));
				socio.setIdentificacion(resultSet.getString(2));
				socio.setNombre(resultSet.getString(3));
				socio.setApellido(resultSet.getString(4));
				socio.setFechaNacimiento(resultSet.getDate(5));
				socio.setTelefono(resultSet.getString(6));
				socio.setCorreo(resultSet.getString(7));
				socio.setGenero(resultSet.getInt(8));
				Blob resultfoto = resultSet.getBlob(9);
				if (resultfoto != null) {
					InputStream bufferedImage = resultfoto.getBinaryStream();
					socio.setFoto(ImageIO.read(bufferedImage));
				}
				socio.setHuella(resultSet.getBytes(10));
				socio.setCodigo(resultSet.getString(11));
				list.add(socio);

			}
			conexion.desconectar();
		} catch (Exception e) {
			e.printStackTrace();
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
			conexion.desconectar();
		} catch (Exception e) {

		}
		return resultado;

	}

	@Override
	public boolean modificarSocio(String identificacion, Date fechaNacimiento, String nombre,
			String apellido, String correo, String telefono, int genero) {
		boolean resultado = false;
		try {
			Connection connection = conexion.getConexion();

			PreparedStatement statement = connection.prepareStatement("UPDATE Socio Set identificacion = ?, fechaNacimiento = ?, "
					+ "nombre = ?, apellido = ?, correoElectronico = ?, telefono = ?, genero = ?"
					+ " WHERE identificacion = ?");
			statement.setString(1, identificacion);
			statement.setDate(2, new java.sql.Date(fechaNacimiento.getTime()));
			statement.setString(3, nombre);
			statement.setString(4, apellido);
			statement.setString(5, correo);
			statement.setString(6, telefono);
			statement.setInt(7, genero);
			statement.setString(8, identificacion);
			statement.execute();
			resultado = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public Socio buscarSocio(String key) {
		Socio socio = null;
		try {
			PreparedStatement preparedStatement = null;
			Connection connection = conexion.getConexion();

			String consulta = "SELECT id, identificacion, nombre, "
					+ "apellido, fechaNacimiento, telefono, correoElectronico, genero, foto"
					+ " FROM Socio WHERE identificacion = ?";
			preparedStatement = connection.prepareStatement(consulta);
			preparedStatement.setString(1, key);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				socio = new Socio();
				socio.setId(resultSet.getInt(1));
				socio.setIdentificacion(resultSet.getString(2));
				socio.setNombre(resultSet.getString(3));
				socio.setApellido(resultSet.getString(4));
				socio.setFechaNacimiento(resultSet.getDate(5));
				socio.setTelefono(resultSet.getString(6));
				socio.setCorreo(resultSet.getString(7));
				socio.setGenero(resultSet.getInt(8));
				Blob blob = resultSet.getBlob(9);
				if (blob != null) {
					InputStream bufferedImage = blob.getBinaryStream();
					socio.setFoto(ImageIO.read(bufferedImage));
				}
			}
			conexion.desconectar();
		} catch (Exception e) {
			System.out.println("error");
		}
		return socio;
	}

	@Override
	public List<Socio> sociosCumpleaniosMes() {
		List<Socio> list = new ArrayList<Socio>();
		Socio socio;
		Calendar calendar = Calendar.getInstance();
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, identificacion, nombre, "
					+ "apellido, fechaNacimiento, telefono, correoElectronico, genero, foto"
					+ " FROM Socio WHERE mesNacimiento = ?");
			int mes = calendar.get(Calendar.MONTH) + 1;
			preparedStatement.setInt(1, mes);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				socio = new Socio();
				socio.setId(resultSet.getInt(1));
				socio.setIdentificacion(resultSet.getString(2));
				socio.setNombre(resultSet.getString(3));
				socio.setApellido(resultSet.getString(4));
				socio.setFechaNacimiento(resultSet.getDate(5));
				socio.setTelefono(resultSet.getString(6));
				socio.setCorreo(resultSet.getString(7));
				socio.setGenero(resultSet.getInt(8));
				Blob blob = resultSet.getBlob(9);
				if (blob != null) {
					InputStream bufferedImage = resultSet.getBlob(10).getBinaryStream();
					socio.setFoto(ImageIO.read(bufferedImage));
				}

				list.add(socio);
			}
			conexion.desconectar();
		} catch (Exception e) {
		}
		return list;
	}

	@Override
	public Socio buscarSocio(int idSocio) {
		Socio socio = null;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, identificacion, nombre, "
					+ "apellido, fechaNacimiento, telefono, correoElectronico, genero, foto"
					+ " FROM Socio WHERE id = ?");
			preparedStatement.setInt(1, idSocio);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				socio = new Socio();
				socio.setId(resultSet.getInt(1));
				socio.setIdentificacion(resultSet.getString(2));
				socio.setNombre(resultSet.getString(3));
				socio.setApellido(resultSet.getString(4));
				socio.setFechaNacimiento(resultSet.getDate(5));
				socio.setTelefono(resultSet.getString(6));
				socio.setCorreo(resultSet.getString(7));
				socio.setGenero(resultSet.getInt(8));
				Blob blob = resultSet.getBlob(9);
				if (blob != null) {
					InputStream bufferedImage = blob.getBinaryStream();
					socio.setFoto(ImageIO.read(bufferedImage));
				}

			}
			conexion.desconectar();
		} catch (Exception e) {
			System.out.println("error");
		}
		return socio;
	}

	@Override
	public List<Socio> sociosCumpleaniosDia() {
		List<Socio> list = new ArrayList<Socio>();
		Socio socio;
		Calendar calendar = Calendar.getInstance();
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, identificacion, nombre, "
					+ "apellido, fechaNacimiento, telefono, correoElectronico, genero, foto"
					+ " FROM Socio WHERE mesNacimiento = ? AND diaNacimiento = ?");
			int mes = calendar.get(Calendar.MONTH) + 1;
			int dia = calendar.get(Calendar.DAY_OF_MONTH);
			preparedStatement.setInt(1, mes);
			preparedStatement.setInt(2, dia);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				socio = new Socio();
				socio.setId(resultSet.getInt(1));
				socio.setIdentificacion(resultSet.getString(2));
				socio.setNombre(resultSet.getString(3));
				socio.setApellido(resultSet.getString(4));
				socio.setFechaNacimiento(resultSet.getDate(5));
				socio.setTelefono(resultSet.getString(6));
				socio.setCorreo(resultSet.getString(7));
				socio.setGenero(resultSet.getInt(8));
				Blob blob = resultSet.getBlob(9);
				if (blob != null) {
					InputStream bufferedImage = blob.getBinaryStream();
					socio.setFoto(ImageIO.read(bufferedImage));
				}
				list.add(socio);
			}
			conexion.desconectar();
		} catch (Exception e) {
		}
		return list;
	}

	@Override
	public List<Socio> buscarSocioKey(String key) {
		List<Socio> socios = new ArrayList<>();
		Socio socio = null;
		try {
			PreparedStatement preparedStatement = null;
			Connection connection = conexion.getConexion();
			if (key.length() == 4 && key.chars().allMatch(Character::isDigit)) {
				preparedStatement = connection.prepareStatement("SELECT id, identificacion, nombre, "
						+ "apellido, fechaNacimiento, telefono, correoElectronico, genero, foto"
						+ " FROM Socio WHERE codigo = ?");
				preparedStatement.setInt(1, Integer.parseInt(key));
			} else {
				String consulta = "SELECT id, identificacion, nombre, "
						+ "apellido, fechaNacimiento, telefono, correoElectronico, genero, foto"
						+ " FROM Socio WHERE identificacion = '" + key + "' OR nombre LIKE '%" + key
						+ "%' OR apellido LIKE '%" + key + "%'";
				preparedStatement = connection.prepareStatement(consulta);
			}

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				socio = new Socio();
				socio.setId(resultSet.getInt(1));
				socio.setIdentificacion(resultSet.getString(2));
				socio.setNombre(resultSet.getString(3));
				socio.setApellido(resultSet.getString(4));
				socio.setFechaNacimiento(resultSet.getDate(5));
				socio.setTelefono(resultSet.getString(6));
				socio.setCorreo(resultSet.getString(7));
				socio.setGenero(resultSet.getInt(8));
				Blob blob = resultSet.getBlob(9);
				if (blob != null) {
					InputStream bufferedImage = blob.getBinaryStream();
					socio.setFoto(ImageIO.read(bufferedImage));
				}
				socios.add(socio);

			}
			conexion.desconectar();
		} catch (Exception e) {
			System.out.println("error");
		}
		return socios;
	}

	@Override
	public int contarSocios() {
		int cantSocios = 0;
		try {
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD.prepareStatement("Select count(*) from Socio");
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				cantSocios = resultSet.getInt(1);
			}
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cantSocios;
	}

	@Override
	public Socio buscarSocioIdOrCodigo(String id) {
		Socio socio = null;
		try {
			PreparedStatement preparedStatement = null;
			Connection connection = conexion.getConexion();

			String consulta = "SELECT id, identificacion, nombre, "
					+ "apellido, fechaNacimiento, telefono, correoElectronico, genero, foto"
					+ " FROM Socio WHERE identificacion = ? OR codigo = ?";
			preparedStatement = connection.prepareStatement(consulta);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, id);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				socio = new Socio();
				socio.setId(resultSet.getInt(1));
				socio.setIdentificacion(resultSet.getString(2));
				socio.setNombre(resultSet.getString(3));
				socio.setApellido(resultSet.getString(4));
				socio.setFechaNacimiento(resultSet.getDate(5));
				socio.setTelefono(resultSet.getString(6));
				socio.setCorreo(resultSet.getString(7));
				socio.setGenero(resultSet.getInt(8));
				Blob blob = resultSet.getBlob(9);
				if (blob != null) {
					InputStream bufferedImage = blob.getBinaryStream();
					socio.setFoto(ImageIO.read(bufferedImage));
				}
			}
			conexion.desconectar();
		} catch (Exception e) {
			System.out.println("error");
		}
		return socio;
	}

}

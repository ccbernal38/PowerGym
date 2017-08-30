package co.powergym.dao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
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
	public boolean registrarSocio(String identificacion, Date fechaNacimiento, String primerNombre,
			String segundoNombre, String primerApellido, String segundoApellido, String correo, String telefono,
			int genero, BufferedImage foto, byte[] tempHuella) throws IOException {

		boolean respuesta = false;
		try {
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD
					.prepareStatement("INSERT INTO Socio(identificacion, primerNombre, segundoNombre,"
							+ "primerApellido, segundoApellido, fechaNacimiento, telefono, correoElectronico, genero, foto, diaNacimiento,"
							+ "mesNacimiento, anioNacimiento, huella) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			statement.setString(1, identificacion);
			statement.setString(2, primerNombre);
			statement.setString(3, segundoNombre);
			statement.setString(4, primerApellido);
			statement.setString(5, segundoApellido);
			statement.setDate(6, new java.sql.Date(fechaNacimiento.getTime()));
			statement.setString(7, telefono);
			statement.setString(8, correo);
			statement.setInt(9, genero);
			if (foto != null) {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(foto, "jpg", baos);
				byte[] imageInByte = baos.toByteArray();
				Blob blob = accesoBD.createBlob();
				blob.setBytes(1, imageInByte);
				statement.setBlob(10, blob);
			}

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(fechaNacimiento);

			statement.setInt(11, calendar.get(Calendar.DAY_OF_MONTH));
			statement.setInt(12, calendar.get(Calendar.MONTH) + 1);
			statement.setInt(13, calendar.get(Calendar.YEAR));
			statement.setBytes(14, tempHuella);
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
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, identificacion, primerNombre"
					+ ", segundoNombre, primerApellido, segundoApellido, fechaNacimiento, telefono, correoElectronico, genero, foto, huella"
					+ " FROM Socio");
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
				Blob resultfoto = resultSet.getBlob(11);
				if (resultfoto != null) {
					InputStream bufferedImage = resultfoto.getBinaryStream();
					socio.setFoto(ImageIO.read(bufferedImage));
				}
				socio.setHuella(resultSet.getBytes(12));
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
	public boolean modificarSocio(String identificacion, Date fechaNacimiento, String primerNombre,
			String segundoNombre, String primerApellido, String segundoApellido, String correo, String telefono,
			int genero) {
		return false;
	}

	@Override
	public Socio buscarSocio(String identificacion) {
		Socio socio = null;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT id, identificacion, primerNombre, segundoNombre,"
							+ "primerApellido, segundoApellido, fechaNacimiento, telefono, correoElectronico, genero, foto"
							+ " FROM Socio WHERE identificacion = ?");
			preparedStatement.setString(1, identificacion);
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
				Blob blob = resultSet.getBlob(11);
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
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT id, identificacion, primerNombre, segundoNombre,"
							+ "primerApellido, segundoApellido, fechaNacimiento, telefono, correoElectronico, genero, foto"
							+ " FROM Socio WHERE mesNacimiento = ?");
			int mes = calendar.get(Calendar.MONTH) + 1;
			preparedStatement.setInt(1, mes);
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
				Blob blob = resultSet.getBlob(11);
				if (blob != null) {
					InputStream bufferedImage = resultSet.getBlob(11).getBinaryStream();
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
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT id, identificacion, primerNombre, segundoNombre,"
							+ "primerApellido, segundoApellido, fechaNacimiento, telefono, correoElectronico, genero, foto"
							+ " FROM Socio WHERE id = ?");
			preparedStatement.setInt(1, idSocio);
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
				Blob blob = resultSet.getBlob(11);
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
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT id, identificacion, primerNombre, segundoNombre,"
							+ "primerApellido, segundoApellido, fechaNacimiento, telefono, correoElectronico, genero, foto"
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
				socio.setPrimerNombre(resultSet.getString(3));
				socio.setSegundoNombre(resultSet.getString(4));
				socio.setPrimerApellido(resultSet.getString(5));
				socio.setSegundoApellido(resultSet.getString(6));
				socio.setFechaNacimiento(resultSet.getDate(7));
				socio.setTelefono(resultSet.getString(8));
				socio.setCorreo(resultSet.getString(9));
				socio.setGenero(resultSet.getInt(10));
				Blob blob = resultSet.getBlob(11);
				if (blob != null) {
					InputStream bufferedImage = resultSet.getBlob(11).getBinaryStream();
					socio.setFoto(ImageIO.read(bufferedImage));
				}
				list.add(socio);
			}
			conexion.desconectar();
		} catch (Exception e) {
		}
		return list;
	}

}

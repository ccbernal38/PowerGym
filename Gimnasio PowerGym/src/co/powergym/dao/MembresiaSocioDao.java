package co.powergym.dao;

import java.io.ByteArrayOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import javax.imageio.ImageIO;

import co.powergym.interfacedao.MembresiaSocioDaoInterface;
import co.powergym.model.Conexion;

public class MembresiaSocioDao implements MembresiaSocioDaoInterface {

	Conexion conexion;

	public MembresiaSocioDao() {

		conexion = new Conexion();
	}

	@Override
	public boolean registrarMembresiaSocio(int codigoMembresia, int idSocio, Date fecha, boolean isActivo) {

		boolean respuesta = false;
		try {
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD
					.prepareStatement("INSERT INTO MembresiaSocio(Socio_id, Membresia_id, ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			statement.setString(1, identificacion);
			statement.setString(2, primerNombre);
			statement.setString(3, segundoNombre);
			statement.setString(4, primerApellido);
			statement.setString(5, segundoApellido);
			statement.setDate(6, fechaNacimiento);
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
			statement.execute();
			respuesta = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return respuesta;
	}

	@Override
	public boolean modificarMembresiaSocio(int id, int codigoMembresia, int idSocio, boolean isActivo) {
		// TODO Auto-generated method stub
		return false;
	}

}

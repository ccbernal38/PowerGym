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

package co.powergym.dao;

import java.io.ByteArrayOutputStream;
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

import co.powergym.interfacedao.MembresiaSocioDaoInterface;
import co.powergym.model.Conexion;
import co.powergym.model.DiaSemana;
import co.powergym.model.Membresia;
import co.powergym.model.MembresiaSocio;
import co.powergym.model.Pago;
import co.powergym.model.Socio;

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
			PreparedStatement statement = accesoBD.prepareStatement(
					"INSERT INTO Membresia_Socio(Socio_id, Membresia_id, fecha, activa) " + "VALUES(?,?,?,?)");
			statement.setInt(1, idSocio);
			statement.setInt(2, codigoMembresia);
			statement.setDate(3, (java.sql.Date) fecha);
			statement.setBoolean(4, isActivo);
			statement.execute();
			respuesta = true;
			conexion.desconectar();
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

	@Override
	public List<MembresiaSocio> historialMembresias(int idSocio) {
		List<MembresiaSocio> list = new ArrayList<MembresiaSocio>();
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"SELECT ms.id as id, ms.fechaInicio as fechaInicio, ms.fechafin as fechaFin, ms.activa as activa, "
					+ "ms.membresia_id as idMembresia, ms.pago_id as idPago "
					+ "FROM Membresia_socio ms "
					+ "WHERE ms.socio_id = ? ORDER BY ms.fechaInicio DESC");
			preparedStatement.setInt(1, idSocio);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				MembresiaSocio memSocio = new MembresiaSocio();
				memSocio.setId(resultSet.getInt("id"));
				memSocio.setFechaInicial(resultSet.getDate("fechaInicio"));
				memSocio.setFechaFinal(resultSet.getDate("fechaFin"));
				
				if(resultSet.getInt("activa") == 1)
					memSocio.setActiva(true);
				else
					memSocio.setActiva(false);
				
				Membresia mem = new Membresia();
				mem.setId(resultSet.getInt("idMembresia"));
				memSocio.setMembresia(mem);
				
				Pago pago = new Pago();
				String idPago = resultSet.getString("idPago");
				if(idPago != null) {
					pago.setId(Integer.parseInt(idPago));
					memSocio.setPago(pago);	
				}
				
				
				list.add(memSocio);			
			}
			conexion.desconectar();
			
			for (MembresiaSocio ms : list) {
				int idMembresia = ms.getMembresia().getId();
				ms.setMembresia(new MembresiaDao().buscarMembresia(idMembresia));
				ms.setSocio(new SocioDao().buscarSocio(idSocio));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	

}

package co.powergym.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.powergym.interfacedao.MembresiaSocioDaoInterface;
import co.powergym.model.Conexion;
import co.powergym.model.Membresia;
import co.powergym.model.MembresiaSocio;
import co.powergym.model.Factura;

public class MembresiaSocioDao implements MembresiaSocioDaoInterface {

	Conexion conexion;

	public MembresiaSocioDao() {

		conexion = new Conexion();
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
							+ "ms.membresia_id as idMembresia " + "FROM Membresia_socio ms "
							+ "WHERE ms.socio_id = ? ORDER BY ms.fechaInicio DESC");
			preparedStatement.setInt(1, idSocio);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				MembresiaSocio memSocio = new MembresiaSocio();
				memSocio.setId(resultSet.getInt("id"));
				memSocio.setFechaInicial(resultSet.getDate("fechaInicio"));
				memSocio.setFechaFinal(resultSet.getDate("fechaFin"));

				if (resultSet.getInt("activa") == 1)
					memSocio.setActiva(true);
				else
					memSocio.setActiva(false);

				Membresia mem = new Membresia();
				mem.setId(resultSet.getInt("idMembresia"));
				memSocio.setMembresia(mem);

				Factura pago = new Factura();

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

	@Override
	public boolean registrarMembresiaSocio(int codigoMembresia, int idSocio, Date fechaInicio, Date fechaFin,
			int descuento, int renovar, int caja_id, int valor) {
		boolean respuesta = false;
		try {
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD.prepareStatement(
					"INSERT INTO Membresia_Socio(Socio_id, Membresia_id, fechaInicio, fechaFin, descuento, renovar, caja_id, valor) "
							+ "VALUES(?,?,?,?,?,?,?,?)");
			statement.setInt(1, idSocio);
			statement.setInt(2, codigoMembresia);
			statement.setDate(3, new java.sql.Date(fechaInicio.getTime()));
			statement.setDate(4, new java.sql.Date(fechaFin.getTime()));
			statement.setInt(5, descuento);
			statement.setInt(6, renovar);
			statement.setInt(7, caja_id);
			statement.setInt(8, valor);
			statement.execute();
			respuesta = true;
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return respuesta;
	}

	@Override
	public boolean eliminarMembresiaSocio(int id) {
		boolean resultado = false;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement statement = connection.prepareStatement("DELETE FROM Membresia_Socio WHERE id = ?");
			statement.setInt(1, id);
			resultado = statement.execute();
			resultado = true;
			conexion.desconectar();
		} catch (Exception e) {

		}
		return resultado;
	}

	@Override
	public int valorPagado(int id) {
		int valor = 0;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT valor FROM Membresia_socio WHERE id = ?");
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				valor = resultSet.getInt(1);
			}
			conexion.desconectar();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return valor;
	}

}

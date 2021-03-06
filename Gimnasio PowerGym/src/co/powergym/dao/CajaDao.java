package co.powergym.dao;

import java.io.ByteArrayOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import co.powergym.interfacedao.CajaInterfaceDao;
import co.powergym.model.Caja;
import co.powergym.model.Conexion;
import co.powergym.model.Membresia;
import co.powergym.model.MembresiaSocio;
import co.powergym.model.Movimiento;
import co.powergym.model.Socio;

public class CajaDao implements CajaInterfaceDao {

	Conexion conexion;

	public CajaDao() {
		conexion = new Conexion();
	}

	@Override
	public boolean aperturaCaja(int responsableApertura, Date fechaApertura, int saldoInicial) {

		boolean respuesta = false;
		try {
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD
					.prepareStatement("INSERT INTO Caja(saldoInicial, usuario_id_apertura, estado) values(?, ?, ?)");
			statement.setInt(1, saldoInicial);
			statement.setInt(2, responsableApertura);
			statement.setInt(3, Caja.ABIERTA);

			statement.execute();
			respuesta = true;
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return respuesta;
	}

	@Override
	public int verificarCajaAbierta() {
		int id = -1;
		try {
			Calendar calendar = Calendar.getInstance();
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD.prepareStatement(
					"SELECT id FROM Caja WHERE DAY(fechaApertura) = ? AND MONTH(fechaApertura) = ? AND YEAR(fechaApertura) = ? AND estado = ? "
							+ "ORDER BY id DESC LIMIT 1");

			statement.setInt(1, calendar.get(Calendar.DAY_OF_MONTH));
			statement.setInt(2, calendar.get(Calendar.MONTH) + 1);
			statement.setInt(3, calendar.get(Calendar.YEAR));
			statement.setInt(4, Caja.ABIERTA);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				id = resultSet.getInt(1);
			}
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return id;
	}

	@Override
	public List<MembresiaSocio> ventasDelDia() {
		List<MembresiaSocio> list = new ArrayList<>();
		try {
			Calendar calendar = Calendar.getInstance();
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD.prepareStatement(
					"SELECT CONCAT(s.nombre,' ', s.apellido), m.nombre, ms.valor, ms.descuento, ms.fechaCreacion "
							+ "FROM membresia_socio as ms JOIN Socio as s ON ms.socio_id = s.id "
							+ "JOIN Membresia m ON m.id = ms.membresia_id "
							+ "WHERE MONTH(ms.fechaCreacion) = ? AND YEAR(ms.fechaCreacion) = ? AND DAY(ms.fechaCreacion) = ?");
			statement.setInt(1, calendar.get(Calendar.MONTH) + 1);
			statement.setInt(2, calendar.get(Calendar.YEAR));
			statement.setInt(3, calendar.get(Calendar.DAY_OF_MONTH));
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				MembresiaSocio membresiaSocio = new MembresiaSocio();
				Socio socio = new Socio();
				socio.setNombre(resultSet.getString(1));
				membresiaSocio.setSocio(socio);
				Membresia membresia = new Membresia();
				membresia.setNombre(resultSet.getString(2));
				membresiaSocio.setValor(resultSet.getInt(3));
				membresiaSocio.setDescuento(resultSet.getInt(4));
				membresiaSocio.setFechaInicial(resultSet.getTimestamp(5));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return list;
	}

	@Override
	public Caja ultimoRegistro() {
		Caja caja = null;
		try {
			Calendar calendar = Calendar.getInstance();
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD
					.prepareStatement("SELECT c.id, c.fechaApertura, c.usuario_id_apertura, c.estado, "
							+ "c.totalEgresos, c.totalMembresias, c.totalVisitas "
							+ "FROM Caja as c WHERE c.estado = ?");
			statement.setInt(1, Caja.ABIERTA);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				caja = new Caja();
				caja.setId(resultSet.getInt(1));
				Date date = resultSet.getTimestamp(2);
				caja.setFechaApertura(date);
				System.out.println(caja.getFechaApertura());
				caja.setResponsableApertura(resultSet.getInt(3));
				caja.setEstado(resultSet.getInt(4));
				caja.setTotalEgresos(resultSet.getInt(5));
				caja.setTotalMembresias(resultSet.getInt(6));
				caja.setTotalVisitas(resultSet.getInt(7));
			}
			return caja;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return caja;
	}

	@Override
	public int totalVentasMembresiasDia(int caja_id) {
		int caja = 0;
		try {
			Calendar calendar = Calendar.getInstance();
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD.prepareStatement("SELECT SUM(valor) FROM membresia_socio "
					+ "WHERE YEAR(fechaCreacion) = ? AND MONTH(fechaCreacion) = ? AND DAY(fechaCreacion) = ? AND caja_id = ?;");
			statement.setInt(1, calendar.get(Calendar.YEAR));
			statement.setInt(2, calendar.get(Calendar.MONTH) + 1);
			statement.setInt(3, calendar.get(Calendar.DAY_OF_MONTH));
			statement.setInt(4, caja_id);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				caja = resultSet.getInt(1);
			}
			return caja;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return caja;
	}

	@Override
	public int totalVentasVisitasDia(int caja_id) {
		int caja = 0;
		try {
			Calendar calendar = Calendar.getInstance();
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD.prepareStatement("SELECT SUM(valor) FROM visita "
					+ "WHERE YEAR(fechaCreacion) = ? AND MONTH(fechaCreacion) = ? AND DAY(fechaCreacion) = ? AND caja_id = ?;");
			statement.setInt(1, calendar.get(Calendar.YEAR));
			statement.setInt(2, calendar.get(Calendar.MONTH) + 1);
			statement.setInt(3, calendar.get(Calendar.DAY_OF_MONTH));
			statement.setInt(4, caja_id);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				caja = resultSet.getInt(1);
			}
			return caja;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return caja;
	}

	@Override
	public int totalEgresosDia(int caja_id) {
		int caja = 0;
		try {
			Calendar calendar = Calendar.getInstance();
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD.prepareStatement("SELECT SUM(valor) FROM movimiento "
					+ "WHERE YEAR(fechaCreacion) = ? AND MONTH(fechaCreacion) = ? AND DAY(fechaCreacion) = ? AND caja_id = ?;");
			statement.setInt(1, calendar.get(Calendar.YEAR));
			statement.setInt(2, calendar.get(Calendar.MONTH) + 1);
			statement.setInt(3, calendar.get(Calendar.DAY_OF_MONTH));
			statement.setInt(4, caja_id);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				caja = resultSet.getInt(1);
			}
			return caja;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return caja;
	}

	@Override
	public boolean cerrarCaja(int caja_id, int usuario_cierre, int totalEgresos, int totalMembresia, int totalVisita,
			int dineroCaja) {
		boolean respuesta = false;
		try {
			Connection conn = conexion.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE Caja SET usuario_id_cierre = ?, totalEgresos = ?, totalMembresias = ?, totalVisitas = ?, saldoFinal = ?, fechaCierre = ?, estado = 0"
							+ " WHERE id = ?;");

			ps.setInt(1, usuario_cierre);
			ps.setInt(2, totalEgresos);
			ps.setInt(3, totalMembresia);
			ps.setInt(4, totalVisita);
			ps.setInt(5, dineroCaja);
			ps.setTimestamp(6, new Timestamp(Calendar.getInstance().getTime().getTime()));
			ps.setInt(7, caja_id);

			// call executeUpdate to execute our sql update statement
			ps.executeUpdate();
			respuesta = true;
			ps.close();
		} catch (SQLException se) {
			// log the exception
			return respuesta;
		}
		return respuesta;
	}
}

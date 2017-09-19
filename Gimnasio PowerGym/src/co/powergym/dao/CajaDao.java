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
			PreparedStatement statement = accesoBD.prepareStatement(
					"INSERT INTO Caja(fechaApertura, saldoInicial, usuario_id_apertura, estado) values(?, ?, ?, ?)");
			statement.setTimestamp(1, new Timestamp(fechaApertura.getTime()));
			statement.setInt(2, saldoInicial);
			statement.setInt(3, responsableApertura);
			statement.setInt(4, Caja.ABIERTA);

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
			PreparedStatement statement = accesoBD
					.prepareStatement("SELECT id FROM Caja WHERE fechaApertura = ? AND estado = ?");
			statement.setDate(1, new java.sql.Date(calendar.getTimeInMillis()));
			statement.setInt(2, Caja.ABIERTA);
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
				caja.setFechaApertura(resultSet.getDate(2));
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
	public int totalVentasMembresiasDia() {
		int caja = 0;
		try {
			Calendar calendar = Calendar.getInstance();
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD.prepareStatement("SELECT SUM(valor) FROM membresia_socio "
					+ "WHERE YEAR(fechaCreacion) = ? AND MONTH(fechaCreacion) = ? AND DAY(fechaCreacion) = ?;");
			statement.setInt(1, calendar.get(Calendar.YEAR));
			statement.setInt(2, calendar.get(Calendar.MONTH) + 1);
			statement.setInt(3, calendar.get(Calendar.DAY_OF_MONTH));
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
}

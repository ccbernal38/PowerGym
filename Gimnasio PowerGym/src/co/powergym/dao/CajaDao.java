package co.powergym.dao;

import java.io.ByteArrayOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;

import co.powergym.interfacedao.CajaInterfaceDao;
import co.powergym.model.Caja;
import co.powergym.model.Conexion;

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
			e.printStackTrace();
		}

		return id;
	}

}

package co.powergym.dao;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;

import co.powergym.interfacedao.ReciboInterfaceDao;
import co.powergym.model.Conexion;
import co.powergym.model.Socio;

public class ReciboDao implements ReciboInterfaceDao {

	private Conexion conexion;

	public ReciboDao() {
		conexion = new Conexion();
	}

	@Override
	public int numeroFactura() {
		int id = 1;
		try {
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD.prepareStatement("SELECT id FROM factura ORDER BY id DESC LIMIT 1;");
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				id = resultSet.getInt(1);
			}
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;

	}

	@Override
	public boolean registrarFactura(Date fecha, int socio, int usuario, String descripcion, int pago,
			int usadoSaldoFavor, int debe, int saldoFavor) {
		boolean respuesta = false;
		try {
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD.prepareStatement("INSERT INTO Factura(fecha, descripcion, "
					+ "paga, usadoSaldoFavor, debe, saldoFavor, socio_id, usuario_id"
					+ ") VALUES(?,?,?,?,?,?,?,?)");
			statement.setTimestamp(1, new Timestamp(fecha.getTime()));
			statement.setString(2, descripcion);
			statement.setInt(3, pago);
			statement.setInt(4, usadoSaldoFavor);
			statement.setInt(5, debe);
			statement.setInt(6, saldoFavor);
			statement.setInt(7, socio);
			statement.setInt(8, usuario);
			
			statement.execute();
			respuesta = true;
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return respuesta;
	}

}

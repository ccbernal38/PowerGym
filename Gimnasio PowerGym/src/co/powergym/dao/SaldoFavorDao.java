package co.powergym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.powergym.interfacedao.SaldoFavorInterfaceDao;
import co.powergym.model.Conexion;

public class SaldoFavorDao implements SaldoFavorInterfaceDao {

	Conexion conexion;

	public SaldoFavorDao() {
		conexion = new Conexion();
	}

	@Override
	public boolean registrarSaldoFavor(int valor, int socio_id, int caja_id) {
		boolean respuesta = false;
		try {
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD
					.prepareStatement("INSERT INTO SaldoAFavor(valor, socio_id, caja_id) VALUES(?,?,?)");
			statement.setInt(1, valor);
			statement.setInt(2, socio_id);
			statement.setInt(3, caja_id);

			statement.execute();
			respuesta = true;
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return respuesta;
	}

	@Override
	public int saldoFavorSocio(int socio_id) {
		int valor = 0;
		try {
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD
					.prepareStatement("SELECT COALESCE(SUM(valor),0) FROM SaldoAFavor WHERE socio_id = ?;");
			statement.setInt(1, socio_id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				valor = resultSet.getInt(1);
			}
			return valor;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return valor;
	}

}
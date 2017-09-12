package co.powergym.dao;

import java.io.ByteArrayOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import javax.imageio.ImageIO;

import co.powergym.interfacedao.MovimientoDaoInterface;
import co.powergym.model.Conexion;
import co.powergym.model.Movimiento;
import co.powergym.utils.Constantes;

public class MovimientoDao implements MovimientoDaoInterface {

	Conexion conexion;

	public MovimientoDao() {
		conexion = new Conexion();
	}

	@Override
	public boolean registrarIngreso(String concepto, int valor, int caja_id) {
		boolean respuesta = false;
		try {
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD
					.prepareStatement("INSERT INTO Movimiento(concepto, valor, caja_id, tipo) VALUES(?,?,?,?)");
			statement.setString(1, concepto);
			statement.setInt(2, valor);
			statement.setInt(3, caja_id);
			statement.setInt(4, Movimiento.INGRESO);

			statement.execute();
			respuesta = true;
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return respuesta;
	}

	@Override
	public boolean registrarEgreso(String concepto, int valor, int caja_id) {
		boolean respuesta = false;
		try {
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD
					.prepareStatement("INSERT INTO Movimiento(concepto, valor, caja_id, tipo) VALUES(?,?,?,?)");
			statement.setString(1, concepto);
			statement.setInt(2, valor);
			statement.setInt(3, caja_id);
			statement.setInt(4, Movimiento.EGRESO);

			statement.execute();
			respuesta = true;
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return respuesta;
	}

}

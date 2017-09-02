/**
 * 
 */
package co.powergym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import co.powergym.interfacedao.DiaMembresiaDaoInterface;
import co.powergym.model.Conexion;

/**
 * @author crisd
 *
 */
public class DiaMembresiaDao implements DiaMembresiaDaoInterface {

	Conexion conexion;
	/**
	 * 
	 */
	public DiaMembresiaDao() {
		
		conexion = new Conexion();
	}

	@Override
	public boolean regitrarDiaMembresia(int idDia, int idMembresia) {
		
		boolean respuesta = false;
		try {
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD
					.prepareStatement("INSERT INTO membresia_diasemana(Membresia_id, DiasSemana_id) VALUES(?,?)");
			statement.setInt(1, idMembresia);
			statement.setInt(2, idDia);
			statement.execute();
			respuesta = true;
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return respuesta;
	}

}

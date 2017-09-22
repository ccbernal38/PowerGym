/**
 * 
 */
package co.powergym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.powergym.interfacedao.PermisoUsuarioDaoInterface;
import co.powergym.interfacedao.RolAsignadoDaoInterface;
import co.powergym.model.Conexion;
import co.powergym.model.PermisoUsuario;

/**
 * @author nia
 *
 */
public class RolUsuarioDao implements RolAsignadoDaoInterface {
	
	//Atributos
	Conexion conexion;
	/**
	 * 
	 */
	public RolUsuarioDao() {
		conexion = new Conexion();
	}

	@Override
	public boolean registrarRolUsuario(int usuario_id, int rol_id) {
		boolean respuesta = false;
		try {
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD.prepareStatement(
					"INSERT INTO rolasignado(usuario_id, rol_id) VALUES(?,?)");
			statement.setInt(1, usuario_id);
			statement.setInt(2, rol_id);
			statement.execute();
			respuesta = true;
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return respuesta;
	}

	

	

}

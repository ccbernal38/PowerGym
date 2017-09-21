/**
 * 
 */
package co.powergym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.powergym.interfacedao.PermisoUsuarioDaoInterface;
import co.powergym.model.Conexion;
import co.powergym.model.PermisoUsuario;

/**
 * @author nia
 *
 */
public class PermisoUsuarioDao implements PermisoUsuarioDaoInterface {
	
	//Atributos
	Conexion conexion;
	/**
	 * 
	 */
	public PermisoUsuarioDao() {
		conexion = new Conexion();
	}

	@Override
	public boolean registrarPermisoUsuario(int usuario_id, int permiso_id) {
		boolean respuesta = false;
		try {
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD.prepareStatement(
					"INSERT INTO permisoasignado(usuario_id, permiso_id) VALUES(?,?)");
			statement.setInt(1, usuario_id);
			statement.setInt(2, permiso_id);
			statement.execute();
			respuesta = true;
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return respuesta;
	}

	@Override
	public ArrayList<PermisoUsuario> listaPermisoUsuario() {
		ArrayList<PermisoUsuario> list = new ArrayList<PermisoUsuario>();
		PermisoUsuario permisoUsuario;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT usuario_id,"
					+ "permiso_id "
					+ " FROM permisoasignado");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				permisoUsuario = new PermisoUsuario();
				permisoUsuario.setUsuario_id(resultSet.getInt(1));
				permisoUsuario.setPermiso_id(resultSet.getInt(2));
				
				list.add(permisoUsuario);
			}
			conexion.desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public boolean modificarUsuario(int usuario_id, int permiso_id) {
		// TODO Auto-generated method stub
		return false;
	}

	

}

/**
 * 
 */
package co.powergym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import co.powergym.interfacedao.LoginInterfaceDao;
import co.powergym.model.Conexion;
import co.powergym.model.Rol;
import co.powergym.model.Usuario;

/**
 * @author nia
 *
 */
public class LoginDao implements LoginInterfaceDao {

	Conexion conexion;

	public LoginDao() {
		conexion = new Conexion();
	}

	@Override
	public Usuario inicioSesion(String username, String password) {
		Usuario usuario = null;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection.prepareStatement(

					"SELECT  user.id, user.identificacion, user.nombre, user.apellido, "
							+ "user.fechaNacimiento, user.telefono, "
							+ "user.correoElectronico, user.genero, r.id, r.nombre, user.username FROM Usuario AS user "
							+ "JOIN RolAsignado AS ra ON ra.usuario_id = user.id "
							+ "JOIN Rol AS r ON r.id = ra.rol_id " + "WHERE username=? AND password=?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				usuario = new Usuario();
				usuario.setId(resultSet.getInt(1));
				usuario.setIdentificacion(resultSet.getString(2));
				usuario.setNombre(resultSet.getString(3));
				usuario.setApellido(resultSet.getString(4));
				usuario.setFechaNacimiento(resultSet.getDate(5));
				usuario.setTelefono(resultSet.getString(6));
				usuario.setCorreo(resultSet.getString(7));
				usuario.setGenero(resultSet.getInt(8));
				Rol rol = new Rol();
				rol.setId(resultSet.getInt(9));
				rol.setNombre(resultSet.getString(10));
				usuario.setRol(rol);
				usuario.setUsuario(resultSet.getString(11));
			}
			conexion.desconectar();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"No se ha podido realizar la conexi�n con la base de datos, por favor intente de nuevo.");
		}
		return usuario;
	}

	@Override
	public boolean cambiarContrasena(String usuario, String password, String passwordNew) {
		try {
			// create our java preparedstatement using a sql update query
			PreparedStatement ps = conexion.getConexion()
					.prepareStatement("UPDATE Usuario SET password = ? WHERE username = ? AND password = ?");

			ps.setString(1, passwordNew);
			ps.setString(2, usuario);
			ps.setString(3, password);
			int res = ps.executeUpdate();
			ps.close();
			if (res == 0)
				return false;
			else
				return true;
		} catch (SQLException se) {
			// log the exception
			System.out.println(se);
		}
		return false;
	}

}

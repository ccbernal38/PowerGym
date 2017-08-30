/**
 * 
 */
package co.powergym.dao;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.imageio.ImageIO;

import co.powergym.interfacedao.LoginInterfaceDao;
import co.powergym.model.Conexion;
import co.powergym.model.Entrenador;
import co.powergym.model.Rol;
import co.powergym.model.Socio;
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
					"SELECT  user.id, user.identificacion, user.primerNombre, user.segundoNombre, user.primerApellido, "
							+ "user.segundoApellido, user.fechaNacimiento, user.telefono, "
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
				usuario.setPrimerNombre(resultSet.getString(3));
				usuario.setSegundoNombre(resultSet.getString(4));
				usuario.setPrimerApellido(resultSet.getString(5));
				usuario.setSegundoApellido(resultSet.getString(6));
				usuario.setFechaNacimiento(resultSet.getDate(7));
				usuario.setTelefono(resultSet.getString(8));
				usuario.setCorreo(resultSet.getString(9));
				usuario.setGenero(resultSet.getInt(10));
				Rol rol = new Rol();
				rol.setId(resultSet.getInt(11));
				rol.setNombre(resultSet.getString(12));
				usuario.setRol(rol);
				usuario.setUsuario(resultSet.getString(13));
			}
			conexion.desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

}

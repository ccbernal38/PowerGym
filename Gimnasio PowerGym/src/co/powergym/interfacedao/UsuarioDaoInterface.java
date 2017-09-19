package co.powergym.interfacedao;

import java.sql.Date;
import java.util.ArrayList;
import co.powergym.model.Usuario;

public interface UsuarioDaoInterface {

	public boolean registrarUsuario(String identificacion, String nombre, String apellido, Date fechaNacimiento,
			String correo, String telefono, int genero, String username, String password);

	public ArrayList<Usuario> listaUsuario();

	public boolean eliminarUsuario(String identificacion);

	public boolean modificarUsuario(String identificacion, String nombre, String apellido, Date fechaNacimiento,
			String correo, String telefono, int genero, String username, String password);

	public Usuario buscarUsuario(String identificacion);

	public Usuario buscarUsuarioId(int id);

}

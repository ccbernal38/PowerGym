package co.powergym.interfacedao;

import co.powergym.model.Usuario;

public interface LoginInterfaceDao {

	public Usuario inicioSesion(String username, String password);

	public boolean cambiarContrasena(String usuario, String password, String passwordNew);

}

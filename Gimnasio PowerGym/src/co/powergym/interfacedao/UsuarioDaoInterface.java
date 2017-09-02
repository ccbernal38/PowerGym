package co.powergym.interfacedao;

import java.sql.Date;
import java.util.ArrayList;

import co.powergym.model.Entrenador;

public interface UsuarioDaoInterface {
	
public boolean registrarEntrenador(String identificacion,  String primerNombre, String segundoNombre, String primerApellido,
        String segundoApellido, Date fechaNacimiento,String correo, String telefono, int genero, String username, String password);
	
	public ArrayList<Entrenador> listaUsuario();
	
	public boolean eliminarEntrenador(String identificacion);
	
	public boolean modificarEntrenador(String identificacion,  String primerNombre, String segundoNombre, String primerApellido,
	        String segundoApellido,Date fechaNacimiento, String correo, String telefono, int genero, String username, String password);
	
	public Entrenador buscarEntrenador(String identificacion);
}

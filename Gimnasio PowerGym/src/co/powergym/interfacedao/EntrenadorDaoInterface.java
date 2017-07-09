package co.powergym.interfacedao;

import java.sql.Date;
import java.util.ArrayList;

import co.powergym.model.Entrenador;

public interface EntrenadorDaoInterface {
	
public boolean registrarEntrenador(String identificacion,  String primerNombre, String segundoNombre, String primerApellido,
        String segundoApellido, Date fechaNacimiento,String correo, String telefono, int genero);
	
	public ArrayList<Entrenador> listaEntrenador();
	
	public boolean eliminarEntrenador(String identificacion);
	
	public boolean modificarEntrenador(String identificacion,  String primerNombre, String segundoNombre, String primerApellido,
	        String segundoApellido,Date fechaNacimiento, String correo, String telefono, int genero);
	
	public Entrenador buscarEntrenador(String identificacion);
}

package co.powergym.dao;

import java.sql.Date;
import java.util.ArrayList;

import co.powergym.interfacedao.EntrenadorDaoInterface;
import co.powergym.model.Conexion;
import co.powergym.model.Entrenador;

public class EntrenadorDao implements EntrenadorDaoInterface{
	
	Conexion conexion;
	
	public EntrenadorDao(){
		conexion = new Conexion();
	}

	@Override
	public boolean registrarEntrenador(String identificacion, Date fechaNacimiento, String primerNombre,
			String segundoNombre, String primerApellido, String segundoApellido, String correo, String telefono,
			int genero) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Entrenador> listaEntrenador() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminarEntrenador(String identificacion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificarEntrenador(String identificacion, Date fechaNacimiento, String primerNombre,
			String segundoNombre, String primerApellido, String segundoApellido, String correo, String telefono,
			int genero) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Entrenador buscarEntrenador(String identificacion) {
		// TODO Auto-generated method stub
		return null;
	}

}

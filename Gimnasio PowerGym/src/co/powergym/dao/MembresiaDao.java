package co.powergym.dao;

import java.util.ArrayList;

import co.powergym.interfacedao.MembresiaDaoInterface;
import co.powergym.model.Conexion;
import co.powergym.model.Membresia;

public class MembresiaDao implements MembresiaDaoInterface{

	Conexion conexion;
	
	public MembresiaDao() {
		// TODO Auto-generated constructor stub
		conexion = new Conexion();
	}
	@Override
	public boolean registrarMembresia(String codigo, String nombre, double valor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Membresia> listaMembresia() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminarMembresia(String codigo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificarMembresia(String codigo, String nombre, double valor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Membresia buscarMembresia(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}

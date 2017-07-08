package co.powergym.interfacedao;

import java.util.ArrayList;
import java.util.List;

import co.powergym.model.Membresia;

public interface MembresiaDaoInterface {
	
	public boolean registrarMembresia(String codigo, String nombre, double valor);
	
	public List<Membresia> listaMembresia();
	
	public boolean eliminarMembresia(int id);
	
	public boolean modificarMembresia(int id, String nombre, double valor);
	
	public Membresia buscarMembresia(int id);
	

}

package co.powergym.interfacedao;

import java.util.ArrayList;
import java.util.List;

import co.powergym.model.Membresia;

public interface MembresiaDaoInterface {
	
	public boolean registrarMembresia(String codigo, String nombre, double valor);
	
	public List<Membresia> listaMembresia();
	
	public boolean eliminarMembresia(String codigo);
	
	public boolean modificarMembresia(String codigo, String nombre, double valor);
	
	public Membresia buscarMembresia(String codigo);
	

}

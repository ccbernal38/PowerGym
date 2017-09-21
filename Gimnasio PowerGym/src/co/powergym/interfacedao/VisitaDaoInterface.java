package co.powergym.interfacedao;

import java.util.List;

import co.powergym.model.Visita;

public interface VisitaDaoInterface {

	public boolean registrarVisita(String nombre, String apellido, int valor, int id_usuario, int id_caja);
	
	public List<Visita> historicoVisitas();
	
	public List<Visita> visitasDelDia();
	
}

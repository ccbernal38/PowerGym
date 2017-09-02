package co.powergym.interfacedao;

import java.util.List;

import co.powergym.model.DiaSemana;
import co.powergym.model.Horario;
import co.powergym.model.Membresia;
import co.powergym.model.MembresiaSocio;

public interface MembresiaDaoInterface {

	public boolean registrarMembresia(String nombre, double valor, int cantidadDuracion, int visitasxdia,
			int IdTipoDuracion);

	public List<Membresia> listaMembresia();

	public boolean eliminarMembresia(int id);

	public boolean modificarMembresia(int id, String nombre, double valor);

	public Membresia buscarMembresia(int id);

	public List<Horario> getHorarios(int id);

	public List<DiaSemana> getDiasPermitidos(int id);

	public Membresia verificarEntradaMembresia(int idSocio);
	
	public Membresia buscarId(String nombre);
}

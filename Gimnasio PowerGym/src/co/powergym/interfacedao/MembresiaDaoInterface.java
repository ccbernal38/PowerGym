package co.powergym.interfacedao;

import java.util.List;

import co.powergym.model.DiaSemana;
import co.powergym.model.Horario;
import co.powergym.model.Membresia;

public interface MembresiaDaoInterface {

	public boolean registrarMembresia(String codigo, String nombre, double valor, int cantidadDuracion,
			String tipoDuracion, boolean limiteDias, int numeroVisitas, List<DiaSemana> dias, boolean horarioIngreso,
			List<Horario> horarios);

	public List<Membresia> listaMembresia();

	public boolean eliminarMembresia(int id);

	public boolean modificarMembresia(int id, String nombre, double valor);

	public Membresia buscarMembresia(int id);

	public List<Horario> getHorarios(int id);

	public List<DiaSemana> getDiasPermitidos(int id);

}

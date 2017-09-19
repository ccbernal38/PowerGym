package co.powergym.interfacedao;

import java.util.Date;
import java.util.List;

import co.powergym.model.DiaSemana;
import co.powergym.model.Horario;
import co.powergym.model.Membresia;
import co.powergym.model.MembresiaSocio;

public interface MembresiaDaoInterface {

	public boolean registrarMembresia(String nombre, double valor, int cantidadDuracion, int visitasxdia,
			int IdTipoDuracion, int promocional, Date fechaFinalizacion);

	public List<Membresia> listaMembresia();

	public boolean eliminarMembresia(int id);

	public boolean modificarMembresia(String nombre, int valor, int visitasDia);

	public Membresia buscarMembresia(int id);

	public List<Horario> getHorarios(int id);

	public List<DiaSemana> getDiasPermitidos(int id);

	public Membresia verificarEntradaMembresia(int idSocio);
	
	public Membresia buscarId(String nombre);
}

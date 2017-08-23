package co.powergym.interfacedao;

import java.util.Date;
import java.util.List;

import co.powergym.model.Membresia;
import co.powergym.model.MembresiaSocio;

public interface MembresiaSocioDaoInterface {

	public boolean registrarMembresiaSocio(int codigoMembresia, int idSocio, Date fecha, boolean isActivo);
	
	public boolean modificarMembresiaSocio(int id, int codigoMembresia, int idSocio, boolean isActivo);
	
	public List<MembresiaSocio> historialMembresias(int idSocio);	
	
	
}

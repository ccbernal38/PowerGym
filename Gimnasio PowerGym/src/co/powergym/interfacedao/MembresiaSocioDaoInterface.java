package co.powergym.interfacedao;

import java.sql.Date;

public interface MembresiaSocioDaoInterface {

	public boolean registrarMembresiaSocio(int codigoMembresia, int idSocio, Date fecha, boolean isActivo);
	
	public boolean modificarMembresiaSocio(int id, int codigoMembresia, int idSocio, boolean isActivo);
	
	
	
	
}

package co.powergym.interfacedao;

import java.util.Date;
import java.util.List;
import co.powergym.model.MembresiaSocio;

public interface MembresiaSocioDaoInterface {

	public boolean registrarMembresiaSocio(int codigoMembresia, int idSocio, Date fechaInicio, Date fechaFin,
			int descuento, int renovar, int caja_id, int valor);

	public boolean modificarMembresiaSocio(int id, int codigoMembresia, int idSocio, boolean isActivo);

	public List<MembresiaSocio> historialMembresias(int idSocio);

}

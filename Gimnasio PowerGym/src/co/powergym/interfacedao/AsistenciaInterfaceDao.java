package co.powergym.interfacedao;

import java.util.List;

import co.powergym.model.Asistencia;

public interface AsistenciaInterfaceDao {
	
	public List<Asistencia> historicoAsistencias(int idSocio);

	public void registrarAsistencia(int idSocio);
}

package co.powergym.interfacedao;

import java.util.Date;
import java.util.List;

import co.powergym.model.Horario;

public interface HorarioDaoInterface {

	public List<Horario> listadoHorariosMembresia(int codigoMembresia);
	
	public boolean registrarHorarioMembresia(Date horaInicio, Date horaFin, int codigoMembresia);
	
}

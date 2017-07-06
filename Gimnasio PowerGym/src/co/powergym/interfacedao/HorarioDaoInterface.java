package co.powergym.interfacedao;

import java.sql.Date;
import java.util.List;

import co.powergym.model.Horario;

public interface HorarioDaoInterface {

	public List<Horario> listadoHorariosMembresia(int codigoMembresia);
	
	public boolean registrarHorarioMembresia(Date horaInicio, Date horaFin, int codigoMembresia);
	
}

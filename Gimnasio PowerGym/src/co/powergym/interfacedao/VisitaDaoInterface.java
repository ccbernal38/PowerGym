package co.powergym.interfacedao;

import java.util.Date;
import java.util.List;

import co.powergym.model.Visita;

public interface VisitaDaoInterface {

	public boolean registrarVisita(String nombre, String apellido, int valor, int id_usuario, int id_caja);

	public boolean registrarVisitaRango(String nombre, String apellido, int valor, int id_usuario, int id_caja, Date horaInicio, Date horaFin);

	public List<Visita> historicoVisitas();

	public List<Visita> visitasDelDia();

	public List<Visita> historicoVisita(int socio_id);

}

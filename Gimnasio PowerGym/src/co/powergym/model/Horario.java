package co.powergym.model;

import java.sql.Date;

public class Horario {

	private int id;
	private Date horaInicio;
	private Date horaFin;
	private int codigoMembresia;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}

	public int getCodigoMembresia() {
		return codigoMembresia;
	}

	public void setCodigoMembresia(int codigoMembresia) {
		this.codigoMembresia = codigoMembresia;
	}

	public Horario(int id, Date horaInicio, Date horaFin) {
		super();
		this.id = id;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}

	public Horario() {
		super();
	}

}

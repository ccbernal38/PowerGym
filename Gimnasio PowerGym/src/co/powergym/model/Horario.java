package co.powergym.model;

import java.text.SimpleDateFormat;
import java.util.Date;

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

	public Horario( Date dateDe, Date dateA) {
		super();
		this.horaInicio = dateDe;
		this.horaFin = dateA;
	}

	public Horario() {
		super();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");

		return "De "+ dateFormat.format(horaInicio)+" a "+dateFormat.format(horaFin);
	}

}

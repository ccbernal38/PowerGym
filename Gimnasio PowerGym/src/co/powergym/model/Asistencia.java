package co.powergym.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Asistencia {
	
	int id;
	Date fecha;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFecha() {
		return new SimpleDateFormat("MM/dd/yyyy").format(fecha);
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getDia() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		if(calendar.get(Calendar.DAY_OF_WEEK) == 1)
			return "Domingo";
		else if(calendar.get(Calendar.DAY_OF_WEEK) == 2)
			return "Lunes";
		else if(calendar.get(Calendar.DAY_OF_WEEK) == 3)
			return "Martes";
		else if(calendar.get(Calendar.DAY_OF_WEEK) == 4)
			return "Miercoles";
		else if(calendar.get(Calendar.DAY_OF_WEEK) == 5)
			return "Jueves";
		else if(calendar.get(Calendar.DAY_OF_WEEK) == 6)
			return "Viernes";
		else 
			return "Sabado";
	}
	
	public String getHora() {
		return new SimpleDateFormat("hh:mm:ss a").format(fecha);	
	}

}

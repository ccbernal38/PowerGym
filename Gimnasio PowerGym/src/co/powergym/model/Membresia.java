package co.powergym.model;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Membresia {

	private int id;
	private String codigo;
	private String nombre;
	private int valor;
	private int cantidad_visitas_dia;
	private int duracion;
	private List<DiaSemana> diasPermitidos;
	private List<Horario> horario;
	private Date fecha_creacion;
	private Duracion duracionValor;
	private boolean renovar;

	public Membresia(String nombre, int valor) {
		super();
		this.nombre = nombre;
		this.valor = valor;
	}

	public Membresia(String codigo, String nombre, int valor) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.valor = valor;
	}

	public Membresia() {
		// TODO Auto-generated constructor stub
	}

	public boolean isRenovar() {
		return renovar;
	}

	public void setRenovar(boolean renovar) {
		this.renovar = renovar;
	}

	public Duracion getDuracionValor() {
		return duracionValor;
	}

	public void setDuracionValor(Duracion duracionValor) {
		this.duracionValor = duracionValor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getCantidad_visitas_dia() {
		return cantidad_visitas_dia;
	}

	public void setCantidad_visitas_dia(int cantidad_visitas_dia) {
		this.cantidad_visitas_dia = cantidad_visitas_dia;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public List<DiaSemana> getDiasPermitidos() {
		return diasPermitidos;
	}

	public void setDiasPermitidos(List<DiaSemana> diasPermitidos) {
		this.diasPermitidos = diasPermitidos;
	}

	public List<Horario> getHorario() {
		return horario;
	}

	public void setHorario(List<Horario> horario) {
		this.horario = horario;
	}

	public String getDias() {
		String dias = "";
		for (int i = 0; i < diasPermitidos.size(); i++) {

			if (i + 1 == diasPermitidos.size()) {
				dias += diasPermitidos.get(i).getNombre() + "";
			} else if (i < diasPermitidos.size()) {
				dias += diasPermitidos.get(i).getNombre() + " - ";
			}
		}
		return dias;
	}

	public String getTiempoDuracion() {
		String fechaActual = new SimpleDateFormat("dd/mm/yyyy").format(Calendar.getInstance().getTime());
		String fechaFin = new SimpleDateFormat("dd/mm/yyyy").format(getFechaFinal());
		return "Comienza el " + fechaActual + " hasta el " + fechaFin;
	}

	public String getHorarioPermitido() {
		String cadena = "<html>";
		for (int i = 0; i < getHorario().size(); i++) {
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss aa");
			String dateHoraInicio = sdf.format(getHorario().get(i).getHoraInicio());
			String dateHoraFin = sdf.format(getHorario().get(i).getHoraFin());
			if (i + 1 == getHorario().size()) {
				cadena += dateHoraInicio + " - " + dateHoraFin;
			} else if (i < getHorario().size()) {
				cadena += dateHoraInicio + " - " + dateHoraFin + ", ";
			}
			if (i % 3 == 1) {
				cadena += "<br/>";
			}

		}
		cadena += "</html>";
		return cadena;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nombre;
	}

	public Date getFechaFinal() {

		String duracionValor = getDuracionValor().getNombre();
		int duracion = getDuracion();
		int diasTotal = 0;
		if (duracionValor.equals(Duracion.DIA)) {
			diasTotal = duracion;
		} else if (duracionValor.equals(Duracion.SEMANA)) {
			diasTotal = duracion * 7;
		} else if (duracionValor.equals(Duracion.MES)) {
			diasTotal = duracion * 30;
		} else if (duracionValor.equals(Duracion.ANIO)) {
			diasTotal = duracion * 365;
		}
		return sumarDiasFecha(Calendar.getInstance().getTime(), diasTotal);
	}

	public Date sumarDiasFecha(Date fecha, int dias) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha); // Configuramos la fecha que se recibe
		calendar.add(Calendar.DAY_OF_YEAR, dias); // numero de días a añadir, o restar en caso de días<0
		return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
	}
}

 package co.powergym.model;

import java.util.Calendar;
import java.util.Date;

public class MembresiaSocio {

	private int id;
	private Membresia membresia;
	private Socio socio;
	private Date fechaInicial;
	private Date fechaFinal;
	private boolean isActiva;
	private int descuento;
	private Factura pago;
	private int valor;

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Membresia getMembresia() {
		return membresia;
	}

	public void setMembresia(Membresia membresia) {
		this.membresia = membresia;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public boolean isActiva() {
		return isActiva;
	}

	public void setActiva(boolean isActiva) {
		this.isActiva = isActiva;
	}

	public Factura getPago() {
		return pago;
	}

	public void setPago(Factura pago) {
		this.pago = pago;
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	
	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public Date getFechaFinal() {
		if (fechaFinal == null) {
			String duracionValor = membresia.getDuracionValor().getNombre();
			int duracion = membresia.getDuracion();
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
			fechaFinal = sumarDiasFecha(fechaInicial, diasTotal);
		}

		return fechaFinal;
	}

	public Date sumarDiasFecha(Date fecha, int dias) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha); // Configuramos la fecha que se recibe
		calendar.add(Calendar.DAY_OF_YEAR, dias); // numero de días a añadir, o restar en caso de días<0
		return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos

	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public MembresiaSocio(Membresia membresia, Socio socio, Date fecha, boolean isActiva, Factura pago) {

		this.membresia = membresia;
		this.socio = socio;
		this.fechaInicial = fecha;
		this.isActiva = isActiva;
		this.pago = pago;
	}

	/**
	 * 
	 */
	public MembresiaSocio() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}

package co.powergym.model;

import java.sql.Date;

public class MembresiaSocio {

	private Membresia membresia;
	private Socio socio;
	private Date fecha;
	private boolean isActiva;
	private Pago pago;

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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isActiva() {
		return isActiva;
	}

	public void setActiva(boolean isActiva) {
		this.isActiva = isActiva;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public MembresiaSocio(Membresia membresia, Socio socio, Date fecha, boolean isActiva, Pago pago) {

		this.membresia = membresia;
		this.socio = socio;
		this.fecha = fecha;
		this.isActiva = isActiva;
		this.pago = pago;
	}

	/**
	 * 
	 */
	public MembresiaSocio() {
		super();
	}

}

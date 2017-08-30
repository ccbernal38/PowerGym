package co.powergym.model;

import java.sql.Timestamp;
import java.util.Date;

public class Caja {

	public static final int ABIERTA = 1;
	public static final int CERRADA = 0;

	private int id;
	private int responsableApertura;
	private int responsableCierre;
	private int estado;
	private Date fechaApertura;
	private Date fechaCierre;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getResponsableApertura() {
		return responsableApertura;
	}

	public void setResponsableApertura(int responsableApertura) {
		this.responsableApertura = responsableApertura;
	}

	public int getResponsableCierre() {
		return responsableCierre;
	}

	public void setResponsableCierre(int responsableCierre) {
		this.responsableCierre = responsableCierre;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Date getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	
	/**
	 * @param responsableApertura
	 * @param responsableCierre
	 * @param fechaApertura
	 * @param fechaCierre
	 */
	public Caja(int responsableApertura, int responsableCierre, Date fechaApertura, Date fechaCierre) {
		this.responsableApertura = responsableApertura;
		this.responsableCierre = responsableCierre;
		this.fechaApertura = fechaApertura;
		this.fechaCierre = fechaCierre;
	}

	/**
	 * 
	 */
	public Caja() {
	}

}

package co.powergym.model;

import java.util.Date;

public class Deuda {

	private int id;
	private int valor;
	private String concepto;
	private int socio_id;
	private int caja_id;
	private Date fecha;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getSocio_id() {
		return socio_id;
	}

	public void setSocio_id(int socio_id) {
		this.socio_id = socio_id;
	}

	public int getCaja_id() {
		return caja_id;
	}

	public void setCaja_id(int caja_id) {
		this.caja_id = caja_id;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}

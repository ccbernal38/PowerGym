package co.powergym.model;

import java.sql.Date;

public class Factura {

	private int id;
	private Double valor;
	private Date fecha;
	private int socio_id;
	private int caja_id;

	public Factura() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCaja_id() {
		return caja_id;
	}

	public void setCaja_id(int caja_id) {
		this.caja_id = caja_id;
	}

	public int getSocio_id() {
		return socio_id;
	}

	public void setSocio_id(int socio_id) {
		this.socio_id = socio_id;
	}
}

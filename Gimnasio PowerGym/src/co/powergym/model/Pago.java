package co.powergym.model;

import java.sql.Date;

public class Pago {
	
	private int id;
	private Socio socio;
	private Membresia membresia;
	private Double valor;
	private Date fecha;
	
	public Pago(){
		
	}
		
	public Pago(Socio socio, Double valor, Membresia membresia){
		super();
		this.socio = socio;
		this.valor = valor;
		this.membresia = membresia;
	}

}

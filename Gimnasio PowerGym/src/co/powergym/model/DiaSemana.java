package co.powergym.model;

import java.util.List;

public class DiaSemana {

	private int id;
	private String nombre;

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
	
	public DiaSemana(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public DiaSemana() {
		super();
	}

}

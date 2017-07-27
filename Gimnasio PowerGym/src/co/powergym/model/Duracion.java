package co.powergym.model;

public class Duracion {

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

	/**
	 * @param id
	 * @param nombre
	 */
	public Duracion(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public Duracion() {
		
	}
	@Override
	public String toString() {
		
		return nombre;
	}
}

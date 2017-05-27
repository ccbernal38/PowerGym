package co.powergym.model;

public class Membresia {
	
	private int id;
	private String codigo;
	private String nombre;
	private double valor;
	
	public Membresia(String nombre, double valor) {
		super();
		this.nombre = nombre;
		this.valor = valor;
	}
	
	public Membresia(String codigo, String nombre, double valor) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.valor = valor;
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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}

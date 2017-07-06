package co.powergym.model;

import java.sql.Date;
import java.util.List;

public class Membresia {

	private int id;
	private String codigo;
	private String nombre;
	private double valor;
	private int cantidad_visitas_dia;
	private int duracion;
	private List<DiaSemana> diasPermitidos;
	private List<Horario> horario;
	private Date fecha_creacion;

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

	public Membresia() {
		// TODO Auto-generated constructor stub
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

}

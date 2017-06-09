package co.powergym.model;

import java.util.Date;
import java.util.List;

public class Entrenador {
	
	public static int GENERO_M = 0;
    public static int GENERO_F = 1;

    private int id;
    private String identificacion;
    private Date fechaNacimiento;
    private String primerNombre, segundoNombre, primerApellido, segundoApellido;
    private String correo, telefono;
    private int genero;
    private String imagen;
    private Rol rol;
    
    
    public Entrenador(){
    	
    }
    
    public Entrenador(String identificacion, Date fechaNacimiento, String primerNombre,
			String segundoNombre, String primerApellido, String segundoApellido, String correo, String telefono,
			int genero){
    	this.identificacion = identificacion;
    	this.fechaNacimiento = fechaNacimiento;
    	this.primerNombre = primerNombre;
    	this.segundoNombre = segundoNombre;
    	this.primerApellido = primerApellido;
    	this.segundoApellido = segundoApellido;
    	this.correo = correo;
    	this.telefono = telefono;
    }
	public static int getGENERO_M() {
		return GENERO_M;
	}
	public static void setGENERO_M(int gENERO_M) {
		GENERO_M = gENERO_M;
	}
	public static int getGENERO_F() {
		return GENERO_F;
	}
	public static void setGENERO_F(int gENERO_F) {
		GENERO_F = gENERO_F;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getSegundoNombre() {
		return segundoNombre;
	}
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getGenero() {
		return genero;
	}
	public void setGenero(int genero) {
		this.genero = genero;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}


}

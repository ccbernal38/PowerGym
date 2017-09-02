/**
 * 
 */
package co.powergym.model;

import java.util.Date;

/**
 * @author nia
 *
 */
public class Usuario {

	private int id;
	private String usuario;
	private String contrasena;
	private Rol rol;

	private String identificacion;
	private Date fechaNacimiento;
	private String nombre, apellido;
	private String correo, telefono;
	private int genero;
	private String direccion;

	public Usuario() {

	}

	public Usuario(int id, String usuario, String contrasena) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.contrasena = contrasena;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the contrasena
	 */
	public String getContrasena() {
		return contrasena;
	}

	/**
	 * @param contrasena
	 *            the contrasena to set
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String primerNombre) {
		this.nombre = primerNombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String primerApellido) {
		this.apellido = primerApellido;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public static int GENERO_M = 0;
	public static int GENERO_F = 1;

}

package co.powergym.model;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Socio {

	public static int GENERO_M = 0;
	public static int GENERO_F = 1;

	private int id;
	private String identificacion;
	private Date fechaNacimiento;
	private String nombre, apellido;
	private String correo, telefono;
	private int genero;
	private String imagen;
	private String direccion;
	private BufferedImage foto;
	private Rol rol;
	private byte[]  huella;
	private String nombreCompleto;
	private String codigo;

	public Socio() {

	}

	public Socio(int id, String identificacion, Date fechaNacimiento, String primerNombre,
			String primerApellido, String correo, String telefono, int genero) {
		super();
		this.id = id;
		this.identificacion = identificacion;
		this.fechaNacimiento = fechaNacimiento;
		this.nombre = primerNombre;
		this.apellido = primerApellido;
		this.correo = correo;
		this.telefono = telefono;
		this.genero = genero;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public BufferedImage getFoto() {
		return foto;
	}

	public void setFoto(BufferedImage foto) {
		this.foto = foto;
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

	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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

	public byte[] getHuella() {
		return huella;
	}

	public void setHuella(byte[] huella) {
		this.huella = huella;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public String getNombreCompleto() {
		return nombre+" "+apellido;
	}

	public String capitalLetter(String input) {
		String output = input.substring(0, 1).toUpperCase() + input.substring(1);
		return output;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getNombreCompleto();
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}

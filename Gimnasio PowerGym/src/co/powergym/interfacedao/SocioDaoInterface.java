package co.powergym.interfacedao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import co.powergym.model.Socio;

public interface SocioDaoInterface {

	public boolean registrarSocio(String identificacion, Date fechaNacimiento, String nombre, String apellido,
            String correo, String telefono, int genero, BufferedImage foto, byte[] huella) throws IOException;
	
	public List<Socio> listaSocios();
	
	public boolean eliminarSocio(String identificacion);
	
	public boolean modificarSocio(String identificacion, Date fechaNacimiento, String nombre, String apellido,
            String correo, String telefono, int genero);
	
	public Socio buscarSocio(String identificacion);
	
	public Socio buscarSocio(int idSocio);

	public List<Socio> sociosCumpleaniosMes();
	
	public List<Socio> sociosCumpleaniosDia();

}

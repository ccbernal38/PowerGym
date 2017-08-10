/**
 * 
 */
package co.powergym.model;

/**
 * @author nia
 *
 */
public class Usuario {
	
	private int id;
	private String usuario;
	private String contrasena;
	
	public Usuario () 
	{
				
	}
	
	public Usuario(int id, String usuario, String contrasena) 
	{	
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
	 * @param id the id to set
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
	 * @param usuario the usuario to set
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
	 * @param contrasena the contrasena to set
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}	

}

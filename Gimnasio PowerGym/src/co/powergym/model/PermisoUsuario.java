/**
 * 
 */
package co.powergym.model;

/**
 * @author nia
 *
 */
public class PermisoUsuario {
	
	//Atributos
	private int usuario_id;
	private int permiso_id;
	
	//Métodos
	/**
	 * Método constructor de la clase
	 */
	public PermisoUsuario() {
		super();
	}

	/**
	 * @return the usuario_id
	 */
	public int getUsuario_id() {
		return usuario_id;
	}

	/**
	 * @param usuario_id the usuario_id to set
	 */
	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}

	/**
	 * @return the permiso_id
	 */
	public int getPermiso_id() {
		return permiso_id;
	}

	/**
	 * @param permiso_id the permiso_id to set
	 */
	public void setPermiso_id(int permiso_id) {
		this.permiso_id = permiso_id;
	}

	
}

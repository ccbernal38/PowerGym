/**
 * 
 */
package co.powergym.interfacedao;

import java.util.ArrayList;
import co.powergym.model.PermisoUsuario;

/**
 * @author nia
 *
 */
public interface PermisoUsuarioDaoInterface{
	public boolean registrarPermisoUsuario(int usuario_id, int permiso_id);
	
	public ArrayList<PermisoUsuario> listaPermisoUsuario();
	
	public boolean modificarUsuario(int usuario_id, int permiso_id);
	

}

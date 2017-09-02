/**
 * 
 */
package co.powergym.interfacedao;

import java.sql.Date;
import java.util.ArrayList;

import co.powergym.model.Permiso;
import co.powergym.model.Usuario;

/**
 * @author nia
 *
 */
public interface PermisoDaoInterface {
	public boolean registrarPermiso(String nombre, Date fechaCreacion,Date fechaModificacion);
		
		public ArrayList<Permiso> listaPermisos();
		
		public boolean eliminarPermiso(int id);
		
		public boolean modificarPermiso(int id, String nombre, Date fechaCreacion,Date fechaModificacion);
		
		public Permiso buscarPermiso(int id);

}

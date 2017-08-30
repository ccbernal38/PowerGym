package co.powergym.utils;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import com.sun.org.apache.regexp.internal.recompile;

import co.powergym.model.Usuario;

public class Preferencias {
	

	private static Preferences prefs;
	
	public static String obtenerPreferencia(String clave) {
		return prefs.get(clave, "-1");
	}
	
	public static void guardarPreferencia(String clave, String valor) {
		prefs.put(clave, valor);
	}
	
	public static void resetPreferencias() {
		try {
			prefs.clear();
		} catch (BackingStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initPreferencia() {
		prefs = Preferences.userRoot().node(Constantes.PREFERENCIAS);
		if(obtenerPreferencia(Constantes.PUERTO).equals("-1")) {
			guardarPreferencia(Constantes.PUERTO, "COM5");
		}
		System.out.println(obtenerPreferencia(Constantes.PUERTO));
	}
	
	public static void InicioSesionPrefs(Usuario usuario) {
		guardarPreferencia("user_username", usuario.getUsuario());
		guardarPreferencia("user_id", usuario.getId()+"");
		guardarPreferencia("user_nombre", usuario.getUsuario());
		guardarPreferencia("user_identificacion", usuario.getIdentificacion());
	}
}

package co.powergym.interfacedao;

import java.util.List;

import co.powergym.model.Socio;

public interface ReporteDaoInterface {
	
	public List<Socio>listaSocios();
	
	public List<Socio> sociosCumpleaniosMes();
	
	public List<Socio>sociosConMembresiaExpirar();
	
	public List<Socio>sociosConMembresiaExpiradas();
	
	public List<Socio>sociosAdeudos();
	
	
	
	

}

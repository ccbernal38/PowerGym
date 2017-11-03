package co.powergym.dao;

import java.util.List;

import co.powergym.interfacedao.ReporteDaoInterface;
import co.powergym.model.Conexion;
import co.powergym.model.Socio;

public class ReporteDao implements ReporteDaoInterface{
	
	Conexion conexion;
	SocioDao socioDao;
	
	public ReporteDao() {
		// TODO Auto-generated constructor stub
		conexion = new Conexion();
		socioDao = new SocioDao();
	}

	@Override
	public List<Socio> listaSocios() {
		List<Socio>listaSocios = socioDao.listaSocios();
		return listaSocios;
	}

	@Override
	public List<Socio> sociosCumpleaniosMes() {
		List<Socio>listaCumpleanosMes = socioDao.sociosCumpleaniosMes();
		return listaCumpleanosMes;
	}

	@Override
	public List<Socio> sociosConMembresiaExpirar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Socio> sociosConMembresiaExpiradas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Socio> sociosAdeudos() {
		// TODO Auto-generated method stub
		return null;
	}

}

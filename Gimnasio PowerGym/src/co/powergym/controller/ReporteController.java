package co.powergym.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.powergym.dao.MembresiaDao;
import co.powergym.dao.SocioDao;
import co.powergym.model.Socio;
import co.powergym.view.reporte.GenerarReporte;

public class ReporteController implements ActionListener{
	
	private SocioDao socioDao;
	private MembresiaDao membresiaDao;
	private GenerarReporte generarReporteA;
	
	public ReporteController(GenerarReporte generarReporte) {
		
		this.socioDao = new SocioDao();
		this.membresiaDao = new MembresiaDao();
		
		
		if(generarReporte != null) {
			this.generarReporteA = generarReporte;
			this.generarReporteA.setVisible(true);
			this.generarReporteA.setLocationRelativeTo(null);
			this.generarReporteA.getChckbxListaSocios().addActionListener(this);			
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(generarReporteA.getChckbxListaSocios() ==e.getSource()) {
			llenarTablaListaSocios(generarReporteA.getTableReportes());
		}
	}



	private void llenarTablaListaSocios(JTable listaSocios) {
		
		DefaultTableModel defaultTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Nro. identificación", "Nombre", "Dirección", "Correo electrónico", "Teléfono" });

		Object[] columna = new Object[5];
		List<Socio> listSocios = socioDao.listaSocios();
		int numeroRegistros = listSocios.size();

		for (int i = 0; i < numeroRegistros; i++) {
			columna[0] = listSocios.get(i).getIdentificacion();
			columna[1] = listSocios.get(i).getNombreCompleto();
			columna[2] = listSocios.get(i).getDireccion();
			columna[3] = listSocios.get(i).getCorreo();
			columna[4] = listSocios.get(i).getTelefono();
			defaultTableModel.addRow(columna);
		}
		
		listaSocios.setModel(defaultTableModel);
		listaSocios.getColumnModel().getColumn(0).setPreferredWidth(20);
		listaSocios.getColumnModel().getColumn(1).setPreferredWidth(80);
		listaSocios.getColumnModel().getColumn(2).setPreferredWidth(80);
		listaSocios.getColumnModel().getColumn(3).setPreferredWidth(80);
		listaSocios.getColumnModel().getColumn(4).setPreferredWidth(20);
		listaSocios.repaint();
		
	}

}

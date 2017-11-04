package co.powergym.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import co.powergym.dao.MembresiaDao;
import co.powergym.dao.SocioDao;
import co.powergym.model.Socio;
import co.powergym.view.reporte.GenerarReporte;

public class ReporteController implements ActionListener {

	private SocioDao socioDao;
	private MembresiaDao membresiaDao;
	private GenerarReporte generarReporteA;
	
	/**
	 * Metodo constructor
	 * @param generarReporte
	 */
	public ReporteController(GenerarReporte generarReporte) {

		this.socioDao = new SocioDao();
		this.membresiaDao = new MembresiaDao();

		if (generarReporte != null) {
			this.generarReporteA = generarReporte;
			this.generarReporteA.setVisible(true);
			this.generarReporteA.setLocationRelativeTo(null);
			this.generarReporteA.getChckbxListaSocios().addActionListener(this);
			this.generarReporteA.getChckbxSociosCumppleanosMes().addActionListener(this);
			this.generarReporteA.getChckbxSociosActivos().addActionListener(this);
			this.generarReporteA.getBtnExportar().addActionListener(this);
			this.generarReporteA.getCheckBoxSociosInactivos().addActionListener(this);
		}
	}
	
	/**
	 * Metodo que retorna la ruta donde se guardara el archivo.
	 * @return ruta donde se guardara el archivo.
	 * @throws IOException
	 */
	public String retornarRutaFileChooser() throws IOException {
		String ruta = "";
		JFileChooser file = new JFileChooser() {
			@Override
			public void approveSelection() {
				File f = getSelectedFile();
				if (f.exists() && getDialogType() == SAVE_DIALOG) {
					int result = JOptionPane.showConfirmDialog(this, "El archivo ya existe, ¿Desea reemplazarlo?", "Advertencia",
							JOptionPane.YES_NO_CANCEL_OPTION);
					switch (result) {
					case JOptionPane.YES_OPTION:
						super.approveSelection();
						return;
					case JOptionPane.NO_OPTION:
						return;
					case JOptionPane.CLOSED_OPTION:
						return;
					case JOptionPane.CANCEL_OPTION:
						cancelSelection();
						return;
					}
				}
				super.approveSelection();
			}
		};
		file.setFileFilter(new javax.swing.filechooser.FileFilter() {
			public boolean accept(final File f) {
				return f.isDirectory() || f.getAbsolutePath().endsWith(".xlsx");
			}

			public String getDescription() {
				return "Excel (*.xlsx)";
			}
		});
		file.setAcceptAllFileFilterUsed(false);
		int selection = file.showSaveDialog(null);
		if (selection == JFileChooser.APPROVE_OPTION) {
			File guarda = file.getSelectedFile();
			ruta = guarda.getAbsolutePath();
			if(!ruta.endsWith(".xlsx")) {
				ruta += ".xlsx";
			}
		}
		return ruta;
	}
	
	/**
	 * Metodo que permite convertir un list de socios a una matriz de String.
	 * @param socios, lista de socios
	 * @return matriz convertida
	 */
	public String[][] converterListToMatrixListaSocios(List<Socio> socios) {

		String[][] sociosFinales = new String[socios.size()][5];
		for (int i = 0; i < sociosFinales.length; i++) {
			sociosFinales[i][0] = socios.get(i).getIdentificacion();
			sociosFinales[i][1] = socios.get(i).getNombreCompleto();
			sociosFinales[i][2] = socios.get(i).getDireccion();
			sociosFinales[i][3] = socios.get(i).getCorreo();
			sociosFinales[i][4] = socios.get(i).getTelefono();
		}
		return sociosFinales;

	}
	
	/**
	 * Metodo que permite convertir un list de socios a una matriz de String.
	 * @param socios
	 * @return
	 */
	public String[][] converterListToMatrixSociosCumple(List<Socio> socios) {

		String[][] sociosFinales = new String[socios.size()][4];
		for (int i = 0; i < sociosFinales.length; i++) {
			sociosFinales[i][0] = socios.get(i).getIdentificacion();
			sociosFinales[i][1] = socios.get(i).getNombreCompleto();
			sociosFinales[i][2] = socios.get(i).getFechaNacimiento()+"";
			sociosFinales[i][3] = socios.get(i).getTelefono();
		}
		return sociosFinales;
	}
	
	/**
	 * Metodo que permite generar el reporte del listado de socios.
	 * @param socios, lista de socios.
	 * @param ruta, ruta donde se guardara el reporte.
	 * @throws IOException
	 */
	public void reporteListaSocios(List<Socio> socios, String ruta) throws IOException {

		String[][] sociosFinales = converterListToMatrixListaSocios(socios);
		String nombreArchivo = ruta;
		String nombreHoja1 = "Lista Socios";
		String[] columnas = { "Nro identificación", "Nombre", "Dirección", "Correo electrónico", "Teléfono" };
		XSSFWorkbook libroTrabajo = new XSSFWorkbook();
		XSSFSheet hoja1 = libroTrabajo.createSheet(nombreHoja1);
		XSSFRow row = hoja1.createRow(0);
		for (int j = 0; j < 5; j++) {
			XSSFCell cell = row.createCell(j);
			cell.setCellValue(columnas[j]);
		}

		for (int i = 0; i < sociosFinales.length; i++) {
			row = hoja1.createRow(i + 1);
			for (int j = 0; j < 5; j++) {
				XSSFCell cell = row.createCell(j);
				cell.setCellValue(sociosFinales[i][j]);
				hoja1.autoSizeColumn(j);

			}
		}
		FileOutputStream fileOut = new FileOutputStream(nombreArchivo);
		libroTrabajo.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}
	
	/**
	 * Metodo que permite llenar la tabla de socios.
	 * @param listaSocios
	 */
	private void llenarTablaListaSocios(JTable listaSocios, List<Socio>listSocios) {

		DefaultTableModel defaultTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Nro. identificación", "Nombre", "Dirección", "Correo electrónico", "Teléfono" });

		Object[] columna = new Object[5];
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
	
	/**
	 * Metodo que permite llenar la tabla de socios que cumplen años en el mes actual.
	 * @param tableSocios
	 */
	public void listadoCumpleaniosLlenarTabla(JTable tableSocios) {
		DefaultTableModel defaultTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Nro. identificacion", "Nombre", "Fecha de cumpleaños", "Teléfono" });

		Object[] columna = new Object[4];
		List<Socio> listSocios = socioDao.sociosCumpleaniosMes();
		int numeroRegistros = listSocios.size();

		for (int i = 0; i < numeroRegistros; i++) {
			columna[0] = listSocios.get(i).getIdentificacion();
			columna[1] = listSocios.get(i).getNombreCompleto();

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(listSocios.get(i).getFechaNacimiento());
			int mesTemp = calendar.get(Calendar.MONTH) + 1;
			String mes = "";
			if (mesTemp == 1) {
				mes = "Enero";
			} else if (mesTemp == 2) {
				mes = "Febrero";
			} else if (mesTemp == 3) {
				mes = "Marzo";
			} else if (mesTemp == 4) {
				mes = "Abril";
			} else if (mesTemp == 5) {
				mes = "Mayo";
			} else if (mesTemp == 6) {
				mes = "Junio";
			} else if (mesTemp == 7) {
				mes = "Julio";
			} else if (mesTemp == 8) {
				mes = "Agosto";
			} else if (mesTemp == 9) {
				mes = "Septiembre";
			} else if (mesTemp == 10) {
				mes = "Octubre";
			} else if (mesTemp == 11) {
				mes = "Noviembre";
			} else if (mesTemp == 12) {
				mes = "Diciembre";
			}

			columna[2] = calendar.get(Calendar.DAY_OF_MONTH) + " de " + mes;
			columna[3] = listSocios.get(i).getTelefono();
			defaultTableModel.addRow(columna);
		}
		tableSocios.setModel(defaultTableModel);
		tableSocios.repaint();
	}
	
	/**
	 * Metodo que permite generar el reporte del listado de socios que cumplen años en el mes actual.
	 * @param sociosCumpleanosMes
	 * @param ruta
	 * @throws IOException
	 */
	public void reporteCumpleanosMes(List<Socio> sociosCumpleanosMes, String ruta)throws IOException{
		
		String[][] sociosFinales = converterListToMatrixSociosCumple(sociosCumpleanosMes);
		String nombreArchivo = ruta;
		String nombreHoja1 = "Socios cumpleaños";
		String[] columnas = { "Nro identificación", "Nombre", "Fecha de cumpleaños", "Teléfono"};
		XSSFWorkbook libroTrabajo = new XSSFWorkbook();
		XSSFSheet hoja1 = libroTrabajo.createSheet(nombreHoja1);
		XSSFRow row = hoja1.createRow(0);
		for (int j = 0; j < 4; j++) {
			XSSFCell cell = row.createCell(j);
			cell.setCellValue(columnas[j]);
		}

		for (int i = 0; i < sociosFinales.length; i++) {
			row = hoja1.createRow(i + 1);
			for (int j = 0; j < 4; j++) {
				XSSFCell cell = row.createCell(j);
				cell.setCellValue(sociosFinales[i][j]);
				hoja1.autoSizeColumn(j);

			}
		}
		FileOutputStream fileOut = new FileOutputStream(nombreArchivo);
		libroTrabajo.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}
	
	/**
	 * Evento de accion.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Llenar tabla y generar reporte de lista de socios.
		if (generarReporteA.getChckbxListaSocios() == e.getSource()) {
			llenarTablaListaSocios(generarReporteA.getTableReportes(), socioDao.listaSocios());
		}
		if (generarReporteA.getChckbxListaSocios().isSelected()) {
			if (generarReporteA.getBtnExportar() == e.getSource()) {
				try {
					String ruta = retornarRutaFileChooser();
					if (!ruta.equals("")) {
						reporteListaSocios(socioDao.listaSocios(), ruta);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}
		//Llenar tabla y generar reporte de socios que cumplen años en mes actual
		if(generarReporteA.getChckbxSociosCumppleanosMes() == e.getSource()) {
			
			listadoCumpleaniosLlenarTabla(generarReporteA.getTableReportes());
		}
		if(generarReporteA.getChckbxSociosCumppleanosMes().isSelected()) {
			if(generarReporteA.getBtnExportar() == e.getSource()) {
				try {
					String ruta = retornarRutaFileChooser();
					if (!ruta.equals("")) {
						reporteCumpleanosMes(socioDao.sociosCumpleaniosMes(), ruta);
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
		}
		//Llenar tabla y generar reporte de socios activos.
		if(generarReporteA.getChckbxSociosActivos() == e.getSource()) {
			llenarTablaListaSocios(generarReporteA.getTableReportes(), socioDao.listarSociosActivos());
		}
		if (generarReporteA.getChckbxSociosActivos().isSelected()) {
			if (generarReporteA.getBtnExportar() == e.getSource()) {
				try {
					String ruta = retornarRutaFileChooser();
					if (!ruta.equals("")) {
						reporteListaSocios(socioDao.listarSociosActivos(), ruta);
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		}
		//Llenar tabla y generar reporte de socios inactivos.
		if(generarReporteA.getCheckBoxSociosInactivos() == e.getSource()) {
			llenarTablaListaSocios(generarReporteA.getTableReportes(), socioDao.listarSociosInactivos());
		}
		if (generarReporteA.getCheckBoxSociosInactivos().isSelected()) {
			if (generarReporteA.getBtnExportar() == e.getSource()) {
				try {
					String ruta = retornarRutaFileChooser();
					if (!ruta.equals("")) {
						reporteListaSocios(socioDao.listarSociosInactivos(), ruta);
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		}
	}

}

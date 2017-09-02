package co.powergym.reportes;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.swing.JTable;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import co.powergym.controller.SocioController;
import co.powergym.dao.MembresiaDao;
import co.powergym.dao.SocioDao;
import co.powergym.model.Membresia;
import co.powergym.model.Socio;
import co.powergym.view.Principal;
import co.powergym.view.reporte.GenerarReporte;


public class Reporte {
	
	//Atributos
	GenerarReporte viewGenerarReporte;
	Principal viewPrincipal;
	JTable tablaVistaPrevia = viewGenerarReporte.getTable_vista_informe();
	
	String rutaArchivo = System.getProperty("user.home")+"/reporte.xls";
	File archivoXLS = new File(rutaArchivo);
	Workbook libro = new HSSFWorkbook();
	FileOutputStream archivo = new FileOutputStream(archivoXLS);
	Sheet hoja = libro.createSheet("hoja 1");
	Membresia membresia = new Membresia();
	Socio socio = new Socio();
	SocioDao socioDao;
	SocioController socioController;
	MembresiaDao membresiaDao;
	List<Socio>listaSocios;
	List<Membresia>listaMembresias = membresiaDao.listaMembresia();
	
	
	//Métodos
	/** Método constructor sin parámetros, se maneja la excepción si un archivo existe*/
	public Reporte () throws FileNotFoundException{
			
	}
	
	/**Método para ocultar panel de fechas cuando la opción no lo requiere */
	public void ocultarPanel() {
		if(viewGenerarReporte != null) {
			if(viewGenerarReporte.getChckbxVentasDia().isSelected() || viewGenerarReporte.getChckbxVentasMes().isSelected()) {
			viewGenerarReporte.getPanel_especifica().setVisible(false);
			}
		}
	}
	
	/** Método para listar los socios registrados en el sistema */
	public List<Socio> listarSocios(){
		listaSocios=socioDao.listaSocios();
		
		return listaSocios;
	}

	
	/** Método para validar si un archivo ya existe, si existe es borrado y actualizado con los nuevos datos */
	public void validarExistencia() {
		if(archivoXLS.exists()) 
		{
			archivoXLS.delete();
			try {
				archivoXLS.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**Método para contruir la estructura del archivo, filas: Row fila = hoja.createRow(f)
	 * celdas: Cell celda = fila.createCell(c) 
	 * @throws IOException */
	public void generarArchivo() throws IOException 
	{
		for(int f=0;f<10;f++) {
			Row fila = hoja.createRow(f);
			for(int c=0;c<5;c++){
				Cell celda = fila.createCell(c);
				if(f==0){
				    celda.setCellValue("Encabezado #"+c);
				}else{
				    celda.setCellValue("Valor celda "+c+","+f);
				}
			}	   
		}
		libro.write(archivo);
		archivo.close();
		Desktop.getDesktop().open(archivoXLS);
	}


}

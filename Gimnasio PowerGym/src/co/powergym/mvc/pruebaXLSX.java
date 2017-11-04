package co.powergym.mvc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class pruebaXLSX {
	
	public static void main(String[] args) throws IOException  {
        
        generaXlsx();
 
    }
	
	public static void generaXlsx() throws IOException {
		
		String nombreArchivo = "/informes/File.xlsx";
		String nombreHoja1 = "Hoja1";//nombre de la hoja1
		XSSFWorkbook libroTrabajo = new XSSFWorkbook();
		XSSFSheet hoja1 = libroTrabajo.createSheet(nombreHoja1) ;
		//iterando numero de filas (r)
		for (int r=0;r < 5; r++ ) {
			XSSFRow row = hoja1.createRow(r);
			for (int c=0;c < 5; c++ ){
				XSSFCell cell = row.createCell(c);
				cell.setCellValue("Cell si"+r+" "+c);
			}
		}
		FileOutputStream fileOut = new FileOutputStream(nombreArchivo);
		//escribir este libro en un OutputStream.
		libroTrabajo.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}
}

package co.powergym.mvc;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
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
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class Impresiones extends javax.swing.JDialog implements Printable {
    private JPanel panel;

	public Impresiones(java.awt.Frame parent, boolean modal) {
    	
    	JLabel lblNewLabel = new JLabel("New label");
    	getContentPane().add(lblNewLabel, BorderLayout.NORTH);
    	
    	JLabel lblNewLabel_1 = new JLabel("New label");
    	getContentPane().add(lblNewLabel_1, BorderLayout.WEST);
    	
    	JButton btnNewButton = new JButton("New button");
    	btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jButton1ActionPerformed(e);
			}
		});
    	getContentPane().add(btnNewButton, BorderLayout.SOUTH);
    	
    	panel = new JPanel();
    	getContentPane().add(panel, BorderLayout.CENTER);
    	
    	JTextPane text = new JTextPane();
    	text.setText("kjkjbbiuoubibubibiubiubiubi");
    	panel.add(text);
        initComponents();
    }
    private void initComponents() {
    	
    }//aqui va codigo generado por Netbeans
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(this);
            job.printDialog();
            job.print();
        } catch (PrinterException ex) { }        
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Impresiones dialog = new Impresiones(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                     

    // End of variables declaration                   
    
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) return NO_SUCH_PAGE;
        Graphics2D g2d = (Graphics2D)graphics;
        //Punto donde empezará a imprimir dentro la pagina (100, 50)
        g2d.translate(  pageFormat.getImageableX(), 
                        pageFormat.getImageableY());
        g2d.scale(1,1); //Reducción de la impresión al 50%
        getContentPane().printAll(graphics);
        return PAGE_EXISTS;                
    }
}


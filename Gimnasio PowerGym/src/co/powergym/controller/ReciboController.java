package co.powergym.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.text.DateFormatter;

import co.powergym.dao.ReciboDao;
import co.powergym.view.ReciboView;

public class ReciboController implements ActionListener {

	private ReciboView reciboView;

	private ReciboDao reciboDao;

	private int clienteId;
	private int usuarioId;

	public ReciboController(ReciboView reciboView) {
		this.reciboView = reciboView;
		reciboDao = new ReciboDao();
		if (this.reciboView != null) {
			this.reciboView.setLocationRelativeTo(null);
			this.reciboView.setVisible(true);
			this.reciboView.getBtnImprimir().addActionListener(this);
			int numero = reciboDao.numeroFactura();
			this.reciboView.getLabelNumero().setText(numero + "");
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat sm = new SimpleDateFormat("mm-dd-yyyy HH:mm:ss a");
			this.reciboView.getLabelFecha().setText(sm.format(calendar.getTime()));
		}
	}

	public ReciboView getReciboView() {
		return reciboView;
	}

	public void setReciboView(ReciboView reciboView) {
		this.reciboView = reciboView;
	}

	public ReciboDao getReciboDao() {
		return reciboDao;
	}

	public void setReciboDao(ReciboDao reciboDao) {
		this.reciboDao = reciboDao;
	}

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (reciboView != null) {
			if (reciboView.getBtnImprimir() == e.getSource()) {
				try {
					PrinterJob job = PrinterJob.getPrinterJob();
					job.setPrintable(reciboView);
					job.setCopies(1);
					job.printDialog();
					job.print();
					reciboView.setVisible(false);
					reciboView.dispose();
				} catch (PrinterException ex) {
					System.out.println(ex);
				}
			}
		}
	}

}

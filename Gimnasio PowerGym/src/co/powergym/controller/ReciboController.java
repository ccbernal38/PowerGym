package co.powergym.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.text.DateFormatter;

import co.powergym.dao.ReciboDao;
import co.powergym.dao.SocioDao;
import co.powergym.utils.Constantes;
import co.powergym.utils.Preferencias;
import co.powergym.view.ReciboView;

public class ReciboController {

	private ReciboView reciboView;

	private ReciboDao reciboDao;
	private SocioDao socioDao;

	private int clienteId;
	private int usuarioId;

	public ReciboController(ReciboView reciboView, int socio_id) {
		this.reciboView = reciboView;
		reciboDao = new ReciboDao();
		socioDao = new SocioDao();
		clienteId = socio_id;
		if (this.reciboView != null) {
			this.reciboView.setLocationRelativeTo(null);
			this.reciboView.setVisible(true);
			int numero = reciboDao.numeroFactura();
			this.reciboView.getLabelNumero().setText(numero + "");
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat sm = new SimpleDateFormat("mm-dd-yyyy HH:mm:ss a");
			Date fecha = calendar.getTime();
			this.reciboView.getLabelFecha().setText(sm.format(calendar.getTime()));
			String nombreOperador = Preferencias.obtenerPreferencia(Constantes.NOMBRE_RESPONSABLE);
			int operadorId = Integer.parseInt(Preferencias.obtenerPreferencia(Constantes.ID_RESPONSABLE));
			String nombreCliente = socioDao.buscarSocio(clienteId).getNombreCompleto();
			this.reciboView.getLabelCliente().setText(nombreCliente);
			this.reciboView.getLabelOperador().setText(nombreOperador);
			this.reciboView.getBtnImprimir().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						PrinterJob job = PrinterJob.getPrinterJob();
						job.setPrintable(reciboView);
						job.setCopies(1);
						job.printDialog();
						job.print();
						reciboView.setVisible(false);
						reciboView.dispose();

						String descripcion = reciboView.getTextPaneDescripcion().getText();
						int pago = Integer.parseInt(reciboView.getTextFieldPaga().getText());
						int usadoSaldoFavor = Integer.parseInt(reciboView.getTextFieldUsadoSaldoFavor().getText());
						int debe = Integer.parseInt(reciboView.getTextFieldDebe().getText());
						int saldoFavor = Integer.parseInt(reciboView.getTextFieldSaldoFavor().getText());

						reciboDao.registrarFactura(fecha, clienteId, operadorId, descripcion, pago, usadoSaldoFavor,
								debe, saldoFavor);
					} catch (PrinterException ex) {
						System.out.println(ex);
					}
				}
			});
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

}

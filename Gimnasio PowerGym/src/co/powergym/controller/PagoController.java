package co.powergym.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.jar.JarEntry;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import com.sun.nio.file.SensitivityWatchEventModifier;

import co.powergym.dao.CajaDao;
import co.powergym.dao.DeudaDao;
import co.powergym.dao.PagoDao;
import co.powergym.dao.SaldoFavorDao;
import co.powergym.dao.SocioDao;
import co.powergym.model.Caja;
import co.powergym.model.Deuda;
import co.powergym.utils.Preferencias;
import co.powergym.view.ReciboView;
import co.powergym.view.membresia.PagoMembresiaView;

public class PagoController implements ActionListener {
	PagoMembresiaView pagoMembresiaView;
	PagoDao pagoDao;
	SocioDao socioDao;
	DeudaDao deudaDao;
	CajaDao cajaDao;
	SaldoFavorDao saldoFavorDao;
	int deuda;
	int saldoFavor;
	int socioTemp;

	/**
	 * @param pagoMembresiaView
	 */
	public PagoController(PagoMembresiaView pagoMembresiaView) {
		if (pagoMembresiaView != null) {
			pagoDao = new PagoDao();
			socioDao = new SocioDao();
			deudaDao = new DeudaDao();
			saldoFavorDao = new SaldoFavorDao();
			cajaDao = new CajaDao();
			this.pagoMembresiaView = pagoMembresiaView;

			this.pagoMembresiaView.getBtnPagar().addActionListener(this);
			this.pagoMembresiaView.getBtnCancelar().addActionListener(this);
			this.pagoMembresiaView.setLocationRelativeTo(null);
			this.pagoMembresiaView.setVisible(true);

		}
	}

	public void cargarDeudas(int socio_id) {
		NumberFormat format = NumberFormat.getInstance();
		socioTemp = socio_id;
		deuda = deudaDao.totalDeudasSocio(socio_id);
		saldoFavor = saldoFavorDao.saldoFavorSocio(socio_id);
		this.cargarTablaDeudas(socio_id);
		this.pagoMembresiaView.getLblBalance().setText("$" + format.format(deuda));
		this.pagoMembresiaView.getLblSaldoFavorActual().setText("$" + format.format(saldoFavor));
		this.pagoMembresiaView.getChckbxSi().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (pagoMembresiaView.getChckbxSi().isSelected()) {
					pagoMembresiaView.getTextFieldSaldoUsar().setEnabled(true);
				} else {
					pagoMembresiaView.getTextFieldSaldoUsar().setEnabled(false);
					pagoMembresiaView.getLblPago().setText("$0");
				}
			}
		});

		pagoMembresiaView.getTextFieldPago().addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				try {
					int saldo = 0;
					if (!pagoMembresiaView.getTextFieldPago().getText().equals("")) {
						saldo = Integer.parseInt(pagoMembresiaView.getTextFieldPago().getText());
					}
					int saldoFavor = 0;
					if (pagoMembresiaView.getChckbxSi().isSelected()) {
						if (!pagoMembresiaView.getTextFieldSaldoUsar().getText().equals("")) {
							saldoFavor = Integer.parseInt(pagoMembresiaView.getTextFieldSaldoUsar().getText());
						}
					}
					int nuevoBalance = deuda - (saldo + saldoFavor);
					pagoMembresiaView.getLblNuevoBalance().setText("$" + nuevoBalance);
				} catch (Exception error) {

				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		pagoMembresiaView.getTextFieldSaldoUsar().addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				try {
					if (pagoMembresiaView.getChckbxSi().isSelected()) {
						int saldo = Integer.parseInt(pagoMembresiaView.getTextFieldSaldoUsar().getText());
						if (saldo <= saldoFavor) {
							pagoMembresiaView.getLblPago().setText("$" + NumberFormat.getInstance().format(saldo));
							int valortemp;

							valortemp = NumberFormat.getInstance()
									.parse(pagoMembresiaView.getLblPago().getText().substring(1)).intValue();

							int valorPago = 0;
							if (!pagoMembresiaView.getTextFieldPago().getText().equals("")) {
								valorPago = Integer.parseInt(pagoMembresiaView.getTextFieldPago().getText());
							}
							int nuevoBalance = deuda - (valortemp + valorPago);
							pagoMembresiaView.getLblNuevoBalance()
									.setText("$" + NumberFormat.getInstance().format(nuevoBalance));
						} else {
							int valortemp;

							valortemp = NumberFormat.getInstance()
									.parse(pagoMembresiaView.getLblPago().getText().substring(1)).intValue();
							pagoMembresiaView.getTextFieldSaldoUsar().setText("" + valortemp);
							int valorPago = 0;
							if (!pagoMembresiaView.getTextFieldPago().getText().equals("")) {
								valorPago = Integer.parseInt(pagoMembresiaView.getTextFieldPago().getText());
							}
							int nuevoBalance = deuda - (valortemp + valorPago);
							pagoMembresiaView.getLblNuevoBalance()
									.setText("$" + NumberFormat.getInstance().format(nuevoBalance));
						}
					}
				} catch (Exception e1) {

				}
			}

			@Override
			public void keyPressed(KeyEvent e) {

			}
		});

	}

	public void cargarTablaDeudas(int socio_id) {
		NumberFormat format = NumberFormat.getInstance();
		List<Deuda> list = deudaDao.listaDeudasSocio(socio_id);
		DefaultTableModel defaultTableModel = (DefaultTableModel) pagoMembresiaView.getTablePendientes().getModel();
		Object[] columna = new Object[3];
		int numeroRegistros = list.size();
		for (int i = 0; i < numeroRegistros; i++) {
			columna[0] = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a").format(list.get(i).getFecha());
			columna[1] = list.get(i).getConcepto();
			columna[2] = "$ " + format.format(list.get(i).getValor());
			defaultTableModel.addRow(columna);
		}
		this.pagoMembresiaView.getTablePendientes().setModel(defaultTableModel);
		this.pagoMembresiaView.getTablePendientes().repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (pagoMembresiaView != null) {
			if (e.getSource() == pagoMembresiaView.getBtnPagar()) {
				int saldoFavor = 0;
				if (pagoMembresiaView.getChckbxSi().isSelected()
						&& !pagoMembresiaView.getTextFieldSaldoUsar().getText().equals("")) {
					saldoFavor = Integer.parseInt(pagoMembresiaView.getTextFieldSaldoUsar().getText());
				}
				int saldoPagar = 0;
				if (!pagoMembresiaView.getTextFieldPago().getText().equals("")) {
					saldoPagar = Integer.parseInt(pagoMembresiaView.getTextFieldPago().getText());
				}

				int totalPagar = (saldoFavor + saldoPagar);
				int caja_id = cajaDao.verificarCajaAbierta();
				deudaDao.registrarPago(-deuda, "Pago realizado", socioTemp, caja_id);
				if (saldoFavor != 0) {
					saldoFavorDao.registrarSaldoFavor(-saldoFavor, socioTemp, caja_id);
					pagoMembresiaView.setVisible(false);
					pagoMembresiaView.dispose();
				}

				if ((deuda - totalPagar) < 0) {
					int option = JOptionPane.showConfirmDialog(null,
							"¿Desea guardar el dinero restante " + (-(deuda - totalPagar)) + " como saldo a favor?",
							"Atención", JOptionPane.YES_NO_OPTION);
					if (option == JOptionPane.YES_OPTION) {
						saldoFavorDao.registrarSaldoFavor(-(deuda - totalPagar), socioTemp, caja_id);
					}
				}
				ReciboView reciboView = new ReciboView();
				reciboView.getTextFieldPaga().setText(saldoPagar + "");
				reciboView.getTextFieldUsadoSaldoFavor().setText(saldoFavor + "");
				reciboView.getTextFieldDebe().setText(0 + "");
				reciboView.getTextFieldSaldoFavor().setText((-(deuda - totalPagar)) + "");
				ReciboController controller = new ReciboController(reciboView, socioTemp);
				controller.setClienteId(socioTemp);

				pagoMembresiaView.setVisible(false);
				pagoMembresiaView.dispose();

			} else if (e.getSource() == pagoMembresiaView.getBtnCancelar()) {
				pagoMembresiaView.setVisible(false);
				pagoMembresiaView.dispose();
			}
		}
	}

	public void actualizarPago(int deuda) {

	}

}

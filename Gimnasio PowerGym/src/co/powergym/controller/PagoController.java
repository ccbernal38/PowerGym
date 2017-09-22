package co.powergym.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.sun.nio.file.SensitivityWatchEventModifier;

import co.powergym.dao.CajaDao;
import co.powergym.dao.DeudaDao;
import co.powergym.dao.PagoDao;
import co.powergym.dao.SocioDao;
import co.powergym.model.Caja;
import co.powergym.model.Deuda;
import co.powergym.view.membresia.PagoMembresiaView;

public class PagoController implements ActionListener, KeyListener {
	PagoMembresiaView pagoMembresiaView;
	PagoDao pagoDao;
	SocioDao socioDao;
	DeudaDao deudaDao;

	/**
	 * @param pagoMembresiaView
	 */
	public PagoController(PagoMembresiaView pagoMembresiaView) {
		if (pagoMembresiaView != null) {
			pagoDao = new PagoDao();
			socioDao = new SocioDao();
			deudaDao = new DeudaDao();

			this.pagoMembresiaView = pagoMembresiaView;
			cargarDeudas();
			this.pagoMembresiaView.getBtnPagar().addActionListener(this);
			this.pagoMembresiaView.getBtnCancelar().addActionListener(this);
			this.pagoMembresiaView.setLocationRelativeTo(null);
			this.pagoMembresiaView.setVisible(true);
			this.pagoMembresiaView.getTextFieldPago().addKeyListener(this);
		}
	}

	private void cargarDeudas() {
		/**
		List<Deuda> list = deudaDao.totalDeudasSocio(socio_id)
		DefaultTableModel defaultTableModel = (DefaultTableModel) cajaHistoricoView.getTable().getModel();
		Object[] columna = new Object[11];
		int numeroRegistros = list.size();
		for (int i = 0; i < numeroRegistros; i++) {
			columna[0] = list.get(i).getId();
			columna[1] = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a").format(list.get(i).getFechaApertura());
			NumberFormat format = NumberFormat.getInstance();
			columna[2] = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a").format(list.get(i).getFechaCierre());
			columna[3] = "$ " + format.format(list.get(i).getTotalVisitas());
			columna[4] = "$ " + format.format(list.get(i).getTotalMembresias());
			columna[5] = "$ " + format.format(list.get(i).getTotalSaldoFavor());
			columna[6] = "$ " + format.format(list.get(i).getTotalAdeudos());
			columna[7] = "$ " + format.format(list.get(i).getTotalEgresos());
			columna[8] = "$ " + format.format(list.get(i).getSaldoFinal());
			columna[9] = list.get(i).getNombreApertura();
			columna[10] = list.get(i).getNombreCierre();

			defaultTableModel.addRow(columna);
		}
		this.cajaHistoricoView.getTable().setModel(defaultTableModel);
		this.cajaHistoricoView.getTable().repaint();
		**/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (pagoMembresiaView != null) {
			if (e.getSource() == pagoMembresiaView.getBtnPagar()) {

			} else if (e.getSource() == pagoMembresiaView.getBtnCancelar()) {
				pagoMembresiaView.setVisible(false);
				pagoMembresiaView.dispose();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		actualizarPago();

	}

	public void actualizarPago() {
		if (pagoMembresiaView != null) {
			int balance = Integer.parseInt(pagoMembresiaView.getLblBalance().getText().substring(1,
					pagoMembresiaView.getLblBalance().getText().length()));
			int valor = Integer.parseInt(pagoMembresiaView.getTextFieldPago().getText());
			pagoMembresiaView.getLblBalance().setText("$" + (int) (balance - valor));
		}
	}

}

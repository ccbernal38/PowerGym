package co.powergym.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.sun.nio.file.SensitivityWatchEventModifier;

import co.powergym.dao.PagoDao;
import co.powergym.dao.SocioDao;
import co.powergym.view.membresia.PagoMembresiaView;

public class PagoController implements ActionListener, KeyListener {
	PagoMembresiaView pagoMembresiaView;
	PagoDao pagoDao;
	SocioDao socioDao;

	/**
	 * @param pagoMembresiaView
	 */
	public PagoController(PagoMembresiaView pagoMembresiaView) {
		if (pagoMembresiaView != null) {
			pagoDao = new PagoDao();
			socioDao = new SocioDao();
			this.pagoMembresiaView = pagoMembresiaView;
			this.pagoMembresiaView.getBtnPagar().addActionListener(this);
			this.pagoMembresiaView.getBtnCancelar().addActionListener(this);
			this.pagoMembresiaView.setLocationRelativeTo(null);
			this.pagoMembresiaView.setVisible(true);
			this.pagoMembresiaView.getTextFieldPago().addKeyListener(this);
		}
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
			pagoMembresiaView.getLblBalance().setText("$"+(int)(balance-valor));
		}
	}

}

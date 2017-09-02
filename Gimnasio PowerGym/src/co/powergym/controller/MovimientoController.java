package co.powergym.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import co.powergym.dao.MovimientoDao;
import co.powergym.utils.Constantes;
import co.powergym.utils.Preferencias;
import co.powergym.view.caja.CajaRegistroEgresoView;
import co.powergym.view.caja.CajaRegistroIngresoView;

public class MovimientoController implements ActionListener {

	CajaRegistroIngresoView cajaRegistroIngresoView;
	CajaRegistroEgresoView cajaRegistroEgresoView;
	MovimientoDao movimientoDao;

	/**
	 * @param cajaRegistroIngresoView
	 * @param cajaRegistroEgresoView
	 */
	public MovimientoController(CajaRegistroIngresoView IngresoView, CajaRegistroEgresoView EgresoView) {
		movimientoDao = new MovimientoDao();
		this.cajaRegistroIngresoView = IngresoView;
		this.cajaRegistroEgresoView = EgresoView;
		if (cajaRegistroIngresoView != null) {
			cajaRegistroIngresoView.getBtnCancelar().addActionListener(this);
			cajaRegistroIngresoView.getBtnRegistrar().addActionListener(this);
			cajaRegistroIngresoView.setLocationRelativeTo(null);
			cajaRegistroIngresoView.setVisible(true);
		}

		if (cajaRegistroEgresoView != null) {
			cajaRegistroEgresoView.getBtnCancelar().addActionListener(this);
			cajaRegistroEgresoView.getBtnRegistrar().addActionListener(this);
			cajaRegistroEgresoView.setLocationRelativeTo(null);
			cajaRegistroEgresoView.setVisible(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (cajaRegistroIngresoView != null) {
			if (cajaRegistroIngresoView.getBtnCancelar() == e.getSource()) {
				cajaRegistroIngresoView.setVisible(false);
				cajaRegistroIngresoView.dispose();
			}
			if (cajaRegistroIngresoView.getBtnRegistrar() == e.getSource()) {
				try {
					String concepto = cajaRegistroIngresoView.getTextAreaConcepto().getText();
					int valor = Integer.parseInt(cajaRegistroIngresoView.getTextFieldValor().getText());
					movimientoDao.registrarIngreso(concepto, valor, Integer.parseInt(Preferencias.obtenerPreferencia(Constantes.CAJA_ID)));
					JOptionPane.showMessageDialog(null, "Se ha registrado el ingreso correctamente.");
					cajaRegistroIngresoView.setVisible(false);
					cajaRegistroIngresoView.dispose();
				}catch(NumberFormatException err) {
					JOptionPane.showMessageDialog(null, "Solo debe ingresar numeros en el campo valor.");
				}
				
			}
		}
		if (cajaRegistroEgresoView != null) {
			if (cajaRegistroEgresoView.getBtnCancelar() == e.getSource()) {
				cajaRegistroEgresoView.setVisible(false);
				cajaRegistroEgresoView.dispose();
			}
			if (cajaRegistroEgresoView.getBtnRegistrar() == e.getSource()) {
				try {
					String concepto = cajaRegistroEgresoView.getTextAreaConcepto().getText();
					int valor = Integer.parseInt(cajaRegistroEgresoView.getTextFieldValor().getText());
					movimientoDao.registrarEgreso(concepto, valor, Integer.parseInt(Preferencias.obtenerPreferencia(Constantes.CAJA_ID)));
					JOptionPane.showMessageDialog(null, "Se ha registrado el egreso correctamente.");
					cajaRegistroEgresoView.setVisible(false);
					cajaRegistroEgresoView.dispose();
				}catch(NumberFormatException err) {
					JOptionPane.showMessageDialog(null, "Solo debe ingresar numeros en el campo valor.");
				}
				
			}
		}
	}

}

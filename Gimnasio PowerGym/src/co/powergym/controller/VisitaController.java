package co.powergym.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import co.powergym.dao.SocioDao;
import co.powergym.dao.VisitaDao;
import co.powergym.model.Socio;
import co.powergym.view.membresia.MembresiaRegistroVisitaView;

public class VisitaController implements ActionListener {

	VisitaDao visitaDao;
	SocioDao socioDao;
	MembresiaRegistroVisitaView membresiaRegistroVisitaView;
	Socio socioTemp;

	/**
	 * @param membresiaRegistroVisitaView
	 */
	public VisitaController(MembresiaRegistroVisitaView membresiaRegistroVisitaView) {
		visitaDao = new VisitaDao();
		socioDao = new SocioDao();
		this.membresiaRegistroVisitaView = membresiaRegistroVisitaView;
		this.membresiaRegistroVisitaView.getBtnBuscar().addActionListener(this);
		this.membresiaRegistroVisitaView.getBtnCancelar().addActionListener(this);
		this.membresiaRegistroVisitaView.getBtnRegistrar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (membresiaRegistroVisitaView != null) {
			if (membresiaRegistroVisitaView.getBtnBuscar() == e.getSource()) {
				String key = membresiaRegistroVisitaView.getTextFieldSocio().getText();
				if (!key.equals("")) {
					socioTemp = socioDao.buscarSocioIdOrCodigo(key);
					membresiaRegistroVisitaView.getTextFieldNombres().setText(socioTemp.getNombre());
					membresiaRegistroVisitaView.getTextFieldApellidos().setText(socioTemp.getApellido());
				}else {
					JOptionPane.showMessageDialog(null, "El campo codigo no puede estar vacio.");
				}

			} else if (membresiaRegistroVisitaView.getBtnCancelar() == e.getSource()) {
				membresiaRegistroVisitaView.setVisible(false);
				membresiaRegistroVisitaView.dispose();
			} else if (membresiaRegistroVisitaView.getBtnRegistrar() == e.getSource()) {
				if(membresiaRegistroVisitaView.getTextFieldNombres().getText().equals("") || membresiaRegistroVisitaView.getTextFieldApellidos().getText().equals("")
						|| membresiaRegistroVisitaView.getTextFieldValor().getText().equals("")) {
					JOptionPane.showMessageDialog(null, "No puede dejar vacio el campo nombre, apellido o valor.");
				}else {
					if(socioTemp == null) {
						String nombre = membresiaRegistroVisitaView.getTextFieldNombres().getText();
						String apellido =membresiaRegistroVisitaView.getTextFieldApellidos().getText();
						int valor = Integer.parseInt(membresiaRegistroVisitaView.getTextFieldValor().getText());
						int id_caja = 0;
						visitaDao.registrarVisita(nombre, apellido, valor, -1, id_caja);
					}else {
						String nombre = membresiaRegistroVisitaView.getTextFieldNombres().getText();
						String apellido =membresiaRegistroVisitaView.getTextFieldApellidos().getText();
						int valor = Integer.parseInt(membresiaRegistroVisitaView.getTextFieldValor().getText());
						int id_caja = 0;
						visitaDao.registrarVisita(nombre, apellido, valor, socioTemp.getId(), id_caja);
					}
				}
				
			}

		}
	}

}

package co.powergym.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import co.powergym.view.CrearMembresia;

public class MembresiaController implements ActionListener {

	private CrearMembresia membresia;
	
	public MembresiaController(CrearMembresia membresia) {
		
		this.membresia = membresia;
		this.membresia.setVisible(true);
		this.membresia.getBtnSiguiente().addActionListener(this);
		this.membresia.getBtnCancelar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == membresia.getBtnSiguiente()){
			
			membresia.getLblNombreMembresia().setText("¿Se limitaran las visitas por dia para esta membresia?");
		}
		if(e.getSource() == membresia.getBtnCancelar()){
			membresia.setVisible(false);
		}
	}

}

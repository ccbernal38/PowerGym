package co.powergym.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.powergym.view.CrearMembresia;

public class MembresiaController implements ActionListener {

	private CrearMembresia membresia;
	
	public MembresiaController(CrearMembresia membresia) {
		
		this.membresia = membresia;
		this.membresia.setVisible(true);
		this.membresia.getBtnSiguiente().addActionListener(this);
		this.membresia.getBtnAtras().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int contPasos = 1;
		if(e.getSource() == membresia.getBtnSiguiente()){
			
			membresia.getLbl_pregunta_1().setVisible(false);
			membresia.getLbl_pregunta_2().setBounds(20, 118, 285, 16);
			contPasos ++;
		}
		if(e.getSource() == membresia.getBtnAtras()){
			membresia.setVisible(false);
		}
	}

}

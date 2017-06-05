package co.powergym.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import co.powergym.view.CrearMembresia;

public class MembresiaController implements ActionListener {

	private CrearMembresia membresia;
	
	public MembresiaController(CrearMembresia membresia) {
		
		this.membresia = membresia;
		membresia.getBtnSiguiente().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == membresia.getBtnSiguiente()){
			
			membresia.getLblNombreMembresia().setText("¿Se limitaran las visitas por dia para esta membresia?");
		}
	}

}

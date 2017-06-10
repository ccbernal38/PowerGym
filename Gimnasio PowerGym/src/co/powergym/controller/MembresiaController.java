package co.powergym.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.powergym.view.CrearMembresia;

public class MembresiaController implements ActionListener {

	private CrearMembresia membresia;
	int contPasos = 1;

	
	public MembresiaController(CrearMembresia membresia) {
		
		this.membresia = membresia;
		this.membresia.setVisible(true);
		this.membresia.getBtnSiguiente().addActionListener(this);
		this.membresia.getBtnAtras().addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
	
		
		if(e.getSource() == membresia.getBtnSiguiente()){
			
			if (contPasos == 1) {
				contPasos ++;
				membresia.getLblPasoDe().setText("Paso "+contPasos+" de 4");
				
				
				membresia.getLbl_pregunta_1().setVisible(false);
				membresia.getTfNombreMembresia().setVisible(false);
				
				membresia.getLbl_pregunta_2().setBounds(20, 118, 285, 16);
				membresia.getBtnAtras().setBounds(22, 280, 117, 37);
				membresia.getLblCantidad().setBounds(21, 146, 61, 16);
				membresia.getCBXCantidad().setBounds(92, 142, 61, 27);
				membresia.getCBXTipoTiempo().setBounds(156, 142, 156, 27);
			}else 
			if (contPasos == 2) {
				
				contPasos ++;
				membresia.getLblPasoDe().setText("Paso "+contPasos+" de 4");
				membresia.getLbl_pregunta_2().setVisible(false);
				membresia.getLb_pregunta_3().setBounds(20, 118, 342, 16);
				
			} else
			if (contPasos == 3) {
				
				contPasos ++;
				membresia.getLblPasoDe().setText("Paso "+contPasos+" de 4");
				
				
			}
		}
		if(e.getSource() == membresia.getBtnAtras()){
			
		}
	}

}

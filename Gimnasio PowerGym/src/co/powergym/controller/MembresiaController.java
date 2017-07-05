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
				membresia.getLblPasoDe().setText("Paso "+contPasos+" de 5");
				
				
				membresia.getLbl_pregunta_1().setVisible(false);
				membresia.getTfNombreMembresia().setVisible(false);
				membresia.getLbl_costoMembresia().setVisible(false);
				membresia.getLblPeso().setVisible(false);
				membresia.getTFPrecio().setVisible(false);
				
				membresia.getLbl_pregunta_2().setBounds(20, 120, 285, 16);
				membresia.getBtnAtras().setBounds(118, 317, 110, 30);
				membresia.getLblCantidad().setBounds(21, 148, 61, 16);
				membresia.getCBXCantidad().setBounds(92, 144, 61, 27);
				membresia.getCBXTipoTiempo().setBounds(156, 144, 156, 27);
			}else 
			if (contPasos == 2) {
				
				contPasos ++;
				membresia.getLblPasoDe().setText("Paso "+contPasos+" de 5");
				membresia.getLbl_pregunta_2().setVisible(false);
				membresia.getCBXCantidad().setVisible(false);
				membresia.getCBXTipoTiempo().setVisible(false);
				membresia.getLblCantidad().setVisible(false);
				membresia.getLb_pregunta_3().setBounds(20, 118, 342, 16);
				membresia.getChckbxNo().setBounds(30, 152, 128, 23);
				membresia.getChckbxSi().setBounds(30, 187, 352, 23);
				membresia.getComboBoxVisitas().setBounds(381, 187, 61, 27);

				
			} else
			if (contPasos == 3) {
				
				contPasos ++;
				membresia.getLblPasoDe().setText("Paso "+contPasos+" de 5");
				membresia.getLb_pregunta_3().setVisible(false);
				membresia.getLbl_pregunta_4().setBounds(20, 118, 342, 16);
				membresia.getComboBoxVisitas().setVisible(false);
			}else
			if(contPasos == 4){
				
				contPasos++;
				membresia.getLblPasoDe().setText("Paso "+contPasos+" de 5");
				membresia.getLbl_pregunta_4().setVisible(false);
				membresia.getLbl_pregunta5().setBounds(20, 118, 342, 16);
			}
		}
		if(e.getSource() == membresia.getBtnAtras()){
			
		}
	}

}

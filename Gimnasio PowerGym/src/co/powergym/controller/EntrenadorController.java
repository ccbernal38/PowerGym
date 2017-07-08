package co.powergym.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import co.powergym.dao.EntrenadorDao;
import co.powergym.model.Entrenador;
import co.powergym.view.entrenador.BusquedaEntrenador;
import co.powergym.view.entrenador.ListaEntrenador;
import co.powergym.view.entrenador.RegistroEntrenador;

public class EntrenadorController implements ActionListener{
	
	EntrenadorDao entrenadorDao;	
	RegistroEntrenador viewRegistroEntrenador;
	BusquedaEntrenador viewBusquedantrenador;
	ListaEntrenador viewListaEntrenador;
	
	public EntrenadorController(EntrenadorDao entrenadorDao, RegistroEntrenador viewRegistroEntrenador, BusquedaEntrenador viewBusquedaentrenador,
			ListaEntrenador viewListaEntrenador) {
		this.entrenadorDao = entrenadorDao;
		this.viewRegistroEntrenador = viewRegistroEntrenador;
		if(viewRegistroEntrenador != null){
			this.viewRegistroEntrenador.btnRegistrar.addActionListener(this);
			this.viewRegistroEntrenador.btnCancelar.addActionListener(this);
			this.viewRegistroEntrenador.setVisible(true);
		}
		else if(viewBusquedaentrenador != null){
			this.viewBusquedantrenador = viewBusquedaentrenador;
			this.viewBusquedantrenador.setVisible(true);
		}
		else if(viewListaEntrenador != null) {
			this.viewListaEntrenador = viewListaEntrenador;
			listadoEntrenadoresLlenarTabla(viewListaEntrenador.getJTableListaEntrenador());
			this.viewListaEntrenador.setVisible(true);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (viewRegistroEntrenador != null && e.getSource() == viewRegistroEntrenador.btnRegistrar) {
			try {
				String numeroId = viewRegistroEntrenador.getTxtNumeroid().getText();
			Entrenador entrenador = entrenadorDao.buscarEntrenador(numeroId);
			if (entrenador == null) {
				
				String primerNombre = viewRegistroEntrenador.getTxtNombre().getText();
				if(primerNombre == null || primerNombre.equals("")){
					JOptionPane.showMessageDialog(null, "El campo primer nombre no puede estar vacio.");
				}
				else{					
					
				}String segundoNombre = viewRegistroEntrenador.getTxtSegundonombre().getText();
				String primerApellido = viewRegistroEntrenador.getTxtPrimerapellido().getText();
				String segundoApellido = viewRegistroEntrenador.getTxtSegundoapellido().getText();
				Date fechaNacimiento = new Date(viewRegistroEntrenador.getDateChooser_fechaNacimiento().getDate().getTime());
				String telefono = viewRegistroEntrenador.getTxtTelefono().getText();
				String correo = viewRegistroEntrenador.getTxtCorreoelectronico().getText();
				int genero = viewRegistroEntrenador.getComboBox_genero().getSelectedIndex();

				boolean respuesta = entrenadorDao.registrarEntrenador(numeroId, fechaNacimiento, primerNombre, segundoNombre, 
						primerApellido, segundoApellido, correo, telefono, genero);
				if (respuesta) {
					JOptionPane.showMessageDialog(null, "Registro exitoso");
				} else {
					JOptionPane.showMessageDialog(null, "Ocurrio un error registrando un nuevo entrenador.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "El entrenador ya se encuentra registrado");
			}
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		else if (e.getSource() == viewBusquedantrenador.btnBuscar) {
			String numeroId = viewBusquedantrenador.getTxtNumeroid().getText();
			Entrenador entrenador = entrenadorDao.buscarEntrenador(numeroId);
			if (entrenador != null) {
				String primerNombre = entrenador.getPrimerNombre();
						viewBusquedantrenador.getTxtNombre().setText(primerNombre);
				String segundoNombre = entrenador.getSegundoNombre();
						viewBusquedantrenador.getTxtSegundonombre().setText(segundoNombre);
				String primerApellido = entrenador.getPrimerApellido();
						viewBusquedantrenador.getTxtPrimerapellido().setText(primerApellido);
				String segundoApellido = entrenador.getSegundoApellido();
						viewBusquedantrenador.getTxtSegundoapellido().setText(segundoApellido);
				String fechaNacimiento = String.valueOf(entrenador.getFechaNacimiento());
						viewBusquedantrenador.txtfechaNacimiento.setText(fechaNacimiento);
				String telefono = entrenador.getTelefono();
						viewBusquedantrenador.getTxtTelefono().setText(telefono);
				String correo = entrenador.getCorreo();
						viewBusquedantrenador.getTxtCorreoelectronico().setText(correo);		
				
			} else {
				JOptionPane.showMessageDialog(null, "No se encontró un entrenador con ese número de identificación, por favor verifique");
			}
		}
	}
	
	public void listadoEntrenadoresLlenarTabla(JTable tablaEntrenadores) {
		DefaultTableModel defaultTableModel = new DefaultTableModel();

		defaultTableModel.addColumn("Nro. identificacion");
		defaultTableModel.addColumn("Nombre");
		defaultTableModel.addColumn("Apellido");
		defaultTableModel.addColumn("Direcci�n");
		defaultTableModel.addColumn("Correo electr�nico");
		defaultTableModel.addColumn("Tel�fono");

		Object[] columna = new Object[5];
		List<Entrenador> listEntrenadores = entrenadorDao.listaEntrenador();
		int numeroRegistros = listEntrenadores.size();

		for (int i = 0; i < numeroRegistros; i++) {
			columna[0] = listEntrenadores.get(i).getIdentificacion();
			columna[1] = listEntrenadores.get(i).getPrimerNombre() + " " + listEntrenadores.get(i).getSegundoNombre();
			columna[2] = listEntrenadores.get(i).getPrimerApellido() + " " + listEntrenadores.get(i).getSegundoApellido();
			columna[4] = listEntrenadores.get(i).getCorreo();
			columna[5] = listEntrenadores.get(i).getTelefono();
			defaultTableModel.addRow(columna);
		}
		tablaEntrenadores.setModel(defaultTableModel);
		tablaEntrenadores.repaint();
	}	
}

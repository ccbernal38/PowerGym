package co.powergym.controller;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.powergym.dao.EntrenadorDao;
import co.powergym.model.Entrenador;
import co.powergym.view.entrenador.ActualizarEntrenador;
import co.powergym.view.entrenador.BusquedaEntrenador;
import co.powergym.view.entrenador.ListaEntrenador;
import co.powergym.view.entrenador.RegistroEntrenador;

public class EntrenadorController implements ActionListener {

	EntrenadorDao entrenadorDao;
	RegistroEntrenador viewRegistroEntrenador;
	BusquedaEntrenador viewBusquedantrenador;
	ListaEntrenador viewListaEntrenador;
	ActualizarEntrenador viewActualizarEntrenador;

	public EntrenadorController(EntrenadorDao entrenadorDao, RegistroEntrenador viewRegistroEntrenador,
			BusquedaEntrenador viewBusquedaentrenador, ListaEntrenador viewListaEntrenador,
			ActualizarEntrenador viewActualizarEntrenador) {
		this.entrenadorDao = entrenadorDao;
		this.viewRegistroEntrenador = viewRegistroEntrenador;
		this.viewBusquedantrenador = viewBusquedaentrenador;
		if (viewRegistroEntrenador != null) {
			this.viewRegistroEntrenador.btnRegistrar.addActionListener(this);
			this.viewRegistroEntrenador.btnCancelar.addActionListener(this);
			this.viewRegistroEntrenador.setVisible(true);
		}
		if (viewBusquedaentrenador != null) {
			this.viewBusquedantrenador.btnBuscar1.addActionListener(this);
			this.viewBusquedantrenador.btnCancelar1.addActionListener(this);
			this.viewBusquedantrenador.setVisible(true);
		}
		if (viewListaEntrenador != null) {
			this.viewListaEntrenador = viewListaEntrenador;
			listadoEntrenadoresLlenarTabla(viewListaEntrenador.getJTableListaEntrenador());
			this.viewListaEntrenador.btnEditar1.addActionListener(this);
			this.viewListaEntrenador.btnEliminar1.addActionListener(this);
			this.viewListaEntrenador.setVisible(true);
		}
		if (viewActualizarEntrenador != null) {
			this.viewActualizarEntrenador = viewActualizarEntrenador;
			this.viewActualizarEntrenador.btnActualizar1.addActionListener(this);
			this.viewActualizarEntrenador.setVisible(true);
		}

	}

	public void listadoEntrenadoresLlenarTabla(JTable tablaEntrenadores) {
		DefaultTableModel defaultTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Nro. identificación", "Nombre", "Dirección", "Correo electronico", "Teléfono" });

		Object[] columna = new Object[5];
		List<Entrenador> listEntrenadores = entrenadorDao.listaEntrenador();
		int numeroRegistros = listEntrenadores.size();

		for (int i = 0; i < numeroRegistros; i++) {
			columna[0] = listEntrenadores.get(i).getIdentificacion();
			columna[1] = listEntrenadores.get(i).getNombreCompleto();
			columna[2] = listEntrenadores.get(i).getDireccion();
			columna[3] = listEntrenadores.get(i).getCorreo();
			columna[4] = listEntrenadores.get(i).getTelefono();
			defaultTableModel.addRow(columna);
		}
		tablaEntrenadores.setModel(defaultTableModel);
		tablaEntrenadores.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (viewRegistroEntrenador != null && e.getSource() == viewRegistroEntrenador.btnRegistrar) {
			try {
				String numeroId = viewRegistroEntrenador.getTxtNumeroid().getText();
				Entrenador entrenador = entrenadorDao.buscarEntrenador(numeroId);
				if (entrenador == null) {

					String primerNombre = viewRegistroEntrenador.getTxtNombre().getText();
					if (primerNombre == null || primerNombre.equals("")) {
						JOptionPane.showMessageDialog(null, "El campo primer nombre no puede estar vacio.");
					} else {
						String segundoNombre = viewRegistroEntrenador.getTxtSegundonombre().getText();
						String primerApellido = viewRegistroEntrenador.getTxtPrimerapellido().getText();
						if (primerApellido == null || primerApellido.equals("")) {
							JOptionPane.showMessageDialog(null, "El campo primer apellido no puede estar vacio.");
						} else {
							String segundoApellido = viewRegistroEntrenador.getTxtSegundoapellido().getText();
							if (segundoApellido == null || segundoApellido.equals("")) {
								JOptionPane.showMessageDialog(null, "El campo segundo apellido no puede estar vacio.");
							}

							else {
								Date fechaNacimiento = null;

								if (viewRegistroEntrenador.getDateChooser_fechaNacimiento().getDate() == null) {
									JOptionPane.showMessageDialog(null,
											"El campo fecha de nacimiento no puede estar vacio.");
								} else {
									fechaNacimiento = new Date(viewRegistroEntrenador.getDateChooser_fechaNacimiento()
											.getDate().getTime());

									String telefono = viewRegistroEntrenador.getTxtTelefono().getText();
									if (telefono == null || telefono.equals("")) {
										JOptionPane.showMessageDialog(null, "El campo telefóno no puede estar vacio.");
									} else {
										String correo = viewRegistroEntrenador.getTxtCorreoelectronico().getText();
										int genero = 0;
										if (viewRegistroEntrenador.getComboBox_genero() != null) {
											genero = viewRegistroEntrenador.getComboBox_genero().getSelectedIndex();
										}

										if (correo == null || correo.equals("")) {
											JOptionPane.showMessageDialog(null,
													"El campo correo electrónico no puede estar vacio.");
										}
										boolean respuesta = entrenadorDao.registrarEntrenador(numeroId, primerNombre,
												segundoNombre, primerApellido, segundoApellido, fechaNacimiento, correo,
												telefono, genero);
										if (respuesta) {
											JOptionPane.showMessageDialog(null, "Registro exitoso");
										} else {
											JOptionPane.showMessageDialog(null,
													"Ocurrio un error registrando un nuevo entrenador.");
										}
									}
								}
							}
						}

					}

				} else {
					JOptionPane.showMessageDialog(null, "El entrenador ya se encuentra registrado");
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}

		} else if (viewRegistroEntrenador != null && e.getSource() == viewRegistroEntrenador.btnCancelar) {
			viewRegistroEntrenador.setVisible(false);
			viewRegistroEntrenador.dispose();
		} else if (viewBusquedantrenador != null && e.getSource() == viewBusquedantrenador.btnBuscar1) {

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
				// String fechaNacimiento =
				// String.valueOf(entrenador.getFechaNacimiento());
				// viewBusquedantrenador.txtfechaNacimiento.setText(fechaNacimiento);
				String telefono = entrenador.getTelefono();
				viewBusquedantrenador.getTxtTelefono().setText(telefono);
				String correo = entrenador.getCorreo();
				viewBusquedantrenador.getTxtCorreoelectronico().setText(correo);
			} else {
				JOptionPane.showMessageDialog(null,
						"No se encontró un entrenador con ese número de identificación, por favor verifique");
			}
		} else if (viewBusquedantrenador != null && e.getSource() == viewBusquedantrenador.btnCancelar1) {
			viewBusquedantrenador.setVisible(false);
			viewBusquedantrenador.dispose();
		} else if (viewListaEntrenador != null && e.getSource() == viewListaEntrenador.btnEliminar1) {
			int filaSeleccionada = viewListaEntrenador.JTableListaEntrenador.getSelectedRow();
			ArrayList<Entrenador> listaEntrenador = entrenadorDao.listaEntrenador();
			Boolean filaEliminada;
			if (filaSeleccionada != -1) {
				if (listaEntrenador != null) {
					String identificacion = listaEntrenador.get(filaSeleccionada).getIdentificacion();
					int optiopn = JOptionPane.showConfirmDialog(viewListaEntrenador,
							"¿Esta seguro de eliminar el entrenador con identificación " + identificacion + " ?");
					if (JOptionPane.YES_OPTION == optiopn) {
						filaEliminada = entrenadorDao.eliminarEntrenador(identificacion);
						if (filaEliminada == true) {

							JOptionPane.showMessageDialog(viewListaEntrenador,
									"El entrenador se ha eliminado correctamente.");
							listadoEntrenadoresLlenarTabla(viewListaEntrenador.getJTableListaEntrenador());
						}
					}
				}
			}

		}
		if (viewListaEntrenador != null && e.getSource() == viewListaEntrenador.btnEditar1) {
			int filaSeleccionada = viewListaEntrenador.JTableListaEntrenador.getSelectedRow();
			ArrayList<Entrenador> listaEntrenador = entrenadorDao.listaEntrenador();
			Boolean filaEditada;
			if (filaSeleccionada != -1) {
				if (listaEntrenador != null) {
					String identificacion = listaEntrenador.get(filaSeleccionada).getIdentificacion();
					Entrenador entrenador = entrenadorDao.buscarEntrenador(identificacion);
					if (entrenador != null) {
						viewActualizarEntrenador = new ActualizarEntrenador();
						String numeroId = entrenador.getIdentificacion();
						viewActualizarEntrenador.getTxtNumeroid().setText(identificacion);
						viewActualizarEntrenador.getTxtNumeroid().setEditable(false);
						String primerNombre = entrenador.getPrimerNombre();
						viewActualizarEntrenador.getTxtPrimernombre().setText(primerNombre);
						viewActualizarEntrenador.getTxtPrimernombre().setEditable(false);
						String segundoNombre = entrenador.getSegundoNombre();
						viewActualizarEntrenador.getTxtSegundoNombre().setText(segundoNombre);
						viewActualizarEntrenador.getTxtSegundoNombre().setEditable(false);
						String primerApellido = entrenador.getPrimerApellido();
						viewActualizarEntrenador.getTxtPrimerapellido().setText(primerApellido);
						viewActualizarEntrenador.getTxtPrimerapellido().setEditable(false);
						String segundoApellido = entrenador.getSegundoApellido();
						viewActualizarEntrenador.getTxtSegundoapellido().setText(segundoApellido);
						viewActualizarEntrenador.getTxtSegundoapellido().setEnabled(false);
						String telefono = viewActualizarEntrenador.getTxtTelefono().getText();
						entrenador.setTelefono(telefono);
						String correoElectronico = viewActualizarEntrenador.getTxtCorreoelectronico().getText();
						entrenador.setCorreo(correoElectronico);
						viewActualizarEntrenador.setVisible(true);
						viewActualizarEntrenador.getBtnActualizar1().addActionListener(this);
					}

				}
			}
		}
		if (viewActualizarEntrenador != null && e.getSource() == viewActualizarEntrenador.btnActualizar1) {
			String numeroId = viewActualizarEntrenador.getTxtNumeroid().getText();
			String primerNombre = viewActualizarEntrenador.getTxtPrimernombre().getText();
			String segundoNombre = viewActualizarEntrenador.getTxtSegundoNombre().getText();
			String primerApellido = viewActualizarEntrenador.getTxtPrimerapellido().getText();
			String segundoApellido = viewActualizarEntrenador.getTxtSegundoapellido().getText();
			String telefono = viewActualizarEntrenador.getTxtTelefono().getText();
			String correoElectronico = viewActualizarEntrenador.getTxtCorreoelectronico().getText();

			boolean respuesta = entrenadorDao.modificarEntrenador(numeroId, primerNombre, segundoNombre, primerApellido,
					segundoApellido, null, correoElectronico, telefono, 0);
			if (respuesta) {
				JOptionPane.showMessageDialog(null, "los datos se actualizaron exitosamente");
			} else {
				JOptionPane.showMessageDialog(null, "Ocurrio un error actualizando los datos del entrenador.");
			}
		}

	}
}

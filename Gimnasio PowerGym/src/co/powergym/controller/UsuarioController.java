package co.powergym.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.powergym.dao.UsuarioDao;
import co.powergym.model.Usuario;
import co.powergym.view.entrenador.ActualizarEntrenador;
import co.powergym.view.entrenador.BusquedaEntrenador;
import co.powergym.view.entrenador.ListaEntrenador;
import co.powergym.view.entrenador.RegistroEntrenador;

public class UsuarioController implements ActionListener {

	UsuarioDao usuarioDao;
	RegistroEntrenador viewRegistroEntrenador;
	BusquedaEntrenador viewBusquedantrenador;
	ListaEntrenador viewListaEntrenador;
	ActualizarEntrenador viewActualizarEntrenador;

	public UsuarioController(UsuarioDao entrenadorDao, RegistroEntrenador viewRegistroEntrenador,
			BusquedaEntrenador viewBusquedaentrenador, ListaEntrenador viewListaEntrenador,
			ActualizarEntrenador viewActualizarEntrenador) {
		this.usuarioDao = entrenadorDao;
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
		List<Usuario> listEntrenadores = usuarioDao.listaUsuario();
		int numeroRegistros = listEntrenadores.size();

		for (int i = 0; i < numeroRegistros; i++) {
			columna[0] = listEntrenadores.get(i).getIdentificacion();
			//columna[1] = listEntrenadores.get(i).getNombreCompleto();
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
				Usuario usuario = usuarioDao.buscarUsuario(numeroId);
				if (usuario == null) {

					String nombre = viewRegistroEntrenador.getTxtNombre().getText();
					if (nombre == null || nombre.equals("")) {
						JOptionPane.showMessageDialog(null, "El campo primer nombre no puede estar vacio.");
					} else {
						
						String apellido = viewRegistroEntrenador.getTxtPrimerapellido().getText();
						if (apellido == null || apellido.equals("")) {
							JOptionPane.showMessageDialog(null, "El campo primer apellido no puede estar vacio.");
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
										// TODO: Completar campos
										String username = "";
										String password = "";
										boolean respuesta = usuarioDao.registrarUsuario(numeroId, nombre,
												apellido, fechaNacimiento, correo,
												telefono, genero, username, password);
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
			Usuario usuario = usuarioDao.buscarUsuario(numeroId);
			if (usuario != null) {
				String primerNombre = usuario.getNombre();
				viewBusquedantrenador.getTxtNombre().setText(primerNombre);
				String primerApellido = usuario.getApellido();
				viewBusquedantrenador.getTxtPrimerapellido().setText(primerApellido);
				// String fechaNacimiento =
				// String.valueOf(entrenador.getFechaNacimiento());
				// viewBusquedantrenador.txtfechaNacimiento.setText(fechaNacimiento);
				String telefono = usuario.getTelefono();
				viewBusquedantrenador.getTxtTelefono().setText(telefono);
				String correo = usuario.getCorreo();
				viewBusquedantrenador.getTxtCorreoelectronico().setText(correo);
			} else {
				JOptionPane.showMessageDialog(null,
						"No se encontró un usuario con ese número de identificación, por favor verifique");
			}
		} else if (viewBusquedantrenador != null && e.getSource() == viewBusquedantrenador.btnCancelar1) {
			viewBusquedantrenador.setVisible(false);
			viewBusquedantrenador.dispose();
		} else if (viewListaEntrenador != null && e.getSource() == viewListaEntrenador.btnEliminar1) {
			int filaSeleccionada = viewListaEntrenador.JTableListaEntrenador.getSelectedRow();
			ArrayList<Usuario> listaEntrenador = usuarioDao.listaUsuario();
			Boolean filaEliminada;
			if (filaSeleccionada != -1) {
				if (listaEntrenador != null) {
					String identificacion = listaEntrenador.get(filaSeleccionada).getIdentificacion();
					int optiopn = JOptionPane.showConfirmDialog(viewListaEntrenador,
							"¿Esta seguro de eliminar el entrenador con identificación " + identificacion + " ?");
					if (JOptionPane.YES_OPTION == optiopn) {
						filaEliminada = usuarioDao.eliminarUsuario(identificacion);
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
			ArrayList<Usuario> listaEntrenador = usuarioDao.listaUsuario();
			Boolean filaEditada;
			if (filaSeleccionada != -1) {
				if (listaEntrenador != null) {
					String identificacion = listaEntrenador.get(filaSeleccionada).getIdentificacion();
					Usuario entrenador = usuarioDao.buscarUsuario(identificacion);
					if (entrenador != null) {
						viewActualizarEntrenador = new ActualizarEntrenador();
						String numeroId = entrenador.getIdentificacion();
						viewActualizarEntrenador.getTxtNumeroid().setText(identificacion);
						viewActualizarEntrenador.getTxtNumeroid().setEditable(false);
						String primerNombre = entrenador.getNombre();
						viewActualizarEntrenador.getTxtPrimernombre().setText(primerNombre);
						viewActualizarEntrenador.getTxtPrimernombre().setEditable(false);
						String primerApellido = entrenador.getApellido();
						viewActualizarEntrenador.getTxtPrimerapellido().setText(primerApellido);
						viewActualizarEntrenador.getTxtPrimerapellido().setEditable(false);
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
			String primerApellido = viewActualizarEntrenador.getTxtPrimerapellido().getText();
			String telefono = viewActualizarEntrenador.getTxtTelefono().getText();
			String correoElectronico = viewActualizarEntrenador.getTxtCorreoelectronico().getText();
			// TODO: Completar campos
			String username = "";
			String password = "";
			boolean respuesta = usuarioDao.modificarUsuario(numeroId, primerNombre, primerApellido,
					null, correoElectronico, telefono, 0, username, password);
			if (respuesta) {
				JOptionPane.showMessageDialog(null, "los datos se actualizaron exitosamente");
			} else {
				JOptionPane.showMessageDialog(null, "Ocurrio un error actualizando los datos del entrenador.");
			}
		}

	}
}

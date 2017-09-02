package co.powergym.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.powergym.dao.PermisoDao;
import co.powergym.dao.PermisoUsuarioDao;
import co.powergym.dao.UsuarioDao;
import co.powergym.model.Permiso;
import co.powergym.model.PermisoUsuario;
import co.powergym.model.Usuario;
import co.powergym.view.usuario.entrenador.UsuarioEntrenador;
import co.powergym.view.usuario.entrenador.BusquedaUsuario;
import co.powergym.view.usuario.entrenador.ListaUsuario;
import co.powergym.view.usuario.entrenador.RegistroUsuario;

public class UsuarioController implements ActionListener {


	UsuarioDao usuarioDao;
	PermisoDao permisoDao;
	PermisoUsuarioDao permisoUsuarioDao;
	RegistroUsuario viewRegistroUsuario;
	BusquedaUsuario viewBusquedaUsuario;
	ListaUsuario viewListaUsuario;
	UsuarioEntrenador viewActualizarUsuario;
	List<PermisoUsuario>permisosAsignados;

	public UsuarioController(UsuarioDao usuarioDao,PermisoDao permisoDao, PermisoUsuarioDao permisoUsuarioDao, RegistroUsuario viewRegistroUsuario,
			BusquedaUsuario viewBusquedaUsuario, ListaUsuario viewListaUsuario,
			UsuarioEntrenador viewActualizarUsuario) {
		this.usuarioDao = usuarioDao;
		this.permisoDao = permisoDao;
		this.viewRegistroUsuario = viewRegistroUsuario;
		this.viewBusquedaUsuario = viewBusquedaUsuario;
		
		if (viewRegistroUsuario != null) {
			this.viewRegistroUsuario = viewRegistroUsuario;
			llenarTablaPermisos(viewRegistroUsuario.getTablePermisos());
			this.viewRegistroUsuario.btnRegistrar.addActionListener(this);
			this.viewRegistroUsuario.btnCancelar.addActionListener(this);
			this.viewRegistroUsuario.setVisible(true);
		}
		if (viewBusquedaUsuario != null) {
			this.viewBusquedaUsuario.btnBuscar1.addActionListener(this);
			this.viewBusquedaUsuario.btnCancelar1.addActionListener(this);
			this.viewBusquedaUsuario.setVisible(true);
		}
		if (viewListaUsuario != null) {
			this.viewListaUsuario = viewListaUsuario;
			listadoUsuariosLlenarTabla(viewListaUsuario.getJTableListaEntrenador());
			this.viewListaUsuario.btnEditar1.addActionListener(this);
			this.viewListaUsuario.btnEliminar1.addActionListener(this);
			this.viewListaUsuario.setVisible(true);
		}
		if (viewActualizarUsuario != null) {
			this.viewActualizarUsuario = viewActualizarUsuario;
			this.viewActualizarUsuario.btnActualizar1.addActionListener(this);
			this.viewActualizarUsuario.setVisible(true);
		}

	}

	public void listadoUsuariosLlenarTabla(JTable tablaUsuarios) {
		DefaultTableModel defaultTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Nro. identificación", "Nombre", "Dirección", "Correo electronico", "Teléfono" });

		Object[] columna = new Object[5];
		List<Usuario> listUsuarios = usuarioDao.listaUsuario();
		int numeroRegistros = listUsuarios.size();

		for (int i = 0; i < numeroRegistros; i++) {
			columna[0] = listUsuarios.get(i).getIdentificacion();
			// columna[1] = listEntrenadores.get(i).getNombreCompleto();
			columna[2] = listUsuarios.get(i).getDireccion();
			columna[3] = listUsuarios.get(i).getCorreo();
			columna[4] = listUsuarios.get(i).getTelefono();
			defaultTableModel.addRow(columna);
		}
		tablaUsuarios.setModel(defaultTableModel);
		tablaUsuarios.repaint();
	}
	
	
	/** Método para listar todos los permisos del sistema*/
	public void llenarTablaPermisos(JTable tablaPermisos) {
		DefaultTableModel defaultTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Nombre", "Fecha creación", "Fecha modificación" });
		
		Object[] columna = new Object[3];
		List<Permiso> listPermisos = permisoDao.listaPermisos();
		int numeroRegistros = listPermisos.size();
		
		for (int i = 0; i < numeroRegistros; i++) {
			columna[0] = listPermisos.get(i).getNombre();
			columna[2] = listPermisos.get(i).getFechaCreacion();
			columna[3] = listPermisos.get(i).getFechaModificacion();
			defaultTableModel.addRow(columna);
		}
		tablaPermisos.setModel(defaultTableModel);
		tablaPermisos.repaint();
	}
	

	/**
	 * @return the permisosAsignados
	 */
	public List<PermisoUsuario> getPermisosAsignados() {
		return permisosAsignados;
	}

	/**
	 * @param permisosAsignados the permisosAsignados to set
	 */
	public void setPermisosAsignados(List<PermisoUsuario> permisosAsignados) {
		this.permisosAsignados = permisosAsignados;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (viewRegistroUsuario != null && e.getSource() == viewRegistroUsuario.btnRegistrar) {
			try {
				String numeroId = viewRegistroUsuario.getTxtNumeroid().getText();
				Usuario usuario = usuarioDao.buscarUsuario(numeroId);
				if (usuario == null) {

					String nombre = viewRegistroUsuario.getTxtNombre().getText();
					if (nombre == null || nombre.equals("")) {
						JOptionPane.showMessageDialog(null, "El campo nombre no puede estar vacio.");
					} else {

						String apellido = viewRegistroUsuario.getTxtPrimerapellido().getText();
						if (apellido == null || apellido.equals("")) {
							JOptionPane.showMessageDialog(null, "El campo apellido no puede estar vacio.");
						} else {
							Date fechaNacimiento = null;

							if (viewRegistroUsuario.getDateChooser_fechaNacimiento().getDate() == null) {
								JOptionPane.showMessageDialog(null,
										"El campo fecha de nacimiento no puede estar vacio.");
							} else {
								fechaNacimiento = new Date(
										viewRegistroUsuario.getDateChooser_fechaNacimiento().getDate().getTime());

								String telefono = viewRegistroUsuario.getTxtTelefono().getText();
								if (telefono == null || telefono.equals("")) {
									JOptionPane.showMessageDialog(null, "El campo telefóno no puede estar vacio.");
								} else {
									String correo = viewRegistroUsuario.getTxtCorreoelectronico().getText();
									int genero = 0;
									if (viewRegistroUsuario.getComboBox_genero() != null) {
										genero = viewRegistroUsuario.getComboBox_genero().getSelectedIndex();
									}

									if (correo == null || correo.equals("")) {
										JOptionPane.showMessageDialog(null,
												"El campo correo electrónico no puede estar vacio.");
									}
									//permiso seleccionado									
									int filaSeleccionada = viewRegistroUsuario.getTablePermisos().getSelectedRow();
									ArrayList<Permiso> listaPermiso = permisoDao.listaPermisos();
									
									Boolean filaPermisoAsignar;
									if (filaSeleccionada != -1) {
										if (listaPermiso != null) {
											int idPermiso = listaPermiso.get(filaSeleccionada).getId();
											Permiso permisoSeleccionado = permisoDao.buscarPermiso(idPermiso);
											
											//id del usuario que recibe permisos
											int id_usuario = usuario.getId();
											
											//id del permiso asgiando al usuario
											int id_permiso = permisoSeleccionado.getId();
											
											//Nombre del permiso asignado
											String nombrePermiso = permisoSeleccionado.getNombre();
											int option = JOptionPane.showConfirmDialog(viewRegistroUsuario,
													"¿Esta seguro de asignar estos permisos " + nombrePermiso + " ?");
											if (JOptionPane.YES_OPTION == option) {
												filaPermisoAsignar = permisoUsuarioDao.registrarPermisoUsuario(id_usuario, id_permiso);
												//permisosAsignados = permisoUsuarioDao.listaPermisoUsuario();
												
												if (filaPermisoAsignar == true) {
													JOptionPane.showMessageDialog(viewRegistroUsuario,
															"Los permisos se asignaron exitosamente.");
													listadoUsuariosLlenarTabla(viewListaUsuario.getJTableListaEntrenador());
												}
											}
										}
									}
									
									// TODO: Completar campos
									String username = "";
									String password = "";
									boolean respuesta = usuarioDao.registrarUsuario(numeroId, nombre, apellido,
											fechaNacimiento, correo, telefono, genero, username, password);
									if (respuesta) {
										JOptionPane.showMessageDialog(null, "Registro exitoso");
									} else {
										JOptionPane.showMessageDialog(null,
												"Ocurrio un error registrando un nuevo usuario.");
									}
								}
							}
						}
					}

				} else {
					JOptionPane.showMessageDialog(null, "El usuario ya se encuentra registrado");
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}

		} else if (viewRegistroUsuario != null && e.getSource() == viewRegistroUsuario.btnCancelar) {
			viewRegistroUsuario.setVisible(false);
			viewRegistroUsuario.dispose();
		} else if (viewBusquedaUsuario != null && e.getSource() == viewBusquedaUsuario.btnBuscar1) {

			String numeroId = viewBusquedaUsuario.getTxtNumeroid().getText();
			Usuario usuario = usuarioDao.buscarUsuario(numeroId);
			if (usuario != null) {
				String primerNombre = usuario.getNombre();
				viewBusquedaUsuario.getTxtNombre().setText(primerNombre);
				String primerApellido = usuario.getApellido();
				viewBusquedaUsuario.getTxtPrimerapellido().setText(primerApellido);
				// String fechaNacimiento =
				// String.valueOf(entrenador.getFechaNacimiento());
				// viewBusquedantrenador.txtfechaNacimiento.setText(fechaNacimiento);
				String telefono = usuario.getTelefono();
				viewBusquedaUsuario.getTxtTelefono().setText(telefono);
				String correo = usuario.getCorreo();
				viewBusquedaUsuario.getTxtCorreoelectronico().setText(correo);
			} else {
				JOptionPane.showMessageDialog(null,
						"No se encontró un usuario con ese número de identificación, por favor verifique");
			}
		} else if (viewBusquedaUsuario != null && e.getSource() == viewBusquedaUsuario.btnCancelar1) {
			viewBusquedaUsuario.setVisible(false);
			viewBusquedaUsuario.dispose();
		} else if (viewListaUsuario != null && e.getSource() == viewListaUsuario.btnEliminar1) {
			int filaSeleccionada = viewListaUsuario.JTableListaEntrenador.getSelectedRow();
			ArrayList<Usuario> listaUsuario = usuarioDao.listaUsuario();
			Boolean filaEliminada;
			if (filaSeleccionada != -1) {
				if (listaUsuario != null) {
					String identificacion = listaUsuario.get(filaSeleccionada).getIdentificacion();
					int optiopn = JOptionPane.showConfirmDialog(viewListaUsuario,
							"¿Esta seguro de eliminar el usuario con identificación " + identificacion + " ?");
					if (JOptionPane.YES_OPTION == optiopn) {
						filaEliminada = usuarioDao.eliminarUsuario(identificacion);
						if (filaEliminada == true) {

							JOptionPane.showMessageDialog(viewListaUsuario,
									"El usuario se ha eliminado correctamente.");
							listadoUsuariosLlenarTabla(viewListaUsuario.getJTableListaEntrenador());
						}
					}
				}
			}

		}
		if (viewListaUsuario != null && e.getSource() == viewListaUsuario.btnEditar1) {
			int filaSeleccionada = viewListaUsuario.JTableListaEntrenador.getSelectedRow();
			ArrayList<Usuario> listaUsuario = usuarioDao.listaUsuario();
			Boolean filaEditada;
			if (filaSeleccionada != -1) {
				if (listaUsuario != null) {
					String identificacion = listaUsuario.get(filaSeleccionada).getIdentificacion();
					Usuario entrenador = usuarioDao.buscarUsuario(identificacion);
					if (entrenador != null) {
						viewActualizarUsuario = new UsuarioEntrenador();
						String numeroId = entrenador.getIdentificacion();
						viewActualizarUsuario.getTxtNumeroid().setText(identificacion);
						viewActualizarUsuario.getTxtNumeroid().setEditable(false);
						String nombre = entrenador.getNombre();
						viewActualizarUsuario.getTxtNombre().setText(nombre);
						viewActualizarUsuario.getTxtNombre().setEditable(false);
						String apellido = entrenador.getApellido();
						viewActualizarUsuario.getTxtApellido().setText(apellido);
						viewActualizarUsuario.getTxtApellido().setEditable(false);
						String telefono = viewActualizarUsuario.getTxtTelefono().getText();
						entrenador.setTelefono(telefono);
						String correoElectronico = viewActualizarUsuario.getTxtCorreoelectronico().getText();
						entrenador.setCorreo(correoElectronico);
						viewActualizarUsuario.setVisible(true);
						viewActualizarUsuario.getBtnActualizar1().addActionListener(this);
					}
				}
			}
		}
		if (viewActualizarUsuario != null && e.getSource() == viewActualizarUsuario.btnActualizar1) {
			String numeroId = viewActualizarUsuario.getTxtNumeroid().getText();
			String nombre = viewActualizarUsuario.getTxtNombre().getText();
			String apellido = viewActualizarUsuario.getTxtApellido().getText();
			String telefono = viewActualizarUsuario.getTxtTelefono().getText();
			String correoElectronico = viewActualizarUsuario.getTxtCorreoelectronico().getText();
			// TODO: Completar campos
			String username = "";
			String password = "";
			boolean respuesta = usuarioDao.modificarUsuario(numeroId, nombre, apellido, null,
					correoElectronico, telefono, 0, username, password);
			if (respuesta) {
				JOptionPane.showMessageDialog(null, "los datos se actualizaron exitosamente");
			} else {
				JOptionPane.showMessageDialog(null, "Ocurrio un error actualizando los datos del usuario.");
			}
		}

	}
}

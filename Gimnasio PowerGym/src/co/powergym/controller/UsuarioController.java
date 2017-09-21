package co.powergym.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
<<<<<<< HEAD
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
=======
import java.util.Date;
>>>>>>> 46c0f968f8d8db3cc60ffdae7e39878b95a139ae
import java.util.ArrayList;
import java.util.List;
//import java.util.Date;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import co.powergym.dao.PermisoDao;
import co.powergym.dao.PermisoUsuarioDao;
import co.powergym.dao.UsuarioDao;
import co.powergym.model.Permiso;
import co.powergym.model.PermisoUsuario;
import co.powergym.model.Usuario;
import co.powergym.view.usuario.entrenador.ActualizarUsuario;
import co.powergym.view.usuario.entrenador.BusquedaUsuario;
import co.powergym.view.usuario.entrenador.ListaUsuario;
import co.powergym.view.usuario.entrenador.RegistroUsuario;

public class UsuarioController implements ActionListener {

	/**
	 * 
	 */
	UsuarioDao usuarioDao;
	PermisoDao permisoDao;
	PermisoUsuarioDao permisoUsuarioDao;
	RegistroUsuario viewRegistroUsuario;
	BusquedaUsuario viewBusquedaUsuario;
	ListaUsuario viewListaUsuario;
	ActualizarUsuario viewActualizarUsuario;
	List<PermisoUsuario> permisosAsignados;
	ArrayList<Permiso> listaPermiso = new ArrayList<>();

	public UsuarioController(UsuarioDao usuarioDao, PermisoDao permisoDao, PermisoUsuarioDao permisoUsuarioDao,
			RegistroUsuario viewRegistroUsuario, BusquedaUsuario viewBusquedaUsuario, ListaUsuario viewListaUsuario,
			ActualizarUsuario viewActualizarUsuario) {
		this.usuarioDao = usuarioDao;
		this.permisoDao = permisoDao;
		this.permisoUsuarioDao = new PermisoUsuarioDao();
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
			llenarTablaPermisos(viewActualizarUsuario.getTablePermisos());
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
<<<<<<< HEAD
			columna[1] = listUsuarios.get(i).getDireccion();
			columna[2] = listUsuarios.get(i).getCorreo();
			columna[3] = listUsuarios.get(i).getTelefono();
=======
			columna[1] = listUsuarios.get(i).getNombre();
			columna[2] = listUsuarios.get(i).getDireccion();
			columna[3] = listUsuarios.get(i).getCorreo();
			columna[4] = listUsuarios.get(i).getTelefono();
>>>>>>> 46c0f968f8d8db3cc60ffdae7e39878b95a139ae
			defaultTableModel.addRow(columna);
		}
		tablaUsuarios.setModel(defaultTableModel);
		tablaUsuarios.repaint();
	}

	/** Método para listar todos los permisos del sistema */
	public void llenarTablaPermisos(JTable tablaPermisos) {
		DefaultTableModel defaultTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Nombre", "Fecha creación", "Fecha modificación", "Asignar" });

		Object[] columna = new Object[4];
		List<Permiso> listPermisos = permisoDao.listaPermisos();
		int numeroRegistros = listPermisos.size();
		for (int i = 0; i < numeroRegistros; i++) {
			columna[0] = listPermisos.get(i).getNombre();
			columna[1] = listPermisos.get(i).getFechaCreacion();
			columna[2] = listPermisos.get(i).getFechaModificacion();
			columna[3] = new JRadioButton("");
			defaultTableModel.addRow(columna);

		}
		tablaPermisos.setModel(defaultTableModel);
		tablaPermisos.repaint();
		tablaPermisos.getColumn("Asignar").setCellRenderer(new Radiorender());
		tablaPermisos.getColumn("Asignar").setCellEditor(new Radio(new JCheckBox()));

	}

	/**
	 * @return the permisosAsignados
	 */
	public List<PermisoUsuario> getPermisosAsignados() {
		return permisosAsignados;
	}

	/**
	 * @param permisosAsignados
	 *            the permisosAsignados to set
	 */
	public void setPermisosAsignados(List<PermisoUsuario> permisosAsignados) {
		this.permisosAsignados = permisosAsignados;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (viewRegistroUsuario != null && e.getSource() == viewRegistroUsuario.btnRegistrar) {
			try {
				String numeroId = viewRegistroUsuario.getTxtNumeroid().getText();

				String username = "";
				String correo = "";
				String contrasena = "";
				String confirmaC = "";
				String telefono = "";
				String apellido = "";
				int genero = 0;
				Date fechaNacimiento = null;
				boolean respuesta = false;

				String nombre = viewRegistroUsuario.getTxtNombre().getText();
				if (nombre == null || nombre.equals("")) {
					JOptionPane.showMessageDialog(null, "El campo nombre no puede estar vacio.");
				} else {

					apellido = viewRegistroUsuario.getTxtPrimerapellido().getText();
					if (apellido == null || apellido.equals("")) {
						JOptionPane.showMessageDialog(null, "El campo apellido no puede estar vacio.");
					} else {

						if (viewRegistroUsuario.getDateChooser_fechaNacimiento().getDate() == null) {
							JOptionPane.showMessageDialog(null, "El campo fecha de nacimiento no puede estar vacio.");
						} else {
							fechaNacimiento = new Date(
									viewRegistroUsuario.getDateChooser_fechaNacimiento().getDate().getTime());
						}
					}
					telefono = viewRegistroUsuario.getTxtTelefono().getText();
					if (telefono == null || telefono.equals("")) {
						JOptionPane.showMessageDialog(null, "El campo telefóno no puede estar vacio.");
					} else {
						correo = viewRegistroUsuario.getTxtCorreoelectronico().getText();
						genero = 0;
						if (viewRegistroUsuario.getComboBox_genero() != null) {
							genero = viewRegistroUsuario.getComboBox_genero().getSelectedIndex();
						}

						if (correo == null || correo.equals("")) {
							JOptionPane.showMessageDialog(null, "El campo correo electrónico no puede estar vacio.");
						}

					}
					username = viewRegistroUsuario.getTextUsername().getText();
					contrasena = viewRegistroUsuario.getTextContrasena().getText();
					confirmaC = viewRegistroUsuario.getTextConfirmaC().getText();
					if (contrasena == null || contrasena.equals("")) {
						JOptionPane.showMessageDialog(null, "El campo contraseña no puede estar vacio.");
					} else if (!contrasena.equals(confirmaC)) {
						JOptionPane.showMessageDialog(null,
								"La contraseña no incide con los datos ingresados en el campo contrseña, por favor verifique.");
					}
				}
				respuesta = usuarioDao.registrarUsuario(numeroId, nombre, apellido, fechaNacimiento, correo, telefono,
						genero, username, contrasena);

				Usuario usuario = usuarioDao.buscarUsuario(numeroId);

				listaPermiso = permisoDao.listaPermisos();
				JRadioButton jRadioButton;
				ArrayList<Integer> seleccionados = new ArrayList<>();
				int idPermiso = 0;
				for (int i = 0; i < listaPermiso.size(); i++) {
					jRadioButton = (JRadioButton) viewRegistroUsuario.getTablePermisos().getValueAt(i, 3);
					if (jRadioButton.isSelected() == true) {
						idPermiso = listaPermiso.get(i).getId();
						seleccionados.add(idPermiso);
					}
				}
				Boolean filaPermisoAsignar = false;
				if (usuario != null) {

					int id_usuario = usuario.getId();
					int option = JOptionPane.showConfirmDialog(viewRegistroUsuario,
							"¿Esta seguro de asignar estos permisos?");
					if (JOptionPane.YES_OPTION == option) {
						for (int i = 0; i < seleccionados.size(); i++) {
							filaPermisoAsignar = permisoUsuarioDao.registrarPermisoUsuario(id_usuario,
									seleccionados.get(i));
						}
						if (filaPermisoAsignar == true) {
							JOptionPane.showMessageDialog(viewRegistroUsuario,
									"Los permisos se asignaron exitosamente.");
						}
					}
				}

				if (respuesta == true) {
					JOptionPane.showMessageDialog(null, "Registro exitoso");
				} else {
					JOptionPane.showMessageDialog(null, "Ocurrio un error registrando un nuevo usuario.");
				}

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}

		} else if (viewRegistroUsuario != null && e.getSource() == viewRegistroUsuario.btnCancelar) {
			viewRegistroUsuario.setVisible(false);
			viewRegistroUsuario.dispose();
		}
		if (viewListaUsuario != null && e.getSource() == viewListaUsuario.btnEditar1) {
			int filaSeleccionada = viewListaUsuario.JTableListaEntrenador.getSelectedRow();
			ArrayList<Usuario> listaUsuario = usuarioDao.listaUsuario();
			if (filaSeleccionada != -1) {
				if (listaUsuario != null) {
					String identificacion = listaUsuario.get(filaSeleccionada).getIdentificacion();
					Usuario usuario = usuarioDao.buscarUsuario(identificacion);
					if (usuario != null) {
						viewActualizarUsuario = new ActualizarUsuario();
						viewActualizarUsuario.getTxtNumeroid().setText(identificacion);
						String nombre = usuario.getNombre();
						viewActualizarUsuario.getTxtNombre().setText(nombre);
						String apellido = usuario.getApellido();
						viewActualizarUsuario.getTxtApellido().setText(apellido);
<<<<<<< HEAD
						viewActualizarUsuario.getTxtApellido().setEditable(false);
						Date fechaN = (Date) usuario.getFechaNacimiento();

						// viewActualizarUsuario.getTxtFechanacimiento().setText(fechaN.toString());
						viewActualizarUsuario.getTxtFechanacimiento().setEditable(false);
						String telefono = viewActualizarUsuario.getTxtTelefono().getText();
						usuario.setTelefono(telefono);
						String username = viewActualizarUsuario.getTextUsuario().getText();
						usuario.setUsuario(username);
						String contrasena = viewActualizarUsuario.getTextContrasena().getText();
						usuario.setContrasena(contrasena);
						String correoElectronico = viewActualizarUsuario.getTxtCorreoelectronico().getText();
						usuario.setCorreo(correoElectronico);
=======
						String telefono = usuario.getTelefono();
						viewActualizarUsuario.getTxtTelefono().setText(telefono);
						String username = usuario.getUsuario();
						viewActualizarUsuario.getTextUsuario().setText(username);
						String correoElectronico = usuario.getCorreo();
						viewActualizarUsuario.getTxtCorreoelectronico().setText(correoElectronico);
						Date fecha = usuario.getFechaNacimiento();
						viewActualizarUsuario.getFechaNacimiento().setDate(fecha);
						//El administrador la actualiza, y no la debe verificar
						String contrasena =  usuario.getContrasena();
						viewActualizarUsuario.getTextContrasena().setText(contrasena);;
						
>>>>>>> 46c0f968f8d8db3cc60ffdae7e39878b95a139ae
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
			String usuario = viewActualizarUsuario.getTextUsuario().getText();
			String confirmaC = viewActualizarUsuario.getTextconfirmaC().getText();
			String contrasena = viewActualizarUsuario.getTextContrasena().getText();
<<<<<<< HEAD
			String fechaNac = viewActualizarUsuario.getTxtFechanacimiento().getText();
			JOptionPane.showMessageDialog(viewActualizarUsuario, ""+correoElectronico);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
=======
			Date fecha = viewActualizarUsuario.getFechaNacimiento().getDate();

>>>>>>> 46c0f968f8d8db3cc60ffdae7e39878b95a139ae
			// Permisos del usuario
			int row = viewActualizarUsuario.getTablePermisos().getSelectedRow();
			int column = 3;
			JRadioButton JRadioseleccion;
			String password = null;
			if (contrasena.equals(confirmaC)) {
				password = contrasena;
			} else {
				JOptionPane.showMessageDialog(viewActualizarUsuario,
						"La contraseña y la confirmación no coinciden, por favor verifique.");
			}
<<<<<<< HEAD
			Date fechaNacimiento = null;
			try {
				fechaNacimiento = (Date) formatter.parse(fechaNac);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			boolean respuesta = usuarioDao.modificarUsuario(numeroId, nombre, apellido, fechaNacimiento, telefono,
					correoElectronico, 0, usuario, password);
=======

			boolean respuesta = usuarioDao.modificarUsuario(numeroId, nombre, apellido, fecha, correoElectronico,
					telefono, 0, usuario, password);
>>>>>>> 46c0f968f8d8db3cc60ffdae7e39878b95a139ae
			if (respuesta) {
				JOptionPane.showMessageDialog(null, "los datos se actualizaron exitosamente");
			} else {
				JOptionPane.showMessageDialog(null, "Ocurrio un error actualizando los datos del usuario.");
			}
		}

	}

	public class Radiorender implements TableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if (value == null) {
				return null;
			}
			return (Component) value;
		}
	}

	// Clases para pintar radiobutton en JTable de permisos que se asignan a un
	// usuario
	public class Radio extends DefaultCellEditor implements ItemListener {

		private static final long serialVersionUID = 1L;
		JRadioButton radioB;

		public Radio(JCheckBox checkBox) {
			super(checkBox);
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {

			if (value == null) {
				return null;
			}
			radioB = (JRadioButton) value;
			radioB.addItemListener(this);
			return (Component) value;
		}

		public Object getCellEditorValue() {
			radioB.removeItemListener(this);
			return radioB;
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			super.fireEditingStopped();
		}

	}

}

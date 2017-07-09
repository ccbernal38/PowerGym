package co.powergym.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.github.sarxos.webcam.Webcam;
import com.sun.java_cup.internal.runtime.virtual_parse_stack;

import co.powergym.dao.SocioDao;
import co.powergym.model.Socio;
import co.powergym.view.socio.SocioBusquedaView;
import co.powergym.view.socio.SocioConsultaEntradaView;
import co.powergym.view.socio.SocioCumpleaniosListadoView;
import co.powergym.view.socio.SocioListadoView;
import co.powergym.view.socio.SocioRegistroView;
import co.powergym.view.socio.SocioRegistrarEntradaView;

public class SocioController implements ActionListener {

	Webcam webcam;
	SocioDao socioDao;

	SocioRegistroView viewRegistroSocio;
	SocioBusquedaView viewBusquedaSocio;
	SocioListadoView viewListadoSocio;
	SocioCumpleaniosListadoView viewCumpleaniosListadoView;
	SocioRegistrarEntradaView viewRegistrarEntrada;
	SocioConsultaEntradaView viewConsultarEntrada;
	private BufferedImage fotoTemp;

	public SocioController(SocioDao socioDao, SocioRegistroView viewRegistroSocio, SocioBusquedaView viewBusquedaSocio,
			SocioListadoView socioListadoView, SocioCumpleaniosListadoView cumpleaniosListadoView,
			SocioRegistrarEntradaView registrarEntradaView, SocioConsultaEntradaView consultaEntradaView) {
		this.socioDao = socioDao;
		if (viewRegistroSocio != null) {
			webcam = Webcam.getWebcams().get(0);
			this.viewRegistroSocio = viewRegistroSocio;
			this.viewRegistroSocio.btnTomarFoto.addActionListener(this);
			this.viewRegistroSocio.btnCapturar.addActionListener(this);
			this.viewRegistroSocio.btnRegistrar.addActionListener(this);
			this.viewRegistroSocio.btnCancelar.addActionListener(this);
			this.viewRegistroSocio.setVisible(true);
			this.viewRegistroSocio.setWebcam(webcam);
		}
		if (viewBusquedaSocio != null) {
			this.viewBusquedaSocio = viewBusquedaSocio;
			this.viewBusquedaSocio.btnBuscar.addActionListener(this);
			this.viewBusquedaSocio.setVisible(true);
		}
		if (socioListadoView != null) {
			this.viewListadoSocio = socioListadoView;
			listadoSociosLlenarTabla(viewListadoSocio.getTableSocios());
			this.viewListadoSocio.setVisible(true);
		}
		if (cumpleaniosListadoView != null) {
			this.viewCumpleaniosListadoView = cumpleaniosListadoView;
			listadoCumpleaniosLlenarTabla(viewCumpleaniosListadoView.getTableSocios());
			this.viewCumpleaniosListadoView.setVisible(true);
		}
		if (registrarEntradaView != null) {
			this.viewRegistrarEntrada = registrarEntradaView;
			this.viewRegistrarEntrada.setVisible(true);
			this.viewRegistrarEntrada.getBtnIdentificar().addActionListener(this);
		}
		if (consultaEntradaView != null) {
			this.viewConsultarEntrada = consultaEntradaView;
			this.viewConsultarEntrada.setVisible(true);

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (viewRegistroSocio != null && e.getSource() == viewRegistroSocio.btnRegistrar) {
			try {
				String numeroId = viewRegistroSocio.getTextField_identificacion().getText();
				Socio socio = socioDao.buscarSocio(numeroId);
				if (socio == null) {
					String primerNombre = viewRegistroSocio.getTextField_primerNombre().getText();
					if (primerNombre == null || primerNombre.equals("")) {
						JOptionPane.showMessageDialog(null, "El campo primer nombre no puede estar vacio.");
					} else {
						String segundoNombre = viewRegistroSocio.getTextField_segundoNombre().getText();
						String primerApellido = viewRegistroSocio.getTextField_primerApellido().getText();
						if (primerApellido == null || primerApellido.equals("")) {
							JOptionPane.showMessageDialog(null, "El campo primer apellido no puede estar vacio.");
						} else {
							String segundoApellido = viewRegistroSocio.getTextField_segundoApellido().getText();
							Date fechaNacimiento = null;
							if (viewRegistroSocio.getDateChooser_fechaNacimiento().getDate() == null) {
								JOptionPane.showMessageDialog(null,
										"El campo fecha de nacimiento no puede estar vacio.");
							} else {
								fechaNacimiento = new Date(
										viewRegistroSocio.getDateChooser_fechaNacimiento().getDate().getTime());

								String telefono = viewRegistroSocio.getTextField_telefono().getText();
								String correo = viewRegistroSocio.getTextField_correo().getText();
								int genero = viewRegistroSocio.getComboBox_genero().getSelectedIndex();

								if (fotoTemp == null) {
									fotoTemp = ImageIO.read(new File("image/avatar.png"));
								}

								boolean respuesta = socioDao.registrarSocio(numeroId, fechaNacimiento, primerNombre,
										segundoNombre, primerApellido, segundoApellido, correo, telefono, genero,
										fotoTemp);
								if (respuesta) {
									JOptionPane.showMessageDialog(null, "Registro exitoso");
									viewRegistroSocio.setVisible(false);
									viewRegistroSocio = null;
								} else {
									JOptionPane.showMessageDialog(null, "Ocurrio un error registrando un nuevo socio.");
								}
							}
						}
					}

				} else {
					JOptionPane.showMessageDialog(null, "El socio ya se encuentra registrado");
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (viewRegistroSocio != null && e.getSource() == viewRegistroSocio.getBtnCapturar()) {

			viewRegistroSocio.getBtnTomarFoto().setEnabled(true);
			viewRegistroSocio.getWebcamPanel().start();

		} else if (viewRegistroSocio != null && e.getSource() == viewRegistroSocio.btnCancelar) {
			viewRegistroSocio.dispose();
		} else if (viewRegistroSocio != null && e.getSource() == viewRegistroSocio.getBtnTomarFoto()) {
			fotoTemp = viewRegistroSocio.getWebcam().getImage();
			viewRegistroSocio.getWebcamPanel().stop();
			viewRegistroSocio.getWebcamPanel().setVisible(false);
			JLabel jLabel = new JLabel(new ImageIcon(fotoTemp));
			jLabel.setBounds(viewRegistroSocio.getWebcamPanel().getBounds());
			viewRegistroSocio.getPanel().add(jLabel);
			viewRegistroSocio.btnTomarFoto.setEnabled(false);
			viewRegistroSocio.btnCapturar.setEnabled(false);

		} else if (viewBusquedaSocio != null && e.getSource() == viewBusquedaSocio.btnBuscar) {

			String numeroId = viewBusquedaSocio.getTextField_identidad().getText();
			Socio socio = socioDao.buscarSocio(numeroId);
			if (socio != null) {
				String primerNombre = socio.getNombreCompleto();
				viewBusquedaSocio.getTextField_primerNombre().setText(primerNombre);
				String fechaNacimiento = String.valueOf(socio.getFechaNacimiento());
				viewBusquedaSocio.getTextField_fechaNacimiento().setText(fechaNacimiento);
				String telefono = socio.getTelefono();
				viewBusquedaSocio.getTextField_telefono().setText(telefono);

				if (socio.getFoto() != null) {
					Image dimg = socio.getFoto().getScaledInstance(viewBusquedaSocio.getLblFoto().getWidth(),
							viewBusquedaSocio.getLblFoto().getHeight(), Image.SCALE_REPLICATE);
					viewBusquedaSocio.getLblFoto().setIcon(new ImageIcon(dimg));
				}

			} else {
				JOptionPane.showMessageDialog(null, "No se encontrÃ³ un socio con ese nÃºmero de identificaciÃ³n, "
						+ "por favor verique e intente de nuevo");
			}
		} else if (viewRegistrarEntrada != null && e.getSource() == viewRegistrarEntrada) {

		} 
	}

	public void listadoSociosLlenarTabla(JTable tabla) {
		DefaultTableModel defaultTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Nro. identificacion", "Nombre", "Dirección", "Correo electrónico", "Teléfono" });

		Object[] columna = new Object[5];
		List<Socio> listSocios = socioDao.listaSocios();
		int numeroRegistros = listSocios.size();

		for (int i = 0; i < numeroRegistros; i++) {
			columna[0] = listSocios.get(i).getIdentificacion();
			columna[1] = listSocios.get(i).getNombreCompleto();
			columna[2] = listSocios.get(i).getDireccion();
			columna[3] = listSocios.get(i).getCorreo();
			columna[4] = listSocios.get(i).getTelefono();
			defaultTableModel.addRow(columna);
		}
		tabla.setModel(defaultTableModel);
		tabla.repaint();

	}

	public void listadoCumpleaniosLlenarTabla(JTable tableSocios) {

		DefaultTableModel defaultTableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Nro. identificacion", "Nombre", "Fecha de cumpleaños" });

		Object[] columna = new Object[3];
		List<Socio> listSocios = socioDao.sociosCumpleaniosMes();
		int numeroRegistros = listSocios.size();

		for (int i = 0; i < numeroRegistros; i++) {
			columna[0] = listSocios.get(i).getIdentificacion();
			columna[1] = listSocios.get(i).getNombreCompleto();

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(listSocios.get(i).getFechaNacimiento());
			int mesTemp = calendar.get(Calendar.MONTH) + 1;
			String mes = "";
			if (mesTemp == 1) {
				mes = "Enero";
			} else if (mesTemp == 2) {
				mes = "Febrero";
			} else if (mesTemp == 3) {
				mes = "Marzo";
			} else if (mesTemp == 4) {
				mes = "Abril";
			} else if (mesTemp == 5) {
				mes = "Mayo";
			} else if (mesTemp == 6) {
				mes = "Junio";
			} else if (mesTemp == 7) {
				mes = "Julio";
			} else if (mesTemp == 8) {
				mes = "Agosto";
			} else if (mesTemp == 9) {
				mes = "Septiembre";
			} else if (mesTemp == 10) {
				mes = "Octubre";
			} else if (mesTemp == 11) {
				mes = "Noviembre";
			} else if (mesTemp == 12) {
				mes = "Diciembre";
			}

			columna[2] = calendar.get(Calendar.DAY_OF_MONTH) + " de " + mes;
			defaultTableModel.addRow(columna);
		}
		tableSocios.setModel(defaultTableModel);

		tableSocios.repaint();
	}

	class HeaderRenderer extends JButton implements TableCellRenderer {
		private static final int BUTTON_WIDTH = 16;
		private final Color BUTTONBGC = new Color(200, 200, 200, 100);
		private int rolloverIndex = -1;
		private final transient MouseAdapter handler = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JTableHeader header = (JTableHeader) e.getComponent();
				JTable table = header.getTable();
				TableColumnModel columnModel = table.getColumnModel();
				int vci = columnModel.getColumnIndexAtX(e.getX());
				// int mci = table.convertColumnIndexToModel(vci);
				// TableColumn column = table.getColumnModel().getColumn(mci);
				// int w = column.getWidth(); //Nimbus???
				// int h = header.getHeight();
				Rectangle r = header.getHeaderRect(vci);
				Container c = (Container) getTableCellRendererComponent(table, "", true, true, -1, vci);
				// if (!isNimbus) {
				// Insets i = c.getInsets();
				// r.translate(r.width - i.right, 0);
				// } else {
				r.translate(r.width - BUTTON_WIDTH, 0);
				r.setSize(BUTTON_WIDTH, r.height);
				Point pt = e.getPoint();
				if (c.getComponentCount() > 0 && r.contains(pt)) {
					JButton b = (JButton) c.getComponent(0);
					b.doClick();
					e.consume();
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				rolloverIndex = -1;
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				JTableHeader header = (JTableHeader) e.getComponent();
				JTable table = header.getTable();
				TableColumnModel columnModel = table.getColumnModel();
				int vci = columnModel.getColumnIndexAtX(e.getX());
				int mci = table.convertColumnIndexToModel(vci);
				rolloverIndex = mci;
			}
		};

		protected HeaderRenderer(JTableHeader header) {
			super();
			header.addMouseListener(handler);
			header.addMouseMotionListener(handler);
		}

		@Override
		public void updateUI() {
			super.updateUI();
			// setOpaque(false);
			// setFont(header.getFont());
			setBorder(BorderFactory.createEmptyBorder());
			setContentAreaFilled(false);
		}

		// JButton button = new JButton(new AbstractAction() {
		// @Override public void actionPerformed(ActionEvent e) {
		// System.out.println("clicked");
		// }
		// });
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			TableCellRenderer r = table.getTableHeader().getDefaultRenderer();
			JLabel l = (JLabel) r.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			l.removeAll();
			int mci = table.convertColumnIndexToModel(column);

			if (rolloverIndex == mci) {
				int w = table.getColumnModel().getColumn(mci).getWidth();
				int h = table.getTableHeader().getHeight();
				// Icon icon = new MenuArrowIcon();
				Border outside = l.getBorder();
				Border inside = BorderFactory.createEmptyBorder(0, 0, 0, BUTTON_WIDTH);
				Border b = BorderFactory.createCompoundBorder(outside, inside);
				l.setBorder(b);
				l.add(this);
				// Insets i = b.getBorderInsets(l);
				// setBounds(w - i.right, 0, BUTTON_WIDTH, h - 2);
				setBounds(w - BUTTON_WIDTH, 0, BUTTON_WIDTH, h - 2);
				setBackground(BUTTONBGC);
				setOpaque(true);
				setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.GRAY));
			}
			// if (l.getPreferredSize().height > 1000) { //XXX: Nimbus
			// System.out.println(l.getPreferredSize().height);
			// l.setPreferredSize(new Dimension(0, h));
			// }
			return l;
		}
	}
}

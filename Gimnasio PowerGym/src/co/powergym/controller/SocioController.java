package co.powergym.controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.github.sarxos.webcam.Webcam;
import com.sun.java_cup.internal.runtime.virtual_parse_stack;

import co.powergym.dao.SocioDao;
import co.powergym.model.Socio;
import co.powergym.view.socio.SocioBusquedaView;
import co.powergym.view.socio.SocioCumpleaniosListadoView;
import co.powergym.view.socio.SocioListadoView;
import co.powergym.view.socio.SocioRegistroView;

public class SocioController implements ActionListener {

	Webcam webcam;
	SocioDao socioDao;

	SocioRegistroView viewRegistroSocio;
	SocioBusquedaView viewBusquedaSocio;
	SocioListadoView viewListadoSocio;
	SocioCumpleaniosListadoView viewCumpleaniosListadoView;
	private BufferedImage fotoTemp;

	public SocioController(SocioDao socioDao, SocioRegistroView viewRegistroSocio, SocioBusquedaView viewBusquedaSocio,
			SocioListadoView socioListadoView, SocioCumpleaniosListadoView cumpleaniosListadoView) {
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
				String primerNombre = socio.getPrimerNombre();
				viewBusquedaSocio.getTextField_primerNombre().setText(primerNombre);
				String segundoNombre = socio.getSegundoNombre();
				viewBusquedaSocio.getTextField_segundoNombre().setText(segundoNombre);
				String primerApellido = socio.getPrimerApellido();
				viewBusquedaSocio.getTextField_primerApellido().setText(primerApellido);
				String segundoApellido = socio.getSegundoApellido();
				viewBusquedaSocio.getTextField_segundoApellido().setText(segundoApellido);
				String fechaNacimiento = String.valueOf(socio.getFechaNacimiento());
				viewBusquedaSocio.getTextField_fechaNacimiento().setText(fechaNacimiento);
				String telefono = socio.getTelefono();
				viewBusquedaSocio.getTextField_telefono().setText(telefono);
				String correo = socio.getCorreo();
				viewBusquedaSocio.getTextField_correoElectronico().setText(correo);
				int genero = socio.getGenero();
				viewBusquedaSocio.getTextField_genero().setText(String.valueOf(genero));
				Image dimg = socio.getFoto().getScaledInstance(viewBusquedaSocio.getLblFoto().getWidth(),
						viewBusquedaSocio.getLblFoto().getHeight(), Image.SCALE_REPLICATE);
				viewBusquedaSocio.getLblFoto().setIcon(new ImageIcon(dimg));

			} else {
				JOptionPane.showMessageDialog(null, "No se encontrÃ³ un socio con ese nÃºmero de identificaciÃ³n, "
						+ "por favor verique e intente de nuevo");
			}

		}
	}

	public void listadoSociosLlenarTabla(JTable tabla) {
		DefaultTableModel defaultTableModel = new DefaultTableModel();

		defaultTableModel.addColumn("Nro. identificacion");
		defaultTableModel.addColumn("Nombre");
		defaultTableModel.addColumn("Apellido");
		defaultTableModel.addColumn("Dirección");
		defaultTableModel.addColumn("Correo electrónico");
		defaultTableModel.addColumn("Teléfono");

		Object[] columna = new Object[6];
		List<Socio> listSocios = socioDao.listaSocios();
		int numeroRegistros = listSocios.size();

		for (int i = 0; i < numeroRegistros; i++) {
			columna[0] = listSocios.get(i).getIdentificacion();
			columna[1] = listSocios.get(i).getPrimerNombre() + " " + listSocios.get(i).getSegundoNombre();
			columna[2] = listSocios.get(i).getPrimerApellido() + " " + listSocios.get(i).getSegundoApellido();
			columna[3] = listSocios.get(i).getDireccion();
			columna[4] = listSocios.get(i).getCorreo();
			columna[5] = listSocios.get(i).getTelefono();
			defaultTableModel.addRow(columna);
		}
		tabla.setModel(defaultTableModel);

		tabla.repaint();

	}

	public void listadoCumpleaniosLlenarTabla(JTable tableSocios) {
		// TODO Auto-generated method stub
		DefaultTableModel defaultTableModel = new DefaultTableModel();

		defaultTableModel.addColumn("Nro. identificacion");
		defaultTableModel.addColumn("Nombre");
		defaultTableModel.addColumn("Apellido");
		defaultTableModel.addColumn("Fecha de cumpleaños");

		Object[] columna = new Object[6];
		List<Socio> listSocios = socioDao.sociosCumpleaniosMes();
		int numeroRegistros = listSocios.size();

		for (int i = 0; i < numeroRegistros; i++) {
			columna[0] = listSocios.get(i).getIdentificacion();
			columna[1] = listSocios.get(i).getPrimerNombre() + " " + listSocios.get(i).getSegundoNombre();
			columna[2] = listSocios.get(i).getPrimerApellido() + " " + listSocios.get(i).getSegundoApellido();
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

			columna[3] = calendar.get(Calendar.DAY_OF_MONTH) + " de " + mes;
			defaultTableModel.addRow(columna);
		}
		tableSocios.setModel(defaultTableModel);

		tableSocios.repaint();
	}

}

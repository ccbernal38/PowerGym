package co.powergym.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.formula.functions.Choose;

import co.powergym.dao.CajaDao;
import co.powergym.dao.UsuarioDao;
import co.powergym.model.Caja;
import co.powergym.model.MembresiaSocio;
import co.powergym.model.Usuario;
import co.powergym.utils.Constantes;
import co.powergym.utils.Preferencias;
import co.powergym.view.caja.CajaListaEgresosHoyView;
import co.powergym.view.caja.CajaListaIngresosHoyView;
import co.powergym.view.caja.CajaMembresiaVentaDiaView;
import co.powergym.view.membresia.MembresiaListaDiaVisitasView;
import co.powergym.view.BackupView;
import co.powergym.view.caja.CajaCierreView;

public class CajaController implements ActionListener {

	private CajaDao cajaDao;
	private UsuarioDao usuarioDao;
	private CajaMembresiaVentaDiaView membresiaVentaDiaView;
	private CajaCierreView cierreCajaView;
	private BackupView backupView;

	public CajaController(CajaMembresiaVentaDiaView diaView, CajaCierreView cierreCaja, BackupView copiaSeguridadView) {
		cajaDao = new CajaDao();
		usuarioDao = new UsuarioDao();
		this.membresiaVentaDiaView = diaView;
		this.cierreCajaView = cierreCaja;
		this.backupView = copiaSeguridadView;

		if (membresiaVentaDiaView != null) {
			cargarVentasMembresiaDia();
			membresiaVentaDiaView.setLocationRelativeTo(null);
			membresiaVentaDiaView.setVisible(true);
		}
		if (cierreCajaView != null) {
			cargarSaldosCierre();
			cierreCajaView.setLocationRelativeTo(null);
			cierreCajaView.setVisible(true);
			cierreCajaView.getButtonDetalleEgresosDia().addActionListener(this);
			cierreCajaView.getButtonDetallesMembresia().addActionListener(this);
			cierreCajaView.getButtonDetallesVisitasDia().addActionListener(this);
			cierreCajaView.getBtnCancelar().addActionListener(this);
			cierreCajaView.getBtnCerrarCaja().addActionListener(this);
		}

		if (backupView != null) {
			backupView.setLocationRelativeTo(null);
			backupView.setVisible(true);
			backupView.getBtnCancelar().addActionListener(this);
			backupView.getBtnGenerarCopiaDe().addActionListener(this);
			backupView.getBtnSeleccionar().addActionListener(this);
		}

	}

	private void cargarSaldosCierre() {
		Caja caja = cajaDao.ultimoRegistro();
		Usuario userApertura = usuarioDao.buscarUsuarioId(caja.getResponsableApertura());
		// Fecha de apertura
		cierreCajaView.getLabelFechaApertura()
				.setText(new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a").format(caja.getFechaApertura()));
		// Responsable de apertura
		cierreCajaView.getLabelResponsableApertura()
				.setText(userApertura.getNombre() + " " + userApertura.getApellido());
		// Responsable de cierre
		cierreCajaView.getLabelResponsableCierre()
				.setText(Preferencias.obtenerPreferencia(Constantes.NOMBRE_RESPONSABLE));
		// Ventas de membresias del dia
		int totalVentasMembresiaDia = cajaDao.totalVentasMembresiasDia(caja.getId());
		NumberFormat format = NumberFormat.getInstance();
		cierreCajaView.getTextFieldVentasM().setText("$ " + format.format(totalVentasMembresiaDia));
		// Ventas de visitas del dia
		int totalVentasVisitasDia = cajaDao.totalVentasVisitasDia(caja.getId());
		cierreCajaView.getTextFieldVisitas().setText("$ " + format.format(totalVentasVisitasDia));
		// Egresos del dia
		int totalEgresosDia = cajaDao.totalEgresosDia(caja.getId());
		cierreCajaView.getTextFieldEgresos().setText("$ " + format.format(totalEgresosDia));
		// Dinero en caja
		int dineroEnCaja = (totalVentasMembresiaDia + totalVentasVisitasDia) - totalEgresosDia;
		cierreCajaView.getLabelDineroEnCaja().setText("$ " + format.format(dineroEnCaja));
		if (dineroEnCaja < 0) {
			cierreCajaView.getLabelDineroEnCaja().setForeground(new Color(128, 0, 0));
		}
	}

	public void cerrarCaja() {
		Caja caja = cajaDao.ultimoRegistro();
		int totalVentasMembresiaDia = cajaDao.totalVentasMembresiasDia(caja.getId());
		int totalVentasVisitasDia = cajaDao.totalVentasVisitasDia(caja.getId());
		int totalEgresosDia = cajaDao.totalEgresosDia(caja.getId());
		int dineroEnCaja = (totalVentasMembresiaDia + totalVentasVisitasDia) - totalEgresosDia;
		int usuario_cierre = Integer.parseInt(Preferencias.obtenerPreferencia(Constantes.ID_RESPONSABLE));
		boolean respuesta = cajaDao.cerrarCaja(caja.getId(), usuario_cierre, totalEgresosDia, totalVentasMembresiaDia,
				totalVentasVisitasDia, dineroEnCaja);
		if (respuesta == true) {
			JOptionPane.showMessageDialog(null, "Se ha cerrado correctamente la caja.");
			System.exit(0);
		} else {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error mientras se cerraba caja");
		}

	}

	private void cargarVentasMembresiaDia() {
		List<MembresiaSocio> list = cajaDao.ventasDelDia();
		DefaultTableModel defaultTableModel = (DefaultTableModel) membresiaVentaDiaView.getTable().getModel();
		Object[] columna = new Object[5];
		int numeroRegistros = list.size();
		for (int i = 0; i < numeroRegistros; i++) {
			columna[0] = list.get(i).getSocio().getNombre();
			columna[1] = list.get(i).getMembresia().getNombre();
			NumberFormat format = NumberFormat.getInstance();
			columna[2] = "$ " + format.format(list.get(i).getValor());
			columna[3] = "$ " + format.format(list.get(i).getDescuento());
			columna[4] = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a").format(list.get(i).getFechaInicial());
			defaultTableModel.addRow(columna);
		}
		this.membresiaVentaDiaView.getTable().setModel(defaultTableModel);
		this.membresiaVentaDiaView.getTable().repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (cierreCajaView != null) {
			if (cierreCajaView.getButtonDetalleEgresosDia() == e.getSource()) {
				new MovimientoController(null, null, new CajaListaEgresosHoyView(), null, null, null);
			}
			if (cierreCajaView.getButtonDetallesMembresia() == e.getSource()) {
				new CajaController(new CajaMembresiaVentaDiaView(), null, null);
			}
			if (cierreCajaView.getButtonDetallesVisitasDia() == e.getSource()) {
				new VisitaController(null, null, new MembresiaListaDiaVisitasView());
			}
			if (cierreCajaView.getBtnCancelar() == e.getSource()) {
				cierreCajaView.setVisible(false);
				cierreCajaView.dispose();
			}
			if (cierreCajaView.getBtnCerrarCaja() == e.getSource()) {
				cerrarCaja();
			}
		}
		if (backupView != null) {
			if (backupView.getBtnCancelar() == e.getSource()) {
				backupView.setVisible(false);
				backupView.dispose();
			}
			if (backupView.getBtnGenerarCopiaDe() == e.getSource()) {
				String ruta = backupView.getTextFieldUbicacion().getText();
				java.io.File file = new java.io.File(ruta);
				if(file.exists()) {
					backup(ruta);
					backupView.setVisible(false);
					backupView.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "La ruta seleccionada no es valida");
				}
			}
			if (backupView.getBtnSeleccionar() == e.getSource()) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("Copia de seguridad");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				//
				// disable the "All files" option.
				//
				chooser.setAcceptAllFileFilterUsed(false);
				//
				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
					System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
					String ruta = chooser.getSelectedFile().getAbsolutePath();
					backupView.getTextFieldUbicacion().setText(ruta);
				} else {
					System.out.println("No Selection ");
				}

			}
		}
	}

	private static void backup(String ruta) {
		try {
			String cmd = "C:\\xampp\\mysql\\bin\\mysqldump -u root powergym";
			System.out.println(cmd);
			Process p = Runtime.getRuntime().exec(cmd);

			InputStream is = p.getInputStream();
			Calendar calendar = Calendar.getInstance();
			String fecha = new SimpleDateFormat("ddMMYYYYHms").format(calendar.getTime());
			FileOutputStream fos = new FileOutputStream(ruta+"\\"+"Backup-"+ fecha + ".sql");
			byte[] buffer = new byte[1000];

			int leido = is.read(buffer);
			while (leido > 0) {
				fos.write(buffer, 0, leido);
				leido = is.read(buffer);
			}

			fos.close();
			JOptionPane.showMessageDialog(null, "La copia de seguridad se genero correctamente.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

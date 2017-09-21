﻿package co.powergym.view;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;

import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;

import javax.swing.JMenu;

import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Image;
import java.awt.Cursor;
import javax.swing.border.BevelBorder;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.JSpinner;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import com.digitalpersona.onetouch.DPFPTemplate;
import com.toedter.components.JSpinField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Dimension;

/**
 *
 * @author bernal
 */
public class InitView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates new form Principal
	 */
	public InitView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("image/icon.ico"));

		setTitle("PowerGym");

		getContentPane().setBackground(new Color(42, 45, 52));
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		Color color = new Color(122, 110, 114);
		jMenuBar = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenu2 = new javax.swing.JMenu();
		jMenuItemRegistrarSocio = new javax.swing.JMenuItem();
		jMenuItem3buscarSocio = new javax.swing.JMenuItem();
		jMenuItem5 = new javax.swing.JMenuItem();
		jMenu6 = new javax.swing.JMenu();
		jMenuItemSocioActivo = new javax.swing.JMenuItem();
		jMenuItemAsistencia = new javax.swing.JMenuItem();
		jMenu3 = new javax.swing.JMenu();
		jMenuItem7 = new javax.swing.JMenuItem();
		jMenuItem8 = new javax.swing.JMenuItem();
		jMenuItem9 = new javax.swing.JMenuItem();
		jMenu4 = new javax.swing.JMenu();
		jMenuItem10 = new javax.swing.JMenuItem();
		jMenuItemListaMembresias = new javax.swing.JMenuItem();
		jMenu7 = new javax.swing.JMenu();
		jMenuItem12 = new javax.swing.JMenuItem();
		jMenu5 = new javax.swing.JMenu();
		jMenuItem13 = new javax.swing.JMenuItem();
		jMenuItem14 = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setExtendedState(6);

		jMenu1.setText("Archivo");
		
		mntmCopiaDeSeguridad = new JMenuItem("Copia de seguridad");
		jMenu1.add(mntmCopiaDeSeguridad);

		jMenuItem1.setText("Salir");

		jMenu1.add(jMenuItem1);

		jMenuBar.add(jMenu1);

		jMenu2.setText("Socios");

		jMenuItemRegistrarSocio.setText("Registrar socio");
		jMenu2.add(jMenuItemRegistrarSocio);

		jMenuItem3buscarSocio.setText("Buscar socio");
		jMenu2.add(jMenuItem3buscarSocio);

		mntmListadoDeSocios = new JMenuItem("Listado de socios");
		jMenu2.add(mntmListadoDeSocios);

		jMenuItem5.setText("Cumpleaños del mes");
		jMenu2.add(jMenuItem5);

		jMenu6.setText("Informes");

		jMenuItemSocioActivo.setText("Socios activos");
		jMenu6.add(jMenuItemSocioActivo);

		jMenuItemAsistencia.setText("Asistencia");
		jMenu6.add(jMenuItemAsistencia);

		jMenu2.add(jMenu6);

		jMenuBar.add(jMenu2);

		jMenu3.setText("Mensualidad");

		jMenuItem7.setText("Pagar mensualidad");

		jMenu3.add(jMenuItem7);

		jMenuItem8.setText("Pago en mora");
		jMenu3.add(jMenuItem8);

		jMenuItem9.setText("Pagos proximos");
		jMenu3.add(jMenuItem9);

		jMenuBar.add(jMenu3);

		jMenu4.setText("Membresias");

		jMenuItem10.setText("Crear membresia");
		jMenu4.add(jMenuItem10);

		jMenuItemListaMembresias.setText("Lista de membresias");
		jMenu4.add(jMenuItemListaMembresias);

		jMenu7.setText("Informes");

		jMenuItem12.setText("Cantidad de membresias activas");
		jMenu7.add(jMenuItem12);

		jMenu4.add(jMenu7);

		jMenuBar.add(jMenu4);

		jMenu5.setText("Caja");

		jMenuItem13.setText("Cierre de caja");
		jMenu5.add(jMenuItem13);

		jMenuItem14.setText("Ventas del dia");
		jMenu5.add(jMenuItem14);

		jMenuBar.add(jMenu5);

		JSeparator separator = new JSeparator();
		jMenu5.add(separator);

		JMenu mnEgresos = new JMenu("Egresos");
		jMenu5.add(mnEgresos);

		mntmHistoricoDeEgresos = new JMenuItem("Historico de egresos");
		mnEgresos.add(mntmHistoricoDeEgresos);

		mntmEgresosDelDia = new JMenuItem("Egresos del dia");
		mnEgresos.add(mntmEgresosDelDia);

		mntmRegistrarEgreso = new JMenuItem("Registrar egreso");
		mnEgresos.add(mntmRegistrarEgreso);

		setJMenuBar(jMenuBar);

		mnVisitas = new JMenu("Visitas");
		jMenuBar.add(mnVisitas);

		mntmHistoricoDeVisitas = new JMenuItem("Historico de visitas");
		mnVisitas.add(mntmHistoricoDeVisitas);

		mntmRegistroDeVisitas = new JMenuItem("Registro de visitas");
		mnVisitas.add(mntmRegistroDeVisitas);

		mntmVisitasDeHoy = new JMenuItem("Visitas del dia");
		mnVisitas.add(mntmVisitasDeHoy);

		jMenuUsuario = new JMenu("Usuario");
		jMenuBar.add(jMenuUsuario);
		jMenuItemRegistrarUsuario = new JMenuItem("Registrar usuario");
		jMenuUsuario.add(jMenuItemRegistrarUsuario);

		jMenuItemBuscarUsuario = new JMenuItem("Buscar usuario");
		jMenuUsuario.add(jMenuItemBuscarUsuario);

		jMenuItemListaUsuario = new JMenuItem("Lista de usuarios");
		jMenuUsuario.add(jMenuItemListaUsuario);

		JMenu mnAyuda = new JMenu("Ayuda");
		jMenuBar.add(mnAyuda);

		mntmPuertoTorniquete = new JMenuItem("Puerto torniquete");
		mnAyuda.add(mntmPuertoTorniquete);
		getContentPane().setLayout(null);
		btnRegistrarSocio = new javax.swing.JButton();
		btnRegistrarSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistrarSocio.setBounds(408, 623, 150, 50);
		btnRegistrarSocio.setBorder(null);
		btnRegistrarSocio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrarSocio.setFont(new Font("Verdana", Font.BOLD, 12));
		getContentPane().add(btnRegistrarSocio);
		btnRegistrarSocio.setForeground(Color.WHITE);
		btnRegistrarSocio.setBackground(new Color(208, 0, 0));

		btnRegistrarSocio.setText("<html><center>Registro<br />de socio (F3)</center></html>");
		btnRegistrarSocio.setToolTipText("");
		btnRegistrarSocio.setPreferredSize(new java.awt.Dimension(50, 50));
		btnMenuMembresia = new javax.swing.JButton();
		btnMenuMembresia.setBounds(728, 623, 150, 50);
		btnMenuMembresia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMenuMembresia.setBorder(null);
		btnMenuMembresia.setFont(new Font("Verdana", Font.BOLD, 12));
		btnMenuMembresia.setForeground(Color.WHITE);
		getContentPane().add(btnMenuMembresia);
		btnMenuMembresia.setBackground(new Color(0, 208, 0));

		btnMenuMembresia.setText("<html><center>Registrar<br />membresia (F5)</center></html>");
		jButtonPagarMensualidad = new javax.swing.JButton();
		jButtonPagarMensualidad.setBounds(568, 623, 150, 50);
		jButtonPagarMensualidad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jButtonPagarMensualidad.setBorder(null);
		jButtonPagarMensualidad.setFont(new Font("Verdana", Font.BOLD, 12));
		jButtonPagarMensualidad.setForeground(Color.WHITE);
		getContentPane().add(jButtonPagarMensualidad);
		jButtonPagarMensualidad.setBackground(new Color(0, 0, 208));

		jButtonPagarMensualidad.setText("<html><center>Pagar<br />mensualidad (F4)</center></html>");
		jButtonCierreCaja = new javax.swing.JButton();
		jButtonCierreCaja.setBounds(888, 623, 150, 50);
		jButtonCierreCaja.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jButtonCierreCaja.setBorder(null);
		jButtonCierreCaja.setFont(new Font("Verdana", Font.BOLD, 12));
		jButtonCierreCaja.setForeground(Color.WHITE);
		getContentPane().add(jButtonCierreCaja);
		jButtonCierreCaja.setBackground(new Color(208, 208, 0));

		jButtonCierreCaja.setText("<html>Cierre<br />de caja (F6)</html>");

		JPanel panelCumpleanios = new JPanel();
		panelCumpleanios.setBounds(1080, 50, 264, 623);
		panelCumpleanios.setBorder(null);
		panelCumpleanios.setBackground(new Color(0, 0, 0, 0));
		getContentPane().add(panelCumpleanios);
		panelCumpleanios.setLayout(null);

		JLabel lblCumpleaosDelDa = new JLabel("Cumpleaños del Día");
		lblCumpleaosDelDa.setForeground(Color.WHITE);
		lblCumpleaosDelDa.setHorizontalAlignment(SwingConstants.CENTER);
		lblCumpleaosDelDa.setFont(new Font("Verdana", Font.BOLD, 18));
		lblCumpleaosDelDa.setBounds(10, 11, 244, 29);
		panelCumpleanios.add(lblCumpleaosDelDa);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon image = new ImageIcon("image/logo_bithday.png");

		lblNewLabel.setBounds(10, 51, 244, 137);
		lblNewLabel.setIcon(new ImageIcon(((new ImageIcon("image/logo_bithday.png")).getImage()).getScaledInstance(
				lblNewLabel.getHeight(), lblNewLabel.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));

		panelCumpleanios.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setViewportBorder(null);
		scrollPane.setBackground(new Color(0, 0, 0, 0));
		scrollPane.setBounds(10, 199, 244, 413);
		panelCumpleanios.add(scrollPane);

		listCumpleanios = new JList();
		listCumpleanios.setFont(new Font("Tahoma", Font.BOLD, 14));
		listCumpleanios.setBorder(null);
		listCumpleanios.setEnabled(false);
		listCumpleanios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listCumpleanios);
		listCumpleanios.setForeground(Color.WHITE);
		listCumpleanios.setBackground(new Color(0, 0, 0, 0));

		panelBusqueda = new JPanel();
		panelBusqueda.setBackground(Color.DARK_GRAY);
		panelBusqueda.setBorder(new EmptyBorder(0, 0, 3, 0));
		panelBusqueda.setBounds(0, 0, 1362, 47);
		getContentPane().add(panelBusqueda);
		panelBusqueda.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Consultar socio:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 3, 195, 36);
		panelBusqueda.add(lblNewLabel_2);

		textFieldKey = new JTextField();
		textFieldKey.setFont(new Font("Verdana", Font.BOLD, 12));
		textFieldKey.setBounds(162, 8, 164, 29);
		panelBusqueda.add(textFieldKey);
		textFieldKey.setColumns(10);

		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnSalir.setBounds(1233, 11, 107, 23);
		panelBusqueda.add(btnSalir);
		btnB = new JButton("Buscar");
		btnB.setBounds(336, 11, 121, 25);
		panelBusqueda.add(btnB);

		btnPuerta = new JButton("Puerta");
		btnPuerta.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnPuerta.setBounds(1134, 11, 89, 23);
		panelBusqueda.add(btnPuerta);

		JLabel labelBackgroundImage = new JLabel("");
		labelBackgroundImage.setBounds(408, 137, 500, 400);
		labelBackgroundImage.setIcon(new ImageIcon(
				((new ImageIcon("image/logo.png")).getImage()).getScaledInstance(labelBackgroundImage.getWidth(),
						labelBackgroundImage.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));

		getContentPane().add(labelBackgroundImage);

		btnRegistrodeVisita = new JButton();
		btnRegistrodeVisita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistrodeVisita.setToolTipText("");
		btnRegistrodeVisita.setText("<html><center>Registro<br />de visita (F2)</center></html>");
		btnRegistrodeVisita.setPreferredSize(new Dimension(50, 50));
		btnRegistrodeVisita.setForeground(Color.WHITE);
		btnRegistrodeVisita.setFont(new Font("Verdana", Font.BOLD, 12));
		btnRegistrodeVisita.setBorder(null);
		btnRegistrodeVisita.setBackground(Color.GREEN);
		btnRegistrodeVisita.setBounds(248, 623, 150, 50);
		getContentPane().add(btnRegistrodeVisita);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(10, 71, 404, 380);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		panel = new JPanel();
		panel.setBounds(10, 66, 192, 205);
		panel_1.add(panel);
		panel.setFont(new Font("Verdana", Font.BOLD, 11));
		panel.setBackground(new Color(0, 0, 0, 0));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Escaneando huella....",
				TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, Color.WHITE));
		panel.setLayout(new BorderLayout(0, 0));

		lblHuella = new JLabel("");
		lblHuella.setFont(new Font("Verdana", Font.BOLD, 11));
		panel.add(lblHuella, BorderLayout.CENTER);

		lblingreseElNmero = new JLabel(
				"<html><center>Ingrese el número <br>de identificación del socio:</center></html>");
		lblingreseElNmero.setBounds(226, 66, 168, 50);
		panel_1.add(lblingreseElNmero);
		lblingreseElNmero.setForeground(Color.WHITE);
		lblingreseElNmero.setFont(new Font("Verdana", Font.PLAIN, 12));

		textField = new JTextField();
		textField.setBounds(245, 127, 125, 20);
		panel_1.add(textField);
		textField.setColumns(10);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 282, 384, 82);
		panel_1.add(scrollPane_2);
		scrollPane_2.setBackground(Color.LIGHT_GRAY);

		textArea = new JTextArea();
		textArea.setFont(new Font("Verdana", Font.BOLD, 13));
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(Color.DARK_GRAY);
		scrollPane_2.setViewportView(textArea);

		btnVerificar = new JButton("Verificar");
		btnVerificar.setBounds(245, 155, 125, 23);
		panel_1.add(btnVerificar);

		JLabel lblNewLabel_1 = new JLabel("Registro de asistencia");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 19, 384, 36);
		panel_1.add(lblNewLabel_1);
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		pack();
	}// </editor-fold>//GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables
	public javax.swing.JButton btnRegistrarSocio;
	public javax.swing.JButton btnMenuMembresia;
	public javax.swing.JButton jButtonPagarMensualidad;
	public javax.swing.JButton jButtonCierreCaja;
	public javax.swing.JMenu jMenu1;
	public javax.swing.JMenu jMenu2;
	public javax.swing.JMenu jMenu3;
	public javax.swing.JMenu jMenu4;
	public javax.swing.JMenu jMenu5;
	public javax.swing.JMenu jMenu6;
	public javax.swing.JMenu jMenu7;
	public javax.swing.JMenuBar jMenuBar;
	public javax.swing.JMenuItem jMenuItem1;
	public javax.swing.JMenuItem jMenuItem10;
	public javax.swing.JMenuItem jMenuItemListaMembresias;
	public javax.swing.JMenuItem jMenuItem12;
	public javax.swing.JMenuItem jMenuItem13;
	public javax.swing.JMenuItem jMenuItem14;
	public javax.swing.JMenuItem jMenuItemRegistrarSocio;
	public javax.swing.JMenuItem jMenuItem3buscarSocio;
	public javax.swing.JMenuItem jMenuItemSocioActivo;

	/**
	 * @return the jMenuItemSocioActivo
	 */
	public javax.swing.JMenuItem getjMenuItemSocioActivo() {
		return jMenuItemSocioActivo;
	}

	/**
	 * @param jMenuItemSocioActivo
	 *            the jMenuItemSocioActivo to set
	 */
	public void setjMenuItemSocioActivo(javax.swing.JMenuItem jMenuItemSocioActivo) {
		this.jMenuItemSocioActivo = jMenuItemSocioActivo;
	}

	public javax.swing.JMenuItem jMenuItem5;
	public javax.swing.JMenuItem jMenuItemAsistencia;
	public javax.swing.JMenuItem jMenuItem7;
	public javax.swing.JMenuItem jMenuItem8;
	public javax.swing.JMenuItem jMenuItem9;

	private JMenuItem mntmListadoDeSocios;

	private JMenu jMenuUsuario;
	private JMenuItem jMenuItemRegistrarUsuario;
	private JMenuItem jMenuItemBuscarUsuario;
	private JMenuItem jMenuItemListaUsuario;
	private JButton btnSalir;
	private JMenuItem mntmPuertoTorniquete;
	private JList listCumpleanios;
	private JPanel panelBusqueda;
	private JTextField textFieldKey;
	private JPanel panel;
	private JLabel lblingreseElNmero;
	private JTextField textField;
	private JScrollPane scrollPane_2;
	private JButton btnVerificar;
	private JLabel lblHuella;
	private JTextArea textArea;
	private JButton btnPuerta;
	private JButton btnB;
	private JButton btnRegistrodeVisita;
	private JMenuItem mntmRegistrarEgreso;
	private JMenuItem mntmEgresosDelDia;
	private JMenuItem mntmHistoricoDeEgresos;
	private JMenu mnVisitas;
	private JMenuItem mntmHistoricoDeVisitas;
	private JMenuItem mntmRegistroDeVisitas;
	private JMenuItem mntmVisitasDeHoy;
	private JMenuItem mntmCopiaDeSeguridad;

	// End of variables declaration//GEN-END:variables
	public JButton getBtnRegistrarSocio() {
		return btnRegistrarSocio;
	}

	public JButton getBtnMenuMembresia() {
		return btnMenuMembresia;
	}

	public JMenuItem getMntmListadoDeSocios() {
		return mntmListadoDeSocios;
	}

	public void callFirePropertyChange(String tEMPLATE_PROPERTY, DPFPTemplate old, DPFPTemplate template) {
		firePropertyChange(tEMPLATE_PROPERTY, old, template);
	}

	public JMenuItem getJMenuItemCumpleanios() {
		return jMenuItem5;
	}

	public JMenuItem getJMenuItemRegistrarUsuario() {
		return jMenuItemRegistrarUsuario;
	}

	public JMenuItem getJMenuItemBuscarUsuario() {
		return jMenuItemBuscarUsuario;
	}

	public JMenuItem getJMenuItemListaUsuario() {
		return jMenuItemListaUsuario;
	}

	public JMenuItem getJMenuItemListaMembresias() {
		return jMenuItemListaMembresias;
	}

	public JMenuItem getJMenuItemRegistrarSocio() {
		return jMenuItemRegistrarSocio;
	}

	public JMenuItem getJMenuItembuscarSocio() {
		return jMenuItem3buscarSocio;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public JMenuItem getMntmPuertoTorniquete() {
		return mntmPuertoTorniquete;
	}

	public JList getListCumpleanios() {
		return listCumpleanios;
	}

	public JButton getBtnVerificar() {
		return btnVerificar;
	}

	public JTextField getTextFieldCodigo() {
		return textField;
	}

	public JLabel getLblHuella() {
		return lblHuella;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	/**
	 * @return the jMenuItem3buscarSocio
	 */
	public javax.swing.JMenuItem getjMenuItem3buscarSocio() {
		return jMenuItem3buscarSocio;
	}

	/**
	 * @param jMenuItem3buscarSocio
	 *            the jMenuItem3buscarSocio to set
	 */
	public void setjMenuItem3buscarSocio(javax.swing.JMenuItem jMenuItem3buscarSocio) {
		this.jMenuItem3buscarSocio = jMenuItem3buscarSocio;
	}

	/**
	 * @return the jMenuItemAsistencia
	 */
	public javax.swing.JMenuItem getjMenuItemAsistencia() {
		return jMenuItemAsistencia;
	}

	/**
	 * @param jMenuItemAsistencia
	 *            the jMenuItemAsistencia to set
	 */
	public void setjMenuItemAsistencia(javax.swing.JMenuItem jMenuItemAsistencia) {
		this.jMenuItemAsistencia = jMenuItemAsistencia;
	}

	public JButton getBtnPuerta() {
		return btnPuerta;
	}

	public JButton getBtnBuscar() {
		return btnB;
	}

	public JTextField getTextFieldKey() {
		return textFieldKey;
	}

	public JButton getBtnRegistrodeVisita() {
		return btnRegistrodeVisita;
	}

	public JMenuItem getMntmRegistrarEgreso() {
		return mntmRegistrarEgreso;
	}

	public JMenuItem getMntmEgresosDelDia() {
		return mntmEgresosDelDia;
	}

	public JMenuItem getMntmHistoricoDeEgresos() {
		return mntmHistoricoDeEgresos;
	}

	public JMenuItem getMntmHistoricoDeVisitas() {
		return mntmHistoricoDeVisitas;
	}

	public JMenuItem getMntmRegistroDeVisitas() {
		return mntmRegistroDeVisitas;
	}

	public JMenuItem getMntmVisitasDeHoy() {
		return mntmVisitasDeHoy;
	}
	public JMenuItem getJMenuItemVentasDia() {
		return jMenuItem14;
	}
	public JMenuItem getJMenuItemCierreCaja() {
		return jMenuItem13;
	}
	public JMenuItem getMntmCopiaDeSeguridad() {
		return mntmCopiaDeSeguridad;
	}
}

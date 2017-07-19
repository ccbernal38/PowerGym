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

/**
 *
 * @author bernal
 */
public class Principal extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Creates new form Principal
     */
    public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("image/icon.ico"));
		
		setTitle("PowerGym");
    	getContentPane().setBackground(new Color(0, 149, 239));
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        Color color = new Color(122, 110, 114);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemRegistrarSocio = new javax.swing.JMenuItem();
        jMenuItem3buscarSocio = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
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

        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

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

        jMenuItem4.setText("Socios activos");
        jMenu6.add(jMenuItem4);

        jMenuItem6.setText("Asistencia");
        jMenu6.add(jMenuItem6);

        jMenu2.add(jMenu6);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Mensualidad");

        jMenuItem7.setText("Pagar mensualidad");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuItem8.setText("Pago en mora");
        jMenu3.add(jMenuItem8);

        jMenuItem9.setText("Pagos proximos");
        jMenu3.add(jMenuItem9);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Membresias");

        jMenuItem10.setText("Crear membresia");
        jMenu4.add(jMenuItem10);

        jMenuItemListaMembresias.setText("Lista de membresias");
        jMenu4.add(jMenuItemListaMembresias);

        jMenu7.setText("Informes");

        jMenuItem12.setText("Cantidad de membresias activas");
        jMenu7.add(jMenuItem12);

        jMenu4.add(jMenu7);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Caja");

        jMenuItem13.setText("Cierre de caja");
        jMenu5.add(jMenuItem13);

        jMenuItem14.setText("Ventas del dia");
        jMenu5.add(jMenuItem14);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);
        
        jMenuEntrenador = new JMenu("Entrenador");
        jMenuBar1.add(jMenuEntrenador);        
        jMenuItemRegistrarEntrenador = new JMenuItem("Registrar entrenador");
        jMenuEntrenador.add(jMenuItemRegistrarEntrenador);  
        jMenuEntrenador.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jMenuItemRegistroEntrenadorActionPerformed(evt);
            }
        });
        jMenuItemBuscarEntrenador = new JMenuItem("Buscar entrenador");
        jMenuEntrenador.add(jMenuItemBuscarEntrenador);
        
        jMenuItemListaEntrenador = new JMenuItem("Lista de entrenadores");
        jMenuEntrenador.add(jMenuItemListaEntrenador);
        
        jPanel1 = new javax.swing.JPanel();
        jPanel1.setBackground(new Color(0, 149, 239));
        btnRegistrarSocio = new javax.swing.JButton();
        btnRegistrarSocio.setForeground(Color.WHITE);
        btnRegistrarSocio.setBackground(new Color(128, 128, 128));
        jButtonRegistrarEntrada = new javax.swing.JButton();
        jButtonRegistrarEntrada.setBackground(new Color(128, 128, 128));
        btnMenuMembresia = new javax.swing.JButton();
        btnMenuMembresia.setBackground(new Color(128, 128, 128));
        jButton5 = new javax.swing.JButton();
        jButton5.setBackground(new Color(128, 128, 128));
        jButton6 = new javax.swing.JButton();
        jButton6.setBackground(new Color(128, 128, 128));
        
                jPanel1.setBorder(null);
                
                        btnRegistrarSocio.setText("Registro socio");
                        btnRegistrarSocio.setToolTipText("");
                        btnRegistrarSocio.setPreferredSize(new java.awt.Dimension(50, 50));
                        btnRegistrarSocio.addActionListener(new java.awt.event.ActionListener() {
                            @Override
							public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton1ActionPerformed(evt);
                            }
                        });
                        
                                jButtonRegistrarEntrada.setText("Registrar entrada");
                                jButtonRegistrarEntrada.addActionListener(new java.awt.event.ActionListener() {
                                    @Override
									public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        jButton2ActionPerformed(evt);
                                    }
                                });
                                        
                                                btnMenuMembresia.setText("Crear membresia");
                                                
                                                        jButton5.setText("Pagar mensualidad");
                                                        
                                                                jButton6.setText("Cierre de caja");
                                                                
                                                                        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                                                                        jPanel1Layout.setHorizontalGroup(
                                                                        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
                                                                        		.addGroup(jPanel1Layout.createSequentialGroup()
                                                                        			.addGap(31)
                                                                        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
                                                                        				.addComponent(btnMenuMembresia, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                                                        				.addComponent(btnRegistrarSocio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        			.addPreferredGap(ComponentPlacement.RELATED)
                                                                        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
                                                                        				.addComponent(jButtonRegistrarEntrada, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        				.addComponent(jButton5, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                                                                        			.addPreferredGap(ComponentPlacement.RELATED)
                                                                        			.addComponent(jButton6)
                                                                        			.addContainerGap(32, Short.MAX_VALUE))
                                                                        );
                                                                        jPanel1Layout.setVerticalGroup(
                                                                        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
                                                                        		.addGroup(jPanel1Layout.createSequentialGroup()
                                                                        			.addGap(37)
                                                                        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
                                                                        				.addComponent(btnRegistrarSocio, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                                                        				.addComponent(jButtonRegistrarEntrada, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        			.addPreferredGap(ComponentPlacement.RELATED)
                                                                        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
                                                                        				.addComponent(btnMenuMembresia, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                                                        				.addComponent(jButton5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        				.addComponent(jButton6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        			.addContainerGap(34, Short.MAX_VALUE))
                                                                        );
                                                                        jPanel1.setLayout(jPanel1Layout);
        
        lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("image/logo.png"));
        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(37)
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 803, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(40)
        					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(63)
        					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 581, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(72, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void jMenuItemRegistroEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnRegistrarSocio;
    public javax.swing.JButton jButtonRegistrarEntrada;
    public javax.swing.JButton btnMenuMembresia;
    public javax.swing.JButton jButton5;
    public javax.swing.JButton jButton6;
    public javax.swing.JMenu jMenu1;
    public javax.swing.JMenu jMenu2;
    public javax.swing.JMenu jMenu3;
    public javax.swing.JMenu jMenu4;
    public javax.swing.JMenu jMenu5;
    public javax.swing.JMenu jMenu6;
    public javax.swing.JMenu jMenu7;
    public javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenuItem jMenuItem1;
    public javax.swing.JMenuItem jMenuItem10;
    public javax.swing.JMenuItem jMenuItemListaMembresias;
    public javax.swing.JMenuItem jMenuItem12;
    public javax.swing.JMenuItem jMenuItem13;
    public javax.swing.JMenuItem jMenuItem14;
    public javax.swing.JMenuItem jMenuItemRegistrarSocio;
    public javax.swing.JMenuItem jMenuItem3buscarSocio;
    public javax.swing.JMenuItem jMenuItem4;
    public javax.swing.JMenuItem jMenuItem5;
    public javax.swing.JMenuItem jMenuItem6;
    public javax.swing.JMenuItem jMenuItem7;
    public javax.swing.JMenuItem jMenuItem8;
    public javax.swing.JMenuItem jMenuItem9;
    public javax.swing.JPanel jPanel1;

    private JMenuItem mntmListadoDeSocios;

    private JMenu jMenuEntrenador;
    private JMenuItem jMenuItemRegistrarEntrenador;
    private JMenuItem jMenuItemBuscarEntrenador;
    private JLabel lblNewLabel;
    private JMenuItem jMenuItemListaEntrenador;

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
	public JMenuItem getJMenuItemCumpleanios() {
		return jMenuItem5;
	}
	public JMenuItem getJMenuItemRegistrarEntrenador() {
		return jMenuItemRegistrarEntrenador;
	}
	public JMenuItem getJMenuItemBuscarEntrenador() {
		return jMenuItemBuscarEntrenador;
	}
	public JMenuItem getJMenuItemListaEntrenador() {
		return jMenuItemListaEntrenador;
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
	public JButton getJButtonRegistrarEntrada() {
		return jButtonRegistrarEntrada;
	}
}

package co.powergym.view.util;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

// CLASE QUE EXTIENDA DE JBUTTON
public class MiBoton extends JButton {

	// Creamos la variable que representa la opacidad
	

	// CONSTRUCTOR CON TEXTO
	public MiBoton(String text) {
		super(text);
		addMouseListener(new EventButton());
		setBorder(new RoundedBorder(10));
	}

	// CONSTRUCTOR SIN TEXTO
	public MiBoton() {
		super();
		addMouseListener(new EventButton());
	}

	

	// Sobreescribir el metodo del padre para que aparesca el boton, y pasarle
	// el valor de mi opacidad
	@Override
	public void paintComponent(Graphics g) {
		 Graphics2D g2 = (Graphics2D)g.create();
	        g2.setPaint(new GradientPaint(
	                new Point(0, 0), 
	                new Color(91, 193, 255), 
	                new Point(0, getHeight()), 
	                Color.BLACK));
	        g2.fillRect(0, 0, getWidth(), getHeight());
	        
	        g2.dispose();

		super.paintComponent(g2);
	}

	// Clase anidad
	public class EventButton extends MouseAdapter {
		// EL MOUSE SALE
		@Override
		public void mouseExited(MouseEvent me) {
			
		}

		// EL MOUSE ENTRA
		@Override
		public void mouseEntered(MouseEvent me) {
			
		}

		// HACES CLICK AL CONTROL
		@Override
		public void mousePressed(MouseEvent me) {
			
		}
	}

	private static class RoundedBorder implements Border {

	    private int radius;


	    RoundedBorder(int radius) {
	        this.radius = radius;
	    }


	    public Insets getBorderInsets(Component c) {
	        return new Insets(this.radius, this.radius, this.radius, this.radius);
	    }


	    public boolean isBorderOpaque() {
	        return true;
	    }


	    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
	    	g.setColor(Color.WHITE);
	        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
	    }
	}
}

package co.powergym.utils;

import java.awt.Button;
import java.awt.Color;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class ButtonPrincipal extends JButton {

	/**
	 * 
	 */
	public ButtonPrincipal() {
		super();
		setForeground(Color.BLACK);
		setBackground(Constantes.blue());
		setBorder(new LineBorder(Color.BLUE, 3, true));
	}

	/**
	 * @param text
	 */
	public ButtonPrincipal(String text) {
		super(text);
		setText(text);
		setForeground(Color.BLACK);
		setBackground(Constantes.blue());
		setBorder(new LineBorder(Color.BLUE, 3, true));
	}

}

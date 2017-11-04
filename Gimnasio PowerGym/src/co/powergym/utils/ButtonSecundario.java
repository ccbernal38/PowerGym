package co.powergym.utils;

import java.awt.Button;
import java.awt.Color;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class ButtonSecundario extends JButton {

	/**
	 * 
	 */
	public ButtonSecundario() {
		super();
		setForeground(Color.BLACK);
		setBackground(Constantes.white());
		setBorder(new LineBorder(Color.WHITE, 3, true));
	}

	/**
	 * @param text
	 */
	public ButtonSecundario(String text) {
		super(text);
		setText(text);
		setForeground(Color.BLACK);
		setBackground(Constantes.white());
		setBorder(new LineBorder(Color.WHITE, 3, true));
	}

}

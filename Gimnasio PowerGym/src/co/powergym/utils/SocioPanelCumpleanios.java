package co.powergym.utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import co.powergym.model.Socio;

public class SocioPanelCumpleanios extends JPanel implements ListCellRenderer<Socio> {

	private JLabel lbIcon = new JLabel();
	private JLabel lbName = new JLabel();
	private JLabel lbAuthor = new JLabel();

	public SocioPanelCumpleanios() {
		setLayout(new BorderLayout(5, 5));

		JPanel panelText = new JPanel(new GridLayout(0, 1));
		panelText.add(lbName);
		panelText.add(lbAuthor);
		add(lbIcon, BorderLayout.WEST);
		add(panelText, BorderLayout.CENTER);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Socio> list, Socio book, int index,
			boolean isSelected, boolean cellHasFocus) {

		lbIcon.setIcon(new ImageIcon(book.getFoto()));
		lbName.setText(book.getNombreCompleto());
		lbName.setForeground(Color.blue);

		return this;
	}
}
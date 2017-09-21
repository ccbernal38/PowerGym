package co.powergym.utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import co.powergym.model.Socio;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class SocioPanelCumpleanios extends JPanel implements ListCellRenderer<Socio> {

	private JLabel lbIcon = new JLabel();
	private JLabel lbName = new JLabel();

	public SocioPanelCumpleanios() {
		setBorder(new EmptyBorder(0, 0, 3, 0));
		setLayout(new BorderLayout(5, 5));
		lbIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lbIcon.setSize(50, 50);

		JPanel panelText = new JPanel(new GridLayout(0, 1));
		panelText.setBackground(new Color(0, 0, 0, 0));
		this.setBackground(new Color(0, 0, 0, 0));
		lbIcon.setBackground(new Color(0, 0, 0, 0));
		lbName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbName.setHorizontalAlignment(SwingConstants.CENTER);
		lbName.setForeground(Color.white);
		lbName.setBackground(new Color(0, 0, 0, 0));
		panelText.add(lbName);
		add(lbIcon, BorderLayout.NORTH);
		add(panelText, BorderLayout.SOUTH);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Socio> list, Socio socio, int index,
			boolean isSelected, boolean cellHasFocus) {
		Image dimg = socio.getFoto().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING);
		lbIcon.setIcon(new ImageIcon(dimg));
		lbName.setText(socio.getNombreCompleto());
		return this;
	}
}
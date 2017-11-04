package co.powergym.view.caja;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import co.powergym.utils.ButtonSecundario;
import co.powergym.utils.Constantes;

import javax.swing.JSeparator;

public class CajaHistoricoDetalleView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEgresos;
	private JTextField textFieldVisitas;
	private JTextField textFieldVentasM;
	private JLabel labelResponsableApertura;
	private JLabel labelFechaApertura;
	private JLabel labelResponsableCierre;
	private JButton btnCancelar;
	private JTextField textFieldAdeudos;
	private JTextField textFieldSaldoFavor;
	private JLabel labelFechaCierre;

	public CajaHistoricoDetalleView() {
		setResizable(false);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage("D:\\PowerGym\\PowerGym\\Gimnasio PowerGym\\image\\icon.ico"));
		setTitle("Cierre de caja");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 473, 506);
		contentPane = new JPanel();
		contentPane.setBackground(Constantes.black());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Constantes.black());
		panel.setBounds(10, 78, 448, 349);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Responsable de apertura:");
		lblNewLabel.setForeground(Constantes.white());
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 232, 24);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Fecha de apertura:");
		lblNewLabel_1.setForeground(Constantes.white());
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 46, 232, 24);
		panel.add(lblNewLabel_1);

		JLabel lblResponsableDeCierre = new JLabel("Responsable de cierre:");
		lblResponsableDeCierre.setForeground(Constantes.white());
		lblResponsableDeCierre.setFont(new Font("Verdana", Font.BOLD, 14));
		lblResponsableDeCierre.setBounds(10, 81, 232, 24);
		panel.add(lblResponsableDeCierre);

		JLabel lblVentaDeMembresias = new JLabel("Venta de membres\u00EDas:");
		lblVentaDeMembresias.setForeground(Constantes.white());
		lblVentaDeMembresias.setFont(new Font("Verdana", Font.BOLD, 14));
		lblVentaDeMembresias.setBounds(10, 167, 232, 27);
		panel.add(lblVentaDeMembresias);

		JLabel lblVisitasDelDia = new JLabel("Visitas del d\u00EDa:");
		lblVisitasDelDia.setForeground(Constantes.white());
		lblVisitasDelDia.setFont(new Font("Verdana", Font.BOLD, 14));
		lblVisitasDelDia.setBounds(10, 205, 232, 24);
		panel.add(lblVisitasDelDia);

		JLabel lblEgresosDelDia = new JLabel("Egresos del d\u00EDa:");
		lblEgresosDelDia.setForeground(Constantes.white());
		lblEgresosDelDia.setFont(new Font("Verdana", Font.BOLD, 14));
		lblEgresosDelDia.setBounds(10, 278, 232, 24);
		panel.add(lblEgresosDelDia);

		textFieldEgresos = new JTextField();
		textFieldEgresos.setForeground(new Color(128, 0, 0));
		textFieldEgresos.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldEgresos.setFont(new Font("Verdana", Font.BOLD, 14));
		textFieldEgresos.setEditable(false);
		textFieldEgresos.setBounds(232, 277, 200, 27);
		panel.add(textFieldEgresos);
		textFieldEgresos.setColumns(10);

		textFieldVisitas = new JTextField();
		textFieldVisitas.setForeground(new Color(34, 139, 34));
		textFieldVisitas.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldVisitas.setFont(new Font("Verdana", Font.BOLD, 14));
		textFieldVisitas.setEditable(false);
		textFieldVisitas.setColumns(10);
		textFieldVisitas.setBounds(232, 204, 200, 27);
		panel.add(textFieldVisitas);

		textFieldVentasM = new JTextField();
		textFieldVentasM.setForeground(new Color(34, 139, 34));
		textFieldVentasM.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldVentasM.setFont(new Font("Verdana", Font.BOLD, 14));
		textFieldVentasM.setEditable(false);
		textFieldVentasM.setColumns(10);
		textFieldVentasM.setBounds(232, 167, 200, 27);
		panel.add(textFieldVentasM);

		labelResponsableCierre = new JLabel("");
		labelResponsableCierre.setForeground(Constantes.white());
		labelResponsableCierre.setHorizontalAlignment(SwingConstants.RIGHT);
		labelResponsableCierre.setFont(new Font("Verdana", Font.BOLD, 14));
		labelResponsableCierre.setBounds(232, 81, 200, 24);
		panel.add(labelResponsableCierre);

		labelFechaApertura = new JLabel("");
		labelFechaApertura.setForeground(Constantes.white());
		labelFechaApertura.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFechaApertura.setFont(new Font("Verdana", Font.BOLD, 14));
		labelFechaApertura.setBounds(232, 46, 200, 24);
		panel.add(labelFechaApertura);

		labelResponsableApertura = new JLabel("");
		labelResponsableApertura.setForeground(Constantes.white());
		labelResponsableApertura.setHorizontalAlignment(SwingConstants.RIGHT);
		labelResponsableApertura.setFont(new Font("Verdana", Font.BOLD, 14));
		labelResponsableApertura.setBounds(232, 11, 200, 24);
		panel.add(labelResponsableApertura);

		textFieldAdeudos = new JTextField();
		textFieldAdeudos.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldAdeudos.setForeground(new Color(128, 0, 0));
		textFieldAdeudos.setFont(new Font("Verdana", Font.BOLD, 14));
		textFieldAdeudos.setEditable(false);
		textFieldAdeudos.setColumns(10);
		textFieldAdeudos.setBounds(232, 313, 200, 27);
		panel.add(textFieldAdeudos);

		textFieldSaldoFavor = new JTextField();
		textFieldSaldoFavor.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldSaldoFavor.setForeground(new Color(34, 139, 34));
		textFieldSaldoFavor.setFont(new Font("Verdana", Font.BOLD, 14));
		textFieldSaldoFavor.setEditable(false);
		textFieldSaldoFavor.setColumns(10);
		textFieldSaldoFavor.setBounds(232, 240, 200, 27);
		panel.add(textFieldSaldoFavor);

		JLabel lblSaldoAFavor = new JLabel("Saldo a favor:");
		lblSaldoAFavor.setForeground(Constantes.white());
		lblSaldoAFavor.setFont(new Font("Verdana", Font.BOLD, 14));
		lblSaldoAFavor.setBounds(10, 243, 232, 24);
		panel.add(lblSaldoAFavor);

		JLabel lblAdeudos = new JLabel("Cuentas por cobrar:");
		lblAdeudos.setForeground(Constantes.white());
		lblAdeudos.setFont(new Font("Verdana", Font.BOLD, 14));
		lblAdeudos.setBounds(10, 314, 232, 24);
		panel.add(lblAdeudos);

		JLabel lblFechaDeCierre = new JLabel("Fecha de cierre:");
		lblFechaDeCierre.setForeground(Constantes.white());
		lblFechaDeCierre.setFont(new Font("Verdana", Font.BOLD, 14));
		lblFechaDeCierre.setBounds(10, 116, 232, 24);
		panel.add(lblFechaDeCierre);

		labelFechaCierre = new JLabel("");
		labelFechaCierre.setForeground(Constantes.white());
		labelFechaCierre.setHorizontalAlignment(SwingConstants.RIGHT);
		labelFechaCierre.setFont(new Font("Verdana", Font.BOLD, 14));
		labelFechaCierre.setBounds(232, 116, 200, 24);
		panel.add(labelFechaCierre);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 148, 422, 8);
		panel.add(separator);

		btnCancelar = new ButtonSecundario("Cancelar");
		btnCancelar.setBounds(329, 438, 113, 23);
		contentPane.add(btnCancelar);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 467, 56);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JLabel lblCierreDeCaja = new JLabel("DETALLE DE CAJA");
		panel_1.add(lblCierreDeCaja, BorderLayout.CENTER);
		lblCierreDeCaja.setHorizontalAlignment(SwingConstants.CENTER);
		lblCierreDeCaja.setFont(new Font("Verdana", Font.BOLD, 18));
	}

	public JLabel getLabelResponsableApertura() {
		return labelResponsableApertura;
	}

	public JLabel getLabelFechaApertura() {
		return labelFechaApertura;
	}

	public JLabel getLabelResponsableCierre() {
		return labelResponsableCierre;
	}

	public JTextField getTextFieldVentasM() {
		return textFieldVentasM;
	}

	public JTextField getTextFieldVisitas() {
		return textFieldVisitas;
	}

	public JTextField getTextFieldEgresos() {
		return textFieldEgresos;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JTextField getTextFieldSaldoFavor() {
		return textFieldSaldoFavor;
	}

	public JTextField getTextFieldAdeudos() {
		return textFieldAdeudos;
	}

	public JLabel getLabelFechaCierre() {
		return labelFechaCierre;
	}
}

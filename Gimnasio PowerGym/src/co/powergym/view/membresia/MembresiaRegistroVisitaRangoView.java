package co.powergym.view.membresia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JButton;
import com.toedter.components.JSpinField;

import co.powergym.utils.ButtonSecundario;

import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;

public class MembresiaRegistroVisitaRangoView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSocio;
	private JTextField textFieldNombres;
	private JTextField textFieldApellidos;
	private JTextField textFieldValor;
	private JButton btnCancelar;
	private JButton btnRegistrar;
	private JButton btnBuscar;
	private JLabel lblHoraDeFin;
	private JSpinner spinner_1;
	private JSpinner spinner2;
	private JSpinner spinner;
	private JPanel panel;

	/**
	 * Create the frame.
	 */
	public MembresiaRegistroVisitaRangoView() {
		setTitle("Registrar visita");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 535, 348);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(42, 45, 52));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 91, 519, 207);
		panel_1.setBackground(new Color(0, 0, 0, 0));
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblSocio = new JLabel("Socio:");
		lblSocio.setBounds(10, 30, 93, 14);
		lblSocio.setForeground(Color.WHITE);
		lblSocio.setFont(new Font("Verdana", Font.BOLD, 12));
		panel_1.add(lblSocio);

		textFieldSocio = new JTextField();
		textFieldSocio.setBounds(113, 28, 135, 20);
		textFieldSocio.setFont(new Font("Verdana", Font.PLAIN, 11));
		panel_1.add(textFieldSocio);
		textFieldSocio.setColumns(10);

		btnBuscar = new ButtonSecundario("Buscar");
		btnBuscar.setBounds(258, 27, 89, 23);
		panel_1.add(btnBuscar);

		JLabel lblNombre = new JLabel("Nombres:");
		lblNombre.setBounds(10, 62, 93, 14);
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Verdana", Font.BOLD, 12));
		panel_1.add(lblNombre);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(258, 62, 93, 14);
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Verdana", Font.BOLD, 12));
		panel_1.add(lblApellidos);

		textFieldNombres = new JTextField();
		textFieldNombres.setBounds(113, 59, 135, 20);
		textFieldNombres.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldNombres.setColumns(10);
		panel_1.add(textFieldNombres);

		textFieldApellidos = new JTextField();
		textFieldApellidos.setBounds(361, 59, 135, 20);
		textFieldApellidos.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldApellidos.setColumns(10);
		panel_1.add(textFieldApellidos);

		textFieldValor = new JTextField();
		textFieldValor.setBounds(113, 122, 135, 20);
		textFieldValor.setFont(new Font("Verdana", Font.PLAIN, 11));
		panel_1.add(textFieldValor);
		textFieldValor.setColumns(10);

		JLabel lblValor = new JLabel("Hora de inicio:");
		lblValor.setBounds(10, 92, 110, 14);
		lblValor.setForeground(Color.WHITE);
		lblValor.setFont(new Font("Verdana", Font.BOLD, 12));
		panel_1.add(lblValor);

		btnRegistrar = new ButtonSecundario("Registrar");
		btnRegistrar.setBounds(321, 173, 89, 23);
		panel_1.add(btnRegistrar);

		btnCancelar = new ButtonSecundario("Cancelar");
		btnCancelar.setBounds(420, 173, 89, 23);
		panel_1.add(btnCancelar);

		JLabel label = new JLabel("Valor:");
		label.setBounds(10, 124, 93, 14);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Verdana", Font.BOLD, 12));
		panel_1.add(label);

		lblHoraDeFin = new JLabel("Hora de fin:");
		lblHoraDeFin.setBounds(258, 93, 110, 14);
		lblHoraDeFin.setForeground(Color.WHITE);
		lblHoraDeFin.setFont(new Font("Verdana", Font.BOLD, 12));
		panel_1.add(lblHoraDeFin);

		Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(0, 0, 0, 0, 0, 0));
        
        spinner2 = new JSpinner(new SpinnerDateModel(new Date(1507111200847L), null, null, Calendar.DAY_OF_MONTH));
        spinner2.setBounds(113, 91, 135, 20);
        spinner2.setFont(new Font("Verdana", Font.PLAIN, 11));
        JSpinner.DateEditor de_spinner2 = new JSpinner.DateEditor(spinner2, "hh:mm:ss a");
        DateFormatter formatter2 = (DateFormatter)de_spinner2.getTextField().getFormatter();
        formatter2.setAllowsInvalid(false); // this makes what you want
        formatter2.setOverwriteMode(true);

        spinner2.setEditor(de_spinner2);

        panel_1.add(spinner2);
		
		
        SpinnerDateModel model = new SpinnerDateModel();
        model.setValue(calendar.getTime());

        spinner = new JSpinner(new SpinnerDateModel(new Date(1507172400847L), null, null, Calendar.DAY_OF_MONTH));
        spinner.setBounds(361, 90, 135, 20);
        spinner.setFont(new Font("Verdana", Font.PLAIN, 11));
        JSpinner.DateEditor de_spinner = new JSpinner.DateEditor(spinner, "hh:mm:ss a");
        DateFormatter formatter = (DateFormatter)de_spinner.getTextField().getFormatter();
        formatter.setAllowsInvalid(false); // this makes what you want
        formatter.setOverwriteMode(true);

        spinner.setEditor(de_spinner);

        panel_1.add(spinner);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 519, 56);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registrar Visita");
		lblNewLabel.setBounds(10, 11, 509, 23);
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
	}

	public JTextField getTextFieldApellidos() {
		return textFieldApellidos;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JTextField getTextFieldSocio() {
		return textFieldSocio;
	}

	public JTextField getTextFieldNombres() {
		return textFieldNombres;
	}

	public JTextField getTextFieldValor() {
		return textFieldValor;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}
	public JSpinner getSpinnerHoraInicio() {
		return spinner2;
	}
	public JSpinner getSpinnerHoraFin() {
		return spinner;
	}
}

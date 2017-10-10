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

	/**
	 * Create the frame.
	 */
	public MembresiaRegistroVisitaRangoView() {
		setTitle("Registrar visita");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 535, 257);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(42, 45, 52));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0, 0));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JLabel lblSocio = new JLabel("Socio:");
		lblSocio.setForeground(Color.WHITE);
		lblSocio.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblSocio.setBounds(10, 30, 93, 14);
		panel_1.add(lblSocio);

		textFieldSocio = new JTextField();
		textFieldSocio.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldSocio.setBounds(113, 28, 135, 20);
		panel_1.add(textFieldSocio);
		textFieldSocio.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(258, 27, 89, 23);
		panel_1.add(btnBuscar);

		JLabel lblNombre = new JLabel("Nombres:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Verdana", Font.BOLD, 11));
		lblNombre.setBounds(10, 62, 93, 14);
		panel_1.add(lblNombre);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Verdana", Font.BOLD, 11));
		lblApellidos.setBounds(258, 62, 93, 14);
		panel_1.add(lblApellidos);

		textFieldNombres = new JTextField();
		textFieldNombres.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldNombres.setColumns(10);
		textFieldNombres.setBounds(113, 59, 135, 20);
		panel_1.add(textFieldNombres);

		textFieldApellidos = new JTextField();
		textFieldApellidos.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldApellidos.setColumns(10);
		textFieldApellidos.setBounds(361, 59, 135, 20);
		panel_1.add(textFieldApellidos);

		textFieldValor = new JTextField();
		textFieldValor.setBounds(113, 122, 135, 20);
		panel_1.add(textFieldValor);
		textFieldValor.setColumns(10);

		JLabel lblValor = new JLabel("Hora de inicio:");
		lblValor.setForeground(Color.WHITE);
		lblValor.setFont(new Font("Verdana", Font.BOLD, 11));
		lblValor.setBounds(10, 92, 110, 14);
		panel_1.add(lblValor);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(258, 153, 89, 23);
		panel_1.add(btnRegistrar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(159, 153, 89, 23);
		panel_1.add(btnCancelar);

		JLabel label = new JLabel("Valor:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Verdana", Font.BOLD, 11));
		label.setBounds(10, 124, 93, 14);
		panel_1.add(label);

		lblHoraDeFin = new JLabel("Hora de fin:");
		lblHoraDeFin.setForeground(Color.WHITE);
		lblHoraDeFin.setFont(new Font("Verdana", Font.BOLD, 11));
		lblHoraDeFin.setBounds(258, 93, 110, 14);
		panel_1.add(lblHoraDeFin);

		Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(0, 0, 0, 0, 0, 0));
        
        spinner2 = new JSpinner(new SpinnerDateModel(new Date(1507111200847L), null, null, Calendar.DAY_OF_MONTH));
        spinner2.setBounds(113, 91, 135, 20);
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
        JSpinner.DateEditor de_spinner = new JSpinner.DateEditor(spinner, "hh:mm:ss a");
        DateFormatter formatter = (DateFormatter)de_spinner.getTextField().getFormatter();
        formatter.setAllowsInvalid(false); // this makes what you want
        formatter.setOverwriteMode(true);

        spinner.setEditor(de_spinner);

        panel_1.add(spinner);
        
		JLabel lblNewLabel = new JLabel("Registrar Visita");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
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

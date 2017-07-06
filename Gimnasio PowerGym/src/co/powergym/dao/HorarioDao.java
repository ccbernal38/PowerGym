package co.powergym.dao;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.imageio.ImageIO;

import co.powergym.interfacedao.HorarioDaoInterface;
import co.powergym.model.Conexion;
import co.powergym.model.Horario;
import co.powergym.model.Socio;

public class HorarioDao implements HorarioDaoInterface {
	Conexion conexion;

	public HorarioDao() {
		conexion = new Conexion();
	}

	@Override
	public List<Horario> listadoHorariosMembresia(int codigoMembresia) {
		List<Horario> list = new ArrayList<Horario>();
		Horario horario;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from Horario");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				horario = new Horario();
				horario.setId(resultSet.getInt(1));
				horario.setHoraInicio(resultSet.getDate(2));
				horario.setHoraFin(resultSet.getDate(3));
				horario.setCodigoMembresia(resultSet.getInt(4));
				list.add(horario);
			}
		} catch (Exception e) {
		}
		return list;
	}

	@Override
	public boolean registrarHorarioMembresia(Date horaInicio, Date horaFin, int codigoMembresia) {
		boolean respuesta = false;
		try {
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD
					.prepareStatement("INSERT INTO Horario(horaInicio, horaFin, Membresia_id) VALUES(?,?,?)");
			statement.setDate(1, horaInicio);
			statement.setDate(2, horaFin);
			statement.setInt(3, codigoMembresia);
			statement.execute();
			respuesta = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return respuesta;
	}

}

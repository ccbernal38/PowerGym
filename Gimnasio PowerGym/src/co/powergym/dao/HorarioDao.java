package co.powergym.dao;


import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.powergym.interfacedao.HorarioDaoInterface;
import co.powergym.model.Conexion;
import co.powergym.model.Horario;

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
			conexion.desconectar();
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
			statement.setDate(1, new java.sql.Date( horaInicio.getTime()));
			statement.setDate(2, new java.sql.Date(horaFin.getTime()));
			statement.setInt(3, codigoMembresia);
			statement.execute();
			respuesta = true;
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return respuesta;
	}

}

package co.powergym.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import co.powergym.interfacedao.AsistenciaInterfaceDao;
import co.powergym.model.Asistencia;
import co.powergym.model.Conexion;

public class AsistenciaDao implements AsistenciaInterfaceDao {

	Conexion conexion;

	public AsistenciaDao() {
		conexion = new Conexion();
	}

	@Override
	public List<Asistencia> historicoAsistencias(int idSocio) {
		List<Asistencia> list = new ArrayList<Asistencia>();
		Asistencia asistencia;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, fechaCreacion FROM Asistencia Where socio_id = ? order by fechaCreacion DESC");
			preparedStatement.setInt(1, idSocio);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				asistencia = new Asistencia();
				asistencia.setId(resultSet.getInt(1));
				Timestamp timestamp = resultSet.getTimestamp(2);
				Date date = new Date(timestamp.getTime());
				asistencia.setFecha(date);
				list.add(asistencia);
			}
			conexion.desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void registrarAsistencia(int idSocio) {
		try {
			Connection accesoBD = conexion.getConexion();
			PreparedStatement statement = accesoBD
					.prepareStatement("INSERT INTO Asistencia(socio_id) VALUES(?,?)");
			statement.setTimestamp(1, new Timestamp(Calendar.getInstance().getTime().getTime()));
			statement.setInt(2, idSocio);
			statement.execute();
			conexion.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

/**
 * 
 */
package co.powergym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import co.powergym.interfacedao.DiaSemanaDaoInterface;
import co.powergym.model.Conexion;
import co.powergym.model.DiaSemana;

/**
 * @author crisd
 *
 */
public class DiaSemanaDao implements DiaSemanaDaoInterface{

	Conexion conexion;
	/**
	 * Constructor
	 */
	public DiaSemanaDao() {
		conexion = new Conexion();
	}
	@Override
	public DiaSemana buscarDiaSemana(String nombre) {
			
		DiaSemana diaSemana = null;
		try {
			Connection connection = conexion.getConexion();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT d.id as id FROM diaSemana d WHERE d.nombre = ?");
			preparedStatement.setString(1, nombre);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				diaSemana = new DiaSemana();
				diaSemana.setId(resultSet.getInt("id"));
							}
			conexion.desconectar();
		} catch (Exception e) {
			System.out.println("error");
		}
		return diaSemana;
	}
}

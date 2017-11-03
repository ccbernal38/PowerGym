package co.powergym.model;

import java.sql.*;

public class Conexion {
	private Connection con;

	public Conexion() {

	}

	public Connection getConexion() {
		con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://192.168.1.8/powergym", "root", "root");
		} catch (Exception e) {
		}

		return con;
	}
	
	
	public void desconectar() {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

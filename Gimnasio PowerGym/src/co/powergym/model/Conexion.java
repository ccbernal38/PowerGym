package co.powergym.model;
import java.sql.*;

public class Conexion {
    public Conexion(){
        
    }
    
    public Connection getConexion(){
        Connection con = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://192.168.1.6:3306/mydb", "root", "");
        } catch (Exception e) {
        }
        
        return con;
    }
}

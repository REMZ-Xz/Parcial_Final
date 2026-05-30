package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
  
    private static final String URL = "jdbc:mysql://localhost:3306/parcial_final_db";
    private static final String USER = "root";
    
    private static final String PASSWORD = "gcn1b8xn"; 

    public static Connection getConexion() {
        Connection cn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Driver de MySQL no encontrado.");
        } catch (SQLException e) {
            System.out.println("Error de conexion: " + e.getMessage());
        }
        return cn;
    }
}

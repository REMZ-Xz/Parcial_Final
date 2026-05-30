package parcial_java;

import db.Conexion;
import java.sql.Connection;
import java.sql.SQLException;

public class PersonajeController {

   
    public boolean verificarConexion() {
        Connection cn = Conexion.getConexion();
        if (cn != null) {
            try {
                cn.close(); 
                return true;
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }
}

package parcial_java;

import db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public boolean crearPersonaje(String nombre, int claseId, int vida) {
        String sql = "INSERT INTO personaje (nombre, clase_id, vida) VALUES (?, ?, ?)";
        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setString(1, nombre);
            ps.setInt(2, claseId);
            ps.setInt(3, vida);
            
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al crear personaje: " + e.getMessage());
            return false;
        }
    }

    public void listarPersonajes() {
        String sql = "SELECT * FROM personaje";
        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            System.out.println("\n--- PERSONAJES ---");
            boolean tienePersonajes = false;
            
            while (rs.next()) {
                tienePersonajes = true;
                System.out.println("ID: " + rs.getInt("id") + 
                                   " Nombre: " + rs.getString("nombre") + 
                                   " Clase ID: " + rs.getInt("clase_id") + 
                                   " Vida: " + rs.getInt("vida"));
            }
            
            if (!tienePersonajes) {
                System.out.println("No hay personajes registrados.");
            }
        } catch (SQLException e) {
            System.out.println("Error al listar personajes: " + e.getMessage());
        }
    }
}

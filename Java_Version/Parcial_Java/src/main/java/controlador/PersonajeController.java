package controlador;

import db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Personaje;

public class PersonajeController {

    public boolean verificarConexion() {
        Connection cn = Conexion.getConexion();
        if (cn != null) {
            try {
                cn.close();
                return true;
            } catch (SQLException e) {
                System.out.println("No se pudo cerrar la conexion: " + e.getMessage());
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
            System.out.println("No se pudo crear el personaje: " + e.getMessage());
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
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int claseId = rs.getInt("clase_id");
                int vida = rs.getInt("vida");
                
                Personaje p;
                
                switch (claseId) {
                    case 1:
                        p = new Personaje(id, nombre, claseId, vida) {
                            @Override
                            public String habilidadEspecial() {
                                return "blande su espada";
                            }
                        };
                        break;
                    case 2:
                        p = new Personaje(id, nombre, claseId, vida) {
                            @Override
                            public String habilidadEspecial() {
                                return "lanza fuego";
                            }
                        };
                        break;
                    case 3:
                        p = new Personaje(id, nombre, claseId, vida) {
                            @Override
                            public String habilidadEspecial() {
                                return "dispara una flecha";
                            }
                        };
                        break;
                    default:
                        p = new Personaje(id, nombre, claseId, vida) {
                            @Override
                            public String habilidadEspecial() {
                                return "ataca";
                            }
                        };
                        break;
                }
                
                System.out.println("ID: " + p.getId() + 
                                   " Nombre: " + p.getNombre() + 
                                   " Clase ID: " + p.getClaseId() + 
                                   " Vida: " + p.getVida() + 
                                   " Accion: " + p.habilidadEspecial());
            }
            
            if (!tienePersonajes) {
                System.out.println("No hay personajes ");
            }
        } catch (SQLException e) {
            System.out.println("No se pueden mostrar los personajes: " + e.getMessage());
        }
    }
        
    public boolean eliminarPersonaje(int id) {
        String sql = "DELETE FROM personaje WHERE id = ?";
        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0; 
        } catch (SQLException e) {
            System.out.println("Ya se borro: " + e.getMessage());
            return false;
        }
    }
}

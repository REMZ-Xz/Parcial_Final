package vista;

import parcial_java.PersonajeController;

public class MenuVista {
    private PersonajeController controlador;

    public MenuVista() {
        this.controlador = new PersonajeController();
    }

    public void iniciar() {
        System.out.println("=== RPG MANAGER ===");
        
        if (controlador.verificarConexion()) {
            System.out.println("Conexion exitosa con MySQL.");
            System.out.println("El sistema esta listo.");
        } else {
            System.out.println("Error: No se pudo conectar a MySQL.");
            System.out.println("Verifica tus credenciales o que el servidor este encendido.");
        }
    }
}

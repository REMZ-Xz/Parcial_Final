package vista;

import parcial_java.PersonajeController;

public class MenuVista {
    private PersonajeController controlador;

    public MenuVista() {
        this.controlador = new PersonajeController();
    }

        public void iniciar() {
        System.out.println("Sistema");
        
        if (controlador.verificarConexion()) {
            System.out.println("Conexion hecha.");
            System.out.println("El sistema esta listo.\n");
            
            java.util.Scanner teclado = new java.util.Scanner(System.in);
            int opcion = 0;
            
            while (opcion != 3) {
                System.out.println("--- MENU PRINCIPAL ---");
                System.out.println("1. Crear nuevo personaje");
                System.out.println("2. Ver personajes");
                System.out.println("3. Salir");
                System.out.print("Selecciona una opcion: ");
                
                opcion = teclado.nextInt();
                
                switch (opcion) {
                    case 1:
                        teclado.nextLine(); 
                        System.out.print("Nombre del personaje: ");
                        String nombre = teclado.nextLine();
                        System.out.print("ID de la clase (1=Guerrero, 2=Mago, 3=Arquero): ");
                        int claseId = teclado.nextInt();
                        System.out.print("Puntos de vida: ");
                        int vida = teclado.nextInt();
                        
                        if (controlador.crearPersonaje(nombre, claseId, vida)) {
                            System.out.println("Personaje guardado");
                        } else {
                            System.out.println("No se pudo guardar el personaje");
                        }
                        break;
                    case 2:
                        controlador.listarPersonajes();
                        break;
                    case 3:
                        System.out.println("Saliendo del sistema");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }

                System.out.println();
            }
            
        } else {
            System.out.println("No se pudo conectar.");
            System.out.println("Revisar que los parametros requeridos esten bien y que el servidor este prendido");
        }
    }

}

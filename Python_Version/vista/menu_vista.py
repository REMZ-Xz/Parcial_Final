from controlador.personaje_controller import PersonajeController

class MenuVista:
    def __init__(self):
        self.controlador = PersonajeController()

    def iniciar(self):
        print("Sistema")
        if self.controlador.verificar_conexion():
            print("Conexion hecha.")
            print("El sistema esta listo.\n")
            opcion = 0
            while opcion != 4:
                print("--- MENU PRINCIPAL ---")
                print("1. Crear nuevo personaje")
                print("2. Ver personajes")
                print("3. Eliminar personaje por ID")
                print("4. Salir")
                try:
                    opcion = int(input("Selecciona una opcion: "))
                except ValueError:
                    print("Opcion no valida\n")
                    continue
                if opcion == 1:
                    nombre = input("Nombre del personaje: ")
                    try:
                        clase_id = int(input("ID de la clase (1=Guerrero, 2=Mago, 3=Arquero): "))
                        vida = int(input("Puntos de vida: "))
                        if self.controlador.crear_personaje(nombre, clase_id, vida):
                            print("Personaje guardado")
                        else:
                            print("No se pudo guardar el personaje")
                    except ValueError:
                        print("Error: Datos numericos invalidos.")
                elif opcion == 2:
                    self.controlador.listar_personajes()
                elif opcion == 3:
                    try:
                        id_eliminar = int(input("Ingresa el ID del personaje: "))
                        if self.controlador.eliminar_personaje(id_eliminar):
                            print("Personaje eliminado")
                        else:
                            print("No se encontro el personaje")
                    except ValueError:
                        print("Error: ID debe ser numerico.")
                elif opcion == 4:
                    print("Saliendo del sistema")
                else:
                    print("Opcion no valida")
                print()
        else:
            print("No se pudo conectar.")
            print("Revisar que los parametros requeridos esten bien y que el servidor este prendido")

from db.conexion import Conexion
from mysql.connector import Error
from modelo.personaje import Personaje, Guerrero  

class PersonajeController:
    def verificar_conexion(self):
        cn = Conexion.get_conexion()
        if cn is not None:
            try:
                cn.close()
                return True
            except Error:
                return False
        return False

    def crear_personaje(self, nombre, clase_id, vida):
        sql = "INSERT INTO personaje (nombre, clase_id, vida) VALUES (%s, %s, %s)"
        cn = Conexion.get_conexion()
        if cn is None:
            return False
        try:
            cursor = cn.cursor()
            cursor.execute(sql, (nombre, clase_id, vida))
            cn.commit()
            cursor.close()
            cn.close()
            return True
        except Error as e:
            print(f"Error al crear: {e}")
            return False

    def listar_personajes(self):
        sql = "SELECT * FROM personaje"
        cn = Conexion.get_conexion()
        if cn is None:
            return
        try:
            cursor = cn.cursor(dictionary=True)
            cursor.execute(sql)
            personajes = cursor.fetchall()
            print("\n--- LISTA DE PERSONAJES ---")
            if not personajes:
                print("No hay personajes registrados.")
            else:
                for p in personajes:
                   
                    if p['clase_id'] == 1:
                        obj_p = Guerrero(p['id'], p['nombre'], p['vida'])
                    else:
                        obj_p = Personaje(p['id'], p['nombre'], p['clase_id'], p['vida'])
                    
                    print(f"ID: {obj_p.id} | Nombre: {obj_p.nombre} (Vida: {obj_p.vida}) -> {obj_p.atacar()}")
            
            cursor.close()
            cn.close()
        except Error as e:
            print(f"Error al listar: {e}")

    def eliminar_personaje(self, id_personaje):
        sql = "DELETE FROM personaje WHERE id = %s"
        cn = Conexion.get_conexion()
        if cn is None:
            return False
        try:
            cursor = cn.cursor()
            cursor.execute(sql, (id_personaje,))
            cn.commit()
            filas = cursor.rowcount
            cursor.close()
            cn.close()
            return filas > 0
        except Error as e:
            print(f"Error al eliminar: {e}")
            return False


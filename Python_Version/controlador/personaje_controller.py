from db.conexion import Conexion
from mysql.connector import Error

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
                    print(f"ID: {p['id']} | Nombre: {p['nombre']} | Clase ID: {p['clase_id']} | Vida: {p['vida']}")
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

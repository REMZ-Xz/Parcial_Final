import mysql.connector
from mysql.connector import Error

class Conexion:
    @staticmethod
    def get_conexion():
        try:
            conexion = mysql.connector.connect(
                host='localhost',
                user='root',
                password='gcn1b8xn',
                database='parcial_final_db'
            )
            if conexion.is_connected():
                return conexion
        except Error as e:
            print(f"No se conecto: {e}")
            return None

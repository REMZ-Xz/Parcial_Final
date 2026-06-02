class Personaje:
    def __init__(self, id_personaje, nombre, clase_id, vida):
        self.__id = id_personaje
        self.__nombre = nombre
        self.__clase_id = clase_id
        self.__vida = vida  

   
    @property
    def vida(self):
        return self.__vida

    @vida.setter
    def vida(self, nueva_vida):
        if nueva_vida < 0:
            self.__vida = 0 
        else:
            self.__vida = nueva_vida

    @property
    def id(self): return self.__id
    @property
    def nombre(self): return self.__nombre
    @property
    def clase_id(self): return self.__clase_id

    def atacar(self):
        return "realiza un ataque básico"


class Guerrero(Personaje):
    def __init__(self, id_personaje, nombre, vida):
        super().__init__(id_personaje, nombre, 1, vida) 

    
    def atacar(self):
        return "pega con su espada causando daño físico crítico"

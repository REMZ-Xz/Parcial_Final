package model;

public class Arquero extends Personaje {
    public Arquero(int id, String nombre, int vida) {
        super(id, nombre, 3, vida); 
    }

    @Override
    public String habilidadEspecial() {
        return "¡" + getNombre() + " activa Lluvia de Flechas con precision critica!";
    }
}

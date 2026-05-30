package model;

public class Guerrero extends Personaje {
    public Guerrero(int id, String nombre, int vida) {
        super(id, nombre, 1, vida);
    }

    @Override
    public String habilidadEspecial() {
        return getNombre() + " usa Ataque de Espada.";
    }
}

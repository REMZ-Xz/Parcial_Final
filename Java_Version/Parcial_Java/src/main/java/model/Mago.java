package model;

public class Mago extends Personaje {
    public Mago(int id, String nombre, int vida) {
        super(id, nombre, 2, vida);
    }

    @Override
    public String habilidadEspecial() {
        return getNombre() + " lanza Hechizo de Magia.";
    }
}

package model;

public class Item {
    private int id;
    private String nombre;
    private String tipo;
    private int personajeId;

    public Item(int id, String nombre, String tipo, int personajeId) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.personajeId = personajeId;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public int getPersonajeId() { return personajeId; }
}

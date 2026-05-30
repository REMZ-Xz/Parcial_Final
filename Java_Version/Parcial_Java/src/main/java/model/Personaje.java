package model;

public abstract class Personaje {
    private int id;
    private String nombre;
    private int claseId;
    private int vida;

    public Personaje(int id, String nombre, int claseId, int vida) {
        this.id = id;
        setNombre(nombre);
        this.claseId = claseId;
        setVida(vida);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio.");
        }
        this.nombre = nombre;
    }

    public int getClaseId() { return claseId; }
    public void setClaseId(int claseId) { this.claseId = claseId; }

    public int getVida() { return vida; }
    public void setVida(int vida) {
        if (vida < 0) {
            this.vida = 0;
        } else {
            this.vida = vida;
        }
    }
public abstract String habilidadEspecial();

    
}

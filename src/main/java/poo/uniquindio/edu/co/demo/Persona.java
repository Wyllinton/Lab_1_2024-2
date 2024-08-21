package poo.uniquindio.edu.co.demo;

public abstract class Persona {

    private String nombre;
    private int numeroId;

    public Persona(String nombre, int numeroId) {
        this.nombre = nombre;
        this.numeroId = numeroId;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getNumeroId() {
        return numeroId;
    }
    public void setNumeroId(int numeroId) {
        this.numeroId = numeroId;
    }
}

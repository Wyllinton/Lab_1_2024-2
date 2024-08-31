package poo.uniquindio.edu.co.demo.Model;

public abstract class Persona {

    private String nombre;
    private String numeroId;

    public Persona(String nombre, String numeroId) {
        this.nombre = nombre;
        this.numeroId = numeroId;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNumeroId() {
        return numeroId;
    }
    public void setNumeroId(String numeroId) {
        this.numeroId = numeroId;
    }
    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", numeroId=" + numeroId + "]";
    }
}

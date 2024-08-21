package poo.uniquindio.edu.co.demo;

import java.util.List;

public class Deporte {
    private String nombre;
    private String descripcion;
    private List <Entrenador> entrenadores;
    private NivelDificultad nivelDificultad;

    public Deporte(String nombre, String descripcion, List <Entrenador> entrenadores) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.entrenadores = entrenadores;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public List <Entrenador> getEntrenadores() {
        return entrenadores;
    }
    public void setEntrenadores(List <Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }

    public NivelDificultad getNivelDificultad() {
        return nivelDificultad;
    }


}

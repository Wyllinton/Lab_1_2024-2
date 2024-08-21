package poo.uniquindio.edu.co.demo;

import java.util.ArrayList;
import java.util.List;

public class ClubDeportivo {

    private String nombre;
    private List<Persona> listaPersonas;

    public ClubDeportivo(String nombre) {
        this.nombre = nombre;
        this.listaPersonas = new ArrayList<Persona>();

    }
    public String getNombre() {
        return nombre;

    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }

}


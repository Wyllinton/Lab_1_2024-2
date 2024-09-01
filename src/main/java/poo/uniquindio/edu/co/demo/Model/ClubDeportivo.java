package poo.uniquindio.edu.co.demo.Model;

import java.util.ArrayList;
import java.util.List;

public class ClubDeportivo{

    private static ClubDeportivo instancia; // Atributo que almacena la única instancia
    private String nombre;
    public Administrador administrador;
    private List<Persona> listaPersonas;
    private List<Entrenador> entrenadores;

    public ClubDeportivo(String nombre) {
        this.nombre = nombre;
        administrador = new Administrador("Admin","0000","Admin1234@hotmail.com");
        this.listaPersonas = new ArrayList<Persona>();
        this.entrenadores = new ArrayList<Entrenador>();
    }

    // Método estático que retorna la única instancia
    public static ClubDeportivo getInstance(String nombre) {
        if (instancia == null) {
            instancia = new ClubDeportivo(nombre);
        }
        return instancia;
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

    public List<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    

}
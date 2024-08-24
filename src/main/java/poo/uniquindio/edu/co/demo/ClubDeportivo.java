package poo.uniquindio.edu.co.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import util.AssertionUtil;

public class ClubDeportivo {

    private static ClubDeportivo instancia; //Atributo que almacena la única instancia 
    private String nombre;
    private List<Persona> listaPersonas;

    private ClubDeportivo(String nombre) {
        this.nombre = nombre;
        this.listaPersonas = new ArrayList<Persona>();
    }

    //Método estático que retorna la única instancia 
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
    //Método para registrar una persona en la lista 
    public void registrarPersona(Persona persona){
        validarPersonaExiste(persona);
        listaPersonas.add(persona);
    }
    //Método que valida si la persona existe
    private void validarPersonaExiste(Persona persona) {
        boolean existePersona = buscarPersona(persona).isPresent();
        AssertionUtil.ASSERTION.assertion(!existePersona, "La persona ya está registrada");
    }
    //Método que busca la persona en la lista por su nombre y numeroId
    public Optional<Persona> buscarPersona(Persona persona) {
        Predicate<Persona> nombreIgual = j -> j.getNombre().equals(persona.getNombre());
        Predicate<Persona> numeroIdIgual = j -> j.getNumeroId().equals(persona.getNumeroId());
        return listaPersonas.stream().filter(nombreIgual.and(numeroIdIgual)).findAny();
    }

}
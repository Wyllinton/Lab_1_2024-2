package poo.uniquindio.edu.co.demo.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import util.AssertionUtil;

public class ClubDeportivo implements gestionarMiembro {

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

    // Método para registrar una persona en la lista
    public void registrarPersona(Persona persona) {
        validarPersonaExiste(persona);
        listaPersonas.add(persona);
    }

    // Método para eliminar una persona en la lista
    public void eliminarPersona(Persona persona) {
        validarPersonaExiste(persona);
        listaPersonas.remove(persona);
    }

    // Método para registrar un entrenador en la lista
    public void registrarEntrenador(Entrenador entrenador) {
        validarEntrenadorExiste(entrenador);
        entrenadores.add(entrenador);
    }

    // Método para registrar un entrenador en la lista
    public void eliminarEntrenador(Entrenador entrenador) {
        validarEntrenadorExiste(entrenador);
        entrenadores.remove(entrenador);
    }

    // Método que valida si la persona existe
    private void validarPersonaExiste(Persona persona) {
        boolean existePersona = buscarPersona(persona).isPresent();
        AssertionUtil.ASSERTION.assertion(!existePersona, "La persona ya está registrada");
    }

    // Método que busca la persona en la lista por su nombre y numeroId
    public Optional<Persona> buscarPersona(Persona persona) {
        Predicate<Persona> nombreIgual = j -> j.getNombre().equals(persona.getNombre());
        Predicate<Persona> numeroIdIgual = j -> j.getNumeroId().equals(persona.getNumeroId());
        return listaPersonas.stream().filter(nombreIgual.and(numeroIdIgual)).findAny();
    }

    // Método que valida si el entrenador existe
    private void validarEntrenadorExiste(Entrenador entrenador) {
        boolean existePersona = buscarEntrenador(entrenador).isPresent();
        AssertionUtil.ASSERTION.assertion(!existePersona, "El entrenador ya está registrado");
    }

    // Método que busca el entrenador en la lista por su nombre y deporte
    public Optional<Entrenador> buscarEntrenador(Entrenador entrenador) {
        Predicate<Entrenador> nombreIgual = j -> j.getNombre().equals(entrenador.getNombre());
        Predicate<Entrenador> numeroIdIgual = j -> j.getDeporte().equals(entrenador.getDeporte());
        return entrenadores.stream().filter(nombreIgual.and(numeroIdIgual)).findAny();
    }

    @Override
    public void comprobarMiembroDeporte(Miembro miembro, Deporte deporte) {
        switch (miembro.getTipoMiembro()) {
            case JUVENIL:
                switch (deporte.getNivelDificultad()) {
                    case BAJO:
                        deporte.registrarMiembro(miembro);
                    case MEDIO:
                        deporte.registrarMiembro(miembro);
                        // System.out.println("Se ha inscrito exitosamente en un deporte de nivel");
                        break;
                    case ALTO:
                        new RuntimeException("El miembro no se puede registrar debido al nivel de dificultad");
                        // System.out.println("No puede inscribirse en deportes de nivel ALTO.");
                        break;
                }
                break;

            case ADULTO:
                deporte.registrarMiembro(miembro);
                // System.out.println("Se ha inscrito exitosamente en un deporte de nivel ");
                break;

        }
    }

}
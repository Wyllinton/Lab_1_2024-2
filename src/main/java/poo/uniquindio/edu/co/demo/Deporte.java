package poo.uniquindio.edu.co.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import util.AssertionUtil;

public class Deporte {
    private String nombre;
    private String descripcion;
    private List <Entrenador> entrenadores;
    private List<Miembro> miembrosDeporte;
    private NivelDificultad nivelDificultad;

    public Deporte(String nombre, String descripcion, List <Entrenador> entrenadores) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.entrenadores = entrenadores;
        this.miembrosDeporte = new ArrayList<>();
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

    public List <Miembro> getMiembros() {
        return miembrosDeporte;
    }

    public NivelDificultad getNivelDificultad() {
        return nivelDificultad;
    }
    //Método para registrar un miembro en la lista 
    public void registrarMiembro(Miembro miembro){
        validarMiembroExiste(miembro);
        miembrosDeporte.add(miembro);
    }
    //Método para registrar un entrenador en la lista 
    public void eliminarMiembro(Miembro miembro){
        validarMiembroExiste(miembro);
        miembrosDeporte.remove(miembro);
    }
    //Método que valida si el entrenador existe
    private void validarMiembroExiste(Miembro miembro) {
        boolean existeMimebro = buscarMiembro(miembro).isPresent();
        AssertionUtil.ASSERTION.assertion(!existeMimebro, "El miembro ya está registrado");
    }
    //Método que busca el entrenador en la lista por su nombre y deporte
    public Optional<Miembro> buscarMiembro(Miembro miembro) {
        Predicate<Miembro> nombreIgual = j -> j.getNombre().equals(miembro.getNombre());
        Predicate<Miembro> numeroIdIgual = j -> j.getNumeroId().equals(miembro.getNumeroId());
        return miembrosDeporte.stream().filter(nombreIgual.and(numeroIdIgual)).findAny();
    }
    //Método sencillo para agregar un entrenador al deporte
    public void registrarEntrenador(Entrenador entrenador){
        entrenadores.add(entrenador);
    }


}

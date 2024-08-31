package poo.uniquindio.edu.co.demo.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import util.AssertionUtil;

public class Administrador extends Persona implements gestionarMiembro{

        private String correoElectronico;
        private List<SesionEntrenamiento> sesiones;
        private List<Persona> listaPersonas;
        private List<Entrenador> entrenadores;

    public Administrador(String nombre, String numeroId, String correoElectronico) {
        super(nombre, numeroId);
        this.correoElectronico = correoElectronico;
        this.sesiones = new ArrayList<SesionEntrenamiento>();
        this.listaPersonas = new ArrayList<Persona>();
        this.entrenadores = new ArrayList<Entrenador>();
    }
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    public List<SesionEntrenamiento> getSesiones() {
        return sesiones;
    }

    public String gestionarInscripciones(){

        String mensaje = "";
        if (sesiones.isEmpty()) {
            mensaje = "No hay sesiones.";
        }
        else {
            mensaje += "La(s) sesion(es) de entrenamiento son:\n";
            for (SesionEntrenamiento sesion : sesiones) {
                    mensaje += sesion.toString() +" \n";
                }
            }
        
        return mensaje;

    }

    public void programarSesion(LocalDate fecha, float duracion, Entrenador entrenador,
    Miembro miembro, Deporte deporte, EstadoSesion estadoSesion, String identificador) {
        SesionEntrenamiento nuevaSesion = new SesionEntrenamiento(fecha, duracion, entrenador, miembro, deporte, estadoSesion, identificador);
        sesiones.add(nuevaSesion);
        System.out.println("La sesion se ha creado con éxito: " + nuevaSesion.toString());
    }


    public String eliminarSesion(String identificador) {

        for (SesionEntrenamiento sesion : sesiones) {
            if (sesion.getIdentificador().equals(identificador)){
                sesiones.remove(sesion);
                String mensaje ="La sesion "+ sesion.toString()+" ha sido cancelada ";
                return mensaje;
            }
        }
        String mensaje = ("No se encontró sesion con el id especificado");
        return mensaje;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Administrador other = (Administrador) obj;
        if (correoElectronico == null) {
            if (other.correoElectronico != null)
                return false;
        } else if (!correoElectronico.equals(other.correoElectronico))
            return false;
        if (sesiones == null) {
            if (other.sesiones != null)
                return false;
        } else if (!sesiones.equals(other.sesiones))
            return false;
        return true;
    }

    public String mostrarSesionesPorFecha(LocalDate fecha) {
        String mensaje = "";
        if (sesiones.isEmpty()) {
            mensaje = "No hay sesiones.";
        }
        else {
            mensaje += "La(s) sesion(es) de entrenamiento con fecha "+ fecha + " es:\n";
            for (SesionEntrenamiento sesion : sesiones) {
                if (sesion.getFecha().equals(fecha)){
                    mensaje += sesion.toString() +" \n";
                }
            }
        }
        return mensaje;
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
    public void registrarMiembro(Miembro miembro, Deporte deporte) {
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



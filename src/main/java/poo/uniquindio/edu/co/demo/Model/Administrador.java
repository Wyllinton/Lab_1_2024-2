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

    public void gestionarInscripciones(SesionEntrenamiento sesion){

    }

    public boolean verificarSesionExistente(String fecha) throws Exception {
        LocalDate fechaLocalDate = LocalDate.parse(fecha, DateTimeFormatter.ISO_DATE);
        boolean sesionExiste = sesiones.stream().anyMatch(sesion -> sesion.getFecha().equals(fechaLocalDate));

        if (sesionExiste) {
            throw new Exception("La sesión con fecha: " + fecha + " ya existe");
        } else {
            return false;
        }
    }

    public void programarSesion(SesionEntrenamiento sesion) throws Exception {
        getSesiones().add(sesion);
    }

    public boolean eliminarSesion(String fecha) throws Exception {
        SesionEntrenamiento sesion = null;
        boolean sesionEliminada = false;
        sesion = obtenerSesion(fecha);
        if (sesion == null) {
            throw new Exception("La sesión a eliminar no existe");
        } else {
            getSesiones().remove(sesion);
            sesionEliminada = true;
        }
        return sesionEliminada;
    }

    private SesionEntrenamiento obtenerSesion(String fecha) {
        LocalDate fechaLocalDate = LocalDate.parse(fecha, DateTimeFormatter.ISO_DATE);
        return sesiones.stream()
                .filter(cita -> cita.getFecha().equals(fechaLocalDate))
                .findFirst()
                .orElse(null);
    }

    public boolean actualizarSesion(String fecha, SesionEntrenamiento sesion) throws Exception {
        SesionEntrenamiento sesionActual = obtenerSesion(fecha);
        if(sesionActual == null){
            throw new Exception("La cita a actualizar no existe");
        }else{
            sesionActual.setFecha(sesion.getFecha());
            sesionActual.setDuracion(sesion.getDuracion());
            sesionActual.setEntrenador(sesion.getEntrenador());
            return true;
        }

    }

    public String listarCitas(LocalDate fecha) {
        String mensaje = "";
        if (sesiones.isEmpty()) {
            mensaje = "No hay sesiones.";
        }
        else {
            mensaje += "La sesión de entrenamiento con fecha "+ fecha + " es:\n";
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



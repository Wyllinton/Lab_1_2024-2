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
        private List<Miembro> listaMiembros;
        private List<Entrenador> entrenadores;

    public Administrador(String nombre, String numeroId, String correoElectronico) {
        super(nombre, numeroId);
        this.correoElectronico = correoElectronico;
        this.sesiones = new ArrayList<SesionEntrenamiento>();
        this.listaMiembros = new ArrayList<Miembro>();
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

    public String programarSesion(LocalDate fecha, float duracion, Entrenador entrenador,
    Miembro miembro, Deporte deporte, String estadoSesion, String identificador) {
        String mensaje = "";
        SesionEntrenamiento nuevaSesion = new SesionEntrenamiento(fecha, duracion, entrenador, miembro, deporte, estadoSesion, identificador);
        sesiones.add(nuevaSesion);
        mensaje = "La sesion se ha creado con éxito: " + nuevaSesion.toString();
        return mensaje;
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

       public List<Miembro> getListaMiembros() {
        return listaMiembros;

    }

    public List<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    // Método para registrar un miembro en la lista
    public void registrarMiembro(Miembro miembro) {
        validarMiembroExiste(miembro);
        listaMiembros.add(miembro);
    }

    // Método para eliminar un miembro en la lista
    public void eliminarMiembro(Miembro miembro) {
        validarMiembroExiste(miembro);
        listaMiembros.remove(miembro);
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

    // Método que valida si el miembro existe
    private void validarMiembroExiste(Miembro miembro) {
        boolean existeMiembro = buscarMiembro(miembro).isPresent();
        AssertionUtil.ASSERTION.assertion(!existeMiembro, "El miembro ya está registrado");
    }

    // Método que busca el miembro en la lista por su nombre y numeroId
    public Optional<Miembro> buscarMiembro(Miembro miembro) {
        Predicate<Miembro> nombreIgual = j -> j.getNombre().equals(miembro.getNombre());
        Predicate<Miembro> numeroIdIgual = j -> j.getNumeroId().equals(miembro.getNumeroId());
        return listaMiembros.stream().filter(nombreIgual.and(numeroIdIgual)).findAny();
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


    public Entrenador buscarEntrenadorPorNombre(String nombre) {
        return entrenadores.stream()
                .filter(entrenador -> entrenador.getNombre().equals(nombre))
                .findAny()
                .orElse(null); // Devuelve null si no se encuentra el entrenador
    }    

    public Miembro buscarMiembroPorId(String id) {
        return listaMiembros.stream()
                .filter(miembro -> miembro.getNumeroId().equals(id))
                .findAny()
                .orElse(null); // Devuelve null si no se encuentra el miembro
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



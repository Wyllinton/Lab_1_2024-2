package poo.uniquindio.edu.co.demo.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Administrador extends Persona {

        private String correoElectronico;
        private List<SesionEntrenamiento> sesiones;

    public Administrador(String nombre, String numeroId, String correoElectronico) {
        super(nombre, numeroId);
        this.correoElectronico = correoElectronico;
        this.sesiones = new ArrayList<SesionEntrenamiento>();
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

    public boolean verificarCitaExistente(String fecha) throws Exception {
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

    public boolean actualizarCita(String fecha, SesionEntrenamiento sesion) throws Exception {
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

    

}



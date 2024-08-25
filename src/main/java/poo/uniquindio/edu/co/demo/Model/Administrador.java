package poo.uniquindio.edu.co.demo;

import java.util.ArrayList;
import java.util.List;

public class Administrador extends Persona{

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

}



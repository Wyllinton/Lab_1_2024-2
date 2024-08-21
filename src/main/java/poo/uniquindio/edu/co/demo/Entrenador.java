package poo.uniquindio.edu.co.demo;

import java.util.List;

public class Entrenador {
    private String nombre;
    private String descripcion;
    private Deporte deporte;
    private List<SesionEntrenamiento> sesionEntrenamientos;

    public Entrenador(String nombre, String descripcion, Deporte deporte, List<SesionEntrenamiento> sesionEntrenamientos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.deporte = deporte;
        this.sesionEntrenamientos = sesionEntrenamientos;
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


    public Deporte getDeporte() {
        return deporte;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }

    public List<SesionEntrenamiento> getSesionEntrenamientos() {
        return sesionEntrenamientos;
    }

}

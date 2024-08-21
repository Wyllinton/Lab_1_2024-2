package poo.uniquindio.edu.co.demo;

import java.time.LocalDate;

public class SesionEntrenamiento {

    private LocalDate fecha;
    private float duracion;
    private EstadoSesion estadoSesion;
    private Entrenador entrenador;

    public SesionEntrenamiento(LocalDate fecha, float duracion, Entrenador entrenador
                               , EstadoSesion estadoSesion) {
        this.fecha = fecha;
        this.duracion = duracion;
        this.entrenador = entrenador;
        this.estadoSesion = estadoSesion;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public float getDuracion() {
        return duracion;
    }
    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }
    public void setEstadoSesion(EstadoSesion estadoSesion){
        this.estadoSesion = estadoSesion;
    }

    public EstadoSesion getEstadoSesion() {
        return estadoSesion;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }
}

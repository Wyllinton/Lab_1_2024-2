package poo.uniquindio.edu.co.demo.Model;

import java.time.LocalDate;

public class SesionEntrenamiento {

    private LocalDate fecha;
    private float duracion;
    private String estadoSesion;
    private Entrenador entrenador;
    private Administrador administrador;
    private Deporte deporte;
    private Miembro miembro;
    private String identificador;

    public SesionEntrenamiento(LocalDate fecha, float duracion, Entrenador entrenador,
                                Miembro miembro, Deporte deporte, String estadoSesion, String identificador) {
        this.fecha = fecha;
        this.duracion = duracion;
        this.entrenador = entrenador;
        this.estadoSesion = estadoSesion;
        this.deporte = deporte;
        this.miembro = miembro;
        this.identificador = identificador;
        administrador = new Administrador("Admin","1234","Admin1234@hotmail.com");
    }
    public Administrador getAdministrador() {
        return administrador;
    }
    public String getIdentificador() {
        return identificador;
    }
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    public Miembro getMiembro() {
        return miembro;
    }
    public void setMiembro(Miembro miembro) {
        this.miembro = miembro;
    }
    public Deporte getDeporte() {
        return deporte;
    }
    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
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
    public void setEstadoSesion(String estadoSesion){
        this.estadoSesion = estadoSesion;
    }

    public String getEstadoSesion() {
        return estadoSesion;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }
    @Override
    public String toString() {
        return "SesionEntrenamiento [fecha=" + fecha + ", duracion=" + duracion + ", estadoSesion=" + estadoSesion
                + ", entrenador=" + entrenador + ", administrador=" + administrador + ", deporte=" + deporte + "]";
    }
}

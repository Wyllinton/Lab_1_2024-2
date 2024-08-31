package poo.uniquindio.edu.co.demo.Model;

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
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
        result = prime * result + ((deporte == null) ? 0 : deporte.hashCode());
        result = prime * result + ((sesionEntrenamientos == null) ? 0 : sesionEntrenamientos.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Entrenador other = (Entrenador) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (descripcion == null) {
            if (other.descripcion != null)
                return false;
        } else if (!descripcion.equals(other.descripcion))
            return false;
        if (deporte == null) {
            if (other.deporte != null)
                return false;
        } else if (!deporte.equals(other.deporte))
            return false;
        if (sesionEntrenamientos == null) {
            if (other.sesionEntrenamientos != null)
                return false;
        } else if (!sesionEntrenamientos.equals(other.sesionEntrenamientos))
            return false;
        return true;
    }

}

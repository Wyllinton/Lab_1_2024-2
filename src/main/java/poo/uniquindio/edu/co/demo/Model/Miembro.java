package poo.uniquindio.edu.co.demo.Model;

public class Miembro extends Persona {

    private TipoMiembro tipoMiembro;
private String correoElectronico;

    public Miembro(String nombre, String numeroId, TipoMiembro tipoMiembro, String correoElectronico) {
        super(nombre, numeroId);
        this.tipoMiembro = tipoMiembro;
        this.correoElectronico = correoElectronico;
    }

    public TipoMiembro getTipoMiembro() {
        return tipoMiembro;
    }

    public void setTipoMiembro(TipoMiembro tipoMiembro) {
        this.tipoMiembro = tipoMiembro;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tipoMiembro == null) ? 0 : tipoMiembro.hashCode());
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
        Miembro other = (Miembro) obj;
        if (tipoMiembro != other.tipoMiembro)
            return false;
        return true;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Override
    public String toString() {
        return "Miembro [tipoMiembro=" + tipoMiembro + ", correoElectronico=" + correoElectronico + "]";
    }
    
}

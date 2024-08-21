package poo.uniquindio.edu.co.demo;

public class Miembro extends Persona {

    private TipoMiembro tipoMiembro;

    public Miembro(String nombre, int numeroId) {
        super(nombre, numeroId);
        tipoMiembro = null;
    }

    public TipoMiembro getTipoMiembro() {
        return tipoMiembro;
    }

    public void setTipoMiembro(TipoMiembro tipoMiembro) {
        this.tipoMiembro = tipoMiembro;
    }
}

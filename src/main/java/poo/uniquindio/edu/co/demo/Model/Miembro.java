package poo.uniquindio.edu.co.demo.Model;

public class Miembro extends Persona {

    private TipoMiembro tipoMiembro;

    public Miembro(String nombre, String numeroId, poo.uniquindio.edu.co.demo.Controller.MiembroController.TipoMiembro tipoMiembro2) {
        super(nombre, numeroId);
        tipoMiembro2 = null;
    }

    public TipoMiembro getTipoMiembro() {
        return tipoMiembro;
    }

    public void setTipoMiembro(TipoMiembro tipoMiembro) {
        this.tipoMiembro = tipoMiembro;
    }
    
}

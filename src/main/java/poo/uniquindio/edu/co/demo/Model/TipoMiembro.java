package poo.uniquindio.edu.co.demo.Model;

public enum TipoMiembro {
    JUVENIL,
    ADULTO;

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}

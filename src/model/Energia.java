package model;

public class Energia extends Carta {

    private Tipo tipo;

    public Energia(String id, String nombre, Rareza rareza, Tipo tipo) {
        super(id, nombre, rareza);
        this.tipo = tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Energia [tipo=" + tipo + ", getId()=" + getId() + ", getNombre()=" + getNombre() + "]";
    }

    

}

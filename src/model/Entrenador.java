package model;

public class Entrenador extends Carta {

    private String descripcion;
    private String restriccion;

    public Entrenador(String id, String nombre, Rareza rareza, String descripcion, String restriccion) {
        super(id, nombre, rareza);
        this.descripcion = descripcion;
        this.restriccion = restriccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRestriccion() {
        return restriccion;
    }

    public void setRestriccion(String restriccion) {
        this.restriccion = restriccion;
    }

    @Override
    public String toString() {
        return "Entrenador [descripcion=" + descripcion + ", getId()=" + getId() + ", getNombre()=" + getNombre() + "]";
    }

    

}

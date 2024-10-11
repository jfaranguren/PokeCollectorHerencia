package model;

public class Ataque {

    private String nombre;
    private int dano;
    private Tipo tipo;

    public Ataque(String nombre, int dano, Tipo tipo) {

        this.nombre = nombre;
        this.dano = dano;
        this.tipo = tipo;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String toString() {

        return nombre + "-" + dano;

    }

}
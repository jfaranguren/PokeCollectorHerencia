package model;

import java.util.Calendar;

public abstract class Carta {

    // Atributos
    private String id; // Esto se referencia al usar this
    private String nombre;
    private Rareza rareza;
    private Calendar fechaPublicacion;

    // Comportamientos - Metodos
    public Carta(String id, String nombre, Rareza rareza) {

        this.id = id;
        this.nombre = nombre;
        this.rareza = rareza;
        fechaPublicacion = Calendar.getInstance();

    }

    // Modificador
    public void setId(String id) {
        this.id = id;
    }

    // Analizador
    public String getId() {
        return id;
    }

    // Modificador
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Analizador
    public String getNombre() {
        return nombre;
    }

    // Modificador
    public void setRareza(Rareza rareza) {
        this.rareza = rareza;
    }

    // Analizador
    public Rareza getRareza() {
        return rareza;
    }

    @Override
    public String toString() {

        return id + "-" + nombre;

    }

    public Calendar getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Calendar fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

}
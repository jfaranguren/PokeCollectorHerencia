package model;

public class Pokemon extends Carta {

    private int puntosVida;
    private Tipo tipo;
    private Ataque[] memoriaAtaques;

    public Pokemon(String id, String nombre, Rareza rareza, int puntosVida, Tipo tipo) {
        super(id, nombre, rareza);
        this.puntosVida = puntosVida;
        this.tipo = tipo;
        memoriaAtaques = new Ataque[2];

    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String mostrarInfoCartaCompleta() {

        String informacionCarta = toString();

        for (int i = 0; i < memoriaAtaques.length; i++) {

            if (memoriaAtaques[i] != null) {

                informacionCarta += "\n" + memoriaAtaques[i].toString();
            }
        }

        return informacionCarta;

    }

    public Ataque[] getMemoriaAtaques() {

        return memoriaAtaques;

    }

    public boolean addAtaque(Ataque nuevoAtaque) {

        for (int i = 0; i < memoriaAtaques.length; i++) {
            if (memoriaAtaques[i] == null) {
                memoriaAtaques[i] = nuevoAtaque;
                return true;
            }
        }

        return false;

    }

    @Override
    public String toString() {

        return getId() + "-" + getNombre() + "-" + tipo + "-" + puntosVida;

    }

}

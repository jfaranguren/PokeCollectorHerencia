package model;

public class Controller {

    public Carta[] memoria;

    public Controller() {
        memoria = new Carta[50];
        precargaDeInformacion();
    }

    public void precargaDeInformacion(){

        Pokemon pichu = new Pokemon("001", "Pichu", Rareza.BASICO, 20, Tipo.ELECTRICO);
        guardarPokemonEnMemoria(pichu);

        Pokemon charmander = new Pokemon("003", "Charmander", Rareza.RARO, 40, Tipo.FUEGO);
        guardarPokemonEnMemoria(charmander);

        Energia normal = new Energia("004", "Energia Basica Normal", Rareza.BASICO, Tipo.NORMAL);
        memoria[2] = normal;

        Entrenador oak = new Entrenador("123", "Profesor Oak", Rareza.MITICO, "Busca un Pokemon Mitico de tu baraja", "Solo puede ser usado una vez por turno");
        memoria[3] = oak;

    }

    public boolean guardarPokemonEnMemoria(Pokemon p){

        for (int i = 0; i < memoria.length; i++) {
            if (memoria[i] == null) {
                memoria[i] = p;
                return true;
            }
        }

        return false;

    }

    public boolean guardarPokemonEnMemoria(String id, String nombre, int rareza, int puntosVida, int tipo) {

        Rareza nuevaRareza = Rareza.BASICO;

        switch (rareza) {
            case 1:
                nuevaRareza = Rareza.BASICO;
                break;
            case 2:
                nuevaRareza = Rareza.RARO;
                break;
            case 3:
                nuevaRareza = Rareza.MITICO;
                break;
            case 4:
                nuevaRareza = Rareza.LEGENDARIO;
                break;
            default:
                nuevaRareza = Rareza.BASICO;
                break;
        }

        Tipo nuevoTipo = Tipo.AGUA;

        // AGUA, FUEGO, PLANTA, ELECTRICO, NORMAL
        switch (tipo) {
            case 1:
                nuevoTipo = Tipo.AGUA;
                break;
            case 2:
                nuevoTipo = Tipo.FUEGO;
                break;
            case 3:
                nuevoTipo = Tipo.PLANTA;
                break;
            case 4:
                nuevoTipo = Tipo.ELECTRICO;
                break;
            case 5:
                nuevoTipo = Tipo.NORMAL;
                break;
            default:
                nuevoTipo = Tipo.NORMAL;
                break;
        }

        Pokemon nuevoPokemon = new Pokemon(id, nombre, nuevaRareza, puntosVida, nuevoTipo);

        for (int i = 0; i < memoria.length; i++) {
            if (memoria[i] == null) {
                memoria[i] = nuevoPokemon;
                return true;
            }
        }

        return false;

    }

    public String construirListaDeCartas() {

        String lista = "";

        boolean validar = false;

        for (int j = 0; j < memoria.length; j++) {
            if (memoria[j] != null) {
                lista += "\n" + memoria[j].getId() + " - " + memoria[j].getNombre();
                validar = true;
            }
        }
        if (!validar) {
            lista = "No hay cartas registradas";
        }
        return lista;

    }

    public String mostrarCarta(String idAConsultar) {

        for (int k = 0; k < memoria.length; k++) {

            if (memoria[k] != null) {
                if (memoria[k].getId().equalsIgnoreCase(idAConsultar)) {
                    return memoria[k].toString();
                }
            }
        }

        return null;

    }

    public String mostrarCartaCompleta(String idAConsultar) {

        for (int k = 0; k < memoria.length; k++) {

            if (memoria[k] != null) {
                if (memoria[k].getId().equalsIgnoreCase(idAConsultar)) {
                    return memoria[k].toString();
                }
            }
        }

        return null;

    }

    public Carta buscarCarta(String idAConsultar) {

        for (int k = 0; k < memoria.length; k++) {

            if (memoria[k] != null) {
                if (memoria[k].getId().equalsIgnoreCase(idAConsultar)) {
                    return memoria[k];
                }
            }
        }

        return null;

    }

    
    public boolean addAtaqueAPokemon(String idCarta, String nombreAtaque, int danoAtaque, int tipoAtaque) {

        Tipo nuevoTipo = Tipo.AGUA;

        // AGUA, FUEGO, PLANTA, ELECTRICO, NORMAL
        switch (tipoAtaque) {
            case 1:
                nuevoTipo = Tipo.AGUA;
                break;
            case 2:
                nuevoTipo = Tipo.FUEGO;
                break;
            case 3:
                nuevoTipo = Tipo.PLANTA;
                break;
            case 4:
                nuevoTipo = Tipo.ELECTRICO;
                break;
            case 5:
                nuevoTipo = Tipo.NORMAL;
                break;
            default:
                nuevoTipo = Tipo.NORMAL;
                break;
        }

        Ataque nuevoAtaque = new Ataque(nombreAtaque, danoAtaque, nuevoTipo);

        Carta cartaBuscada = buscarCarta(idCarta);

        if(cartaBuscada instanceof Pokemon){
            
            return ((Pokemon)cartaBuscada).addAtaque(nuevoAtaque);

        }

        return false;

    }

    public String modificarEnergia(String idAConsultar, int tipo) {
      
        Tipo nuevoTipo = Tipo.AGUA;

        // AGUA, FUEGO, PLANTA, ELECTRICO, NORMAL
        switch (tipo) {
            case 1:
                nuevoTipo = Tipo.AGUA;
                break;
            case 2:
                nuevoTipo = Tipo.FUEGO;
                break;
            case 3:
                nuevoTipo = Tipo.PLANTA;
                break;
            case 4:
                nuevoTipo = Tipo.ELECTRICO;
                break;
            case 5:
                nuevoTipo = Tipo.NORMAL;
                break;
            default:
                nuevoTipo = Tipo.NORMAL;
                break;
        }

        Carta cartaBuscada = buscarCarta(idAConsultar);

        if(cartaBuscada instanceof Energia){
            
            ((Energia)cartaBuscada).setTipo(nuevoTipo);;
            return cartaBuscada.toString();
        }

        return null;
       
    }

}
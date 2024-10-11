package ui;

import java.util.Scanner;
import model.Controller;

public class PokeCollector {

    public Scanner reader;
    private Controller controladora;

    public static void main(String[] args) {

        PokeCollector executable = new PokeCollector();
        executable.menu();
    }

    public PokeCollector() {

        reader = new Scanner(System.in);
        controladora = new Controller();

    }

    /**
     * Descripcion: Este metodo se encarga de desplegar el menu al usuario y mostrar
     * los mensajes de resultado para cada funcionalidad
     * pre: El Scanner reader debe estar inicializado
     */
    public void menu() {

        System.out.println("Bienvenido a PokeCollector!");

        boolean salir = false;

        do {

            System.out.println("\nMenu Principal:");
            System.out.println("1. Registrar una Carta (Create)");
            System.out.println("2. Consultar una Carta (Read)");
            System.out.println("3. Modificar una Energia (Update)");
            System.out.println("4. Eliminar una Carta (Delete)");
            System.out.println("5. Añadir Ataque a Carta");
            System.out.println("0. Salir");
            System.out.println("\nDigite la opcion a ejecutar");
            int opcion = reader.nextInt();

            switch (opcion) {
                case 1:
                    solicitarDatosCarta();
                    break;
                case 2:
                    consultarCarta();
                    break;
                case 3:
                    modificarEnergia();
                    break;
                case 4:
                    eliminarCarta();
                    break;
                case 5:
                    solictarDatosAtaque();
                    break;
                case 0:
                    System.out.println("\nGracias por usar nuestros servicios!");
                    salir = true;
                    reader.close();
                    break;

                default:
                    System.out.println("\nOpción inválida!");
                    break;
            }

        } while (!salir);

    }

    /**
     * Descripcion: Este metodo se encarga de preguntar al usuario los datos
     * necesarios para registrar una carta en el sistema
     * pre: El Scanner reader debe estar inicializado
     */
    public void solicitarDatosCarta() {

        reader.nextLine(); // Limpieza de buffer
        System.out.println("Proporcione el ID de la carta");
        String id = reader.nextLine();

        System.out.println("Proporcione el nombre del Pokemon en la carta");
        String nombre = reader.nextLine();

        System.out.println("Proporcione los puntos de vida del Pokemon en la carta");
        int puntosVida = reader.nextInt();
        reader.nextLine();// Limpieza de buffer

        System.out.println(
                "Proporcione el tipo del Pokemon en la carta (1. Agua, 2. Fuego, 3. Planta, 4. Electrico, 5. Normal)");
        int tipo = reader.nextInt();

        System.out.println("Proporcione la rareza de la carta (1. Basico, 2. Raro, 3. Mitico, 4. Legendario)");
        int rareza = reader.nextInt();

        boolean resultado = controladora.guardarPokemonEnMemoria(id, nombre, puntosVida, tipo, rareza);

        if (resultado) {
            System.out.println("Carta registrada exitosamente");
        } else {
            System.out.println("Error memoria llena!");
        }

    }

    /**
     * Descripcion: Este metodo se encarga de desplegar al usuario los datos de una
     * carta registrada en el sistema
     * pre: El Scanner reader debe estar inicializado
     */
    public void consultarCarta() {

        reader.nextLine();
        System.out.println(controladora.construirListaDeCartas());

        System.out.println("Ingrese el Id de la Carta a consultar");
        String idAConsultar = reader.nextLine();

        String consulta = controladora.mostrarCarta(idAConsultar);

        if (consulta == null) {

            System.out.println("No existe una Carta registrada en el sistema con ese Id");

        } else {

            System.out.println("La carta es: " + consulta);

        }

    }

    /**
     * Descripcion: Este metodo se encarga de preguntar al usuario los datos
     * necesarios para modificar una carta en el sistema
     * pre: El Scanner reader debe estar inicializado
     */
    public void modificarEnergia() {

        reader.nextLine();

        System.out.println(controladora.construirListaDeCartas());

        System.out.println("Ingrese el Id de la Carta a consultar");
        String idAConsultar = reader.nextLine();

        String consulta = controladora.mostrarCartaCompleta(idAConsultar);

        System.out.println("La informacion de la carta es: " + consulta);

        System.out.println("Proporcione el nuevo tipo (1. Agua, 2. Fuego, 3. Planta, 4. Electrico, 5. Normal)");
        int nuevoTipo = reader.nextInt();

        if (controladora.modificarEnergia(idAConsultar, nuevoTipo) != null) {

            System.out.println("Energia modificada exitosamente");
            System.out.println("La nueva informacion es: " + controladora.modificarEnergia(idAConsultar, nuevoTipo));

        } else {

            System.out.println("Error, no se pudo modificar la Energia");

        }

    }

    /**
     * Descripcion: Este metodo se encarga de preguntar al usuario los datos
     * necesarios para eliminar una carta en el sistema
     * pre: El Scanner reader debe estar inicializado
     */
    public void eliminarCarta() {

        // memoria[0]=null;

    }

    public void solictarDatosAtaque() {

        reader.nextLine();
        System.out.println(controladora.construirListaDeCartas());

        System.out.println("Ingrese el Id de la Carta a consultar");
        String idAConsultar = reader.nextLine();

        if (controladora.mostrarCarta(idAConsultar) != null) {

            System.out.println("Ingrese el Nombre del Ataque");
            String nombreAtaque = reader.nextLine();

            System.out.println("Ingrese el Dano del Ataque");
            int danoAtaque = reader.nextInt();

            reader.nextLine();

            System.out.println("Ingrese el Tipo del Ataque (1. Agua, 2. Fuego, 3. Planta, 4. Electrico, 5. Normal)");
            int tipoAtaque = reader.nextInt();

            if (controladora.addAtaqueAPokemon(idAConsultar, nombreAtaque, danoAtaque, tipoAtaque)) {

                System.out.println("Ataque añadido a la Carta exitosamente");

                System.out.println(controladora.mostrarCartaCompleta(idAConsultar));

            } else {

                System.out.println("Error, no se pudo añadir el Ataque a la Carta");

            }

        } else {

            System.out.println("Id invalido, no existe una Carta con ese id");

        }

    }

}

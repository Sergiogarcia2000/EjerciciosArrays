package org.ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author SERGIO GARCIA MAYO
 */
public class Ejercicio4 {

    private static String[][] jugadoresLibres = new String[25][2];
    private static String[][] jugadoresPertenecientes = new String[11][2];
    private static int dinero = 10000000;
    private static int cantidadJugadores = 0;
    private static int cantidadJugadoresLibres = 24;

    /**
     * Imprimir todos los jugadores libres
     */
    private static void jugadoresLibres(){

        System.out.println("JUGADORES LIBRES: ");
        for (int i = 0; i < cantidadJugadoresLibres; i++) {
            System.out.println("Jugador: " + jugadoresLibres[i][0] + "\n Precio: " + jugadoresLibres[i][1]);
            System.out.println("------------------------");
        }

        System.out.println("Se han encontrado " + (cantidadJugadoresLibres + 1) + " resultados.");

    }

    /**
     * Elige unos nombres aleatoriamente de un fichero.txt y los almacena
     * @throws IOException Excepción necesario por si no existe el archivo o surje cualquier otro problema
     */
    private static void generarNombres() throws IOException {
        Random rand = new Random();
        String cadena;
        String[] nombres = new String[200];
        FileReader f = new FileReader("./src/org/utils/nombres.txt");
        BufferedReader b = new BufferedReader(f);

        int[] jugadoresUsados = new int[25];

        int contador = 0;

        // Guardar 200 nombres en array
        while((cadena = b.readLine())!=null) {
            int aleatorio = rand.nextInt(100);

            if(aleatorio < 50){
                nombres[contador] = cadena;
                contador++;
            }

            if (contador >= 199){
                break;
            }
        }

        int i = 0;

        // Bucle que elige un jugador aleatorio y genera un precio aleatorio
        while(i < jugadoresLibres.length){

            int jugador = rand.nextInt(198);
            int dinero = rand.nextInt(200000) + 200000;

            boolean disponible = true;

            // Comprueba si el jugador aleatorio ya esta usado
            for (int jugadoresUsado : jugadoresUsados) {
                if (jugador == jugadoresUsado) {
                    disponible = false;
                    break;
                }
            }

            if (disponible){
                jugadoresLibres[i][0] = nombres[jugador];
                jugadoresLibres[i][1] = Integer.toString(dinero);
                jugadoresUsados[i] = jugador;
                i++;
            }


        }
        b.close();
    }

    /**
     * Algoritmo para comprar un jugador
     * Comprueba si el jugador existe y esta en el array de jugadores libres
     * en el caso de encontrarlo y que el jugador esté seguro se le resta el dinero al jugador
     * se cambia el jugador al array de jugadoresPertenecientes y se actualiza el array de jugadoresLibres
     */
    private static void comprarJugador(){

        int posicion = 0;
        boolean encontrado = false;
        Scanner sc = new Scanner(System.in);


        System.out.print("Jugador: ");
        String opcion = sc.nextLine().toLowerCase();

        for (int i = 0; i < jugadoresLibres.length; i++){

            if (opcion.equals(jugadoresLibres[i][0].toLowerCase())){

                System.out.println("Jugador encontrado!");
                encontrado = true;
                posicion = i;
            }
        }

        if(encontrado){

            if (dinero >= Integer.parseInt(jugadoresLibres[posicion][1])){


                System.out.println("¿Estas seguro de que quieres comprar este jugador por " + jugadoresLibres[posicion][1] + " €? (si/no)");
                opcion = sc.nextLine().toLowerCase();

                if (opcion.equals("si")){
                    dinero -= Integer.parseInt(jugadoresLibres[posicion][1]);

                    jugadoresPertenecientes[cantidadJugadores][0] = jugadoresLibres[posicion][0];
                    jugadoresPertenecientes[cantidadJugadores][1] = jugadoresLibres[posicion][1];

                    for (int j = posicion; j < jugadoresLibres.length - 1; j++){

                        jugadoresLibres[j][0] = jugadoresLibres[j + 1][0];
                        jugadoresLibres[j][1] = jugadoresLibres[j + 1][1];

                    }
                    cantidadJugadoresLibres--;
                    cantidadJugadores++;

                    System.out.println("Jugador/a comprado/a con éxito!");
                    System.out.println("--------------------------");
                }else if (opcion.equals("no")){
                    System.out.println("--------------------------");
                }
            }else{

                System.out.println("No cuentas con el dinero suficiente para comprar al jugador.");
            }
        }else{
            System.out.println("Jugador no encontrado. Asegúrate de que lo has escrito bien o está en la lista.");
        }
    }

    /**
     * Algoritmo para vender jugador, similar al de compra
     * Comprueba si existe el jugador y esta en el array de jugadores pertenecientes
     * en el caso de encontrarlo y que el jugador este seguro se le suma el dinero al jugador
     * se cambia el jugador al array de jugadoresLibres y se actualiza el array de jugadoresPertenecientes
     */
    private static void venderJugador(){

        int posicion = 0;
        boolean encontrado = false;
        Scanner sc = new Scanner(System.in);

        if (cantidadJugadores > 0){

            System.out.print("Jugador: ");
            String opcion = sc.nextLine().toLowerCase();

            for (int i = 0; i < cantidadJugadores; i++){

                if (opcion.equals(jugadoresPertenecientes[i][0].toLowerCase())){

                    System.out.println("Jugador encontrado!");
                    encontrado = true;
                    posicion = i;
                }
            }

            if(encontrado){

                System.out.println("¿Estas seguro de que quieres vender este jugador por " + jugadoresPertenecientes[posicion][1] + " €? (si/no)");
                opcion = sc.nextLine().toLowerCase();

                System.out.println(opcion);

                if (opcion.equals("si")){
                    dinero += Integer.parseInt(jugadoresPertenecientes[posicion][1]);

                    jugadoresLibres[cantidadJugadoresLibres][0] = jugadoresPertenecientes[posicion][0];
                    jugadoresLibres[cantidadJugadoresLibres][1] = jugadoresPertenecientes[posicion][1];

                    for (int j = posicion; j < jugadoresPertenecientes.length - 1; j++){

                        jugadoresPertenecientes[j][0] = jugadoresPertenecientes[j + 1][0];
                        jugadoresPertenecientes[j][1] = jugadoresPertenecientes[j + 1][1];

                    }
                    cantidadJugadores--;
                    cantidadJugadoresLibres++;

                    System.out.println("Jugador/a vendido/a con éxito!");
                    System.out.println("--------------------------");
                }else if (opcion.equals("no")){
                    System.out.println("--------------------------");
                }
            }else{
                System.out.println("No cuentas con el dinero suficiente para comprar al jugador.");
            }
        }else {
            System.out.println("No tienes jugadores!");
        }


    }

    /**
     * Imprime todos los jugadores pertenecientes al jugador con sus respectivos precios
     */
    private static void desplegarJugadores(){

        System.out.println("TUS JUGADORES: ");

        for (int i = 0; i < cantidadJugadores; i++) {
            System.out.println("Jugador: " + jugadoresPertenecientes[i][0] + "\n Precio: " + jugadoresPertenecientes[i][1]);
            System.out.println("------------------------");
        }

        System.out.println("Se han encontrado " + cantidadJugadores + " jugadores.");

    }

    public static void main(String[] args) throws IOException {

        generarNombres();

        Scanner sc = new Scanner(System.in);

        label:
        while (true){

            try{
                System.out.println("==============================");
                System.out.println("1. Desplegar jugadores disponibles y precios.");
                System.out.println("2. Desplegar jugadores comprados y precios pagados.");
                System.out.println("3. Desplegar dinero disponible.");
                System.out.println("4. Comprar jugador.");
                System.out.println("5. Vender un jugador.");
                System.out.println("6. Salir");
                System.out.print("Ingresa una opción: ");

                int opcion = sc.nextInt();

                switch (opcion){

                    case 1:
                        jugadoresLibres();
                        break;
                    case 2:
                        if (cantidadJugadores > 0){
                            desplegarJugadores();
                        }else{
                            System.out.println("No tienes jugadores en la plantilla.");
                        }
                        break;
                    case 3:
                        System.out.println("Dinero disponible: " + dinero);
                        break;
                    case 4:
                        comprarJugador();
                        break;
                    case 5:
                        venderJugador();
                        break;
                    case 6:
                        break label;
                    default:
                        System.out.println("Opción desconocida.");
                }

            }catch(InputMismatchException e){
                System.out.println("Entrada inválida");
            }
        }

        sc.close();
    }

}

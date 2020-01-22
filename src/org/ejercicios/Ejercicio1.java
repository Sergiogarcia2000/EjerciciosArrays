package org.ejercicios;

import java.util.Scanner;

public class Ejercicio1 {

    /**
     * FILLARRAY
     * Rellena el array pasado con cadenas que se le piden al usuario
     * @param array array que deseas ordenar
     */
    private static void fillArray(String[] array){

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < array.length; i++) {
            System.out.print((i + 1) + ": ");
            array[i] = sc.nextLine();
        }

    }

    /**
     * ORDER
     * Ordena un array alfabéticamente
     * utilizando el metodo CompareTo
     * @param array Matriz que quieres ordenar
     */
    private static void order(String[] array){

        System.out.println("Ordenando...");
        System.out.println("------------");

        String[] arrayOrdenado = new String[array.length];

        // Bucle que se ejecuta hasta que se llena arrayOrdenado
        for (int palabrasOrdenadas = 0; palabrasOrdenadas < array.length; palabrasOrdenadas++){

            int posPalabra = 0;

            // Recorro el array
            for(int i = 0; i < array.length; i++){

                // Tomando la primera palabra compruebo hasta encontrar otra mayor lexograficamente
                if (posPalabra != i){
                    // En el caso de que encuentre una palabra mayor cambiarla
                    if(array[posPalabra].compareToIgnoreCase(array[i]) > 0)
                        posPalabra = i;
                }
            }
            // Una vez terminado el bulce añado la palabra en la primera posicion del array y la elimino del array principal
            arrayOrdenado[palabrasOrdenadas] = array[posPalabra];

            if (array.length - 1 - posPalabra >= 0)
                System.arraycopy(array, posPalabra + 1, array, posPalabra, array.length - 1 - posPalabra);

            // Va estableciendo la ultima cadena del array una que nunca sea posible
            array[(array.length - 1) - palabrasOrdenadas] = "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ";

        }

        // Imprimo el nuevo array
        for (String s : arrayOrdenado)
            System.out.println("- " + s);

    }

    public static void main(String[] args){

        while (true){
            try{
                Scanner sc = new Scanner(System.in);

                int n;

                do{
                    System.out.print("Número de palabras: ");
                    n = sc.nextInt();
                }while (n <= 0);


                String[] palabras = new String[n];

                fillArray(palabras);

                order(palabras);

                break;
            } catch (java.util.InputMismatchException e){
                System.out.println("Entrada inválida...");
            }
        }


    }
}

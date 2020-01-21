package Ejercicios;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio1 {

    private static String order(String[] array){

        System.out.println(array[1].compareToIgnoreCase("Prro"));
        System.out.println(array[1].compareToIgnoreCase("Ramon"));

        return "Hola";
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n;

        System.out.println("Palabras: ");
        n = sc.nextInt();

        String[] palabras = new String[n];
        String[] palabrasOrdenadas = new String[n];

        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + ":");
            palabras[i] = sc.nextLine();
        }
        System.out.println("Ordenando...");

        order(palabras);

        /*

        for (String s : palabras){
            char x = s.charAt(0);

            for (String j: palabras){
                char i = j.charAt(0);

                if ((int)x == (int) i) {
                    System.out.println("Iguales");
                }else if ((int) x > (int) i){
                    System.out.println(j);
                }else if ( (int) x < (int) i){
                    System.out.println(s);
                }
            }

        }

        */

    }


}

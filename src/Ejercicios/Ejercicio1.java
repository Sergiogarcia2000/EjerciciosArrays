package Ejercicios;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio1 {

    private static String order(String[] array){

        String[] arrayOrdenado = new String[array.length];

        int palabrasOrdenadas = 0;

        while (palabrasOrdenadas < array.length){
            for (int i = 0; i < array.length; i++){



                for (int j = 0; j < array.length; j++){

                    if ( i != j ){



                    }

                }
            }
        }


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



    }


}

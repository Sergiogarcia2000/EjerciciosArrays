package org.ejercicios;

import java.util.Scanner;

/**
 * @author SERGIO GARCIA MAYO
 */
public class Ejercicio3 {


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String[] procesos = new String[100];
        int ultimaPos = 0;


        label:
        while(true){

            System.out.println("====FCFS====");
            System.out.println("1. Añadir proceso a la cola.");
            System.out.println("2. Permitir el acceso a un proceso.");
            System.out.println("3. Salir");
            System.out.print("Introduce una opción: ");
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Nombre del proceso: ");
                    procesos[ultimaPos] = sc.nextLine();
                    System.out.println("Proceso añadido con éxito.");
                    ultimaPos++;
                    break;
                case "2":
                    if (ultimaPos <= 0) {
                        System.out.println("No hay procesos en la cola");
                    } else {
                        System.out.println("Se acaba de procesar el proceso con nombre: " + procesos[0]);
                        System.arraycopy(procesos, 1, procesos, 0, procesos.length - 1);
                        ultimaPos--;
                    }

                    if (ultimaPos > 0){
                        System.out.println("====LISTADO DE PROCESOS====");
                        for(int i = 0; i < ultimaPos; i++){
                            System.out.println(procesos[i]);
                        }
                    }

                    break;
                case "3":
                    break label;
                default:
                    System.out.println("Opción desconocida");
                    break;
            }
        }
    }
}

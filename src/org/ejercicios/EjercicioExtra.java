package org.ejercicios;

import java.util.Scanner;

public class EjercicioExtra {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String[][] procesos = new String[100][2];
        int ultimaPos = 0;


        label:
        while(true){

            System.out.println("====ROUND ROBIN====");
            System.out.println("1. Añadir proceso a la cola.");
            System.out.println("2. Permitir el acceso a un proceso.");
            System.out.println("3. Salir");
            System.out.print("Introduce una opción: ");
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Nombre del proceso: ");
                    procesos[ultimaPos][0] = sc.nextLine();
                    System.out.print("Ciclos del proceso: ");
                    procesos[ultimaPos][1] = sc.nextLine();
                    System.out.println("Proceso añadido con éxito.");
                    ultimaPos++;
                    break;
                case "2":
                    if (ultimaPos <= 0) {
                        System.out.println("No hay procesos en la cola");
                    } else {

                        if (Integer.parseInt(procesos[0][1]) <= 1){

                            System.out.println("Se ha terminado de procesar el proceso con nombre: " + procesos[0][0]);
                            System.arraycopy(procesos, 1, procesos, 0, ultimaPos - 1);
                            ultimaPos--;
                        }else{

                            System.out.println("Se procesa un ciclo del proceso " + procesos[0][0]);

                            procesos[0][1] = Integer.toString(Integer.parseInt(procesos[0][1]) - 1);
                            System.out.println("Numero de ciclos restantes: " + procesos[0][1]);

                            String nombre = procesos[0][0];
                            String ciclos = procesos[0][1];

                            System.arraycopy(procesos, 1, procesos, 0, ultimaPos - 1);

                            procesos[ultimaPos - 1][0] = nombre;
                            procesos[ultimaPos - 1][1] = ciclos;


                        }

                        for(int i = 0; i < ultimaPos; i++){
                            System.out.println(procesos[i][0] + " - " + procesos[i][1]);
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

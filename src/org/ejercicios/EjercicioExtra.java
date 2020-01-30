package org.ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EjercicioExtra {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String[][] procesos = new String[100][2];
        int ultimaPos = 0;

        int quantum = 0;

        do{
            try{
                Scanner scan = new Scanner(System.in);

                System.out.print("Introduce un quantum: ");
                quantum = scan.nextInt();

                if (quantum <= 0)
                    System.out.println("El número debe ser mayor que 0");

            }catch (InputMismatchException e){
                System.out.println("El valor introducido no es válido.");
            }
        }while (quantum <= 0);

        label:
        while(true){

            System.out.println("====ROUND ROBIN====");
            System.out.println("1. Añadir proceso a la cola.");
            System.out.println("2. Permitir el acceso a un proceso.");
            System.out.println("3. Cambiar el valor del quantum.");
            System.out.println("4. Salir");
            System.out.print("Introduce una opción: ");
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Nombre del proceso: ");
                    procesos[ultimaPos][0] = sc.nextLine();
                    System.out.print("Ciclos del proceso: ");
                    procesos[ultimaPos][1] = sc.nextLine();

                    // TRY CATCH PARA COMPROBAR QUE AÑADE UN NÚMERO EN VEZ DE UNA LETRA
                    try{
                        if (Integer.parseInt(procesos[ultimaPos][1]) > 0){
                            System.out.println("Proceso añadido con éxito.");
                            ultimaPos++;
                        }else{
                            System.out.println("El número introducido debe ser mayor que 0.");
                        }
                    }catch (java.lang.NumberFormatException e){
                        System.out.println("Debes introducir un número");
                    }

                    break;
                case "2":
                    if (ultimaPos <= 0) {
                        System.out.println("No hay procesos en la cola");
                    } else {

                        if (Integer.parseInt(procesos[0][1]) <= quantum){

                            System.out.println("Se ha terminado de procesar el proceso con nombre: " + procesos[0][0]);
                            System.arraycopy(procesos, 1, procesos, 0, ultimaPos - 1);
                            ultimaPos--;
                        }else{

                            System.out.println("Se procesa " + quantum + " ciclo/s del proceso " + procesos[0][0]);

                            procesos[0][1] = Integer.toString(Integer.parseInt(procesos[0][1]) - quantum);
                            System.out.println("Numero de ciclos restantes: " + procesos[0][1]);

                            String nombre = procesos[0][0];
                            String ciclos = procesos[0][1];

                            // RECORRER TODOS LOS PROCESOS UNA POSICION ADELANTE
                            for (int i = 0; i < ultimaPos - 1; i++) {
                                procesos[i][0] = procesos[i + 1][0];
                                procesos[i][1] = procesos[i + 1][1];
                            }

                            // ESTABLECER EL ÚLTIMO PROCESO AL QUE FUE PRIMERO
                            procesos[ultimaPos - 1][0] = nombre;
                            procesos[ultimaPos - 1][1] = ciclos;
                        }

                        System.out.println("====== LISTADO DE PROCESOS ======");
                        for(int i = 0; i < ultimaPos; i++){
                            System.out.println(procesos[i][0] + " - " + procesos[i][1]);
                        }
                    }
                    break;
                case "3":
                    do{
                        try{
                            Scanner scan = new Scanner(System.in);

                            System.out.print("Introduce un quantum: ");
                            quantum = scan.nextInt();

                            if (quantum <= 0)
                                System.out.println("El número debe ser mayor que 0");

                        }catch (InputMismatchException e){
                            System.out.println("El valor introducido no es válido.");
                        }
                    }while (quantum <= 0);
                    break;
                case "4":
                    break label;
                default:
                    System.out.println("Opción desconocida");
                    break;
            }
        }
    }
}

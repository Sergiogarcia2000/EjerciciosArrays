package org.ejercicios;

import java.util.Locale;
import java.util.Random;

/**
 * @author SERGIO GARCIA MAYO
 */

public class Ejercicio2 {


    /**
     * MOSTRAR EL ARRAY DE FORMA ADECUADA Y COMPRENSIBLE
     * @param sueldos Array con los sueldos de los trabajadores
     * @param empresas Array con las empresas
     * @param empleados Array con los empleados
     */
    private static void showArray (int[][][] sueldos, String[] empresas, String[][] empleados){

        int salarioMedioMaxTotal = 0;
        String indiceTotal = "";

        // ITERO POR CADA EMPRESA
        for (int i = 0; i < sueldos.length; i++){

            System.out.println("Empresa: " + empresas[i]);
            // VARIABLE STRING EN LA QUE SE GUARDARA LA CADENA QUE DIRA LOS ÍNDICES DE EMPLEADO CON SUELDO MEDIO MAS ALTO
            String indice = "";

            int salarioMedioMaximo = 0;

            // ITERO POR CADA EMPLEADO
            for (int j = 0; j < sueldos[i].length; j++){
                System.out.println("    Empleado: " + empleados[i][j]);

                // VARIABLE QUE VA GUARDANDO LA SUMA DEL SALARIO
                int sumaSalario = 0;

                // ITERO POR LOS MESES
                for (int x = 0; x < sueldos[i][j].length; x++){

                    System.out.print("        Sueldo del mes " + (x + 1) + ": ");
                    System.out.printf(Locale.ITALY, "%,d €%n", sueldos[i][j][x]);
                    sumaSalario += sueldos[i][j][x];
                }

                // REALIZO EL SALARIO MEDIO
                int salarioMedio = sumaSalario / sueldos[i][j].length;

                // COMPRUEBO SI SU SALARIO MEDIO ES MAYOR QUE EL MAXIMO
                // SI ES ASÍ GUARDO SUS INDICES EN LA VARIABLE INDICE
                if (salarioMedio > salarioMedioMaximo){
                    indice = "Índices del array del empleado con el sueldo medio más alto: [" + i + ", " + j + "]";
                    salarioMedioMaximo = salarioMedio;
                }

                if(salarioMedioMaximo > salarioMedioMaxTotal){
                    indiceTotal = "Índices del array del empleado de las tres empresas con el sueldo medio más alto: [" + i + ", " + j + "]";
                    salarioMedioMaxTotal = salarioMedioMaximo;
                }

                System.out.print("        El salario medio del trabajador es: ");
                System.out.printf(Locale.ITALY, "%,d €%n", salarioMedio);
                System.out.println("------------------------------------------------------------------");
            }
            System.out.println(indice);
            System.out.println("=============");

        }

        System.out.println(indiceTotal);
    }

    public static void main(String[] args){

        String[] empresas = {"Indra", "Accenture", "GMQTech"};
        String[][] empleados = {{"Pedro", "Sergio", "Daniel", "Adrian"}, {"Gabi", "Miguel", "Alberto", "Manu"}, {"Carolina", "Alex", "Rosmery", "Roberta"}};
        int[][][] sueldos = new int[3][4][5];

        Random rnd = new Random();

        // RELLENO EL ARRAY CON NUMEROS ALEATORIOS
        for (int i = 0; i < sueldos.length; i++){
            for (int j = 0; j < sueldos[i].length; j++){
                for (int x = 0; x < sueldos[i][j].length; x++){
                    sueldos[i][j][x] = rnd.nextInt(2000) + 2000;
                }
            }
        }

        showArray(sueldos, empresas, empleados);

    }

}

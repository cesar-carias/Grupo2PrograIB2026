/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.zologico;

/**
 *
 * @author ferna
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        java.util.Scanner sn = new java.util.Scanner(System.in);
        boolean salir = false;
        int opcion; 

        while (!salir) {
            System.out.println("--- MENU PRINCIPAL ZOOLÓGICO ---");
            System.out.println("1. Zoo");
            System.out.println("2. Fase II");
            System.out.println("3. Fase III");
            System.out.println("4. Salir");

            System.out.print("Escribe una de las opciones: ");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    // Creamos un objeto de la clase Leon
                    // (Nombre, Especie, Cantidad de alimento)
                    Leon miLeon = new Leon("Simba", "Felino", 5.5);
                    
                    System.out.println("--- DATOS DEL ANIMAL ---");
                    miLeon.mostrarDatos(); // Método heredado de Animal
                    miLeon.emitirSonido(); // Método polimórfico de Leon
                    break;
                case 2:
                    System.out.println("Has seleccionado la opción 2 (Fase II)");
                    break;
                case 3:
                    System.out.println("Has seleccionado la opción 3 (Fase III)");
                    break;
                case 4:
                    salir = true;
                    System.out.println("Saliendo del programa... ¡Feliz día!");
                    break;
                default:
                    System.out.println("Solo números entre 1 y 4");
            }
        }
    }
    
}

package com.zologico;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; 

        while (!salir) {
            System.out.println("\n========================================");
            System.out.println("   SISTEMA DE GESTIÓN ZOOLÓGICO UMG");
            System.out.println("========================================");
            System.out.println("1. Zoo (Fase I: Herencia y Recursividad)");
            System.out.println("2. Fase II (Persistencia en Archivos)");
            System.out.println("3. Fase III (Estructuras de Datos)");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("\n--- EJECUTANDO FASE I ---");
                        // 1. Creamos el objeto usando Polimorfismo
                        // (Nombre, Especie, kg de comida al día)
                        Leon miLeon = new Leon("Simba", "Mamífero - Felino", 8.5);
                        
                        // 2. Demostramos el sonido (Polimorfismo)
                        miLeon.emitirSonido();
                        
                        // 3. Demostramos el cálculo de comida (Recursividad)
                        int dias = 7;
                        double totalComida = miLeon.calcularConsumoRecursivo(dias);
                        
                        System.out.println("Animal: " + miLeon.getNombre());
                        System.out.println("Consumo diario: " + 8.5 + " kg");
                        System.out.println("Total de alimento para " + dias + " días: " + totalComida + " kg");
                        break;

                    case 2:
                        System.out.println("\n[INFO] Fase II: Persistencia en archivos CSV - Próximamente.");
                        break;

                    case 3:
                        System.out.println("\n[INFO] Fase III: Pilas, Colas y Listas - Próximamente.");
                        break;

                    case 4:
                        System.out.println("Saliendo del sistema... ¡Feliz día, Ingeniero!");
                        salir = true;
                        break;

                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: Por favor ingrese un número válido.");
                sn.next(); // Limpiar el scanner para evitar bucle infinito
            }
        }
    }
}
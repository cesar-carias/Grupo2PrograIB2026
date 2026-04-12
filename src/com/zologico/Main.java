package com.zologico;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        
        // Solo uno de cada tipo (Instrucción 1.1.1)
        Leon miLeon = null;
        Aguila miAguila = null;
        Serpiente miSerpiente = null;

        while (!salir) {
            System.out.println("\n--- SISTEMA ZOOLÓGICO FASE I ---");
            System.out.println("1. Agregar Animal (Máx 1 por especie)");
            System.out.println("2. Ver Listado de Animales y Sonidos");
            System.out.println("3. Calcular Alimento (Recursividad)");
            System.out.println("4. Salir");
            System.out.print("Seleccione: ");

            try {
                int opcion = sn.nextInt();
                sn.nextLine(); 

                switch (opcion) {
                    case 1:
                        System.out.print("Tipo (1.Leon 2.Aguila 3.Serpiente): ");
                        int tipo = sn.nextInt(); sn.nextLine();
                        System.out.print("Nombre: "); String n = sn.nextLine();
                        System.out.print("Consumo diario (kg): "); double c = sn.nextDouble();

                        if (tipo == 1 && miLeon == null) {
                            miLeon = new Leon(n, "Felino", c);
                            System.out.println("¡Leon agregado!");
                        } else if (tipo == 2 && miAguila == null) {
                            miAguila = new Aguila(n, "Rapaz", c);
                            System.out.println("¡Aguila agregada!");
                        } else if (tipo == 3 && miSerpiente == null) {
                            miSerpiente = new Serpiente(n, "Reptil", c);
                            System.out.println("¡Serpiente agregada!");
                        } else {
                            System.out.println("Error: Especie ya existe o tipo inválido.");
                        }
                        break;

                    case 2:
                        System.out.println("\n--- LISTADO DEL ZOO ---");
                        if (miLeon != null) { System.out.print(miLeon.getNombre() + ": "); miLeon.emitirSonido(); }
                        if (miAguila != null) { System.out.print(miAguila.getNombre() + ": "); miAguila.emitirSonido(); }
                        if (miSerpiente != null) { System.out.print(miSerpiente.getNombre() + ": "); miSerpiente.emitirSonido(); }
                        break;

                    case 3:
                        System.out.print("¿Para cuántos días calcular? ");
                        int dias = sn.nextInt();
                        if (miLeon != null) System.out.println(miLeon.getNombre() + " consumirá: " + miLeon.calcularConsumoRecursivo(dias) + "kg");
                        if (miAguila != null) System.out.println(miAguila.getNombre() + " consumirá: " + miAguila.calcularConsumoRecursivo(dias) + "kg");
                        if (miSerpiente != null) System.out.println(miSerpiente.getNombre() + " consumirá: " + miSerpiente.calcularConsumoRecursivo(dias) + "kg");
                        break;

                    case 4:
                        salir = true;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: Ingrese datos válidos.");
                sn.next();
            }
        }
    }
}
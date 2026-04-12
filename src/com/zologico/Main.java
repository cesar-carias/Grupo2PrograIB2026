package com.zologico;

import java.util.Scanner;

public class Main {

    static Mamifero mamifero = null;
    static Ave ave = null;
    static Reptil reptil = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- SISTEMA ZOOLOGICO FASE I ---");
            System.out.println("1. Agregar Animal (Max 1 por especie)");
            System.out.println("2. Ver Listado de Animales y Sonidos");
            System.out.println("3. Calcular Alimento (Recursividad)");
            System.out.println("4. Exportar datos a CSV");
            System.out.println("5. Salir");
            System.out.print("Seleccione: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    agregarAnimal(sc);
                    break;
                case 2:
                    mostrarAnimales();
                    break;
                case 3:
                    calcularAlimento(sc);
                    break;
                case 4:
                    ArchivoCSV.exportar(mamifero, ave, reptil);
                    break;
                case 5:
                    System.out.println("Gracias por usar el sistema del zoologico.");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 5);

        sc.close();
    }

    public static void agregarAnimal(Scanner sc) {
        System.out.println("\n1. Mamifero");
        System.out.println("2. Ave");
        System.out.println("3. Reptil");
        System.out.print("Seleccione tipo: ");
        int tipo = sc.nextInt();
        sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Especie: ");
        String especie = sc.nextLine();

        System.out.print("Consumo diario (kg): ");
        double consumo = sc.nextDouble();
        sc.nextLine();

        switch (tipo) {
            case 1:
                if (mamifero == null) {
                    mamifero = new Mamifero(nombre, especie, consumo);
                    System.out.println("Mamifero agregado.");
                } else {
                    System.out.println("Ya existe un mamifero registrado.");
                }
                break;

            case 2:
                if (ave == null) {
                    ave = new Ave(nombre, especie, consumo);
                    System.out.println("Ave agregada.");
                } else {
                    System.out.println("Ya existe un ave registrada.");
                }
                break;

            case 3:
                if (reptil == null) {
                    reptil = new Reptil(nombre, especie, consumo);
                    System.out.println("Reptil agregado.");
                } else {
                    System.out.println("Ya existe un reptil registrado.");
                }
                break;

            default:
                System.out.println("Opcion invalida.");
        }
    }

    public static void mostrarAnimales() {
        System.out.println("\n--- ANIMALES DEL ZOO ---");

        if (mamifero != null) {
            System.out.println(mamifero.getTipo() + ": " + mamifero.getNombre() + " - " + mamifero.getEspecie());
            mamifero.emitirSonido();
        }

        if (ave != null) {
            System.out.println(ave.getTipo() + ": " + ave.getNombre() + " - " + ave.getEspecie());
            ave.emitirSonido();
        }

        if (reptil != null) {
            System.out.println(reptil.getTipo() + ": " + reptil.getNombre() + " - " + reptil.getEspecie());
            reptil.emitirSonido();
        }

        if (mamifero == null && ave == null && reptil == null) {
            System.out.println("No hay animales registrados.");
        }
    }

    public static void calcularAlimento(Scanner sc) {
        System.out.println("\n--- CALCULO DE ALIMENTO ---");
        System.out.println("1. Mamifero");
        System.out.println("2. Ave");
        System.out.println("3. Reptil");
        System.out.print("Seleccione animal: ");
        int tipo = sc.nextInt();

        System.out.print("Ingrese cantidad de dias: ");
        int dias = sc.nextInt();
        sc.nextLine();

        switch (tipo) {
            case 1:
                if (mamifero != null) {
                    System.out.println("Consumo total: " + mamifero.calcularConsumoRecursivo(dias) + " kg");
                } else {
                    System.out.println("No hay mamifero registrado.");
                }
                break;

            case 2:
                if (ave != null) {
                    System.out.println("Consumo total: " + ave.calcularConsumoRecursivo(dias) + " kg");
                } else {
                    System.out.println("No hay ave registrada.");
                }
                break;

            case 3:
                if (reptil != null) {
                    System.out.println("Consumo total: " + reptil.calcularConsumoRecursivo(dias) + " kg");
                } else {
                    System.out.println("No hay reptil registrado.");
                }
                break;

            default:
                System.out.println("Opcion invalida.");
        }
    }
}
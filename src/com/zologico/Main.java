package com.zologico;

import java.util.Scanner;

public class Main {

    private static final Zoo zoo = new Zoo();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcionPrincipal;

        do {
            System.out.println("\n===== SISTEMA ZOOLOGICO =====");
            System.out.println("1. Registrar Animal");
            System.out.println("2. Fase 2 - Arreglos y Busqueda");
            System.out.println("3. Calcular Alimento");
            System.out.println("4. Exportar datos CSV");
            System.out.println("5. Salir");
            opcionPrincipal = leerEnteroRango(sc, "Seleccione una opcion: ", 1, 5);

            switch (opcionPrincipal) {
                case 1:
                    registrarAnimalPorTipo(sc);
                    break;
                case 2:
                    menuFase2(sc);
                    break;
                case 3:
                    calcularAlimento(sc);
                    break;
                case 4:
                    ArchivoCSV.exportar(zoo.getAnimales());
                    break;
                case 5:
                    System.out.println("Gracias por usar el sistema del zoologico.");
                    break;
            }

        } while (opcionPrincipal != 5);

        sc.close();
    }

    private static void menuFase2(Scanner sc) {

        int opcion;
        do {
            System.out.println("\n===== FASE 2 - ARREGLOS Y BUSQUEDA =====");
            System.out.println("a. Agregar Mamifero");
            System.out.println("b. Agregar Ave");
            System.out.println("c. Agregar Reptil");
            System.out.println("d. Buscar animal por identificador");
            System.out.println("e. Buscar animal por nombre");
            System.out.println("f. Ordenar arreglo por identificador");
            System.out.println("g. Mostrar todos los animales");
            System.out.println("h. Mostrar estadisticas");
            System.out.println("i. Regresar al menu principal");
            System.out.print("Seleccione una opcion: ");

            String entrada = sc.nextLine().trim().toLowerCase();
            opcion = entrada.isEmpty() ? 0 : entrada.charAt(0);

            switch (opcion) {
                case 'a':
                    registrarAnimalEspecifico(sc, 1);
                    break;
                case 'b':
                    registrarAnimalEspecifico(sc, 2);
                    break;
                case 'c':
                    registrarAnimalEspecifico(sc, 3);
                    break;
                case 'd':
                    buscarPorId(sc);
                    break;
                case 'e':
                    buscarPorNombre(sc);
                    break;
                case 'f':
                    ordenarPorId(sc);
                    break;
                case 'g':
                    zoo.mostrarTodos();
                    break;
                case 'h':
                    zoo.mostrarEstadisticas();
                    break;
                case 'i':
                    System.out.println("Regresando al menu principal...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 'i');
    }

    private static void registrarAnimalPorTipo(Scanner sc) {
        System.out.println("\n1. Mamifero");
        System.out.println("2. Ave");
        System.out.println("3. Reptil");
        int tipo = leerEnteroRango(sc, "Seleccione el tipo de animal: ", 1, 3);
        registrarAnimalEspecifico(sc, tipo);
    }

    private static void registrarAnimalEspecifico(Scanner sc, int tipo) {

        if (zoo.estaLleno()) {
            System.out.println("El Zoo ya esta lleno");
            return;
        }

        try {
            long idAnimal = leerIdUnico(sc);

            String nombre = leerTextoNoVacio(sc, "Nombre: ");
            String especie = leerTextoNoVacio(sc, "Especie: ");
            int años = leerEnteroNoNegativo(sc, "Años: ");
            double consumo = leerDoublePositivo(sc, "Consumo diario (kg): ");

            Animal animal = null;

            switch (tipo) {
                case 1:
                    String pelaje = leerTextoNoVacio(sc, "Tipo de pelaje: ");
                    animal = new Mamifero(idAnimal, nombre, especie, años, consumo, pelaje);
                    break;
                case 2:
                    double envergadura = leerDoublePositivo(sc, "Envergadura de alas (cm): ");
                    animal = new Ave(idAnimal, nombre, especie, años, consumo, envergadura);
                    break;
                case 3:
                    boolean venenoso = leerBooleano(sc, "Es venenoso? (s/n): ");
                    animal = new Reptil(idAnimal, nombre, especie, años, consumo, venenoso);
                    break;
                default:
                    System.out.println("Tipo invalido.");
                    return;
            }

            zoo.agregarAnimal(animal);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void buscarPorId(Scanner sc) {
        long id = leerLongPositivo(sc, "Ingrese el identificador a buscar: ");
        zoo.buscarPorId(id);
    }

    private static void buscarPorNombre(Scanner sc) {
        String nombre = leerTextoNoVacio(sc, "Ingrese el nombre a buscar: ");
        zoo.buscarPorNombre(nombre);
    }

    private static void ordenarPorId(Scanner sc) {
        if (zoo.getContador() == 0) {
            System.out.println("No hay animales registrados.");
            return;
        }

        System.out.println("1. Ascendente");
        System.out.println("2. Descendente");
        int opcion = leerEnteroRango(sc, "Seleccione el orden: ", 1, 2);

        boolean ascendente = opcion == 1;
        zoo.ordenarPorId(ascendente);

        System.out.println("\nArreglo ordenado por identificador:");
        zoo.mostrarTodos();
    }

    private static void calcularAlimento(Scanner sc) {
        if (zoo.getContador() == 0) {
            System.out.println("No hay animales registrados.");
            return;
        }

        long id = leerLongPositivo(sc, "Ingrese el identificador del animal: ");
        Animal animal = buscarAnimalPorId(id);

        if (animal == null) {
            System.out.println("No existe un animal con ese identificador.");
            return;
        }

        int dias = leerEnteroPositivo(sc, "Ingrese la cantidad de dias: ");
        double total = animal.calcularConsumoRecursivo(dias);

        System.out.println("Animal: " + animal.getNombre());
        System.out.println("Consumo total en " + dias + " dias: " + total + " kg");
    }

    private static Animal buscarAnimalPorId(long idAnimal) {
        Animal[] animales = zoo.getAnimales();

        for (int i = 0; i < zoo.getContador(); i++) {
            if (animales[i] != null && animales[i].getIdAnimal() == idAnimal) {
                return animales[i];
            }
        }
        return null;
    }

    private static long leerIdUnico(Scanner sc) {
        while (true) {
            long id = leerLongPositivo(sc, "ID animal: ");

            if (zoo.existeId(id)) {
                System.out.println("El identificador es unico para cada animal");
            } else {
                return id;
            }
        }
    }

    private static String leerTextoNoVacio(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = sc.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("Debe ingresar un valor valido.");
        }
    }

    private static long leerLongPositivo(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();
            try {
                long valor = Long.parseLong(entrada);
                if (valor > 0) {
                    return valor;
                }
                System.out.println("Debe ingresar un numero mayor a 0.");
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero valido.");
            }
        }
    }

    private static int leerEnteroPositivo(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();
            try {
                int valor = Integer.parseInt(entrada);
                if (valor > 0) {
                    return valor;
                }
                System.out.println("Debe ingresar un numero mayor a 0.");
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero valido.");
            }
        }
    }

    private static int leerEnteroNoNegativo(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();
            try {
                int valor = Integer.parseInt(entrada);
                if (valor >= 0) {
                    return valor;
                }
                System.out.println("Debe ingresar un numero mayor o igual a 0.");
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero valido.");
            }
        }
    }

    private static double leerDoublePositivo(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();
            try {
                double valor = Double.parseDouble(entrada);
                if (valor > 0) {
                    return valor;
                }
                System.out.println("Debe ingresar un numero mayor a 0.");
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero valido.");
            }
        }
    }

    private static int leerEnteroRango(Scanner sc, String mensaje, int min, int max) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();
            try {
                int valor = Integer.parseInt(entrada);
                if (valor >= min && valor <= max) {
                    return valor;
                }
                System.out.println("Debe ingresar una opcion entre " + min + " y " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero valido.");
            }
        }
    }

    private static boolean leerBooleano(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim().toLowerCase();

            if (entrada.equals("s") || entrada.equals("si")) {
                return true;
            }

            if (entrada.equals("n") || entrada.equals("no")) {
                return false;
            }

            System.out.println("Debe responder con s/n o si/no.");
        }
    }
}
package com.zologico;


public class Zoo {

    private final Animal[] animales;
    private int contador;

    public Zoo() {
        animales = new Animal[10];
        contador = 0;
    }

    public Animal[] getAnimales() {
        return animales;
    }

    public int getContador() {
        return contador;
    }

    public boolean estaLleno() {
        return contador >= animales.length;
    }

    public boolean existeId(long idAnimal) {
        return obtenerIndicePorId(idAnimal) != -1;
    }

    private int obtenerIndicePorId(long idAnimal) {
        for (int i = 0; i < contador; i++) {
            if (animales[i] != null && animales[i].getIdAnimal() == idAnimal) {
                return i;
            }
        }
        return -1;
    }

    public boolean agregarAnimal(Animal animal) {
        if (estaLleno()) {
            System.out.println("El Zoo ya esta lleno");
            return false;
        }

        if (existeId(animal.getIdAnimal())) {
            System.out.println("El identificador es unico para cada animal");
            return false;
        }

        animales[contador] = animal;
        contador++;
        System.out.println("Animal agregado correctamente.");
        return true;
    }

    public void buscarPorId(long idAnimal) {
        int posicion = obtenerIndicePorId(idAnimal);

        if (posicion == -1) {
            System.out.println("No existe un animal con ese identificador.");
            return;
        }

        System.out.println("\nAnimal encontrado en la posicion: " + (posicion + 1));
        System.out.println(animales[posicion]);
    }

    public void buscarPorNombre(String nombre) {
        boolean encontrado = false;

        System.out.println("\n===== RESULTADOS DE BUSQUEDA =====");

        for (int i = 0; i < contador; i++) {
            if (animales[i] != null && animales[i].getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("\nPosicion: " + (i + 1));
                System.out.println(animales[i]);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No existe un animal con ese nombre.");
        }
    }

    public void ordenarPorId(boolean ascendente) {
        for (int i = 0; i < contador - 1; i++) {
            for (int j = 0; j < contador - 1 - i; j++) {
                boolean debeIntercambiar;

                if (ascendente) {
                    debeIntercambiar = animales[j].getIdAnimal() > animales[j + 1].getIdAnimal();
                } else {
                    debeIntercambiar = animales[j].getIdAnimal() < animales[j + 1].getIdAnimal();
                }

                if (debeIntercambiar) {
                    Animal temp = animales[j];
                    animales[j] = animales[j + 1];
                    animales[j + 1] = temp;
                }
            }
        }
    }

    public void mostrarTodos() {
        System.out.println("\n===== ANIMALES REGISTRADOS =====");

        if (contador == 0) {
            System.out.println("No hay animales registrados.");
            return;
        }

        for (int i = 0; i < contador; i++) {
            if (animales[i] != null) {
                System.out.println("\nPosicion: " + (i + 1));
                System.out.println(animales[i]);
            }
        }
    }

    public void mostrarEstadisticas() {
        if (contador == 0) {
            System.out.println("No hay animales registrados.");
            return;
        }

        int totalAnimales = 0;
        int cantidadMamiferos = 0;
        int cantidadAves = 0;
        int cantidadReptiles = 0;
        int sumaAños = 0;

        Animal mayorConsumo = null;
        Animal menorConsumo = null;

        for (int i = 0; i < contador; i++) {
            Animal actual = animales[i];

            if (actual == null) {
                continue;
            }

            totalAnimales++;
            sumaAños += actual.getAños();

            if (actual instanceof Mamifero) {
                cantidadMamiferos++;
            } else if (actual instanceof Ave) {
                cantidadAves++;
            } else if (actual instanceof Reptil) {
                cantidadReptiles++;
            }

            if (mayorConsumo == null || actual.getCantidadAlimento() > mayorConsumo.getCantidadAlimento()) {
                mayorConsumo = actual;
            }

            if (menorConsumo == null || actual.getCantidadAlimento() < menorConsumo.getCantidadAlimento()) {
                menorConsumo = actual;
            }
        }

        double promedioEdad = (double) sumaAños / totalAnimales;

        System.out.println("\n===== ESTADISTICAS DEL ZOO =====");
        System.out.println("Cantidad total de animales registrados: " + totalAnimales);
        System.out.println("Cantidad de mamiferos: " + cantidadMamiferos);
        System.out.println("Cantidad de aves: " + cantidadAves);
        System.out.println("Cantidad de reptiles: " + cantidadReptiles);
        System.out.println("Promedio de edad de los animales registrados: " + promedioEdad);

        System.out.println("\nAnimal con mayor consumo de alimento:");
        System.out.println(mayorConsumo);

        System.out.println("\nAnimal con menor consumo de alimento:");
        System.out.println(menorConsumo);
    }
}
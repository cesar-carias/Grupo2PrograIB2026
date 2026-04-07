package com.zologico;

public abstract class Animal {
    // Atributos básicos que todos los animales del zoo tendrán
    protected String nombre;
    protected String especie;
    protected double cantidadAlimento; // Para la recursividad después

    public Animal(String nombre, String especie, double cantidadAlimento) {
        this.nombre = nombre;
        this.especie = especie;
        this.cantidadAlimento = cantidadAlimento;
    }

    // Este método es "Abstracto" porque cada animal hace un sonido distinto
    // Esto es POLIMORFISMO
    public abstract void emitirSonido();

    public void mostrarDatos() {
        System.out.println("Animal: " + nombre + " | Especie: " + especie);
    }
}
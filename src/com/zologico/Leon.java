package com.zologico;

// Hereda de Mamifero, cumpliendo la jerarquía del Ing. García
public class Leon extends Mamifero {

    // Constructor: Recibe los datos y los pasa hacia arriba (super)
    public Leon(String nombre, String especie, double cantidadAlimento) {
        super(nombre, especie, cantidadAlimento);
    }

    // Polimorfismo: Cada animal tiene su propio rugido
    @Override
    public void emitirSonido() {
        System.out.println("El león " + nombre + " está rugiendo: ¡ROAARRRR!");
    }
}
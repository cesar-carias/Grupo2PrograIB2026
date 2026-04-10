package com.zologico;

// 'abstract' porque no existe un "Mamífero" genérico, solo especies específicas
public abstract class Mamifero extends Animal {

    public Mamifero(String nombre, String especie, double cantidadAlimento) {
        // 'super' envía los datos hacia arriba, a la clase Animal
        super(nombre, especie, cantidadAlimento);
    }
}
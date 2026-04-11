package com.zologico;

// Debe extender de tu clase Animal
public abstract class Ave extends Animal {

    // Constructor que comunica con la clase padre (Animal)
    public Ave(String nombre, String especie, double cantidadAlimento) {
        super(nombre, especie, cantidadAlimento);
    }
    
    // Aquí Eduardo no necesita poner el método emitirSonido 
    // porque es abstracta, eso lo hará en la clase hija.
}
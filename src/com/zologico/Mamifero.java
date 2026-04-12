package com.zologico;

public class Mamifero extends Animal {

    public Mamifero(String nombre, String especie, double cantidadAlimento) {
        super(nombre, especie, cantidadAlimento);
    }

    @Override
    public void emitirSonido() {
        System.out.println(nombre + " hace: Grrrr ");
    }

    @Override
    public String getTipo() {
        return "Mamifero";
    }
}
      

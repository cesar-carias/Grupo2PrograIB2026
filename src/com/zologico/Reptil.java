package com.zologico;

public class Reptil extends Animal {

    public Reptil(String nombre, String especie, double cantidadAlimento) {
        super(nombre, especie, cantidadAlimento);
    }

    @Override
    public void emitirSonido() {
        System.out.println(nombre + " hace:  Ssssss ");
    }

    @Override
    public String getTipo() {
        return "Reptil";
    }
}
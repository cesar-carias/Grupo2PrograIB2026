package com.zologico;

public class Ave extends Animal {

    public Ave(String nombre, String especie, double cantidadAlimento) {
        super(nombre, especie, cantidadAlimento);
    }

    @Override
    public void emitirSonido() {
        System.out.println(nombre + " hace: Pii pii ");
    }

    @Override
    public String getTipo() {
        return "Ave";
    }
}
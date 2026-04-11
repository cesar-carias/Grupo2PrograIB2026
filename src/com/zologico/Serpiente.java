package com.zologico;

public class Serpiente extends Reptil {
    public Serpiente(String nombre, String especie, double cantidadAlimento) {
        super(nombre, especie, cantidadAlimento);
    }

    @Override
    public void emitirSonido() {
        System.out.println("La serpiente " + getNombre() + " sisea: ¡Sssssssss!");
    }
}

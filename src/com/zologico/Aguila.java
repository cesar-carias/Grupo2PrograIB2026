package com.zologico;

public class Aguila extends Ave {

    public Aguila(String nombre, String especie, double cantidadAlimento) {
        super(nombre, especie, cantidadAlimento);
    }

    @Override
    public void emitirSonido() {
        System.out.println("El águila " + getNombre() + " lanza un grito agudo: ¡Screeech!");
    }
}
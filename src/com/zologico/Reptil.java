package com.zologico;


public class Reptil extends Animal {

    private boolean venenoso;

    public Reptil(long idAnimal, String nombre, String especie, int años, double cantidadAlimento, boolean venenoso) {
        super(idAnimal, nombre, especie, años, cantidadAlimento);
        this.venenoso = venenoso;
    }

    public boolean isVenenoso() {
        return venenoso;
    }

    @Override
    public void emitirSonido() {
        System.out.println(getNombre() + " hace: Ssssss");
    }

    @Override
    public String getTipo() {
        return "Reptil";
    }

    @Override
    public String getDatoEspecifico() {
        return venenoso ? "Es venenoso: Si" : "Es venenoso: No";
    }
}
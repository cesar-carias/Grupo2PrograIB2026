package com.zologico;


public class Mamifero extends Animal {

    private String tipoPelaje;

    public Mamifero(long idAnimal, String nombre, String especie, int años, double cantidadAlimento, String tipoPelaje) {
        super(idAnimal, nombre, especie, años, cantidadAlimento);

        if (tipoPelaje == null || tipoPelaje.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de pelaje no puede estar vacio.");
        }

        this.tipoPelaje = tipoPelaje.trim();
    }

    public String getTipoPelaje() {
        return tipoPelaje;
    }

    @Override
    public void emitirSonido() {
        System.out.println(getNombre() + " hace: Grrrr");
    }

    @Override
    public String getTipo() {
        return "Mamifero";
    }

    @Override
    public String getDatoEspecifico() {
        return "Tipo de pelaje: " + tipoPelaje;
    }
}

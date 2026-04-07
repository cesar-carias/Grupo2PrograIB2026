package com.zologico;

// "extends Animal" significa que León hereda todo de tu clase madre
public class Leon extends Animal {

    public Leon(String nombre, String especie, double cantidadAlimento) {
        // "super" le envía los datos al constructor de la clase Animal
        super(nombre, especie, cantidadAlimento);
    }

    // Aquí aplicas el POLIMORFISMO: defines el sonido real
    @Override
    public void emitirSonido() {
        System.out.println("El león " + nombre + " está rugiendo: ¡ROAARR!");
    }
}
package com.zologico;

public abstract class Animal {
    protected String nombre;
    protected String especie;
    protected double cantidadAlimento;

    public Animal(String nombre, String especie, double cantidadAlimento) {
        this.nombre = nombre;
        this.especie = especie;
        this.cantidadAlimento = cantidadAlimento;
    }

    // RECURSIVIDAD: Cálculo de alimento día por día
    public double calcularConsumoRecursivo(int dias) {
        if (dias <= 0) return 0;
        return this.cantidadAlimento + calcularConsumoRecursivo(dias - 1);
    }

    public abstract void emitirSonido();

// Este es el método que le falta a tu Main para reconocer el nombre
public String getNombre() {
    return nombre;
}

}
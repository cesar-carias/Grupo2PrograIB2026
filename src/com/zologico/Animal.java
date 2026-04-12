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

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public double getCantidadAlimento() {
        return cantidadAlimento;
    }

    public double calcularConsumoRecursivo(int dias) {
        if (dias <= 0) {
            return 0;
        }
        return cantidadAlimento + calcularConsumoRecursivo(dias - 1);
    }

    public abstract void emitirSonido();
    public abstract String getTipo();
}
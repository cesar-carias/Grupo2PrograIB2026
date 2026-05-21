package com.zologico;


public abstract class Animal {

    private long idAnimal;
    private String nombre;
    private String especie;
    private int años;
    private double cantidadAlimento;

    public Animal(long idAnimal, String nombre, String especie, int años, double cantidadAlimento) {

        if (idAnimal <= 0) {
            throw new IllegalArgumentException("El identificador debe ser mayor a 0.");
        }

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio.");
        }

        if (especie == null || especie.trim().isEmpty()) {
            throw new IllegalArgumentException("La especie no puede estar vacia.");
        }

        if (años < 0) {
            throw new IllegalArgumentException("Los años no pueden ser negativos.");
        }

        if (cantidadAlimento <= 0) {
            throw new IllegalArgumentException("La cantidad de alimento debe ser mayor a 0.");
        }

        this.idAnimal = idAnimal;
        this.nombre = nombre.trim();
        this.especie = especie.trim();
        this.años = años;
        this.cantidadAlimento = cantidadAlimento;
    }

    public long getIdAnimal() {
        return idAnimal;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public int getAños() {
        return años;
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

    @Override
    public String toString() {
        return "ID: " + idAnimal +
                "\nNombre: " + nombre +
                "\nEspecie: " + especie +
                "\nAños: " + años +
                "\nConsumo diario: " + cantidadAlimento + " kg" +
                "\nDato especifico: " + getDatoEspecifico();
    }

    public abstract void emitirSonido();

    public abstract String getTipo();

    public abstract String getDatoEspecifico();
}

package com.zologico;


public class Ave extends Animal {

    private double envergaduraAlas;

    public Ave(long idAnimal, String nombre, String especie, int años, double cantidadAlimento, double envergaduraAlas) {
        super(idAnimal, nombre, especie, años, cantidadAlimento);

        if (envergaduraAlas <= 0) {
            throw new IllegalArgumentException("La envergadura de alas debe ser mayor a 0.");
        }

        this.envergaduraAlas = envergaduraAlas;
    }

    public double getEnvergaduraAlas() {
        return envergaduraAlas;
    }

    @Override
    public void emitirSonido() {
        System.out.println(getNombre() + " hace: Pii pii");
    }

    @Override
    public String getTipo() {
        return "Ave";
    }

    @Override
    public String getDatoEspecifico() {
        return "Envergadura de alas: " + envergaduraAlas + " cm";
    }
}

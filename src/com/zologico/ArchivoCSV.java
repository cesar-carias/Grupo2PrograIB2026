package com.zologico;


import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class ArchivoCSV {

    public static void exportar(Animal[] animales) {

        boolean hayDatos = false;

        try (PrintWriter pw = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream("zoologico.csv"),
                                StandardCharsets.UTF_8)))) {

            pw.println("idAnimal,nombre,especie,años,consumo,tipo,datoEspecifico");

            for (Animal animal : animales) {
                if (animal != null) {
                    pw.println(
                            escapeCsv(String.valueOf(animal.getIdAnimal())) + "," +
                            escapeCsv(animal.getNombre()) + "," +
                            escapeCsv(animal.getEspecie()) + "," +
                            escapeCsv(String.valueOf(animal.getAños())) + "," +
                            escapeCsv(String.valueOf(animal.getCantidadAlimento())) + "," +
                            escapeCsv(animal.getTipo()) + "," +
                            escapeCsv(animal.getDatoEspecifico())
                    );
                    hayDatos = true;
                }
            }

            if (hayDatos) {
                System.out.println("Datos exportados correctamente a zoologico.csv");
            } else {
                System.out.println("No hay animales para exportar.");
            }

        } catch (IOException e) {
            System.out.println("Error al exportar el archivo: " + e.getMessage());
        }
    }

    private static String escapeCsv(String valor) {
        if (valor == null) {
            return "";
        }
        return "\"" + valor.replace("\"", "\"\"") + "\"";
    }
}

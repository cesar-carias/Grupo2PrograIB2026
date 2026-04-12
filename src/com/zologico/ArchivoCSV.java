package com.zologico;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ArchivoCSV {
    
    public static void exportar(Mamifero mamifero, Ave ave, Reptil reptil) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("zoologico.csv"))) {

            pw.println("tipo,nombre,especie,consumo");

            if (mamifero != null) {
                pw.println(mamifero.getTipo() + "," + mamifero.getNombre() + "," + mamifero.getEspecie() + "," + mamifero.getCantidadAlimento());
            }

            if (ave != null) {
                pw.println(ave.getTipo() + "," + ave.getNombre() + "," + ave.getEspecie() + "," + ave.getCantidadAlimento());
            }

            if (reptil != null) {
                pw.println(reptil.getTipo() + "," + reptil.getNombre() + "," + reptil.getEspecie() + "," + reptil.getCantidadAlimento());
            }

            System.out.println("Datos exportados correctamente a zoologico.csv");

        } catch (IOException e) {
            System.out.println("Error al exportar el archivo: " + e.getMessage());
        }
    }
}
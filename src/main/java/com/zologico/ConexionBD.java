package com.zologico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL =
            "jdbc:mysql://localhost:3306/zoologico";

    private static final String USUARIO = "root";

    private static final String PASSWORD = "Cesar2110fer";

    public static Connection conectar() {

        try {

            Connection conexion =
                    DriverManager.getConnection(URL, USUARIO, PASSWORD);

            System.out.println("Conexión exitosa a MySQL");

            return conexion;

        } catch (SQLException e) {

            System.out.println("Error al conectar: " + e.getMessage());

            return null;
        }
    }
}
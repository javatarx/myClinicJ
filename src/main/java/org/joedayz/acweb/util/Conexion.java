package org.joedayz.acweb.util;

import java.sql.*;

public class Conexion {

    public static Connection getConnexion() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:/" + Constantes.directorioBaseDeDatos + "/myClinic", "sa", "");

//		connection  = DriverManager.getConnection("jdbc:h2:myClinic", "sa", "");
        } catch (ClassNotFoundException e) {

            System.out.println("Error de Conexion");
        }
        return connection;
    }
}

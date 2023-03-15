package com.company.db;

import java.sql.*;

public class ConectDb {

    private Connection c = null; // Objeto de tipo coneccion donde se guardaran los datos de coneccion
    private final Statement stmt = null; // Objeto de tipo sentencia SQL
    private final ResultSet rs = null; // Objeto de tipo resultado Query SQL
    private final String url = "jdbc:postgresql://localhost:5432/adminconcecionaria";
    private final String usuario = "natalia";
    private final String passware = "natalia";

    // CONSTRUCTORLI
    public ConectDb() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, usuario, passware);
            c.setAutoCommit(true);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            c.close();
        }
    }


    /**
     * Cierra la coneccion con la BD
     */
    public void cerrarDatabase() throws SQLException {
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        // Se cierra conexion a la BD
        c.close();
    }

    public Connection getC() {
        return c;
    }

    public void setC(Connection c) {
        this.c = c;
    }

}

package com.company.db;


import com.company.bean.Auto;
import com.company.bean.TipodeCombustible;
import com.company.bean.Vehiculo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Autodb {
    public static String bool = "T";


    public static List< Auto > consultarAutos() throws SQLException {
        List< Auto > autos = new ArrayList< Auto >();
        ConectDb c = new ConectDb();
        Statement stmt = c.getC().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Auto " +
                "inner join Vehiculos on Vehiculos.patente=Auto.vehiculos_patente" +
                " inner join Tipocombustible on Vehiculos.idtipocombustiblr=Tipocombustible.id;");
        while (rs.next()) {
            int ide = rs.getInt("id");
            String vehiculos_patente = rs.getString("patente");
            String detalle = rs.getString("detalle");
            int modelo = rs.getInt("modelo");
            int km = rs.getInt("km");
            int tipocombustible = rs.getInt("idtipocombustiblr");
            float precio = rs.getFloat("precio");
            String tipo = rs.getString("tipo");
            String marca = rs.getString("marca");
            boolean aldia = bool.equalsIgnoreCase(rs.getString("servicioaldia"));
            TipoCombustibledb tc = new TipoCombustibledb();
            TipodeCombustible tipoComb = tc.getTipoCombustible(tipocombustible);
            Auto auto = new Auto(ide, vehiculos_patente, km, tipoComb, modelo, marca, precio, aldia, detalle, tipo);
            autos.add(auto);
            System.out.println(auto);
        }
        rs.close();
        stmt.close();
        return autos;
    }

    public static Auto getAuto(Integer id) throws SQLException {
        ConectDb c = new ConectDb();
        Statement stmt = c.getC().createStatement();
        Vehiculo vehiculo;
        try {
            PreparedStatement pstmt = c.getC().prepareStatement("SELECT * FROM Auto WHERE id=?;");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int ide = rs.getInt("id");
                String vehiculos_patente = rs.getString("vehiculos_patente");
                String detalle = rs.getString("detalle");
                PreparedStatement pstmtveic = c.getC().prepareStatement("SELECT * FROM Vehiculo WHERE patente=?;");
                pstmtveic.setString(1, vehiculos_patente);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    int modelo = rs.getInt("modelo");
                    int km = rs.getInt("km");
                    int tipocombustible = rs.getInt("idtipocombustiblr");
                    float precio = rs.getFloat("precio");
                    String tipo = rs.getString("tipo");
                    String marca = rs.getString("marca");
                    boolean aldia = bool.equalsIgnoreCase(rs.getString("servicioaldia"));
                    TipoCombustibledb tc = new TipoCombustibledb();
                    TipodeCombustible tipoComb = tc.getTipoCombustible(tipocombustible);
                    return new Auto(ide, vehiculos_patente, km, tipoComb, modelo, marca, precio, aldia, detalle, tipo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static Boolean addAuto(Auto auto) throws SQLException {
        ConectDb c = new ConectDb();
        Statement stmt = c.getC().createStatement();

        try {
            /**  id_sucursal
             **/
            PreparedStatement pstmt = c.getC().prepareStatement("INSERT INTO Vehiculo VALUES (?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, auto.getPatente());
            pstmt.setInt(2, auto.getKm());
            pstmt.setString(3, auto.getTipo());
            pstmt.setString(4, auto.getMarca());
            pstmt.setInt(5, auto.getModelo());
            if (auto.isServiceAlDia())
                pstmt.setString(6, "T");
            else
                pstmt.setString(6, "F");
            pstmt.setFloat(7, auto.getPrecio());
            pstmt.setInt(8, auto.getTipoConbustible().getId());
            pstmt.setInt(9, 1);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                pstmt = c.getC().prepareStatement("INSERT INTO Camioneta VALUES (?,?,?,?,?,?)");
                pstmt.setInt(1, auto.getId());
                pstmt.setString(2, auto.getDetalle());
                pstmt.setString(3, auto.getPatente());
                rs = pstmt.executeQuery();
            }

            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Boolean modificarAuto(Auto auto) throws SQLException {
        ConectDb c = new ConectDb();
        Statement stmt = c.getC().createStatement();
        String permiso = "F";
        try {
            PreparedStatement pstmt = c.getC().prepareStatement("UPDATE  Vehiculo " +
                    "SET patente = ?, marca=?,modelo=?" +
                    "km = ?, precio=?,servicioAlDia=?" +
                    "WHERE id= ?;");
            pstmt.setString(1, auto.getPatente());
            pstmt.setString(2, auto.getMarca());
            pstmt.setInt(3, auto.getModelo());
            pstmt.setInt(4, auto.getKm());
            pstmt.setFloat(5, auto.getPrecio());
            if (auto.isServiceAlDia())
                pstmt.setString(6, "T");
            else
                pstmt.setString(6, "F");
            int rs = pstmt.executeUpdate();
            if (rs > 0) {
                rs = 0;
                PreparedStatement pstmtCam = c.getC().prepareStatement("UPDATE Camioneta " +
                        "SET detalle = ?" +
                        "WHERE id= ?;");
                pstmt.setString(1, auto.getPatente());
                rs = pstmtCam.executeUpdate();
            }
            return (rs > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}

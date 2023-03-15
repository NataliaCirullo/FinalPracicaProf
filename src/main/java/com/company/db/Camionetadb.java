package com.company.db;

import com.company.bean.Camioneta;
import com.company.bean.TipodeCombustible;
import com.company.bean.Vehiculo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Camionetadb {

    public static String bool = "T";


    public static List< Camioneta > consultarCamionetas() throws SQLException {
        List< Camioneta > camionetas = new ArrayList< Camioneta >();
        ConectDb c = new ConectDb();
        Statement stmt = c.getC().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Camioneta " +
                "inner join Vehiculos on Vehiculos.patente=Camioneta.vehiculos_patente" +
                " inner join Tipocombustible on Vehiculos.idtipocombustiblr=Tipocombustible.id;");
        while (rs.next()) {
            int ide = rs.getInt("id");
            String vehiculos_patente = rs.getString("vehiculos_patente");
            String detalle = rs.getString("detalle");
            PreparedStatement pstmtveic = c.getC().prepareStatement("SELECT * FROM Vehiculo WHERE patente=?;");
            pstmtveic.setString(1, vehiculos_patente);
            rs = pstmtveic.executeQuery();
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
                Camioneta camioneta = new Camioneta(ide, vehiculos_patente, km, tipoComb, modelo, marca, precio, aldia, detalle, tipo);
                camionetas.add(camioneta);
            }
        }
        rs.close();
        stmt.close();
        return camionetas;
    }

    public static Camioneta getCamioneta(Integer id) throws SQLException {
        ConectDb c = new ConectDb();
        Statement stmt = c.getC().createStatement();
        Vehiculo vehiculo;
        try {
            PreparedStatement pstmt = c.getC().prepareStatement("SELECT * FROM Camioneta WHERE id=?;");
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
                    return new Camioneta(ide, vehiculos_patente, km, tipoComb, modelo, marca, precio, aldia, detalle, tipo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static Boolean addCamioneta(Camioneta camioneta) throws SQLException {
        ConectDb c = new ConectDb();
        Statement stmt = c.getC().createStatement();

        try {
            /**  id_sucursal
             **/
            PreparedStatement pstmt = c.getC().prepareStatement("INSERT INTO Vehiculo VALUES (?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, camioneta.getPatente());
            pstmt.setInt(2, camioneta.getKm());
            pstmt.setString(3, camioneta.getTipo());
            pstmt.setString(4, camioneta.getMarca());
            pstmt.setInt(5, camioneta.getModelo());
            if (camioneta.isServiceAlDia())
                pstmt.setString(6, "T");
            else
                pstmt.setString(6, "F");
            pstmt.setFloat(7, camioneta.getPrecio());
            pstmt.setInt(8, camioneta.getTipoConbustible().getId());
            pstmt.setInt(9, 1);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                pstmt = c.getC().prepareStatement("INSERT INTO Camioneta VALUES (?,?,?,?,?,?)");
                pstmt.setInt(1, camioneta.getId());
                pstmt.setString(2, camioneta.getDetalle());
                pstmt.setString(3, camioneta.getPatente());
                rs = pstmt.executeQuery();
            }

            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Boolean modificarCamioneta(Camioneta camioneta) throws SQLException {
        ConectDb c = new ConectDb();
        Statement stmt = c.getC().createStatement();
        String permiso = "F";
        try {
            PreparedStatement pstmt = c.getC().prepareStatement("UPDATE  Vehiculo " +
                    "SET patente = ?, marca=?,modelo=?" +
                    "km = ?, precio=?,servicioAlDia=?" +
                    "WHERE id= ?;");
            pstmt.setString(1, camioneta.getPatente());
            pstmt.setString(2, camioneta.getMarca());
            pstmt.setInt(3, camioneta.getModelo());
            pstmt.setInt(4, camioneta.getKm());
            pstmt.setFloat(5, camioneta.getPrecio());
            if (camioneta.isServiceAlDia())
                pstmt.setString(6, "T");
            else
                pstmt.setString(6, "F");
            int rs = pstmt.executeUpdate();
            if (rs > 0) {
                rs = 0;
                PreparedStatement pstmtCam = c.getC().prepareStatement("UPDATE Camioneta " +
                        "SET detalle = ?" +
                        "WHERE id= ?;");
                pstmt.setString(1, camioneta.getPatente());
                rs = pstmtCam.executeUpdate();
            }
            return (rs > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}

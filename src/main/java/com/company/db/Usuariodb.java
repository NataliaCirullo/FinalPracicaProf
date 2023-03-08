package com.company.db;

import com.company.bean.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Usuariodb {


    public static String bool="T";

    public static List< Usuario > consultarUsuarios() throws SQLException {
        List< Usuario > usuarios = new ArrayList< Usuario >();
        ConectDb c = new ConectDb();
        Statement stmt = c.getC().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM USUARIO;");
        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String clave = rs.getString("clave");
            boolean permiso = bool.equalsIgnoreCase(rs.getString("permiso"));
            Usuario us = new Usuario(id, nombre, clave,permiso);
            usuarios.add(us);
        }
        rs.close();
        stmt.close();
        return usuarios;
    }

    public static Usuario getUsuario(Integer id) throws SQLException {
        ConectDb c = new ConectDb();
        Statement stmt = c.getC().createStatement();
        Usuario usuario;
        try {
            PreparedStatement pstmt = c.getC().prepareStatement("SELECT * FROM usuario WHERE id=?;");
            pstmt.setInt(1, id);
            //los parametros tienen un index 1 id porque es el primero y lleva ?para identifivcar que es un parametro que espera valor
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int ide = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String clave = rs.getString("clave");
                boolean permiso = bool.equalsIgnoreCase(rs.getString("permiso"));
               return (new Usuario(id, nombre, clave,permiso));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Boolean addUsuario(Usuario usuario) throws SQLException {
        ConectDb c = new ConectDb();
        Statement stmt = c.getC().createStatement();
        String petmiso="F";
        if (usuario.getPermisoABM()) petmiso="T";
        try {
            PreparedStatement pstmt = c.getC().prepareStatement("INSERT INTO usuario VALUES (?,?,?,?)");
            pstmt.setInt(1, usuario.getId());
            pstmt.setString(2, usuario.getNombre());
            pstmt.setString(3, usuario.getClave());
            pstmt.setString(4, petmiso);
            //los parametros tienen un index 1 id porque es el primero y lleva ?para identifivcar que es un parametro que espera valor
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Boolean modificarUsuario(Usuario usuario) throws SQLException {
        ConectDb c = new ConectDb();
        Statement stmt = c.getC().createStatement();
        String permiso="F";
        if (usuario.getPermisoABM()) permiso="T";
        try {
            PreparedStatement pstmt = c.getC().prepareStatement("UPDATE  usuario " +
                    "SET nombre = ?, clave=?,permiso=?"  +
                    "WHERE id= ?;");
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getClave());
            pstmt.setString(3, permiso);
            pstmt.setInt(6, usuario.getId());
            //los parametros tienen un index 1 id porque es el primero y lleva ?para identifivcar que es un parametro que espera valor
            int rs = pstmt.executeUpdate();
            return (rs > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Boolean eliminarUsuario(Integer id) throws SQLException {
        ConectDb c = new ConectDb();
        Statement stmt = c.getC().createStatement();

        try {
            PreparedStatement pstmt = c.getC().prepareStatement("DELETE FROM usuario  WHERE id= ?;");
            pstmt.setInt(1, id);
            //los parametros tienen un index 1 id porque es el primero y lleva ?para identifivcar que es un parametro que espera valor
            int rs = pstmt.executeUpdate();
            //retorna la cantidad de registros afectados
            return (rs > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Usuario existeUsuario(String nombre, String clave) throws SQLException {
        ConectDb c = new ConectDb();
        Statement stmt = c.getC().createStatement();
        Usuario usuario;
        try {
            PreparedStatement pstmt = c.getC().prepareStatement("SELECT * FROM usuario WHERE nombre=?and clave=?;");
            pstmt.setString(1, nombre);
            pstmt.setString(2, clave);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int ide = rs.getInt("id");
                boolean permiso = bool.equalsIgnoreCase(rs.getString("permiso"));
                return (new Usuario(ide, nombre, clave,permiso));
            }

        } catch (SQLException e) {
            System.out.println("Error: (" + e.toString()+")");

        }
        return null;
    }
}

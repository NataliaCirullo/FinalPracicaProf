package com.company.db;

import com.company.bean.TipodeCombustible;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TipoCombustibledb {
    public static String bool="T";

    public TipodeCombustible getTipoCombustible(Integer id) throws SQLException {
        ConectDb c = new ConectDb();
        Statement stmt = c.getC().createStatement();
        TipodeCombustible tipodeCombustible;
         try {
            PreparedStatement pstmt = c.getC().prepareStatement("SELECT * FROM TipoCombustible WHERE id=?;");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int ide = rs.getInt("id");
                String tipo = rs.getString("nombre");
                String clave = rs.getString("clave");
                boolean ttienegas= bool.equalsIgnoreCase(rs.getString("permiso"));
                return (new TipodeCombustible(id, tipo, ttienegas));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

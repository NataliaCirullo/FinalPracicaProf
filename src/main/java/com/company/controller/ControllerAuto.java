package com.company.controller;

import com.company.bean.Auto;
import com.company.db.Autodb;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerAuto {

    public ControllerAuto() {
    }

    public Auto consultarAuto(Integer id) throws SQLException {
        return Autodb.getAuto(id);
    }

    public List< Auto > listartarAutos() throws SQLException {
        List< Auto > autos = new ArrayList< Auto >();
        autos = Autodb.consultarAutos();
        return autos;
    }

    public boolean addAuto(Auto auto) throws SQLException {
        return Autodb.addAuto(auto);
    }

    public boolean modificarAuto(Auto auto) throws SQLException {
        return Autodb.modificarAuto(auto);
    }

    public boolean eliminarAuto(Integer id) throws SQLException {
        //return Autodb.eliminarAuto(id);
        return true;
    }


}

package com.company.controller;


import com.company.bean.Camioneta;
import com.company.db.Camionetadb;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerCamioneta {

    public ControllerCamioneta() {
    }

    public Camioneta consultarAuto(Integer id) throws SQLException {
        return Camionetadb.getCamioneta(id);
    }

    public List< Camioneta > listartarCamioneta() throws SQLException {
        List< Camioneta > camionetas = new ArrayList< Camioneta >();
        camionetas = Camionetadb.consultarCamionetas();
        return camionetas;
    }

    public boolean addAuto(Camioneta camioneta) throws SQLException {
        return Camionetadb.addCamioneta(camioneta);
    }

    public boolean modificarCamioneta(Camioneta camioneta) throws SQLException {
        return Camionetadb.modificarCamioneta(camioneta);
    }

    public boolean eliminarCamioneta(Integer id) throws SQLException {
        //return Camionetadb.eliminarCamioneta(id);
        return true;
    }


}

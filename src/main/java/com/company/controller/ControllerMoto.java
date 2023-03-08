package com.company.controller;

import com.company.bean.Camioneta;
import com.company.bean.Moto;
import com.company.db.Motodb;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerMoto {
    public ControllerMoto() {
    }

    public Moto consultarMoto(Integer id) throws SQLException {
        return Motodb.getMoto(id);
    }

    public List< Moto > listartarMotos() throws SQLException {
        List< Moto > motos = new ArrayList< Moto >();
        motos= Motodb.consultarMoto();
        return motos;
    }

    public boolean addMoto(Moto moto) throws SQLException {
        return Motodb.addMoto(moto);
    }

    public boolean modificarCamioneta(Moto moto) throws SQLException {
        return Motodb.modificarMoto(moto);
    }

    public boolean eliminarMoto(Integer id) throws SQLException {
        //return Motodb.eliminarMoto(id);
        return true;
    }


}

package com.company.controller;

import com.company.bean.Usuario;
import com.company.db.Usuariodb;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerUsuario {

    public ControllerUsuario() {
    }

    public Usuario consultarUsuario(Integer id) throws SQLException {
        return Usuariodb.getUsuario(id);
    }

    public List< Usuario > listartarUsuarios() throws SQLException {
        List< Usuario > usuarios = new ArrayList< Usuario >();
        usuarios = Usuariodb.consultarUsuarios();
        return usuarios;
    }

    public boolean addUsuario(Usuario usuario) throws SQLException {
        return Usuariodb.addUsuario(usuario);
    }

    public boolean modificarUsuario(Usuario usuario) throws SQLException {
        return Usuariodb.modificarUsuario(usuario);
    }

    public boolean eliminarUsuario(Integer id) throws SQLException {
        return Usuariodb.eliminarUsuario(id);
    }

    public Usuario existeUsuario(String usser, String contrasenia) throws SQLException {
        return Usuariodb.existeUsuario(usser, contrasenia);
    }
}

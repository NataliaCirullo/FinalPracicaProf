package com.company.controller;

import com.company.bean.Consecionaria;
import com.company.bean.Usuario;

import java.sql.SQLException;
import java.util.Scanner;

public class ControllerLoguin {
    public ControllerLoguin() {

    }

    public void Loguin() throws SQLException {
        ControllerUsuario usuarioServlet = new ControllerUsuario();
        ControllerConcecionaria concecionaria = new ControllerConcecionaria();
        Consecionaria consecionariapoo = new Consecionaria();
        Usuario usu = null;
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("****************MY Concesionaria***************\n");
            System.out.println("****************LOGUIN***************\n");
            System.out.println("USUARIO = ");
            String usser = scan.next();
            System.out.println("CONTRACEÑA = ");
            String contrasenia = scan.next();
            usu = usuarioServlet.existeUsuario(usser, contrasenia);

            System.out.print("\033[H\033[2J");
            System.out.flush();
            if (usu == null) System.out.println(" USUARIO o CONTRACEÑA incorrectas ");

        } while (usu == null);
        concecionaria.menu(usu);
    }
}

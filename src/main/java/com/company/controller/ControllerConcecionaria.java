package com.company.controller;

import com.company.bean.Usuario;
import java.sql.SQLException;
import java.util.Scanner;
/**
 * Crear una base de datos relacional SQL local donde se aloje toda la
 * informacion del sistema como Clientes, Vehiculos, Sucursales, etc.
 *
 * Todos los usuarios pueden realizar búsquedas filtrando por cualquier
 * criterio incluso combinando cualquiera de los mismos. Recuerda que los
 * datos a considerar son:
 * a. kilometraje
 * b. tipo de combustible
 * c. modelo
 * d. marca
 * e. precio
 * f. servicio al día
 * g. categoría (camioneta/auto/motocicleta)
 * */
public class ControllerConcecionaria {


    public void menu(Usuario usuario) throws SQLException {

        Scanner sc = new Scanner(System.in);
        int opcionElegida = 0;

        while (opcionElegida != 8) {
            System.out.println(" Seleccione ");
            System.out.println("1.- Sucursal 1 ");
            System.out.println("2.- Sucursal 2 ");
            System.out.println("3.- Sucursal 3 ");
            System.out.println("4.- Listar datos de Sucursales");
            System.out.println("5.- Listar Autos ");
            System.out.println("6.- Listar Motos ");
            System.out.println("7.- Listar Camionetas ");
            if (usuario==null)
                System.out.println("8.- Loguin ");
            if ((usuario!=null) && (usuario.getPermisoABM()))
                System.out.println("9.-Listar Usuarios ");
            System.out.println("10.- Salir");
            opcionElegida = sc.nextInt();

            switch (opcionElegida) {
                case 1:
                    //Sucursal 1
                    break;
                case 2:
                   // Sucursal 2;
                    break;
                case 3:
                    //3Sucursal 3
                    break;
                case 4:
                    //Sucursales
                    break;
                case 5:
                    ControllerAuto cauto= new ControllerAuto();
                    System.out.println(cauto.listartarAutos());
                    break;
                case 6:
                    ControllerMoto cmoto= new ControllerMoto();
                    System.out.println(cmoto.listartarMotos());
                    break;
                case 7:
                    ControllerCamioneta camioneta= new ControllerCamioneta();
                    System.out.println(camioneta.listartarCamioneta());
                    break;
                case 8:
                    ControllerLoguin servlet = new ControllerLoguin();
                    try {
                        servlet.Loguin();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 9:
                    ControllerUsuario usuario1= new ControllerUsuario();
                    System.out.println(  usuario1.listartarUsuarios());
                    break;
                case 10:
                    break;
                default:
                    System.out.println("Tienes que introducir una opción valida");
            }

        }


    }
}

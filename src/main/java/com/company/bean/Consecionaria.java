package com.company.bean;


import java.util.HashMap;
import java.util.Iterator;

/**
 * hacer procedimiento para cargar veiculo
 * menu usuario  elegir sucursal ,elegir veiculo ,comprar veiculo
 * menu empleado cargar ceiculo a la lista , hacer factura de venta ,sacar auto de la lista
 */
public class Consecionaria {
    private HashMap< String, Sucursal > sucursales = new HashMap< String, Sucursal >();
    private HashMap< String, Vehiculo > vehiculos = new HashMap< String, Vehiculo >();
    private HashMap< String, String > stock = new HashMap< String, String >();
    ;


    //String coinside con String de sucursal


    public Consecionaria() {

    }

    public HashMap< String, Sucursal > getSucursales() {

        return sucursales;
    }

    public void setSucursales(HashMap< String, Sucursal > sucursales) {

        this.sucursales = sucursales;
    }



    public void mostrarDatosDeSucursal(String nombSucursal) {
        System.out.println(sucursales.get(nombSucursal));
    }

}

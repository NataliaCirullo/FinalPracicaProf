package com.company.bean;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Sucursal {
    /**
     * Cada sucursal tendrá su dirección y horarios de
     * atención al público.  El usuario del sistema podrá realizar la búsqueda de
     * vehículos de interés en una sucursal específica o en todas. Cada sucursal
     * tendrá su catálogo de vehículos y en el caso de que un vehículo sea
     * compartido por más de una sucursal no se debe repetir información en el
     * sistema
     */
    private String Domicilio;
    private Time horarioInicio;
    private Time horarioCierre;
    private List<Vehiculo > vehiculos = new ArrayList<>();
    public Sucursal() {
    }

    public Time getHorarioCierre() {

        return horarioCierre;
    }

    public List< Vehiculo > getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List< Vehiculo > vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void setHorarioCierre(Time horarioCierre) {

        this.horarioCierre = horarioCierre;
    }

    public Time getHorarioInicio() {

        return horarioInicio;
    }

    public void setHorarioInicio(Time horarioInicio) {

        this.horarioInicio = horarioInicio;
    }

    public String getDomicilio() {

        return Domicilio;
    }

    public void setDomicilio(String domicilio) {

        Domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "Sucursal{" +
                "Domicilio='" + Domicilio +
                ", horarioInicio=" + horarioInicio +
                ", horarioCierre=" + horarioCierre +

                '}';
    }
}

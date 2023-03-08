package com.company.bean;


/*
    Si el combustible es diesel
    (kilometrajes / años de antigüedad )  / 1000
    Si el combustible es nafta (con o sin GNC)
    (kilometrajes / años de antigüedad )  / 100
*/
public class Camioneta extends Vehiculo {
    private int id;
    private String detalle;
    public Camioneta(int id,String patente, Integer km,
                     TipodeCombustible tipoConbustible,
                     Integer modelo, String marca,
                     float precio, boolean serviceAlDia,String detalle,String tipo) {

        super( patente, km,tipoConbustible,modelo, marca,  precio,serviceAlDia,tipo) ;
        this.id=id;
        this.detalle=detalle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public double nivelDeDesgaste() {
        if (!super.isServiceAlDia()) {
            return (super.getKm() / super.getModelo()) / 1000;
        } else {
            return (super.getKm() / super.getModelo()) / 100;
        }
    }
}
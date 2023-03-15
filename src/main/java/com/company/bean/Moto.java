package com.company.bean;

public class Moto extends Vehiculo {
    /*
   Si el service está al día y tiene menos de 30 mil km
(kilometrajes / años de antigüedad )  / 1000
En caso contrario
(kilometrajes / años de antigüedad )  / 10
*/
    private int id;
    private String detalle;

    public Moto(int id, String patente, Integer km,
                TipodeCombustible tipoConbustible,
                Integer modelo, String marca,
                float precio, boolean serviceAlDia, String detalle, String tipo) {

        super(patente, km, tipoConbustible, modelo, marca, precio, serviceAlDia, tipo);
        this.id = id;
        this.detalle = detalle;
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
            return (super.getKm() / super.getModelo()) / 10;
        }

    }
}

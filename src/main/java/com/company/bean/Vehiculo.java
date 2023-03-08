package com.company.bean;

public abstract class Vehiculo {
    private String patente;
    private String tipo;
    private Integer km;
    private TipodeCombustible tipoConbustible;
    private final Integer modelo;
    private final String marca;
    private float precio;
    private boolean serviceAlDia;

    protected Vehiculo(Integer modelo,String marca) {
        this.modelo = modelo;
        this.marca= marca;
    }

    public Vehiculo(String patente, Integer km,
                    TipodeCombustible tipoConbustible,
                    Integer modelo, String marca, float precio, boolean serviceAlDia,String tipo) {
        this.patente = patente;
        this.km = km;
        this.tipoConbustible = tipoConbustible;
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
        this.serviceAlDia = serviceAlDia;
        this.tipo=tipo;
    }


    public boolean isServiceAlDia() {
        return serviceAlDia;
    }

    public float getPrecio() {
        return precio;
    }

    public Integer getKm() {
        return km;
    }

    public String getMarca() {
        return marca;
    }

    public Integer getModelo() {
        return modelo;
    }

    public TipodeCombustible getTipoConbustible() {
        return tipoConbustible;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setServiceAlDia(boolean serviceAlDia) {
        this.serviceAlDia = serviceAlDia;
    }

    public void setTipoConbustible(TipodeCombustible tipoConbustible) {
        this.tipoConbustible = tipoConbustible;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "patente='" + patente + '\'' +
                ", km=" + km +
                ", tipoConbustible=" + tipoConbustible +
                ", modelo=" + modelo +
                ", marca='" + marca + '\'' +
                ", precio=" + precio +
                ", serviceAlDia=" + serviceAlDia +
                '}';
    }

    public abstract double nivelDeDesgaste();
}

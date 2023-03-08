package com.company.bean;

import java.io.Serializable;

public class Usuario implements Serializable {
    private int id;
    private String nombre;
    private String clave;
    private Boolean permisoABM;

    public Usuario(int id, String nombre, String clave, boolean permiso) {
        this.id = id;
        this.nombre = nombre;
        this.clave= clave;
        this.permisoABM=permiso;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Boolean getPermisoABM() {
        return permisoABM;
    }

    public void setPermisoABM(Boolean permisoABM) {
        this.permisoABM = permisoABM;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", clave='" + clave + '\'' +
                ", permisoABM=" + permisoABM +
                '}';
    }
}

package com.company.bean;

public class TipodeCombustible {
    private int id;
    private String tipo;
    private boolean conGas;

    public TipodeCombustible() {

    }

    public TipodeCombustible(int id,String Tipo,boolean conGas){
        this.id=id;
        this.tipo = tipo;
        this.conGas = conGas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setConGas(boolean conGas) {
        this.conGas = conGas;
    }

    public boolean isConGas() {
        return this.conGas;
    }

    @Override
    public String toString() {
        return "TipodeCombustible" + tipo;
    }
}

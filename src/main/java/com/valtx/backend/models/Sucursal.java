package com.valtx.backend.models;


public class Sucursal {

    private String codigoSucursal;

    private String nombre;

    public Sucursal() {
    }

    public Sucursal(String codigoSucursal, String nombre) {
        this.codigoSucursal = codigoSucursal;
        this.nombre = nombre;
    }

    public String getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(String codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

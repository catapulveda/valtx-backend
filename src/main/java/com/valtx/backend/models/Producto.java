package com.valtx.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Producto {

    @NotBlank(message = "Ingrese el codigo de producto")
    private String codigoProducto;

    @NotBlank(message = "Ingrese el nombre de producto")
    private String nombre;

    @NotBlank(message = "Ingrese el precio de producto")
    @Size(min = 1, max = Integer.MAX_VALUE, message = "El precio debe ser mayor a 0")
    private Double precio;

    public Producto() {
    }

    public Producto(String codigoProducto, String nombre, Double precio) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}

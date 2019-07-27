package com.prueba.prueba_asesoftware.entities;

import java.io.Serializable;

public class Products implements Serializable {

    private String producto;
    private String descripcion;
    private String precio;
    private String img;

    public Products(String producto, String descripcion, String precio, String img) {
        this.producto = producto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.img = img;
    }

    public Products(){

    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
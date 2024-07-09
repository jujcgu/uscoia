package com.agro.uscoia.producto.presentacion;

public class ProductoPresentacion {

    private long id;
    private String nombre;
    private String presentacion;
    private double cantidad;
    private String unidad;
    private String marca;


    public ProductoPresentacion() {
    }

    public ProductoPresentacion(long id, String nombre, String presentacion, double cantidad, String unidad,
            String marca) {
        this.id = id;
        this.nombre = nombre;
        this.presentacion = presentacion;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.marca = marca;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "ProductoPresentacion [id=" + id + ", nombre=" + nombre + ", presentacion=" + presentacion
                + ", cantidad=" + cantidad + ", unidad=" + unidad + ", marca=" + marca + "]";
    }

}

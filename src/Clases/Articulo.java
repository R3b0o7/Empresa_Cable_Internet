package Clases;

import Enumeraciones.Articulos;

public class Articulo {

    /** Parametros **/

    private Enumeraciones.Articulos articulo;
    private int cantidad;
    private double precio;

    /** Constructor **/

    public Articulo(Enumeraciones.Articulos articulo, int cantidad, double precio) {
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    /** Metodos de la clase **/

    public int agregarCantidadArticulos(int cantidad) {
        // Suma la cantidad ingresada a la cantidad de articulos existentes
        this.cantidad += cantidad;
        return this.cantidad;
    }

    /** Getters **/

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public Articulos getArticulo() {
        return articulo;
    }

    /** Setters **/

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}

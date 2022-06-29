package Clases;

public class Articulo {

    /** Parametros **/

    private Enum Articulos;
    private int cantidad;
    private double precio;

    /** Constructor **/

    public Articulo(Enum articulos, int cantidad, double precio) {
        Articulos = articulos;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    /** Getters**/

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    /** Setters **/

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

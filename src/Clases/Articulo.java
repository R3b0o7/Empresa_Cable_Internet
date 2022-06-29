package Clases;

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

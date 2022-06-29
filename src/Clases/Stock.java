package Clases;
import java.util.*;
import Enumeraciones.Articulos;

public class Stock {

    /** Parámetros **/

    private List<Articulo> articulos;

    /** Constructor **/ // Es necesario?

    public Stock(ArrayList<Articulo> stockArticulos) {
        this.stockArticulos = stockArticulos;
    }

    /** Metodos de la clase **/

    public Void agregarArticulo(int catidad, double precio) {
        Scanner cantidad = new Scanner(System.in);
        System.out.println("Cantidad de articulos a agregar:");
        String nuevaCantidad = cantidad.nextLine();

        return null;
    }

    public boolean verificarStock() {
        // TODO implementar
        return false;
    }

}
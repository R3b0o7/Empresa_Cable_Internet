package Clases;
import java.util.*;
import Enumeraciones.Articulos;

public class Stock {

    /** Parámetros **/

    private ArrayList<Articulo> articulos;

    /** Constructor **/ // Es necesario?

    public Stock() {
        this.articulos = new ArrayList<Articulo>();
    }

    /** Metodos de la clase **/

    public Void agregarArticulo(Articulo articulo) {
        articulos.add(articulo);
        return null;
    }

    public boolean verificarStock() {
        // TODO implementar
        return false;
    }

}
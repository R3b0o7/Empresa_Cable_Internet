package Clases;
import java.util.*;
import Enumeraciones.Articulos;

public class Stock {

    /** Parámetros **/

    private ArrayList<Articulo> stockArticulos;

    /** Constructor **/ // Es necesario?

    public Stock(ArrayList<Articulo> stockArticulos) {
        this.stockArticulos = stockArticulos;
    }

    /** Metodos de la clase **/

    public Void agregarArticulo() {
        Scanner articulo = new Scanner(System.in);
        System.out.println("Nombre del Art{iculo nuevo:");
        String articuloNuevo = articulo.nextLine();
        Enumeraciones.Articulos articuloNuevo = Articulos.
        return null;
    }

    public boolean verificarStock() {
        // TODO implementar
        return false;
    }

}
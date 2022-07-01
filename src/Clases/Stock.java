package Clases;
import java.util.*;

public class Stock {

    /** Parámetros **/

    private Collection<Articulo> articulos;

    /** Constructor **/

    public Stock() {
        articulos = new ArrayList<Articulo>();
    }

    /** Metodos de la clase **/

    public void agregarArticulo(Articulo articulo) {          // Agrega un articulo a la lista de articulos
        articulos.add(articulo);
    }

    public boolean verificarStock(Articulo artVerificar) {
        int cantidadActual = 0;                               // variable auxiliar para guardar la cantidad actual de la instancia
        for(Articulo articulo : articulos)                    // recorro los articulos dentro de la lista de articulos
            if(articulo.equals(artVerificar)) {               // si el articulo que estoy recorriendo es igual al que busco
                cantidadActual = articulo.getCantidad();      // asigno a la variable auxiliar la cantidad de la instancia
                if (cantidadActual > 0)                       // si es mayor a 0 hay stock
                    return true;
            }
        return false;
    }

    /** Gettes **/

    public ArrayList<Articulo> getArticulos() {
        return (ArrayList<Articulo>) articulos;
    }

}
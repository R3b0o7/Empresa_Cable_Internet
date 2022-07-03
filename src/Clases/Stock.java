package Clases;
import Enumeraciones.Articulos;

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

    public Articulo getArticulo(Enumeraciones.Articulos nombreArticulo){
        for(Articulo articulo: this.articulos){
            if(articulo.getArticulo().equals(nombreArticulo)){
                return articulo;
            }
        }
        return null;
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

    public boolean hayStockInstalacion(){
        boolean res = true;
        Map<Articulos, Float> materialesInstalacion = new HashMap<Articulos, Float>();
        materialesInstalacion.put(Articulos.Cable, 4.5f);
        materialesInstalacion.put(Articulos.Conector_coaxial_RG6, 6.0f);
        materialesInstalacion.put(Articulos.Decodificador, 1.0f);
        materialesInstalacion.put(Articulos.Modem, 1.0f);
        materialesInstalacion.put(Articulos.Divisor, 1.0f);
        for(Articulo articulo: articulos){
            if(materialesInstalacion.get(articulo.getArticulo()) != null){
                if(articulo.getCantidad() <= materialesInstalacion.get(articulo.getArticulo())){
                    res = false;
                }
            }
        }
        return res;
    }

    /** Gettes **/

    public ArrayList<Articulo> getArticulos() {
        return (ArrayList<Articulo>) articulos;
    }

}
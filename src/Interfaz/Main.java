package Interfaz;

import Clases.Articulo;
import Clases.Compania;
import Enumeraciones.Articulos;

import java.util.ArrayList;

public class Main {

    //instancia controlador, el controlador ya instancia la compania
    public static void main(String[] args) {
        Compania companiaCableInternet = new Compania();
        companiaCableInternet.inicializarBDD();

        //Controlador controlador = new Controlador();

        //ArrayList stock = companiaCableInternet.getStock().getArticulos(); // Devuelve un ArrayList VACIO!!

        for (Object articulo: companiaCableInternet.getStock().getArticulos()){
            articulo.toString();
        }
    }
}
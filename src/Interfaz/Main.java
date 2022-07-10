package Interfaz;

import Clases.Articulo;
import Clases.Compania;
import Enumeraciones.Articulos;

import java.util.ArrayList;

public class Main {

    //instancia controlador, el controlador ya instancia la compania
    public static void main(String[] args) {
        Compania companiaCableInternet = Clases.Compania.getInstance();
//        companiaCableInternet.inicializarBDD();`NO ES NECESARIO, la iniciliza el constructor de Compania

        //Controlador controlador = new Controlador();

        //ArrayList stock = companiaCableInternet.getStock().getArticulos(); // Devuelve un ArrayList VACIO!!

        for (Articulo articulo: companiaCableInternet.getStock().getArticulos()){
            System.out.println(articulo.toString());
        }
    }
}
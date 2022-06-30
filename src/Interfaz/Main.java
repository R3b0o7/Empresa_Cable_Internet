package Interfaz;

import Clases.Compania;

import java.util.ArrayList;

public class Main {

    //instancia controlador, el controlador ya instancia la compania
    public static void main(String[] args) {
        Compania companiaCableInternet = new Compania();

        ArrayList stock = companiaCableInternet.getStock().getArticulos(); // Devuelve un ArrayList VACIO!!

        for (Object articulo: stock){
            articulo.toString();
        }
    }
}
package Interfaz;

import Clases.*;
import Enumeraciones.*;

import java.util.*;
import java.util.function.ToDoubleBiFunction;

public class Controlador {

    private static Controlador instancia;           // Singleton
    private Compania compania;

    private Controlador(){                          // Cuando creo el controlador instancio la compania (contenedor de la BDD)
        compania = new Compania();
        compania.inicializarBDD();                  // Inicializo la base de datos
    }
    public static Controlador getinstancia(){       // si no esta instanciado se instancia
        if(instancia == null)
            instancia = new Controlador();
        return instancia;
    }

    public void actualizarArticulos(){

        /* Ingresa por pantalla cantidad de articulos que quiero agregar al stock */

        Scanner cantidad = new Scanner(System.in);
        System.out.println("Cantidad de articulos a agregar:");
        int nuevaCantidad = cantidad.nextInt();
        //TODO -> TBD

    }

}

package Interfaz;

import Clases.*;
import Enumeraciones.*;
import Excepciones.GenericException;

import java.util.*;
import java.util.function.ToDoubleBiFunction;

public class Controlador {

    private static Controlador instancia;           // Singleton
    private Compania compania;

    public Controlador(){                          // Cuando creo el controlador instancio la compania (contenedor de la BDD)
        compania = Clases.Compania.getInstance();
        //compania.inicializarBDD();                  // Inicializo la base de datos. LA INICIALIZA EL CONSTRUCTOR DE COMPANIA
    }
    public static Controlador getinstancia(){       // si no esta instanciado se instancia
        if(instancia == null)
            instancia = new Controlador();
        return instancia;
    }

    public Compania getCompania() {
        return compania;
    }

    public void actualizarArticulos(Articulo artActualizar){

        // Ingresa por pantalla cantidad de articulos que quiero agregar al stock

        Scanner cantidad = new Scanner(System.in);
        System.out.println("Cantidad de articulos a agregar:");
        int agregarCantidad = cantidad.nextInt();

        // Selecciono un articulo de la lista de stock para usar el metodo "agregarCantidadArticulos" de la clase Articulo
        // Creería que no es necesario el for
        /** for (Articulo articulo : compania.getStock().getArticulos()){
            if (compania.getStock().getArticulos().equals(artActualizar)){ */
                artActualizar.agregarCantidadArticulos(agregarCantidad);
           /** }
        }*/
    }

    public void agendarServicio() throws GenericException{
        int idServicio = 1;

        //determino el tipo de servicio parsarlo al metodo del Tecnico
        String tipoServicio;
        if(compania.getReparacion(idServicio) != null){
            tipoServicio = "REPARACION";
        } else if(compania.getInstalacion(idServicio) != null) {
            tipoServicio = "INSTALACION";
        } else {
            throw new GenericException("El servicio no existe.");
        }
    }

}

package Clases;

import java.util.*;

/** Clase heredada de Usuario **/

public class PerfilAdministrativo extends Usuario {

    /** Constructor

     Parametros heredados:

     @param nombre
     @param nombreUsuario
     @param password

     **/

    public PerfilAdministrativo(String nombre, String nombreUsuario, String password) {
        super(nombre, nombreUsuario, password);
    }

    /** Metodos de la clase **/

    public Factura emitirFactura() {
        // TODO implementar
        return null;
    }

    public void imprimirFactura() {
        // TODO implementar
    }

    public void modificarFactura() {
        // TODO implementar
    }

    public ArrayList<Factura> listarFacturas() {
        // TODO implementar
        return null;
    }

    public void actualizarServicio() {
        // TODO implementar
    }

    /** Metodos heredados **/

    @Override
    public Void login() {
        return super.login();
    }

}
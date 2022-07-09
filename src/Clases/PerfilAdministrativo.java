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

//    public PerfilAdministrativo(String nombre, String nombreUsuario, String password) {
//        super(nombre, nombreUsuario, password);
//    }

    /** Metodos de la clase **/

    public Factura emitirFactura() {
        // elegir un servicio y usar la función generarFactura
        // TODO implementar
        return null;
    }

    public void imprimirFactura(Factura factura) {
        factura.toString();
    }

    public void modificarFactura() {
        // ?? Factura no tiene Setters, y debería poder ser modificada?
        // TODO implementar
    }

    public ArrayList<Factura> listarFacturas() {
        // ciclo for que imprima todos los nros de factura guardados en la compania
        // TODO implementar
        return null;
    }

    public void actualizarServicio() {
        // Usar los setters del Servicio (Faltan)
        // TODO implementar
    }

    /** Metodos heredados **/

    @Override
    public Void login() {
        return super.login();
    }

}
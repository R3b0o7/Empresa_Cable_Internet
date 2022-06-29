package Clases;

import Clases.Tecnico;
import java.util.*;

/** Clase heredada de Usuario **/
public class PerfilCallCenter extends Usuario {


    /** Constructor

     Parametros heredados:

     @param nombre
     @param nombreUsuario
     @param password

     **/

    public PerfilCallCenter(String nombre, String nombreUsuario, String password) {
        super(nombre, nombreUsuario, password);
    }

    /** Metodos de la clase **/

    public Cliente seleccionarCliente(int) {
        // TODO implement here
        return null;
    }

    public Cliente crearCliente() {
        // TODO implement here
        return null;
    }

    public ArrayList<Tecnico> revisarDisponibilidad(Date, int horario,Enum tipoServicio) {
        // TODO implement here
        return null;
    }

    public EnumeraciónTipoServicio crerVisita(Date, int horario, Enum tipoServicio,Cliente cliente) {
        // TODO implement here
        return null;
    }

    /** Metodos heredados **/

    @Override
    public Void login() {
        return super.login();
    }

}
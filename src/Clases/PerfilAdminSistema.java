package Clases;

import java.util.*;

/** Clase heredada de Usuario **/

public class PerfilAdminSistema extends Usuario {

    /** Constructor

     Parametros heredados:

     @param nombre
     @param nombreUsuario
     @param password

     **/

    //public PerfilAdminSistema(String nombre, String nombreUsuario, String password) {
    //    Super(nombre, nombreUsuario, password);
    //}

    /** Metodos de la clase **/

    public Tecnico crearTecnico() {
        // Constructor tecnico y guardarlo en ArrayList<Tecnico> tecnicos de la compania
        // TODO implementar
        return null;
    }

    public Void modificarTecnico() {
        // Setters del tecnico
        // TODO implementar
        return null;
    }

    public Void bajaTecnico() {
        // borrarlo del ArrayList<Tecnico> tecnicos de la compania
        // TODO implementar
        return null;
    }

    public Articulo crearArticulo() {
        // agregarArticulo del Stock de la comania
        // TODO implementar
        return null;
    }

    public Void modificarArticulo() {
        // SetPrecio de Articulo
        // TODO implementar
        return null;
    }

    public Void bajaArticulo() {

        // TODO implementar
        return null;
    }

    public int configurarCostosSeniority() {
        // TODO implementar
        return 0;
    }

    public void confiurarCostoCombustible() {

    }

    public void configurarCostoViaje() {
        // TODO implementar
    }

    /** Metodos heredados **/

    @Override
    public Void login() {
        return super.login();
    }

}
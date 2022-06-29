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

    public PerfilAdminSistema(String nombre, String nombreUsuario, String password) {
        super(nombre, nombreUsuario, password);
    }

    /** Metodos de la clase **/

    public Tecnico crearTecnico(void int, void EnumeraciónTipoTecnico) {
        // TODO implementar
        return null;
    }

    public Void modificarTecnico(void Técnico) {
        // TODO implementar
        return null;
    }

    public Void bajaTecnico(Tecnico) {
        // TODO implementar
    }

    public Articulo crearArticulo(void EneumeraciónArticulos, void int, void double) {
        // TODO implementar
        return null;
    }

    public Void modificarArticulo(void Articulo) {
        // TODO implementar
        return null;
    }

    public Void bajaArticulo(void Articulo) {
        // TODO implementar
        return null;
    }

    public int configurarCostosSeniority(void Técnico) {
        // TODO implementar
        return 0;
    }

    public void confiurarCostoCombustible(void double) {
        // TODO implementar
    }

    public void configurarCostoViaje(void double) {
        // TODO implementar
    }

    /** Metodos heredados **/

    @Override
    public Void login() {
        return super.login();
    }

}
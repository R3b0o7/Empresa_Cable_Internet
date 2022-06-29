package Clases;
import java.util.*;

/** Clase abstracta - superclase **/

public class Usuario {

    /** Parámetros **/

    private String nombre;
    private String nombreUsuario;
    private String password;

    /** Constructor **/

    public Usuario(String nombre, String nombreUsuario, String password) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }

    /** Metodos de la clase **/
    public Void login() { //Persona tiene el mismo metodo
        // TODO implementar
        return null;
    }

}
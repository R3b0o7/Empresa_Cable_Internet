package Clases;
import java.util.*;

/** Clase abstracta - superclase **/

public class Persona {

    /** Atributos **/

    private int dni;
    private String nombreApellido;
    private String dirección;

    /** Constructor **/

    public Persona(int dni, String nombreApellido, String dirección) {
        this.dni = dni;
        this.nombreApellido = nombreApellido;
        this.dirección = dirección;
    }

    /** Getters **/

    public int getDni() {
        return dni;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public String getDirección() {
        return dirección;
    }

    /** Getters **/

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }
}
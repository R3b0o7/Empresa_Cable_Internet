package Clases;
import java.util.*;

/** Clase abstracta - superclase **/

public class Usuario {

    /** Parámetros **/

//    protected String nombre;
//    protected String nombreUsuario;
//    protected String password;

//    /** Constructor **/
//
//    public Usuario(String nombre, String nombreUsuario, String password) {
//        this.nombre = nombre;
//        this.nombreUsuario = nombreUsuario;
//        this.password = password;
//    }
    private Compania compania;

    /** Metodos de la clase **/
    public Void login() {
        // TODO implementar
        return null;
    }
    public void menuInicial(){
        //Genero los objetos base

    }

    public void imprimirMenuInicial() {
    }

    public void imprimirEncabezado(String[] menu) {
        System.out.println("");
        System.out.println("");
        for(int i = 0; i < menu.length; i++ ) {
            System.out.print(menu[i]);
            if(i == menu.length-1) {
                break;
            }
            System.out.print(" > ");
        }
        System.out.print("\n");
        System.out.println("##################################");
    }
}
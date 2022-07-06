package Clases;
import java.util.*;

/** Clase heredada de Usuario **/
public class PerfilTecnico extends Usuario {

    private Tecnico tecnico;

    /** Constructor

     Parametros heredados:

     @param nombre
     @param nombreUsuario
     @param password

     **/

    //public PerfilTecnico(String nombre, String nombreUsuario, String password, Tecnico tecnico) {
    //    super(nombre, nombreUsuario, password);
    //    this.tecnico = tecnico;
    //}

    /** Metodos de la clase **/

    public PerfilTecnico PerfilTécnico() {
        // TODO implementar
        return null;
    }

    public ArrayList<?> serviciosAsignados() { //Tengo que sacar el array list de servicios de la compañia
        // TODO implementar
        return null;
    }

    public Void cargarDatoServicio() {
        // TODO implementar
        return null;
    }

    /** Metodos heredados **/

    @Override
    public Void login() {
        return super.login();
    }

}
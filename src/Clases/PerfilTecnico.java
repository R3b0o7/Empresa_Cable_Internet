package Clases;
import java.util.*;

public class PerfilTecnico extends Usuario {

    private Tecnico tecnico;

    /** Constructor

     Parametros heredados:

     @param nombre
     @param nombreUsuario
     @param password

     **/

    public PerfilTecnico(String nombre, String nombreUsuario, String password, Tecnico tecnico) {
        super(nombre, nombreUsuario, password);
        this.tecnico = tecnico;
    }

    /** Metodos de la clase **/

    public PerfilTecnico PerfilTécnico(String, String, String) {
        // TODO implementar
        return null;
    }

    public ArrayList<Servicio> serviciosAsignados() {
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
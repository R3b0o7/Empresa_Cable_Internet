package Clases;
import Clases.Persona;
import java.util.*;
import java.util.Date;

public class Cliente extends Persona {

    /** Parametros **/
    private Agenda agenda;

    /** Constructor

     Parametros heredados:

     @param dni
     @param nombreApellido
     @param dirección

     **/

    public Cliente(int dni, String nombreApellido, String dirección, Agenda agenda) {
        super(dni, nombreApellido, dirección);
        this.agenda = agenda;
    }


    /** Metodos **/

    public void agendarServicio(void Date, void int, void int) {
        // TODO implementar
        return null;
    }

    /** Metodos heredados **/

    @Override
    public void login() {
        super.login();
    }

    @Override
    public int getDni() {
        return super.getDni();
    }

    @Override
    public String getNombreApellido() {
        return super.getNombreApellido();
    }

    @Override
    public String getDirección() {
        return super.getDirección();
    }
}
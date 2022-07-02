package Test;

import Clases.Compania;
import Clases.Tecnico;
import Enumeraciones.TipoTecnico;
import Excepciones.GenericException;

import java.util.Calendar;
import java.util.Date;

public class TestTecnico {

    public static void main(String[] args) {

        Compania compania = Clases.Compania.getInstance();

        Tecnico t = compania.getTecnicos().get(0);
        Date fecha = new Date();
        String horario = "19:00";
        String tipoServicio = "REPARACION";
        int idServicio = 1;

        try{
            t.agendarServicio(fecha, horario,1, tipoServicio);
        } catch (GenericException exc){
            System.out.println("no se pudo agendar el servicio");
        }

        fecha = new Date();
        horario = "18:00";
        tipoServicio = "INSTALACION";

        try{
            boolean b = t.poseeDisponibilidad(fecha, horario, tipoServicio);
            System.out.println(b);
        } catch(GenericException exc){
            System.out.println("error");
        }

    }
}

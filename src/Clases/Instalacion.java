package Clases;

import Enumeraciones.Articulos;

import java.util.ArrayList;
import java.util.Date;

/** Clase heredada de Servicio **/

public class Instalacion extends Servicio {

    /**
     * Constructor
     * Parametros heredados:
     *
     * @param idServicio
     * @param fecha
     * @param horario
     * @param tecnicos
     * @param cliente
     **/
    public Instalacion(int idServicio, Date fecha, String horario, ArrayList<Tecnico> tecnicos, Cliente cliente) {

        super(idServicio, fecha, horario, tecnicos, cliente);

        //establezco los materiales básicos
        Articulo cable = new Articulo(Articulos.Cable, 5, 0.0d);
        Articulo conector = new Articulo(Articulos.Conector_coaxial_RG6, 6, 0.0d);
        Articulo decodificador = new Articulo(Articulos.Decodificador , 1, 0.0d);
        Articulo modem = new Articulo(Articulos.Modem , 1, 0.0d);
        Articulo divisor = new Articulo(Articulos.Divisor , 1, 0.0d);
        this.materiales.add(cable);
        this.materiales.add(conector);
        this.materiales.add(decodificador);
        this.materiales.add(modem);
        this.materiales.add(divisor);

        this.tiempoTrabajado = 1.0d;
    }

}
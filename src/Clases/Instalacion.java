package Clases;

import Enumeraciones.Articulos;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

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
    public Instalacion(int idServicio, Date fecha, String horario, ArrayList<Tecnico> tecnicos, Cliente cliente, Stock stock) {

        super(idServicio, fecha, horario, tecnicos, cliente);
        this.tiempoTrabajado = new HashMap<Integer, Float>();
        for(Tecnico tecnico: tecnicos){
            tiempoTrabajado.put(tecnico.getNroTécnico(), 1.0f);
        }
        this.setMaterialesBasicos(stock);
    }

    public void setMaterialesBasicos(Stock stock){
        //establezco los materiales básicos
        Articulo cable = new Articulo(Articulos.Cable, 5, stock.getArticulo(Articulos.Cable).getPrecio());
        Articulo conector = new Articulo(Articulos.Conector_coaxial_RG6, 6, stock.getArticulo(Articulos.Conector_coaxial_RG6).getPrecio());
        Articulo decodificador = new Articulo(Articulos.Decodificador , 1, stock.getArticulo(Articulos.Decodificador).getPrecio());
        Articulo modem = new Articulo(Articulos.Modem , 1, stock.getArticulo(Articulos.Modem).getPrecio());
        Articulo divisor = new Articulo(Articulos.Divisor , 1, stock.getArticulo(Articulos.Divisor).getPrecio());
        this.materiales.add(cable);
        this.materiales.add(conector);
        this.materiales.add(decodificador);
        this.materiales.add(modem);
        this.materiales.add(divisor);
    }

    public String toString() {
        return "Instalacion{" +
                "idServicio=" + idServicio +
                ", fecha=" + fecha +
                ", horario='" + horario + '\'' +
                ", tecnicos=" + tecnicos +
                ", cliente=" + cliente +
                "} ";
    }

}
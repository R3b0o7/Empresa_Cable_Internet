package Clases;

import Enumeraciones.Articulos;
import Enumeraciones.TipoServicio;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
        this.tipoServicio = TipoServicio.Instalación;
        this.tiempoTrabajado = new HashMap<Integer, Double>();
        for(Tecnico tecnico: tecnicos){
            tiempoTrabajado.put(tecnico.getNroTécnico(), 1.0);
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

    //Getters
    public ArrayList<Tecnico> getTecnicos(){
        return this.tecnicos;
    }

    public String toString() {
        String tecnicosStr = "";
        for(Tecnico tec: this.tecnicos){
            tecnicosStr += "id-"+ tec.getNroTécnico()+" ";
        }
        return "Instalacion - " +
                "idServicio=" + idServicio +
                " - Fecha=" + this.getFecha() +
                " - Horario='" + horario + '\'' +
                " - Tecnicos=" + tecnicosStr +
                " - Estado=" + estado +
                " - Cliente=" + cliente.getNombreApellido() +
                "} ";
    }

    public String toStringDetalle() {
        String tecnicosStr = "";
        for(Tecnico tec: this.tecnicos){
            tecnicosStr += "id-"+ tec.getNroTécnico()+" ";
        }
        String articulosStr = "";
        for(Articulo art: this.materiales){
            articulosStr += art.getArticulo()+" ";
        }
        return "Instalacion - " +
                "idServicio=" + idServicio +
                " - tecnicos=" + tecnicosStr +
                " - cliente=" + cliente +
                " - Estado=" + estado +
                " - Materiales=" + articulosStr +
                " - Costo Materiales adicionales= $" + costoMaterialesAdicionales +
                " - Almuerzo=" + almuerzo +
                " - Combustible= " + combustible +
                " - Costo Real= $" + costoReal +
                " - Bonificacion= "+ bonificacion*100 + "%" +
                " - Precio Real= $"+ precioFinal +
                " - Gastos= $" + gastos +
                "} ";
    }

}
package Controladores;

import Clases.*;
import Enumeraciones.Articulos;
import Enumeraciones.TipoTecnico;
import Excepciones.GenericException;

import javax.swing.*;
import java.util.*;

public class ControllerAdministrador{

    static Scanner sc = new Scanner(System.in);
    private Compania compania;
    private static ControllerAdministrador controladorAdministrador;

    private ControllerAdministrador(){
        this.compania = Compania.getInstance();
    }

    public static ControllerAdministrador getInstance(){
        if(controladorAdministrador == null){
            controladorAdministrador = new ControllerAdministrador();
        }
        return controladorAdministrador;
    }

    public DefaultListModel<String> listModelTecnico(){
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        int i = 0;
        for(Tecnico tec: compania.getTecnicos()){
            if(tec.getEstado()){
                listModel.add(i,+tec.getNroTécnico()
                        + " - Nombre: " + tec.getNombreApellido()
                        + " - Seniority: " + tec.getTipoTecnico()
                        + " - Turno: " + tec.getTurno());
                        //+ " - Estado: " + tec.getEstado()
                i++;
            }
        }
        return listModel;
    }

    public DefaultListModel<String> listModelArticulo(){
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        int i = 0;
        for(Articulo art: compania.getStock().getStockArticulos()){
            listModel.add(i,i+1+". " + art.getArticulo() + ": " + art.getCantidad() + " articulos " + "(" +  art.getPrecio() + "$)");
            i++;
        }
        return listModel;
    }

    public void darDeBajaTecnico(int id){
        for (Tecnico tec : compania.getTecnicos()){
            if (tec.getNroTécnico() == id && tec.getEstado() == true){
                compania.getTecnico(id).setEstado(false);
                System.out.println("El Técnico Nro " + id + " fué dado de baja de manera exitosa.");
                JOptionPane.showMessageDialog(null, "El Técnico Nro "+ id + " fué dado de baja de manera exitosa.");
                System.out.println();
            }
        }
    }

    public void darDeAltaTecnico(int dni, String nombre, String direccion, TipoTecnico tipoTecnico,String turno){
        if (this.compania.getTecnicoDNI(dni) != null) {
            JOptionPane.showMessageDialog(null, "El técnico ya existe");
            return;
        }
        else{
            compania.guardarTecnico(new Tecnico(dni, nombre, direccion, tipoTecnico, turno ));
        }

    }

    public void modificarTecnico(int id, TipoTecnico tipoTecnico,String turno){
        for(Tecnico tecnico: compania.getTecnicos()){
            if(tecnico.getNroTécnico()==id){
                tecnico.setTipoTecnico(tipoTecnico);
                tecnico.setTurno(turno);
            }
        }
    }

    public String[] listadoArticulosToCombo(){
        String[] listado = new String[20];
        int i = 0;
        for(Articulo art: compania.getStock().getStockArticulos()){
            listado[i] = art.getArticulo().toString();
            i++;
        }
        return listado;
    }

    public void altaDeStock(Enumeraciones.Articulos articulo, int cantidad){
        for(Articulo art: compania.getStock().getStockArticulos()){
            if(art.getArticulo().equals(articulo)){
                art.agregarCantidadArticulos(cantidad);
            }
        }
    }

    public void bajaDeStock(Enumeraciones.Articulos articulo, int cantidad) throws GenericException{
        for (Articulo art : compania.getStock().getStockArticulos()) {
            if (art.getArticulo().equals(articulo)) {
                if(art.getCantidad() >= cantidad) {
                    art.agregarCantidadArticulos(cantidad * -1);
                } else {
                    throw new GenericException("El valor ingresado supera el stock existente.");
                }
            }
        }
    }

    public boolean existeTecnico(int id){
        for(Tecnico tec: compania.getTecnicos()){
            if(tec.getNroTécnico()==id){
                return true;
            }
        }
        return false;
    }

    public void modificarPrecioArticulo(Articulos articulo, Double precio){
        for (Articulo art : compania.getStock().getStockArticulos()) {
            if (art.getArticulo().equals(articulo)) {
                art.setPrecio(precio);
            }
        }
    }
}

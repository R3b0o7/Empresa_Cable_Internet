package Controladores;

import Clases.*;
import Enumeraciones.Estado;
import Excepciones.GenericException;

import javax.swing.*;
import java.util.*;

public class ControllerCallCenter{

    static Scanner sc = new Scanner(System.in);
    private Compania compania;
    private static ControllerCallCenter controladorCallCenter;
    private Cliente clienteSeleccionado;
    ArrayList<Tecnico> tecnicosDisponibles;
    ArrayList<Integer> idTecnicosDisponibles;
    ArrayList<Tecnico> tecnicosSeleccionados;
    ArrayList<Integer> idTecnicosSeleccionados;
    Reparacion reparacionPreliminar;
    Instalacion instalacionPreliminar;

   private ControllerCallCenter(){

       compania = Compania.getInstance();
       tecnicosDisponibles = new ArrayList<Tecnico>();
       tecnicosSeleccionados = new ArrayList<Tecnico>();
       idTecnicosDisponibles = new ArrayList<Integer>();
   }

    public static ControllerCallCenter getInstance(){
        if(controladorCallCenter == null){
            controladorCallCenter = new ControllerCallCenter();
        }
        return controladorCallCenter;
    }

    public ListModel<String> listModelCliente(int dni){
        Cliente cliente = compania.getCliente(dni);
        clienteSeleccionado = cliente;
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        listModel.add(0,
                "DNI: "+cliente.getDni()
                +" - Nombre: "+ cliente.getNombreApellido()
                +"- Dirección: " + cliente.getDirección()
                );
        return listModel;
    }

    public ListModel<String> listModelClientes(){
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        int i = 0;
       for(Cliente cliente: compania.getClientes()) {
           listModel.add(i,
                   "DNI: " + cliente.getDni()
                           + " - Nombre: " + cliente.getNombreApellido()
                           + "- Dirección: " + cliente.getDirección()
           );
       }
        return listModel;
    }

    public DefaultListModel<String> listModelTecnicosDisponibles(String turnoStr, Date fecha, String horarioStr, String tiposervicioStr) throws GenericException{
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        int i = 0;
        try {
            for (Tecnico tecnico : compania.getTecnicos()) {
                if(tecnicosDisponibles.contains(tecnico) && !tecnico.getTurno().equals(turnoStr)){
                    tecnicosDisponibles.remove(tecnico);
                }
                if (tecnico.getTurno().equals(turnoStr) && tecnico.poseeDisponibilidad(fecha, horarioStr, tiposervicioStr) && tecnico.getEstado()) {
                    if (!tecnicosSeleccionados.contains(tecnico) && !tecnicosDisponibles.contains(tecnico)){
                        tecnicosDisponibles.add(tecnico);
                        idTecnicosDisponibles.add(tecnico.getNroTécnico());
                    }
                }
            }
        } catch (GenericException exc) {
            System.out.println(exc);
        }
        for(Tecnico tec: tecnicosDisponibles){
            listModel.add(i,+tec.getNroTécnico()
                    + " - Nombre: " + tec.getNombreApellido()
                    + " - Seniority: " + tec.getTipoTecnico()
                    + " - Estado: " + tec.getEstado()
            );
            i++;
        }
        return listModel;
    }

    public ListModel<String> listModelTecnicosSeleccionados(){
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        int i = 0;
        for(Tecnico tec: tecnicosSeleccionados){
            listModel.add(i,+tec.getNroTécnico()
                    + " - Nombre: " + tec.getNombreApellido()
                    + " - Seniority: " + tec.getTipoTecnico()
                    + " - Estado: " + tec.getEstado()
            );
            i++;
        }
        return listModel;
    }

    public ListModel<String> listModelServicios(int opcion){
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        switch(opcion) {
            case 0:
                int i = 0;
                for (Reparacion reparacion : compania.getReparaciones()) {
                    if (reparacion.getEstado() == Estado.Programado) {
                        listModel.add(i, reparacion.toString());
                        i++;
                    }
                }
                i = 0;
                for (Instalacion instalacion : compania.getInstalaciones()) {
                    if (instalacion.getEstado() == Estado.Programado) {
                        listModel.add(i, instalacion.toString());
                        i++;
                    }
                }
                break;
            case 3:
                i = 0;
                for (Reparacion reparacion : compania.getReparaciones()) {
                    if (reparacion.getEstado() == Estado.Finalizada) {
                        listModel.add(i, reparacion.toStringDetalle());
                        i++;
                    }
                }
                i = 0;
                for (Instalacion instalacion : compania.getInstalaciones()) {
                    if (instalacion.getEstado() == Estado.Finalizada) {
                        listModel.add(i, instalacion.toStringDetalle());
                        i++;
                    }
                }
                break;
        }
        return listModel;
    }

    public void seleccionarTecnico(int nroTecnico){
        for (Tecnico tecnico : tecnicosDisponibles) {
            if (tecnico.getNroTécnico() == nroTecnico) {
                tecnicosSeleccionados.add(tecnico);
            }
        }
        for(Tecnico tecnico: tecnicosSeleccionados){
            if (tecnico.getNroTécnico() == nroTecnico) {
                tecnicosDisponibles.remove(tecnico);
            }
        }
    }

    public double obtenerPrecioInicialServicio(Date fecha, String horarioStr, String tipoServicioStr){
        Reparacion servicioR = null;
        Instalacion servicioI = null;
        Double costoBase;
       if(tipoServicioStr.equals("REPARACION")){
            servicioR = new Reparacion(compania.getUltimoServicio()+1, fecha, horarioStr, tecnicosSeleccionados, clienteSeleccionado);
            costoBase = servicioR.calcularPrecioBase(compania);
            reparacionPreliminar = servicioR;
            instalacionPreliminar = null;
        } else {
            servicioI = new Instalacion(compania.getUltimoServicio()+1, fecha, horarioStr, tecnicosSeleccionados, clienteSeleccionado, compania.getStock());
            costoBase = servicioI.calcularPrecioBase(compania);
            instalacionPreliminar = servicioI;
           System.out.println(instalacionPreliminar.getFecha());
            reparacionPreliminar = null;
        }
       return costoBase;
    }

    public void guardarServicio() throws Exception{
        //despliego los cambios asociados a la generacion del servicio
        // agrego el servicio a la base de datos
        if(instalacionPreliminar != null &&  !compania.getStock().hayStockInstalacion()){
            JOptionPane.showMessageDialog(null, "No existe suficiente stock de materiales. El servicio se creará pero recuerde solicitar la reposición.", "Atención!!",
                    JOptionPane.WARNING_MESSAGE);
        }
        if(reparacionPreliminar != null){
            //almaceno el servicio
            compania.guardarReparacion(reparacionPreliminar);

            //incremento el id servicio
            compania.incrementarUltimoServicio();

            //Agendo en el tecnico el servicio
            try {
                for (Tecnico tecnico : tecnicosSeleccionados) {
                    tecnico.agendarServicio(reparacionPreliminar.getFecha(), reparacionPreliminar.getHora(), reparacionPreliminar.getIdServicio(), reparacionPreliminar.getTipoServicio().toString());
                }
            } catch(Exception exc){
                throw new Exception("Error al agendar el servicio");
            }

            //Agendo en el cliente el servicio
            try{
                clienteSeleccionado.agendarServicio(reparacionPreliminar.getFecha(), reparacionPreliminar.getHora(), reparacionPreliminar.getIdServicio(), reparacionPreliminar.getTipoServicio().toString());
            } catch (GenericException exc) {
                throw new Exception("Error al agendar el servicio al cliente.");
            }
            JOptionPane.showMessageDialog(null, "Se creó correctamente el servicio n° "+reparacionPreliminar.getIdServicio());

        } else if(instalacionPreliminar != null) {
            //almaceno el servicio
            compania.guardarInstalacion(instalacionPreliminar);

            //incremento el id servicio
            compania.incrementarUltimoServicio();

            //Agendo en el tecnico el servicio
            try {
                for (Tecnico tecnico : tecnicosSeleccionados) {
                    tecnico.agendarServicio(instalacionPreliminar.getFecha(), instalacionPreliminar.getHora(), instalacionPreliminar.getIdServicio(), instalacionPreliminar.getTipoServicio().toString());
                }
            } catch (GenericException exc) {
                throw new Exception("Error al agendar el servicio al técnico.");
            }

            //Agendo en el cliente el servicio
            try {
                clienteSeleccionado.agendarServicio(instalacionPreliminar.getFecha(), instalacionPreliminar.getHora(), instalacionPreliminar.getIdServicio(), instalacionPreliminar.getTipoServicio().toString());
            } catch (GenericException exc) {
                throw new Exception("Error al agendar el servicio al cliente.");
            }

            JOptionPane.showMessageDialog(null, "Se creó correctamente el servicio n° "+instalacionPreliminar.getIdServicio());

        } else {
            throw new Exception("No se cuenta con datos preliminares del servicio");
        }
    }

    public void reiniciarListadoTecnicos(){
       tecnicosDisponibles = new ArrayList<Tecnico>();
       tecnicosSeleccionados = new ArrayList<Tecnico>();
    }

    public Cliente getClienteSeleccionado(){
       return clienteSeleccionado;
    }

    public int validarClienteConReserva(int dni){
       int res = 0;
        if (compania.getReparacionVigentePorCliente(dni) != null) {
            Reparacion reparacion = compania.getReparacionVigentePorCliente(dni);
            return reparacion.getIdServicio();
        } else if (compania.getInstalacionVigentePorCliente(dni) != null) {
            Instalacion instalacion = compania.getInstalacionVigentePorCliente(dni);
            return instalacion.getIdServicio();
        }
        return res;
    }


    public void altaCliente(int dni, String nombre, String direccion ){
        Cliente cliente = new Cliente(dni, nombre, direccion);
        compania.guardarCliente(cliente);
    }

}

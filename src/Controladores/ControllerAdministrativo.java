package Controladores;

import Clases.*;
import Enumeraciones.Estado;
import Enumeraciones.TipoServicio;
import Enumeraciones.TipoTecnico;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class ControllerAdministrativo{

    static Scanner sc = new Scanner(System.in);
    private Compania compania;
    private static ControllerAdministrativo controladorAdministrativo;
    private Reparacion reparacionSeleccionada;
    private Instalacion instalacionSeleccionada;
    private String printFactura;
    private  Factura facturaSeleccionada;

    private ControllerAdministrativo() {
        //Genero los objetos base
        this.compania = Clases.Compania.getInstance();

        this.reparacionSeleccionada = null;
        this.instalacionSeleccionada = null;

        //Genero datos de prueba
        Clases.Cliente cliente999 = new Cliente(12345, "Juan", "salta");
        Clases.Cliente cliente888 = new Cliente(1234, "Juan", "salta");
        compania.guardarCliente(cliente888);
        compania.guardarCliente(cliente999);

        int idServicio1 = compania.getUltimoServicio()+1;
        Clases.Tecnico tecnico999 = new Tecnico(123, "Gonzalo", "salta", TipoTecnico.Junior, "Tarde");
        ArrayList<Tecnico> tecnicosPrueba = new ArrayList<Tecnico>();
        tecnicosPrueba.add(tecnico999);
        Reparacion reparacion = new Reparacion(idServicio1, new Date(), "9:00", tecnicosPrueba, cliente999);
        compania.incrementarUltimoServicio();
        reparacion.finalizarServicio();
        compania.guardarReparacion(reparacion);

        int idServicio2 = compania.getUltimoServicio()+1;
        Clases.Tecnico tecnico888 = new Tecnico(1234, "Gonzalo", "salta", TipoTecnico.Senior, "Tarde");
        ArrayList<Tecnico> tecnicosPrueba2 = new ArrayList<Tecnico>();
        tecnicosPrueba2.add(tecnico888);
        Instalacion instalacion = new Instalacion(idServicio2, new Date(), "9:00", tecnicosPrueba2, cliente888, compania.getStock());
        compania.incrementarUltimoServicio();
        instalacion.finalizarServicio();
        compania.guardarInstalacion(instalacion);
    }

    public static ControllerAdministrativo getInstance(){
        if(controladorAdministrativo == null){
            controladorAdministrativo = new ControllerAdministrativo();
        }
        return controladorAdministrativo;
    }

    public void setServicioSeleccionado(int idServicio){
        instalacionSeleccionada = null;
        reparacionSeleccionada = null;
        if(compania.getInstalacion(idServicio) != null){
            instalacionSeleccionada = compania.getInstalacion(idServicio);
            System.out.println("instalacion "+instalacionSeleccionada.toString());
        } else {
            reparacionSeleccionada = compania.getReparacion(idServicio);
            System.out.println("reparacion "+reparacionSeleccionada.toString());
        }
    }

    public void setFacturaSeleccionada(int nroFactura) {
        facturaSeleccionada = null;
        for (Factura fac : compania.getFacturas()){
            if (fac.getNroFactura()==nroFactura) {
                facturaSeleccionada = fac;
            }
        }
    }

    public String getDetalleFacturaSeleccioanda(){
        if(facturaSeleccionada!=null){
            return facturaSeleccionada.imprimirFactura();
        } else {
            return "Vacío";
        }
    }

    public ListModel<Integer> listModelFacturas(){
        DefaultListModel<Integer> listModel = new DefaultListModel<Integer>();
        int i = 0;
        for(Factura fac: compania.getFacturas()){
            listModel.add(i, fac.getNroFactura());
        }
        facturaSeleccionada = null;
        return listModel;
    }


    public ListModel<Integer> listModelServiciosFinalizados(){
        DefaultListModel<Integer> listModel = new DefaultListModel<Integer>();
        int i = 0;
        for(Reparacion rep: compania.getReparaciones()){
            if(rep.getFactura()  == null && rep.getEstado()==Estado.Finalizada){
                listModel.add(i, rep.getIdServicio());
            }
        }
        i = 0;
        for(Instalacion inst: compania.getInstalaciones()){
            if(inst.getFactura()  == null && inst.getEstado()==Estado.Finalizada){
                listModel.add(i, inst.getIdServicio());
            }
        }
        reparacionSeleccionada = null;
        instalacionSeleccionada = null;
        return listModel;
    }

    public int facturar() throws Exception{
        printFactura = "";
        if(instalacionSeleccionada!=null && instalacionSeleccionada.getFactura() == null){
            instalacionSeleccionada.facturar();
            printFactura = instalacionSeleccionada.getFactura().imprimirFactura();
            this.compania.guardarFactura(instalacionSeleccionada.getFactura());
            return instalacionSeleccionada.getFactura().getNroFactura();
        } else if (reparacionSeleccionada!=null && reparacionSeleccionada.getFactura()==null) {
            reparacionSeleccionada.facturar();
            printFactura = reparacionSeleccionada.getFactura().imprimirFactura();
            this.compania.guardarFactura(reparacionSeleccionada.getFactura());
            return reparacionSeleccionada.getFactura().getNroFactura();
        } else {
            throw new Exception("El servicio ya se encuentra facturado");
        }
    }

    public String getPrintFactura(){
        return printFactura;
    }

    public void imprimirFactura(int nroFactura){
        for(Factura fac: compania.getFacturas()){
            if(fac.getNroFactura()==nroFactura) {
                if(fac.getEmitida()){
                    JOptionPane.showMessageDialog(null, "Factura ya emitida.");
                    return;
                } else {
                    fac.setEmitida(true);
                    printFactura = fac.imprimirFactura();
                    JFrame pdf = new JFrame();
                    //Encabezado Ventana
                    pdf.setTitle("FACTURA");
                    pdf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    pdf.setLayout(new FlowLayout());
                    JPanel panel = new JPanel();
                    panel.setBackground(new Color(255,255,255));
                    JTextArea texar = new JTextArea();
                    texar.setText(printFactura);
                    panel.add(texar);
                    pdf.add(panel);

                    pdf.setSize(615,400);
                    pdf.setLocation(652,340);
                    pdf.setResizable(false);      //Evitar que la ventana pueda ser cambiada de tamaño
                    pdf.setVisible(true);        //Hace el frame visible

                    printFactura = "";
                }
            }
        }



    }

    public String getDetalleServicioSeleccionado(){
        if(reparacionSeleccionada!=null){
            return reparacionSeleccionada.toStringDetalle();
        } else if(instalacionSeleccionada!=null) {
            return instalacionSeleccionada.toStringDetalle();
        }
        return "Sin info";
    }

    public boolean verificarSeleccion(){
        return (reparacionSeleccionada != null || instalacionSeleccionada != null);
    }

    public void actualizarCostoMatAd(Double costo){
        if(reparacionSeleccionada!= null){
            reparacionSeleccionada.setCostoMaterialesAdicionales(costo);
        } else {
            instalacionSeleccionada.setCostoMaterialesAdicionales(costo);
        }
    }

    public void actualizarCombustible(Double combustible){
        if(reparacionSeleccionada!= null){
            reparacionSeleccionada.setCombustible(combustible);
        } else {
            instalacionSeleccionada.setCombustible(combustible);
        }
    }

    public void actualizarAlmuerzo(boolean valor){
        if(reparacionSeleccionada!= null){
            reparacionSeleccionada.setAlmuerzo(valor);
        } else {
            instalacionSeleccionada.setAlmuerzo(valor);
        }
    }

    public void aplicarBonificacion(float bon){
        if(reparacionSeleccionada!= null){
            reparacionSeleccionada.setPrecioFinal(reparacionSeleccionada.getPrecioFinal() - reparacionSeleccionada.getPrecioFinal()*bon);
            reparacionSeleccionada.setBonificacion(bon);
        } else {
            instalacionSeleccionada.setPrecioFinal(instalacionSeleccionada.getPrecioFinal() - instalacionSeleccionada.getPrecioFinal()*bon);
            instalacionSeleccionada.setBonificacion(bon);
        }
    }
}

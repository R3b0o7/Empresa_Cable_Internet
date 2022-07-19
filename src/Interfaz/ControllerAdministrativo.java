package Interfaz;

import Clases.*;
import Enumeraciones.Estado;
import Enumeraciones.TipoServicio;
import Enumeraciones.TipoTecnico;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class ControllerAdministrativo extends Usuario {

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

    //############################################################################################3
    //############################################################################################3
    //############################################################################################3
    //############################################################################################3
    //############################################################################################3
    //############################################################################################3
    //############################################################################################3

    public void menuInicial() {
        // TODO Auto-generated method stub


        //ejecución menu principal
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while (run) {
            this.imprimirMenuInicial();
            int opcion = sc.nextInt();
            switch(opcion) {
                case 1:
                    this.listarFacturas();
                    break;
                case 2:
                    this.menuModificarServicio();
                    break;
                case 3:
                    this.generarFactura();
                    break;
                case 0:
                    run = false;
                    break;
            }
        }
    }

    public void imprimirMenuInicial() {
        String[] menu = {"EMPRESA DE CABLE"};
        imprimirEncabezado(menu);
        System.out.println("1. Listar facturas");
        System.out.println("2. Modificar servicio");
        System.out.println("3. Generar factura");
        System.out.println("0. Salir");
        System.out.print("Elija una opción: ");
    }

    public void imprimirEncabezado(String[] menu) {
        System.out.println("");
        System.out.println("");
        for(int i = 0; i < menu.length; i++ ) {
            System.out.print(menu[i]);
            if(i == menu.length-1) {
                break;
            }
            System.out.print(" > ");
        }
        System.out.print("\n");
        System.out.println("##################################");
    }

    public ArrayList listarFacturas(){
        //Scanner sc = new Scanner(System.in);

        //String[] menu = {"EMPRESA DE CABLE", "LISTAR FACTURAS"};
        //this.imprimirEncabezado(menu);

        ArrayList<String> facturas = new ArrayList<>();
        this.listarServiciosFinalizados();
        if(this.compania.getFacturas().size() == 0) {
            System.out.println();
            System.out.println("No existen facturas.");
            return null;
        } else {
            for (Factura factura : this.compania.getFacturas()) {
                System.out.println(factura.toString());
                facturas.add("Numero de Factura:");
                facturas.add(String.valueOf(factura.getNroFactura()));
                facturas.add("Total de costo:");
                facturas.add(String.valueOf(factura.getServicio().getCostoReal()));
                facturas.add("Margen real:");
                facturas.add(String.valueOf(factura.getServicio().getPrecioFinal()));
                facturas.add("Precio final:");
                facturas.add(String.valueOf(factura.getServicio().calcularMargenReal()));
            }
        }
        return facturas;
    }

    public void listarServiciosFinalizados(){
        int serviciosFinalizados = 0;
        if(this.compania.getInstalaciones().size() == 0 && this.compania.getReparaciones().size() == 0){
            System.out.println();
            System.out.println("No existen servicios.");
        } else {
            for (Instalacion instalacion : compania.getInstalaciones()) {
                System.out.println(instalacion.toString());
                serviciosFinalizados++;
            }
            for(Reparacion reparacion: this.compania.getReparaciones()){
                System.out.println(reparacion.toString());
                serviciosFinalizados++;
            }
        }
        if(serviciosFinalizados == 0){
            System.out.println();
            System.out.println("No existen servicios finalizados.");
            return;
        }
    }

    public void menuModificarServicio(){
        Scanner sc = new Scanner(System.in);

        String[] menu = {"EMPRESA DE CABLE", "MODIFICAR SERVICIO"};
        this.imprimirEncabezado(menu);

        //listo los servicios finalizados
        int serviciosFinalizados = 0;
        if(this.compania.getInstalaciones().size() == 0 && this.compania.getReparaciones().size() == 0){
            System.out.println();
            System.out.println("No existen servicios finalizados.");
            return;
        } else {
            for (Instalacion instalacion : compania.getInstalaciones()) {
                if(instalacion.getFactura() == null && instalacion.getEstado() == Estado.Finalizada){
                    System.out.println(instalacion.toStringDetalle());
                    serviciosFinalizados++;
                }
            }
            for(Reparacion reparacion: this.compania.getReparaciones()){
                if(reparacion.getFactura() == null && reparacion.getEstado() == Estado.Finalizada) {
                    System.out.println(reparacion.toStringDetalle());
                    serviciosFinalizados++;
                }
            }
        }

        if(serviciosFinalizados == 0){
            System.out.println("No existen servicios en estado de ser modificados por el Administrativo.");
            return;
        }

        //obtengo el servicio a modificar
        TipoServicio tipoServicio;
        Reparacion servicioR = null;
        Instalacion servicioI = null;
        System.out.println();
        System.out.println("Ingrese el id de servicio a modificar: ");
        int idServicio = ingresarEntero();
        if(this.compania.getReparacion(idServicio) == null && this.compania.getInstalacion(idServicio) == null){
            System.out.println("El id de servicio ingresado no corresponde a un servicio existente");
            return;
        } else {
            if(compania.getInstalacion(idServicio) != null){
                servicioI = compania.getInstalacion(idServicio);
                tipoServicio = servicioI.getTipoServicio();
                System.out.println();
                System.out.println("Se trabajará con el siguiente servicio:");
                System.out.println(servicioI.toString());
                System.out.println();
            } else {
                servicioR = compania.getReparacion(idServicio);
                tipoServicio = servicioR.getTipoServicio();
                System.out.println();
                System.out.println("Se trabajará con el siguiente servicio:");
                System.out.println(servicioR.toString());
                System.out.println();
            }
        }

        //modificacion de valores del servicio
        if(tipoServicio == TipoServicio.Instalación){
            this.modificarServicio(servicioI);
        } else {
            this.modificarServicio(servicioR);
        }
    }

    public void generarFactura(){
        //Scanner sc = new Scanner(System.in);

        //String[] menu = {"EMPRESA DE CABLE", "GENERAR FACTURA"};
        //this.imprimirEncabezado(menu);

        //listo los servicios finalizados
        int serviciosFinalizados = 0;
        ArrayList<Integer> control = new ArrayList<Integer>();
        if(this.compania.getInstalaciones().size() == 0 && this.compania.getReparaciones().size() == 0){
            System.out.println();
            System.out.println("No existen servicios finalizados.");
            return;
        } else {
            for (Instalacion instalacion : compania.getInstalaciones()) {
                if(instalacion.getFactura() == null && instalacion.getEstado() == Estado.Finalizada) {
                    System.out.println(instalacion.toStringDetalle());
                    control.add(instalacion.getIdServicio());
                    serviciosFinalizados++;
                }
            }
            for(Reparacion reparacion: this.compania.getReparaciones()) {
                if (reparacion.getFactura() == null && reparacion.getEstado() == Estado.Finalizada){
                    System.out.println(reparacion.toStringDetalle());
                    control.add(reparacion.getIdServicio());
                    serviciosFinalizados++;
                }
            }
        }

        //obtengo el servicio a facturar
        TipoServicio tipoServicio;
        Reparacion servicioR = null;
        Instalacion servicioI = null;
        System.out.println();
        System.out.println("Ingrese el id de servicio a facturar: ");
        int idServicio = ingresarEntero();
        if(!control.contains(idServicio)) {
            System.out.println("El id ingresado no corresponde a un servicio apto para facturar.");
            return;
        } else {
            if(compania.getInstalacion(idServicio) != null){
                servicioI = compania.getInstalacion(idServicio);
                tipoServicio = servicioI.getTipoServicio();
                System.out.println();
                System.out.println("Se generará la factura correspondiente al siguiente servicio servicio:");
                System.out.println(servicioI.toString());
                System.out.println();
            } else {
                servicioR = compania.getReparacion(idServicio);
                tipoServicio = servicioR.getTipoServicio();
                System.out.println();
                System.out.println("Se generará la factura correspondiente al siguiente servicio servicio:");
                System.out.println(servicioR.toString());
                System.out.println();
            }
        }

        System.out.println("¿Confirma la generación de la factura? Y/n");
        sc.nextLine();
        String confirma = sc.nextLine();
        if(confirma.equals("n")){
            return;
        }

        //genero la factura correspondiente
        if(tipoServicio == TipoServicio.Instalación){
            servicioI.facturar();
            this.compania.guardarFactura(servicioI.getFactura());
            System.out.println("Factura generada correctamente");
            System.out.println();
            System.out.println("¿Desea imprimir la factura? Y/n");
            String imprime = sc.nextLine();
            if(imprime.equals("Y")){
                System.out.println(servicioI.getFactura().imprimirFactura());
            }
        } else {
            servicioR.facturar();
            this.compania.guardarFactura(servicioR.getFactura());
            System.out.println("Factura generada correctamente");
            System.out.println();
            System.out.println("¿Desea imprimir la factura? Y/n");
            String imprime = sc.nextLine();
            if(imprime.equals("Y")){
                System.out.println(servicioR.getFactura().imprimirFactura());
            }
        }

    }

    /** Metodos auxiliares**/

    private void modificarServicio(Instalacion instalacion){
        Scanner sc = new Scanner(System.in);

        boolean run = true;
        while (run) {
            System.out.println("Seleccione valor a modificar: ");
            System.out.println("1 - Costo de materiales adicionales");
            System.out.println("2 - Combustible");
            System.out.println("3 - Almuerzo");
            System.out.println("4 - Ajuste precio final");
            System.out.println("0 - Volver al menú anterior.");
            System.out.println();
            int opcion = ingresarEntero();
            switch(opcion) {
                case 1:
                    System.out.println("Ingrese el nuevo valor para Costo de materiales adicionales: ");
                    double valorCosto = ingresarDouble();
                    instalacion.setCostoMaterialesAdicionales(valorCosto);
                    instalacion.finalizarServicio(); //esta linea recalcula el costo del servicio
                    System.out.println("Se guardó el valor correctamente.");
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Ingrese el nuevo valor para Combustible: ");
                    double valorCombustible = sc.nextDouble();
                    instalacion.setCombustible(valorCombustible);
                    instalacion.finalizarServicio(); //esta linea recalcula el costo del servicio
                    System.out.println("Se guardó el valor correctamente.");
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Ingrese el nuevo valor para Almuerzo (0-NO/1-SI): ");
                    boolean valorAlmuerzoBool = false;
                    int valorAlmuerzoInt = ingresarEntero();
                    if(valorAlmuerzoInt == 1){
                        valorAlmuerzoBool = true;
                    } else {
                        if(valorAlmuerzoInt > 1 || valorAlmuerzoInt < 0){
                            System.out.println("El valor ingresado no es válido.");
                        }
                    }
                    instalacion.setAlmuerzo(valorAlmuerzoBool);
                    instalacion.finalizarServicio(); //esta linea recalcula el costo del servicio
                    System.out.println("Se guardó el valor correctamente.");
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Ingrese el porcentaje a descontar del ajuste (1-100%): ");
                    int descuento = sc.nextInt();
                    sc.nextLine();
                    if(descuento > 100 || descuento <= 0){
                        System.out.println("Valor inválido");
                        break;
                    }
                    float descuentoF = descuento/100;
                    instalacion.setPrecioFinal(instalacion.getPrecioFinal() - instalacion.getPrecioFinal()*descuentoF);
                    System.out.println("Se hará un descuento del "+descuento+"%");
                    System.out.println();
                    break;
                case 0:
                    run = false;
                    break;
            }
        }
    }

    private void modificarServicio(Reparacion reparacion) {
        Scanner sc = new Scanner(System.in);

        boolean run = true;
        while (run) {
            System.out.println("Seleccione valor a modificar: ");
            System.out.println("1 - Costo de materiales adicionales");
            System.out.println("2 - Combustible");
            System.out.println("3 - Almuerzo");
            System.out.println("4 - Precio final");
            System.out.println("0 - Volver al menú anterior.");
            System.out.println();
            int opcion = ingresarEntero();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nuevo valor para Costo de materiales adicionales: ");
                    double valorCosto = ingresarDouble();
                    reparacion.setCostoMaterialesAdicionales(valorCosto);
                    reparacion.finalizarServicio(); //esta linea recalcula el costo del servicio
                    System.out.println("Se guardó el valor correctamente.");
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Ingrese el nuevo valor para Combustible: ");
                    double valorCombustible = ingresarDouble();
                    reparacion.setCombustible(valorCombustible);
                    reparacion.finalizarServicio(); //esta linea recalcula el costo del servicio
                    System.out.println("Se guardó el valor correctamente.");
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Ingrese el nuevo valor para Almuerzo (0-NO/1-SI): ");
                    boolean valorAlmuerzoBool = false;
                    int valorAlmuerzoInt = ingresarEntero();
                    if (valorAlmuerzoInt == 1) {
                        valorAlmuerzoBool = true;
                    } else {
                        if (valorAlmuerzoInt > 1 || valorAlmuerzoInt < 0) {
                            System.out.println("El valor ingresado no es válido.");
                        }
                    }
                    reparacion.setAlmuerzo(valorAlmuerzoBool);
                    reparacion.finalizarServicio(); //esta linea recalcula el costo del servicio
                    System.out.println("Se guardó el valor correctamente.");
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Ingrese el porcentaje a descontar del ajuste (1-100%): ");
                    int descuento = sc.nextInt();
                    sc.nextLine();
                    if(descuento > 100 || descuento <= 0){
                        System.out.println("Valor inválido");
                        break;
                    }
                    float descuentoF = descuento/100;
                    reparacion.setPrecioFinal(reparacion.getPrecioFinal() - reparacion.getPrecioFinal()*descuentoF);
                    System.out.println("Se hará un descuento del "+descuento+"%");
                    System.out.println();
                    break;
                case 0:
                    run = false;
                    break;
            }
        }
    }

    public static int ingresarEntero() {
        boolean repetir;
        int n = 100;
        do {
            repetir = false;
            try {
                n = sc.nextInt();
                return n;
            }
            catch (InputMismatchException exception) {
                System.out.println("ERROR. El valor no corresponde a un Entero. Volver a ingresar: ");
                repetir = true;
            }
            finally {
                sc.nextLine();
            }
        } while (repetir);
        return n;
    }

    public static double ingresarDouble() {
        boolean repetir;
        double n = 100.0;
        do {
            repetir = false;
            try {
                n = sc.nextDouble();
                return n;
            }
            catch (InputMismatchException exception) {
                System.out.println("ERROR. El valor no corresponde a un Número con Decimales. Volver a ingresar: ");
                repetir = true;
            }
            finally {
                sc.nextLine();
            }
        } while (repetir);
        return n;
    }
}

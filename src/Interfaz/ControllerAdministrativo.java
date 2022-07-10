package Interfaz;

import Clases.*;
import Enumeraciones.TipoServicio;

import java.util.Scanner;

public class ControllerAdministrativo extends Usuario {

    private Compania compania;


    public void menuInicial() {
        // TODO Auto-generated method stub

        //Genero los objetos base
        this.compania = Clases.Compania.getInstance();

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
                case 0:
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

    private void listarFacturas(){
        Scanner sc = new Scanner(System.in);

        String[] menu = {"EMPRESA DE CABLE", "LISTAR FACTURAS"};
        this.imprimirEncabezado(menu);

        if(this.compania.getFacturas().size() == 0) {
            System.out.println();
            System.out.println("No existen facturas.");
        } else {
            for (Factura factura : this.compania.getFacturas()) {
                System.out.println(factura.toString());
            }
        }
    }

    private void listarServiciosFinalizados(){
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

    private void menuModificarServicio(){
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
                System.out.println(instalacion.toString());
                serviciosFinalizados++;
            }
            for(Reparacion reparacion: this.compania.getReparaciones()){
                System.out.println(reparacion.toString());
                serviciosFinalizados++;
            }
        }

        //obtengo el servicio a modificar
        TipoServicio tipoServicio;
        Reparacion servicioR = null;
        Instalacion servicioI = null;
        System.out.println();
        System.out.println("Ingrese el id de servicio a modificar: ");
        int idServicio = sc.nextInt();
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

    private void modificarServicio(Instalacion instalacion){
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
            int opcion = sc.nextInt();
            switch(opcion) {
                case 1:
                    System.out.println("Ingrese el nuevo valor para Costo de materiales adicionales: ");
                    double valorCosto = sc.nextDouble();
                    instalacion.setCostoMaterialesAdicionales(valorCosto);
                    instalacion.finalizarServicio(this.compania); //esta linea recalcula el costo del servicio
                    System.out.println("Se guardó el valor correctamente.");
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Ingrese el nuevo valor para Combustible: ");
                    double valorCombustible = sc.nextDouble();
                    instalacion.setCombustible(valorCombustible);
                    instalacion.finalizarServicio(this.compania); //esta linea recalcula el costo del servicio
                    System.out.println("Se guardó el valor correctamente.");
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Ingrese el nuevo valor para Almuerzo (0-NO/1-SI): ");
                    boolean valorAlmuerzoBool = false;
                    int valorAlmuerzoInt = sc.nextInt();
                    if(valorAlmuerzoInt == 1){
                        valorAlmuerzoBool = true;
                    } else {
                        if(valorAlmuerzoInt > 1 || valorAlmuerzoInt < 0){
                            System.out.println("El valor ingresado no es válido.");
                        }
                    }
                    instalacion.setAlmuerzo(valorAlmuerzoBool);
                    instalacion.finalizarServicio(this.compania); //esta linea recalcula el costo del servicio
                    System.out.println("Se guardó el valor correctamente.");
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Ingrese el nuevo valor para Precio final: ");
                    double valorPrecioFinal = sc.nextDouble();
                    instalacion.setPrecioFinal(valorPrecioFinal);
                    System.out.println("Se guardó el valor correctamente.");
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
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nuevo valor para Costo de materiales adicionales: ");
                    double valorCosto = sc.nextDouble();
                    reparacion.setCostoMaterialesAdicionales(valorCosto);
                    reparacion.finalizarServicio(this.compania); //esta linea recalcula el costo del servicio
                    System.out.println("Se guardó el valor correctamente.");
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Ingrese el nuevo valor para Combustible: ");
                    double valorCombustible = sc.nextDouble();
                    reparacion.setCombustible(valorCombustible);
                    reparacion.finalizarServicio(this.compania); //esta linea recalcula el costo del servicio
                    System.out.println("Se guardó el valor correctamente.");
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Ingrese el nuevo valor para Almuerzo (0-NO/1-SI): ");
                    boolean valorAlmuerzoBool = false;
                    int valorAlmuerzoInt = sc.nextInt();
                    if (valorAlmuerzoInt == 1) {
                        valorAlmuerzoBool = true;
                    } else {
                        if (valorAlmuerzoInt > 1 || valorAlmuerzoInt < 0) {
                            System.out.println("El valor ingresado no es válido.");
                        }
                    }
                    reparacion.setAlmuerzo(valorAlmuerzoBool);
                    reparacion.finalizarServicio(this.compania); //esta linea recalcula el costo del servicio
                    System.out.println("Se guardó el valor correctamente.");
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Ingrese el nuevo valor para Precio final: ");
                    double valorPrecioFinal = sc.nextDouble();
                    reparacion.setPrecioFinal(valorPrecioFinal);
                    System.out.println("Se guardó el valor correctamente.");
                    System.out.println();
                    break;
                case 0:
                    run = false;
                    break;
            }
        }
    }
}

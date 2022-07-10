package Interfaz;

import Clases.*;

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

    public void imprimirModificarServicio() {
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
            System.out.println("No existen servicios finalizados.");
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

    private void modificarServicio(){
        Scanner sc = new Scanner(System.in);

        String[] menu = {"EMPRESA DE CABLE", "MODIFICAR SERVICIO"};
        this.imprimirEncabezado(menu);

        //listo los servicios finalizados
        int serviciosFinalizados = 0;
        if(this.compania.getInstalaciones().size() == 0 && this.compania.getReparaciones().size() == 0){
            System.out.println();
            System.out.println("No existen servicios finalizados.");
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
        Object servicio;
        System.out.println();
        System.out.println("Ingrese el id de servicio a modificar: ");
        int idServicio = sc.nextInt();
        if(this.compania.getServicio(idServicio) == null){
            System.out.println("El id de servicio ingresado no corresponde a un servicio existente");
            return;
        } else {
            servicio = this.compania.getServicio(idServicio);
        }

        System.out.println();
        System.out.println("Se trabajará con el siguiente servicio:");
        System.out.println(servicio.toString());
        System.out.println();

        //modificacion de valores del servicio
        boolean run = true;
        while (run) {
            System.out.println("Seleccione valor a modificar: ");
            System.out.println("1 - ");
            System.out.println();
            System.out.println();
            int opcion = sc.nextInt();
            switch(opcion) {
                case 1:
                    this.listarFacturas();
                    break;
                case 2:
                    break;
                case 0:
                    break;
            }
        }


    }

}

package Interfaz;

import Clases.*;
import java.util.Scanner;

public class InterfazConsola {

    private Compania compania;

    public void main(String[] args) {
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
                    this.reservarServicio();
                    break;
                case 0:
                    run = false;
            }
        }
    }

    public void imprimirMenuInicial() {
        String[] menu = {"EMPRESA DE CABLE"};
        imprimirEncabezado(menu);
        System.out.println("1. Reservar Servicio");
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

    public void reservarServicio() {

        Scanner sc = new Scanner(System.in);

        String[] menu = {"EMPRESA DE CABLE", "RESERVAR SERVICIO"};
        this.imprimirEncabezado(menu);

        //obtengo cliente
        System.out.println("Ingrese DNI del cliente: ");
        int dni = sc.nextInt();
        if(this.compania.getCliente(dni) == null){
            System.out.println("El cliente no existe.");
            return;
        } else {
            Cliente cliente = this.compania.getCliente(dni);
        }

        //verifico si el cliente tiene otros servicios reservados
        if(compania.getReparacionPorCliente(dni) != null){
            Reparacion reparacion = compania.getReparacionPorCliente(dni);
            System.out.println("El cliente posee vigente el servicio"+reparacion.getIdServicio());
            return;
        } else if(compania.getInstalacionPorCliente(dni) != null){
            Instalacion instalacion = compania.getInstalacionPorCliente(dni);
            System.out.println("El cliente posee vigente el servicio"+ instalacion.getIdServicio());
            return;
        }



//
//        //verifico disponibilidad
//        ArrayList<Vehiculo> vehiculosDisponibles = adminReservas.verificarDisponibilidad(fechas[0], fechas[1], tipoAuto);
//
//        //imprimo resultado
//        interfaz.imprimirVehiculosDisponibles(vehiculosDisponibles);
//
//        //confirmo si crea reserva
//        Boolean continuaReserva = interfaz.continuaCreandoReserva();
//        if(!continuaReserva){
//            return;
//        }
//
//        //solicito y valido existencia del cliente
//        int nroDocumentoCliente = 0;
//        Boolean a = true;
//        while(a) {
//            int nroDocumentoClienteAux = interfaz.obtenerNroDocumento();
//            if(adminClientes.getCliente(nroDocumentoClienteAux) == null) {
//                a = interfaz.continuaIngresandoCliente();
//                if(!a) return;
//            } else {
//                a = false;
//                nroDocumentoCliente = nroDocumentoClienteAux;
//            }
//        }
//
//        //solicito los vehiculos a reservar y la confirmacion de la reserva
//        ArrayList<String> vehiculosReserva = interfaz.obtenerVehiculosReserva();
//        ArrayList<Vehiculo> vehiculosReservaObj = adminReservas.obtenerVehiculosReservaObj(vehiculosReserva, vehiculosDisponibles);
//        Boolean creaReserva = interfaz.creaReserva();
//        if(!creaReserva){
//            return;
//        }
//
//        //creo reserva
//        Cliente cliente = adminClientes.getCliente(nroDocumentoCliente);
//        Reserva reserva = adminReservas.altaReserva(cliente, fechas[0], fechas[1], vehiculosReservaObj, nroAgenciaOperadora);
//
//        //valido si abona por anticipado
//        if(creaReserva) {
//            Boolean abonaAnticipado = interfaz.abonaAnticipado(reserva);
//            if(!abonaAnticipado){
//                return;
//            }
//            adminReservas.abonaReserva(reserva);
//        }
    }

}

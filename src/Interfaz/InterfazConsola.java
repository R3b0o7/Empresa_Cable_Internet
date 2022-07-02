package Interfaz;

import Clases.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import static java.util.Calendar.DAY_OF_WEEK;

public class InterfazConsola {

    private Compania compania;

    public void main() {
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
        if (this.compania.getCliente(dni) == null) {
            System.out.println("El cliente no existe.");
            return;
        } else {
            Cliente cliente = this.compania.getCliente(dni);
        }

        //verifico si el cliente tiene otros servicios reservados
        if (compania.getReparacionPorCliente(dni) != null) {
            Reparacion reparacion = compania.getReparacionPorCliente(dni);
            System.out.println("El cliente posee vigente el servicio" + reparacion.getIdServicio());
            return;
        } else if (compania.getInstalacionPorCliente(dni) != null) {
            Instalacion instalacion = compania.getInstalacionPorCliente(dni);
            System.out.println("El cliente posee vigente el servicio" + instalacion.getIdServicio());
            return;
        }

        //obtengo datos fecha
        System.out.println("Indique el turno requerido (1-Mañana/2-Tarde): ");
        int turno = sc.nextInt();
        if(turno != 1 && turno != 2) {
            System.out.println("Valor indicado incorrecto.");
        }
        Date fecha;
        try {
            fecha = this.obtenerFecha();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        //valido que no sea domingo o sabado por la tarde
        Calendar c = Calendar.getInstance();
        c.setTime(fecha);
        int day = c.DAY_OF_WEEK;
        if(day == 7 || (day  == 6 && turno == 2)){
            System.out.println("El turno y fecha indicado no se presta servicio.");
        }

        //obtengo horario
        System.out.println("Indique el horario (1-Mañana/2-Tarde): ");
        if(turno == 1) {
            System.out.println("0 - 8:00");
            System.out.println("1 - 8:30");
            System.out.println("2 - 9:00");
            System.out.println("3 - 9:30");
            System.out.println("4 - 10:00");
            System.out.println("5 - 10:30");
            System.out.println("6 - 11:00");
            System.out.println("7 - 11:30");
            System.out.println("8 - 12:00");
            System.out.println("9 - 12:30");
            System.out.println("10 - 13:00");
            System.out.println("11 - 13:30");
            int horario = sc.nextInt();
        }



        //
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

    private Date obtenerFecha() throws ParseException {
        Scanner sc = new Scanner(System.in);
        Date fechaDate = new Date();
        System.out.print("Ingrese fecha requerida (dd/mm/aaaa):");
        String fechaTexto = sc.nextLine();
        SimpleDateFormat sdfInicio = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = sdfInicio.parse(fechaTexto);
        return fecha;
    }

}

package Interfaz;

import Clases.*;
import Excepciones.GenericException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import static java.util.Calendar.DAY_OF_WEEK;

public class ControllerCallCenter extends Usuario {

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
                    this.reservarServicio();
                    break;
                case 2:
                    this.altaCliente();
                    break;
                case 0:
                    run = false;
                    break;
            }
        }
    }


    public void reservarServicio() {

        Scanner sc = new Scanner(System.in);

        String[] menu = {"EMPRESA DE CABLE", "RESERVAR SERVICIO"};
        this.imprimirEncabezado(menu);

        //obtengo cliente
        Cliente cliente;
        System.out.println("Ingrese DNI del cliente: ");
        int dni = sc.nextInt();
        if (this.compania.getCliente(dni) == null) {
            System.out.println("El cliente no existe.");
            return;
        } else {
            cliente = this.compania.getCliente(dni);
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
        //obtengo tipo de servicio
        System.out.println("Seleccione el tipo de servicio (1-REPARACION/2-INSTALACION)");
        int tipoServicio = sc.nextInt();
        String tiposervicioStr = (tipoServicio==1) ? "REPARACION":"INSTALACION";

        //Verifico si hay stock para los materiales base
        if(!compania.getStock().hayStockInstalacion() && tipoServicio == 1){
            System.out.println("ATENCION!!");
            System.out.println("Se debe solicitar la compra de materiales para la Instalación");
            System.out.println();
        }

        //obtengo datos fecha
        System.out.println("Indique el turno requerido (1-Mañana/2-Tarde): ");
        int turno = sc.nextInt();
        if (turno != 1 && turno != 2) {
            System.out.println("Valor indicado incorrecto.");
            return;
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
        int day = c.get(DAY_OF_WEEK);
        if (day == 1 || (day == 7 && turno == 2)) {
            System.out.println("En el turno y fecha indicado no se presta servicio.");
            return;
        }

        //obtengo horario
        Agenda agendaModelo = new Agenda();
        System.out.println(agendaModelo.getEquivalenciaFilaHora().toString());
        System.out.println("Seleccione el horario: ");
        if (turno == 1) {
            for (int k = 0; k < 12; k++) {
                System.out.println(k + "-" + agendaModelo.getEquivalenciaFilaHora().get(k));
            }
        } else {
            for (int k = 12; k < 24; k++) {
                System.out.println(k + "-" + agendaModelo.getEquivalenciaFilaHora().get(k));
            }
        }
        int horario = sc.nextInt();
        String horarioStr = agendaModelo.getEquivalenciaFilaHora().get(horario);

        //obtengo los tecnicos disponibles
        String turnoStr = (turno == 1) ? "Mañana" : "Tarde";
        ArrayList<Tecnico> tecnicosDisponibles = new ArrayList<Tecnico>();
        try {
            for (Tecnico tecnico : compania.getTecnicos()) {
                if (tecnico.getTurno().equals(turnoStr) && tecnico.poseeDisponibilidad(fecha, horarioStr, tiposervicioStr)) {
                    tecnicosDisponibles.add(tecnico);
                }
            }
        } catch (GenericException exc) {
            System.out.println(exc);
            return;
        }
//
//        //Los muestro por pantalla y solicito la seleccion
        ArrayList<Tecnico> tecnicosSeleccionados = new ArrayList<Tecnico>();
        System.out.println("Seleccione  los técnicos para brindar el servicio (0-Continuar):");
        int escape = 1;
        while (escape != 0) {
            if (tecnicosDisponibles.isEmpty()) {
                System.out.println("No existen más técnicos disponibles.");
                break;
            }
            System.out.println("Tecnicos disponibles:");
            for (Tecnico tecnico : tecnicosDisponibles) {
                System.out.println(tecnico.toString());
            }
            int nroTecnico = sc.nextInt();
            if (nroTecnico == 0) {
                escape = 0;
            } else {
                for (Tecnico tecnico : tecnicosDisponibles) {
                    if (tecnico.getNroTécnico() == nroTecnico) {
                        tecnicosSeleccionados.add(tecnico);
                        System.out.println("Se seleccionó correctamente el siguiente Tecnico:");
                        System.out.println(tecnico.toString());
                        System.out.println();
                    }
                }
                for(Tecnico tecnico: tecnicosSeleccionados){
                    if (tecnico.getNroTécnico() == nroTecnico) {
                        tecnicosDisponibles.remove(tecnico);
                    }
                }
            }
        }

        //Instancio el servicio, calculo el costo base e imprimo por pantalla
        Reparacion servicioR = null;
        Instalacion servicioI = null;
        Double costoBase;

        System.out.println();
        System.out.println("Se está generando el siguiente servicio:");
        System.out.println("________________________________________");

        if(tiposervicioStr.equals("REPARACION")){
            servicioR = new Reparacion(compania.getUltimoServicio()+1, fecha, horarioStr, tecnicosSeleccionados, cliente);
            costoBase = servicioR.calcularPrecioBase(compania);
            System.out.println(servicioR.toString());
        } else {
            servicioI = new Instalacion(compania.getUltimoServicio()+1, fecha, horarioStr, tecnicosSeleccionados, cliente, compania.getStock());
            costoBase = servicioI.calcularPrecioBase(compania);
            System.out.println(servicioI.toString());
        }

        System.out.println("El costo base del servicio es:   "+costoBase);
        //solicito confirmacion
        System.out.println();
        sc.nextLine(); //para capturar el enter
        System.out.println("¿Confirma el servicio? Y/n");
        String confirmacion = sc.nextLine();

        //si no confirma destruyo la instancia
        if(confirmacion.equals("n") && tiposervicioStr.equals("REPARACION")){
            servicioR = null;
        } else if(confirmacion.equals("n")){
            servicioI = null;
        }

        //si confirma despliego los cambios asociados a la generacion del servicio
        // agrego el servicio a la base de datos
        if(confirmacion.equals("Y") && tiposervicioStr.equals("REPARACION")){
            //almaceno el servicio
            compania.guardarReparacion(servicioR);

            //incremento el id servicio
            compania.incrementarUltimoServicio();

            //Agendo en el tecnico el servicio
            try {
                for (Tecnico tecnico : tecnicosSeleccionados) {
                    tecnico.agendarServicio(fecha, horarioStr, servicioR.getIdServicio(), tiposervicioStr);
                }
            } catch(GenericException exc){
                System.out.println("Error al agendar el servicio en el Tecnico");
            }

            //Agendo en el cliente el servicio
            try{
                cliente.agendarServicio(fecha, horarioStr, servicioR.getIdServicio(), tiposervicioStr);
            } catch (GenericException exc) {
                System.out.println("Error al agendar el servicio en el Cliente");
            }

        } else if(confirmacion.equals("Y")) {
            //almaceno el servicio
            compania.guardarInstalacion(servicioI);

            //incremento el id servicio
            compania.incrementarUltimoServicio();

            //Agendo en el tecnico el servicio
            try {
                for (Tecnico tecnico : tecnicosSeleccionados) {
                    tecnico.agendarServicio(fecha, horarioStr, servicioI.getIdServicio(), tiposervicioStr);
                }
            } catch(GenericException exc){
                System.out.println("Error al agendar el servicio en el Tecnico");
            }

            //Agendo en el cliente el servicio
            try{
                cliente.agendarServicio(fecha, horarioStr, servicioI.getIdServicio(), tiposervicioStr);
            } catch (GenericException exc) {
                System.out.println("Error al agendar el servicio en el Cliente");
            }
        }

    }

    private void altaCliente(){

        Scanner sc = new Scanner(System.in);

        String[] menu = {"EMPRESA DE CABLE", "ALTA DE CLIENTE"};
        this.imprimirEncabezado(menu);

        //obtengo cliente
        Cliente cliente;
        System.out.println("Ingrese DNI del cliente: ");
        int dni = sc.nextInt();
        if (this.compania.getCliente(dni) != null) {
            System.out.println("El cliente ya existe.");
            return;
        }
        sc.nextLine(); //leer salto de linea
        System.out.println("Ingrese nombre del cliente: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese direccion del cliente: ");
        String direccion = sc.nextLine();

        System.out.println("Se creará el siguiente cliente:");
        System.out.println("DNI: "+dni);
        System.out.println("Nombre: "+nombre);
        System.out.println("Direccion: "+direccion);
        System.out.println("¿Confirma el alta? Y/n :");
        String confirma = sc.nextLine();
        if(confirma.equals("Y")){
            cliente = new Cliente(dni, nombre, direccion);
            compania.guardarCliente(cliente);
            System.out.println("El cliente se guardó correctamente.");
            System.out.println();
        } else {
            System.out.println("Se canceló la operación");
            System.out.println();
        }

    }

    public void imprimirMenuInicial() {
        String[] menu = {"EMPRESA DE CABLE"};
        imprimirEncabezado(menu);
        System.out.println("1. Reservar Servicio");
        System.out.println("2. Alta de cliente");
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

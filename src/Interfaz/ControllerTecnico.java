package Interfaz;

import Clases.*;

import java.util.Scanner;

public class ControllerTecnico extends Usuario{

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
                    this.serviciosAsignados();
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
        System.out.println("1. Listar servicios asignados");
        System.out.println("2. Finalizar servicio");
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

    public void serviciosAsignados(){
        if(this.compania.getReparaciones()==null){
            System.out.println("No existen reparaciones");
        } else {
            for (Reparacion reparacion : this.compania.getReparaciones()){
                for(Tecnico tecnicoReparacion : reparacion.getTecnicos()) {
                    for (Tecnico tecnicoUsuario : this.compania.getTecnicos()) {
                        if (tecnicoReparacion.getNroTécnico() == tecnicoUsuario.getNroTécnico()) {
                            this.compania.getReparacion(reparacion.getIdServicio());
                            System.out.println("REPARACIONES");
                            System.out.println(reparacion);
                        }
                    }
                }
            }
        }

    }
}

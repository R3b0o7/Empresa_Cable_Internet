package Interfaz;

import Clases.*;

import java.util.Scanner;

public class ControllerAdministrador extends Usuario{

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
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    break;
            }
        }
    }

    public void imprimirMenuInicial() {
        String[] menu = {"EMPRESA DE CABLE"};
        imprimirEncabezado(menu);
        System.out.println("1. ABM de tecnicos");
        System.out.println("2. ABM de artículos");
        System.out.println("3. Configurar parámetros");
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

}

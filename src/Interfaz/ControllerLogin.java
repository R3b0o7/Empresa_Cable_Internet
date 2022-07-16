package Interfaz;

import Clases.*;
import GUI.VentanaAdministrador;
import GUI.VentanaCallCenter;
import GUI.VentanaTecnico;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class ControllerLogin {
    JOptionPane mensajeError = new JOptionPane();
    private Compania compania = Compania.getInstance();
    private static ControllerLogin controladorLogin;
    private ControllerCallCenter controladorCallCenter;
    private ControllerAdministrativo controladorAdministrativo;
    private ControllerAdministrador controladorAdministrador;
    private ControllerTecnico controladorTecnico;
    private String perfil;

    private ControllerLogin(){
    }

    public static ControllerLogin getInstance(){
        if(controladorLogin == null){
            controladorLogin = new ControllerLogin();
        }
        return controladorLogin;
    }

    public boolean validarCredenciales(String usuario, String contraseña){
        if(Compania.getInstance().getContraseña(usuario) != null){
            return Compania.getInstance().getContraseña(usuario).equals(contraseña);
        }
        else{
            JOptionPane.showMessageDialog(mensajeError, "Datos ingresados incorrectos");
            return false;
        }
    }

    public void obtenerPerfil(String usuario){
        boolean run = true;
        this.perfil = compania.getPerfil(usuario);
        while (run){
            switch(perfil) {
                case "callCenter":
                    this.controladorCallCenter = ControllerCallCenter.getInstance();
                    new VentanaCallCenter();
                    run = false;
                    break;
                case "tecnico":
                    this.controladorTecnico = ControllerTecnico.getInstance();
                    new VentanaTecnico();
                    run = false;
                    break;
                case "administrador":
                    this.controladorAdministrador = ControllerAdministrador.getInstance();
                    new VentanaAdministrador();
                    run = false;
                    break;
                case "administrativo":
                    this.controladorAdministrativo = ControllerAdministrativo.getInstance();
                    new VentanaAdministrador();
                    run = false;
                    break;
            }
            break;
        }
    }
}

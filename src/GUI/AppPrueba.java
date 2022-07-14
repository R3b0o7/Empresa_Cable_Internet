package GUI;

import Clases.Compania;
import Interfaz.ControllerAdministrador;
import Interfaz.ControllerAdministrativo;
import Interfaz.ControllerLogin;
import Interfaz.ControllerTecnico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AppPrueba extends JFrame {

    ControllerLogin login;
    ControllerAdministrador administrador;
    ControllerAdministrativo administrativo;
    ControllerTecnico tecnico;

    public AppPrueba(){

        this.setTitle("Empresa de Cable Internet");    //Titulo de la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //Cierra la aplicación al apretar la x
        this.setLayout(new FlowLayout());

        JTextField usuario = new JTextField();
        usuario.setPreferredSize(new Dimension(250,40));
        JPasswordField contraseña = new JPasswordField();
        contraseña.setPreferredSize(new Dimension(250,40));

        JButton botonEnviar = new JButton("Enviar");
        //button.addActionListener(login.validarCredenciales(usuario.getText(),contraseña.getPassword()));

        this.add(botonEnviar);
        this.add(usuario);
        this.add(contraseña);
        this.setSize(600,400);
        this.setResizable(false);      //Evitar que la ventana pueda ser cambiada de tamaño
        this.setVisible(true);     //Hace el frame visible

        ImageIcon image = new ImageIcon("C:\\Users\\Luciano\\OneDrive\\01. Facultad\\2022\\" +
                "4. Introducción a la Orientación a Objetos\\TPO\\_Empresa Cable e Internet\\TPO\\src\\Interfaz\\Logo.png"); //crea un icono de la imagen
        this.setIconImage(image.getImage());  //cambia el icono del frame
        this.getContentPane().setBackground(new Color(107,108,109));
    }

    public static void main(String[] args) {
        AppPrueba ventanaLogin = new AppPrueba();
    }
}

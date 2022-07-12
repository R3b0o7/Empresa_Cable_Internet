package Interfaz;

import javax.swing.*;
import java.awt.*;

public class App {

    public static void main(String[] args) {
        JLabel encabezado = new JLabel();
        encabezado.setText("Inicio de Sesión\n(usrAdministrador / usrAdministrativo / usrCallCenter / usrTecnico)");
        encabezado.setHorizontalAlignment(JLabel.CENTER);
        encabezado.setVerticalAlignment(JLabel.TOP);
        encabezado.setForeground(new Color(237,237,237));
        encabezado.setFont(new Font("Encabezado",Font.BOLD,20));

        //JFrame
        JFrame frame = new JFrame();
        frame.setTitle("Empresa de Cable Internet");    //Titulo de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //Cierra la aplicación al apretar la x
        frame.setResizable(false);      //Evitar que la ventana pueda ser cambiada de tamaño
        frame.setSize(600,420);     //Setea el tamaño en x e y
        frame.setVisible(true);     //Hace el frame visible

        ImageIcon image = new ImageIcon("C:\\Users\\Nothi\\OneDrive\\Documentos\\OneDrive\\01. Facultad\\2022\\" +
                "4. Introducción a la Orientación a Objetos\\Empresa_Cable_Internet\\src\\Interfaz\\Logo.png"); //crea un icono de la imagen
        frame.setIconImage(image.getImage());  //cambia el icono del frame
        frame.getContentPane().setBackground(new Color(107,108,109));

        frame.add(encabezado);  //NO LO CARGA EL WACHIN

    }
}

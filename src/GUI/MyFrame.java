package GUI;
import Interfaz.ControllerLogin;
import Interfaz.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    JButton button;
    JTextField textField;
    JTextField textField2;
    MyFrame(){
        this.setTitle("Empresa de Cable Internet");    //Titulo de la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //Cierra la aplicación al apretar la x
        this.setLayout(new FlowLayout());
        this.setResizable(false);      //Evitar que la ventana pueda ser cambiada de tamaño

        button = new JButton("Enviar");
        button.addActionListener(this);


        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250,40));
        textField2 = new JTextField();
        textField2.setPreferredSize(new Dimension(250,40));

        this.add(button);
        this.add(textField);
        this.add(textField2);
        this.setSize(600,400);
        this.setVisible(true);     //Hace el frame visible

        ImageIcon image = new ImageIcon("C:\\Users\\Luciano\\OneDrive\\01. Facultad\\2022\\" +
                "4. Introducción a la Orientación a Objetos\\TPO\\_Empresa Cable e Internet\\TPO\\src\\Interfaz\\Logo.png"); //crea un icono de la imagen
        this.setIconImage(image.getImage());  //cambia el icono del frame
        this.getContentPane().setBackground(new Color(107,108,109));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            //ControllerLogin login = new ControllerLogin().getInstance();
            //login.validarCredenciales(textField.getText(),textField2.getText());

        }
    }
}

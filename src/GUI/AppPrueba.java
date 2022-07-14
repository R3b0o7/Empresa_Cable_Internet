package GUI;

import Clases.Compania;
import Interfaz.ControllerAdministrador;
import Interfaz.ControllerAdministrativo;
import Interfaz.ControllerLogin;
import Interfaz.ControllerTecnico;

import javax.swing.*;
import javax.swing.plaf.basic.DefaultMenuLayout;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AppPrueba extends JFrame {

    ControllerLogin login;
    ControllerAdministrador administrador;
    ControllerAdministrativo administrativo;
    ControllerTecnico tecnico;

    public AppPrueba(){

        //Titulo Ventana
        this.setTitle("Empresa de Cable Internet");    //Titulo de la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //Cierra la aplicación al apretar la x
        this.setLayout(new FlowLayout());
        ImageIcon image = new ImageIcon("C:\\Users\\Luciano\\OneDrive\\01. Facultad\\2022\\" +
                "4. Introducción a la Orientación a Objetos\\TPO\\_Empresa Cable e Internet\\TPO\\src\\GUI\\Logo.png"); //crea un icono de la imagen
        this.setIconImage(image.getImage());  //cambia el icono del frame
        //Color de la ventana
        this.getContentPane().setBackground(new Color(107,108,109));

        //Paneles  --> Size(whidth: 600, height: 400)

        //Laterales

        JPanel panelIzquierdoUsuario = new JPanel();
        panelIzquierdoUsuario.setBackground(new Color(107,108,109));
        panelIzquierdoUsuario.setBounds(0, 160,100,30);
        panelIzquierdoUsuario.setLayout(new BorderLayout());

        JPanel panelIzquierdoContraseña = new JPanel();
        panelIzquierdoContraseña.setBackground(new Color(107,108,109));
        panelIzquierdoContraseña.setBounds(0, 200,100,30);
        panelIzquierdoContraseña.setLayout(new BorderLayout());

        JPanel panelDerecho = new JPanel();
        panelDerecho.setBackground(new Color(107,108,109));
        panelDerecho.setBounds(500, 0,100,400);

        //Centro

        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(107,108,109));
        panelTitulo.setBounds(100,0,400,150);

        JPanel panelUsuario = new JPanel();
        panelUsuario.setBackground(new Color(107,108,109));
        panelUsuario.setBounds(100,150,400,40);

        JPanel panelContraseña = new JPanel();
        panelContraseña.setBackground(new Color(107,108,109));
        panelContraseña.setBounds(100,190,400,40);

        JPanel panelBoton = new JPanel();
        panelBoton.setBackground(new Color(107,108,109));
        panelBoton.setBounds(100,230,400,70);

        JPanel panelAdicional = new JPanel();
        panelAdicional.setBackground(new Color(107,108,109));
        panelAdicional.setBounds(100,300,400,65);

        //Titulo
        JLabel titulo = new JLabel();
        titulo.setText("Inicio de Sesión");
        titulo.setHorizontalTextPosition(JLabel.CENTER);
        titulo.setVerticalTextPosition(JLabel.TOP);
        titulo.setForeground(new Color(255, 255, 255));
        titulo.setFont(new Font("Fuente",Font.BOLD, 15));
        titulo.setIconTextGap(10);

        //Imagen del titulo

        ImageIcon imagen = new ImageIcon("C:\\Users\\Luciano\\OneDrive\\01. Facultad\\2022\\" +
                "4. Introducción a la Orientación a Objetos\\TPO\\_Empresa Cable e Internet\\TPO\\src\\GUI\\LogIn.png");
        titulo.setIcon(imagen);
        titulo.setPreferredSize(new Dimension(600,150));
        titulo.setVerticalAlignment(JLabel.CENTER);
        titulo.setHorizontalAlignment(JLabel.CENTER);


        //Linea de Usuario
        JLabel textUsuario = new JLabel("Usuario: ");
        textUsuario.setText("Usuario: ");
        textUsuario.setHorizontalAlignment(JLabel.RIGHT);
        textUsuario.setVerticalAlignment(JLabel.CENTER);
        //textUsuario.setPreferredSize(new Dimension(100,30));
        textUsuario.setBounds(0,150,100,30);
        textUsuario.setForeground(new Color(255, 255, 255));

        JTextField usuario = new JTextField();
        usuario.setPreferredSize(new Dimension(380, 30));

        //Linea de Contraseña
        JLabel textContraseña = new JLabel("Contraseña: ");
        textContraseña.setHorizontalAlignment(JLabel.RIGHT);
        textContraseña.setVerticalAlignment(JLabel.CENTER);
        //textContraseña.setPreferredSize(new Dimension(100, 30));
        //textUsuario.setBounds(0,190,100,30);
        textContraseña.setForeground(new Color(255, 255, 255));

        JPasswordField contraseña = new JPasswordField();
        contraseña.setPreferredSize(new Dimension(380, 30));

        //Boton de Enviar
        JButton botonEnviar = new JButton("Enviar");
        botonEnviar.setHorizontalAlignment(JLabel.CENTER);
        botonEnviar.setVerticalAlignment(JLabel.CENTER);
        botonEnviar.setPreferredSize(new Dimension(100, 30));

        //button.addActionListener(login.validarCredenciales(usuario.getText(),contraseña.getPassword()));

        //Texto adicional
        JLabel usuariosExistentes = new JLabel("(Usuarios: usrAdministrador, usrCallCenter, usrAdministrativo, usrTecnico)");
        usuariosExistentes.setHorizontalTextPosition(JLabel.CENTER);
        usuariosExistentes.setVerticalTextPosition(JLabel.BOTTOM);
        usuariosExistentes.setHorizontalAlignment(JLabel.CENTER);
        usuariosExistentes.setVerticalAlignment(JLabel.BOTTOM);
        usuariosExistentes.setForeground(new Color(0, 0, 0));
        usuariosExistentes.setFont(new Font("Consolas",Font.PLAIN, 9));

        //Agregar items a la ventana

        this.add(panelIzquierdoUsuario);
        panelIzquierdoUsuario.add(textUsuario);
        this.add(panelIzquierdoContraseña);
        panelIzquierdoContraseña.add(textContraseña);
        this.add(panelDerecho);
        this.add(panelTitulo);
        panelTitulo.add(titulo);
        this.add(panelUsuario);
        panelUsuario.add(usuario);
        this.add(panelContraseña);
        panelContraseña.add(contraseña);
        this.add(panelBoton);
        panelBoton.add(botonEnviar);
        this.add(panelAdicional);
        panelAdicional.add(usuariosExistentes);

        //Propiedades de la ventana

        this.setSize(615,400);
        this.setLayout(null);
        this.setResizable(false);      //Evitar que la ventana pueda ser cambiada de tamaño
        this.setVisible(true);        //Hace el frame visible

    }

    public static void main(String[] args) {
        AppPrueba ventanaLogin = new AppPrueba();
    }
}

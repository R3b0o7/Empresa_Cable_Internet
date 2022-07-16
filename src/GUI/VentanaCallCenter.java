package GUI;

import Interfaz.ControllerAdministrador;
import Interfaz.ControllerCallCenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCallCenter extends JFrame implements ActionListener {

    ControllerCallCenter controller = ControllerCallCenter.getInstance();

    //Botones
    JButton botonReservarServicio;
    JButton botonAltaCliente;
    JButton botonListarServiciosPorEstado;
    JButton botonCerrarSesion;
    //Paneles
    //JPanel menuPrincipal;
    JPanel altaCliente;

    public VentanaCallCenter() {
        //Encabezado Ventana
        this.setTitle("Empresa de Cable Internet");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        ImageIcon image = new ImageIcon("C:\\Users\\Luciano\\OneDrive\\01. Facultad\\2022\\" +
                "4. Introducción a la Orientación a Objetos\\TPO\\_Empresa Cable e Internet\\TPO\\src\\GUI\\Logo.png"); //crea un icono de la imagen
        this.setIconImage(image.getImage());

        //Paneles --> (Ancho: 900,Alto: 600)
        //menuPrincipal = new JPanel();
        //menuPrincipal.setBackground(new Color(107,108,109));
        //menuPrincipal.setBounds(0, 50,900,450);

        JPanel menuSuperior = new JPanel();
        menuSuperior.setBackground(new Color(169, 169, 169));
        menuSuperior.setBounds(0, 0,900,40);

        JPanel inicio = new JPanel();
        inicio.setBackground(new Color(107,108,109));
        inicio.setBounds(0, 525,150,40);

        altaCliente = new JPanel();
        altaCliente.setBackground(new Color(107,108,109));
        altaCliente.setBounds(0, 50,900,450);


        //Botones Superiores

        botonReservarServicio = new JButton("Reservar servicio");
        botonReservarServicio.setHorizontalAlignment(JLabel.LEFT);
        botonReservarServicio.setBackground(Color.lightGray);

        botonAltaCliente = new JButton("Alta cliente");
        botonAltaCliente.setHorizontalAlignment(JLabel.CENTER);
        botonAltaCliente.setBackground(Color.lightGray);

        botonListarServiciosPorEstado = new JButton("Listar servicios por estado");
        botonListarServiciosPorEstado.setHorizontalAlignment(JLabel.RIGHT);
        botonListarServiciosPorEstado.setBackground(Color.lightGray);

        //Boton Inferior

        botonCerrarSesion = new JButton("Cerrar Sesión");
        botonCerrarSesion.setHorizontalAlignment(JLabel.CENTER);
        botonCerrarSesion.setBackground(Color.lightGray);
        botonCerrarSesion.addActionListener(this);

        //Agregar items a la ventana

        //this.add(menuPrincipal);
        this.add(menuSuperior);
        menuSuperior.add(botonReservarServicio);
        menuSuperior.add(botonAltaCliente);
        menuSuperior.add(botonListarServiciosPorEstado);
        this.add(inicio);
        inicio.add(botonCerrarSesion);

        //Ventana
        this.setSize(900,600);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(107,108,109));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==botonCerrarSesion){
            this.dispose();
            new VentanaLogin();
        }
    }
}

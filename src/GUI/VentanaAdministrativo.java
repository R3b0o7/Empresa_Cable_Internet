package GUI;

import Controladores.ControllerAdministrativo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAdministrativo extends JFrame implements ActionListener {
    ControllerAdministrativo controller = ControllerAdministrativo.getInstance();

    JPanel menuModificarServicio;
    JPanel menuGenerarFactura;
    JPanel menuListarFacturas;
    JButton botonModificarServicio;
    JButton botonListarFacturas;
    JButton botonGenerarFactura;
    JButton botonCerrarSesion;
    JLabel labelNroServicio;
    JTextField textNroServicio;
    JLabel labelTipoServicio;
    JComboBox tipo;
    JButton nroServicio;
    JTextArea textArea;
    JScrollPane scrollPane;

    public VentanaAdministrativo() {
        //Encabezado Ventana
        this.setTitle("Empresa de Cable Internet");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        ImageIcon image = new ImageIcon("C:\\Users\\Luciano\\OneDrive\\01. Facultad\\2022\\" +
                "4. Introducción a la Orientación a Objetos\\TPO\\_Empresa Cable e Internet\\TPO\\src\\GUI\\Logo.png"); //crea un icono de la imagen
        this.setIconImage(image.getImage());

        //Configuración básica de ventana
        JPanel menuSuperior = new JPanel();
        menuSuperior.setBackground(new Color(107,108,109));
        menuSuperior.setBounds(150, 0,750,40);

        JPanel inicio = new JPanel();
        inicio.setBackground(new Color(107,108,109));
        inicio.setBounds(0, 525,150,40);

        //Botones Superiores
        botonModificarServicio = new JButton("Modificar servicio");
        botonModificarServicio.setHorizontalAlignment(JLabel.CENTER);
        botonModificarServicio.setBackground(Color.lightGray);
        botonModificarServicio.addActionListener(this);

        botonListarFacturas = new JButton("Listar facturas");
        botonListarFacturas.setHorizontalAlignment(JLabel.LEFT);
        botonListarFacturas.setBackground(Color.lightGray);
        botonListarFacturas.addActionListener(this);

        botonGenerarFactura = new JButton("Generar factura");
        botonGenerarFactura.setHorizontalAlignment(JLabel.RIGHT);
        botonGenerarFactura.setBackground(Color.lightGray);
        botonGenerarFactura.addActionListener(this);

        //Boton Inferior

        botonCerrarSesion = new JButton("Cerrar Sesión");
        botonCerrarSesion.setHorizontalAlignment(JLabel.CENTER);
        botonCerrarSesion.setBackground(Color.lightGray);
        botonCerrarSesion.addActionListener(this);

        //Agregar items a la ventana

        //Botones superiores
        this.add(menuSuperior);
        menuSuperior.add(botonModificarServicio);
        menuSuperior.add(botonListarFacturas);
        menuSuperior.add(botonGenerarFactura);

        //Botones inicio
        this.add(inicio);
        inicio.add(botonCerrarSesion);

        //Ventana
        this.setSize(900,600);
        this.setLocation(510,240);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(107,108,109));

        //Sub menues

        //paneles submenues
        menuModificarServicio = new MenuModificarServicio();
        menuGenerarFactura = new MenuGenerarFactura();
        menuListarFacturas = new MenuListarFacturas();

        this.add(menuModificarServicio);
        this.add(menuGenerarFactura);
        this.add(menuListarFacturas);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==botonCerrarSesion){
            this.dispose();
            new VentanaLogin();
        }
        if(e.getSource() == botonModificarServicio){
            menuGenerarFactura.setVisible(false);
            menuGenerarFactura.setEnabled(false);
            menuListarFacturas.setVisible(false);
            menuListarFacturas.setEnabled(false);
            menuModificarServicio.setVisible(true);
            menuModificarServicio.setEnabled(true);
        }
        if(e.getSource()==botonGenerarFactura){
            menuListarFacturas.setVisible(false);
            menuListarFacturas.setEnabled(false);
            menuModificarServicio.setVisible(false);
            menuModificarServicio.setEnabled(false);
            menuGenerarFactura.setVisible(true);
            menuGenerarFactura.setEnabled(true);
        }
        if(e.getSource()==botonListarFacturas){
            menuModificarServicio.setVisible(false);
            menuModificarServicio.setEnabled(false);
            menuGenerarFactura.setVisible(false);
            menuGenerarFactura.setEnabled(false);
            menuListarFacturas.setVisible(true);
            menuListarFacturas.setEnabled(true);
        }

    }
}

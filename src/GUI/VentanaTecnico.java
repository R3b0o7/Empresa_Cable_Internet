package GUI;

import Interfaz.ControllerAdministrador;
import Interfaz.ControllerLogin;
import Interfaz.ControllerTecnico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaTecnico extends JFrame implements ActionListener {

    ControllerTecnico controller = ControllerTecnico.getInstance();

    JButton botonServiciosAsignados;
    JButton botonCargarDatosServicio;
    JButton botonCerrarSesion;
    JButton botonBuscar;
    JTextField textNroTecnico;
    JLabel labelNroTecnico;

    public VentanaTecnico() {
        //Encabezado Ventana
        this.setTitle("Empresa de Cable Internet");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        ImageIcon image = new ImageIcon("C:\\Users\\Luciano\\OneDrive\\01. Facultad\\2022\\" +
                "4. Introducción a la Orientación a Objetos\\TPO\\_Empresa Cable e Internet\\TPO\\src\\GUI\\Logo.png"); //crea un icono de la imagen
        this.setIconImage(image.getImage());

        //Paneles
        JPanel menuIzquierdo = new JPanel();
        menuIzquierdo.setBackground(Color.red);
        menuIzquierdo.setBounds(0, 180,150,200);

        JPanel menuSuperior = new JPanel();
        menuSuperior.setBackground(new Color(107,108,109));
        menuSuperior.setBounds(150, 0, 750, 40);

        JPanel inicio = new JPanel();
        inicio.setBackground(new Color(107,108,109));
        inicio.setBounds(0, 525, 150, 40);

        //Panel Superior

        botonServiciosAsignados = new JButton("Servicios asignados");
        botonServiciosAsignados.setHorizontalAlignment(JLabel.LEFT);
        botonServiciosAsignados.setBackground(Color.lightGray);
        botonServiciosAsignados.addActionListener(this);

        botonCargarDatosServicio = new JButton("Cargar datos de servicio");
        botonCargarDatosServicio.setHorizontalAlignment(JLabel.CENTER);
        botonCargarDatosServicio.setBackground(Color.lightGray);

        //Panel Lateral
        labelNroTecnico = new JLabel("Numero de tecnico:");
        labelNroTecnico.setHorizontalAlignment(JLabel.LEFT);
        labelNroTecnico.setBackground(Color.lightGray);
        labelNroTecnico.setForeground(new Color(255, 255, 255));
        labelNroTecnico.setFont(new Font("Consolas",Font.BOLD, 12));
        labelNroTecnico.setVisible(false);

        textNroTecnico = new JTextField("");
        textNroTecnico.setHorizontalAlignment(JTextField.CENTER);
        textNroTecnico.setPreferredSize(new Dimension(100, 18));
        textNroTecnico.setVisible(false);

        botonBuscar = new JButton("Buscar");
        botonBuscar.setHorizontalAlignment(JLabel.CENTER);
        botonBuscar.setBackground(Color.lightGray);
        botonBuscar.addActionListener(this);
        botonBuscar.setVisible(false);

        //Panel Inferior
        botonCerrarSesion = new JButton("Cerrar Sesión");
        botonCerrarSesion.setHorizontalAlignment(JLabel.CENTER);
        botonCerrarSesion.setBackground(Color.lightGray);
        botonCerrarSesion.addActionListener(this);

        //Agregar items a la ventana

        //Botones en menu lateral
        this.add(menuIzquierdo);
        menuIzquierdo.add(labelNroTecnico);
        menuIzquierdo.add(textNroTecnico);
        menuIzquierdo.add(botonBuscar);

        //Botones en menu superior
        this.add(menuSuperior);
        menuSuperior.add(botonServiciosAsignados);
        menuSuperior.add(botonCargarDatosServicio);

        //Botones menu inferior
        this.add(inicio);
        inicio.add(botonCerrarSesion);

        //Ventana
        this.setSize(900, 600);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(107, 108, 109));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonCerrarSesion) {
            this.dispose();
            new VentanaLogin();
        } else if (e.getSource() == botonServiciosAsignados){
            labelNroTecnico.setVisible(true);
            textNroTecnico.setVisible(true);
            botonBuscar.setVisible(true);
        } else if (e.getSource() == botonCargarDatosServicio){

        } else if (e.getSource() == botonBuscar){
            controller.getInstance().serviciosAsignados();
        }
    }
}

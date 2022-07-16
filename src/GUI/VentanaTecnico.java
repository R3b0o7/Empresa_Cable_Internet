package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaTecnico extends JFrame implements ActionListener {
    JButton botonServiciosAsignados;
    JButton botonCargarDatosServicio;
    JButton botonCerrarSesion;

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
        menuIzquierdo.setBounds(0, 0, 150, 520);

        JPanel menuSuperior = new JPanel();
        menuSuperior.setBackground(new Color(107,108,109));
        menuSuperior.setBounds(150, 0, 750, 40);

        JPanel inicio = new JPanel();
        inicio.setBackground(new Color(107,108,109));
        inicio.setBounds(0, 525, 150, 40);

        //Botones Superiores

        botonServiciosAsignados = new JButton("Servicios asignados");
        botonServiciosAsignados.setHorizontalAlignment(JLabel.LEFT);
        botonServiciosAsignados.setBackground(Color.lightGray);

        botonCargarDatosServicio = new JButton("Cargar datos de servicio");
        botonCargarDatosServicio.setHorizontalAlignment(JLabel.CENTER);
        botonCargarDatosServicio.setBackground(Color.lightGray);

        //Botones Laterales

        //Boton Inferior

        botonCerrarSesion = new JButton("Cerrar Sesión");
        botonCerrarSesion.setHorizontalAlignment(JLabel.CENTER);
        botonCerrarSesion.setBackground(Color.lightGray);
        botonCerrarSesion.addActionListener(this);

        //Agregar items a la ventana

        this.add(menuIzquierdo);
        //Aca van los botones laterales
        this.add(menuSuperior);
        menuSuperior.add(botonServiciosAsignados);
        menuSuperior.add(botonCargarDatosServicio);
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
        }
    }
}

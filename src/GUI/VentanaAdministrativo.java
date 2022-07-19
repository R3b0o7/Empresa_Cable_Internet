package GUI;

import Interfaz.ControllerAdministrativo;
import Interfaz.ControllerTecnico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaAdministrativo extends JFrame implements ActionListener {
    ControllerAdministrativo controller = ControllerAdministrativo.getInstance();

    JButton botonListarFacturas;
    JButton botonModificarServicio;
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

        //Paneles
        JPanel menuIzquierdo = new JPanel();
        menuIzquierdo.setBackground(Color.red);
        menuIzquierdo.setBounds(0, 180,150,200);

        JPanel menuSuperior = new JPanel();
        menuSuperior.setBackground(new Color(107,108,109));
        menuSuperior.setBounds(150, 0,750,40);

        JPanel inicio = new JPanel();
        inicio.setBackground(new Color(107,108,109));
        inicio.setBounds(0, 525,150,40);

        JPanel menuCentro = new JPanel();
        menuCentro.setBounds(210, 100,600,400);
        menuCentro.setBackground(new Color(107,108,109));
        menuCentro.setLayout(null);

        //Botones Superiores

        botonListarFacturas = new JButton("Listar facturas");
        botonListarFacturas.setHorizontalAlignment(JLabel.LEFT);
        botonListarFacturas.setBackground(Color.lightGray);
        botonListarFacturas.addActionListener(this);

        botonModificarServicio = new JButton("Modificar servicio");
        botonModificarServicio.setHorizontalAlignment(JLabel.CENTER);
        botonModificarServicio.setBackground(Color.lightGray);
        botonModificarServicio.addActionListener(this);

        botonGenerarFactura = new JButton("Generar factura");
        botonGenerarFactura.setHorizontalAlignment(JLabel.RIGHT);
        botonGenerarFactura.setBackground(Color.lightGray);
        botonGenerarFactura.addActionListener(this);

        //Botones Laterales

        labelNroServicio = new JLabel("Numero de servicio:");
        labelNroServicio.setHorizontalAlignment(JLabel.LEFT);
        labelNroServicio.setBackground(Color.lightGray);
        labelNroServicio.setForeground(new Color(255, 255, 255));
        labelNroServicio.setFont(new Font("Consolas",Font.BOLD, 12));
        labelNroServicio.setVisible(false);

        textNroServicio = new JTextField("");
        textNroServicio.setHorizontalAlignment(JTextField.CENTER);
        textNroServicio.setPreferredSize(new Dimension(100, 18));
        textNroServicio.setVisible(false);

        labelTipoServicio = new JLabel("Tipo de servicio:");
        labelTipoServicio.setHorizontalAlignment(JLabel.LEFT);
        labelTipoServicio.setBackground(Color.lightGray);
        labelTipoServicio.setForeground(new Color(255, 255, 255));
        labelTipoServicio.setFont(new Font("Consolas",Font.BOLD, 12));
        labelTipoServicio.setVisible(false);

        tipo = new JComboBox();
        tipo.addItem("Reparacion");
        tipo.addItem("Instalacion");
        tipo.setBounds(450,270,120,20);
        tipo.setVisible(false);

        nroServicio = new JButton("Buscar");
        nroServicio.setHorizontalAlignment(JLabel.CENTER);
        nroServicio.setBackground(Color.lightGray);
        nroServicio.addActionListener(this);
        nroServicio.setVisible(false);

        //Panel Central
        textArea = new JTextArea("");
        textArea.setText("");
        textArea.setAlignmentX(LEFT_ALIGNMENT);
        textArea.setLineWrap(true);
        textArea.setVisible(false);

        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(0, 0,600,150);
        scrollPane.setVisible(false);

        //Boton Inferior

        botonCerrarSesion = new JButton("Cerrar Sesión");
        botonCerrarSesion.setHorizontalAlignment(JLabel.CENTER);
        botonCerrarSesion.setBackground(Color.lightGray);
        botonCerrarSesion.addActionListener(this);

        //Agregar items a la ventana

        //Botones centrales
        this.add(menuCentro);
        menuCentro.add(scrollPane);

        //Botones laterales
        this.add(menuIzquierdo);
        menuIzquierdo.add(labelNroServicio);
        menuIzquierdo.add(textNroServicio);
        menuIzquierdo.add(labelTipoServicio);
        menuIzquierdo.add(tipo);
        menuIzquierdo.add(nroServicio);

        //Botones superiores
        this.add(menuSuperior);
        menuSuperior.add(botonListarFacturas);
        menuSuperior.add(botonModificarServicio);
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==botonCerrarSesion){
            this.dispose();
            new VentanaLogin();
        } else if (e.getSource() == botonGenerarFactura){

        } else if (e.getSource() == botonListarFacturas){

        } else if (e.getSource() == botonModificarServicio){
            labelNroServicio.setVisible(true);
            textNroServicio.setVisible(true);
            tipo.setVisible(true);
            nroServicio.setVisible(true);
            labelTipoServicio.setVisible(true);
        } else if (e.getSource() == nroServicio){
            textArea.setEditable(true);
            textArea.setText("dfs");
            scrollPane.setVisible(true);
            if (tipo.getSelectedItem().toString() == "Reparacion"){
                ArrayList<String> facturas = controller.getInstance().listarFacturas();
                facturas.add(tipo.getSelectedItem().toString());
            } else {
                ArrayList<String> facturas = controller.getInstance().listarFacturas();
                facturas.add(tipo.getSelectedItem().toString());
            }
            /*
            if (facturas!=null){
                for (int k=0;k<facturas.size();k++){
                    String texto = textArea.getText();
                    textArea.setText(texto+facturas.get(k)+"\n");
                    System.out.println(facturas.get(k));
                }
            }
            */
            textArea.setEditable(false);
        }
    }
}

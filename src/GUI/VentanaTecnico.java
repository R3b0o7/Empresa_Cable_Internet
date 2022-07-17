package GUI;

import Clases.Articulo;
import Interfaz.ControllerAdministrador;
import Interfaz.ControllerLogin;
import Interfaz.ControllerTecnico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaTecnico extends JFrame implements ActionListener {

    ControllerTecnico controller = ControllerTecnico.getInstance();
    ArrayList<String> servicios;

    JButton botonServiciosAsignados;
    JButton botonCargarDatosServicio;
    JButton botonCerrarSesion;
    JButton botonBuscar;
    JTextField textNroTecnico;
    JLabel labelNroTecnico;
    JTextArea textArea;
    JScrollPane scrollPane;
    JComboBox tipo;
    JLabel labelTipo;
    JComboBox material;
    JLabel labelMaterial;
    JTextField textCant;
    JLabel labelCant;
    JTextField textMatAdic;
    JLabel labelMatAdic;
    JTextField textCantAdic;
    JLabel labelCantAdic;
    JComboBox almuerzo;
    JLabel labelAlmuerzo;
    JTextField textCombustible;
    JLabel labelCombustible;
    JTextField textTiempo;
    JLabel labelTiempo;
    JButton cargarDatos;

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
        //menuIzquierdo.setBackground(new Color(107,108,109));
        menuIzquierdo.setBackground(Color.red);
        menuIzquierdo.setBounds(0, 180,150,200);

        JPanel menuSuperior = new JPanel();
        //menuSuperior.setBackground(new Color(107,108,109));
        menuSuperior.setBackground(Color.darkGray);
        menuSuperior.setBounds(150, 0, 750, 40);

        JPanel inicio = new JPanel();
        //inicio.setBackground(new Color(107,108,109));
        inicio.setBackground(Color.black);
        inicio.setBounds(0, 525, 150, 40);

        JPanel menuCentro = new JPanel();
        menuCentro.setBounds(210, 100,600,400);
        menuCentro.setBackground(new Color(107,108,109));
        menuCentro.setLayout(null);

        //Panel Superior
        botonServiciosAsignados = new JButton("Servicios asignados");
        botonServiciosAsignados.setHorizontalAlignment(JLabel.LEFT);
        botonServiciosAsignados.setBackground(Color.lightGray);
        botonServiciosAsignados.addActionListener(this);

        botonCargarDatosServicio = new JButton("Cargar datos de servicio");
        botonCargarDatosServicio.setHorizontalAlignment(JLabel.CENTER);
        botonCargarDatosServicio.setBackground(Color.lightGray);
        botonCargarDatosServicio.addActionListener(this);

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

        //Panel Central
        textArea = new JTextArea("");
        textArea.setText("");
        textArea.setAlignmentX(LEFT_ALIGNMENT);
        textArea.setLineWrap(true);
        textArea.setVisible(false);

        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(0, 0,600,150);
        scrollPane.setVisible(false);

        labelMaterial = new JLabel("Tipo de material: ");
        labelMaterial.setHorizontalAlignment(JLabel.LEFT);
        labelMaterial.setBackground(Color.lightGray);
        labelMaterial.setForeground(new Color(255, 255, 255));
        labelMaterial.setFont(new Font("Consolas",Font.BOLD, 12));
        labelMaterial.setBounds(20,180,200,20);
        labelMaterial.setVisible(false);

        material = new JComboBox();
        material.addItem("Cable");
        material.addItem("Conector_coaxial_RG6");
        material.addItem("Divisor");
        material.addItem("Modem");
        material.addItem("Decodificador");
        material.setBounds(5,210,145,20);
        material.setVisible(false);

        labelCant = new JLabel("Cantidad: ");
        labelCant.setHorizontalAlignment(JLabel.LEFT);
        labelCant.setBackground(Color.lightGray);
        labelCant.setForeground(new Color(255, 255, 255));
        labelCant.setFont(new Font("Consolas",Font.BOLD, 12));
        labelCant.setBounds(40,240,200,20);
        labelCant.setVisible(false);

        textCant = new JTextField();
        textCant.setHorizontalAlignment(JTextField.LEFT);
        textCant.setBounds(35, 270,80,20);
        textCant.setVisible(false);

        labelMatAdic = new JLabel("Material adicional: ");
        labelMatAdic.setHorizontalAlignment(JLabel.LEFT);
        labelMatAdic.setBackground(Color.lightGray);
        labelMatAdic.setForeground(new Color(255, 255, 255));
        labelMatAdic.setFont(new Font("Consolas",Font.BOLD, 12));
        labelMatAdic.setBounds(170,180,200,20);
        labelMatAdic.setVisible(false);

        textMatAdic = new JTextField();
        textMatAdic.setHorizontalAlignment(JTextField.LEFT);
        textMatAdic.setBounds(180, 210,100,20);
        textMatAdic.setVisible(false);

        labelCantAdic = new JLabel("Cantidad:");
        labelCantAdic.setHorizontalAlignment(JLabel.LEFT);
        labelCantAdic.setBackground(Color.lightGray);
        labelCantAdic.setForeground(new Color(255, 255, 255));
        labelCantAdic.setFont(new Font("Consolas",Font.BOLD, 12));
        labelCantAdic.setBounds(195,240,200,20);
        labelCantAdic.setVisible(false);

        textCantAdic = new JTextField();
        textCantAdic.setHorizontalAlignment(JTextField.LEFT);
        textCantAdic.setBounds(190, 270,80,20);
        textCantAdic.setVisible(false);

        labelAlmuerzo = new JLabel("Almuerzo:");
        labelAlmuerzo.setHorizontalAlignment(JLabel.LEFT);
        labelAlmuerzo.setBackground(Color.lightGray);
        labelAlmuerzo.setForeground(new Color(255, 255, 255));
        labelAlmuerzo.setFont(new Font("Consolas",Font.BOLD, 12));
        labelAlmuerzo.setBounds(330,180,200,20);
        labelAlmuerzo.setVisible(false);

        almuerzo = new JComboBox();
        almuerzo.addItem("Si");
        almuerzo.addItem("No");
        almuerzo.setBounds(335,210,50,20);
        almuerzo.setVisible(false);

        labelTiempo = new JLabel("Tiempo trabajado:");
        labelTiempo.setHorizontalAlignment(JLabel.LEFT);
        labelTiempo.setBackground(Color.lightGray);
        labelTiempo.setForeground(new Color(255, 255, 255));
        labelTiempo.setFont(new Font("Consolas",Font.BOLD, 12));
        labelTiempo.setBounds(310,240,200,20);
        labelTiempo.setVisible(false);

        textTiempo = new JTextField();
        textTiempo.setHorizontalAlignment(JTextField.LEFT);
        textTiempo.setBounds(325, 270,80,20);
        textTiempo.setVisible(false);

        labelCombustible = new JLabel("Litros de combustible:");
        labelCombustible.setHorizontalAlignment(JLabel.LEFT);
        labelCombustible.setBackground(Color.lightGray);
        labelCombustible.setForeground(new Color(255, 255, 255));
        labelCombustible.setFont(new Font("Consolas",Font.BOLD, 12));
        labelCombustible.setBounds(430,180,200,20);
        labelCombustible.setVisible(false);

        textCombustible = new JTextField();
        textCombustible.setHorizontalAlignment(JTextField.LEFT);
        textCombustible.setBounds(470, 210,80,20);
        textCombustible.setVisible(false);

        labelTipo = new JLabel("Tipo de servicio:");
        labelTipo.setHorizontalAlignment(JLabel.LEFT);
        labelTipo.setBackground(Color.lightGray);
        labelTipo.setForeground(new Color(255, 255, 255));
        labelTipo.setFont(new Font("Consolas",Font.BOLD, 12));
        labelTipo.setBounds(450,240,200,20);
        labelTipo.setVisible(false);

        tipo = new JComboBox();
        tipo.addItem("Reparacion");
        tipo.addItem("Instalacion");
        tipo.setBounds(450,270,120,20);
        tipo.setVisible(false);

        cargarDatos = new JButton("Cargar");
        cargarDatos.setHorizontalAlignment(JLabel.CENTER);
        cargarDatos.setBackground(Color.lightGray);
        cargarDatos.setBounds(250,360,100,30);
        cargarDatos.addActionListener(this);
        cargarDatos.setVisible(false);

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

        //Botones menu central
        this.add(menuCentro);
        menuCentro.add(cargarDatos);
        menuCentro.add(scrollPane);
        menuCentro.add(labelMaterial);
        menuCentro.add(material);
        menuCentro.add(labelCant);
        menuCentro.add(textCant);
        menuCentro.add(textMatAdic);
        menuCentro.add(labelMatAdic);
        menuCentro.add(labelCantAdic);
        menuCentro.add(textCantAdic);
        menuCentro.add(almuerzo);
        menuCentro.add(labelAlmuerzo);
        menuCentro.add(labelTiempo);
        menuCentro.add(textTiempo);
        menuCentro.add(textCombustible);
        menuCentro.add(labelCombustible);
        menuCentro.add(labelTipo);
        menuCentro.add(tipo);

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
            labelTipo.setVisible(false);
            tipo.setVisible(false);
            material.setVisible(false);
            labelMaterial.setVisible(false);
            textCant.setVisible(false);
            labelCant.setVisible(false);
            textMatAdic.setVisible(false);
            labelMatAdic.setVisible(false);
            textCantAdic.setVisible(false);
            labelCantAdic.setVisible(false);
            almuerzo.setVisible(false);
            labelAlmuerzo.setVisible(false);
            textCombustible.setVisible(false);
            labelCombustible.setVisible(false);
            textTiempo.setVisible(false);
            labelTiempo.setVisible(false);
            cargarDatos.setVisible(false);
            scrollPane.setVisible(false);
        } else if (e.getSource() == botonCargarDatosServicio){
            labelTipo.setVisible(true);
            tipo.setVisible(true);
            material.setVisible(true);
            labelMaterial.setVisible(true);
            textCant.setVisible(true);
            labelCant.setVisible(true);
            textMatAdic.setVisible(true);
            labelMatAdic.setVisible(true);
            textCantAdic.setVisible(true);
            labelCantAdic.setVisible(true);
            almuerzo.setVisible(true);
            labelAlmuerzo.setVisible(true);
            textCombustible.setVisible(true);
            labelCombustible.setVisible(true);
            textTiempo.setVisible(true);
            labelTiempo.setVisible(true);
            cargarDatos.setVisible(true);
            labelNroTecnico.setVisible(true);
            textNroTecnico.setVisible(true);
            botonBuscar.setVisible(true);
        } else if (e.getSource() == botonBuscar){
            textArea.setEditable(true);
            textArea.setText("");
            servicios = controller.getInstance().serviciosAsignados(textNroTecnico.getText());
            scrollPane.setVisible(true);
            if (servicios!=null){
                for (int k=0;k<servicios.size();k++){
                    String texto = textArea.getText();
                    textArea.setText(texto+servicios.get(k)+"\n");
                    System.out.println(servicios.get(k));
                }
            }
            textArea.setEditable(false);
        }
    }
}

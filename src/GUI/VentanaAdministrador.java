package GUI;
import Interfaz.ControllerAdministrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
ad
public class VentanaAdministrador extends JFrame implements ActionListener {

    ControllerAdministrador controller = ControllerAdministrador.getInstance();

    //Botones superiores
    JButton botonABMtecnico;
    JButton botonAMBarticulo;
    JButton botonConfigurarParametros;

    //Botones Inferior
    JButton botonCerrarSesion;

    //Sub Menu
    JPanel menuABMTec;
    JPanel altaTecnico;
    JPanel menuABMArt;
    JPanel menuParametros;
    JButton botonAltaTecnico;
    JButton botonBajaTecnico;
    JButton botonModificaTecnico;
    JList listaTecnicos;


    public VentanaAdministrador(){
        //Encabezado Ventana
        this.setTitle("Empresa de Cable Internet");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        ImageIcon image = new ImageIcon("C:\\Users\\Luciano\\OneDrive\\01. Facultad\\2022\\" +
                "4. Introducción a la Orientación a Objetos\\TPO\\_Empresa Cable e Internet\\TPO\\src\\GUI\\Logo.png"); //crea un icono de la imagen
        this.setIconImage(image.getImage());

        //Paneles -> setSize(Alto: 900,Ancho: 600);
        menuABMTec = new JPanel();
        menuABMTec.setBackground(Color.lightGray);
        menuABMTec.setBounds(0, 180,600,200);

        altaTecnico = new JPanel();
        altaTecnico.setBackground(Color.lightGray);
        altaTecnico.setBounds(0, 380,600,200);

        JPanel menuSuperior = new JPanel();
        menuSuperior.setBackground(new Color(107,108,109));
        menuSuperior.setBounds(150, 0,750,40);

        JPanel inicio = new JPanel();
        inicio.setBackground(new Color(107,108,109));
        inicio.setBounds(0, 525,150,40);

        //Botones Superiores

        botonABMtecnico = new JButton("ABM Técnico");
        botonABMtecnico.setHorizontalAlignment(JLabel.LEFT);
        botonABMtecnico.setBackground(Color.lightGray);
        botonABMtecnico.addActionListener(this);

        botonAMBarticulo = new JButton("ABM Articulos");
        botonAMBarticulo.setHorizontalAlignment(JLabel.CENTER);
        botonAMBarticulo.setBackground(Color.lightGray);

        botonConfigurarParametros = new JButton("Configurar Parametros");
        botonConfigurarParametros.setHorizontalAlignment(JLabel.RIGHT);
        botonConfigurarParametros.setBackground(Color.lightGray);

        //Botones Laterales submenu tecnico

        botonAltaTecnico = new JButton("Alta Tecnico");
        botonAltaTecnico.setHorizontalAlignment(JLabel.LEFT);
        botonAltaTecnico.setVerticalAlignment(JLabel.BOTTOM);
        botonAltaTecnico.setBackground(Color.lightGray);
        botonAltaTecnico.addActionListener(this);

        botonBajaTecnico = new JButton("Baja Tecnico");
        botonBajaTecnico.setHorizontalAlignment(JLabel.LEFT);
        botonBajaTecnico.setVerticalAlignment(JLabel.BOTTOM);
        botonBajaTecnico.setBackground(Color.lightGray);
        botonBajaTecnico.addActionListener(this);

        botonModificaTecnico = new JButton("Modificar Tecnico");
        botonModificaTecnico.setHorizontalAlignment(JLabel.LEFT);
        botonModificaTecnico.setVerticalAlignment(JLabel.BOTTOM);
        botonModificaTecnico.setBackground(Color.lightGray);
        botonModificaTecnico.addActionListener(this);

        //armado de panel de altaTecnico
        JTextField fieldNroDoc = new JTextField();
        fieldNroDoc.setPreferredSize(new Dimension(100, 20));

        JTextField fieldNombre = new JTextField();
        fieldNombre.setPreferredSize(new Dimension(200, 20));

        JTextField fieldDomicilio = new JTextField();
        fieldDomicilio.setPreferredSize(new Dimension(200, 20));

        JButton buttonGrabarCliente = new JButton("Grabar Cliente");
        buttonGrabarCliente.addActionListener(this);

        JLabel lblNroDoc = new JLabel("Número de documento");
        JLabel lblDomLeg = new JLabel("Domicilio legal");
        JLabel lblDomPer = new JLabel("Domicilio Personal");

//        JPanel panel1 = new JPanel(new BorderLayout());
//        panel1.add(lblNroDoc, BorderLayout.WEST);
//        panel1.add(fieldNroDoc, BorderLayout.CENTER);
//        JPanel panel2 = new JPanel(new BorderLayout());
//        panel2.add(lblDomLeg, BorderLayout.WEST);
//        panel2.add(fieldDomicilioLegal, BorderLayout.CENTER);
//        JPanel panel3 = new JPanel(new BorderLayout());
//        panel3.add(lblDomPer, BorderLayout.WEST);
//        panel3.add(fieldDomicilioPersonal, BorderLayout.CENTER);


        //Boton Inferior

        botonCerrarSesion = new JButton("Cerrar Sesión");
        botonCerrarSesion.setHorizontalAlignment(JLabel.CENTER);
        botonCerrarSesion.setBackground(Color.lightGray);
        botonCerrarSesion.addActionListener(this);

        //Listas
        listaTecnicos = new JList();
        listaTecnicos.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
        listaTecnicos.setAlignmentY(JPanel.TOP_ALIGNMENT);
        listaTecnicos.setModel(controller.listModelTecnico());


        //Agregar items a la ventana
        this.add(menuABMTec);
        this.add(menuSuperior);
        menuSuperior.add(botonABMtecnico);
        menuSuperior.add(botonAMBarticulo);
        menuSuperior.add(botonConfigurarParametros);
        this.add(inicio);
        inicio.add(botonCerrarSesion);

        //armado de menues izquierda
        menuABMTec.add(botonAltaTecnico);
        menuABMTec.add(botonBajaTecnico);
        menuABMTec.add(botonModificaTecnico);
        menuABMTec.add(listaTecnicos);
        menuABMTec.setVisible(false);

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
            VentanaLogin.getInstance();
        }
        if (e.getSource()==botonABMtecnico){
            menuABMTec.setVisible(true);
        }
        if (e.getSource()==botonABMtecnico){
            menuABMTec.setVisible(true);
        }
        if (e.getSource()==botonBajaTecnico){
            if(listaTecnicos.getSelectedValue() == null){
                JOptionPane.showMessageDialog(null,"Seleccione un técnico.");
            } else {
                JOptionPane.showMessageDialog(null,listaTecnicos.getSelectedValue());
                String id = listaTecnicos.getSelectedValue().toString().substring(0,2).replaceAll(" ", "");
                Integer idInt = Integer.parseInt(id);
                controller.darDeBajaTecnico(idInt);
                listaTecnicos.setModel(controller.listModelTecnico());
            }

        }
    }
}

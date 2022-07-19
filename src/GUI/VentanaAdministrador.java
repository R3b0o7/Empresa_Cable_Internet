package GUI;
import Interfaz.ControllerAdministrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    JPanel pnlAltaTecnico;
    JPanel pnlModificarTecnico;
    JPanel menuABMArt;
    JPanel menuParametria;
    JButton botonAltaTecnico;
    JButton botonBajaTecnico;
    JButton botonModificaTecnico;
    JButton botonRefrescar;
    JList listaTecnicos;
    JScrollPane scroll;


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
        menuABMTec.setBounds(80, 60,735,400);
        menuABMTec.setLayout(new FlowLayout());

        menuABMArt = new MenuABMArticulo();

        menuParametria = new MenuParametria();

        JPanel menuSuperior = new JPanel();
        menuSuperior.setBackground(new Color(169, 169, 169));
        menuSuperior.setBounds(0, 0,900,40);

        JPanel inicio = new JPanel();
        inicio.setBackground(new Color(107,108,109));
        inicio.setBounds(0, 525,150,40);

        this.pnlAltaTecnico = new PanelAltaTecnico();
        this.pnlModificarTecnico = new PanelModificarTecnico();

        //Botones Superiores

        botonABMtecnico = new JButton("ABM Técnico");
        botonABMtecnico.setHorizontalAlignment(JLabel.LEFT);
        botonABMtecnico.setBackground(Color.lightGray);
        botonABMtecnico.addActionListener(this);

        botonAMBarticulo = new JButton("ABM Articulos");
        botonAMBarticulo.setHorizontalAlignment(JLabel.CENTER);
        botonAMBarticulo.setBackground(Color.lightGray);
        botonAMBarticulo.addActionListener(this);

        botonConfigurarParametros = new JButton("Configurar Parametros");
        botonConfigurarParametros.setHorizontalAlignment(JLabel.RIGHT);
        botonConfigurarParametros.setBackground(Color.lightGray);
        botonConfigurarParametros.addActionListener(this);

        //Botones Laterales submenu tecnico

        botonAltaTecnico = new JButton("Alta Tecnico");
        botonAltaTecnico.setHorizontalAlignment(JLabel.LEFT);
        botonAltaTecnico.setVerticalAlignment(JLabel.BOTTOM);
        //botonAltaTecnico.setBackground(Color.lightGray);
        botonAltaTecnico.addActionListener(this);

        botonBajaTecnico = new JButton("Baja Tecnico");
        botonBajaTecnico.setHorizontalAlignment(JLabel.LEFT);
        botonBajaTecnico.setVerticalAlignment(JLabel.BOTTOM);
        //botonBajaTecnico.setBackground(Color.lightGray);

        botonBajaTecnico.addActionListener(this);
        botonBajaTecnico.setHorizontalAlignment(JLabel.CENTER);
        botonBajaTecnico.setVerticalAlignment(JLabel.BOTTOM);

        botonModificaTecnico = new JButton("Modificar Tecnico");
        botonModificaTecnico.setHorizontalAlignment(JLabel.LEFT);
        botonModificaTecnico.setVerticalAlignment(JLabel.BOTTOM);
        //botonModificaTecnico.setBackground(Color.lightGray);
        botonModificaTecnico.addActionListener(this);

        botonRefrescar = new JButton("Refrescar");
        botonRefrescar.setHorizontalAlignment(JLabel.LEFT);
        botonRefrescar.setVerticalAlignment(JLabel.BOTTOM);
        //botonRefrescar.setBackground(Color.lightGray);
        botonRefrescar.addActionListener(this);

        //Boton Inferior

        botonCerrarSesion = new JButton("Cerrar Sesión");
        botonCerrarSesion.setHorizontalAlignment(JLabel.CENTER);
        botonCerrarSesion.setBackground(Color.lightGray);
        botonCerrarSesion.addActionListener(this);

        //Listas

        listaTecnicos = new JList();
        listaTecnicos.setVisibleRowCount(10);
        listaTecnicos.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        listaTecnicos.setAlignmentY(JPanel.CENTER_ALIGNMENT);
        listaTecnicos.setModel(controller.listModelTecnico());
        scroll = new JScrollPane(listaTecnicos);

        //armado de submenu
        menuABMTec.add(botonAltaTecnico);
        menuABMTec.add(botonBajaTecnico);
        menuABMTec.add(botonModificaTecnico);
        menuABMTec.add(botonRefrescar);
        menuABMTec.add(scroll);
        menuABMTec.add(pnlAltaTecnico);
        menuABMTec.add(pnlModificarTecnico);
        menuABMTec.setVisible(false);
        menuABMTec.setEnabled(false);

        //Agregar items a la ventana
        this.add(menuABMTec);
        this.add(menuABMArt);
        this.add(menuParametria);
        this.add(menuSuperior);
        menuSuperior.add(botonABMtecnico);
        menuSuperior.add(botonAMBarticulo);
        menuSuperior.add(botonConfigurarParametros);
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
            VentanaLogin.getInstance();
        }
        if (e.getSource()==botonABMtecnico){
            menuABMArt.setVisible(false);
            menuABMArt.setEnabled(false);
            menuParametria.setVisible(false);
            menuParametria.setEnabled(false);
            menuABMTec.setVisible(true);
            menuABMTec.setEnabled(true);
            pnlAltaTecnico.setVisible(false);
            pnlAltaTecnico.setEnabled(false);
            pnlModificarTecnico.setVisible(false);
            pnlModificarTecnico.setEnabled(false);
        }
        if (e.getSource()==botonAMBarticulo){
            menuABMTec.setVisible(false);
            menuABMTec.setEnabled(false);
            menuParametria.setVisible(false);
            menuParametria.setEnabled(false);
            menuABMArt.setVisible(true);
            menuABMArt.setEnabled(true);
        }
        if (e.getSource()==botonConfigurarParametros){
            menuABMTec.setVisible(false);
            menuABMTec.setEnabled(false);
            menuABMArt.setVisible(false);
            menuABMArt.setEnabled(false);
            menuParametria.setVisible(true);
            menuParametria.setEnabled(true);
        }
        if (e.getSource()==botonAltaTecnico){
            pnlAltaTecnico.setVisible(true);
            pnlAltaTecnico.setEnabled(true);
            pnlModificarTecnico.setVisible(false);
            pnlModificarTecnico.setEnabled(false);

        }
        if (e.getSource()==botonRefrescar){
            pnlAltaTecnico.setVisible(false);
            pnlAltaTecnico.setEnabled(false);
            pnlModificarTecnico.setVisible(false);
            pnlModificarTecnico.setEnabled(false);
            listaTecnicos.setModel(controller.listModelTecnico());
        }
        if (e.getSource()==botonBajaTecnico){
            listaTecnicos.setModel(controller.listModelTecnico());
            pnlAltaTecnico.setVisible(false);
            pnlAltaTecnico.setEnabled(false);
            pnlModificarTecnico.setVisible(false);
            pnlModificarTecnico.setEnabled(false);
            menuABMArt.setVisible(false);
            menuABMArt.setEnabled(false);

            if(listaTecnicos.getSelectedValue() == null){
                JOptionPane.showMessageDialog(null,"Seleccione un técnico.");
            } else {
                String id = listaTecnicos.getSelectedValue().toString().substring(0,2).replaceAll(" ", "");
                Integer idInt = Integer.parseInt(id);
                controller.darDeBajaTecnico(idInt);
                listaTecnicos.setModel(controller.listModelTecnico());
            }
        }
        if (e.getSource()==botonModificaTecnico){
            listaTecnicos.setModel(controller.listModelTecnico());
            pnlAltaTecnico.setVisible(false);
            pnlAltaTecnico.setEnabled(false);
            pnlModificarTecnico.setVisible(true);
            pnlModificarTecnico.setEnabled(true);
        }
    }
}

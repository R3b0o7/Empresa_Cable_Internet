package GUI;

import Controladores.ControllerAdministrativo;
import Controladores.ControllerTecnico;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanTecnicoAlt extends JFrame implements ActionListener {

    private final JButton botonCerrarSesion;
    JButton btnServiciosAsignados;
    JButton btnCargaDatos;
    JPanel pnlIngresoTecnico;
    JLabel lblIngresoTecnico;
    JTextField fldIdTecnico;
    JButton btnBuscarServicios;
    JPanel pnlListaServicios;
    JList listaServiciosAsignados;
    JScrollPane scrollListaServicios;
    JTextArea texaDetalleServicio;

    JPanel pnlModMaterial;
    JComboBox comboMaterial;
    JLabel lblCantMaterial;
    JTextField fldCantMaterial;
    JButton btnCargarMaterial;

    public VentanTecnicoAlt(){

        //Encabezado Ventana
        this.setTitle("Empresa de Cable Internet");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        ImageIcon image = new ImageIcon("C:\\Users\\Luciano\\OneDrive\\01. Facultad\\2022\\" +
                "4. Introducción a la Orientación a Objetos\\TPO\\_Empresa Cable e Internet\\TPO\\src\\GUI\\Logo.png"); //crea un icono de la imagen
        this.setIconImage(image.getImage());

        JPanel menuSuperior = new JPanel();
        menuSuperior.setBackground(new Color(169, 169, 169));
        menuSuperior.setBounds(0, 0,900,40);

        JPanel inicio = new JPanel();
        inicio.setBackground(new Color(107,108,109));
        inicio.setBounds(0, 525,150,40);

        pnlIngresoTecnico = new JPanel();
        pnlIngresoTecnico.setBackground(new Color(169, 169, 169));
        pnlIngresoTecnico.setBounds(0, 50,900,40);
        pnlIngresoTecnico.setPreferredSize(new Dimension(900, 50));

        pnlListaServicios = new JPanel();
        pnlListaServicios.setBackground(new Color(169, 169, 0));
        pnlListaServicios.setBounds(0, 100,900,100);
        pnlListaServicios.setPreferredSize(new Dimension(900, 100));

        pnlModMaterial = new JPanel();
        pnlModMaterial.setBackground(new Color(169, 169, 169));
        pnlModMaterial.setBounds(0, 200,900,40);
        pnlModMaterial.setPreferredSize(new Dimension(900, 50));

        //menu Superior

        btnServiciosAsignados = new JButton("Servicios asignados");
        btnServiciosAsignados.setHorizontalAlignment(JLabel.LEFT);
        btnServiciosAsignados.setBackground(Color.lightGray);
        btnServiciosAsignados.addActionListener(this);

        btnCargaDatos = new JButton("Cargar datos y finalizar");
        btnCargaDatos.setHorizontalAlignment(JLabel.CENTER);
        btnCargaDatos.setBackground(Color.lightGray);
        btnCargaDatos.addActionListener(this);

        menuSuperior.add(btnServiciosAsignados);
        menuSuperior.add(btnCargaDatos);

        //Cierre sesion

        botonCerrarSesion = new JButton("Cerrar Sesión");
        botonCerrarSesion.setHorizontalAlignment(JLabel.CENTER);
        botonCerrarSesion.setBackground(Color.lightGray);
        botonCerrarSesion.addActionListener(this);

        inicio.add(botonCerrarSesion);

        //panel ingreso tecnico
        lblIngresoTecnico = new JLabel("Numero de tecnico:");
//        lblIngresoTecnico.setHorizontalAlignment(JLabel.LEFT);
        lblIngresoTecnico.setBackground(Color.lightGray);
        lblIngresoTecnico.setForeground(new Color(255, 255, 255));
        lblIngresoTecnico.setFont(new Font("Consolas",Font.BOLD, 12));

        fldIdTecnico = new JTextField(5);
        fldIdTecnico.setHorizontalAlignment(JTextField.CENTER);

        btnBuscarServicios = new JButton("Buscar");
        btnBuscarServicios.setHorizontalAlignment(JLabel.CENTER);
        btnBuscarServicios.setBackground(Color.lightGray);
        btnBuscarServicios.addActionListener(this);

        pnlIngresoTecnico.add(lblIngresoTecnico);
        pnlIngresoTecnico.add(fldIdTecnico);
        pnlIngresoTecnico.add(btnBuscarServicios);

        //panel listaServicios
        listaServiciosAsignados = new JList();
        listaServiciosAsignados.setVisibleRowCount(5);
        listaServiciosAsignados.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        listaServiciosAsignados.setAlignmentY(JPanel.TOP_ALIGNMENT);
        scrollListaServicios = new JScrollPane(listaServiciosAsignados);
        scrollListaServicios.setPreferredSize(new Dimension(100, 90));
        listaServiciosAsignados.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    ControllerTecnico.getInstance().setServicioSeleccionado((Integer) listaServiciosAsignados.getSelectedValue());
                    texaDetalleServicio.setText(ControllerTecnico.getInstance().getDetalleServicioSeleccionado());
                } catch (Exception exc){

                }
            }
        });

        texaDetalleServicio = new JTextArea();
        texaDetalleServicio.setPreferredSize(new Dimension(500, 90));
        texaDetalleServicio.setAlignmentX(LEFT_ALIGNMENT);
        texaDetalleServicio.setLineWrap(true);

        pnlListaServicios.add(scrollListaServicios);
        pnlListaServicios.add(texaDetalleServicio);

        // panel modificar materiales

        comboMaterial = new JComboBox();
        comboMaterial.addItem("Cable");
        comboMaterial.addItem("Conector_coaxial_RG6");
        comboMaterial.addItem("Divisor");
        comboMaterial.addItem("Modem");
        comboMaterial.addItem("Decodificador");
        comboMaterial.setBounds(5,210,145,20);

        lblCantMaterial = new JLabel("Cantidad: ");
        lblCantMaterial.setHorizontalAlignment(JLabel.LEFT);
        lblCantMaterial.setBackground(Color.lightGray);
        lblCantMaterial.setForeground(new Color(255, 255, 255));
        lblCantMaterial.setFont(new Font("Consolas",Font.BOLD, 12));
        lblCantMaterial.setBounds(40,240,200,20);

        fldCantMaterial = new JTextField(5);
        fldCantMaterial.setHorizontalAlignment(JTextField.LEFT);

        btnCargarMaterial = new JButton("Agregar");
        btnCargarMaterial.setHorizontalAlignment(JLabel.CENTER);
        btnCargarMaterial.setBackground(Color.lightGray);
        btnCargarMaterial.setBounds(25,320,100,30);
        btnCargarMaterial.addActionListener(this);

        pnlModMaterial.add(comboMaterial);
        pnlModMaterial.add(lblCantMaterial);
        pnlModMaterial.add(fldCantMaterial);
        pnlModMaterial.add(btnCargarMaterial);

        //Agregar items a la ventana
        this.add(pnlIngresoTecnico);
        this.add(pnlListaServicios);
        this.add(pnlModMaterial);


        this.add(menuSuperior);
        this.add(inicio);


        //ventana
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
        }
        if(e.getSource()==btnBuscarServicios){
            texaDetalleServicio.setText("");
            int nroTec = 0;
            try{
                nroTec = Integer.parseInt(fldIdTecnico.getText());
            } catch (Exception exc){
                JOptionPane.showMessageDialog(null, "Valor inválido");
                return;
            }
            ListModel<Integer> listModel = ControllerTecnico.getInstance().listModelServiciosAsignados(nroTec);
            if(listModel.getSize()==0){
                JOptionPane.showMessageDialog(null, "No posee servicios asignados");
            }
            listaServiciosAsignados.setModel(listModel);
        }
    }
}

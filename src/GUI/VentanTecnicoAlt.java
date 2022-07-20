package GUI;

import Controladores.ControllerTecnico;
import Enumeraciones.Articulos;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanTecnicoAlt extends JFrame implements ActionListener {

    private final JButton botonCerrarSesion;
    private final JTextField fldMaterialAdPrecio;
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
    JButton btnActualizarListado;

    JPanel pnlModMaterial;
    JComboBox comboMaterial;
    JLabel lblCantMaterial;
    JTextField fldCantMaterial;
    JButton btnCargarMaterial;

    JPanel pnlMaterialAdicional;
    JTextField fldMaterialAd;
    JLabel lblMaterialAd;
    JTextField fldPrecioMaterialAd;
    JButton btnCargarMaterialAd;

    JPanel pnlAlmuerzoComb;
    JLabel lblAlmuerzo;
    JComboBox comboAlmuerzo;
    JLabel lblCombustible;
    JTextField fldCombustible;
    JButton btnCargarAlmuerzoComb;

    JPanel pnlTiempo;
    JLabel lblTiempo;
    JTextField fldTiempo;
    JButton btnCargarTiempo;

    JPanel pnlFinalizar;
    JButton btnFinalizarServicio;

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
        pnlListaServicios.setBackground(new Color(169, 169, 169));
        pnlListaServicios.setBounds(0, 100,900,100);
        pnlListaServicios.setPreferredSize(new Dimension(900, 100));

        pnlModMaterial = new JPanel();
        pnlModMaterial.setBackground(new Color(169, 169, 169));
        pnlModMaterial.setBounds(0, 200,900,40);
        pnlModMaterial.setPreferredSize(new Dimension(900, 50));

        pnlMaterialAdicional = new JPanel();
        pnlMaterialAdicional.setBackground(new Color(169, 169, 169));
        pnlMaterialAdicional.setBounds(0, 250,900,40);
        pnlMaterialAdicional.setPreferredSize(new Dimension(900, 50));

        pnlAlmuerzoComb = new JPanel();
        pnlAlmuerzoComb.setBackground(new Color(169, 169, 169));
        pnlAlmuerzoComb.setBounds(0, 300,900,40);
        pnlAlmuerzoComb.setPreferredSize(new Dimension(900, 50));

        pnlTiempo = new JPanel();
        pnlTiempo.setBackground(new Color(169, 169, 169));
        pnlTiempo.setBounds(0, 350,900,40);
        pnlTiempo.setPreferredSize(new Dimension(900, 50));

        pnlFinalizar = new JPanel();
        pnlFinalizar.setBackground(new Color(169, 169, 169));
        pnlFinalizar.setBounds(0, 400,900,40);
        pnlFinalizar.setPreferredSize(new Dimension(900, 50));

        //menu Superior

        btnServiciosAsignados = new JButton("Servicios asignados");
        btnServiciosAsignados.setHorizontalAlignment(JLabel.LEFT);
        btnServiciosAsignados.setBackground(Color.lightGray);
        btnServiciosAsignados.addActionListener(this);

        btnCargaDatos = new JButton("Cargar datos y finalizar");
        btnCargaDatos.setHorizontalAlignment(JLabel.CENTER);
        btnCargaDatos.setBackground(Color.lightGray);
        btnCargaDatos.addActionListener(this);

//        menuSuperior.add(btnServiciosAsignados);
//        menuSuperior.add(btnCargaDatos);

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

        btnActualizarListado = new JButton("Refrescar");
        btnActualizarListado.setHorizontalAlignment(JLabel.CENTER);
        btnActualizarListado.setBackground(Color.lightGray);
        btnActualizarListado.addActionListener(this);


        pnlListaServicios.add(scrollListaServicios);
        pnlListaServicios.add(texaDetalleServicio);
        pnlListaServicios.add(btnActualizarListado);

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

        //Panel modificar material adicional

        lblMaterialAd = new JLabel("Materiales adicionales: ");
        lblMaterialAd.setHorizontalAlignment(JLabel.LEFT);
        lblMaterialAd.setBackground(Color.lightGray);
        lblMaterialAd.setForeground(new Color(255, 255, 255));
        lblMaterialAd.setFont(new Font("Consolas",Font.BOLD, 12));

        fldMaterialAd = new JTextField(5);
        fldMaterialAd.setHorizontalAlignment(JTextField.LEFT);
        fldMaterialAd.setBounds(180, 210,100,20);

        JLabel lblPrecio = new JLabel("Costo:");
        lblPrecio.setHorizontalAlignment(JLabel.LEFT);
        lblPrecio.setBackground(Color.lightGray);
        lblPrecio.setForeground(new Color(255, 255, 255));
        lblPrecio.setFont(new Font("Consolas",Font.BOLD, 12));

        fldMaterialAdPrecio = new JTextField(5);
        fldMaterialAdPrecio.setHorizontalAlignment(JTextField.LEFT);
        fldMaterialAdPrecio.setBounds(180, 210,100,20);

        btnCargarMaterialAd = new JButton("Agregar");
        btnCargarMaterialAd.setHorizontalAlignment(JLabel.CENTER);
        btnCargarMaterialAd.setBackground(Color.lightGray);
        btnCargarMaterialAd.setBounds(180,320,100,30);//Agregar items a la ventana
        btnCargarMaterialAd.addActionListener(this);

        pnlMaterialAdicional.add(lblMaterialAd);
        pnlMaterialAdicional.add(fldMaterialAd);
        pnlMaterialAdicional.add(lblPrecio);
        pnlMaterialAdicional.add(fldMaterialAdPrecio);
        pnlMaterialAdicional.add(btnCargarMaterialAd);

        // Panel Almuerzo y combustible
        lblAlmuerzo = new JLabel("Almuerzo: ");
        lblAlmuerzo.setHorizontalAlignment(JLabel.LEFT);
        lblAlmuerzo.setBackground(Color.lightGray);
        lblAlmuerzo.setForeground(new Color(255, 255, 255));
        lblAlmuerzo.setFont(new Font("Consolas",Font.BOLD, 12));

        String[] opciones = {"SI", "NO"};
        comboAlmuerzo = new JComboBox(opciones);

        lblCombustible = new JLabel("Combustible: ");
        lblCombustible.setHorizontalAlignment(JLabel.LEFT);
        lblCombustible.setBackground(Color.lightGray);
        lblCombustible.setForeground(new Color(255, 255, 255));
        lblCombustible.setFont(new Font("Consolas",Font.BOLD, 12));

        fldCombustible = new JTextField(5);
        fldCombustible.setHorizontalAlignment(JTextField.LEFT);
        fldCombustible.setBounds(180, 210,100,20);

        btnCargarAlmuerzoComb = new JButton("Agregar");
        btnCargarAlmuerzoComb.setHorizontalAlignment(JLabel.CENTER);
        btnCargarAlmuerzoComb.setBackground(Color.lightGray);
        btnCargarAlmuerzoComb.setBounds(180,320,100,30);//Agregar items a la ventana
        btnCargarAlmuerzoComb.addActionListener(this);

        pnlAlmuerzoComb.add(lblAlmuerzo);
        pnlAlmuerzoComb.add(comboAlmuerzo);
        pnlAlmuerzoComb.add(lblCombustible);
        pnlAlmuerzoComb.add(fldCombustible);
        pnlAlmuerzoComb.add(btnCargarAlmuerzoComb);

        //Panel tiempo

        lblTiempo = new JLabel("Tiempo trabajado en horas (indicar decimales con punto: ");
        lblTiempo.setHorizontalAlignment(JLabel.LEFT);
        lblTiempo.setBackground(Color.lightGray);
        lblTiempo.setForeground(new Color(255, 255, 255));
        lblTiempo.setFont(new Font("Consolas",Font.BOLD, 12));

        fldTiempo = new JTextField(5);
        fldTiempo.setHorizontalAlignment(JTextField.LEFT);
        fldTiempo.setBounds(180, 210,100,20);

        btnCargarTiempo = new JButton("Cargar tiempo");
        btnCargarTiempo.setHorizontalAlignment(JLabel.CENTER);
        btnCargarTiempo.setBackground(Color.lightGray);
        btnCargarTiempo.setBounds(180,320,100,30);//Agregar items a la ventana
        btnCargarTiempo.addActionListener(this);

        pnlTiempo.add(lblTiempo);
        pnlTiempo.add(fldTiempo);
        pnlTiempo.add(btnCargarTiempo);

        // Boton finalizar servicio
        btnFinalizarServicio = new JButton("Finalizar servicio");
        btnFinalizarServicio.setHorizontalAlignment(JLabel.CENTER);
        btnFinalizarServicio.setBackground(Color.lightGray);
        btnFinalizarServicio.setBounds(180,320,100,30);//Agregar items a la ventana
        btnFinalizarServicio.addActionListener(this);

        pnlFinalizar.add(btnFinalizarServicio);

        //agrupo en vventana

        this.add(pnlIngresoTecnico);
        this.add(pnlListaServicios);
        this.add(pnlModMaterial);
        this.add(pnlMaterialAdicional);
        this.add(pnlAlmuerzoComb);
        this.add(pnlTiempo);
        this.add(pnlFinalizar);

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
                JOptionPane.showMessageDialog(null, "No posee servicios asignados en curso");
            }
            listaServiciosAsignados.setModel(listModel);
        }
        if(e.getSource()==btnActualizarListado){
            if(listaServiciosAsignados.getSelectedValue()==null){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un servicio.");
                return;
            }
            texaDetalleServicio.setText(ControllerTecnico.getInstance().getDetalleServicioSeleccionado());;
        }
        if(e.getSource()==btnCargarMaterial){
            if(listaServiciosAsignados.getSelectedValue()==null){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un servicio.");
                return;
            }
            Articulos art = Articulos.Cable;
            switch (comboMaterial.getSelectedIndex()){
                case 0:
                    art = Articulos.Cable;
                    break;
                case 1:
                    art = Articulos.Conector_coaxial_RG6;
                    break;
                case 2:
                    art = Articulos.Divisor;
                    break;
                case 3:
                    art = Articulos.Modem;
                    break;
                case 4:
                    art = Articulos.Decodificador;
                    break;
            }
            int cantidad = 0;
            try{
                cantidad = Integer.parseInt(fldCantMaterial.getText());
            } catch (Exception exc){
                JOptionPane.showMessageDialog(null, "Valor inválido");
                return;
            }
            ControllerTecnico.getInstance().setearMaterial(art, cantidad);
            JOptionPane.showMessageDialog(null, "Se seteo correctamente el valor.");
        }
        if(e.getSource()==btnCargarMaterialAd){
            if(listaServiciosAsignados.getSelectedValue()==null){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un servicio.");
                return;
            }
            Double precio = 0.0d;
            try{
                precio = Double.parseDouble(fldMaterialAdPrecio.getText());
            } catch (Exception exc){
                JOptionPane.showMessageDialog(null, "Valor inválido");
                return;
            }
            ControllerTecnico.getInstance().setearMaterialAdicional(fldMaterialAd.getText(), precio );
            JOptionPane.showMessageDialog(null, "Se seteo correctamente el valor.");
        }
        if(e.getSource()==btnCargarAlmuerzoComb){
            if(listaServiciosAsignados.getSelectedValue()==null){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un servicio.");
                return;
            }
            Double combustible = 0.0d;
            try{
                combustible = Double.parseDouble(fldCombustible.getText());
            } catch (Exception exc){
                JOptionPane.showMessageDialog(null, "Valor inválido");
                return;
            }
            boolean almuerzo = true;
            switch (comboAlmuerzo.getSelectedIndex()){
                case 0:
                    almuerzo = true;
                    break;
                case 1:
                    almuerzo = false;
                    break;
            }
            ControllerTecnico.getInstance().setearAlmuerzoCombustible(almuerzo, combustible);
            JOptionPane.showMessageDialog(null, "Se seteo correctamente el valor.");
        }
        if(e.getSource()==btnCargarTiempo){
            if(listaServiciosAsignados.getSelectedValue()==null){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un servicio.");
                return;
            }
            int id = 0;
            if(fldIdTecnico.getText()==""){
                JOptionPane.showMessageDialog(null, "Debe indicar el id del técnico.");
                return;
            } else {
                try{
                    id = Integer.parseInt(fldIdTecnico.getText());
                } catch (Exception exc){
                    JOptionPane.showMessageDialog(null, "Id tecnico invalido.");
                    return;
                }
            }
            Double tiempo = 0.0d;
            try{
                tiempo = Double.parseDouble(fldTiempo.getText());
            } catch (Exception exc){
                JOptionPane.showMessageDialog(null, "Valor inválido");
                return;
            }
            ControllerTecnico.getInstance().setearTiempoTrabajado(id, tiempo);
            JOptionPane.showMessageDialog(null, "Se seteo correctamente el valor.");
        }
        if(e.getSource()==btnFinalizarServicio){
            if(listaServiciosAsignados.getSelectedValue()==null){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un servicio.");
                return;
            }
            int confirma = JOptionPane.showConfirmDialog(null, "Confirma la finalización del servicio?", "Confirmación", 1);
            if(confirma==0) {
                ControllerTecnico.getInstance().finalizarServicioSeleccionado();
                JOptionPane.showMessageDialog(null, "Se finalizó correctamente el valor.");
                btnBuscarServicios.doClick();
            }
        }
    }
}

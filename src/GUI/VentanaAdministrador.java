package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
ad
public class VentanaAdministrador extends JFrame implements ActionListener {

    //Botones superiores
    JButton botonABMtecnico;
    JButton botonAMBarticulo;
    JButton botonConfigurarParametros;

    //Botones Inferior
    JButton botonCerrarSesion;

    //Lateral Izquierdo
    JPanel menuIzquierdo;
    JButton botonAltaTecnico;

    public VentanaAdministrador(){
        //Encabezado Ventana
        this.setTitle("Empresa de Cable Internet");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        ImageIcon image = new ImageIcon("C:\\Users\\Luciano\\OneDrive\\01. Facultad\\2022\\" +
                "4. Introducción a la Orientación a Objetos\\TPO\\_Empresa Cable e Internet\\TPO\\src\\GUI\\Logo.png"); //crea un icono de la imagen
        this.setIconImage(image.getImage());

        //Paneles -> setSize(Alto: 900,Ancho: 600);
        menuIzquierdo = new JPanel();
        menuIzquierdo.setBackground(Color.red);
        menuIzquierdo.setBounds(0, 180,150,200);

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

        //Botones Laterales

        botonAltaTecnico = new JButton("Alta Tecnico");
        botonAltaTecnico.setHorizontalAlignment(JLabel.CENTER);
        botonAltaTecnico.setVerticalAlignment(JLabel.CENTER);
        botonAltaTecnico.setBackground(Color.lightGray);

        //Boton Inferior

        botonCerrarSesion = new JButton("Cerrar Sesión");
        botonCerrarSesion.setHorizontalAlignment(JLabel.CENTER);
        botonCerrarSesion.setBackground(Color.lightGray);
        botonCerrarSesion.addActionListener(this);

        //Agregar items a la ventana

        this.add(menuIzquierdo);
        //menuIzquierdo.add(botonAltaTecnico);
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
            new VentanaLogin();
        }
        if (e.getSource()==botonABMtecnico){
            menuIzquierdo.add(botonAltaTecnico);
        }
    }
}

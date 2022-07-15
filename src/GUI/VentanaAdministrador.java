package GUI;
import javax.swing.*;
import java.awt.*;

public class VentanaAdministrador extends JFrame {

    JButton BotonABMtecnico;
    JButton BotonAMBarticulo;
    JButton BotonConfigurarParametros;

    public VentanaAdministrador(){
        //Encabezado Ventana
        this.setTitle("Empresa de Cable Internet");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        ImageIcon image = new ImageIcon("C:\\Users\\Luciano\\OneDrive\\01. Facultad\\2022\\" +
                "4. Introducción a la Orientación a Objetos\\TPO\\_Empresa Cable e Internet\\TPO\\src\\GUI\\Logo.png"); //crea un icono de la imagen
        this.setIconImage(image.getImage());
        //Ventana
        this.setSize(900,600);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(107,108,109));

        //Paneles
        JPanel menuIzquierdo = new JPanel();
        menuIzquierdo.setBackground(Color.red);
        menuIzquierdo.setBounds(0, 0,150,600);

        JPanel menuSuperior = new JPanel();
        menuSuperior.setBackground(Color.blue);
        menuSuperior.setBounds(150, 0,750,40);

        //Botones

        BotonABMtecnico = new JButton("ABM Técnico");
        BotonABMtecnico.setHorizontalAlignment(JLabel.LEFT);
        BotonABMtecnico.setBackground(Color.lightGray);

        BotonAMBarticulo = new JButton("ABM Articulos");
        BotonAMBarticulo.setHorizontalAlignment(JLabel.CENTER);
        BotonAMBarticulo.setBackground(Color.lightGray);

        BotonConfigurarParametros = new JButton("Configurar Parametros");
        BotonConfigurarParametros.setHorizontalAlignment(JLabel.RIGHT);
        BotonConfigurarParametros.setBackground(Color.lightGray);

        //Agregar items a la ventana

        this.add(menuIzquierdo);
        this.add(menuSuperior);
        menuSuperior.add(BotonABMtecnico);
        menuSuperior.add(BotonAMBarticulo);
        menuSuperior.add(BotonConfigurarParametros);


    }

}

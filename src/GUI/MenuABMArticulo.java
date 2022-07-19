package GUI;

import Controladores.ControllerAdministrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuABMArticulo extends JPanel implements ActionListener {

    private final JButton btnAltaBajaStock;
    private final JButton btnActualizarPrecio;
    private final JButton botonRefrescar;
    private final JList listaArticulos;
    private final JScrollPane scroll;
    private final PanelAltaArtículo pnlAltaArticulo;
    private final PanelModificarArticulo pnlModificarPrecio;

    public MenuABMArticulo(){

        ControllerAdministrador controller = ControllerAdministrador.getInstance();

        this.setBackground(Color.lightGray);
        this.setBounds(80, 60,735,400);

        //Botones submenu

        btnAltaBajaStock = new JButton("Actualizar stock");
        btnAltaBajaStock.setHorizontalAlignment(JLabel.LEFT);
        btnAltaBajaStock.setVerticalAlignment(JLabel.BOTTOM);
        //btnAltaBajaStock.setBackground(Color.lightGray);
        btnAltaBajaStock.addActionListener(this);

        btnActualizarPrecio = new JButton(" Actualizar precios");
        btnActualizarPrecio.setHorizontalAlignment(JLabel.LEFT);
        btnActualizarPrecio.setVerticalAlignment(JLabel.BOTTOM);
        btnActualizarPrecio.addActionListener(this);

        botonRefrescar = new JButton("Refrescar");
        botonRefrescar.setHorizontalAlignment(JLabel.LEFT);
        botonRefrescar.setVerticalAlignment(JLabel.BOTTOM);
        //botonRefrescar.setBackground(Color.lightGray);
        botonRefrescar.addActionListener(this);

        //Listas

        listaArticulos = new JList();
        listaArticulos.setVisibleRowCount(5);
        listaArticulos.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
        listaArticulos.setAlignmentY(JPanel.TOP_ALIGNMENT);
        listaArticulos.setModel(controller.listModelArticulo());
        scroll = new JScrollPane(listaArticulos);

        //Panel de alta
        pnlAltaArticulo = new PanelAltaArtículo();
        pnlModificarPrecio = new PanelModificarArticulo();

        //armado de submenu
        this.add(btnAltaBajaStock);
        this.add(btnActualizarPrecio);
        this.add(botonRefrescar);
        this.add(scroll);
        this.add(pnlAltaArticulo, JPanel.BOTTOM_ALIGNMENT);
        this.add(pnlModificarPrecio, JPanel.BOTTOM_ALIGNMENT);
        this.setVisible(false);
        this.setEnabled(false);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btnAltaBajaStock){
            pnlAltaArticulo.setVisible(true);
            pnlModificarPrecio.setVisible(false);
            pnlModificarPrecio.setEnabled(false);
            listaArticulos.setModel(ControllerAdministrador.getInstance().listModelArticulo());
        }
        if(e.getSource()==btnActualizarPrecio){
            pnlModificarPrecio.setVisible(true);
            pnlModificarPrecio.setEnabled(true);
            pnlAltaArticulo.setVisible(false);
            pnlAltaArticulo.setEnabled(false);
            listaArticulos.setModel(ControllerAdministrador.getInstance().listModelArticulo());
        }
        if (e.getSource()==botonRefrescar){
            pnlAltaArticulo.setVisible(false);
            pnlAltaArticulo.setEnabled(false);
            pnlModificarPrecio.setVisible(false);
            pnlModificarPrecio.setEnabled(false);
            listaArticulos.setModel(ControllerAdministrador.getInstance().listModelArticulo());
        }
    }

}

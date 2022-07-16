package GUI;

import Interfaz.ControllerAdministrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuABMArticulo extends JPanel implements ActionListener {

    private final JButton btnAltaArticulo;
    private final JButton btnBajaStock;
    private final JButton btnModificaStock;
    private final JButton botonRefrescar;
    private final JList listaArticulos;
    private final JScrollPane scroll;
    private final PanelAltaArtículo pnlAltaArticulo;

    public MenuABMArticulo(){

        ControllerAdministrador controller = ControllerAdministrador.getInstance();

        this.setBackground(Color.lightGray);
        this.setBounds(0, 180,600,260);

        //Botones submenu

        btnAltaArticulo = new JButton("Alta de stock");
        btnAltaArticulo.setHorizontalAlignment(JLabel.LEFT);
        btnAltaArticulo.setVerticalAlignment(JLabel.BOTTOM);
        btnAltaArticulo.setBackground(Color.lightGray);
        btnAltaArticulo.addActionListener(this);

        btnBajaStock = new JButton("Baja stock");
        btnBajaStock.setHorizontalAlignment(JLabel.LEFT);
        btnBajaStock.setVerticalAlignment(JLabel.BOTTOM);
        btnBajaStock.setBackground(Color.lightGray);
        btnBajaStock.addActionListener(this);

        btnModificaStock = new JButton("Modificar stock");
        btnModificaStock.setHorizontalAlignment(JLabel.LEFT);
        btnModificaStock.setVerticalAlignment(JLabel.BOTTOM);
        btnModificaStock.setBackground(Color.lightGray);
        btnModificaStock.addActionListener(this);

        botonRefrescar = new JButton("Refrescar");
        botonRefrescar.setHorizontalAlignment(JLabel.LEFT);
        botonRefrescar.setVerticalAlignment(JLabel.BOTTOM);
        botonRefrescar.setBackground(Color.lightGray);
        botonRefrescar.addActionListener(this);

        //Listas

        listaArticulos = new JList();
        listaArticulos.setVisibleRowCount(3);
        listaArticulos.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
        listaArticulos.setAlignmentY(JPanel.TOP_ALIGNMENT);
        listaArticulos.setModel(controller.listModelArticulo());
        scroll = new JScrollPane(listaArticulos);

        //Panel de alta
        pnlAltaArticulo = new PanelAltaArtículo();

        //armado de submenu
        this.add(btnAltaArticulo);
        this.add(btnBajaStock);
        this.add(btnModificaStock);
        this.add(botonRefrescar);
        this.add(scroll);
        this.add(pnlAltaArticulo);
        this.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnAltaArticulo){
            pnlAltaArticulo.setVisible(true);
        }
        if (e.getSource()==botonRefrescar){
            pnlAltaArticulo.setVisible(false);
            listaArticulos.setModel(ControllerAdministrador.getInstance().listModelArticulo());
        }
    }

}

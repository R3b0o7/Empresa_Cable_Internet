package GUI;

import Enumeraciones.Articulos;
import Interfaz.ControllerAdministrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelModificarArticulo extends JPanel implements ActionListener {

    JComboBox<String> comboArticulo;
    JTextField fldPrecio;
    JButton buttonGrabarArticulo;

    public PanelModificarArticulo(){

        this.setBackground(Color.lightGray);
        this.setBounds(0, 380,300,120);
        this.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        this.setAlignmentY(JPanel.BOTTOM_ALIGNMENT);
        this.setLayout(new GridLayout(0, 2));

        JLabel lblArticulo = new JLabel("Articulo:   ");
        lblArticulo.setHorizontalAlignment(SwingConstants.RIGHT);
        JLabel lblPrecio = new JLabel("Precio:   ");
        lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
        fldPrecio = new JTextField();

        buttonGrabarArticulo = new JButton("Guardar cambio");
        buttonGrabarArticulo.addActionListener(this);

        String[] opcionesArticulo = ControllerAdministrador.getInstance().listadoArticulosToCombo();
        this.comboArticulo = new JComboBox<String>(opcionesArticulo);

        this.add(lblPrecio);
        this.add(fldPrecio);
        this.add(comboArticulo);
        this.add(buttonGrabarArticulo);
        this.setVisible(false);
        this.setEnabled(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.buttonGrabarArticulo){
            double precio = 0;
            try {
                precio = Double.parseDouble(this.fldPrecio.getText());
            } catch (Exception exc){
                JOptionPane.showMessageDialog(null, "Valor incorrecto para precio");
                return;
            }
            Articulos articulo = Articulos.Cable;
            switch(this.comboArticulo.getSelectedItem().toString()){
                case "Cable":
                    articulo = Articulos.Cable;
                    break;
                case "Conector_coaxial_RG6":
                    articulo = Articulos.Conector_coaxial_RG6;
                    break;
                case "Decodificador":
                    articulo = Articulos.Decodificador;
                    break;
                case "Modem"   :
                    articulo = Articulos.Modem;
                    break;
                case "Divisor":
                    articulo = Articulos.Divisor;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + this.comboArticulo.getSelectedItem().toString());
            }
            int confirma = JOptionPane.showConfirmDialog(null, "Confirma la actualización del artículo?", "Confirmación", 1);
            if(confirma == 0) {
                ControllerAdministrador.getInstance().modificarPrecioArticulo(articulo, precio);
                JOptionPane.showMessageDialog(null, "El artículo fue actualizado correctamente");
                this.setVisible(false);
            }
        }
    }
}

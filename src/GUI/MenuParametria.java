package GUI;

import Clases.Compania;
import Enumeraciones.TipoTecnico;
import Interfaz.ControllerAdministrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuParametria extends JPanel implements ActionListener {

    private final JButton btnGuardar;
    private final JButton btnRefrescar;
    JTextField fldValor;
    JLabel lblValor;
    JLabel lblValorActual;
    JComboBox comboParametro;


    public MenuParametria() {

        ControllerAdministrador controller = ControllerAdministrador.getInstance();

        this.setBackground(Color.lightGray);
        this.setBounds(0, 180, 600, 260);

        fldValor = new JTextField();
        fldValor.setPreferredSize(new Dimension(100, 20));
        lblValor = new JLabel("Valor nuevo: ");
        lblValorActual = new JLabel("");

        btnGuardar = new JButton("Guardar cambios");
        btnGuardar.addActionListener(this);

        btnRefrescar = new JButton("Ver valor actual");
        btnRefrescar.addActionListener(this);

        String[] opciones = {"Costo Tecnico Jr", "Costo Tecnico Ssr", "Costo Tecnico Sr", "Costo de viaje", "Precio Combustible"};
        this.comboParametro = new JComboBox<String>(opciones);

        //armado de submenu
        this.add(comboParametro);
        this.add(lblValor);
        this.add(fldValor);
        this.add(lblValorActual);
        this.add(btnRefrescar);
        this.add(btnGuardar);
        this.setVisible(false);
        this.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnGuardar){
            Double valor = 0.0;
            try{
                if(!fldValor.getText().equals("")){
                    valor = Double.parseDouble(fldValor.getText());
                }
            } catch (Exception exc){
                JOptionPane.showMessageDialog(null, "Valor inválido");
            }
            int confirma = JOptionPane.showConfirmDialog(null, "Confirma la actualización del parámetro?", "Confirmación", 1);
            if(confirma > 0) {
                this.setVisible(false);
                this.setEnabled(false);
                return;
            }
            int opcion = comboParametro.getSelectedIndex();
            switch(opcion){
                case 0:
                    Compania.getInstance().getMaestroCostoTecnicos().put(TipoTecnico.Junior, valor);
                    break;
                case 1:
                    Compania.getInstance().getMaestroCostoTecnicos().put(TipoTecnico.Semi_senior, valor);
                    break;
                case 2:
                    Compania.getInstance().getMaestroCostoTecnicos().put(TipoTecnico.Senior, valor);
                    break;
                case 3:
                    Compania.getInstance().setCostoDeViaje(valor);
                    break;
                case 4:
                    Compania.getInstance().setPrecioCombustible(valor);
                    break;
            }
            JOptionPane.showMessageDialog(null, "Valor actualizado correctamente.");
            this.setVisible(false);
            this.setEnabled(false);
        }
        if(e.getSource() == btnRefrescar){
            try{
                switch(this.comboParametro.getSelectedIndex()){
                    case 0:
                        this.lblValorActual.setText(Compania.getInstance().getMaestroCostoTecnicos().get(TipoTecnico.Junior).toString());
                        break;
                    case 1:
                        this.lblValorActual.setText(Compania.getInstance().getMaestroCostoTecnicos().get(TipoTecnico.Semi_senior).toString());
                        break;
                    case 2:
                        this.lblValorActual.setText(Compania.getInstance().getMaestroCostoTecnicos().get(TipoTecnico.Senior).toString());
                        break;
                    case 3:
                        String costo1 = String.valueOf(Compania.getInstance().getCostoDeViaje());
                        this.lblValorActual.setText(costo1);
                        break;
                    case 4:
                        String costo2 = String.valueOf(Compania.getInstance().getPrecioCombustible());
                        this.lblValorActual.setText(costo2);
                        break;
                }
            } catch (Exception exc){
                JOptionPane.showMessageDialog(null, "No se selecciono parámetro");
            }
        }
    }
}

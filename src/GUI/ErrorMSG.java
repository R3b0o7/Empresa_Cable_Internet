package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorMSG extends JFrame implements ActionListener {

    JButton ok;

    public ErrorMSG(){
        this.setTitle("");
        this.setDefaultCloseOperation(JFrame.ERROR);
        this.setSize(150,80);
        this.setResizable(false);
        this.setVisible(true);

        JLabel msg = new JLabel("Entrada Invalida");
        msg.setHorizontalAlignment(JLabel.CENTER);
        msg.setVerticalTextPosition(JLabel.TOP);

        ok = new JButton();
        ok.setHorizontalAlignment(JLabel.CENTER);
        ok.setHorizontalAlignment(JLabel.BOTTOM);

        this.add(msg);
        this.add(ok);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ok){
            this.dispose();
            VentanaLogin.getInstance();
        }
    }
}

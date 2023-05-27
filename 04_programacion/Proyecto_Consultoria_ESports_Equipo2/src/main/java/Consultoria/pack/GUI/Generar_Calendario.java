package Consultoria.pack.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Generar_Calendario {
    private JButton generarCalendarioButton;
    private JPanel panelGenerar;
    private JTextField textFieldFecha;

    public JPanel getPanelGenerar() {
        return panelGenerar;
    }

    public Generar_Calendario() {
    generarCalendarioButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String fecha = textFieldFecha.getText();
        }
    });
}
}

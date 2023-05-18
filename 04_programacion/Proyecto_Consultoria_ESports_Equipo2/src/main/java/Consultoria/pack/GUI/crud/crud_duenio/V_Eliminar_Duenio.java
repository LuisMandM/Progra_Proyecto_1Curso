package Consultoria.pack.GUI.crud.crud_duenio;

import Consultoria.pack.Clases_Base.Duenio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class V_Eliminar_Duenio {

    private JPanel panelEliminar_Duenio;
    private JComboBox<Duenio> comboBoxDuenio;
    private JButton buttonEliminar;
    List<Duenio> duenios;


    public V_Eliminar_Duenio() {

        for (Duenio duenio : duenios) {
            comboBoxDuenio.addItem(duenio);
        }
        buttonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Duenio duenioselec = (Duenio) comboBoxDuenio.getSelectedItem();
                duenios.remove(duenioselec);
            }
        });
    }
    public JPanel getPanelEliminar_Duenio() {
        return panelEliminar_Duenio;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("V_Eliminar_Duenio");
        frame.setContentPane(new V_Eliminar_Duenio().panelEliminar_Duenio);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

package Consultoria.pack.GUI.crud.crud_duenio;

import Consultoria.pack.Base_Datos.Carga;
import Consultoria.pack.Clases_Base.Duenio;
import Consultoria.pack.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class V_Actualizar_Duenio {
    private JPanel panelActualizarDuenio;
    private JLabel labelEscogerDuenio;
    private JComboBox<Duenio> comboBoxDuenio;
    private JButton seleccionarButton;

    public V_Actualizar_Duenio() {

        for (Duenio duenio : Main.getDuenios()) {
            comboBoxDuenio.addItem(duenio);
        }
        seleccionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Duenio duenioselec = (Duenio) comboBoxDuenio.getSelectedItem();
                // meter main de crar , añadir un constructor en l que reciba el objeto
                JFrame frame = new JFrame("V_Crear_Duenio");
                frame.setContentPane(new V_Crear_Duenio(duenioselec).getPanelCrear_duenio());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
    public JPanel getPanelActualizarDuenio() {
        return panelActualizarDuenio;
    }
}

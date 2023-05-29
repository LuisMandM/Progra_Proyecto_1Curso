package Consultoria.pack.GUI.crud.crud_duenio;

import Consultoria.pack.Clases_Base.Duenio;
import Consultoria.pack.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V_Actualizar_Duenio {
    private JPanel panelActualizarDuenio;
    private JLabel labelEscogerDuenio;
    private JComboBox<Duenio> comboBoxDuenio;
    private JButton seleccionarButton;

    private Duenio duenioSeleccionado;

    public V_Actualizar_Duenio() {
        for (Duenio duenio : Main.getDuenios()) {
            comboBoxDuenio.addItem(duenio);
        }
        seleccionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    duenioSeleccionado = (Duenio) comboBoxDuenio.getSelectedItem();
                    JFrame frame = new JFrame("Actualizar");
                    frame.setContentPane(new V_Crear_Duenio(duenioSeleccionado).getPanelCrear_duenio());
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
            }
        });
    }
    public JPanel getPanelActualizarDuenio() {
        return panelActualizarDuenio;
    }
}

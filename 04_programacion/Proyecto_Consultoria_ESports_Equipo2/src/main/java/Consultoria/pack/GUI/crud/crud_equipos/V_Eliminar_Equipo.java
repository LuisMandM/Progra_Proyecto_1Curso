package Consultoria.pack.GUI.crud.crud_equipos;

import Consultoria.pack.Clases_Base.Duenio;
import Consultoria.pack.Clases_Base.Equipo;
import Consultoria.pack.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class V_Eliminar_Equipo {
    private JPanel panelEliminarEquipo;
    private JLabel labelEscogerEquipo;
    private JComboBox<Equipo> comboBoxEscogeEquipo;
    private JButton seleccionarButton;
    List<Equipo> equipos;
    public V_Eliminar_Equipo() {
        for (Equipo equipo : Main.getEquipos()) {
            comboBoxEscogeEquipo.addItem(equipo);
        }
        seleccionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Equipo equiposelec = (Equipo) comboBoxEscogeEquipo.getSelectedItem();
                equipos.remove(equiposelec);
            }
        });
    }
    public JPanel getPanelEliminarEquipo() {
        return panelEliminarEquipo;
    }

}

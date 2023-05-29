package Consultoria.pack.gui.crud.crud_equipos;

import Consultoria.pack.Base_Datos.CRUD.Delete;
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
        seleccionarButton.addActionListener(e -> {
            Equipo equiposelec = (Equipo) comboBoxEscogeEquipo.getSelectedItem();

            if (equiposelec != null) Delete.Delete_Equipo(equiposelec);
            else JOptionPane.showMessageDialog(null, "Error al seleccionar el equipo " +
                    "intente nuevamente", "Error BD", JOptionPane.ERROR_MESSAGE);
        });
    }

    public JPanel getPanelEliminarEquipo() {
        return panelEliminarEquipo;
    }

}

package Consultoria.pack.gui.crud.crud_duenio;

import Consultoria.pack.Base_Datos.CRUD.Delete;
import Consultoria.pack.Base_Datos.Carga;
import Consultoria.pack.Clases_Base.Duenio;
import Consultoria.pack.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class V_Eliminar_Duenio {

    private JPanel panelEliminar_Duenio;
    private JComboBox<Duenio> comboBoxDuenio;
    private JButton buttonEliminar;

    public V_Eliminar_Duenio() {

        for (Duenio duenio : Main.getDuenios()) {
            comboBoxDuenio.addItem(duenio);
        }
        buttonEliminar.addActionListener(e -> {
            Duenio duenioselec = (Duenio) comboBoxDuenio.getSelectedItem();

            if (duenioselec!= null)  Delete.Delete_Duenio(duenioselec);
            else JOptionPane.showMessageDialog(null, "Error al seleccionar el dueño " +
                    "intente nuevamente", "Error BD", JOptionPane.ERROR_MESSAGE);
        });
    }
    public JPanel getPanelEliminar_Duenio() {
        return panelEliminar_Duenio;
    }

}

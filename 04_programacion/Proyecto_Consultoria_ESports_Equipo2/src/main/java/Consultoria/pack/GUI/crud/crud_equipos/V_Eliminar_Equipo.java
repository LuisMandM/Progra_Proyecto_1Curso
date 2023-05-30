package Consultoria.pack.GUI.crud.crud_equipos;

import Consultoria.pack.Base_Datos.CRUD.Delete;
import Consultoria.pack.Clases_Base.Equipo;
import Consultoria.pack.Main;

import javax.swing.*;
import java.util.List;

/**
 * La clase `V_Eliminar_Equipo` representa la interfaz gráfica de usuario para eliminar un objeto `Equipo`.
 */
public class V_Eliminar_Equipo {
    private JPanel panelEliminarEquipo;
    private JLabel labelEscogerEquipo;
    private JComboBox<Equipo> comboBoxEscogeEquipo;
    private JButton seleccionarButton;
    List<Equipo> equipos;

    /**
     * Crea una nueva instancia de `V_Eliminar_Equipo`.
     */
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

    /**
     * Obtiene el panel de la interfaz gráfica de usuario para eliminar un `Equipo`.
     *
     * @return El panel de la interfaz gráfica de usuario.
     */
    public JPanel getPanelEliminarEquipo() {
        return panelEliminarEquipo;
    }
}

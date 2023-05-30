package Consultoria.pack.GUI.crud.crud_duenio;

import Consultoria.pack.Base_Datos.CRUD.Delete;
import Consultoria.pack.Clases_Base.Duenio;
import Consultoria.pack.Main;

import javax.swing.*;

/**
 * La clase `V_Eliminar_Duenio` representa la interfaz gráfica de usuario para eliminar un objeto `Duenio`.
 */
public class V_Eliminar_Duenio {

    private JPanel panelEliminar_Duenio;
    private JComboBox<Duenio> comboBoxDuenio;
    private JButton buttonEliminar;

    /**
     * Crea una nueva instancia de `V_Eliminar_Duenio`.
     */
    public V_Eliminar_Duenio() {

        for (Duenio duenio : Main.getDuenios()) {
            comboBoxDuenio.addItem(duenio);
        }
        buttonEliminar.addActionListener(e -> {
            Duenio duenioselec = (Duenio) comboBoxDuenio.getSelectedItem();

            if (duenioselec != null)  Delete.Delete_Duenio(duenioselec);
            else JOptionPane.showMessageDialog(null, "Error al seleccionar el dueño " +
                    "intente nuevamente", "Error BD", JOptionPane.ERROR_MESSAGE);
        });
    }

    /**
     * Obtiene el panel de la interfaz gráfica de usuario para eliminar un `Duenio`.
     *
     * @return El panel de la interfaz gráfica de usuario.
     */
    public JPanel getPanelEliminar_Duenio() {
        return panelEliminar_Duenio;
    }

}

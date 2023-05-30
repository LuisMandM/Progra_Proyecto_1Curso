package Consultoria.pack.GUI.crud.crud_duenio;

import Consultoria.pack.Clases_Base.Duenio;
import Consultoria.pack.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase `V_Actualizar_Duenio` representa la interfaz gráfica de usuario para la funcionalidad de actualización de un objeto `Duenio`.
 */
public class V_Actualizar_Duenio {
    private JPanel panelActualizarDuenio;
    private JLabel labelEscogerDuenio;
    private JComboBox<Duenio> comboBoxDuenio;
    private JButton seleccionarButton;

    private Duenio duenioSeleccionado;

    /**
     * Crea una nueva instancia de `V_Actualizar_Duenio` e inicializa los componentes de la interfaz.
     */
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
    /**
     * Obtiene el panel de la interfaz gráfica de usuario para la funcionalidad de actualización de `Duenio`.
     *
     * @return El panel de la interfaz gráfica de usuario.
     */
    public JPanel getPanelActualizarDuenio() {
        return panelActualizarDuenio;
    }
}

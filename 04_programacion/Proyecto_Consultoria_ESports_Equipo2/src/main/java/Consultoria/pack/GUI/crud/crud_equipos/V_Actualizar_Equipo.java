package Consultoria.pack.GUI.crud.crud_equipos;

import Consultoria.pack.Clases_Base.Equipo;
import Consultoria.pack.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase `V_Actualizar_Equipo` representa la interfaz gráfica de usuario para actualizar un objeto `Equipo`.
 */
public class V_Actualizar_Equipo {
    private JButton botonSeleccionar;
    private JPanel panelActualizarEquipo;
    private JLabel labelEscogerEquipo;
    private JComboBox<Equipo> comboBox1;
    private Equipo equiposelec;

    /**
     * Crea una nueva instancia de `V_Actualizar_Equipo`.
     */
    public V_Actualizar_Equipo() {
        for (Equipo equipo : Main.getEquipos()) {
            comboBox1.addItem(equipo);
        }
        botonSeleccionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equiposelec = (Equipo) comboBox1.getSelectedItem();
                JFrame frame = new JFrame("Actualizar_Equipo");
                frame.setContentPane(new V_Crear_Equipo(equiposelec).getPanelCrear_Equipo());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    /**
     * Obtiene el panel de la interfaz gráfica de usuario para actualizar un `Equipo`.
     *
     * @return El panel de la interfaz gráfica de usuario.
     */
    public JPanel getPanelActualizarEquipo() {
        return panelActualizarEquipo;
    }
}


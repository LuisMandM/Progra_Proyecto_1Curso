package Consultoria.pack.GUI.crud.crud_jugador;

import Consultoria.pack.Clases_Base.Equipo;
import Consultoria.pack.Clases_Base.Jugador;
import Consultoria.pack.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase `V_Eliminar_Jugador` representa la interfaz gráfica de usuario para eliminar un objeto `Jugador`.
 */
public class V_Eliminar_Jugador {
    private JPanel panelEliminar_Jugador;
    private JLabel labelEscogerJugador;
    private JLabel labelEscogerEquipo;
    private JComboBox<Equipo> comboBoxEquipo;
    private JComboBox<Jugador> comboBoxJugador;
    private JButton buttonConfirmar;

    /**
     * Crea una nueva instancia de `V_Eliminar_Jugador`.
     */
    public V_Eliminar_Jugador() {

        for (Equipo equipo : Main.getEquipos()) {
            comboBoxEquipo.addItem(equipo);
        }
        comboBoxEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBoxJugador.removeAllItems();

                Equipo equipoSeleccionado = (Equipo) comboBoxEquipo.getSelectedItem();
                assert equipoSeleccionado != null;
                for (Jugador jugador : equipoSeleccionado.getJugadores()) {
                    comboBoxJugador.addItem(jugador);
                }
            }
        });
        buttonConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jugador jugadorselec = (Jugador) comboBoxJugador.getSelectedItem();
                Main.getJugadores().remove(jugadorselec);
            }
        });
    }

    /**
     * Obtiene el panel de la interfaz gráfica de usuario para eliminar un jugador.
     *
     * @return El panel de la interfaz gráfica de usuario.
     */
    public JPanel getPanelEliminar_Jugador() {
        return panelEliminar_Jugador;
    }
}

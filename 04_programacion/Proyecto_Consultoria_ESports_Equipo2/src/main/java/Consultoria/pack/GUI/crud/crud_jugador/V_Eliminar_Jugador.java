package Consultoria.pack.gui.crud.crud_jugador;

import Consultoria.pack.Clases_Base.Equipo;
import Consultoria.pack.Clases_Base.Jugador;
import Consultoria.pack.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V_Eliminar_Jugador {
    private JPanel panelEliminar_Jugador;
    private JLabel labelEscogerJugador;
    private JLabel labelEscogerEquipo;
    private JComboBox<Equipo> comboBoxEquipo;
    private JComboBox<Jugador> comboBoxJugador;
    private JButton buttonConfirmar;

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
    public JPanel getPanelEliminar_Jugador() {
        return panelEliminar_Jugador;
    }
}

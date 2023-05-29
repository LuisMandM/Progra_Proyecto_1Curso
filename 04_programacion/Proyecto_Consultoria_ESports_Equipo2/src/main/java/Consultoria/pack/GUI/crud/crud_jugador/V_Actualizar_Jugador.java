package Consultoria.pack.gui.crud.crud_jugador;

import Consultoria.pack.Clases_Base.Jugador;
import Consultoria.pack.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V_Actualizar_Jugador {

    private JPanel panelActualizar;
    private JComboBox<Jugador> comboBoxActualiJugador;
    private JButton seleccionarButton;
    private JLabel labelEscoger;
    private Jugador jugadorselec;
    private final boolean actualizar = false;

    public V_Actualizar_Jugador() {
        for (Jugador jugador: Main.getJugadores()) {
            comboBoxActualiJugador.addItem(jugador);
        }
        seleccionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Jugador jugadorSelec = (Jugador) comboBoxActualiJugador.getSelectedItem();
                    JFrame frame = new JFrame("Actualizar_Jugador");
                    frame.setContentPane(new V_CrearJugador(jugadorSelec).getPanel_CrearJugador());
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
            }
        });
    }
    public JPanel getPanelActualizar() {
        return panelActualizar;
    }
}

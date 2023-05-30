package Consultoria.pack.GUI.crud.crud_jugador;

import Consultoria.pack.Clases_Base.Jugador;
import Consultoria.pack.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase `V_Actualizar_Jugador` representa la interfaz gráfica de usuario para actualizar un objeto `Jugador`.
 */
public class V_Actualizar_Jugador {

    private JPanel panelActualizar;
    private JComboBox<Jugador> comboBoxActualiJugador;
    private JButton seleccionarButton;
    private JLabel labelEscoger;
    private Jugador jugadorselec;
    private final boolean actualizar = false;

    /**
     * Crea una nueva instancia de `V_Actualizar_Jugador`.
     */
    public V_Actualizar_Jugador() {
        for (Jugador jugador : Main.getJugadores()) {
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

    /**
     * Obtiene el panel de la interfaz gráfica de usuario para actualizar un `Jugador`.
     *
     * @return El panel de la interfaz gráfica de usuario.
     */
    public JPanel getPanelActualizar() {
        return panelActualizar;
    }
}

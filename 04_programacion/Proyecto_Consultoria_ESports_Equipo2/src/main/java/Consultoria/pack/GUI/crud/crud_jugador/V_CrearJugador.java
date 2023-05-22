package Consultoria.pack.GUI.crud.crud_jugador;

import Consultoria.pack.Clases_Base.Equipo;
import Consultoria.pack.Clases_Base.Jugador;
import Consultoria.pack.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V_CrearJugador {
    private JPanel Panel_CrearJugador;
    private JLabel label_IDJugador;
    private JLabel labelNombre;
    private JLabel labelNickname;
    private JLabel labelSueldo;
    private JTextField textFieldId_jugador;
    private JTextField textFieldNombre;
    private JTextField textFieldNickname;
    private JTextField textFieldSueldo;
    private JButton buttonGuardar;
    private JComboBox<Equipo> comboBoxEquipos;
    private JLabel labelEquipo;
    Jugador jugador;
    public V_CrearJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    public V_CrearJugador() {

        for (Equipo equipo : Main.getEquipos()) {
            comboBoxEquipos.addItem(equipo);
        }
        buttonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id_jugador = Integer.parseInt(textFieldId_jugador.getText());
                String nombre = textFieldNombre.getText();
                String nickname = textFieldNickname.getText();
                double sueldo = Double.parseDouble(textFieldSueldo.getText());
                Equipo equiposelec = (Equipo) comboBoxEquipos.getSelectedItem();
                Jugador jugador = new Jugador(id_jugador, nombre, nickname, sueldo, equiposelec);
                Main.getJugadores().add(jugador);
                textFieldId_jugador.setText("");
                textFieldNombre.setText("");
                textFieldNickname.setText("");
                textFieldSueldo.setText("");
            }
        });
    }

    public JPanel getPanel_CrearJugador() {
        return Panel_CrearJugador;
    }
}

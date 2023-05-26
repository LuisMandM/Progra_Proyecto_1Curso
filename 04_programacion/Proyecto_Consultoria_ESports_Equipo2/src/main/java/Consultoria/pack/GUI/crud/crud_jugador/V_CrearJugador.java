package Consultoria.pack.GUI.crud.crud_jugador;

import Consultoria.pack.Clases_Base.Duenio;
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
    private boolean actualizar;
    private JLabel labelEquipo;
    Jugador jugador;
    public V_CrearJugador(Jugador jugador) {
        this.jugador = jugador;
        this.actualizar = true;
        for (Equipo equipo : Main.getEquipos()) {
            comboBoxEquipos.addItem(equipo);
        }
        textFieldId_jugador.setText(String.valueOf(jugador.getId_jugador()));
        textFieldNombre.setText(jugador.getNombre());
        textFieldNickname.setText(jugador.getNickname());
        textFieldSueldo.setText(String.valueOf(jugador.getSueldo()));
        gest_Jugador();
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
    private void gest_Jugador() {
        if (!actualizar) {
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
        } else {
            textFieldId_jugador.setText(String.valueOf(jugador.getId_jugador()));
            textFieldNombre.setText(jugador.getNombre());
            textFieldNickname.setText(jugador.getNickname());
            textFieldSueldo.setText(String.valueOf(jugador.getSueldo()));
        }
    }
    public JPanel getPanel_CrearJugador() {
        return Panel_CrearJugador;
    }
}

package Consultoria.pack.GUI;

import Consultoria.pack.Base_Datos.Carga;
import Consultoria.pack.Clases_Base.Duenio;
import Consultoria.pack.Clases_Base.Equipo;
import Consultoria.pack.Clases_Base.Jugador;
import Consultoria.pack.Main;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class confeccionarEquipo {
    JPanel panel1;
    private JList<Jugador> list1;
    private JButton añadirButton;
    private JButton quitarButton;
    private JList<Jugador> list2;
    private JLabel label1;
    private JLabel label2;
    private JTextArea textArea3;
    private JTextArea textArea4;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JPasswordField passwordField1;
    private JTextField textField5;
    private JButton loginButton;
    private JLabel label4;

    List<Jugador> jugadores = new ArrayList<>();
    private String nombre;
    private String password;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Confeccionar equipo");
        frame.setContentPane(new confeccionarEquipo().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public confeccionarEquipo() {
        //Carga.Cargar_Equipos();
        //Carga.Cargar_Jugadores_Libres();
        actualizarListaJugadores();

        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String id = String.valueOf(list1.getSelectedValue().getId_jugador());
                String nombre = String.valueOf(list1.getSelectedValue().getNombre());
                String nickname = String.valueOf(list1.getSelectedValue().getNickname());
                String sueldo = String.valueOf(list1.getSelectedValue().getSueldo());
                textField1.setText(id);
                textField2.setText(nombre);
                textField3.setText(nickname);
                textField4.setText(sueldo);
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombre = textField5.getText();
                password = new String(passwordField1.getPassword());

                DefaultListModel<Jugador> modeloEquipo = new DefaultListModel<>();

                for (Duenio duenio: Main.getDuenios()) {
                    if (Objects.equals(nombre, duenio.getUsuario()) && Objects.equals(password, duenio.getContrasenya())) {
                        for (Equipo equipo: Main.getEquipos()) {
                            if (equipo.getDuenyo() == duenio) {

                                for (int i = 1; i < equipo.getJugadores().length; i++) {
                                    modeloEquipo.addElement(equipo.getJugadores()[i-1]);
                                }
                                /*for (Jugador jugador: Main.getJugadores()) {
                                    if (Objects.equals(jugador.getEquipo().getNombre(), duenio.getNombre())) {
                                        modeloEquipo.addElement(jugador);
                                    }
                                }*/
                            }
                        }
                    }
                    list2.setModel(modeloEquipo);
                }
            }
        });

        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        quitarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void actualizarListaJugadores() {
        DefaultListModel<Jugador> modelo = new DefaultListModel<>();

        for (Jugador jugador: Main.getFree_players()) {
            modelo.addElement(jugador);
        }
        list1.setModel(modelo);
    }

    public JPanel getPanel1() {
        return panel1;
    }
}

package Consultoria.pack.GUI;

import Consultoria.pack.Base_Datos.CRUD.Update;
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

    /**
     * Clase para cambiar los jugadores de cada equipo. Mediante un login verificamos al dueño y los jugadores correspondientes a su equipo. En el login debera introducirse
     * el nombre de usuario y su contraseña. A la izquierda hay una lista de los jugadores libres los cuales pueden añadirse al equipo y a la derecha los jugadores que ya
     * están en el equipo. Puedes añadir jugadores libres al equipo o quitar jugadores de tu equipo.
     * @param nombre String con el usuario
     * @param password String con el password
     * @param equipo Equipo para el dueño
     */

    JPanel panel1;
    private JList<Jugador> jugadores_libres;
    private JButton añadirButton;
    private JButton quitarButton;
    private JList<Jugador> jugadores_equipo;
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
    private Equipo equipo_jugador;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Confeccionar equipo");
        frame.setContentPane(new confeccionarEquipo().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public confeccionarEquipo() {
        Carga.Cargar_Equipos();
        Carga.Cargar_Jugadores_Libres();
        actualizarListaJugadores();

        /**
         *
         */

        jugadores_libres.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String id = String.valueOf(jugadores_libres.getSelectedValue().getId_jugador());
                String nombre = String.valueOf(jugadores_libres.getSelectedValue().getNombre());
                String nickname = String.valueOf(jugadores_libres.getSelectedValue().getNickname());
                String sueldo = String.valueOf(jugadores_libres.getSelectedValue().getSueldo());
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

                                for (int i = 0; i < equipo.getJugadores().length; i++) {
                                    modeloEquipo.addElement(equipo.getJugadores()[i]);
                                    equipo_jugador = equipo;
                                }
                                /*for (Jugador jugador: Main.getJugadores()) {
                                    if (Objects.equals(jugador.getEquipo().getNombre(), duenio.getNombre())) {
                                        modeloEquipo.addElement(jugador);
                                    }
                                }*/
                            }
                        }
                    }
                    jugadores_equipo.setModel(modeloEquipo);
                }
            }
        });

        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jugador actual = jugadores_libres.getSelectedValue();
                System.out.println(actual.getEquipo());
                actual.setEquipo(equipo_jugador);
                Update.Add_PlayerTeam(actual);
            }
        });

        quitarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jugador jugador_eliminado = jugadores_equipo.getSelectedValue();
                System.out.println(jugador_eliminado.getEquipo());

                Update.Remove_Player(jugador_eliminado);
            }
        });
    }

    private void actualizarListaJugadores() {
        DefaultListModel<Jugador> modelo = new DefaultListModel<>();

        for (Jugador jugador: Main.getFree_players()) {
            modelo.addElement(jugador);
        }
        jugadores_libres.setModel(modelo);
    }

    public JPanel getPanel1() {
        return panel1;
    }
}

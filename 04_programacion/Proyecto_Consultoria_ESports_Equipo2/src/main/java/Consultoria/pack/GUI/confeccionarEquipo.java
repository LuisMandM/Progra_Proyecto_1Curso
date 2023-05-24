package Consultoria.pack.GUI;

import Consultoria.pack.Base_Datos.Carga;
import Consultoria.pack.Base_Datos.Visualizacion_Pack;
import Consultoria.pack.Clases_Base.Jugador;
import Consultoria.pack.Main;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

public class confeccionarEquipo {
    JPanel panel1;
    private JList<Jugador> list1;
    private JButton añadirButton;
    private JButton quitarButton;
    private JList list2;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JTextArea textArea4;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel label4;

    List<Jugador> jugadores = new ArrayList<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Confeccionar equipo");
        frame.setContentPane(new confeccionarEquipo().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public confeccionarEquipo() {
        Carga.Cargar_Equipos();
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
    }

    private void actualizarListaJugadores() {
        DefaultListModel<Jugador> modelo = new DefaultListModel<>();

        for (Jugador jugador: Main.getJugadores()) {
            modelo.addElement(jugador);
        }
        list1.setModel(modelo);
    }
}

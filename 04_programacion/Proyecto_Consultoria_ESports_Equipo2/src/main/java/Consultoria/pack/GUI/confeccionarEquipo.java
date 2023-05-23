package Consultoria.pack.GUI;

import Consultoria.pack.Clases_Base.Equipo;
import Consultoria.pack.Clases_Base.Jugador;

import javax.swing.*;
import java.util.List;

public class confeccionarEquipo {
    private JPanel panel1;
    private JList<Jugador> list1;
    private JList list2;
    private JButton añadirButton;
    private JButton quitarButton;
    private JTable table1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("confeccionarEquipo");
        frame.setContentPane(new confeccionarEquipo().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public confeccionarEquipo() {

    }
}

package Consultoria.pack.GUI;

import Consultoria.pack.Base_Datos.Carga;
import Consultoria.pack.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class verJornada {
    private JPanel panel1;
    private JLabel label1;
    private JTable table1;
    private JScrollPane scrollpane1;
    private JButton button1;
    private JButton button2;
    private JTextField Textfield1;

    private int numJor = 1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Jornadas");
        frame.setContentPane(new verJornada().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public verJornada() {

        Textfield1.setText(String.valueOf("Jornada " + numJor));

        table1 = new JTable();
        Carga.Cargar_Equipos();
        table1.setModel(new TablaJornadaModel(Main.getJornadas()));
        scrollpane1.setViewportView(table1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numJor <= 1) {
                    numJor = 9;
                    Textfield1.setText(String.valueOf("Jornada " + numJor));
                } else {
                    numJor--;
                    Textfield1.setText(String.valueOf("Jornada " + numJor));
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numJor >= 9) {
                    numJor = 1;
                    Textfield1.setText(String.valueOf("Jornada " + numJor));
                } else {
                    numJor++;
                    Textfield1.setText(String.valueOf("Jornada " + numJor));
                }
            }
        });
    }
}

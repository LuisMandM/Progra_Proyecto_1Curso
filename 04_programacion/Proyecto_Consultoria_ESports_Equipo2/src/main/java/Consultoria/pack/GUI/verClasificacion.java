package Consultoria.pack.GUI;

import Consultoria.pack.Base_Datos.Carga;
import Consultoria.pack.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class verClasificacion {
    private JPanel panel1;
    private JLabel label1;
    private JTable table1;
    private JScrollPane scrollpane1;
    private JButton button1;
    private JButton button2;
    private JTextField Textfield1;
    private JButton button3;
    private JButton button4;
    private JTextField Textfield2;

    private int numJor = 1;
    private int numTemp = 1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Clasificación");
        frame.setContentPane(new verClasificacion().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public verClasificacion() {

        table1 = new JTable();
        Carga.Cargar_Equipos();
        table1.setModel(new TablaClasificacionModel(Main.getEquipos()));
        scrollpane1.setViewportView(table1);

        Textfield2.setText("Temporada " + numTemp);
        Textfield1.setText("Jornada " + numJor);

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
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numTemp <= 1) {
                    numTemp = 9;
                    Textfield2.setText(String.valueOf("Temporada " + numTemp));
                } else {
                    numTemp--;
                    Textfield2.setText(String.valueOf("Temporada " + numTemp));
                }
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numTemp >= 9) {
                    numTemp = 1;
                    Textfield2.setText(String.valueOf("Temporada " + numTemp));
                } else {
                    numTemp++;
                    Textfield2.setText(String.valueOf("Temporada " + numTemp));
                }
            }
        });
    }
}

package Consultoria.pack.GUI;

import Consultoria.pack.Base_Datos.Carga;
import Consultoria.pack.Clases_Base.Calendario;
import Consultoria.pack.Clases_Base.Jornada;
import Consultoria.pack.Clases_Base.Partido;
import Consultoria.pack.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class verJornada {
    private JPanel panel1;
    private JLabel label1;
    private JTable table1;
    private JScrollPane scrollpane1;
    private JComboBox<LocalDate> comboBox2;
    private JComboBox comboBox1;
    private JLabel label2;
    private JLabel label3;
    private JButton button1;
    private JButton button2;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Jornadas");
        frame.setContentPane(new verJornada().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public verJornada() {

        table1 = new JTable();
        Carga.Cargar_Equipos();
        Carga.Cargar_Calendario();

        for (Jornada jornada: Main.getJornadas()) {
            comboBox2.addItem(jornada.getFecha());
        }

        for (Calendario calendario: Main.getCalendarios()) {
            comboBox1.addItem(calendario.getFecha_inicio());
        }

        table1.setModel(new TablaJornadaModel());

        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDate fecha = (LocalDate) comboBox2.getSelectedItem();
                List<Partido> partidos = new ArrayList<>();



                for (Partido partido1: Main.getPartidos()) {
                    if (partido1.getJornada().getFecha() == fecha) {
                        partidos.add(partido1);
                    }
                }
                table1.setModel(new TablaJornadaModel(partidos));
                scrollpane1.setViewportView(table1);
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDate fechaTemp = (LocalDate) comboBox1.getSelectedItem();
                List<Calendario> calendarios = new ArrayList<>();

                for (Calendario calendario: Main.getCalendarios()) {
                    if (calendario.getFecha_inicio() == fechaTemp) {
                        calendarios.add(calendario);
                    }
                }
            }
        });
    }
}

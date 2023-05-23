package Consultoria.pack.GUI;

import Consultoria.pack.Base_Datos.Carga;
import Consultoria.pack.Base_Datos.Visualizacion_Pack;
import Consultoria.pack.Clases_Base.Calendario;
import Consultoria.pack.Clases_Base.Equipo;
import Consultoria.pack.Clases_Base.Jornada;
import Consultoria.pack.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class verClasificacion {
    private JPanel panel1;
    private JLabel label1;
    private JTable table1;
    private JScrollPane scrollpane1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JLabel label2;
    private JLabel label3;
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
        Carga.Cargar_Calendario();

        for (Jornada jornada: Main.getJornadas()) {
            comboBox2.addItem(jornada.getFecha());
        }

        for (Calendario calendario: Main.getCalendarios()) {
            comboBox1.addItem(calendario.getFecha_inicio());
        }

        table1.setModel(new TablaClasificacionModel(Main.getEquipos()));
        scrollpane1.setViewportView(table1);

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
        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDate fechaJor = (LocalDate) comboBox2.getSelectedItem();
                List<Equipo> equipos = new ArrayList<>();
                int[] estadisticas;

                for (Equipo equipo: equipos) {
                    estadisticas = equipo.Estadisticas_globales();
                    Visualizacion_Pack.calcularPuntaje(estadisticas[0], estadisticas[1], estadisticas[2]);
                }
                Visualizacion_Pack.OrdenarClasificacion();
                table1.setModel(new TablaClasificacionModel(equipos));
                scrollpane1.setViewportView(table1);
            }
        });
    }
}

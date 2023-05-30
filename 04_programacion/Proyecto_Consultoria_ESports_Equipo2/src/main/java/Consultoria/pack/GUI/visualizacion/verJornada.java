package Consultoria.pack.GUI.visualizacion;

import Consultoria.pack.Base_Datos.Carga;
import Consultoria.pack.Clases_Base.Calendario;
import Consultoria.pack.Clases_Base.Jornada;
import Consultoria.pack.Clases_Base.Partido;
import Consultoria.pack.GUI.visualizacion.TablaJornadaModel;
import Consultoria.pack.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class verJornada {

    /**
     * Clase para ver los partidos y resultados de las jornadas.
     * Para ello contaremos con un combox con todas las temporadas y otro con todas las jornadas de dicha temporada.
     * @author David.R
     */

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


    public JPanel getPanel1() {
        return panel1;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("verJornada");
        frame.setContentPane(new verJornada().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Carga todos los datos de la clase Carga y los introduce al combox.
     */

    public verJornada() {

        table1 = new JTable();
        //Carga.Cargar_Equipos();
        //Carga.Cargar_Calendario();

        for (Jornada jornada: Main.getJornadas()) {
            comboBox2.addItem(jornada.getFecha());
        }

        for (Calendario calendario: Main.getCalendarios()) {
            comboBox1.addItem(calendario.getFecha_inicio());
        }

        table1.setModel(new TablaJornadaModel());

        /**
         * Carga los datos de la jornada seleccionada.
         */

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

        /**
         * Carga los datos de la temporada seleccionada.
         */

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

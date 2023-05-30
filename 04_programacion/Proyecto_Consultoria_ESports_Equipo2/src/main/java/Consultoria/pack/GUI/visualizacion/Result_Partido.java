package Consultoria.pack.GUI.visualizacion;

import Consultoria.pack.Base_Datos.Admin_Pack;
import Consultoria.pack.Base_Datos.Carga;
import Consultoria.pack.Clases_Base.Calendario;
import Consultoria.pack.Clases_Base.Jornada;
import Consultoria.pack.Clases_Base.Partido;
import Consultoria.pack.Main;

import javax.swing.*;
import java.util.List;

public class Result_Partido {
    private JPanel panel1;
    private JLabel label1;
    private JTextArea textArea1;
    private JLabel label2;
    private JLabel label3;
    private JButton button1;
    private JComboBox<Jornada> jornada_comboBox;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JComboBox<Calendario> temporadas_comboBox;
    private JComboBox<Partido> partido_comboBox;

    private List<Partido> partidos;

    public Result_Partido() {

        for (Calendario calendario:Main.getCalendarios()) {
            temporadas_comboBox.addItem(calendario);
        }

        button1.addActionListener(e -> {
            int marcador_Local = (int) spinner1.getValue();
            int marcador_Visitante = (int) spinner2.getValue();
            Partido partido_current = (Partido) partido_comboBox.getSelectedItem();
            if (partido_current != null) {

                if (marcador_Local>=0 && marcador_Visitante>=0) {
                    partido_current.setMarcador_local(marcador_Local);
                    partido_current.setMarcador_visitante(marcador_Visitante);
                    Admin_Pack.Registrar_Resultado(partido_current);
                } else JOptionPane.showMessageDialog(null, "Valores de marcador invalido", "Error", JOptionPane.ERROR_MESSAGE);
            } else JOptionPane.showMessageDialog(null, "Error al seleccionar el Partido intente" +
                    " nuevamente", "Error", JOptionPane.ERROR_MESSAGE);

        });


        jornada_comboBox.addActionListener(e -> {
            Jornada current = (Jornada) jornada_comboBox.getSelectedItem();
            if (current != null) {
                for (Partido partido : Main.getPartidos()) {
                    if (partido.getJornada() == current) partido_comboBox.addItem(partido);
                }
            } else JOptionPane.showMessageDialog(null, "Error al seleccionar la Jornada " +
                    "intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
        });

        temporadas_comboBox.addActionListener(e -> {
            Calendario current = (Calendario) temporadas_comboBox.getSelectedItem();
            if (current != null) {
                for (Jornada jornada : Main.getJornadas()) {
                    if (jornada.getCalendario() == current) jornada_comboBox.addItem(jornada);
                }
            } else JOptionPane.showMessageDialog(null, "Error al seleccionar la temporada " +
                    "intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
        });
    }

    public static void main(String[] args) {
        //Carga.Cargar_Equipos();
        //Carga.Cargar_Calendario();

        JFrame frame = new JFrame("Resultado del partido");
        frame.setContentPane(new Result_Partido().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getPanel1() {
        return panel1;
    }
}

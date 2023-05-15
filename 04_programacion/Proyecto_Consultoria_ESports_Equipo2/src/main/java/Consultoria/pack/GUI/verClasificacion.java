package Consultoria.pack.GUI;

import Consultoria.pack.Base_Datos.Carga;
import Consultoria.pack.Base_Datos.Gestor_BD;
import Consultoria.pack.Main;

import javax.swing.*;

public class verClasificacion {
    private JPanel panel1;
    private JLabel label1;
    private JTable table1;
    private JScrollPane scrollpane1;

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

    }
}

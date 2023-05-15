package Consultoria.pack.GUI;

import javax.swing.*;
import javax.swing.table.TableModel;

public class verJornada {
    private JPanel panel1;
    private JLabel label1;
    private JTable table1;
    private JScrollPane scrollpane1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Jornadas");
        frame.setContentPane(new verJornada().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public verJornada() {

        table1 = new JTable();
        table1.setModel(new TablaJornadaModel());
        scrollpane1.setViewportView(table1);
    }
}

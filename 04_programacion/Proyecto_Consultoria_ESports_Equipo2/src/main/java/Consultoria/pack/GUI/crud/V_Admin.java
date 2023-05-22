package Consultoria.pack.GUI.crud;

import Consultoria.pack.GUI.crud.crud_duenio.Crud_Duenio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V_Admin {

    private JPanel V_Admin;
    private JButton botonEquipo;
    private JButton botonDuenio;
    private JButton botonUsuario;
    private JButton botonJugador;

    public V_Admin() {
        botonDuenio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Crud_Duenio");
                frame.setContentPane(new Crud_Duenio().getPanelCrudDuenio());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("V_Admin");
        frame.setContentPane(new V_Admin().V_Admin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

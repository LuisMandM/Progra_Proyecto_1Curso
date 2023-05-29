package Consultoria.pack.gui.crud;
import Consultoria.pack.*;
import Consultoria.pack.gui.crud.crud_duenio.Crud_Duenio;
import Consultoria.pack.gui.crud.crud_equipos.Crud_Equipos;
import Consultoria.pack.gui.crud.crud_jugador.Crud_Jugador;

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
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        botonEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Crud_Equipos");
                frame.setContentPane(new Crud_Equipos().getPanelCrudEquipos());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        botonJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Crud_Jugador");
                frame.setContentPane(new Crud_Jugador().getPanelCrudJugador());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("V_Admin");
        frame.setContentPane(new V_Admin().V_Admin);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getV_Admin() {
        return V_Admin;
    }
}

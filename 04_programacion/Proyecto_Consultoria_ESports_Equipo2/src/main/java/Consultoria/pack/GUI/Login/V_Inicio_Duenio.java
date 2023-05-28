package Consultoria.pack.GUI.Login;

import Consultoria.pack.GUI.*;
import Consultoria.pack.GUI.confeccionarEquipo;
import Consultoria.pack.GUI.verClasificacion;
import Consultoria.pack.GUI.verJornada;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V_Inicio_Duenio {
    private JPanel panelDuenio;
    private JButton confeccionEquipoButton;
    private JButton resultadoPartidoButton;
    private JButton verJornadaButton;
    private JButton clasificaciónButton;

    public V_Inicio_Duenio() {
    confeccionEquipoButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("Confeccionar equipo");
            frame.setContentPane(new confeccionarEquipo().getPanel1());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
    });
    resultadoPartidoButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("Resultado del partido");
            frame.setContentPane(new Result_Partido().getPanel1());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
    });
    verJornadaButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("Jornadas");
            frame.setContentPane(new verJornada().getPanel1());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
    });
        clasificaciónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Clasificación");
                frame.setContentPane(new verClasificacion().getPanel1());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
    public JPanel getPanelDuenio() {
        return panelDuenio;
    }

}
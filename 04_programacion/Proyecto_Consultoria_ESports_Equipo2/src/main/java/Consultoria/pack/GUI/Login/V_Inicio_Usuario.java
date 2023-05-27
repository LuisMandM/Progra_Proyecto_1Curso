package Consultoria.pack.GUI.Login;

import Consultoria.pack.gui.Result_Partido;
import Consultoria.pack.gui.VerClasificacion;
import Consultoria.pack.gui.VerJornada;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V_Inicio_Usuario {
    private JPanel panelUsuario;
    private JButton resultadoPartidoButton;
    private JButton verJornadaButton;
    private JButton verClasificaciónButton;

    public JPanel getPanelUsuario() {
        return panelUsuario;
    }

    public V_Inicio_Usuario() {
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
            frame.setContentPane(new VerJornada().getPanel1());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
    });
    verClasificaciónButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("Clasificación");
            frame.setContentPane(new VerClasificacion().getPanel1());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
    });
}
}

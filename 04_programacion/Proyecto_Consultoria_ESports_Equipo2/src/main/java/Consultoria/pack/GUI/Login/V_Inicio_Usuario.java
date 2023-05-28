package Consultoria.pack.GUI.Login;

import Consultoria.pack.GUI.Result_Partido;
import Consultoria.pack.GUI.verClasificacion;
import Consultoria.pack.GUI.verJornada;

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
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
    });
    verJornadaButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("Jornadas");
            frame.setContentPane(new verJornada().getPanel1());
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
    });
    verClasificaciónButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("Clasificación");
            frame.setContentPane(new verClasificacion().getPanel1());
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
    });
}
}

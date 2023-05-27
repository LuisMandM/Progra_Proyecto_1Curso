package Consultoria.pack.GUI.Login;

import Consultoria.pack.GUI.Generar_Calendario;
import Consultoria.pack.GUI.crud.V_Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V_Inicio_Admin {
    private JPanel panelInicio_Admin;
    private JButton buttonGENERAR;
    private JButton buttonCRUD;

    public V_Inicio_Admin() {
    buttonCRUD.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("V_Admin");
            frame.setContentPane(new V_Admin().getV_Admin());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
    });
    buttonGENERAR.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("Generar_Calendario");
            frame.setContentPane(new Generar_Calendario().getPanelGenerar());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
    });
}
    public JPanel getPanelInicio_Admin() {
        return panelInicio_Admin;
    }
}

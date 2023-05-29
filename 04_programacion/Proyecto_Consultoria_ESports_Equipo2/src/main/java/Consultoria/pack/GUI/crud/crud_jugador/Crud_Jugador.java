package Consultoria.pack.GUI.crud.crud_jugador;

import Consultoria.pack.Base_Datos.Carga;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Crud_Jugador {
    private JButton crearButton;
    private JButton actualizarButton;
    private JButton eliminarButton;
    private JPanel panelCrudJugador;
public Crud_Jugador() {
    crearButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Carga.Cargar_Equipos();
            JFrame frame = new JFrame("V_CrearJugador");
            frame.setContentPane(new V_CrearJugador().getPanel_CrearJugador());
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
    });
    actualizarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Carga.Cargar_Equipos();
            JFrame frame = new JFrame("V_Actualizar_Jugador");
            frame.setContentPane(new V_Actualizar_Jugador().getPanelActualizar());
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
    });
    eliminarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("V_Eliminar_Jugador");
            frame.setContentPane(new V_Eliminar_Jugador().getPanelEliminar_Jugador());
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
    });
}
    public JPanel getPanelCrudJugador() {
        return panelCrudJugador;
    }
}

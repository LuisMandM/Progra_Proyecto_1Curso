package Consultoria.pack.GUI.crud.crud_equipos;

import Consultoria.pack.Base_Datos.Carga;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Crud_Equipos {
    private JButton crearButton;
    private JButton actualizarButton;
    private JButton eliminarButton;
    private JPanel panelCrudEquipos;
public Crud_Equipos() {
    crearButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Carga.Cargar_Equipos();
            JFrame frame = new JFrame("V_Crear_Equipo");
            frame.setContentPane(new V_Crear_Equipo().getPanelCrear_Equipo());
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
    });
    actualizarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Carga.Cargar_Equipos();
            JFrame frame = new JFrame("V_Actualizar_Equipo");
            frame.setContentPane(new V_Actualizar_Equipo().getPanelActualizarEquipo());
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
    });
    eliminarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Carga.Cargar_Equipos();
            JFrame frame = new JFrame("V_Eliminar_Equipo");
            frame.setContentPane(new V_Eliminar_Equipo().getPanelEliminarEquipo());
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
    });
}
    public JPanel getPanelCrudEquipos() {
        return panelCrudEquipos;
    }
}

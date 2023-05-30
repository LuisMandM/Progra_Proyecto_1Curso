package Consultoria.pack.GUI.crud.crud_duenio;

import Consultoria.pack.Base_Datos.Carga;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Crud_Duenio {
    private JButton CrearButton;
    private JPanel panelCrudDuenio;
    private JButton actualizarButton;
    private JButton eliminarButton;


    public Crud_Duenio() {
        CrearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Carga.Cargar_Equipos();
                JFrame frame = new JFrame("V_Crear_Duenio");
                frame.setContentPane(new V_Crear_Duenio().getPanelCrear_duenio());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Carga.Cargar_Equipos();
                JFrame frame = new JFrame("V_Actualizar_Duenio");
                frame.setContentPane(new V_Actualizar_Duenio().getPanelActualizarDuenio());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Carga.Cargar_Equipos();
                JFrame frame = new JFrame("V_Eliminar_Duenio");
                frame.setContentPane(new V_Eliminar_Duenio().getPanelEliminar_Duenio());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
    public JPanel getPanelCrudDuenio() {
        return panelCrudDuenio;
    }
}

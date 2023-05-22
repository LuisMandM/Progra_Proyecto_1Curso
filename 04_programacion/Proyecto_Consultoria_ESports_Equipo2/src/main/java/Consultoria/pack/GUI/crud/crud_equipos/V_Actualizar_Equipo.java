package Consultoria.pack.GUI.crud.crud_equipos;

import Consultoria.pack.Base_Datos.Carga;
import Consultoria.pack.Clases_Base.Equipo;
import Consultoria.pack.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V_Actualizar_Equipo {
    private JButton botonSeleccionar;
    private JPanel panelActualizarEquipo;
    private JLabel labelEscogerEquipo;
    private JComboBox<Equipo> comboBox1;

    public V_Actualizar_Equipo() {
        for (Equipo equipo : Main.getEquipos()) {
            comboBox1.addItem(equipo);
        }
        botonSeleccionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Equipo equiposelec = (Equipo) comboBox1.getSelectedItem();
                // falta crear metodo con booleano
                Carga.Cargar_Equipos();
                JFrame frame = new JFrame("V_Crear_Equipo");
                frame.setContentPane(new V_Crear_Equipo(equiposelec).getPanelCrear_Equipo());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
    public JPanel getPanelActualizarEquipo() {
        return panelActualizarEquipo;
    }

}

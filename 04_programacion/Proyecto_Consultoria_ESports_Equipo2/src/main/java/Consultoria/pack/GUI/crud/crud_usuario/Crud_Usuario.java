package Consultoria.pack.GUI.crud.crud_usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Crud_Usuario {
    private JPanel panelCrudUsuario;
    private JButton crearButton;
    private JButton actualizarButton;
    private JButton eliminarButton;

public Crud_Usuario() {
    crearButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("V_Crear_Usuario");
            frame.setContentPane(new V_Crear_Usuario().getPanelCrearUsuario());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
    });
    actualizarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
    eliminarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
}
}

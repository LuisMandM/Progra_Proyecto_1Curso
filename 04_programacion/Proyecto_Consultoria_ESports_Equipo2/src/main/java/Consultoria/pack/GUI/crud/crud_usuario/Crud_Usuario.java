package Consultoria.pack.GUI.crud.crud_usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Crud_Usuario {
    private JPanel panelCrudUsuario;
    private JButton crearButton;
    private JButton actualizarButton;
    private JButton eliminarButton;

    public JPanel getPanelCrudUsuario() {
        return panelCrudUsuario;
    }


    public Crud_Usuario() {
    crearButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("V_Crear_Usuario");
            frame.setContentPane(new V_Crear_Usuario().getPanelCrearUsuario());
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    });
    actualizarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("V_Actualizar_Usuario");
            frame.setContentPane(new V_Actualizar_Usuario().getPanelActualizarUsuario());
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    });
    eliminarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame frame = new JFrame("V_Eliminar_Usuario");
            frame.setContentPane(new V_Eliminar_Usuario().getV_Eliminr_Dueño());
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    });
}
}

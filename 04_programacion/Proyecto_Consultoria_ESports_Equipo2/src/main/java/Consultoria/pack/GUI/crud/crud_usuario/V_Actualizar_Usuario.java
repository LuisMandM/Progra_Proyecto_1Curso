package Consultoria.pack.GUI.crud.crud_usuario;

import Consultoria.pack.Clases_Base.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V_Actualizar_Usuario {
    private JPanel panelActualizarUsuario;
    private JLabel labelescoge;
    private JComboBox comboBoxUsuario;
    private JButton buttonSelectUsu;
    private boolean actualizar;
    private Usuario usuarioselec;
    public V_Actualizar_Usuario() {

    buttonSelectUsu.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Usuario usuarioselec = (Usuario) comboBoxUsuario.getSelectedItem();
            JFrame frame = new JFrame("Actualizar_Jugador");
            frame.setContentPane(new V_Crear_Usuario(usuarioselec).getPanelCrearUsuario());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
    });
}
    public JPanel getPanelActualizarUsuario() {
        return panelActualizarUsuario;
    }

    public static void main(String[] args) {

    }
}

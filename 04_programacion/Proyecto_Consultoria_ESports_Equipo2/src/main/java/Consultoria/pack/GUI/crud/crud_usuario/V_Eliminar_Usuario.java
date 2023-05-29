package Consultoria.pack.GUI.crud.crud_usuario;

import Consultoria.pack.Clases_Base.Usuario;
import Consultoria.pack.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V_Eliminar_Usuario {
    private JPanel V_Eliminr_Dueño;
    private JLabel laberlEscogeElimiUsu;
    private JComboBox comboBoxUsuario;
    private JButton buttonEliminarUsu;
public V_Eliminar_Usuario() {
    for (Usuario usuario : Main.getUsuarios()) {
        comboBoxUsuario.addItem(usuario);
    }
    buttonEliminarUsu.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Usuario usuarioselec = (Usuario) comboBoxUsuario.getSelectedItem();
            Main.getUsuarios().remove(usuarioselec);
        }
    });
}
}

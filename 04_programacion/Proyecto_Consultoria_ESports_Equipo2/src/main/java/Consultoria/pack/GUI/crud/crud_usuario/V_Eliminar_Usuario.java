package Consultoria.pack.GUI.crud.crud_usuario;

import Consultoria.pack.Clases_Base.Usuario;
import Consultoria.pack.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase `V_Eliminar_Usuario` representa la interfaz gráfica de usuario para eliminar un objeto `Usuario`.
 */
public class V_Eliminar_Usuario {
    private JPanel V_Eliminr_Dueño;
    private JLabel laberlEscogeElimiUsu;
    private JComboBox<Usuario> comboBoxUsuario;
    private JButton buttonEliminarUsu;

    /**
     * Crea una nueva instancia de `V_Eliminar_Usuario`.
     */
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

    /**
     * Obtiene el panel de la interfaz gráfica de usuario para eliminar un usuario.
     *
     * @return El panel de la interfaz gráfica de usuario.
     */
    public JPanel getV_Eliminr_Dueño() {
        return V_Eliminr_Dueño;
    }


}

package Consultoria.pack.GUI.crud.crud_usuario;

import Consultoria.pack.Clases_Base.Usuario;
import Consultoria.pack.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase `V_Actualizar_Usuario` representa la interfaz gráfica de usuario para actualizar un objeto `Usuario`.
 */
public class V_Actualizar_Usuario {
    private JPanel panelActualizarUsuario;
    private JLabel labelescoge;
    private JComboBox<Usuario> comboBoxUsuario;
    private JButton buttonSelectUsu;
    private boolean actualizar;
    private Usuario usuarioselec;

    /**
     * Crea una nueva instancia de `V_Actualizar_Usuario`.
     */
    public V_Actualizar_Usuario() {

        for (Usuario usuario : Main.getUsuarios()) {
            comboBoxUsuario.addItem(usuario);
        }
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

    /**
     * Obtiene el panel de la interfaz gráfica de usuario para actualizar un usuario.
     *
     * @return El panel de la interfaz gráfica de usuario.
     */
    public JPanel getPanelActualizarUsuario() {
        return panelActualizarUsuario;
    }

}

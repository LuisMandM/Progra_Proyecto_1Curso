package Consultoria.pack.GUI.crud.crud_usuario;

import Consultoria.pack.Clases_Base.Equipo;
import Consultoria.pack.Clases_Base.Jugador;
import Consultoria.pack.Clases_Base.Usuario;
import Consultoria.pack.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class V_Crear_Usuario {
    private JPanel panelCrearUsuario;
    private JLabel labelID;
    private JLabel labelUsuario;
    private JLabel labelContraseña;
    private JButton buttonGuardar;
    private JTextField textFieldID;
    private JTextField textFieldUsuario;
    private JPasswordField passwordUsuario;
    private boolean actualizar;
    private Usuario usuario;

    public V_Crear_Usuario(Usuario usuario) {
        this.usuario = usuario;
        this.actualizar = true;

        textFieldID.setText(String.valueOf(usuario.getId_usuario()));
        textFieldUsuario.setText(usuario.getUsuario());
        passwordUsuario.setText(usuario.getContrasenya());
        gest_Usuario();
    }
    public V_Crear_Usuario() {
        buttonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id_usuario = Integer.parseInt(textFieldID.getText());
                String nombreU = textFieldUsuario.getText();
                String contrasenya = Arrays.toString(passwordUsuario.getPassword());
                Usuario usuario = new Usuario(id_usuario,nombreU,contrasenya);
                // tengo que añadir al Main
                textFieldID.setText("");
                textFieldUsuario.setText("");
                passwordUsuario.setText("");
            }
        });
    }
    private void gest_Usuario() {
        if (!actualizar) {
            int id_usuario = Integer.parseInt(textFieldID.getText());
            String nombreU = textFieldUsuario.getText();
            String contrasenya = Arrays.toString(passwordUsuario.getPassword());
            Usuario usuario = new Usuario(id_usuario,nombreU,contrasenya);
            Main.getUsuarios().add(usuario);
            textFieldID.setText("");
            textFieldUsuario.setText("");
            passwordUsuario.setText("");
        } else {
            textFieldID.setText(String.valueOf(usuario.getId_usuario()));
            textFieldUsuario.setText(usuario.getUsuario());
            passwordUsuario.setText(usuario.getContrasenya());
        }
    }

    public JPanel getPanelCrearUsuario() {
        return panelCrearUsuario;
    }
}

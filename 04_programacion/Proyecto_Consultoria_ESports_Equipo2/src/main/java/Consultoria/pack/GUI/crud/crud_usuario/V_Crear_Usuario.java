package Consultoria.pack.GUI.crud.crud_usuario;

import Consultoria.pack.Base_Datos.CRUD.Create;
import Consultoria.pack.Base_Datos.CRUD.Update;
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
    private JTextField passwordUsuario;
    private boolean actualizar;
    private Usuario usuario;

    public V_Crear_Usuario(Usuario usuario) {
        this.usuario = usuario;
        this.actualizar = true;

        textFieldID.setText(String.valueOf(usuario.getId_usuario()));
        textFieldID.setEditable(false);

        textFieldUsuario.setText(usuario.getUsuario());
        passwordUsuario.setText(usuario.getContrasenya());
        buttonGuardar.addActionListener(e -> gest_Usuario());
    }

    public V_Crear_Usuario() {
        textFieldID.setText("Campo asignado por el sistema.");
        textFieldID.setEditable(false);

        buttonGuardar.addActionListener(e -> gest_Usuario());
    }

    private void gest_Usuario() {
        if (!actualizar) {
            //int id_usuario = Integer.parseInt(textFieldID.getText());
            String nombreU = textFieldUsuario.getText();
            String contrasenya = passwordUsuario.getText();
            Usuario usuario = new Usuario(nombreU, contrasenya);

            Create.Crear_Usuario(usuario);
            //Main.getUsuarios().add(usuario);
            textFieldID.setText("");
            textFieldUsuario.setText("");
            passwordUsuario.setText("");
        } else {

            usuario.setUsuario(textFieldUsuario.getText());
            usuario.setContrasenya(passwordUsuario.getText()); //Se puede cambiar pot un texfield normal

            Update.Update_User(usuario);
        }
    }

    public JPanel getPanelCrearUsuario() {
        return panelCrearUsuario;
    }
}

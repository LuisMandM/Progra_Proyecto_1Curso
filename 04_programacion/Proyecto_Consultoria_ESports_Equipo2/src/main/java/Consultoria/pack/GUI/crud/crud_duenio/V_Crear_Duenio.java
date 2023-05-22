package Consultoria.pack.GUI.crud.crud_duenio;

import Consultoria.pack.Clases_Base.Duenio;
import Consultoria.pack.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class V_Crear_Duenio {
    private JPanel panelCrear_duenio;
    private JLabel labelNombre;
    private JLabel labelUsuario;
    private JLabel labelContraseña;
    private JTextField textFieldID;
    private JTextField textFieldNombre;
    private JTextField textFieldUsuario;
    private JButton buttonGuardar;
    private JPasswordField passwordField1;
    private JLabel labelID;
    private boolean insert = false;
    Duenio duenio;
    public V_Crear_Duenio(Duenio duenio) {
    this.duenio=duenio;
    }
    public V_Crear_Duenio() {
        buttonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(textFieldID.getText());
                String nombre = textFieldNombre.getText();
                String usuario = textFieldUsuario.getText();
                String contraseña = Arrays.toString(passwordField1.getPassword());
                Duenio duenio = new Duenio(id,nombre,usuario,contraseña);
                Main.getDuenios().add(duenio);
                textFieldID.setText("");
                textFieldNombre.setText("");
                textFieldUsuario.setText("");
                passwordField1.setText("");
            }
        });
    }
    public JPanel getPanelCrear_duenio() {
        return panelCrear_duenio;
    }
}

package Consultoria.pack.GUI.crud.crud_duenio;

import Consultoria.pack.Base_Datos.CRUD.Create;
import Consultoria.pack.Base_Datos.CRUD.Update;
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
    private JTextField passwordField1; //Puede cambiarse por un campo textfield normal.
    private JLabel labelID;
    private Duenio duenio;
    private boolean actualizar = false;

    public V_Crear_Duenio() {
        textFieldID.setText("Campo asignado por el sistema.");
        textFieldID.setEditable(false);
        buttonGuardar.addActionListener(e -> gest_Duenio());
    }

    public V_Crear_Duenio(Duenio duenio) {
        this.duenio = duenio;
        this.actualizar = true;

        textFieldID.setText(String.valueOf(duenio.getId_usuario()));
        textFieldID.setEditable(false);

        textFieldNombre.setText(duenio.getNombre());
        textFieldUsuario.setText(duenio.getUsuario());
        passwordField1.setText(duenio.getContrasenya());

        buttonGuardar.addActionListener(e -> gest_Duenio());
    }

    private void gest_Duenio() {
        if (!actualizar) {
            int id = Integer.parseInt(textFieldID.getText());
            String nombre = textFieldNombre.getText();
            String usuario = textFieldUsuario.getText();
            String contrasenya = passwordField1.getText();
            Duenio duenio = new Duenio(nombre, usuario, contrasenya);
            //Main.getDuenios().add(duenio);
            Create.Crear_duenio(duenio);
            textFieldID.setText("");
            textFieldNombre.setText("");
            textFieldUsuario.setText("");
            passwordField1.setText("");
        } else {
            duenio.setNombre(textFieldNombre.getText());
            duenio.setUsuario(textFieldUsuario.getText());
            duenio.setContrasenya(passwordField1.getText());

            Update.Update_Duenio(duenio);

            //textFieldID.setText(String.valueOf(duenio.getId_usuario()));
            //textFieldNombre.setText(duenio.getNombre());
            //textFieldUsuario.setText(duenio.getUsuario());
            //passwordField1.setText(duenio.getContrasenya());
        }
    }

    public JPanel getPanelCrear_duenio() {
        return panelCrear_duenio;
    }
}

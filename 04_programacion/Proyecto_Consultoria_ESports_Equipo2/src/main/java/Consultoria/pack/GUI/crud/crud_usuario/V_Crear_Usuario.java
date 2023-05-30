package Consultoria.pack.GUI.crud.crud_usuario;

import Consultoria.pack.Base_Datos.CRUD.Create;
import Consultoria.pack.Base_Datos.CRUD.Update;
import Consultoria.pack.Clases_Base.Usuario;

import javax.swing.*;

/**
 * La clase `V_Crear_Usuario` representa la interfaz gráfica de usuario para crear o actualizar un objeto `Usuario`.
 */
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

    /**
     * Crea una nueva instancia de `V_Crear_Usuario` para actualizar un usuario existente.
     *
     * @param usuario El objeto `Usuario` a actualizar.
     */
    public V_Crear_Usuario(Usuario usuario) {
        this.usuario = usuario;
        this.actualizar = true;

        textFieldID.setText(String.valueOf(usuario.getId_usuario()));
        textFieldID.setEditable(false);

        textFieldUsuario.setText(usuario.getUsuario());
        passwordUsuario.setText(usuario.getContrasenya());
        buttonGuardar.addActionListener(e -> gest_Usuario());
    }

    /**
     * Crea una nueva instancia de `V_Crear_Usuario` para crear un nuevo usuario.
     */
    public V_Crear_Usuario() {
        textFieldID.setText("Campo asignado por el sistema.");
        textFieldID.setEditable(false);

        buttonGuardar.addActionListener(e -> gest_Usuario());
    }

    /**
     * Gestiona la creación o actualización del usuario según los datos ingresados en la interfaz.
     */
    private void gest_Usuario() {
        if (!actualizar) {
            String nombreU = textFieldUsuario.getText();
            String contrasenya = passwordUsuario.getText();
            Usuario usuario = new Usuario(contrasenya, nombreU);

            Create.Crear_Usuario(usuario);
            textFieldID.setText("");
            textFieldUsuario.setText("");
            passwordUsuario.setText("");
        } else {
            usuario.setUsuario(textFieldUsuario.getText());
            usuario.setContrasenya(passwordUsuario.getText());

            Update.Update_User(usuario);
        }
    }

    /**
     * Obtiene el panel de la interfaz gráfica de usuario para crear o actualizar un usuario.
     *
     * @return El panel de la interfaz gráfica de usuario.
     */
    public JPanel getPanelCrearUsuario() {
        return panelCrearUsuario;
    }
}

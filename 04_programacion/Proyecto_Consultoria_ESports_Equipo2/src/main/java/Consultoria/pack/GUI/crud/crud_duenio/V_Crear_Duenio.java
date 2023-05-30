package Consultoria.pack.GUI.crud.crud_duenio;

import Consultoria.pack.Base_Datos.CRUD.Create;
import Consultoria.pack.Base_Datos.CRUD.Update;
import Consultoria.pack.Clases_Base.Duenio;

import javax.swing.*;

/**
 * La clase `V_Crear_Duenio` representa la interfaz gráfica de usuario para la creación y actualización de un objeto `Duenio`.
 */
public class V_Crear_Duenio {
    private JPanel panelCrear_duenio;
    private JLabel labelNombre;
    private JLabel labelUsuario;
    private JLabel labelContraseña;
    private JTextField textFieldID;
    private JTextField textFieldNombre;
    private JTextField textFieldUsuario;
    private JButton buttonGuardar;
    private JTextField passwordField1;
    private JLabel labelID;
    private Duenio duenio;
    private boolean actualizar = false;

    /**
     * Crea una nueva instancia de `V_Crear_Duenio` para la creación de un nuevo `Duenio`.
     */
    public V_Crear_Duenio() {
        textFieldID.setText("Campo asignado por el sistema.");
        textFieldID.setEditable(false);
        buttonGuardar.addActionListener(e -> gest_Duenio());
    }

    /**
     * Crea una nueva instancia de `V_Crear_Duenio` para la actualización de un `Duenio` existente.
     *
     * @param duenio El objeto `Duenio` a actualizar.
     */
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

    /**
     * Gestiona la creación o actualización del objeto `Duenio` según los datos ingresados en la interfaz.
     */
    private void gest_Duenio() {
        if (!actualizar) {
            String nombre = textFieldNombre.getText();
            String usuario = textFieldUsuario.getText();
            String contrasenya = passwordField1.getText();
            Duenio duenio = new Duenio(nombre, usuario, contrasenya);
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
        }
    }

    /**
     * Obtiene el panel de la interfaz gráfica de usuario para la creación y actualización de `Duenio`.
     *
     * @return El panel de la interfaz gráfica de usuario.
     */
    public JPanel getPanelCrear_duenio() {
        return panelCrear_duenio;
    }
}

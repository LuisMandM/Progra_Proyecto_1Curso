package Consultoria.pack.GUI.crud.crud_jugador;

import Consultoria.pack.Base_Datos.CRUD.Create;
import Consultoria.pack.Base_Datos.CRUD.Update;
import Consultoria.pack.Clases_Base.Equipo;
import Consultoria.pack.Clases_Base.Jugador;

import javax.swing.*;

/**
 * La clase `V_CrearJugador` representa la interfaz gráfica de usuario para crear o actualizar un objeto `Jugador`.
 */
public class V_CrearJugador {
    private JPanel Panel_CrearJugador;
    private JLabel label_IDJugador;
    private JLabel labelNombre;
    private JLabel labelNickname;
    private JLabel labelSueldo;
    private JTextField textFieldId_jugador;
    private JTextField textFieldNombre;
    private JTextField textFieldNickname;
    private JTextField textFieldSueldo;
    private JButton buttonGuardar;
    private JComboBox<Equipo> comboBoxEquipos;
    private boolean actualizar;
    Jugador jugador;

    /**
     * Crea una nueva instancia de `V_CrearJugador` para crear un nuevo jugador.
     */
    public V_CrearJugador() {
        textFieldId_jugador.setText("Campo asignado por el sistema.");
        textFieldId_jugador.setEditable(false);

        buttonGuardar.addActionListener(e -> gest_Jugador());
    }

    /**
     * Crea una nueva instancia de `V_CrearJugador` para actualizar un jugador existente.
     *
     * @param jugador El objeto `Jugador` a actualizar.
     */
    public V_CrearJugador(Jugador jugador) {
        this.jugador = jugador;
        this.actualizar = true;

        textFieldId_jugador.setText(String.valueOf(jugador.getId_jugador()));
        textFieldId_jugador.setEditable(false);

        textFieldNombre.setText(jugador.getNombre());
        textFieldNickname.setText(jugador.getNickname());
        textFieldSueldo.setText(String.valueOf(jugador.getSueldo()));

        buttonGuardar.addActionListener(e -> gest_Jugador());
    }

    /**
     * Gestiona la creación o actualización del jugador en función de los datos proporcionados.
     */
    private void gest_Jugador() {
        if (!actualizar) {
            String nombre = textFieldNombre.getText();
            String nickname = textFieldNickname.getText();

            try {
                double sueldo = Double.parseDouble(textFieldSueldo.getText());

                if (sueldo > 0) {

                    Create.Crear_jugador(new Jugador(nombre, nickname, sueldo));
                    textFieldId_jugador.setText("");
                    textFieldNombre.setText("");
                    textFieldNickname.setText("");
                    textFieldSueldo.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "El sueldo de un jugador no puede ser nulo o negativo.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Tipo de dato en sueldo no es correcto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            jugador.setNombre(textFieldNombre.getText());
            jugador.setNickname(textFieldNickname.getText());
            jugador.setSueldo(Double.parseDouble(textFieldSueldo.getText()));

            Update.Update_Jugador(jugador);
        }
    }

    /**
     * Obtiene el panel de la interfaz gráfica de usuario para crear o actualizar un jugador.
     *
     * @return El panel de la interfaz gráfica de usuario.
     */
    public JPanel getPanel_CrearJugador() {
        return Panel_CrearJugador;
    }
}

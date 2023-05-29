package Consultoria.pack.gui.crud.crud_equipos;

import Consultoria.pack.Base_Datos.CRUD.Create;
import Consultoria.pack.Base_Datos.CRUD.Update;
import Consultoria.pack.Base_Datos.Carga;
import Consultoria.pack.Clases_Base.Duenio;
import Consultoria.pack.Clases_Base.Equipo;
import Consultoria.pack.Clases_Base.Jugador;
import Consultoria.pack.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class V_Crear_Equipo {

    private JPanel panelCrear_Equipo;
    private JLabel labelID_Equipo;
    private JTextField textFieldID_Equipo;
    private JLabel labelname;
    private JTextField textFieldNombreEquipo;
    private JTextField textFieldSalario_Total;
    private JLabel labelEquipoDuenio;
    private JComboBox<Duenio> comboBoxDuenio;
    private JButton buttonConfirmar;
    private boolean actualizar = false;
    private Duenio duenioselec;
    List<Duenio> duenios;
    Equipo equipo;

    public V_Crear_Equipo(Equipo equipo) {
        this.equipo = equipo;
        this.actualizar = true;

        comboBoxDuenio.addItem(equipo.getDuenyo());

        textFieldID_Equipo.setText(String.valueOf(equipo.getId_equipo()));
        textFieldID_Equipo.setEditable(false);

        textFieldNombreEquipo.setText(equipo.getNombre());
        textFieldSalario_Total.setText(String.valueOf(equipo.getSalario_total()));
        textFieldSalario_Total.setEditable(false);

        buttonConfirmar.addActionListener(e -> gest_Equipo());
    }
    public V_Crear_Equipo() {
        for (Duenio duenio: Main.getDuenios()) {
            comboBoxDuenio.addItem(duenio);
        }
        textFieldID_Equipo.setText("Campo asignado por el sistema.");
        textFieldID_Equipo.setEditable(false);
        textFieldSalario_Total.setText("0");
        textFieldSalario_Total.setEditable(false);

        buttonConfirmar.addActionListener(e -> gest_Equipo());
    }
    private void gest_Equipo() {
        if (!actualizar) {
            int id = Integer.parseInt(textFieldID_Equipo.getText());
            String nombre = textFieldNombreEquipo.getText();
            double tope_salarial = Double.parseDouble(textFieldSalario_Total.getText());
            Duenio duenioselec = (Duenio) comboBoxDuenio.getSelectedItem();
            Equipo equipo = new Equipo(nombre,tope_salarial,duenioselec);

            Create.Crear_equipo(equipo);
            //Main.getEquipos().add(equipo);
            textFieldID_Equipo.setText("");
            textFieldNombreEquipo.setText("");
            textFieldSalario_Total.setText("");
        } else {

            equipo.setNombre(textFieldNombreEquipo.getText());
            Update.Update_Equipo(equipo);

        }
    }
    public JPanel getPanelCrear_Equipo() {
        return panelCrear_Equipo;
    }
}

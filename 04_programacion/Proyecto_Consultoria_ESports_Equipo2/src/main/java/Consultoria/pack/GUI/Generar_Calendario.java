package Consultoria.pack.GUI;

import Consultoria.pack.Clases_Base.Equipo;
import Consultoria.pack.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Generar_Calendario {
    private JButton generarCalendarioButton;
    private JPanel panelGenerar;
    private JTextField textFieldFecha;

    public JPanel getPanelGenerar() {
        return panelGenerar;
    }

    public Generar_Calendario() {

        JOptionPane.showMessageDialog(null, "La fecha debe ser introducida " +
                "siguiendo el modelo yyyy-mm-dd", "FORMAT FECHA", JOptionPane.INFORMATION_MESSAGE);
        generarCalendarioButton.addActionListener(e -> {

            if (JugadoresValid()) {

                if (Main.getEquipos().size()%2 == 0) {
                    String fecha = textFieldFecha.getText();
                    LocalDate date = LocalDate.parse(fecha);
                } else
                    JOptionPane.showMessageDialog(null, "La fecha debe ser introducida " +
                            "siguiendo el modelo yyyy-mm-dd", "Error Cantidad Jugadores", JOptionPane.ERROR_MESSAGE);
            } else JOptionPane.showMessageDialog(null, "Existe un equipo con menos de 2 Jugadores," +
                    "\nLa temporada no puede iniciarse asi.", "Error Cantidad Jugadores", JOptionPane.ERROR_MESSAGE);
        });
    }

    private boolean JugadoresValid() {
        boolean able = true;
        for (Equipo equipo : Main.getEquipos()) {
            if (equipo.getJugadores().length < 2) able = false;
        }
        return able;
    }
}

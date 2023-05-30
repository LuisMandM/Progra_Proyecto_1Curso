package Consultoria.pack.GUI;

import Consultoria.pack.Base_Datos.Admin_Pack;
import Consultoria.pack.Clases_Base.Equipo;
import Consultoria.pack.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.DateTimeException;
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
                    try {
                        LocalDate date = LocalDate.parse(fecha);
                        if (date.isAfter(Main.getCalendarios().get(Main.getCalendarios().size()-1).getFecha_fin())){
                            Admin_Pack.Generar_Temporada(date);
                        }else JOptionPane.showMessageDialog(null, "No se puede crear una temporada" +
                                        " con fecha de inicio anterior\n a la fecha de fin de una temporada.", "Error",
                                JOptionPane.ERROR_MESSAGE);

                    } catch (DateTimeException ex) {
                        JOptionPane.showMessageDialog(null, "Fecha mal introducida debe ingresar un valor logico,\n" +
                                        "siguiendo el modelo yyyy-mm-dd", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } catch (SQLException exe) {
                        JOptionPane.showMessageDialog(null, exe.getCause().getMessage(),
                                "Error BD", JOptionPane.ERROR_MESSAGE);
                    }


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

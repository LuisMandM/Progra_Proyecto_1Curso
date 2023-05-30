package Consultoria.pack.Clases_Base;

import java.time.LocalDate;

import java.time.LocalDate;

/**
 * La clase `HistorialJugador` representa el historial de un jugador en un equipo específico.
 */
public class HistorialJugador {
    private LocalDate id_jugador;
    private LocalDate id_equipo;
    private Equipo equipo;
    private Jugador jugador;

    /**
     * Crea un nuevo objeto `HistorialJugador` con los siguientes parámetros:
     *
     * @param id_jugador El ID del jugador en el historial.
     * @param id_equipo  El ID del equipo en el historial.
     * @param equipo     El objeto `Equipo` asociado al historial.
     * @param jugador    El objeto `Jugador` asociado al historial.
     */
    public HistorialJugador(LocalDate id_jugador, LocalDate id_equipo, Equipo equipo, Jugador jugador) {
        this.id_jugador = id_jugador;
        this.id_equipo = id_equipo;
        this.equipo = equipo;
        this.jugador = jugador;
    }

    public LocalDate getId_jugador() {
        return id_jugador;
    }

    public void setId_jugador(LocalDate id_jugador) {
        this.id_jugador = id_jugador;
    }

    public LocalDate getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(LocalDate id_equipo) {
        this.id_equipo = id_equipo;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public String toString() {
        return "\n********************Historial Jugador********************\n" +
                "-Id jugador: " + id_jugador + "\n" +
                "-Id equipo: " + id_equipo + "\n" +
                "-Equipo: " + equipo + "\n" +
                "-Jugador: " + jugador +
                "\n********************************************************\n";
    }
}

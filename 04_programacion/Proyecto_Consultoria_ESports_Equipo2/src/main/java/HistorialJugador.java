import java.time.LocalDate;

public class HistorialJugador {
    private LocalDate id_jugador;
    private LocalDate id_equipo;
    private Equipo equipo;
    private Jugador jugador;

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
        return "HistorialJugador{" +
                "id_jugador=" + id_jugador +
                ", id_equipo=" + id_equipo +
                ", equipo=" + equipo +
                ", jugador=" + jugador +
                '}';
    }
}

package Consultoria.pack.Clases_Base;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Jornada {
    private int id_jornada;
    private LocalDate fecha;
    private Calendario calendario;
    private List<Equipo> equipos = new ArrayList<>();

    public Jornada(int id_jornada, LocalDate fecha, Calendario calendario) {
        this.id_jornada = id_jornada;
        this.fecha = fecha;
        this.calendario = calendario;
    }

    public Jornada(LocalDate fecha, Calendario calendario) {
        this.fecha = fecha;
        this.calendario = calendario;
    }

    public Jornada() {
    }

    public int getId_jornada() {
        return id_jornada;
    }

    public void setId_jornada(int id_jornada) {
        this.id_jornada = id_jornada;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Calendario getCalendario() {
        return calendario;
    }

    public void setCalendario(Calendario calendario) {
        this.calendario = calendario;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    @Override
    public String toString() {
        return "Jornada: "+ id_jornada + " / "+getFecha();
    }

    //Equals and HashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jornada jornada = (Jornada) o;
        return id_jornada == jornada.id_jornada && fecha.equals(jornada.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_jornada, fecha);
    }
}

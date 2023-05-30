package Consultoria.pack.Clases_Base;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * La clase `Jornada` representa una jornada de un calendario en un torneo.
 */
public class Jornada {
    private int id_jornada;
    private LocalDate fecha;
    private Calendario calendario;
    private List<Equipo> equipos = new ArrayList<>();

    /**
     * Crea un nuevo objeto `Jornada` con los siguientes parámetros:
     *
     * @param id_jornada  El ID de la jornada.
     * @param fecha       La fecha de la jornada.
     * @param calendario  El objeto `Calendario` asociado a la jornada.
     */
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

    /**
     * Compara esta instancia de `Jornada` con otro objeto para verificar si son iguales.
     *
     * @param o El objeto a comparar.
     * @return `true` si este objeto es igual al objeto proporcionado, `false` en caso contrario.
     */
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

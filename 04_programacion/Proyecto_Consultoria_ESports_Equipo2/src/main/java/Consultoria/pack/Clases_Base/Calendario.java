package Consultoria.pack.Clases_Base;

import java.time.LocalDate;
import java.util.Objects;

/**
 * La clase `Calendario` representa un calendario con una temporada y un rango de fechas.
 */
public class Calendario {
    private int id_temporada;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;

    /**
     * Crea un nuevo objeto `Calendario` con los siguientes parámetros:
     *
     * @param id_temporada  El ID de la temporada.
     * @param fecha_inicio  La fecha de inicio del calendario.
     * @param fecha_fin     La fecha de fin del calendario.
     */
    public Calendario(int id_temporada, LocalDate fecha_inicio, LocalDate fecha_fin) {
        this.id_temporada = id_temporada;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    /**
     * Crea un nuevo objeto `Calendario` con los siguientes parámetros:
     *
     * @param fecha_inicio  La fecha de inicio del calendario.
     * @param fecha_fin     La fecha de fin del calendario.
     */
    public Calendario(LocalDate fecha_inicio, LocalDate fecha_fin) {
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }


    public Calendario() {
    }

    public int getId_temporada() {
        return id_temporada;
    }

    public void setId_temporada(int id_temporada) {
        this.id_temporada = id_temporada;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    @Override
    public String toString() {
        return "Temporada: "+fecha_inicio+" - "+fecha_fin;
    }

    /**
     * Compara si el objeto actual es igual a otro objeto dado.
     *
     * @param o El objeto a comparar.
     * @return `true` si los objetos son iguales, `false` en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calendario that = (Calendario) o;
        return id_temporada == that.id_temporada && Objects.equals(fecha_inicio, that.fecha_inicio) && Objects.equals(fecha_fin, that.fecha_fin);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id_temporada, fecha_inicio, fecha_fin);
    }
}

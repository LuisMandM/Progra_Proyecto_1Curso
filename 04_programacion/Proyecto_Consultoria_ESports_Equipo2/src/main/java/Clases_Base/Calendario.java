package Clases_Base;

import java.time.LocalDate;


public class Calendario {
    private int id_temporada;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;

    public Calendario(int id_temporada, LocalDate fecha_inicio, LocalDate fecha_fin) {
        this.id_temporada = id_temporada;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
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
        return "Clases_Base.Calendario{" +
                "id_temporada=" + id_temporada +
                ", fecha_inicio=" + fecha_inicio +
                ", fecha_fin=" + fecha_fin +
                '}';
    }
}

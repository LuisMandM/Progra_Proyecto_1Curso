package Consultoria.pack.Clases_Base;

import java.util.Objects;

/**
 * La clase `Partido` representa un partido entre dos equipos en una jornada.
 */
public class Partido {
    private int id_partido;
    private int marcador_local;
    private int marcador_visitante;
    private Equipo equipoL;
    private Equipo equipoV;
    private Equipo equipoGanador;
    private Jornada jornada;

    /**
     * Crea un nuevo objeto `Partido` con los siguientes parámetros:
     *
     * @param id_partido         El ID del partido.
     * @param marcador_local     El marcador del equipo local.
     * @param marcador_visitante El marcador del equipo visitante.
     * @param equipoL            El objeto `Equipo` del equipo local.
     * @param equipoV            El objeto `Equipo` del equipo visitante.
     * @param jornada            El objeto `Jornada` asociado al partido.
     */
    public Partido(int id_partido, int marcador_local, int marcador_visitante, Equipo equipoL, Equipo equipoV, Jornada jornada) {
        this.id_partido = id_partido;
        this.marcador_local = marcador_local;
        this.marcador_visitante = marcador_visitante;
        this.equipoL = equipoL;
        this.equipoV = equipoV;
        this.jornada = jornada;
    }

    public Partido() {
    }

    public Partido(int marcador_local, int marcador_visitante) {
        this.marcador_local = marcador_local;
        this.marcador_visitante = marcador_visitante;
    }

    public int getId_partido() {
        return id_partido;
    }

    public void setId_partido(int id_partido) {
        this.id_partido = id_partido;
    }

    public int getMarcador_local() {
        return marcador_local;
    }

    public void setMarcador_local(int marcador_local) {
        this.marcador_local = marcador_local;
    }

    public int getMarcador_visitante() {
        return marcador_visitante;
    }

    public void setMarcador_visitante(int marcador_visitante) {
        this.marcador_visitante = marcador_visitante;
    }

    public Equipo getEquipoL() {
        return equipoL;
    }

    public void setEquipoL(Equipo equipoL) {
        this.equipoL = equipoL;
    }

    public Equipo getEquipoV() {
        return equipoV;
    }

    public void setEquipoV(Equipo equipoV) {
        this.equipoV = equipoV;
    }

    public Equipo getEquipoGanador() {
        return equipoGanador;
    }

    public void setEquipoGanador(Equipo equipoGanador) {
        this.equipoGanador = equipoGanador;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    @Override
    public String toString() {
        return equipoL.getNombre() +
                " vs  " + equipoV.getNombre() ;
    }
    /**
     * Compara esta instancia de `Partido` con otro objeto para verificar si son iguales.
     *
     * @param o El objeto a comparar.
     * @return `true` si este objeto es igual al objeto proporcionado, `false` en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partido partido = (Partido) o;
        return id_partido == partido.id_partido && Objects.equals(equipoL, partido.equipoL) && Objects.equals(equipoV, partido.equipoV) && Objects.equals(jornada, partido.jornada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_partido, equipoL, equipoV, jornada);
    }
}

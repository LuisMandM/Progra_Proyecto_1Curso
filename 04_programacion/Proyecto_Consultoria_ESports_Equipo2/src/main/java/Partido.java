public class Partido {

    private int id_partido;
    private int marcador_local;
    private int marcador_visitante;
    private Equipo equipoL;
    private Equipo equipoV;
    private Equipo equipoGanador;
    private Jornada jornada;

    public Partido(int id_partido, int marcador_local, int marcador_visitante, Equipo equipoL, Equipo equipoV, Equipo equipoGanador, Jornada jornada) {
        this.id_partido = id_partido;
        this.marcador_local = marcador_local;
        this.marcador_visitante = marcador_visitante;
        this.equipoL = equipoL;
        this.equipoV = equipoV;
        this.equipoGanador = equipoGanador;
        this.jornada = jornada;
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
        return "Partido{" +
                "id_partido=" + id_partido +
                ", marcador_local=" + marcador_local +
                ", marcador_visitante=" + marcador_visitante +
                ", equipoL=" + equipoL +
                ", equipoV=" + equipoV +
                ", equipoGanador=" + equipoGanador +
                ", jornada=" + jornada +
                '}';
    }
}

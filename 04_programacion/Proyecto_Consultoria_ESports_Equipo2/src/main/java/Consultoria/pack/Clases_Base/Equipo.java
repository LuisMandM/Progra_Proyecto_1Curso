package Consultoria.pack.Clases_Base;

public class Equipo {

    private int id_equipo;
    private String nombre;
    private double salario_total;
    private Duenio duenio;
    private final Jugador[] jugadores = new Jugador[6];

    public Equipo(int id_equipo, String nombre, double salario_total, Duenio duenio) {
        this.id_equipo = id_equipo;
        this.nombre = nombre;
        this.salario_total = salario_total;
        this.duenio = duenio;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario_total() {
        return salario_total;
    }

    public void setSalario_total(double salario_total) {
        this.salario_total = salario_total;
    }

    public Duenio getDuenyo() {
        return duenio;
    }

    public void setDuenyo(Duenio duenio) {
        this.duenio = duenio;
    }

    public void addPlayer(Jugador jugador, int posicion){
        this.jugadores[posicion] = jugador;
    }
    public Jugador[] getJugadores() {
        return jugadores;
    }

    @Override
    public String toString() {
        return "Clases_Base.Equipo{" +
                "id_equipo=" + id_equipo +
                ", nombre='" + nombre + '\'' +
                ", salario_total=" + salario_total +
                ", duenyo=" + duenio +
                '}';
    }
}

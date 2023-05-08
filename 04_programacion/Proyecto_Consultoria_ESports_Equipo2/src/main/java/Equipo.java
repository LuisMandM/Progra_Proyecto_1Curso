import java.util.Arrays;

public class Equipo {

    private int id_equipo;
    private String nombre;
    private double salario_total;
    private Duenyo duenyo;
    private final Jugador[] jugadores = new Jugador[6];

    public Equipo(int id_equipo, String nombre, double salario_total, Duenyo duenyo) {
        this.id_equipo = id_equipo;
        this.nombre = nombre;
        this.salario_total = salario_total;
        this.duenyo = duenyo;
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

    public Duenyo getDuenyo() {
        return duenyo;
    }

    public void setDuenyo(Duenyo duenyo) {
        this.duenyo = duenyo;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id_equipo=" + id_equipo +
                ", nombre='" + nombre + '\'' +
                ", salario_total=" + salario_total +
                ", duenyo=" + duenyo +
                ", jugadores=" + Arrays.toString(jugadores) +
                '}';
    }
}

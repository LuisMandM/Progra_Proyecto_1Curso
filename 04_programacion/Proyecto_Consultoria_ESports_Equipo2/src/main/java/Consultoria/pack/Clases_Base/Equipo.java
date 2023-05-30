package Consultoria.pack.Clases_Base;

import Consultoria.pack.Base_Datos.Visualizacion_Pack;

import java.util.Objects;

/**
 * La clase `Equipo` representa un equipo con jugadores, un dueño y estadísticas asociadas.
 */
public class Equipo {

    private int id_equipo;
    private String nombre;
    private double salario_total;
    private Duenio duenio;
    private final Jugador[] jugadores = new Jugador[6];

    /**
     * Crea un nuevo objeto `Equipo` con los siguientes parámetros:
     *
     * @param id_equipo     El ID del equipo.
     * @param nombre        El nombre del equipo.
     * @param salario_total El salario total del equipo.
     * @param duenio        El dueño del equipo.
     */
    public Equipo(int id_equipo, String nombre, double salario_total, Duenio duenio) {
        this.id_equipo = id_equipo;
        this.nombre = nombre;
        this.salario_total = salario_total;
        this.duenio = duenio;
    }

    public Equipo(String nombre, double salario_total, Duenio duenio) {
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
        Equipo equipo = (Equipo) o;
        return Objects.equals(nombre, equipo.nombre);
    }

    /**
     * Calcula el código hash del objeto.
     *
     * @return El código hash calculado.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el salario total del equipo.
     *
     * @return El salario total del equipo.
     */
    public double getSalario_total() {
        double salario = 0;
        for (Jugador jugador : jugadores) {
            salario += jugador.getSueldo();
        }

        return salario;
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

    public void addPlayer(Jugador jugador, int posicion) {
        this.jugadores[posicion] = jugador;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    @Override
    public String toString() {
        return nombre;
    }

    //Utilities

    /**
     * Obtiene las estadísticas globales del equipo.
     *
     * @return Un arreglo de enteros con las estadísticas globales del equipo.
     */
    public int[] Estadisticas_globales() {
        return Visualizacion_Pack.Historial_Equipo(this.id_equipo);
    }

    /**
     * Obtiene las estadísticas del equipo para una temporada específica.
     *
     * @param id_temporada El ID de la temporada.
     * @return Un arreglo de enteros con las estadísticas del equipo para la temporada especificada.
     */
    public int[] Estadisticas_Temporada(int id_temporada) {
        return Visualizacion_Pack.Historial_Equipo_Temporada(id_temporada, this.id_equipo);
    }
}

package Consultoria.pack.Clases_Base;

import Consultoria.pack.Base_Datos.Visualizacion_Pack;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipo equipo = (Equipo) o;
        return Objects.equals(nombre, equipo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
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
        return nombre ;
    }

    //Utilities

    public int[] Estadisticas_globales(){
        return Visualizacion_Pack.Historial_Equipo(this.id_equipo);
    }public int[] Estadisticas_Temporada(int id_temporada){
        return Visualizacion_Pack.Historial_Equipo_Temporada(id_temporada,this.id_equipo);
    }

}

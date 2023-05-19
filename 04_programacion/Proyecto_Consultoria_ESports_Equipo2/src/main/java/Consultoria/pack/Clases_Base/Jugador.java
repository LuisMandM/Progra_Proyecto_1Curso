package Consultoria.pack.Clases_Base;

import java.util.Objects;

public class Jugador {

    private int id_jugador;
    private String nombre;
    private String nickname;
    private int sueldo;
    private Equipo equipo;

    public Jugador(int id_jugador, String nombre, String nickname, int sueldo, Equipo equipo) {
        this.id_jugador = id_jugador;
        this.nombre = nombre;
        this.nickname = nickname;
        this.sueldo = sueldo;
        this.equipo = equipo;
    }

    public int getId_jugador() {
        return id_jugador;
    }

    public void setId_jugador(int id_jugador) {
        this.id_jugador = id_jugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Clases_Base.Jugador{" +
                "id_jugador=" + id_jugador +
                ", nombre='" + nombre + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sueldo=" + sueldo +
                ", equipo=" + equipo +
                '}';
    }

    //equals and HasCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return id_jugador == jugador.id_jugador && Objects.equals(nombre, jugador.nombre) && Objects.equals(nickname, jugador.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_jugador, nombre, nickname);
    }
}

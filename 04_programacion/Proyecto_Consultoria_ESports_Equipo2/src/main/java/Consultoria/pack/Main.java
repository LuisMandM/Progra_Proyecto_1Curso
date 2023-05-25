package Consultoria.pack;

import Consultoria.pack.Clases_Base.*;
import Consultoria.pack.gui.Login.V_Login;

import javax.swing.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static Connection connection ;

    private static  List<Equipo> equipos  = new ArrayList<>();
    private static  List<Jugador> jugadores  = new ArrayList<>();
    private static  List<Duenio> duenios  = new ArrayList<>();
    private static List<Calendario> calendarios = new ArrayList<>();
    private static List<Jornada> jornadas = new ArrayList<>();
    private static List<Partido> partidos = new ArrayList<>();
    private static List<Usuario> usuarios = new ArrayList<>();

    private static List<Jugador> free_players = new ArrayList<>();


    public static void main(String[] args) {

        JFrame frame = new JFrame("Login");
        frame.setContentPane(new V_Login(frame).getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        System.out.println("Prueba");
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        Main.connection = connection;
    }

    public static List<Usuario> getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(List<Usuario> usuarios) {
        Main.usuarios = usuarios;
    }

    public static List<Equipo> getEquipos() {
        return equipos;
    }

    public static void setEquipos(List<Equipo> equipos) {
        Main.equipos = equipos;
    }

    public static List<Jugador> getJugadores() {
        return jugadores;
    }

    public static void setJugadores(List<Jugador> jugadores) {
        Main.jugadores = jugadores;
    }

    public static List<Duenio> getDuenios() {
        return duenios;
    }

    public static void setDuenios(List<Duenio> duenios) {
        Main.duenios = duenios;
    }

    public static List<Calendario> getCalendarios() {
        return calendarios;
    }

    public static void setCalendarios(List<Calendario> calendarios) {
        Main.calendarios = calendarios;
    }

    public static List<Jornada> getJornadas() {
        return jornadas;
    }

    public static void setJornadas(List<Jornada> jornadas) {
        Main.jornadas = jornadas;
    }

    public static List<Partido> getPartidos() {
        return partidos;
    }

    public static void setPartidos(List<Partido> partidos) {
        Main.partidos = partidos;
    }

    public static List<Jugador> getFree_players() {
        return free_players;
    }

    public static void setFree_players(List<Jugador> free_players) {
        Main.free_players = free_players;
    }
}
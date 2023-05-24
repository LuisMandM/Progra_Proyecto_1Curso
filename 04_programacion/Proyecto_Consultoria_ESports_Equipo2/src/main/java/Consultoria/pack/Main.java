package Consultoria.pack;

import Consultoria.pack.Base_Datos.Carga;
import Consultoria.pack.Clases_Base.*;
import Consultoria.pack.Base_Datos.Gestor_BD;
import Consultoria.pack.Base_Datos.*;
import Consultoria.pack.GUI.Login.V_Login;
import Consultoria.pack.GUI.crud.crud_duenio.Crud_Duenio;

import javax.swing.*;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static Consultoria.pack.Base_Datos.Visualizacion_Pack.OrdenarClasificacion;

public class Main {

    private static Connection connection ;

    private static  List<Equipo> equipos  = new ArrayList<>();
    private static  List<Jugador> jugadores  = new ArrayList<>();
    private static  List<Duenio> duenios  = new ArrayList<>();
    private static List<Calendario> calendarios = new ArrayList<>();
    private static List<Jornada> jornadas = new ArrayList<>();
    private static List<Partido> partidos = new ArrayList<>();

    public static void main(String[] args) {

        JFrame frame = new JFrame("Login");
        frame.setContentPane(new V_Login(frame).getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        System.out.println("Prueba");
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
}
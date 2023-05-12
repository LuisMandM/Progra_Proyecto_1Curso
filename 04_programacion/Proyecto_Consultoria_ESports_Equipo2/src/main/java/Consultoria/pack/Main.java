package Consultoria.pack;

import Consultoria.pack.Base_Datos.Carga;
import Consultoria.pack.Clases_Base.Duenio;
import Consultoria.pack.Clases_Base.Equipo;
import Consultoria.pack.Clases_Base.Jugador;
import Consultoria.pack.Base_Datos.Gestor_BD;
import Consultoria.pack.Base_Datos.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static Connection connection ;

    private static  List<Equipo> equipos  = new ArrayList<>();
    private static  List<Jugador> jugadores  = new ArrayList<>();
    private static  List<Duenio> duenios  = new ArrayList<>();



    public static void main(String[] args) {

        connection = Gestor_BD.Conectar_BD();
        List<Jugador> jugadores = new ArrayList<>();
        Carga.Cargar_Equipos();

        try {
            Statement statement = connection.createStatement();
            ResultSet result_Jugadores = statement.executeQuery("SELECT * FROM JUGADOR");

            while (result_Jugadores.next()){
                Jugador actual = new Jugador(result_Jugadores.getInt("ID_JUGADOR"),
                        result_Jugadores.getString("NOMBRE"),result_Jugadores.getString("NICKNAME"),
                        result_Jugadores.getInt("SUELDO"),null);
            jugadores.add(actual);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (Jugador jugador:jugadores) {
            System.out.println(jugador);
        }

    }

    public void pepe(){}

    public static List<Equipo> getEquipos() {
        return equipos;
    }

    public  void setEquipos(List<Equipo> equipos) {
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

    public  void setDuenios(List<Duenio> duenios) {
        Main.duenios = duenios;
    }
}
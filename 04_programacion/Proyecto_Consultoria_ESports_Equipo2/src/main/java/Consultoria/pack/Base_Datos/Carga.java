package Consultoria.pack.Base_Datos;

import Consultoria.pack.Clases_Base.*;
import Consultoria.pack.Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Carga {


    public static void Cargar_Equipos() {
        Connection connection = Gestor_BD.Conectar_BD();
        List<Jugador> jugadores = new ArrayList<>();
        List<Duenio> duenios = new ArrayList<>();
        List<Equipo> equipos = new ArrayList<>();
        try {

            Statement statement = connection.createStatement();
            ResultSet resultDuenios = statement.executeQuery("SELECT * FROM DUEÑO");

            while (resultDuenios.next()) {

                Duenio actual = new Duenio(resultDuenios.getInt("ID_DUEÑO"), resultDuenios.getString("NOMBRE"),
                        resultDuenios.getString("USUARIO"), resultDuenios.getString("CONTRASEÑA"));

                Statement statement_equi = connection.createStatement();
                ResultSet result_Equi = statement_equi.executeQuery("SELECT * FROM EQUIPO WHERE ID_DUENIO = "
                        + actual.getId_usuario());

                while (result_Equi.next()) {
                    Equipo equipo = new Equipo(result_Equi.getInt("ID_EQUIPO"), result_Equi.getString("NOMBRE"),
                            result_Equi.getInt("SALARIO_TOTAL"), actual);

                    Statement statement_player = connection.createStatement();
                    ResultSet result_Play = statement_player.executeQuery("SELECT * FROM JUGADOR NATURAL JOIN JUGADOR_EQUIPO T WHERE T.ID_EQUIPO = "
                            + equipo.getId_equipo() + "AND T.FECHA_FIN IS NULL");
                    int indice = 0;

                    while (result_Play.next() && indice < 6) {
                        Jugador player = new Jugador(result_Play.getInt("ID_JUGADOR"), result_Play.getString("NOMBRE"),
                                result_Play.getString("NICKNAME"), result_Play.getInt("SUELDO"), equipo);
                        equipo.addPlayer(player, indice);
                        indice++;
                        if (!Main.getJugadores().contains(player)) jugadores.add(player);
                    }
                    if (!Main.getEquipos().contains(equipo)) equipos.add(equipo);
                }
                if (!Main.getDuenios().contains(actual)) duenios.add(actual);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Main.setDuenios(duenios);
        Main.setEquipos(equipos);
        Main.setJugadores(jugadores);
    }

    public static Equipo buscarEquipo(int idEquipo) {
        Equipo equipoBuscado = null;
        for (Equipo equipo : Main.getEquipos()) {
            if (equipo.getId_equipo() == idEquipo) {
                equipoBuscado = equipo;
                break;
            }
        }
        return equipoBuscado;
    }

    public static void Cargar_Calendario() {
        Connection connection = Gestor_BD.Conectar_BD();
        List<Calendario> calendarios = new ArrayList<>();
        List<Jornada> jornadas = new ArrayList<>();
        List<Partido> partidos = new ArrayList<>();
        try {

            Statement statement = connection.createStatement();
            ResultSet resultCalendario = statement.executeQuery("SELECT * FROM CALENDARIO");

            while (resultCalendario.next()) {

                Calendario calen = new Calendario(resultCalendario.getInt("ID_TEMPORADA"), LocalDate.parse(resultCalendario.getDate("FECHA_INICIO").toString()),
                        LocalDate.parse(resultCalendario.getDate("FECHA_FIN").toString()));

                System.out.println(calen);

                Statement statement_calen = connection.createStatement();
                ResultSet result_Calen = statement_calen.executeQuery("SELECT * FROM JORNADA  WHERE ID_TEMPORADA =  "
                        + calen.getId_temporada());

                while (result_Calen.next()) {
                    Jornada jornada = new Jornada(result_Calen.getInt("ID_JORNADA"), LocalDate.parse(result_Calen.getDate("FECHA").toString()),
                            calen);
                    //System.out.println(jornada);
                    Statement statement_jornada = connection.createStatement();
                    ResultSet result_Jorna = statement_jornada.executeQuery("SELECT * FROM Partido  WHERE JORNADA =  "
                            + jornada.getId_jornada());

                    while (result_Jorna.next()) {
                        Equipo equipo_local = buscarEquipo((result_Jorna.getInt("EQUIPO_LOCAL")));
                        Equipo equipo_visitante = buscarEquipo((result_Jorna.getInt("EQUIPO_VISITANTE")));

                        //System.out.println(equipo_local);
                        Partido partido = new Partido(result_Jorna.getInt("ID_PARTIDO"), result_Jorna.getInt("MARCADOR_LOCAL"),
                                result_Jorna.getInt("MARCADOR_VISITANTE"), equipo_local,
                                equipo_visitante, jornada);

                        if (!Main.getPartidos().contains(partido)) partidos.add(partido);
                    }
                    if (!Main.getJornadas().contains(jornada)) jornadas.add(jornada);
                }
                if (!Main.getCalendarios().contains(calen)) calendarios.add(calen);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Main.setCalendarios(calendarios);
        Main.setJornadas(jornadas);
        Main.setPartidos(partidos);
    }

    public static void Cargar_Jugadores_Libres(){
        List<Jugador> free_Players = new ArrayList<>();

        try {
            Connection connection = Gestor_BD.Conectar_BD();
            Statement st = connection.createStatement();

            ResultSet result_Play = st.executeQuery("SELECT * FROM JUGADORES_DISPONIBLES");

            while (result_Play.next()){
                Jugador player = new Jugador(result_Play.getInt("ID_JUGADOR"), result_Play.getString("NOMBRE"),
                        result_Play.getString("NICKNAME"), result_Play.getInt("SUELDO"));

                free_Players.add(player);
            }

            if (free_Players.size()>0) Main.setFree_players(free_Players);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}

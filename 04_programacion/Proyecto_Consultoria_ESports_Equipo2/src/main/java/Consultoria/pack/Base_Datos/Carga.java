package Consultoria.pack.Base_Datos;

import Consultoria.pack.Clases_Base.Duenio;
import Consultoria.pack.Clases_Base.Equipo;
import Consultoria.pack.Clases_Base.Jugador;
import Consultoria.pack.Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Carga {


    public static void Cargar_Equipos(){
        Connection connection = Gestor_BD.Conectar_BD();
        List<Jugador> jugadores = new ArrayList<>();
        List<Duenio> duenios = new ArrayList<>();
        List<Equipo> equipos = new ArrayList<>();
         try {

            Statement statement = connection.createStatement();
            ResultSet resultDuenios = statement.executeQuery("SELECT * FROM DUEÑO");

            while (resultDuenios.next()){

                Duenio actual = new Duenio(resultDuenios.getInt("ID_DUEÑO"),resultDuenios.getString("NOMBRE"),
                        resultDuenios.getString("USUARIO"),resultDuenios.getString("CONTRASEÑA"));

                Statement statement_equi = connection.createStatement();
                ResultSet result_Equi = statement_equi.executeQuery("SELECT * FROM EQUIPO WHERE ID_DUENIO = "
                        + actual.getId_usuario());

                while (result_Equi.next()){
                    Equipo equipo = new Equipo(result_Equi.getInt("ID_EQUIPO"),result_Equi.getString("NOMBRE"),
                            result_Equi.getInt("SALARIO_TOTAL"),actual);

                    Statement statement_player = connection.createStatement();
                    ResultSet result_Play = statement_player.executeQuery("SELECT * FROM JUGADOR NATURAL JOIN JUGADOR_EQUIPO T WHERE T.ID_EQUIPO = "
                            + equipo.getId_equipo());
                    int indice = 0;

                    while (result_Play.next() && indice<6){
                        Jugador player = new Jugador(result_Play.getInt("ID_JUGADOR"),result_Play.getString("NOMBRE"),
                                result_Play.getString("NICKNAME"),result_Play.getInt("SUELDO"),equipo);
                        equipo.addPlayer(player,indice);
                        indice++;
                        jugadores.add(player);

                    }
                    equipos.add(equipo);
                }
                duenios.add(actual);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
         Main.setDuenios(duenios);
         Main.setEquipos(equipos);
         Main.setJugadores(jugadores);

    }
}

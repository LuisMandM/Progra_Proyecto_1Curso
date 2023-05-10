import Clases_Base.Duenio;
import Clases_Base.Equipo;
import Clases_Base.Jugador;
import org.example.Base_Datos.Gestor_BD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static Connection connection ;

    private static  List<Equipo> equipos  = new ArrayList<>();



    public static void main(String[] args) {

        connection = Gestor_BD.Conectar_BD();
        List<Jugador> jugadores = new ArrayList<>();
        Cargar_Equipos();

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


    private static void Cargar_Equipos(){

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
                    }

                    equipos.add(equipo);


                }




            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


}
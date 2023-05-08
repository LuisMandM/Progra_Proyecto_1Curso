import org.example.Base_Datos.Gestor_BD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static Connection connection ;

    public static void main(String[] args) {

        connection = Gestor_BD.Conectar_BD();
        List<Jugador> jugadores = new ArrayList<>();

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


}
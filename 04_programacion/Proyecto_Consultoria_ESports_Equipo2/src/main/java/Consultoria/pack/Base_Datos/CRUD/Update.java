package Consultoria.pack.Base_Datos.CRUD;

import Consultoria.pack.Base_Datos.Admin_Pack;
import Consultoria.pack.Base_Datos.Gestor_BD;
import Consultoria.pack.Clases_Base.Jugador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
public class Update {

    public static void Add_PlayerTeam(Jugador player){

        try {
            Connection connection = Gestor_BD.Conectar_BD();

            String query ="INSERT INTO JUGADOR_EQUIPO(ID_JUGADOR,ID_EQUIPO,FECHA_INICIO) VALUES(?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);

            pst.setInt(1,player.getId_jugador());
            pst.setInt(2,player.getEquipo().getId_equipo());
            pst.setString(3, Admin_Pack.Convertir_fecha(LocalDate.now()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

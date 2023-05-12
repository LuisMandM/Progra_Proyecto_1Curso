package Consultoria.pack.Base_Datos;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Visualizacion_Pack {


    /**
     * Metodo con llamada a procedimiento "Clasificacion" de paquete "Visualizacion_Resultados" de la base de datos,
     * busca retornar un Resulset de una query en donde esta el ID, nombre y partidos ganados por un equipo.
     * @return HashMap con Key -> Id_Equipo ; Value -> Partidos ganados.
     * @autor Luis M.
     */
    public static Map Clasificacion() {
        Map<Integer, Integer> clasificacion = new HashMap<>();

        try {
            Connection connection = Gestor_BD.Conectar_BD();
            CallableStatement cs = connection.prepareCall("{call VISUALIZACION_RESULTADOS.clasificacion(?)}");
            cs.registerOutParameter(1, Types.REF_CURSOR);
            cs.execute();
            ResultSet set = (ResultSet) cs.getObject(1);
            while (set.next()) {
                System.out.println("Equipo: " + set.getString(1)
                        + " ID: " + set.getInt(2) + " Ganados " + set.getInt(3));
                clasificacion.put(set.getInt(2), set.getInt(3));
            }

            Gestor_BD.desconectar(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clasificacion;
    }

    public static void Historial_Equipo() {

        try {
            Connection connection = Gestor_BD.Conectar_BD();
            CallableStatement cs = connection.prepareCall("{call VISUALIZACION_RESULTADOS.HISTORIAL_EQUIPO(?,?,?,?) }");

            cs.setInt(1, 1);

            cs.registerOutParameter(2, Types.INTEGER);
            cs.registerOutParameter(3, Types.INTEGER);
            cs.registerOutParameter(4, Types.INTEGER);

            cs.execute();

            int equipo = cs.getInt(1);
            int ganados = cs.getInt("GANADOS");
            int perdidos = cs.getInt("PERDIDOS");
            int empatados = cs.getInt("EMPATE");

            System.out.println("EQUIPO: " + equipo + "Ganados" + ganados);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}

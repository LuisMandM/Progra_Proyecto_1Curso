package Consultoria.pack.Base_Datos;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Visualizacion_Pack {


    /**
     * Metodo con llamada a procedimiento "Clasificacion" de paquete "Visualizacion_Resultados" de la base de datos,
     * busca retornar un Resulset de una query en donde esta el ID, nombre y partidos ganados por un equipo.
     *
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


    /**
     * Metodo con llamada a procedimiento "Historial_Equipo" de paquete "Visualizacion_Resultados" de la base de datos,
     * busca retornar la cantidad de partidos ganados, perdidos y empatados en la historia del equipo.
     * @param id_equipo Numero de Identificador del equipo.
     * @return Array de tres posiciones con [0] = Partidas Ganados, [1] = Partidas Perdidos, [2] = Partidas empatadas.
     * @autor Luis M.
     */

    public static int[] Historial_Equipo(int id_equipo) {

        int[] resultados = new int[3];

        try {
            Connection connection = Gestor_BD.Conectar_BD();
            CallableStatement cs = connection.prepareCall("{call VISUALIZACION_RESULTADOS.HISTORIAL_EQUIPO(?,?,?,?) }");

            cs.setInt(1, id_equipo);

            cs.registerOutParameter(2, Types.INTEGER);
            cs.registerOutParameter(3, Types.INTEGER);
            cs.registerOutParameter(4, Types.INTEGER);

            cs.execute();

            resultados[0] = cs.getInt(2);
            resultados[1] = cs.getInt(3);
            resultados[2] = cs.getInt(4);

            Gestor_BD.desconectar(connection);
        } catch (SQLException e) {
            System.out.println(e.getCause().getMessage());

            if (e.getErrorCode() == -20382) System.out.println(e.getMessage());
        }

        return resultados;
    }

    /**
     * Metodo con llamada a procedimiento "Historial_Equipo" de paquete "Visualizacion_Resultados" de la base de datos,
     * busca retornar la cantidad de partidos ganados, perdidos y empatados en una temporada especifica.
     * @param id_temporada Numero de Identificador de la temporada que se desea filtrar.
     * @param id_equipo Numero de Identificador del equipo.
     * @return Array de tres posiciones con [0] = Partidas Ganados, [1] = Partidas Perdidos, [2] = Partidas empatadas.
     * @autor Luis M.
     */

    public static int[] Historial_Equipo_Temporada(int id_temporada, int id_equipo) {
        int[] resultados = new int[3];
        try {
            Connection connection = Gestor_BD.Conectar_BD();
            CallableStatement cs = connection.prepareCall("{call VISUALIZACION_RESULTADOS.HISTORIAL_EQUIPO(?,?,?,?,?) }");

            cs.setInt(1, id_equipo);
            cs.setInt(2, id_temporada);

            cs.registerOutParameter(3, Types.INTEGER);
            cs.registerOutParameter(4, Types.INTEGER);
            cs.registerOutParameter(5, Types.INTEGER);

            cs.execute();

            resultados[0] = cs.getInt(3);
            resultados[1] = cs.getInt(4);
            resultados[2] = cs.getInt(5);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultados;

    }


}

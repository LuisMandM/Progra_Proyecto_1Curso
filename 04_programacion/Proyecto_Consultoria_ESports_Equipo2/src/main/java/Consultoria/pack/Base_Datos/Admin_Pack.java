package Consultoria.pack.Base_Datos;

import Consultoria.pack.Clases_Base.Calendario;
import Consultoria.pack.Clases_Base.Equipo;
import Consultoria.pack.Clases_Base.Jornada;
import Consultoria.pack.Clases_Base.Partido;
import Consultoria.pack.Main;

import java.sql.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class Admin_Pack {

    public static void Generar_Temporada(LocalDate fecha_inicio) throws SQLException {
        Map<LocalDate, Partido[]> liga = Generacion_Calendario(fecha_inicio);
        Calendario temporada = Cargar_Calendario(Crear_Calendario(liga));
        Organizar_Temporada(temporada, liga);
    }

    public static void Registrar_Resultado(Partido partido_ref) {
        try {
            Connection connection = Gestor_BD.Conectar_BD();
            CallableStatement cs = connection.prepareCall("{call Acciones_Administrador.actualizar_resultado(?,?,?)}");

            cs.setInt(1, partido_ref.getId_partido());
            cs.setInt(2, partido_ref.getMarcador_local());
            cs.setInt(3, partido_ref.getMarcador_visitante());

            cs.execute();

            Gestor_BD.desconectar(connection);
        } catch (SQLException e) {
            System.out.println(e.getCause().getMessage());
        }
    }




    /**
     * Metodo creado para el emparejamiento aleatorio de los equipos participantes en la temporada
     * crea el numero de jornadas posibles según el numero de equipos, y dentro de cada ronda distribuye parejamente
     * para que se hagan los enfrentamientos. El numero de jornadas esta determinado por numero_equipos-1 y el
     * numero de partidos por ronda esta dado por numero_equipos/2. Esta función solo puede darse con una lista de equipos
     * con tamaño par.
     * @return Matriz de Partidos. Donde las filas son las Rondas y las columnas los emparejamientos.
     * @autor Luis M.
     */
    private static Partido[][] GenerarEnfrentamientos() {
        List<Equipo> equipos = Sort_Equipos();
        int num_equipos = equipos.size();

        int num_rondas = num_equipos - 1;
        int partidos = num_equipos / 2;

        Partido[][] rondas = new Partido[num_rondas][partidos];
        for (int i = 0, k = 0; i < num_rondas; i++) {
            for (int j = 0; j < partidos; j++) {
                rondas[i][j] = new Partido();
                rondas[i][j].setEquipoL(equipos.get(k));
                k++;
                if (k == num_rondas) k = 0;
            }
        }

        for (int i = 0; i < num_rondas; i++) {
            if (i % 2 == 0) rondas[i][0].setEquipoV(equipos.get(num_equipos - 1));
            else {
                rondas[i][0].setEquipoV(rondas[i][0].getEquipoL());
                rondas[i][0].setEquipoL(equipos.get(num_equipos - 1));
            }
        }

        int equipo_Mayor = num_equipos - 1;
        int equipo_NonMayor = equipo_Mayor - 1;

        for (int i = 0, k = equipo_NonMayor; i < num_rondas; i++) {
            for (int j = 1; j < partidos; j++) {
                rondas[i][j].setEquipoV(equipos.get(k));
                k--;
                if (k == -1) k = equipo_NonMayor;
            }
        }
        return rondas;
    }


    /**
     * Metodo encargado de realizar el envio a escritura de Jornadas y partidos creados, se hace la asociacion de las jornadas
     * con la Temporada(Calendario) respectivo.
     * @param calendario Objeto calendario recuperado de la base de datos.
     * @param temporada Map<LocalDate, Partido[]>.
     * @throws SQLException
     * @autor Luis M.
     */
    private static void Organizar_Temporada(Calendario calendario, Map<LocalDate, Partido[]> temporada) throws SQLException {
        List<Jornada> jornadas = new ArrayList<>();
        List<Partido> partidos = new ArrayList<>();

        for (Map.Entry<LocalDate, Partido[]> entry : temporada.entrySet()) {
            Jornada actual = new Jornada(entry.getKey(), calendario);
            actual = Cargar_Jornada(actual);
            if (actual.getId_jornada() != -1) {
                for (Partido partido : entry.getValue()) {
                    partido.setJornada(actual);
                    Cargar_Partido(partido);
                    //partidos.add(partido);
                }
                jornadas.add(actual);
            } else {
                System.out.println("Error con la escritura en BD de Jornada");
            }
        }
        Carga.Cargar_Calendario();

    }


    /**
     * Metodo encargado de la escritura en base de datos de las partidas creadas.
     * @param partido_init Objeto Partido unicamente con campos de Equipos participantes y su Jornada asociada.
     * @throws SQLException
     * @autor Luis M.
     */
    private static void Cargar_Partido(Partido partido_init) throws SQLException {
        Connection connection = Gestor_BD.Conectar_BD();
        PreparedStatement pst = connection.prepareStatement("INSERT INTO PARTIDO(EQUIPO_LOCAL,EQUIPO_VISITANTE,JORNADA)" +
                "VALUES(?,?,?)");
        pst.setInt(1, partido_init.getEquipoL().getId_equipo());
        pst.setInt(2, partido_init.getEquipoV().getId_equipo());
        pst.setInt(3, partido_init.getJornada().getId_jornada());

        int filas_modificadas = pst.executeUpdate();
        if (filas_modificadas > 0) {
            System.out.println("Ingreso exitoso de partido");
            Gestor_BD.commit(connection);
        } else System.out.println("ALGO HA IDO MAL ESCRIBIENDO PARTIDO");
        Gestor_BD.desconectar(connection);
    }


    /**
     * Metodo de Escritura y recuperacion automatica de un objeto jornada en la base de datos. Se hace una escritura y
     * lectura automatica para retornar el objeto con un id_Jornada dado por defecto en la base de datos.
     * @param jornada_init Objeto Jornada unicamente con fecha y con Calendario asociado
     * @return se retorna el mismo objeto pasado como parametro pero con un ID_Jornada corrrespondiente en la base de datos.
     * @throws SQLException
     * @autor  Luis M.
     */
    private static Jornada Cargar_Jornada(Jornada jornada_init) throws SQLException {
        Connection connection = Gestor_BD.Conectar_BD();
        String fecha = Convertir_fecha(jornada_init.getFecha());
        PreparedStatement pst = connection.prepareStatement("INSERT INTO JORNADA(FECHA,ID_TEMPORADA) VALUES(?,?)");
        pst.setString(1, fecha);
        pst.setInt(2, jornada_init.getCalendario().getId_temporada());

        int filas_modificadas = pst.executeUpdate();
        if (filas_modificadas > 0) {
            Gestor_BD.commit(connection);
            System.out.println("ingreso exitoso jornada");

            PreparedStatement query = connection.prepareStatement("SELECT * FROM JORNADA WHERE FECHA = ? " +
                    "AND ID_TEMPORADA = ?");
            query.setString(1, fecha);
            query.setInt(2, jornada_init.getCalendario().getId_temporada());

            ResultSet set = query.executeQuery();

            while (set.next()) {
                int id_jornada = set.getInt("ID_JORNADA");
                jornada_init.setId_jornada(id_jornada);
            }

        } else jornada_init.setId_jornada(-1);
        Gestor_BD.desconectar(connection);
        return jornada_init;
    }


    /**
     * Metodo de Escritura y recuperacion automatica de un objeto Calendario en la base de datos. Se hace una escritura y
     * lectura automatica para retornar el objeto con un id_temporada dado por defecto en la base de datos.
     * @param calen_init Objeto Calendario unicamente con las fechas de Inicio y Fin
     * @return Se retorna el mismo objeto dado como parametro pero con ID_TEMPORADA Correspondiente al de la base de datos.
     * @throws SQLException
     * @autor Luis M.
     */
    private static Calendario Cargar_Calendario(Calendario calen_init) throws SQLException {

        Connection connection = Gestor_BD.Conectar_BD();
        String fecha_init = Convertir_fecha(calen_init.getFecha_inicio());
        String fecha_fin = Convertir_fecha(calen_init.getFecha_fin());
        PreparedStatement pst = connection.prepareStatement("INSERT INTO CALENDARIO(FECHA_INICIO, FECHA_FIN) VALUES(?,?)");
        pst.setString(1, fecha_init);
        pst.setString(2, fecha_fin);
        int filas_modificadas = pst.executeUpdate();
        if (filas_modificadas > 0) {
            Gestor_BD.commit(connection);

            PreparedStatement query = connection.prepareStatement("SELECT * FROM CALENDARIO WHERE FECHA_INICIO = ?" +
                    " AND FECHA_FIN = ?");

            query.setString(1, fecha_init);
            query.setString(2, fecha_fin);

            ResultSet set = query.executeQuery();
            while (set.next()) {
                int id_calendario = set.getInt("ID_TEMPORADA");
                calen_init.setId_temporada(id_calendario);
            }
        } else calen_init.setId_temporada(-1);

        Gestor_BD.desconectar(connection);
        return calen_init;
    }

    public static String Convertir_fecha(LocalDate fecha) {

        if (fecha.getMonthValue() < 10)
            return fecha.getDayOfMonth() + "/0" + fecha.getMonthValue() + "/" + fecha.getYear();
        else return fecha.getDayOfMonth() + "/" + fecha.getMonthValue() + "/" + fecha.getYear();
    }

    /**
     * Metodo para la creacion de calendario, determina su fecha de inicio y fin basado en las fechas determinadas
     * previamente para las jornadas.
     * @param temporada Map<LocalDate, Partido[]> Donde se tienen las fechas de Jornada como Key y los encuentros de cada uno en un array.
     * @return Objeto Calendario sin ID_temporada ya que es una creacion en local.
     */
    private static Calendario Crear_Calendario(Map<LocalDate, Partido[]> temporada) {
        Calendario liga = null;
        if (temporada.size() > 0) {
            List<LocalDate> fechas = new ArrayList<>();
            temporada.forEach((fecha, partido) -> fechas.add(fecha));
            LocalDate fecha_init = fechas.get(0);
            LocalDate fecha_fin = fechas.get(fechas.size() - 1);
            liga = new Calendario(fecha_init, fecha_fin);
        }
        return liga;
    }


    /**
     * Metodo encargado de crear un Map en donde se alojan los partidos determinados por el sistema y las fechas de las
     * jornadas asociadas a estos.
     * @param fecha_inicio Se pasa un LocalDate con la fecha deseada de inicio de la temporada.
     * @return Map<LocalDate, Partido[]> Donde se tienen las fechas de Jornada como Key y los encuentros de cada uno en un array.
     * @autor Luis M.
     */
    public static Map<LocalDate, Partido[]> Generacion_Calendario (LocalDate fecha_inicio) {
        //Carga y sort de partidas y jornadas
        //Carga.Cargar_Equipos();
        Partido[][] partidos = GenerarEnfrentamientos();
        int anio_init = fecha_inicio.getYear();
        int mes_init = fecha_inicio.getMonthValue();
        int dia_init = fecha_inicio.getDayOfMonth();
        LocalDate[] fechas = Fechas_Jornadas(anio_init, mes_init, dia_init);

        Map<LocalDate, Partido[]> jornadas = new TreeMap<>();
        for (int i = 0; i < fechas.length; i++) {
            jornadas.put(fechas[i], partidos[i]);
        }
        return jornadas;
    }

    private static LocalDate[] Fechas_Jornadas(int anio_init, int mes_init, int dia_init) {
        int rondas = Main.getEquipos().size() - 1;
        LocalDate fecha_init = LocalDate.of(anio_init, mes_init, dia_init);
        LocalDate fecha_fin = fecha_init.plusWeeks(rondas);


        LocalDate[] fechas = new LocalDate[rondas];
        fechas[0] = fecha_init;
        LocalDate fecha;
        Random random = new Random();
        for (int i = 1; i < rondas; i++) {
            fecha = fecha_init.plusWeeks(i);
            int index = random.nextInt(0, 10);
            if (index > 5 && fecha.isBefore(fecha_fin)) {
                int dia = fecha.getDayOfMonth();
                dia = dia + dias_Correr(fecha.getDayOfWeek());
                if (dia < 31) {
                    fecha = LocalDate.of(fecha.getYear(), fecha.getMonthValue(), dia);
                }
            }
            fechas[i] = fecha;
        }
        return fechas;
    }

    private static int dias_Correr(DayOfWeek dia) {
        Random random = new Random();
        return switch (dia) {
            case MONDAY -> random.nextInt(1, 6);
            case TUESDAY -> random.nextInt(1, 5);
            case WEDNESDAY -> random.nextInt(1, 4);
            case THURSDAY -> random.nextInt(1, 3);
            case FRIDAY -> random.nextInt(1, 2);
            default -> 0;
        };
    }

    private static List<Equipo> Sort_Equipos() {
        List<Equipo> sorted = new ArrayList<>();

        List<Equipo> copy = new ArrayList<>();
        for (Equipo equipo : Main.getEquipos()) {
            copy.add(equipo);
        }
        Random random = new Random();
        while (copy.size() > 0) {
            if (copy.size() == 1) {
                sorted.add(copy.get(0));
                copy.remove(0);
            } else {
                int posicion = random.nextInt(0, copy.size());
                sorted.add(copy.get(posicion));
                copy.remove(posicion);

            }
        }
        return sorted;
    }


}

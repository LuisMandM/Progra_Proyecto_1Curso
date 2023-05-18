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


    static public void main(String[] args) {
        Carga.Cargar_Equipos();
        Map<LocalDate, Partido[]> liga = Generacion_Calendario(LocalDate.of(2023, 5, 18));
        System.out.println("Finalizado");
    }


    private static void Organizar_Temporada(Calendario calendario,Map<LocalDate,Partido[]> temporada){
        List<Jornada> jornadas = new ArrayList<>();
        List<Partido> partidos = new ArrayList<>();

        for (Map.Entry<LocalDate, Partido[]> entry:temporada.entrySet()) {
            Jornada actual = new Jornada(entry.getKey(),calendario);
            for (Partido partido: entry.getValue()) {
                partido.setJornada(actual);
                partidos.add(partido);
            }
            jornadas.add(actual);
        }
    }


    private static Calendario Cargar_Calendario(Calendario calen_init) throws SQLException {

        Connection connection = Gestor_BD.Conectar_BD();
        String fecha_init = calen_init.getFecha_inicio().getYear() + "/" + calen_init.getFecha_inicio().getMonthValue() + "/"
                + calen_init.getFecha_inicio().getDayOfMonth();
        String fecha_fin = calen_init.getFecha_inicio().getYear() + "/" + calen_init.getFecha_inicio().getMonthValue() + "/"
                + calen_init.getFecha_inicio().getDayOfMonth();
        PreparedStatement pst = connection.prepareStatement("INSERT INTO CALENDARIO(FECHA_INICIO, FECHA_FIN) VALUES(?,?)");
        pst.setString(1, fecha_init);
        pst.setString(2, fecha_fin);
        int filas_modificadas = pst.executeUpdate();
        if (filas_modificadas > 0) {
            Gestor_BD.commit(connection);

            PreparedStatement query = connection.prepareStatement("SELECT * FROM CALENDARIO WHERE FECHA_INICIO = ?" +
                    " AND FECHA_FIN = ?");

            query.setString(1,fecha_init);
            query.setString(2,fecha_fin);

            ResultSet set = query.executeQuery();
            int id_calendario = set.getInt("ID_TEMPORADA");
            calen_init.setId_temporada(id_calendario);
        } else calen_init.setId_temporada(-1);

        return calen_init;
    }

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

    public static Map<LocalDate, Partido[]> Generacion_Calendario(LocalDate fecha_inicio) {
        //Carga y sort de partidas y jornadas
        Carga.Cargar_Equipos();
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

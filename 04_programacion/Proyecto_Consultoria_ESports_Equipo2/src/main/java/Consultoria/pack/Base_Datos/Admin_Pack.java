package Consultoria.pack.Base_Datos;

import Consultoria.pack.Clases_Base.Equipo;
import Consultoria.pack.Clases_Base.Partido;
import Consultoria.pack.Main;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class Admin_Pack {


    public static Partido[][] GenerarEnfrentamientos() {
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
        //Carga y sort de partidas y jornadas
        Carga.Cargar_Equipos();
        Partido[][] partidos = GenerarEnfrentamientos();

        int anio_init = 2023;
        int mes_init = 5;
        int dia_init = 16;
        LocalDate[] fechas = Fechas_Jornadas(anio_init, mes_init, dia_init);

        Map<LocalDate,Partido[]> Jornadas = new HashMap<>();

        for (int i = 0; i < fechas.length; i++) {
            Jornadas.put(fechas[i],partidos[i]);
        }


        System.out.println("\n fechas array");
        for (int j = 0; j <fechas.length ; j++) {
            System.out.println("fecha "+j+": "+fechas[j]);
        }

       /* System.out.println("ENFRENTRAMIENTOS");
        for (Equipo equipo:Main.getEquipos()) {
            int index_2 = 1;
            System.out.println(equipo.getNombre());
            for (Partido[] ronda: partidos) {
                System.out.println("RONDA Aleatoria "+ index_2 +": ");
                for (Partido partido: ronda) {
                    if (partido.getEquipoL() == equipo || partido.getEquipoV() == equipo)System.out.println(partido);
                }
                index_2++;
            }
            System.out.println("\n\n");
        }*/



        /*List<Equipo> equipos_sorted = Sort_Equipos();
        int largo = Main.getEquipos().size();
        System.out.println("Tamaño sorted : " + equipos_sorted.size());
        System.out.println("Tamaño real : " + largo);
        for (Equipo equipo : equipos_sorted) {
            System.out.println(equipo.getNombre());
        }*/

    }

    private static LocalDate[] Fechas_Jornadas(int anio_init, int mes_init, int dia_init) {
        int rondas = Main.getEquipos().size();
        LocalDate fecha_init = LocalDate.of(anio_init, mes_init, dia_init);
        LocalDate fecha_fin = fecha_init.plusWeeks(rondas);


        LocalDate[] fechas = new LocalDate[rondas];
        fechas[0]= fecha_init;
        LocalDate fecha;
        Random random = new Random();
        System.out.println("Fecha inicial: " + fecha_init);
        for (int i = 1; i < rondas; i++) {
            fecha = fecha_init.plusWeeks(i);
            //System.out.println("Fecha " + i + ": " + fecha);
            int index = random.nextInt(0, 10);
            if (index > 5 && fecha.isBefore(fecha_fin)) {
                int dia = fecha.getDayOfMonth();
                dia = dia + dias_Correr(fecha.getDayOfWeek());
                if (dia < 31) {
                    fecha = LocalDate.of(fecha.getYear(), fecha.getMonthValue(), dia);
                    //System.out.println("Fecha Modificada: " + fecha + "\n");
                }
            }
            fechas[i]=fecha;
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

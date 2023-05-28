package Consultoria.pack.GUI.visualizacion;

import Consultoria.pack.Clases_Base.Equipo;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TablaClasificacionModel extends AbstractTableModel {

    private String[] columnasClasificacion = {"Equipo", "ID", "Partidos ganados", "Partidos perdidos", "Empates"};

    private Equipo equipo;
    private List<Equipo> equipos;
    private int num_ganados;
    private int num_perdidos;
    private int empates;

    public TablaClasificacionModel() {
    }

    public TablaClasificacionModel(List<Equipo> partidos) {
        this.equipos = partidos;
    }

    @Override
    public int getRowCount() {
        return equipos.size();
    }

    @Override
    public int getColumnCount() {
        return columnasClasificacion.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        equipo = equipos.get(rowIndex);
        int[] estadisticas = equipo.Estadisticas_globales();

        switch (columnIndex) {
            case 0:
                return equipo.getNombre();
            case 1:
                return equipo.getId_equipo();
            case 2:
                return estadisticas[0];
            case 3:
                return estadisticas[1];
            case 4:
                return estadisticas[2];
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnasClasificacion[column];
    }
}

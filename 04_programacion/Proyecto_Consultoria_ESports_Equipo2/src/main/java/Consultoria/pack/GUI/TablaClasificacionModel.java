package Consultoria.pack.GUI;

import Consultoria.pack.Clases_Base.Equipo;
import Consultoria.pack.Clases_Base.Partido;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TablaClasificacionModel extends AbstractTableModel {

    private String[] columnasClasificacion = {"Equipo", "ID", "Partidos ganados"};

    private Equipo equipo;
    private List<Partido> partidos;
    private int num_ganados;

    public TablaClasificacionModel() {
    }

    public TablaClasificacionModel(List<Partido> partidos) {
        this.partidos = partidos;
    }

    @Override
    public int getRowCount() {
        return partidos.size();
    }

    @Override
    public int getColumnCount() {
        return columnasClasificacion.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return equipo.getNombre();
            case 1:
                return equipo.getId_equipo();
            case 2:
                for (Partido partido: partidos) {
                    if (partido.getEquipoGanador().equals(equipo.getId_equipo())) {
                        num_ganados++;
                    }
                    return num_ganados;
                }
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnasClasificacion[column];
    }
}

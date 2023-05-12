package Consultoria.pack.GUI;

import Consultoria.pack.Clases_Base.Equipo;
import Consultoria.pack.Clases_Base.Partido;

import javax.swing.table.AbstractTableModel;

public class TablaClasificacionModel extends AbstractTableModel {

    private String[] columnas = {"Equipo", "ID", "Partidos ganados"};

    private Equipo equipo;

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return equipo.getNombre();
            case 1:
                return equipo.getId_equipo();
            case 2:
                for (Partido partido:
                     ) {

                }
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
}

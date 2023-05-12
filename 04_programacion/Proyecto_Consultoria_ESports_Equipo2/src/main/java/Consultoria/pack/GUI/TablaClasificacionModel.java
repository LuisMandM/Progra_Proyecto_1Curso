package Consultoria.pack.GUI;

import Consultoria.pack.Base_Datos.Visualizacion_Pack;
import Consultoria.pack.Clases_Base.Equipo;
import Consultoria.pack.Clases_Base.Partido;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TablaClasificacionModel extends AbstractTableModel {

    private String[] columnasClasificacion = {"Equipo", "ID", "Partidos ganados", "Partidos perdidos", "Empates"};

    private Equipo equipo;
    private List<Partido> partidos;
    private int num_ganados;
    private int num_perdidos;
    private int empates;

    public TablaClasificacionModel() {
    }

    public TablaClasificacionModel(List<Partido> partidos) {
        this.partidos = partidos;
    }

    @Override
    public int getRowCount() {
        return Visualizacion_Pack.Clasificacion().size();
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
            case 3:
                for (Partido partido: partidos) {
                    if (!partido.getEquipoGanador().equals(equipo.getId_equipo())) {
                        num_perdidos--;
                    }
                    return num_perdidos;
                }
            case 4:
                for (Partido partido: partidos) {
                    if (partido.getMarcador_local() == partido.getMarcador_visitante()) {
                        empates++;
                    }
                    return empates;
                }
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnasClasificacion[column];
    }
}

package Consultoria.pack.GUI;

import Consultoria.pack.Clases_Base.Equipo;
import Consultoria.pack.Clases_Base.Jornada;
import Consultoria.pack.Clases_Base.Partido;
import Consultoria.pack.Main;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TablaJornadaModel extends AbstractTableModel {

    private String[] columnasJornada = {"ID", "Fecha", "Equipo local", "Marcador local", "Marcador visitante", "Equipo visitante"};

    private Jornada jornada;
    private List<Jornada> jornadas;
    private Equipo equipo;
    private Partido partido;

    public TablaJornadaModel(List<Jornada> jornadas) {
        this.jornadas = jornadas;
    }

    @Override
    public int getRowCount() {
        return jornadas.size();
    }

    @Override
    public int getColumnCount() {
        return columnasJornada.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        jornada = jornadas.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return partido.getJornada().getId_jornada();
            case 1:
                return partido.getJornada().getFecha();
            case 2:
                return partido.getEquipoL();
            case 3:
                return partido.getMarcador_local();
            case 4:
                return partido.getMarcador_visitante();
            case 5:
                return partido.getEquipoV();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnasJornada[column];
    }
}

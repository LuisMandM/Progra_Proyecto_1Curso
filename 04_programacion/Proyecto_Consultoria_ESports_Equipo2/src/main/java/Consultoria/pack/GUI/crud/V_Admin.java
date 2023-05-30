package Consultoria.pack.GUI.crud;

import Consultoria.pack.Base_Datos.Carga;
import Consultoria.pack.GUI.crud.crud_duenio.Crud_Duenio;
import Consultoria.pack.GUI.crud.crud_equipos.Crud_Equipos;
import Consultoria.pack.GUI.crud.crud_jugador.Crud_Jugador;
import Consultoria.pack.GUI.crud.crud_usuario.Crud_Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase `V_Admin` representa la interfaz gráfica de usuario para la administración de datos.
 */
public class V_Admin {

    private JPanel V_Admin;
    private JButton botonEquipo;
    private JButton botonDuenio;
    private JButton botonUsuario;
    private JButton botonJugador;

    /**
     * Crea una nueva instancia de `V_Admin`.
     */
    public V_Admin() {
        botonDuenio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Crud_Duenio");
                frame.setContentPane(new Crud_Duenio().getPanelCrudDuenio());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        botonEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Crud_Equipos");
                frame.setContentPane(new Crud_Equipos().getPanelCrudEquipos());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        botonJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Crud_Jugador");
                frame.setContentPane(new Crud_Jugador().getPanelCrudJugador());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        botonUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Crud_Usuario");
                frame.setContentPane(new Crud_Usuario().getPanelCrudUsuario());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    /**
     * Punto de entrada principal para ejecutar la aplicación.
     *
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        Carga.Cargar_Equipos();
        Carga.Cargar_Clientes();
        JFrame frame = new JFrame("V_Admin");
        frame.setContentPane(new V_Admin().V_Admin);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Obtiene el panel de la interfaz gráfica de usuario para la administración de datos.
     *
     * @return El panel de la interfaz gráfica de usuario.
     */
    public JPanel getV_Admin() {
        return V_Admin;
    }
}

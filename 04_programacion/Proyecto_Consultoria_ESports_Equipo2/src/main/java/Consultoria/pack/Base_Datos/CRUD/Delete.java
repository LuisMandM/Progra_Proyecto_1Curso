package Consultoria.pack.Base_Datos.CRUD;

import Consultoria.pack.Base_Datos.Admin_Pack;
import Consultoria.pack.Base_Datos.Gestor_BD;
import Consultoria.pack.Clases_Base.Administrador;
import Consultoria.pack.Clases_Base.Duenio;
import Consultoria.pack.Clases_Base.Usuario;
import Consultoria.pack.GUI.Login.V_Login;
import Consultoria.pack.Clases_Base.*;


import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * Clase destinada a alojar los metodo relacionados a la eliminacion de objetos del programa.
 */
public class Delete {

    public static void Delete_Usuario(Usuario usuario_Current) {

        try {
            Connection connection = Gestor_BD.Conectar_BD();
            String query = "DELETE FROM CLIENTE WHERE ID_USUARIO = ?";
            PreparedStatement pst = connection.prepareStatement(query);

            pst.setInt(1, usuario_Current.getId_usuario());

            int filas_delete = pst.executeUpdate();
            if (filas_delete > 0) {
                Gestor_BD.commit(connection);
                JOptionPane.showMessageDialog(null, "Usuario borrado correctamente",
                        "Borrado Exitoso", JOptionPane.INFORMATION_MESSAGE);
            } else JOptionPane.showMessageDialog(null, "EL usuario no ha podido ser Borrado en " +
                    "la Base de datos.\nIntente nuevamente", "Error Borrado", JOptionPane.ERROR_MESSAGE);
            Gestor_BD.desconectar(connection);


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getCause().getMessage(),
                    "Error BD", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void Delete_Admin(Administrador admin_Current) {

        try {
            Connection connection = Gestor_BD.Conectar_BD();
            String query = "DELETE FROM ADMINISTRADOR WHERE ID_ADMIN = ?";
            PreparedStatement pst = connection.prepareStatement(query);

            pst.setInt(1, admin_Current.getId_usuario());

            int filas_delete = pst.executeUpdate();
            if (filas_delete > 0) {
                Gestor_BD.commit(connection);
                JOptionPane.showMessageDialog(null, "Usuario borrado correctamente",
                        "Borrado Exitoso", JOptionPane.INFORMATION_MESSAGE);
            } else JOptionPane.showMessageDialog(null, "EL usuario no ha podido ser Borrado en " +
                    "la Base de datos.\nIntente nuevamente", "Error Borrado", JOptionPane.ERROR_MESSAGE);
            Gestor_BD.desconectar(connection);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getCause().getMessage(),
                    "Error BD", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void Delete_Duenio(Duenio duenio_Current) {
        try {
            Connection connection = Gestor_BD.Conectar_BD();
            String query = "DELETE FROM VISTA_DUEÑO WHERE ID_DUEÑO = ?";
            PreparedStatement pst = connection.prepareStatement(query);

            pst.setInt(1, duenio_Current.getId_usuario());

            int filas_delete = pst.executeUpdate();
            if (filas_delete > 0) {
                Gestor_BD.commit(connection);
                JOptionPane.showMessageDialog(null, "Usuario borrado correctamente",
                        "Borrado Exitoso", JOptionPane.INFORMATION_MESSAGE);
            } else JOptionPane.showMessageDialog(null, "EL usuario no ha podido ser Borrado en " +
                    "la Base de datos.\nIntente nuevamente", "Error Borrado", JOptionPane.ERROR_MESSAGE);
            Gestor_BD.desconectar(connection);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getCause().getMessage(),
                    "Error BD", JOptionPane.ERROR_MESSAGE);
        }


    }

    public static void Delete_Jugador(Jugador player_Current) {

        try {
            Connection connection = Gestor_BD.Conectar_BD();
            String first_query = "DELETE FROM JUGADOR_EQUIPO WHERE ID_JUGADOR = ?";
            PreparedStatement pst_1 = connection.prepareStatement(first_query);

            pst_1.setInt(1, player_Current.getId_jugador());

            int filas_TeamPlayer_Del = pst_1.executeUpdate();
            if (filas_TeamPlayer_Del >= 0) {
                String second_query = "DELETE FROM JUGADOR WHERE ID_JUGADOR = ?";
                PreparedStatement pst_2 = connection.prepareStatement(second_query);

                pst_2.setInt(1, player_Current.getId_jugador());

                int filas_Player_Del = pst_2.executeUpdate();
                if (filas_Player_Del > 0) {
                    Gestor_BD.commit(connection);
                    JOptionPane.showMessageDialog(null, "Jugador borrado correctamente",
                            "Borrado Exitoso", JOptionPane.INFORMATION_MESSAGE);
                } else JOptionPane.showMessageDialog(null, "EL Jugador no ha podido ser Borrado en " +
                        "la Base de datos.\nIntente nuevamente", "Error Borrado", JOptionPane.ERROR_MESSAGE);
                Gestor_BD.desconectar(connection);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getCause().getMessage(),
                    "Error BD", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void Delete_Equipo(Equipo equipo_Current) {

        try {
            Connection connection = Gestor_BD.Conectar_BD();
            String query = "DELETE FROM VISTA_EQUIPO WHERE ID_EQUIPO = ?";
            PreparedStatement pst = connection.prepareStatement(query);

            pst.setInt(1, equipo_Current.getId_equipo());
            int filas_delete = pst.executeUpdate();
            if (filas_delete > 0) {
                Gestor_BD.commit(connection);
                JOptionPane.showMessageDialog(null, "Equipo borrado correctamente",
                        "Borrado Exitoso", JOptionPane.INFORMATION_MESSAGE);
            } else JOptionPane.showMessageDialog(null, "EL Equipo no ha podido ser Borrado en " +
                    "la Base de datos.\nIntente nuevamente", "Error Borrado", JOptionPane.ERROR_MESSAGE);

            Gestor_BD.desconectar(connection);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getCause().getMessage(),
                    "Error BD", JOptionPane.ERROR_MESSAGE);
        }


    }
}

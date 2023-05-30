package Consultoria.pack.Base_Datos.CRUD;

import Consultoria.pack.Base_Datos.Admin_Pack;
import Consultoria.pack.Base_Datos.Gestor_BD;
import Consultoria.pack.Clases_Base.Duenio;
import Consultoria.pack.Clases_Base.Equipo;
import Consultoria.pack.Clases_Base.Jugador;
import Consultoria.pack.Clases_Base.Usuario;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Update {

    public static void Add_PlayerTeam(Jugador player) {

        try {
            Connection connection = Gestor_BD.Conectar_BD();

            String query = "INSERT INTO JUGADOR_EQUIPO(ID_JUGADOR,ID_EQUIPO,FECHA_INICIO) VALUES(?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);

            pst.setInt(1, player.getId_jugador());
            pst.setInt(2, player.getEquipo().getId_equipo());
            pst.setString(3, Admin_Pack.Convertir_fecha(LocalDate.now()));

            int filas_add = pst.executeUpdate();
            if (filas_add > 0) {
                String get_Salario = "SELECT SALARIO_TOTAL FROM EQUIPO WHERE ID_EQUIPO = ?";
                PreparedStatement pst_salario = connection.prepareStatement(get_Salario);

                pst_salario.setInt(1, player.getEquipo().getId_equipo());

                ResultSet salario_Set = pst_salario.executeQuery();
                double salario_total = 0;
                while (salario_Set.next()) {
                    salario_total = salario_Set.getDouble("SALARIO_TOTAL");
                }

                String update_Salario = "UPDATE EQUIPO SET SALARIO_TOTAL = ? WHERE ID_EQUIPO = ?";
                PreparedStatement pst_Update = connection.prepareStatement(update_Salario);

                pst_Update.setDouble(1, salario_total + player.getSueldo());
                pst_Update.setInt(2, player.getEquipo().getId_equipo());

                int filas_updated = pst_Update.executeUpdate();
                if (filas_updated > 0) {
                    Gestor_BD.commit(connection);
                    JOptionPane.showMessageDialog(null, "Jugador añadido correctamente",
                            "Jugador Registrado", JOptionPane.INFORMATION_MESSAGE);
                } else JOptionPane.showMessageDialog(null, "Actualizacion incorrecta,\n" +
                        "Intente nuevamente", "Error", JOptionPane.INFORMATION_MESSAGE);
            } else JOptionPane.showMessageDialog(null, "Jugador no añadido",
                    "Error", JOptionPane.INFORMATION_MESSAGE);

            Gestor_BD.desconectar(connection);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getCause().getMessage(),
                    "Error BD", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void Remove_Player(Jugador player) {
        try {
            Connection connection = Gestor_BD.Conectar_BD();
            String query = "UPDATE JUGADOR_EQUIPO SET FECHA_FIN = ? WHERE ID_JUGADOR = ? AND ID_EQUIPO = ?";
            PreparedStatement pst = connection.prepareStatement(query);

            pst.setString(1, Admin_Pack.Convertir_fecha(LocalDate.now()));
            pst.setInt(2, player.getId_jugador());
            pst.setInt(3, player.getEquipo().getId_equipo());

            int filas_add = pst.executeUpdate();
            if (filas_add > 0) {

                String get_Salario = "SELECT SALARIO_TOTAL FROM EQUIPO WHERE ID_EQUIPO = ?";
                PreparedStatement pst_salario = connection.prepareStatement(get_Salario);

                pst_salario.setInt(1, player.getEquipo().getId_equipo());

                ResultSet salario_Set = pst_salario.executeQuery();
                double salario_total = 0;
                while (salario_Set.next()) {
                    salario_total = salario_Set.getDouble("SALARIO_TOTAL");
                }

                String update_Salario = "UPDATE EQUIPO SET SALARIO_TOTAL = ? WHERE ID_EQUIPO = ?";
                PreparedStatement pst_Update = connection.prepareStatement(update_Salario);

                pst_Update.setDouble(1, salario_total - player.getSueldo());
                pst_Update.setInt(2, player.getEquipo().getId_equipo());

                int filas_updated = pst_Update.executeUpdate();
                if (filas_updated > 0) {
                    Gestor_BD.commit(connection);
                    JOptionPane.showMessageDialog(null, "Jugador retirado correctamente",
                            "Retiro Jugador", JOptionPane.INFORMATION_MESSAGE);
                } else JOptionPane.showMessageDialog(null, "Jugador no retirado del equipo",
                        "Error", JOptionPane.INFORMATION_MESSAGE);

            } else JOptionPane.showMessageDialog(null, "Jugador no retirado del equipo",
                    "Error", JOptionPane.INFORMATION_MESSAGE);

            Gestor_BD.desconectar(connection);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getCause().getMessage(),
                    "Error BD", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void Update_Duenio(Duenio current_Duenio) {
        try {
            Connection connection = Gestor_BD.Conectar_BD();
            String query = "UPDATE DUEÑO SET NOMBRE = ?,USUARIO = ?, CONTRASEÑA = ? WHERE ID_DUEÑO = ?";
            PreparedStatement pst = connection.prepareStatement(query);

            pst.setString(1, current_Duenio.getNombre());
            pst.setString(2, current_Duenio.getUsuario());
            pst.setString(3, current_Duenio.getContrasenya());
            pst.setInt(4, current_Duenio.getId_usuario());


            int filas_updated = pst.executeUpdate();
            if (filas_updated > 0) {
                Gestor_BD.commit(connection);
                JOptionPane.showMessageDialog(null, "Dueño actualizado correctamente",
                        "Actualizacion Dueño", JOptionPane.INFORMATION_MESSAGE);
            } else JOptionPane.showMessageDialog(null, "Actualizacion incorrecta,\n" +
                    "Intente nuevamente", "Error", JOptionPane.INFORMATION_MESSAGE);

            Gestor_BD.desconectar(connection);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getCause().getMessage(),
                    "Error BD", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void Update_Jugador(Jugador current_Player) {
        try {
            Connection connection = Gestor_BD.Conectar_BD();
            String query = "UPDATE JUGADOR SET NOMBRE = ?, NICKNAME = ?, SUELDO = ? WHERE ID_JUGADOR = ?";
            PreparedStatement pst = connection.prepareStatement(query);

            pst.setString(1, current_Player.getNombre());
            pst.setString(2, current_Player.getNickname());
            pst.setDouble(3, current_Player.getSueldo());
            pst.setInt(4, current_Player.getId_jugador());

            int filas_updated = pst.executeUpdate();
            if (filas_updated > 0) {
                Gestor_BD.commit(connection);
                JOptionPane.showMessageDialog(null, "Jugador actualizado correctamente",
                        "Actualizacion Jugador", JOptionPane.INFORMATION_MESSAGE);
            } else JOptionPane.showMessageDialog(null, "Actualizacion incorrecta,\n" +
                    "Intente nuevamente", "Error", JOptionPane.INFORMATION_MESSAGE);
            Gestor_BD.desconectar(connection);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getCause().getMessage(),
                    "Error BD", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void Update_User(Usuario user_Current) {
        try {
            Connection connection = Gestor_BD.Conectar_BD();
            String query = "UPDATE CLIENTE SET USUARIO = ?, CONTRASEÑA = ? WHERE ID_USUARIO = ?";
            PreparedStatement pst = connection.prepareStatement(query);

            pst.setString(1, user_Current.getUsuario());
            pst.setString(2, user_Current.getContrasenya());
            pst.setInt(3, user_Current.getId_usuario());

            int filas_updated = pst.executeUpdate();
            if (filas_updated > 0) {
                Gestor_BD.commit(connection);
                JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente",
                        "Actualizacion Cliente", JOptionPane.INFORMATION_MESSAGE);
            } else JOptionPane.showMessageDialog(null, "Actualizacion incorrecta,\n" +
                    "Intente nuevamente", "Error", JOptionPane.INFORMATION_MESSAGE);

            Gestor_BD.desconectar(connection);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getCause().getMessage(),
                    "Error BD", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void Update_Equipo(Equipo equipo) {
        try {
            Connection connection = Gestor_BD.Conectar_BD();
            String query = "UPDATE EQUIPO SET NOMBRE = ?, ID_DUENIO = ? WHERE ID_EQUIPO = ?";
            PreparedStatement pst = connection.prepareStatement(query);

            pst.setString(1, equipo.getNombre());
            pst.setInt(2, equipo.getDuenyo().getId_usuario());
            pst.setInt(3, equipo.getId_equipo());

            int filas_updated = pst.executeUpdate();
            if (filas_updated > 0) {
                Gestor_BD.commit(connection);
                JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente",
                        "Actualizacion Cliente", JOptionPane.INFORMATION_MESSAGE);
            } else JOptionPane.showMessageDialog(null, "Actualizacion incorrecta,\n" +
                    "Intente nuevamente", "Error", JOptionPane.INFORMATION_MESSAGE);

            Gestor_BD.desconectar(connection);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getCause().getMessage(),
                    "Error BD", JOptionPane.ERROR_MESSAGE);
        }


    }
}

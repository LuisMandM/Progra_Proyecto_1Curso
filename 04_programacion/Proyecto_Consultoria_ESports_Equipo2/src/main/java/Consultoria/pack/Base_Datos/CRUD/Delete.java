package Consultoria.pack.Base_Datos.CRUD;

import Consultoria.pack.Base_Datos.Gestor_BD;
import Consultoria.pack.Clases_Base.Administrador;
import Consultoria.pack.Clases_Base.Duenio;
import Consultoria.pack.Clases_Base.Usuario;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {

    public static void Delete_Usuario(Usuario usuario_Current) {

        try {
            Connection connection = Gestor_BD.Conectar_BD();
            String query = "DELETE FROM CLIENTE WHERE ID_USUARIO = ?";
            PreparedStatement pst = connection.prepareStatement(query);

            pst.setInt(1, usuario_Current.getId_usuario());

            int filas_delete = pst.executeUpdate();
            if (filas_delete>0){
                Gestor_BD.commit(connection);
                JOptionPane.showMessageDialog(null, "Usuario borrado correctamente",
                        "Borrado Exitoso", JOptionPane.INFORMATION_MESSAGE);
            }else JOptionPane.showMessageDialog(null, "EL usuario no ha podido ser Borrado en " +
                    "la Base de datos.\nIntente nuevamente", "Error Borrado", JOptionPane.ERROR_MESSAGE);
            Gestor_BD.desconectar(connection);


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getCause().getMessage(),
                    "Error BD", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void Delete_Admin(Administrador admin_Current){

        try {
            Connection connection = Gestor_BD.Conectar_BD();
            String query = "DELETE FROM ADMINISTRADOR WHERE ID_ADMIN = ?";
            PreparedStatement pst = connection.prepareStatement(query);

            pst.setInt(1,admin_Current.getId_usuario());

            int filas_delete = pst.executeUpdate();
            if (filas_delete>0){
                Gestor_BD.commit(connection);
                JOptionPane.showMessageDialog(null, "Usuario borrado correctamente",
                        "Borrado Exitoso", JOptionPane.INFORMATION_MESSAGE);
            }else JOptionPane.showMessageDialog(null, "EL usuario no ha podido ser Borrado en " +
                    "la Base de datos.\nIntente nuevamente", "Error Borrado", JOptionPane.ERROR_MESSAGE);
            Gestor_BD.desconectar(connection);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getCause().getMessage(),
                    "Error BD", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void Delete_Duenio(Duenio duenio_Current){
        try {
            Connection connection = Gestor_BD.Conectar_BD();
            String query = "DELETE FROM VISTA_DUEÑO WHERE ID_DUEÑO = ?";
            PreparedStatement pst = connection.prepareStatement(query);

            pst.setInt(1,duenio_Current.getId_usuario());

            int filas_delete = pst.executeUpdate();
            if (filas_delete>0){
                Gestor_BD.commit(connection);
                JOptionPane.showMessageDialog(null, "Usuario borrado correctamente",
                        "Borrado Exitoso", JOptionPane.INFORMATION_MESSAGE);
            }else JOptionPane.showMessageDialog(null, "EL usuario no ha podido ser Borrado en " +
                    "la Base de datos.\nIntente nuevamente", "Error Borrado", JOptionPane.ERROR_MESSAGE);
            Gestor_BD.desconectar(connection);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getCause().getMessage(),
                    "Error BD", JOptionPane.ERROR_MESSAGE);
        }


    }

}

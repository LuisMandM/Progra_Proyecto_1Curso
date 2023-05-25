package Consultoria.pack.Base_Datos.CRUD;

import Consultoria.pack.Base_Datos.Gestor_BD;
import Consultoria.pack.Clases_Base.Usuario;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Create {


    public static void Crear_Usuario(Usuario usuario_current) {

        try {
            Connection connection = Gestor_BD.Conectar_BD();
            String query = "INSERT INTO CLIENTE(USUARIO,CONTRASEÑA)VALUES(?,?)";
            PreparedStatement pst = connection.prepareStatement(query);

            pst.setString(1, usuario_current.getUsuario());
            pst.setString(2, usuario_current.getContrasenya());

            int filas_add = pst.executeUpdate();
            if (filas_add > 0) {
                Gestor_BD.commit(connection);
                JOptionPane.showMessageDialog(null, "Usuario registrado correctamente",
                        "Usuario Registrado", JOptionPane.INFORMATION_MESSAGE);
            } else JOptionPane.showMessageDialog(null, "EL usuario no ha podido ser guardado en " +
                    "la Base de datos.\nIntente nuevamente", "Error Registro", JOptionPane.ERROR_MESSAGE);
            Gestor_BD.desconectar(connection);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getCause().getMessage(),
                    "Error BD", JOptionPane.ERROR_MESSAGE);
        }


    }
}

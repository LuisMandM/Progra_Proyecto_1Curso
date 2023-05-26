package Consultoria.pack.Base_Datos.CRUD;

import Consultoria.pack.Base_Datos.Gestor_BD;
import Consultoria.pack.Clases_Base.Duenio;
import Consultoria.pack.Clases_Base.Equipo;
import Consultoria.pack.Clases_Base.Jugador;
import Consultoria.pack.Clases_Base.Usuario;
import Consultoria.pack.Clases_Base.Duenio;
import Consultoria.pack.Clases_Base.Equipo;
import Consultoria.pack.Clases_Base.Jugador;

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
    public static void Crear_jugador(Jugador jugador_current){

        try {
            Connection connection = Gestor_BD.Conectar_BD();
            String query = "INSERT INTO JUGADOR(NOMBRE,NICKNAME,SUELDO)VALUES(?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);

            pst.setString(1,jugador_current.getNombre());
            pst.setString(2,jugador_current.getNickname());
            pst.setString(3, String.valueOf(jugador_current.getSueldo()));

            int filas_add = pst.executeUpdate();
            if (filas_add > 0) {
                Gestor_BD.commit(connection);
                JOptionPane.showMessageDialog(null, "Jugador registrado correctamente",
                        "Jugador Registrado", JOptionPane.INFORMATION_MESSAGE);
            } else JOptionPane.showMessageDialog(null, "EL jugador no ha podido ser guardado en " +
                    "la Base de datos.\nIntente nuevamente", "Error Registro", JOptionPane.ERROR_MESSAGE);
            Gestor_BD.desconectar(connection);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getCause().getMessage(),
                    "Error BD", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void Crear_duenio(Duenio duenio_current){
        try {
            Connection connection = Gestor_BD.Conectar_BD();
            String query = "INSERT INTO DUEÑO(NOMBRE,USUARIO,CONTRASEÑA)VALUES(?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);

            pst.setString(1,duenio_current.getNombre());
            pst.setString(2,duenio_current.getUsuario());
            pst.setString(3, duenio_current.getContrasenya());

            int filas_add = pst.executeUpdate();
            if (filas_add > 0) {
                Gestor_BD.commit(connection);
                JOptionPane.showMessageDialog(null, "Dueño registrado correctamente",
                        "Jugador Registrado", JOptionPane.INFORMATION_MESSAGE);
            } else JOptionPane.showMessageDialog(null, "EL Dueño no ha podido ser guardado en " +
                    "la Base de datos.\nIntente nuevamente", "Error Registro", JOptionPane.ERROR_MESSAGE);
            Gestor_BD.desconectar(connection);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getCause().getMessage(),
                    "Error BD", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void Crear_equipo(Equipo equipo_current){
        try {
            Connection connection = Gestor_BD.Conectar_BD();
            String query = "INSERT INTO EQUIPO(NOMBRE,SALARIO_TOTAL,ID_DUEÑO,DISPONIBILIDAD)VALUES(?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);

            pst.setString(1,equipo_current.getNombre());
            pst.setString(2, String.valueOf(equipo_current.getSalario_total()));
            pst.setString(3, String.valueOf(equipo_current.getDuenyo().getId_usuario()));
            pst.setString(4,"E");

            int filas_add = pst.executeUpdate();
            if (filas_add > 0) {
                Gestor_BD.commit(connection);
                JOptionPane.showMessageDialog(null, "Equipo registrado correctamente",
                        "Equipo Registrado", JOptionPane.INFORMATION_MESSAGE);
            } else JOptionPane.showMessageDialog(null, "EL Equipo no ha podido ser guardado en " +
                    "la Base de datos.\nIntente nuevamente", "Error Registro", JOptionPane.ERROR_MESSAGE);
            Gestor_BD.desconectar(connection);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getCause().getMessage(),
                    "Error BD", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void Crear_jugador(Jugador jugador_current){

        try {
            Connection connection = Gestor_BD.Conectar_BD();
            String query = "INSERT INTO JUGADOR(NOMBRE,NICKNAME,SUELDO)VALUES(?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);

            pst.setString(1,jugador_current.getNombre());
            pst.setString(2,jugador_current.getNickname());
            pst.setString(3, String.valueOf(jugador_current.getSueldo()));

            int filas_add = pst.executeUpdate();
            if (filas_add > 0) {
                Gestor_BD.commit(connection);
                JOptionPane.showMessageDialog(null, "Jugador registrado correctamente",
                        "Jugador Registrado", JOptionPane.INFORMATION_MESSAGE);
            } else JOptionPane.showMessageDialog(null, "EL jugador no ha podido ser guardado en " +
                    "la Base de datos.\nIntente nuevamente", "Error Registro", JOptionPane.ERROR_MESSAGE);
            Gestor_BD.desconectar(connection);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getCause().getMessage(),
                    "Error BD", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void Crear_duenio(Duenio duenio_current){
        try {
            Connection connection = Gestor_BD.Conectar_BD();
            String query = "INSERT INTO DUEÑO(NOMBRE,USUARIO,CONTRASEÑA)VALUES(?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);

            pst.setString(1,duenio_current.getNombre());
            pst.setString(2,duenio_current.getUsuario());
            pst.setString(3, duenio_current.getContrasenya());

            int filas_add = pst.executeUpdate();
            if (filas_add > 0) {
                Gestor_BD.commit(connection);
                JOptionPane.showMessageDialog(null, "Dueño registrado correctamente",
                        "Jugador Registrado", JOptionPane.INFORMATION_MESSAGE);
            } else JOptionPane.showMessageDialog(null, "EL Dueño no ha podido ser guardado en " +
                    "la Base de datos.\nIntente nuevamente", "Error Registro", JOptionPane.ERROR_MESSAGE);
            Gestor_BD.desconectar(connection);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getCause().getMessage(),
                    "Error BD", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void Crear_equipo(Equipo equipo_current){
        try {
            Connection connection = Gestor_BD.Conectar_BD();
            String query = "INSERT INTO EQUIPO(NOMBRE,SALARIO_TOTAL,ID_DUEÑO,DISPONIBILIDAD)VALUES(?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);

            pst.setString(1,equipo_current.getNombre());
            pst.setString(2, String.valueOf(equipo_current.getSalario_total()));
            pst.setString(3, String.valueOf(equipo_current.getDuenyo().getId_usuario()));
            pst.setString(4,"E");

            int filas_add = pst.executeUpdate();
            if (filas_add > 0) {
                Gestor_BD.commit(connection);
                JOptionPane.showMessageDialog(null, "Equipo registrado correctamente",
                        "Equipo Registrado", JOptionPane.INFORMATION_MESSAGE);
            } else JOptionPane.showMessageDialog(null, "EL Equipo no ha podido ser guardado en " +
                    "la Base de datos.\nIntente nuevamente", "Error Registro", JOptionPane.ERROR_MESSAGE);
            Gestor_BD.desconectar(connection);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getCause().getMessage(),
                    "Error BD", JOptionPane.ERROR_MESSAGE);
        }
    }
}

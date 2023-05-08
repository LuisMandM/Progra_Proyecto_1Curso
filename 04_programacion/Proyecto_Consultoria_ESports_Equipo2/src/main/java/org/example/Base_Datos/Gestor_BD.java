package org.example.Base_Datos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Gestor_BD {

    private static Logger logger = LogManager.getLogger();

    public static Connection Conectar_BD(){
        Connection conexion = null;
        try {

            // Cadena de conexión
            String servidor = Configuracion.leer("DB_HOST");
            String puerto = Configuracion.leer("DB_PORT");
            String bd = Configuracion.leer("DB_DATABASE");
            String login = Configuracion.leer("DB_USERNAME");
            String password = Configuracion.leer("DB_PASSWORD");
            String url = "jdbc:oracle:thin:@" + servidor + ":" + puerto + ":" + bd;

            // Establecimiento de conexión
            conexion = DriverManager.getConnection(url, login, password);

            logger.info("Conexión abierta");

        } catch (SQLException e) {
            logger.fatal(e);
        }
        return conexion;
    }

    public static void desconectar(Connection conexion) {
        try {
            conexion.close();
            logger.info("Conexión cerrada");
        } catch (SQLException e) {
            logger.error(e);
        }
    }

    public static void commit(Connection conexion) throws SQLException {
        Statement st = conexion.createStatement();
        st.execute("COMMIT");
    }



}

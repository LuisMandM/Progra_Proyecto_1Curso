package Consultoria.pack.Base_Datos;

import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class Autenticacion {


    public static int Autorizacion(String usuario, String password) {
        int view = 0;
        String passHex = String.format("%x", new BigInteger(1, password.getBytes())).toUpperCase();
        int answer;
        boolean found = false;

        for (int i = 0; i < 3; i++) {
            if (!found) {
                switch (i) {
                    case (0):
                        answer = Autenticar_Admin(usuario, passHex);
                        if (answer != 0) {
                            switch (answer) {
                                case -1 -> view = -900;
                                case 10 -> {
                                    view = 10;
                                    found = true;
                                }
                                case -404 -> view = -800;
                            }
                        } else view = 900;


                    case (1):
                        answer = Autenticar_Duenio(usuario, passHex);
                        if (answer != 0) {
                            switch (answer) {
                                case -1 -> view = -900;
                                case 20 -> {
                                    view = 20;
                                    found = true;
                                }
                                case -404 -> view = -800;
                            }
                        } else view = 900;


                    case (2):
                        answer = Autenticar_User(usuario, passHex);
                        if (answer != 0) {
                            switch (answer) {
                                case -1 -> view = -900;
                                case 30 -> {
                                    view = 30;
                                    found = true;
                                }
                                case -404 -> view = -800;
                            }
                        } else
                            view = 900;
                }
            }else break;
        }


        return view;

    }


    private static int Autenticar_Admin(String usuario, String passHex) {

        int answer;
        try {
            Connection connection = Gestor_BD.Conectar_BD();
            CallableStatement cs = connection.prepareCall("{call AUTENTICACION_PACK.AUTENTICACION_ADMIN(?,?,?)}");

            cs.setString(1, usuario);
            cs.setString(2, passHex);

            cs.registerOutParameter(3, Types.INTEGER);
            cs.execute();
            answer = cs.getInt(3);
            Gestor_BD.desconectar(connection);
        } catch (SQLException e) {
            answer = 0;
        }
        return answer;
    }

    private static int Autenticar_Duenio(String usuario, String passHex) {

        int answer;
        try {
            Connection connection = Gestor_BD.Conectar_BD();
            CallableStatement cs = connection.prepareCall("{call AUTENTICACION_PACK.AUTENTICACION_DUENIO(?,?,?)}");

            cs.setString(1, usuario);
            cs.setString(2, passHex);

            cs.registerOutParameter(3, Types.INTEGER);
            cs.execute();
            answer = cs.getInt(3);
            Gestor_BD.desconectar(connection);
        } catch (SQLException e) {
            answer = 0;
        }
        return answer;
    }

    private static int Autenticar_User(String usuario, String passHex) {

        int answer;
        try {
            Connection connection = Gestor_BD.Conectar_BD();
            CallableStatement cs = connection.prepareCall("{call AUTENTICACION_PACK.AUTENTICACION_CLIENTE(?,?,?)}");

            cs.setString(1, usuario);
            cs.setString(2, passHex);

            cs.registerOutParameter(3, Types.INTEGER);
            cs.execute();
            answer = cs.getInt(3);

            Gestor_BD.desconectar(connection);
        } catch (SQLException e) {
            answer = 0;
        }

        return answer;
    }


}


package Consultoria.pack.GUI.Login;

import Consultoria.pack.Base_Datos.Autenticacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V_Login {
    private JPanel panel;
    private JPanel panel_Inserts;
    private JTextField user_textField;
    private JButton enter_Button;
    private JPasswordField passwordField;

    public V_Login(JFrame frame) {


        enter_Button.addActionListener(e -> {
            String user = user_textField.getText();
            String password = new String(passwordField.getPassword());

            int autenticacion = Autenticacion.Autorizacion(user, password);

            switch (autenticacion) {

                case 0:
                    JOptionPane.showMessageDialog(null, "Error inesperado Intente nuevamente",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    break;

                case 10:
                    //Aqui va el llamado al menu de Admin;
                   frame.setVisible(false);
                    break;

                case 20:
                    //Aqui va el llamado a menu de Duenio;
                    frame.setVisible(false);
                    break;

                case 30:
                    //Aqui va el llamado a menu Usuario;
                    frame.setVisible(false);
                    break;

                case 900:
                    JOptionPane.showMessageDialog(null, "Error de Conexion a la base de datos, Intente más Tarde",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    break;

                case -800:
                    JOptionPane.showMessageDialog(null, "Usuario no encontrado, Intente nuevamente",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                case -900:
                    JOptionPane.showMessageDialog(null, "Clave Incorrecta, Intente nuevamente",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    break;

            }


        });
    }



    public JPanel getPanel() {
        return panel;
    }
}

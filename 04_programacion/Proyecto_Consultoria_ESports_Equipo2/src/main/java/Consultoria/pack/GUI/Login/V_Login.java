package Consultoria.pack.GUI.Login;

import Consultoria.pack.Base_Datos.Autenticacion;
import Consultoria.pack.Base_Datos.Carga;

import javax.swing.*;

public class V_Login {
    private JPanel panel;
    private JPanel panel_Inserts;
    private JTextField user_textField;
    private JButton enter_Button;
    private JPasswordField passwordField;

    public V_Login(JFrame frame1) {


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
                    JOptionPane.showMessageDialog(null, "Se abre ventana inicio ADMIN",
                            "V_ADMIN", JOptionPane.INFORMATION_MESSAGE);
                   frame1.setVisible(false);
                    Carga_base(10);
                    VentanaAdmin();
                    break;

                case 20:
                    JOptionPane.showMessageDialog(null, "Se abre ventana inicio DUEÑO",
                            "V_DUENIO", JOptionPane.INFORMATION_MESSAGE);
                    frame1.setVisible(false);
                    Carga_base(20);
                    VentanaDuenio();
                    break;

                case 30:
                    JOptionPane.showMessageDialog(null, "Se abre ventana inicio CLIENTE",
                            "V_CLIENTE", JOptionPane.INFORMATION_MESSAGE);
                    frame1.setVisible(false);
                    Carga_base(30);
                    VentanaUsuario();
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

    public static void Carga_base(int level){

        switch (level){
            case 10:
                Carga.Cargar_Equipos();
                Carga.Cargar_Calendario();
                Carga.Cargar_Clientes();
                Carga.Cargar_Jugadores_Libres();
                break;
            case 20:
                Carga.Cargar_Equipos_View();
                Carga.Cargar_Calendario();
                Carga.Cargar_Jugadores_Libres();
                break;
            case 30:
                Carga.Cargar_Equipos_View();
                Carga.Cargar_Calendario();
                break;
        }
    }
    public static void VentanaAdmin(){
        JFrame frame = new JFrame("V_Inicio_Admin");
        frame.setContentPane(new Consultoria.pack.GUI.Login.V_Inicio_Admin().getPanelInicio_Admin());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public static void VentanaDuenio (){
        JFrame frame = new JFrame("V_Inicio_Duenio");
        frame.setContentPane(new Consultoria.pack.GUI.Login.V_Inicio_Duenio().getPanelDuenio());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public static void VentanaUsuario (){
        JFrame frame = new JFrame("V_Inicio_Usuario");
        frame.setContentPane(new Consultoria.pack.GUI.Login.V_Inicio_Usuario().getPanelUsuario());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

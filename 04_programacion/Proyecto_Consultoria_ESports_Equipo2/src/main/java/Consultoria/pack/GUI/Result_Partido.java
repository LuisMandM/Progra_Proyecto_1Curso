package Consultoria.pack.GUI;

import Consultoria.pack.Clases_Base.Partido;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Result_Partido {
    private JPanel panel1;
    private JLabel label1;
    private JTextArea textArea1;
    private JLabel label2;
    private JTextArea textArea2;
    private JLabel label3;
    private JTextArea textArea3;
    private JButton button1;

    private List<Partido> partidos;

    public Result_Partido() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Partido partido: partidos) {
                    if (partido.getJornada().getFecha().equals(textArea1.getText())) {

                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Result_Partido");
        frame.setContentPane(new Result_Partido().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}

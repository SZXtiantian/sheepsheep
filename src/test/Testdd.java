package test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Testdd {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setLayout(null);
        JComboBox<String> jComboBox = new JComboBox<String>();
        jComboBox.setBounds(0, 30, 120, 30);
        frame.add(jComboBox,BorderLayout.CENTER);

        JButton button = new JButton("重绘");
        button.setBounds(0, 0, 120, 30);
        frame.add(button,BorderLayout.NORTH);

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                frame.remove(jComboBox);
                JButton button_R = new JButton("重绘后");
                button_R.setBounds(0, 30, 120, 30);
                frame.add(button_R);
                button_R.repaint(0, 0, 120, 30);

                button_R.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "由之前的下拉列表重绘为按钮");
                    }
                });
            }
        });
        frame.setBounds(100, 100, 100, 100);
        frame.setVisible(true);


    }

}
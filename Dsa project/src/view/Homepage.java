package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homepage extends JFrame implements ActionListener {
    JButton b1;


    Homepage() {
        Addtask();
        setTitle("DSA Project");
        setLayout(null);
        getContentPane().setBackground(new Color(212, 103, 231, 179));
        setSize(900, 600);
        setVisible(true);
        setLocationRelativeTo(null);


    }
    public void Addtask() {
        b1 = new JButton("Add Task");
        b1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        b1.setBackground(new Color(255, 255, 255, 255));
        b1.setBounds(50, 50, 200, 40);
        add(b1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            dispose();
            new Addtask();
        }


    }


    public static void main(String args[]) {
        Homepage t = new Homepage();
    }
}
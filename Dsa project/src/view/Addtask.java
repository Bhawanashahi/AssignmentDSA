package view;

import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

public class Addtask extends JFrame implements ActionListener {
    JButton b1;
    JLabel l;
    JTextField j;

    Addtask() {
        Addtask();
        Task();
        Taskfield();;
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
        b1.setBounds(100, 150, 200, 40);
        add(b1);
    }
    public void Task() {
        l = new JLabel("Task");
        l.setFont(new Font("Times New Roman", Font.BOLD, 25));
        l.setBounds(150, 50, 200, 40);
        add(l);
    }
    public void Taskfield() {
        j = new JTextField();
        j.setFont(new Font("Times New Roman", Font.BOLD, 16));
        j.setBounds(100, 100, 200, 40);
        add(j);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            dispose();
             new Homepage();
        }


    }

    public static void main(String args[]) {
        Addtask t = new Addtask();
    }
}

package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Createjob     extends JFrame implements ActionListener {



        JButton b1;
        JLabel l;
    JLabel l1;
    JLabel l2;

        JTextField j;
    JTextField j1;
    JTextField j2;

        Createjob() {
            JobName();
             Profit();
             CreateJob();
            JobnameField();
            ProfitField();
            setTitle("DSA Project");
            setLayout(null);
            getContentPane().setBackground(new Color(212, 103, 231, 179));
            setSize(900, 600);
            setVisible(true);
            setLocationRelativeTo(null);


        }
        public void JobName() {
            l1 = new JLabel("Jon Name");
            l1.setFont(new Font("Times New Roman", Font.BOLD, 16));
            l1.setBackground(new Color(255, 255, 255, 255));
            l1.setBounds(100, 150, 200, 40);
            add(l1);
        }
    public void JobnameField() {
        j = new JTextField();
        j.setFont(new Font("Times New Roman", Font.BOLD, 16));
        j.setBounds(250, 150, 200, 40);
        add(j);
    }


        public void Profit() {
            l1 = new JLabel("Profit");
            l1.setFont(new Font("Times New Roman", Font.BOLD, 16));
            l1.setBounds(100, 200, 200, 40);
            add(l1);
        }
    public void ProfitField() {
        j1 = new JTextField();
        j1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        j1.setBounds(250, 200, 200, 40);
        add(j1);
    }
    public void CreateJob() {
        b1 = new JButton("Create Job");
        b1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        b1.setBounds(250, 250, 200, 40);
        add(b1);
    }




    @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == b1) {
                dispose();
                new Homepage();
            }


        }

        public static void main(String args[]) {
            view.Createjob t = new view.Createjob();
        }
    }



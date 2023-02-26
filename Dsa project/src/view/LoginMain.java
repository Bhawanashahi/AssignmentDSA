package view;

import controller.CustomerController;
import model.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginMain extends JFrame implements ActionListener {

    JButton jb1, b1;
    JTextField jt1;
    JPasswordField jt2;
    JLabel lbl;
    JButton jb12, jb3;
    CustomerController customerController;
    Customer customer;
    public static int CUSTOMER_ID = 0;

    LoginMain() {

        UI();
        ManLogo();
        UsernameText();
        Username();
        Password();
        Loginbutton();
        PasswordText();
       // ForgotPassword();
        Welcome();
        CreateAccount();
       // Exit();
       // Logo_Name();
        Half_line();


        jb1.addActionListener(this);
        jb12.addActionListener(this);
//        jb3.addActionListener(this);
//        b1.addActionListener(this);
        setTitle("DSA Project");
        setLayout(null);
        //getContentPane().setBackground(new Color(63, 22, 81));
        setSize(900, 600);
        setVisible(true);
        setLocationRelativeTo(null);

    }

    public void UI() {
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(400, 100, 1080, 720);
        setBackground(Color.BLUE);
        setLayout(null);
        setResizable(false);
    }


    private void ManLogo() {
        JLabel lbl_icon = new JLabel(new ImageIcon("C:\\Users\\ACER\\Desktop\\Group 4\\Group 4(BMS)\\public\\Manlogo.png"));
        lbl_icon.setBounds(460, 12, 120, 120);
        add(lbl_icon);
    }

    public void Welcome() {
        lbl = new JLabel("WELCOME");
        lbl.setFont(new Font("Times New Roman", Font.BOLD, 30));
        lbl.setForeground(Color.BLACK);
        lbl.setBounds(460, 155, 300, 30);
        add(lbl);
    }


    public void Username() {
        lbl = new JLabel("Email");
        lbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbl.setForeground(Color.BLACK);
        lbl.setBounds(300, 250, 100, 30);
        add(lbl);
    }

    public void UsernameText() {
        jt1 = new JTextField();
        jt1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        jt1.setBounds(440, 250, 200, 30);
        add(jt1);
    }

    public void Password() {
        lbl = new JLabel("Password");
        lbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbl.setForeground(Color.BLACK);
        lbl.setBounds(300, 300, 100, 30);
        add(lbl);
    }

    public void PasswordText() {
        jt2 = new JPasswordField();
        jt2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        jt2.setBounds(440, 300, 200, 30);
        add(jt2);
    }

    public void Loginbutton() {
        jb12 = new JButton("Login");
        jb12.setFont(new Font("Times New Roman", Font.BOLD, 16));
        jb12.setBackground(new Color(255, 255, 255));
        jb12.setBounds(440, 350, 200, 40);
        add(jb12);
    }

//    public void ForgotPassword() {
//        b1 = new JButton("Forgot Password ?");
//        b1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
//        b1.setForeground(Color.BLACK);
//        b1.setBorderPainted(false);
//        b1.setBounds(460, 400, 150, 30);
//        add(b1);
//    }

    public void CreateAccount() {
        jb1 = new JButton("Create Account");
        jb1.setBackground(new Color(0, 0, 0));
        jb1.setForeground(Color.WHITE);
        jb1.setBounds(00, 350, 200, 50);
        add(jb1);
    }

//    public void Exit() {
//        jb3 = new JButton("Back");
//        jb3.setForeground(Color.white);
//        jb3.setBackground(Color.RED);
//        jb3.setBounds(0, 410, 200, 50);
//        add(jb3);
//    }

//    private void Logo_Name() {
//        JLabel lbl_icon = new JLabel(new ImageIcon("C:\\Users\\ACER\\Desktop\\Group 4\\Group 4(BMS)\\public\\Logoregister1.PNG"));
//        lbl_icon.setBounds(38, 29, 140, 120);
//        add(lbl_icon);
//    }

    private void Half_line() {
        JLabel lbl_icon = new JLabel(new ImageIcon("C:\\Users\\ACER\\Desktop\\Group 4\\Group 4(BMS)\\public\\Purple_Color.PNG"));
        lbl_icon.setBounds(0, 0, 205, 600);
        add(lbl_icon);
    }


    public static void main(String args[]) {
        LoginMain t = new LoginMain();
    }


    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == b1) {
            dispose();
          //  new ForgetPw();
        }

        if (e.getSource() == jb1) {
            dispose();
            new RegistrationPage();
//        }
            if (e.getSource() == jb3) {
                this.hide();
           //    new Homepage().setVisible(true);
            }




            if (e.getSource() == jb12) {
                customerController = new CustomerController();
                customer = customerController.loginCustomer(jt1.getText(),
                        jt2.getText());
                if (customer != null) {
                    JOptionPane.showMessageDialog(this, "Successfully Login");
//                    MerchantPay MPay = new MerchantPay();
//                    MPay.show();

                    // Home home = new Home();
                    // home.show();


                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            }

        }
    }
}

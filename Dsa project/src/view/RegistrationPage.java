package view;

import controller.CustomerController;
import model.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RegistrationPage extends JFrame {
    private static JLabel lblSign, lblFname, lblLname,  lblemail, lblPassword,
            lblConfirmPassword, lbldeposite, lblproperty, lbl_i, lbl1;
    private static JTextField txtFname, txtLname,  txtEmailaddress,txtdeposite, txtrequest;
    private static JTextArea txtAddress;
    private static JPasswordField jpPassword, jpConfirmPassword;
    private static JRadioButton rbMale, rbFemale, rbOthers;
    private static JButton btnRegsiter, btnClose, btnLogin;
    private static ButtonGroup bgGender;
    CustomerController customerController;

    private void registerCustomer() {
        String fname = txtFname.getText();
        String lname = txtLname.getText();



        String password = jpPassword.getText();
        String confirmPassword = jpConfirmPassword.getText();
        String email = txtEmailaddress.getText();
        Integer deposite = Integer.valueOf(txtdeposite.getText());
        String request = txtrequest.getText();


        if (password.equals(confirmPassword)) {

            Customer customer = new Customer(fname, lname,   password,  email,  deposite, request);

            customerController = new CustomerController();
            int insert = customerController.registerCustomer(customer);

            if (insert > 0) {
                JOptionPane.showMessageDialog(null, "Successfully registered");
                dispose();
                //new LoginMain();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to register");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Password and Confirm Password does not match");
            jpPassword.requestFocus();
        }
    }

    public RegistrationPage() {
        setTitle("DSA Project");
        setSize(800, 600);
        setLayout(null);


        lbl_i = new JLabel(new ImageIcon("C:\\Users\\ACER\\Desktop\\Group 4\\Group 4(BMS)\\public\\Purple_Color.PNG"));
        lbl_i.setBounds(0, 0, 230, 600);
        add(lbl_i);

        JLabel lbl1 = new JLabel(new ImageIcon("C:\\Users\\ACER\\Desktop\\Group 4\\Group 4(BMS)\\public\\Createacc.png"));
        lbl1.setBounds(440, 60, 75, 72);
        add(lbl1);


        lblSign = new JLabel("Registration Page");
        lblFname = new JLabel("First Name");
        lblLname = new JLabel("Last Name");

        lblemail = new JLabel("Email");

        lblPassword = new JLabel("Password");
        lblConfirmPassword = new JLabel("Confirm Password");

        lbldeposite = new JLabel("Deposit");
        lblproperty = new JLabel("This is the property of KeepItSafe Bank, Unauthorised access of this software will be illegal and punishable, © 2022 KeepItSafe Bank");

        txtFname = new JTextField("");
        txtLname = new JTextField("");

        txtEmailaddress = new JTextField("");

        txtAddress = new JTextArea("");

        txtdeposite = new JTextField("500000");
        txtrequest = new JTextField("No request is made");

        jpPassword = new JPasswordField("");
        jpPassword.setEchoChar('$');
        jpConfirmPassword = new JPasswordField("");


        btnRegsiter = new JButton("Create Account");
        btnClose = new JButton("Back");
        btnLogin = new JButton("Login Account");

        bgGender = new ButtonGroup();


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Center the screen
        setLocationRelativeTo(null);

        populateComponents();

        btnRegsiter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!checkFields())
                    registerCustomer();
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginMain();
            }
        });


        setVisible(true);
    }

    boolean flag = false;

    private boolean checkFields() {

        if (txtFname.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Fill Up the Form Completely");
            txtFname.requestFocus();
            flag = true;
        } else if (txtLname.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Fill Up the Form Completely");
            txtLname.requestFocus();
            flag = true;
        }
        return flag;
    }

    private void populateComponents() {
        lblSign.setBounds(410, 0, 300, 50);
        lblSign.setFont(new Font("Times New Roman", Font.BOLD, 28));
        lblSign.setForeground(Color.BLACK);
        add(lblSign);

        lblFname.setBounds(300, 150, 100, 30);
        lblFname.setForeground(Color.BLACK);
        add(lblFname);

        txtFname.setBounds(420, 150, 200, 30);
        add(txtFname);

        lblLname.setBounds(300, 200, 100, 30);
        lblLname.setForeground(Color.BLACK);
        add(lblLname);

        txtLname.setBounds(420, 200, 200, 30);
        add(txtLname);






        lblemail.setBounds(300, 250, 100, 30);
        lblemail.setForeground(Color.BLACK);
        add(lblemail);

        txtEmailaddress.setBounds(420, 250, 200, 30);
        add(txtEmailaddress);


        lblPassword.setBounds(300, 300, 100, 30);
        lblPassword.setForeground(Color.BLACK);
        add(lblPassword);

        jpPassword.setBounds(420, 300, 200, 30);
        add(jpPassword);

        lblConfirmPassword.setBounds(300, 350, 120, 30);
        lblConfirmPassword.setForeground(Color.BLACK);
        add(lblConfirmPassword);

        jpConfirmPassword.setBounds(420, 350, 200, 30);
        add(jpConfirmPassword);


        btnRegsiter.setBounds(420, 480, 200, 40);
        btnRegsiter.setBackground(Color.WHITE);
        add(btnRegsiter);


        btnLogin.setBounds(0, 400, 230, 40);
        btnLogin.setBackground(Color.white);
        lbl_i.add(btnLogin);


        lbldeposite.setBounds(20, 260, 120, 30);
        lbldeposite.setForeground(Color.WHITE);

        lblproperty.setBounds(150, 630, 760, 30);
        lblproperty.setForeground(Color.WHITE);
        lblproperty.setForeground(Color.WHITE);
        add(lblproperty);

        txtdeposite.setBounds(130, 260, 200, 30);



    }

    public static void main(String args[]) {
        RegistrationPage t = new RegistrationPage();
    }
}


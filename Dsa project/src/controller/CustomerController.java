package controller;

import database.DbConnection;
import model.Customer;
import view.LoginMain;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerController {
    //creating the object of DbConnection class
    static DbConnection db = new DbConnection();
    static PreparedStatement st;

//    data/user  register garniiii

    public static int registerCustomer(Customer customer) {
        try {
            String query = "insert into customer(custFname,custLname" +
                    "email,password,) values(?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement st = db.connection.prepareStatement(query);

            st.setString(1, customer.getCustFname());
            st.setString(2, customer.getCustLname());
            st.setString(7, customer.getPassword());
            st.setString(10, customer.getemail());
//            st.setString(12, String.valueOf(customer.getDeposite()));
//            st.setString(13, customer.getRequest());


            return db.manipulate(st);

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }


//    fetching username and password----for login
    public static Customer loginCustomer(String username, String password) {
        Customer customer = null;
        try {
            String query;
            query = "select custId from customer where username =? and password =?";
            st = db.connection.prepareStatement(query);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = db.retrieve(st);
            while (rs.next()) {
                customer = new Customer();
                customer.setCustId(rs.getInt("custId"));
                LoginMain.CUSTOMER_ID=rs.getInt("custId");
            }
        } catch (Exception ex) {
            System.out.println("Error " + ex);
        }
        return customer;
    }
//
////    -----forget password----matching phone number and username
//    public static Customer ResetCustomer(String phoneNo, String username) {
//        Customer customer = null;
//        try {
//            String query;
//            query = "select custId from customer where phoneNo =? and username =?";
//            st = db.connection.prepareStatement(query);
//            st.setString(1, phoneNo);
//            st.setString(2, username);
//            ResultSet rs = db.retrieve(st);
//            while (rs.next()) {
//                customer = new Customer();
//                customer.setCustId(rs.getInt("custId"));
//                ForgetPw.CUSTOMER_ID=rs.getInt("custId");
//            }
//        } catch (Exception ex) {
//            System.out.println("Error " + ex);
//        }
//        return customer;
//    }
//
//// displaying user information in home page
//
//    public static Customer fetchLoggedInCustomer() {
//        Customer customer = null;
//        try {
//            String query;
//            query = "select * from customer where custId =?";
//            st = db.connection.prepareStatement(query);
//            st.setInt(1, LoginMain.CUSTOMER_ID);
//            ResultSet rs = db.retrieve(st);
//            while (rs.next()) {
//                customer = new Customer();
//                customer.setCustId(rs.getInt("custId"));
//                customer.setCustFname(rs.getString("custFname"));
//                customer.setCustLname(rs.getString("custLname"));
//                customer.setGender(rs.getString("gender").charAt(0));
//                customer.setPhoneNo(rs.getString("phoneNo"));
//                customer.setAddress(rs.getString("address"));
//                customer.setUsername(rs.getString("username"));
//                customer.setPassword(rs.getString("password"));
//                customer.setDatofbirth(rs.getString("datofbirth"));
//                customer.setcitizenship(rs.getString("citizenship"));
//                customer.setemail(rs.getString("email"));
//                customer.setAccountnumber(rs.getString("accountnumber"));
//                customer.setDeposite(Integer.valueOf(rs.getString("deposite")));
//                customer.setRequest(rs.getString("request"));
//
//            }
//        } catch (Exception ex) {
//            System.out.println("Error " + ex);
//        }
//        return customer;
//    }
//
////    kyc updatee
//    public static int updateProfile(Customer customer) {
//        try {
//            String query;
//            query ="update customer set custFname= ?,custLname= ?,address= ?,phoneNo= ?,citizenship=?,datofbirth=?,email=?,username=? where custId= ?";
//            st = db.connection.prepareStatement(query);
//            st.setString(1, customer.getCustFname());
//            st.setString(2, customer.getCustLname());
//            st.setString(3, customer.getAddress());
//            st.setString(4, customer.getPhoneNo());
//            st.setString(5, customer.getDatofbirth());
//            st.setString(6, customer.getcitizenship());
//            st.setString(7, customer.getemail());
//            st.setString(8, customer.getUsername());
//            st.setInt(9, customer.getCustId());
//            return db.manipulate(st);
//        } catch (Exception ex) {
//            System.out.println("Error " + ex);
//            return 0;
//        }
//    }
//
//
//
//    //    reseting password
//    public static int resetpassword(Customer customer) {
//        try {
//            String query;
//            query ="update customer set password=? where custId= ?";
//            st = db.connection.prepareStatement(query);
//            st.setString(1, customer.getPassword());
//            st.setInt(2, customer.getCustId());
//
//            return db.manipulate(st);
//        } catch (Exception ex) {
//            System.out.println("Error " + ex);
//            return 0;
//        }
//    }
//
//
//    //Update Balance after Transaction
//    public int updateBalance(Customer customer1) {
//        try {
//            String query;
//            query ="update customer set deposite=? where custId= ?";
//            st = db.connection.prepareStatement(query);
//            st.setInt(1, customer1.getDeposite());
//            st.setInt(2, customer1.getCustId());
//            return db.manipulate(st);
//        } catch (Exception ex) {
//            System.out.println("Error " + ex);
//            return 0;
//        }
//    }
//
//
//
}

package model;

public class Customer {
    private int custId;

    private String custFname;
    private String custLname;
    private String password;
    private String email;
    private Integer deposite;
    private String request;


    public Customer() {

    }
    public Customer(Integer deposite, int custId ){
        this.deposite = deposite;
        this.custId = custId;
    }
    public Customer(int custId ){
        this.custId = custId;
    }


    public Customer(int custId, String custFname, String custLname,  String email, String request) {
        this.custId = custId;
        this.custFname = custFname;
        this.custLname = custLname;

        this.email = email;
        this.request = request;

    }public Customer(String fname, String lname, String s, String email, int custId, String password) {
        this.custId = custId;
        this.password = password;

    }

    public Customer(String custFname, String custLname, char gender, String phoneNo, String address, String username, String password, String datofbirth, String citizenship, String email, String accountnumber, Integer deposite, String request) {
        this.custFname = custFname;
        this.custLname = custLname;
        this.password = password;
        this.email = email;
        this.deposite = deposite;
        this.request = request;


    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getCustFname() {
        return custFname;
    }

    public void setCustFname(String custFname) {
        this.custFname = custFname;
    }

    public String getCustLname() {
        return custLname;
    }

    public void setCustLname(String custLname) {
        this.custLname = custLname;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }


    public Integer getDeposite() {
        return deposite;
    }

    public void setDeposite(Integer deposite) {
        this.deposite = deposite;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

}

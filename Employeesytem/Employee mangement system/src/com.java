import java.sql.*;      //interface sql

public class com {

    Connection c;           //2nd step creating connection string
    Statement s;            //3rd step creating statement  com.mysql.cj.jdbc.Driver
    public com () {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");         //1st step of registering thye driver class

            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemangementsystem" , "root" , "password");
            s = c.createStatement();
        } catch (Exception e) {

            //TODO: handle exception
            e.printStackTrace();                
            
        }        
    }
}

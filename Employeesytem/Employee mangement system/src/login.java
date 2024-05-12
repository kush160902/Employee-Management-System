import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class login extends JFrame implements ActionListener{

    JTextField userField , passField;

    login() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername = new JLabel("USERNAME");
        lblusername.setBounds(40, 20, 100, 30);                            // setting alignments for heading
        add (lblusername);

        //setting textfield for username
        userField = new JTextField();
        userField.setBounds(150, 20, 150, 30);
        add (userField);

       
        JLabel lblpassowrd = new JLabel("PASSWORD");
        lblpassowrd.setBounds(40, 70, 100, 30);                            
        add (lblpassowrd);

        //setting textfield for passowrd
        passField = new JTextField();
        passField.setBounds(150, 70, 150, 30);
        add (passField);

        //creating button for logoin
        JButton login = new JButton("LOGIN");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
    
        try {
            String username = userField.getText();
            String password = passField.getText();

            com c = new com();
            String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
            
            ResultSet rs = c.s.executeQuery(query);        //queyr made been called from statement made in com
            if (rs.next()) {
                setVisible(false);
                //next class
                new Home();
            }else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
            }

        } catch (Exception e) {
                e.printStackTrace();                    // TODO: handle exception
        }
    
    }


    public static void main(String[] args) {
        new login();
    }
    
}

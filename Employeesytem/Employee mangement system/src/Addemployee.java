import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

import com.toedter.calendar.*;


public class Addemployee extends JFrame implements ActionListener{

    Random ran = new Random();             //random used with import to genrate rnadom unique employee id
    int number = ran.nextInt(999999);

    JTextField tfname, tffname, tfsalary, tfaddress, tfphone, tfmail, tfdesignation, tfaadhar;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel lblempid;
    JButton add, back;

    Addemployee() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("SAN_SARIF", Font.BOLD, 25));
        add(heading);

        JLabel labelname = new JLabel("NAME");
        labelname.setBounds(50,150,150,20);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);

        tfname = new JTextField();
        tfname.setBounds(200,150,150,20);
        add(tfname);

        JLabel labelfname = new JLabel("FATHER'S NAME");
        labelfname.setBounds(400,150,150,20);
        labelfname.setFont(new Font("serif", Font.BOLD, 14));
        add(labelfname);

        tffname = new JTextField();
        tffname.setBounds(600,150,150,20);
        add(tffname);


        JLabel labeldob = new JLabel("DOB");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(200,200,150,30);
        add(dcdob);

        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400,200,150,30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(600,200,150,30);
        add(tfsalary);

        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50,250,150,30); 
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);

        JLabel labelphone = new JLabel("Phone no");
        labelphone.setBounds(400,250,150,30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);

        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);

        JLabel labelmail = new JLabel("MAIL");
        labelmail.setBounds(50,300,150,30);
        labelmail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelmail);

        tfmail = new JTextField();
        tfmail.setBounds(200,300,150,30);
        add(tfmail);

        JLabel labeleducation = new JLabel("Highest Education");
        labeleducation.setBounds(400,300,150,30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);

        String courses[] = {"BBA", "BCA", "B.Sc", "B.Com", "BTech", "Mtech", "MBA", "MCA", "MA", "M.Sc", "P.hd"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBounds(600,300,150,30);
        add(cbeducation);

        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50,350,150,30); 
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);

        tfdesignation = new JTextField();
        tfdesignation.setBounds(200,350,150,30);
        add(tfdesignation);

        JLabel labelaadhar = new JLabel("Aadhar no.");
        labelaadhar.setBounds(400,350,150,30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(600,350,150,30);
        add(tfaadhar);

        JLabel labelempid = new JLabel("Employee ID");
        labelempid.setBounds(50,400,150,30);
        labelempid.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempid);

        lblempid = new JLabel(""+number);         //genrating employee id unique
        lblempid.setBounds(200,400,150,30);
        add(lblempid);


        //creating button
        add = new JButton("Add Details");
        add.setBounds(300, 450, 150, 40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        //creating button
        back = new JButton("Back");
        back.setBounds(470, 450, 150, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(900,600);
        setLocation(300, 50);
        setVisible(true);

    }

    public void actionPerformed (ActionEvent ae) {
         if (ae.getSource() == add) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfmail.getText();
            String education = (String) cbeducation.getSelectedItem();
            String designation = tfdesignation.getText();
            String aadhar = tfaadhar.getText();
            String empId = lblempid.getText();

            try {
                com conn = new com();
                String query = "insert into employee values ('"+name+"', '"+fname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+aadhar+"', '"+empId+"')";

                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added succesfully !!");
                setVisible(false);
                new Home();

            } catch (Exception e) {
                e.printStackTrace();
            }
         } else {
            setVisible(false);
            new Home();
         }
    }

    public static void main(String[] args) {
        new Addemployee();
    }

}

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import javax.swing.*;


public class Viewemployee extends JFrame implements ActionListener {

    JTable table;
    Choice cemployeeid;
    JButton search, print, update, back;


    Viewemployee() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        JLabel searchlbl = new JLabel("Search by Employee Id");
        searchlbl.setBounds(20, 20, 150, 18);
        add(searchlbl);

        cemployeeid = new Choice();
        cemployeeid.setBounds(200,20,150,20);
        add(cemployeeid);

        try {
            com c = new com();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while (rs.next()) {
                cemployeeid.add(rs.getString("empId"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }


        table = new JTable();

        try {
            com c = new com();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);

        //search button
        search = new JButton("Search");
        search.setBounds(20,70,100,20);
        search.addActionListener(this);
        add(search);

        //print button
        print = new JButton("Print");
        print.setBounds(150,70,80,20);
        print.addActionListener(this);
        add(print);


        //update button
        update = new JButton("Update");
        update.setBounds(280,70,100,20);
        update.addActionListener(this);
        add(update);

        //back button
        back = new JButton("Back");
        back.setBounds(400,70,80,20);
        back.addActionListener(this);
        add(back);

        setSize(900,700);
        setLocation(300,100);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from employee where empId = '"+cemployeeid.getSelectedItem()+"'";

            try {
                com c = new com();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
              

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }


        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateEmployee(cemployeeid.getSelectedItem());

        } else {
            setVisible(false);
            new Home();
        }

    }

    public static void main(String[] args) {
        new Viewemployee();
    }
}
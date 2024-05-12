import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
import java.awt.event.*;        //used to link the action peformed here to login page


public class Splash extends JFrame implements ActionListener{

 
    Splash() {

        getContentPane().setBackground(Color.GRAY);
        setLayout(null);

        //applying heading
        JLabel heading = new JLabel("EMPLOYEE  MANAGEMENT  SYSTEM");
        heading.setBounds(80, 30, 1200, 60);                            // setting alignments for heading
        heading.setFont(new Font("serif", Font.PLAIN, 50));
        heading.setForeground(Color.WHITE);
        add(heading);


        //image setting
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        add(image);

        
        //creating button
        JButton click = new JButton("Click here to continue....");
        click.setBounds(400, 400, 300, 70);
        click.setBackground(Color.BLACK);
        click.setForeground(Color.WHITE);
        click.addActionListener(this);
        add(click);

        //making main frame 
        setSize(1170, 650);
        setLocation(100,50);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent aEvent){

        setVisible(false);
        new login();
    }

    public static void main(String[] args) {
        new  Splash();
    }
}
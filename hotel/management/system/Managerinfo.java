package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Managerinfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    Managerinfo(){

        getContentPane().setBackground(Color.white);
        setLayout(null);


        JLabel i4 = new JLabel("Name");
        i4.setBounds(30,10,100,20);
        add(i4);

        JLabel i5 = new JLabel("Age");
        i5.setBounds(180,10,100,20);
        add(i5);

        JLabel i6 = new JLabel("Gender");
        i6.setBounds(280,10,100,20);
        add(i6);

        JLabel i7 = new JLabel("Job");
        i7.setBounds(420,10,100,20);
        add(i7);

        JLabel i8 = new JLabel("Salary");
        i8.setBounds(540,10,100,20);
        add(i8);

        JLabel i9 = new JLabel("Mobile Number");
        i9.setBounds(640,10,100,20);
        add(i9);

        JLabel i10 = new JLabel("Email");
        i10.setBounds(780,10,100,20);
        add(i10);

        JLabel i11 = new JLabel("Aadhar Number");
        i11.setBounds(880,10,100,20);
        add(i11);

        table = new JTable();
        table.setBounds(0,40,1000,400);
        add(table);

        try{
            Connection_ conn = new Connection_();
            ResultSet rs = conn.s.executeQuery("select * from addemployee where job='Manager'");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(420,500,120,30);
        add(back);

        setBounds(300,200,1000,600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }

    public static void main (String args[]){
        new Managerinfo();
    }
}

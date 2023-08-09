package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Depaertment extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    Depaertment(){

        getContentPane().setBackground(Color.white);
        setLayout(null);



        JLabel i4 = new JLabel("Department");
        i4.setBounds(180,10,100,20);
        add(i4);

        JLabel i5 = new JLabel("Budget");
        i5.setBounds(470,10,100,20);
        add(i5);


        table = new JTable();
        table.setBounds(0,50,700,350);
        add(table);

        try{
            Connection_ conn = new Connection_();
            ResultSet rs = conn.s.executeQuery("select * from Department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(280,400,120,30);
        add(back);

        setBounds(400,200,700,480);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }

    public static void main (String args[]){
        new Depaertment();
    }
}

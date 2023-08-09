package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Pickup extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    Choice typeofcar;

    Pickup(){

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("Pickup Service");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);

        JLabel lblbed = new JLabel("Type of Car");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);

        typeofcar = new Choice();
        typeofcar.setBounds(150,100,200,25);
        add(typeofcar);

        try{
            Connection_ con = new Connection_();
            ResultSet rs = con.s.executeQuery("select * from driver ");
            while(rs.next()){
                typeofcar.add(rs.getString("brand"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }



        JLabel i4 = new JLabel("Driver Name");
        i4.setBounds(30,160,100,20);
        add(i4);

        JLabel i5 = new JLabel("Age");
        i5.setBounds(200,160,100,20);
        add(i5);

        JLabel i6 = new JLabel("Gender");
        i6.setBounds(330,160,100,20);
        add(i6);

        JLabel i7 = new JLabel("Company");
        i7.setBounds(460,160,100,20);
        add(i7);

        JLabel i8 = new JLabel("Brand");
        i8.setBounds(630,160,100,20);
        add(i8);

        JLabel i9 = new JLabel("availability");
        i9.setBounds(740,160,100,20);
        add(i9);

        JLabel i10 = new JLabel("Brand");
        i10.setBounds(890,160,100,20);
        add(i10);

        table = new JTable();
        table.setBounds(0,200,1000,300);
        add(table);

        try{
            Connection_ conn = new Connection_();
            ResultSet rs = conn.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setBounds(300,520,120,30);
        add(submit);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(500,520,120,30);
        add(back);

        setBounds(300,200,1000,600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==submit){
            try{
                String query1 = "select * from driver where brand='"+typeofcar.getSelectedItem()+"'";

                Connection_ conn = new Connection_();
                ResultSet rs= conn.s.executeQuery(query1);

                table.setModel(DbUtils.resultSetToTableModel(rs));


            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
            new Reception();
        }
    }

    public static void main (String args[]){
        new Pickup();
    }
}

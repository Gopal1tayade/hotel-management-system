package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    JComboBox bedtype;
    JCheckBox available;
    SearchRoom(){

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("Search for Room");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);

        JLabel lblbed = new JLabel("Bed Type");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);

        bedtype = new JComboBox(new String[]{"Single Bed","Double Bed"});
        bedtype.setBounds(150,100,150,20);

        bedtype.setForeground(Color.black);
        add(bedtype);

        available = new JCheckBox("Only display Available");
        available.setBounds(650,100,150,25);
          available.setBackground(Color.white);
          add(available);

        JLabel i4 = new JLabel("Room Number");
        i4.setBounds(50,160,100,20);
        add(i4);

        JLabel i5 = new JLabel("Availability");
        i5.setBounds(270,160,100,20);
        add(i5);

        JLabel i6 = new JLabel("Status");
        i6.setBounds(450,160,100,20);
        add(i6);

        JLabel i7 = new JLabel("Price");
        i7.setBounds(670,160,100,20);
        add(i7);

        JLabel i8 = new JLabel("Bed Type");
        i8.setBounds(870,160,100,20);
        add(i8);

        table = new JTable();
        table.setBounds(0,200,1000,300);
        add(table);

        try{
            Connection_ conn = new Connection_();
            ResultSet rs = conn.s.executeQuery("select * from addroom");
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
                String query1 = "select * from addroom where bed_type='"+bedtype.getSelectedItem()+"'";
                String query2 = "select * from addroom where available='Available' and bed_type = '"+bedtype.getSelectedItem()+"'";

                Connection_ conn = new Connection_();
                 ResultSet rs;
                if ( available.isSelected()){

                    rs= conn.s.executeQuery(query2);

                }else{

                    rs= conn.s.executeQuery(query1);

                }
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
        new SearchRoom();
    }
}

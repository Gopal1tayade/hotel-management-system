package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.spec.ECField;
import java.sql.ResultSet;

public class UpdateRoom  extends JFrame implements ActionListener {
    Choice ccustomer;
    TextField tfroom,tfavailable,tfstatus;
    JButton check,update,back;
    UpdateRoom(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(30,20,250,30);
        text.setForeground(Color.blue);
        add(text);

        JLabel lblid = new JLabel("Customer ID");
        lblid.setBounds(20 , 80,100,20);
        add(lblid);

        ccustomer = new Choice();
        ccustomer.setBounds(200,80,150,25);
        add(ccustomer);


        try{
            Connection_ con = new Connection_();
            ResultSet rs = con.s.executeQuery("select * from customer");
            while (rs.next()){
                ccustomer.add(rs.getString("number"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30 , 130,100,20);
        add(lblroom);

        tfroom = new TextField();
        tfroom.setBounds(200,130,150,25);
        add(tfroom);

        JLabel lblname = new JLabel("Availability");
        lblname.setBounds(30 , 180,100,20);
        add(lblname);

        tfavailable = new TextField();
        tfavailable.setBounds(200,180,150,25);
        add(tfavailable);

        JLabel lblcheckin = new JLabel(" Cleaning Status");
        lblcheckin.setBounds(30 , 230,100,20);
        add(lblcheckin);

        tfstatus = new TextField();
        tfstatus.setBounds(200,230,150,25);
        add(tfstatus);


        check = new JButton("Check");
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.setBounds(30,300,100,30);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.setBounds(150,300,100,30);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(270,300,100,30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);


        setBounds(300,200,900,500);
        setVisible(true);
    }




    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == check){
            String id = ccustomer.getSelectedItem();
            String query = "select * from customer where number = '"+id+"'";
            try{
                Connection_ con = new Connection_();
                ResultSet rs = con.s.executeQuery(query);
                while(rs.next()){
                    tfroom.setText(rs.getString("room"));
                }
                ResultSet rs2 = con.s.executeQuery("select * from addroom where room_number='"+tfroom.getText()+"'");
                while(rs2.next()){
                    tfavailable.setText(rs2.getString("available"));
                    tfstatus.setText(rs2.getString("clean"));
                }



            }catch(Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource() == update){
           String number = ccustomer.getSelectedItem();
           String room = tfroom.getText();
           String available = tfavailable.getText();
           String status = tfstatus.getText();

           try{
               Connection_ con = new Connection_();
               con.s.executeUpdate("update addroom set available='"+available+"',clean='"+status+"'where room_number='"+room+"'");
               JOptionPane.showMessageDialog(null,"Updated Sucessfully");
               setVisible(false);
               new Reception();

           }catch(Exception e){
               e.printStackTrace();
           }


        }else if(ae.getSource() == back){
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String args[]){
        new UpdateRoom();
    }
}

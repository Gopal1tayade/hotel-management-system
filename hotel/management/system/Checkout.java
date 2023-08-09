package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener {
    JLabel lblroomnumber,lblcheckin,lblout;
    Choice ccustomer;
    JButton checkout, back,get;
   Checkout(){
       getContentPane().setBackground(Color.white);
      setLayout(null);
        JLabel text = new JLabel("Check Out");
        text.setBounds(100,20,100,30);
      text.setForeground(Color.blue);
      text.setFont(new Font("Tahoma",Font.PLAIN,20));
      add(text);

      JLabel lblid = new JLabel("Customer ID");
      lblid.setBounds(30,80,100,20);
      add(lblid);

       ccustomer = new Choice();
       ccustomer.setBounds(150,80,150,25);
       add(ccustomer);


       JLabel lblroom = new JLabel("Room Number");
       lblroom.setBounds(30,130,100,20);
       add(lblroom);

       lblroomnumber = new JLabel();
       lblroomnumber.setBounds(150,125,100,30);
       add(lblroomnumber);

       JLabel lblcheck = new JLabel("Checkin Time");
       lblcheck.setBounds(30,180,100,20);
       add(lblcheck);

       lblcheckin = new JLabel();
       lblcheckin.setBounds(150,175,100,30);
       add(lblcheckin);

       JLabel lblcheckout = new JLabel("Checkout Time");
       lblcheckout.setBounds(30,230,100,20);
       add(lblcheckout);

       Date date = new Date();

       lblout = new JLabel(""+date);
       lblout.setBounds(150,226,150,30);
       add(lblout);

       checkout = new JButton("Check Out");
       checkout.setBackground(Color.black);
       checkout.setForeground(Color.white);
       checkout.setBounds(10,300,100,30);
       checkout.addActionListener(this);
       add(checkout);

       get = new JButton("Get Info");
       get.setBackground(Color.black);
       get.setForeground(Color.white);
       get.setBounds(130,300,100,30);
       get.addActionListener(this);
       add(get);

       back = new JButton("back");
       back.setBackground(Color.black);
       back.setForeground(Color.white);
       back.setBounds(250,300,100,30);
       back.addActionListener(this);
       add(back);

       try{
           Connection_ con = new Connection_();
           ResultSet rs = con.s.executeQuery("select * from customer");
           while (rs.next()){
               ccustomer.add(rs.getString("number"));

           }
           ResultSet rs2 = con.s.executeQuery("select * from customer where number='"+ccustomer.getSelectedItem()+"'");
           while (rs2.next()){
//               ccustomer.add(rs.getString("number"));
               lblroomnumber.setText(rs2.getString("room"));
               lblcheckin.setText(rs2.getString("checkintime"));
           }
       }catch (Exception e){
           e.printStackTrace();
       }

       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
       Image i2 = i1.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(350,48,400,250);
       add(image);


       setBounds(300,200,800,400);
       setVisible(true);
   }

   public void actionPerformed(ActionEvent ae){
      String roomnumber = lblroomnumber.getText();

       if(ae.getSource()==checkout){
        String query1 = "delete from customer where number='"+ccustomer.getSelectedItem()+"'";
       String query2 = "update addroom set available = 'Available' where room_number ='"+roomnumber+"'";
       try{
      Connection_ con = new Connection_();
         con.s.executeUpdate(query1);
         con.s.executeUpdate(query2);

         JOptionPane.showMessageDialog(null,"CheckOut Done");
           setVisible(false);
           new Reception();

       }catch (Exception e){
           e.printStackTrace();
       }

       }else if(ae.getSource()== get){

           try{
               Connection_ con = new Connection_();
               ResultSet rs2 = con.s.executeQuery("select * from customer where number='"+ccustomer.getSelectedItem()+"'");
               while (rs2.next()){
                   lblroomnumber.setText(rs2.getString("room"));
                   lblcheckin.setText(rs2.getString("checkintime"));
               }
           }catch (Exception e){
               e.printStackTrace();
           }


       }else if(ae.getSource()==back){
           setVisible(false);
           new Reception();
       }
   }

    public static void main(String[] args) {
        new Checkout();
    }
}

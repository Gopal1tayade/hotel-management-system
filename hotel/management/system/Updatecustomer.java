package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.spec.ECField;
import java.sql.ResultSet;

public class Updatecustomer  extends JFrame implements ActionListener {
    Choice ccustomer;
    TextField tfroom,tfname,tfcheckin,tfpaid,tfpending;
    JButton check,update,back;
    Updatecustomer(){
       getContentPane().setBackground(Color.white);
       setLayout(null);

       JLabel text = new JLabel("Update Status");
       text.setFont(new Font("Tahoma",Font.PLAIN,20));
       text.setBounds(90,20,200,30);
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
        lblroom.setBounds(20 , 120,100,20);
        add(lblroom);

        tfroom = new TextField();
        tfroom.setBounds(200,120,150,25);
        add(tfroom);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(20 , 160,100,20);
        add(lblname);

        tfname = new TextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);

        JLabel lblcheckin = new JLabel("Checkin Time");
        lblcheckin.setBounds(20 , 200,100,20);
        add(lblcheckin);

        tfcheckin = new TextField();
        tfcheckin.setBounds(200,200,150,25);
        add(tfcheckin);

        JLabel lblpaid = new JLabel("Amount Paid");
        lblpaid.setBounds(20 , 240,100,20);
        add(lblpaid);

        tfpaid = new TextField();
        tfpaid.setBounds(200,240,150,25);
        add(tfpaid);

        JLabel lblpending = new JLabel("Pending Amount");
        lblpending.setBounds(20 , 280,100,20);
        add(lblpending);

        tfpending = new TextField();
        tfpending.setBounds(200,280,150,25);
        add(tfpending);

        check = new JButton("Check");
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.setBounds(30,340,100,30);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.setBounds(150,340,100,30);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(270,340,100,30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image = new JLabel(i1);
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
               tfcheckin.setText(rs.getString("checkintime"));
               tfname.setText(rs.getString("name"));
               tfpaid.setText(rs.getString("deposite"));
              }

              ResultSet rs2 = con.s.executeQuery("select * from addroom where room_number ='"+tfroom.getText()+"'");
              while(rs2.next()){
                  String price = rs2.getString("price");
                  int ammount = Integer.parseInt(price) - Integer.parseInt(tfpaid.getText());
                  tfpending.setText(""+ammount);
              }

          }catch(Exception e){
              e.printStackTrace();
          }

      }else if(ae.getSource() == update){
          String number = ccustomer.getSelectedItem();
          String name = tfname.getText();
          String checkin = tfcheckin.getText();
          String deposite = tfpaid.getText();
          String room = tfroom.getText();

          try{
              Connection_ con = new Connection_();
              con.s.executeUpdate("update customer set room ='"+room+"', name ='"+name+"', checkintime='"+checkin+"',deposite='"+deposite+"' where number='"+number+"'");
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
        new Updatecustomer();
    }
}
